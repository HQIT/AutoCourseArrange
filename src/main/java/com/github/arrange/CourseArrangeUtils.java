package com.github.arrange;

import com.github.arrange.GA.GeneticAlgorithm;
import com.github.arrange.model.AutoCourseInfo;
import com.github.arrange.temporary.*;
import com.github.arrange.utils.CloneTools;
import com.github.arrange.utils.ExportUtils;
import com.github.arrange.utils.FitnessFunctionUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 排课
 */
public final class CourseArrangeUtils {

    public static void test() {
        /**
         * 预处理
         */
        //获取所有的CourseInfo（正常课时类型的行政班课程的CourseInfo）
        Vector<AutoCourseInfo> courseInfos = CourseInfoTools.generateCourseInfoList();
        ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap = new ConcurrentHashMap<>();
        courseInfos.stream().forEach(oneCourseInfo -> {
            courseInfoMap.put(oneCourseInfo.getCourseInfoID(), oneCourseInfo);
        });

        WholeOccupy wholeOccupy = new WholeOccupy();
        wholeOccupy.setOccupancies(courseInfoMap); //注意，浅拷贝

        //获取所有的教师ID
        List<String> teacherIDs = new ArrayList<>(courseInfos.stream().map(oneCourseInfo -> oneCourseInfo.getTeacherId()).collect(Collectors.toSet()));

        //获取每周可上课的时间段（课时设置中设置的）
        Vector<String> classHours = ClassHourTools.generateClassHours();

        //取每个时间区间（上午、下午等）可安排的最多的节次段
        ConcurrentHashMap<String, Vector<String>> intervalMaxLesson = ClassHourTools.getIntervalMaxLesson(classHours);

        //获取学科优先安排的时段（由节次优先规则得出）， {学科, [优先时段]}
        ConcurrentHashMap<String, Vector<String>> subjectPriorityArrangeHour = PriorityTools.setSubjectPriorityArrangeHour();

        //获取教师已被占用的时段（由已被安排的组合课、长课时以及课时活动安排规则得出），{teacherID, {hour, 校区}}
        ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus = ClassHourTools.setTeacherOccupyHourAndCampus(courseInfos);

        //获取教室已被占用的时段
        ConcurrentHashMap<String, Vector<String>> classroomOccupyHour = ClassHourTools.setClassroomOccupyHour(courseInfos);

        //获取班级已安排课程的时段（已安排的组合课、长课时的占用）
        ConcurrentHashMap<String, Vector<String>> classOccupyHour = ClassHourTools.setClassOccupyHour(courseInfos);

        //处理classOccupyHour，将其长课时占用转换成正常课时占用
        ClassHourTools.handleClassOccupyHour(classOccupyHour);

        //获取班级可安排课程的时段（即去除走班课程、长课时占用后的时段）
        ConcurrentHashMap<String, Vector<String>> classCanArrangeHours = ClassHourTools.getCanArrange(classHours, classOccupyHour);

        //获取合班信息，{科目，[[班级id]]}
        ConcurrentHashMap<String, Vector<Vector<String>>> togetherClass = RuleTools.getTogetherClass();

        //获取教师互斥信息，{教师id, [互斥的教师id]}
        ConcurrentHashMap<String, Vector<String>> teacherMutex = RuleTools.getTeacherMutex();

        //获取连上设定(教师) （跨校区任课需要隔开的课时数由Const设定）
        ConcurrentHashMap<String, Integer> teacherMaxContinuousClassHour = RuleTools.getTeacherMaxContinuousClassHour(teacherIDs);

        //获取教师跨校区上课中间需要隔开的节数
        int teacherTrainsCampusNeedInterval = 2;

        //获取课程设定（部分课程后不上部分课），{subject, [subject]}
        ConcurrentHashMap<String, Vector<String>> subjectNextNotArrangeSubjects = RuleTools.getSubjectNextNotArrangeSubjects();

        //首先安排合班的课程，安排完合班课程后再安排其他课程
        //合班课程的课时务必是相同的
        if (!togetherClass.isEmpty()) {
            Temporary.handleTogetherClassArrange(
                    courseInfos, wholeOccupy, teacherOccupyHourAndCampus, classroomOccupyHour, classOccupyHour, classCanArrangeHours, togetherClass, subjectPriorityArrangeHour, intervalMaxLesson
            );
        }

        //自动排课
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> bestIndividual = CourseArrangeUtils.autoArrange(
                courseInfos,
                courseInfoMap,
                intervalMaxLesson,
                subjectPriorityArrangeHour,
                teacherOccupyHourAndCampus,
                classroomOccupyHour,
                classCanArrangeHours,
                teacherMutex,
                teacherMaxContinuousClassHour,
                teacherTrainsCampusNeedInterval,
                subjectNextNotArrangeSubjects
        );

        if (!wholeOccupy.getHours().isEmpty()) {
            for (Map.Entry<String, Vector<String>> oneCourseInfoArrange : wholeOccupy.getHours().entrySet()) {
                AutoCourseInfo courseInfo = courseInfoMap.get(oneCourseInfoArrange.getKey());

                bestIndividual.get(courseInfo.getClassId()).put(courseInfo.getCourseInfoID(), oneCourseInfoArrange.getValue());
            }
        }

        ExportUtils.exportIndividual(bestIndividual, courseInfoMap, "schedule"); //打印测试
    }

