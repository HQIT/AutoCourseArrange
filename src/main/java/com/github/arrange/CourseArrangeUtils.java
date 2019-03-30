package com.github.arrange;

import com.github.arrange.GA.GeneticAlgorithm;
import com.github.arrange.model.AutoCourseInfo;
import com.github.arrange.utils.CloneUtils;
import com.github.arrange.utils.FitnessFunctionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 排课
 */
public final class CourseArrangeUtils {

    /**
     * 自动安排课表
     * @param courseInfos
     * @param courseInfoMap
     * @param intervalMaxLesson
     * @param gradeStageSubjectPriorityArrangeHour
     * @param teacherOccupyHourAndCampus
     * @param classroomOccupyHour
     * @param classCanArrangeHours
     * @param teacherMutex
     * @param teacherMaxContinuousClassHour
     * @param teacherTrainsCampusNeedInterval 教师跨校区上课中间需要隔开的节数
     * @param subjectNextNotArrangeSubjects
     * @param populationSize 种群规模
     * @param generationSize 遗传代数
     * @return
     */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> autoArrange(
            Vector<AutoCourseInfo> courseInfos,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, Vector<String>> intervalMaxLesson,
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> gradeStageSubjectPriorityArrangeHour,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours,
            ConcurrentHashMap<String, Vector<String>> teacherMutex,
            ConcurrentHashMap<String, Integer> teacherMaxContinuousClassHour,
            int teacherTrainsCampusNeedInterval,
            ConcurrentHashMap<String, Vector<String>> subjectNextNotArrangeSubjects,
            int populationSize,
            int generationSize
    ) {
        //产生初始种群
        List<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> population =
                GeneticAlgorithm.generateInitialPopulationRandom(courseInfos, teacherOccupyHourAndCampus, classroomOccupyHour, classCanArrangeHours, populationSize);

        //遗传i代
        for (int i = 0; i < generationSize; i++ ) {
            Vector<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> offspringPopulation = new Vector(); //记录下一代种群

            ConcurrentHashMap<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>, Double> individualFitnessMap = new ConcurrentHashMap<>();

            //并发计算适应度
            population.parallelStream().forEach(individual -> {
                //计算适应度
                double fitness =
                        GeneticAlgorithm.getFitness(individual, courseInfoMap, gradeStageSubjectPriorityArrangeHour, intervalMaxLesson, teacherMutex, teacherMaxContinuousClassHour, teacherTrainsCampusNeedInterval, subjectNextNotArrangeSubjects);
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

            double best_f1 = FitnessFunctionUtils.f1(population.get(bestIndex), gradeStageSubjectPriorityArrangeHour, courseInfoMap); //最佳个体节次优度
            double best_f2 = FitnessFunctionUtils.f2(population.get(bestIndex)); //最佳个体均匀度
            int hard_conflict = GeneticAlgorithm.getHardConstraintsConflictTimes(population.get(bestIndex), courseInfoMap, teacherMutex);
            int soft_conflict = GeneticAlgorithm.getUserdefinedConstraintsConclictTimes(population.get(bestIndex), courseInfoMap, intervalMaxLesson, teacherMaxContinuousClassHour, teacherTrainsCampusNeedInterval, subjectNextNotArrangeSubjects);

            double averageFitness = totalFitness / population.size();

            //打印此代种群中的最佳个体信息
            System.out.println("第" + (i + 1) + "代最佳适应度：" + bestFitness + "，违反硬约束" + hard_conflict + "次，违反自定义约束" + soft_conflict + "次, 节次优度：" + best_f1 + "，均匀度:" + best_f2 + "。平均适应度:" + averageFitness);

            //if (bestFitness > 0.85) break;

            //预处理，选出交叉的双亲组合
            Vector<Vector<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>>> crossedParents = new Vector<>();
            int time = populationSize / 2; //次数,每次选择两个个体
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
            offspringPopulation.add(CloneUtils.clone(population.get(bestIndex)));

            //交叉、变异产生下一代
            crossedParents.parallelStream().forEach(couple -> {
                ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual_1 = couple.get(0);
                ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual_2 = couple.get(1);

                List<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> offsprings = new ArrayList<>(); //记录要放入下一代种群中的个体

                double crossed_probability = Const.crossed_probability;

                //以一定概率交叉产生新个体
                if(Math.random() <= crossed_probability) {
                    offsprings.addAll(
                            GeneticAlgorithm.crossover(individual_1, individual_2, courseInfoMap)
                    );
                } else {
                    offsprings.add(CloneUtils.clone(individual_1));
                    offsprings.add(CloneUtils.clone(individual_2));
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

        //获取最后一代种群中的最优解
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> bestIndividual = new ConcurrentHashMap<>();
        double bestFitness = 0.0;
        for (ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual : population) {

            //计算适应度
            double fitness = GeneticAlgorithm.getFitness(individual, courseInfoMap, gradeStageSubjectPriorityArrangeHour, intervalMaxLesson, teacherMutex, teacherMaxContinuousClassHour, teacherTrainsCampusNeedInterval, subjectNextNotArrangeSubjects);

            if (bestFitness < fitness) {
                bestFitness = fitness;
                bestIndividual = individual;
            }
        }

        return bestIndividual;
    }

}
