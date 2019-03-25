package com.github.arrange.GA;

import com.github.arrange.Const;
import com.github.arrange.handler.ConflictHandler;
import com.github.arrange.model.AutoCourseInfo;
import com.github.arrange.utils.ClassHourUtils;
import com.github.arrange.utils.CloneTools;
import com.github.arrange.utils.FitnessFunctionUtils;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class GeneticAlgorithm {
    /**
     * 生成初始种群中的个体
     * @param courseInfos
     * @param teacherOccupyHourAndCampus
     * @param classroomOccupyHour
     * @param classCanArrangeHours
     * @return
     */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> generateInitialIndividual (
            Vector<AutoCourseInfo> courseInfos,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours) {

        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual = new ConcurrentHashMap<>();

        Random random = new Random();

        courseInfos.stream().forEach(oneCourseInfo -> {
            List<String> hours = classCanArrangeHours.get(oneCourseInfo.getClassId());

            if (!individual.containsKey(oneCourseInfo.getClassId()))
                individual.put(oneCourseInfo.getClassId(), new ConcurrentHashMap<>());

            //获取该课程的安排
            Vector<String> currentCourseInfoArrange = new Vector<>();
            IntStream.range(0, oneCourseInfo.getPeriods()).forEach(index -> {

                //随机获取一个时间
                String hour = hours.get(random.nextInt(hours.size()));

                while(teacherOccupyHourAndCampus.get(oneCourseInfo.getTeacherId()).containsKey(hour) || classroomOccupyHour.get(oneCourseInfo.getClassroomId()).contains(hour)) {
                    hour = hours.get(random.nextInt(hours.size()));
                }

                currentCourseInfoArrange.add(hour);
            });

            individual.get(oneCourseInfo.getClassId()).put(oneCourseInfo.getCourseInfoID(), currentCourseInfoArrange);
        });

        return individual;

    }

    /**
     * 生成初始种群（完全随机）
     * @param courseInfos
     * @param teacherOccupyHourAndCampus
     * @param classroomOccupyHour
     * @param classCanArrangeHours
     * @return
     */
    public static Vector<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> generateInitialPopulationRandom (
            Vector<AutoCourseInfo> courseInfos,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours) {

        Vector<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> population = new Vector<>(); //用于记录初始种群

        for (int psize = 0; psize < Const.population_size; psize++) {
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual =
                    generateInitialIndividual(courseInfos, teacherOccupyHourAndCampus, classroomOccupyHour, classCanArrangeHours);

            population.add(individual);

        }

        return population;
    }

    /**
     * 选择操作
     * 轮盘赌算法选择出个体的下标
     * @param fitnesses 种群中个体的适应度
     * @return
     */
    public static int rouletteWheelSelection(List<Double> fitnesses) {
        //计算总的适应度值
        double totalFitnessScire = 0.0;
        for (Double fitness : fitnesses) {
            totalFitnessScire += fitness;
        }

        //每次选择一个个体，返回个体在List中的下标
        double slice = Math.random() * totalFitnessScire;

        double cfTotal = 0.0;   //概率统计

        int result = 0; //被选中的个体下标

        int size = fitnesses.size();
        for (int i = 0; i < size; i++) {
            cfTotal += fitnesses.get(i);

            if (cfTotal > slice) {
                result = i;
                break;
            }
        }

        return result;
    }

    /**
     * 交叉操作
     * @param parentIndividual_1 双亲个体1
     * @param parentIndividual_2 双亲个体2
     * @return 遗传到下一代的2个子个体
     */
    public static List<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> crossover(
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> parentIndividual_1,
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> parentIndividual_2) {

        List<ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>>> offsprings = new ArrayList<>();

        //复制这两个个体为子个体
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> offspringIndividual_1 =  CloneTools.clone(parentIndividual_1);
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> offspringIndividual_2 =  CloneTools.clone(parentIndividual_2);

        Random random = new Random();

        List<String> classIDs = new ArrayList<>(offspringIndividual_1.keySet());
        //随机选择一个班级
        String classID = classIDs.get(random.nextInt(classIDs.size()));
        String gradeName = classID.substring(0, 2);

        offspringIndividual_1.entrySet().stream().forEach(oneClassArrange -> {
            if (oneClassArrange.getKey().contains(gradeName)) {
                ConcurrentHashMap<String, Vector<String>> temp = offspringIndividual_1.get(oneClassArrange.getKey());
                offspringIndividual_1.put(oneClassArrange.getKey(), offspringIndividual_2.get(oneClassArrange.getKey()));
                offspringIndividual_2.put(oneClassArrange.getKey(), temp);
            }
        });

        offsprings.add(offspringIndividual_1);
        offsprings.add(offspringIndividual_2);

        return offsprings;
    }

    /**
     * 变异操作（含基因改造，人为消除冲突）
     * @param individual
     * @param classCanArrangeHours 班级可以安排课程的时段
     * @return
     */
    public static void mutation(
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours,
            int hardViolations) {

        Random random = new Random();

        List<String> classIDs = new ArrayList<>(individual.keySet());

        //随机选择一个班级ID
        String classID = classIDs.get(random.nextInt(classIDs.size()));

        //获取这个班级节次对应的课程
        Map<String, List<String>> hourCourseInfosMap = new HashMap<>();
        individual.get(classID).entrySet().stream().forEach(oneCourseInfoArrange -> {
            String courseInfoID = oneCourseInfoArrange.getKey();

            //遍历节次
            oneCourseInfoArrange.getValue().stream().forEach(oneHour -> {
                if (!hourCourseInfosMap.containsKey(oneHour))
                    hourCourseInfosMap.put(oneHour, new ArrayList<>());

                hourCourseInfosMap.get(oneHour).add(courseInfoID);
            });
        });

        //一个节次安排了多课程的情况
        Map<String, List<String>> conflictHourCourseInfosMap = new HashMap<>();
        hourCourseInfosMap.entrySet().stream().forEach(one -> {
            if (one.getValue().size() > 1)
                conflictHourCourseInfosMap.put(one.getKey(), one.getValue());
        });

        //该班级存在一个节次安排了多节课的情况
        if (conflictHourCourseInfosMap.size() > 0) {
            ConflictHandler.handleClassroomHourConflict(individual, courseInfoMap, classCanArrangeHours, classID, hourCourseInfosMap, conflictHourCourseInfosMap, teacherOccupyHourAndCampus, classroomOccupyHour);

            if (Math.random() < 0.5) {
                subMutation(individual, classID, courseInfoMap, teacherOccupyHourAndCampus, classroomOccupyHour, classCanArrangeHours);
            }
        } else {
            //一定几率执行消除教师课时冲突
            if (hardViolations > 0 && Math.random() < 0.1) {
                ConflictHandler.handleTeacherHourConflict(individual, courseInfoMap, teacherOccupyHourAndCampus, classroomOccupyHour, classCanArrangeHours);
            } else {
                subMutation(individual, classID, courseInfoMap, teacherOccupyHourAndCampus, classroomOccupyHour, classCanArrangeHours);
            }

        }

    }

    /**
     * 交叉操作（交换两个课程的节次）
     * @param individual
     * @param classID
     * @param courseInfoMap
     * @param teacherOccupyHourAndCampus
     * @param classroomOccupyHour
     * @param classCanArrangeHours
     */
    public static void subMutation(
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual,
            String classID,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours
    ) {
        Random random = new Random();

        //获取当前班级所有的courseInfo
        List<String> currentClassCourseInfoIDs = new ArrayList<>(individual.get(classID).keySet());

        //随机选择一个CourseInfo
        AutoCourseInfo courseInfo_1 = courseInfoMap.get(currentClassCourseInfoIDs.get(random.nextInt(currentClassCourseInfoIDs.size())));
        //获取该科目可以安排的时间段
        List<String> courseInfoCanArrangeHours_1 = ClassHourUtils.getCourseInfoCanArrangeHours(courseInfo_1, classCanArrangeHours, teacherOccupyHourAndCampus, classroomOccupyHour);
        //获取该科目已安排的时段
        List<String> courseInfoAlreadyArrangeHours_1 = new ArrayList<>(individual.get(classID).get(courseInfo_1.getCourseInfoID()));
        //随机选取一个时段
        String hour_1 = courseInfoAlreadyArrangeHours_1.get(random.nextInt(courseInfoAlreadyArrangeHours_1.size()));

        //随机选择另一个CourseInfo
        AutoCourseInfo courseInfo_2 = courseInfoMap.get(currentClassCourseInfoIDs.get(random.nextInt(currentClassCourseInfoIDs.size())));
        while (courseInfo_1.getCourseInfoID().equals(courseInfo_2.getCourseInfoID()))
            courseInfo_2 = courseInfoMap.get(currentClassCourseInfoIDs.get(random.nextInt(currentClassCourseInfoIDs.size())));
        //获取该科目可以安排的时间段
        List<String> courseInfoCanArrangeHours_2 = ClassHourUtils.getCourseInfoCanArrangeHours(courseInfo_2, classCanArrangeHours, teacherOccupyHourAndCampus, classroomOccupyHour);
        //获取科目2已安排的时段
        List<String> courseInfoAlreadyArrangeHours_2 = new ArrayList<>(individual.get(classID).get(courseInfo_2.getCourseInfoID()));
        courseInfoAlreadyArrangeHours_2.retainAll(courseInfoCanArrangeHours_1); //科目1可向科目2调换的时段

        while (!courseInfoCanArrangeHours_2.contains(hour_1) || courseInfoAlreadyArrangeHours_2.size() == 0) {
            courseInfo_2 = courseInfoMap.get(currentClassCourseInfoIDs.get(random.nextInt(currentClassCourseInfoIDs.size())));
            //获取该科目可以安排的时间段
            courseInfoCanArrangeHours_2 = ClassHourUtils.getCourseInfoCanArrangeHours(courseInfo_2, classCanArrangeHours, teacherOccupyHourAndCampus, classroomOccupyHour);

            //获取科目2已安排的时段
            courseInfoAlreadyArrangeHours_2 = new ArrayList<>(individual.get(classID).get(courseInfo_2.getCourseInfoID()));
            courseInfoAlreadyArrangeHours_2.retainAll(courseInfoCanArrangeHours_1); //科目1可向科目2调换的时段
        }

        String hour_2 = courseInfoAlreadyArrangeHours_2.get(random.nextInt(courseInfoAlreadyArrangeHours_2.size()));

        //交换
        individual.get(classID).get(courseInfo_1.getCourseInfoID()).remove(hour_1);
        individual.get(classID).get(courseInfo_1.getCourseInfoID()).add(hour_2);
        individual.get(classID).get(courseInfo_2.getCourseInfoID()).remove(hour_2);
        individual.get(classID).get(courseInfo_2.getCourseInfoID()).add(hour_1);
    }

    /**
     * 计算个体的适应度
     * @return
     */
    public static double getFitness(
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, Vector<String>> subjectPriorityArrangeHour,
            ConcurrentHashMap<String, Vector<String>> intervalMaxLesson,
            ConcurrentHashMap<String, Vector<String>> teacherMutex,
            ConcurrentHashMap<String, Integer> teacherMaxContinuousClassHour,
            int teacherTrainsCampusNeedInterval,
            ConcurrentHashMap<String, Vector<String>> subjectNextNotArrangeSubjects) {

        //获得该个体违反约束的次数
        int hard_violations = getHardConstraintsConflictTimes(individual, courseInfoMap, teacherMutex);
        int soft_violations = getUserdefinedConstraintsConclictTimes(individual, courseInfoMap, intervalMaxLesson, teacherMaxContinuousClassHour, teacherTrainsCampusNeedInterval, subjectNextNotArrangeSubjects);

        double f1 = FitnessFunctionUtils.f1(individual, subjectPriorityArrangeHour, courseInfoMap); //课表节次优度
        double f2 = FitnessFunctionUtils.f2(individual); //课表均匀度
        //double f3 = FitnessFunctionUtils.f3(individual);

        double a1 = 0.96, a2 = 0.98;
        double fitness = (0.5 * f1 + 0.5 * f2) * Math.pow(a1, hard_violations) * Math.pow(a2, soft_violations);

        return fitness;
    }

    /**
     * 获得个体违反硬约束的次数
     * @param individual
     * @param courseInfoMap
     * @return
     */
    public static int getHardConstraintsConflictTimes(
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, Vector<String>> teacherMutex) {

        int violations = 0;

        //记录教师、教室的占用
        Map<String, List<String>> teacherOccupyHour = new HashMap<>();
        Map<String, List<String>> classroomOccupyHour = new HashMap<>();

        Vector<ConcurrentHashMap<String, Vector<String>>> classArrangesList = new Vector<>(individual.values());

        for (ConcurrentHashMap<String, Vector<String>> classArrange : classArrangesList) {

            for (Map.Entry<String, Vector<String>> courseInfoArrange : classArrange.entrySet()) {

                AutoCourseInfo courseInfo = courseInfoMap.get(courseInfoArrange.getKey());
                String teacherID = courseInfo.getTeacherId();
                String classroomID = courseInfo.getClassroomId();

                if (!teacherOccupyHour.containsKey(teacherID)) {
                    teacherOccupyHour.put(teacherID, new ArrayList<>());
                }

                if (!classroomOccupyHour.containsKey(classroomID)) {
                    classroomOccupyHour.put(classroomID, new ArrayList<>());
                }

                //循环各个时段，判断是否有冲突
                for (String hour : courseInfoArrange.getValue()) {
                    //判断教师冲突
                    if (teacherOccupyHour.get(teacherID).contains(hour)) {
                        violations++;
                    } else {
                        teacherOccupyHour.get(teacherID).add(hour);
                    }

                    //判断教室冲突
                    if (classroomOccupyHour.get(classroomID).contains(hour)) {
                        violations++;
                    } else {
                        classroomOccupyHour.get(classroomID).add(hour);
                    }
                }
            }
        }

        //判断是否违反教师互斥
        for (Map.Entry<String, Vector<String>> teacherMutextEntry : teacherMutex.entrySet()) {
            String currentTeacher = teacherMutextEntry.getKey();
            List<String> currentTeacherHours = new ArrayList<>(teacherOccupyHour.get(currentTeacher));

            for (String currentTeacherHour : currentTeacherHours) {
                for (String mutexTeacher : teacherMutextEntry.getValue()) {
                    if (teacherOccupyHour.get(mutexTeacher).contains(currentTeacherHour)) //违反教师互斥
                        violations++;
                }
            }
        }

        return violations;
    }

    /**
     * 获得个体违反用户自定义约束的次数
     * @param classArranges
     * @param courseInfoMap
     * @param intervalMaxLesson
     * @param teacherMaxContinuousClassHour
     * @param teacherTrainsCampusNeedInterval
     * @param subjectNextNotArrangeSubjects
     * @return
     */
    public static int getUserdefinedConstraintsConclictTimes(
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> classArranges,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, Vector<String>> intervalMaxLesson,
            ConcurrentHashMap<String, Integer> teacherMaxContinuousClassHour,
            int teacherTrainsCampusNeedInterval,
            ConcurrentHashMap<String, Vector<String>> subjectNextNotArrangeSubjects) {

        int violations = 0;

        //记录教师、教室的占用
        Map<String, List<String>> teacherOccupyHour = new HashMap<>();
        Map<String, Map<String, String>> teacherOccupyHourAndCampus = new HashMap<>();
        Map<String, List<String>> classroomOccupyHour = new HashMap<>();

        Vector<ConcurrentHashMap<String, Vector<String>>> classArrangesList = new Vector<>(classArranges.values());

        for (ConcurrentHashMap<String, Vector<String>> classArrange : classArrangesList) {

            for (Map.Entry<String, Vector<String>> courseInfoArrange : classArrange.entrySet()) {

                AutoCourseInfo courseInfo = courseInfoMap.get(courseInfoArrange.getKey());
                String teacherID = courseInfo.getTeacherId();
                String classroomID = courseInfo.getClassroomId();
                String campus = courseInfo.getCampus();

                if (!teacherOccupyHour.containsKey(teacherID)) {
                    teacherOccupyHour.put(teacherID, new ArrayList<>());
                    teacherOccupyHourAndCampus.put(teacherID, new HashMap<>());
                }

                if (!classroomOccupyHour.containsKey(classroomID)) {
                    classroomOccupyHour.put(classroomID, new ArrayList<>());
                }

                courseInfoArrange.getValue().stream().forEach(oneHour -> {
                    teacherOccupyHour.get(teacherID).add(oneHour);
                    teacherOccupyHourAndCampus.get(teacherID).put(oneHour, campus);
                    classroomOccupyHour.get(classroomID).add(oneHour);
                });
            }
        }

        //判断是否违反教师连上设定
        for (Map.Entry<String, List<String>> oneTeacherOccupyHour : teacherOccupyHour.entrySet()) {
            int maxContinuousClassHour = teacherMaxContinuousClassHour.get(oneTeacherOccupyHour.getKey());

            //{"0-1",[0,1,2]}
            Map<String, List<Integer>> intervalSections = new HashMap<>();
            oneTeacherOccupyHour.getValue().stream().forEach(hour -> {
                String[] hourSplit = hour.split("-");

                String interval = String.format("%s-%s", hourSplit[0], hourSplit[1]);
                int section = Integer.valueOf(hourSplit[2]);

                if (!intervalSections.containsKey(interval)) {
                    intervalSections.put(interval, new ArrayList<>());
                }
                intervalSections.get(interval).add(section);
            });

            //开始判断这个教师是否违反连上设定
            for (List<Integer> sections : intervalSections.values()) {
                Collections.sort(sections); //从小到大排序

                //获取最大连续的长度
                int currentContinueLong = 1;
                int maxContinueLong = currentContinueLong;
                for (int i = 1; i < sections.size(); i++) {
                    int section = sections.get(i);
                    if (sections.get(i - 1) == section - 1) {
                        currentContinueLong++;
                        if (maxContinueLong < currentContinueLong)
                            maxContinueLong = currentContinueLong;
                    } else {
                        currentContinueLong = 1;
                    }
                }

                if (maxContinueLong > maxContinuousClassHour) //违反教师最大连上
                    violations++;
            }
        }

        //判断是否违反跨校区任课的约束条件
        for (Map.Entry<String, Map<String, String>> oneTeacher : teacherOccupyHourAndCampus.entrySet()) {
            Map<String, String> hourAndCampus = oneTeacher.getValue();

            for (String hour : hourAndCampus.keySet()) {
                String campus = hourAndCampus.get(hour);
                String[] hourSplit = hour.split("-");
                int section = Integer.valueOf(hourSplit[2]);

                //向前查
                section--;
                while(section >= 0 && Integer.valueOf(hourSplit[2]) - section <= teacherTrainsCampusNeedInterval) {
                    String preHour = String.format("%s-%s-%s", hourSplit[0], hourSplit[1], section);
                    if (hourAndCampus.containsKey(preHour) && !hourAndCampus.get(preHour).equals(campus))
                        violations++;

                    section--;
                }

                //向后查
                int currentIntervalMaxLesson = intervalMaxLesson.get(hourSplit[1]).size(); //该时段最多几节课
                section = Integer.valueOf(hourSplit[2]);
                section++;
                while(section < currentIntervalMaxLesson && section - Integer.valueOf(hourSplit[2]) <= teacherTrainsCampusNeedInterval) {
                    String preHour = String.format("%s-%s-%s", hourSplit[0], hourSplit[1], section);
                    if (hourAndCampus.containsKey(preHour) && !hourAndCampus.get(preHour).equals(campus))
                        violations++;

                    section++;
                }
            }
        }

        //TODO:课程设定是否违反

        return violations;
    }
}