    /**
     * 自动安排课表
     * @param courseInfos
     * @param courseInfoMap
     * @param intervalMaxLesson
     * @param subjectPriorityArrangeHour
     * @param teacherOccupyHourAndCampus
     * @param classroomOccupyHour
     * @param classCanArrangeHours
     * @param teacherMutex
     * @param teacherMaxContinuousClassHour
     * @param teacherTrainsCampusNeedInterval 教师跨校区上课中间需要隔开的节数
     * @param subjectNextNotArrangeSubjects
     * @return
     */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> autoArrange(
            Vector<AutoCourseInfo> courseInfos,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, Vector<String>> intervalMaxLesson,
            ConcurrentHashMap<String, Vector<String>> subjectPriorityArrangeHour,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours,
            ConcurrentHashMap<String, Vector<String>> teacherMutex,
            ConcurrentHashMap<String, Integer> teacherMaxContinuousClassHour,
            int teacherTrainsCampusNeedInterval,
            ConcurrentHashMap<String, Vector<String>> subjectNextNotArrangeSubjects
    ) {
        //产生初始种群
        List<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> population =
                GeneticAlgorithm.generateInitialPopulationRandom(courseInfos, teacherOccupyHourAndCampus, classroomOccupyHour, classCanArrangeHours);

        //打印适应度
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("适应度");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("代");
        row.createCell(1).setCellValue("最佳适应度");
        row.createCell(2).setCellValue("违反硬约束次数");
        row.createCell(3).setCellValue("违反自定义约束次数");
        row.createCell(4).setCellValue("节次优度");
        row.createCell(5).setCellValue("均匀度");
        row.createCell(6).setCellValue("平均适应度");

        //遗传i代
        for (int i = 0; i < Const.generation_size; i++ ) {
            Vector<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> offspringPopulation = new Vector(); //记录下一代种群

            ConcurrentHashMap<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>, Double> individualFitnessMap = new ConcurrentHashMap<>();

            //并发计算适应度
            population.parallelStream().forEach(individual -> {
                //计算适应度
                double fitness =
                        GeneticAlgorithm.getFitness(individual, courseInfoMap, subjectPriorityArrangeHour, intervalMaxLesson, teacherMutex, teacherMaxContinuousClassHour, teacherTrainsCampusNeedInterval, subjectNextNotArrangeSubjects);
                individualFitnessMap.put(individual, fitness);
            });

            List<Double> fitnesses = new ArrayList<>();
            double bestFitness = 0.0;   //用于获取此代最佳适应度
            int bestIndex = 0;
            double totalFitness = 0.0;
            for (int j = 0; j < population.size(); j++ ) {
                double fitness = individualFitnessMap.get(population.get(j));
                fitnesses.add(fitness);

                if (bestFitness < fitness) {
                    bestFitness = fitness;
                    bestIndex = j;
                }

                totalFitness += fitness;
            }

            double best_f1 = FitnessFunctionUtils.f1(population.get(bestIndex), subjectPriorityArrangeHour, courseInfoMap); //最佳个体节次优度
            double best_f2 = FitnessFunctionUtils.f2(population.get(bestIndex)); //最佳个体均匀度
            int hard_conflict = GeneticAlgorithm.getHardConstraintsConflictTimes(population.get(bestIndex), courseInfoMap, teacherMutex);
            int soft_conflict = GeneticAlgorithm.getUserdefinedConstraintsConclictTimes(population.get(bestIndex), courseInfoMap, intervalMaxLesson, teacherMaxContinuousClassHour, teacherTrainsCampusNeedInterval, subjectNextNotArrangeSubjects);

            double averageFitness = totalFitness / population.size();

            //打印此代种群中的最佳个体信息
            System.out.println("第" + (i + 1) + "代最佳适应度：" + bestFitness + "，违反硬约束" + hard_conflict + "次，违反自定义约束" + soft_conflict + "次, 节次优度：" + best_f1 + "，均匀度:" + best_f2 + "。平均适应度:" + averageFitness);

            //Excel
            sheet.createRow(i + 1).createCell(0).setCellValue(i + 1);
            sheet.getRow(i + 1).createCell(1).setCellValue(bestFitness);
            sheet.getRow(i + 1).createCell(2).setCellValue(hard_conflict);
            sheet.getRow(i + 1).createCell(3).setCellValue(soft_conflict);
            sheet.getRow(i + 1).createCell(4).setCellValue(best_f1);
            sheet.getRow(i + 1).createCell(5).setCellValue(best_f2);
            sheet.getRow(i + 1).createCell(6).setCellValue(averageFitness);

            //if (bestFitness > 0.85) break;

            //预处理，选出交叉的双亲组合
            Vector<Vector<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>>> crossedParents = new Vector<>();
            int time = population.size() / 2; //次数,每次选择两个个体
            for (int j = 0; j < time; j++) {
                Vector<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> couple = new Vector<>();

                //根据轮盘赌算法获取两个个体
                int index_1 = GeneticAlgorithm.rouletteWheelSelection(fitnesses); //个体1的下标
                int index_2 = GeneticAlgorithm.rouletteWheelSelection(fitnesses); //个体2的下标
                while(index_1 == index_2) {
                    index_2 = GeneticAlgorithm.rouletteWheelSelection(fitnesses);
                }

                couple.add(population.get(index_1));
                couple.add(population.get(index_2));

                crossedParents.add(couple);
            }

            //精英主义（将此代最优的个体直接放入下一代）
            offspringPopulation.add(CloneTools.clone(population.get(bestIndex)));

            //交叉、变异产生下一代
            crossedParents.parallelStream().forEach(couple -> {
                ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual_1 = couple.get(0);
                ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual_2 = couple.get(1);

                List<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> offsprings = new ArrayList<>(); //记录要放入下一代种群中的个体

                double crossed_probability = Const.crossed_probability;

                //以一定概率交叉产生新个体
                if(Math.random() <= crossed_probability) {
                    offsprings.addAll(
                            GeneticAlgorithm.crossover(individual_1, individual_2)
                    );
                } else {
                    offsprings.add(CloneTools.clone(individual_1));
                    offsprings.add(CloneTools.clone(individual_2));
                }

                //变异
                for (ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> offspring : offsprings) {
                    double mutation_probability = Const.mutation_probability;

                    //以一定概率发生变异
                    if (Math.random() <= mutation_probability)

                        GeneticAlgorithm.mutation(offspring,
                                courseInfoMap,
                                teacherOccupyHourAndCampus,
                                classroomOccupyHour,
                                classCanArrangeHours,
                                GeneticAlgorithm.getHardConstraintsConflictTimes(offspring, courseInfoMap, teacherMutex));
                }

                offspringPopulation.addAll(offsprings);

            });

            population = offspringPopulation;

        }

        //Excel适应度
        try {
            String fileName = "D:/fitness.xls";
            FileOutputStream fout = new FileOutputStream(fileName);
            wb.write(fout);
            fout.close();
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取最后一代种群中的最优解
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> bestIndividual = new ConcurrentHashMap<>();
        double bestFitness = 0.0;
        for (ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual : population) {

            //计算适应度
            double fitness = GeneticAlgorithm.getFitness(individual, courseInfoMap, subjectPriorityArrangeHour, intervalMaxLesson, teacherMutex, teacherMaxContinuousClassHour, teacherTrainsCampusNeedInterval, subjectNextNotArrangeSubjects);

            if (bestFitness < fitness) {
                bestFitness = fitness;
                bestIndividual = individual;
            }
        }

        return bestIndividual;
    }

}
