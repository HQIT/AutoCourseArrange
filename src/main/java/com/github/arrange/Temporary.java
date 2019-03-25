package com.github.arrange;

import com.github.arrange.model.AutoCourseInfo;
import com.github.arrange.temporary.WholeOccupy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Temporary {
    /**
     * 安排合班课程（生成初始种群的个体时，优先安排合班课程）
     * @param courseInfos
     * @param wholeOccupy
     * @param teacherOccupyHourAndCampus
     * @param classroomOccupyHour
     * @param classOccupyHour
     * @param classCanArrangeHours
     * @param togetherClass
     * @param subjectPriorityArrangeHour
     * @param intervalMaxLesson
     */
    public static void handleTogetherClassArrange(
            Vector<AutoCourseInfo> courseInfos,
            WholeOccupy wholeOccupy,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours,
            ConcurrentHashMap<String, Vector<Vector<String>>> togetherClass,
            ConcurrentHashMap<String, Vector<String>> subjectPriorityArrangeHour,
            ConcurrentHashMap<String, Vector<String>> intervalMaxLesson) {

        togetherClass.entrySet().stream().forEach(oneSubject -> {
            //遍历该科目的所有组合班
            oneSubject.getValue().stream().forEach(oneGroupTogetherClass -> {
                //获取相关的CourseInfo
                List<AutoCourseInfo> togetherClassCourseInfo = courseInfos.stream()
                        .filter(oneCourseInfo -> oneCourseInfo.getSubjectId().equals(oneSubject.getKey()) && oneGroupTogetherClass.contains(oneCourseInfo.getClassId()))
                        .collect(Collectors.toList());

                //若这些CourseInfo的课时不相同，则报错
                Set<Integer> courseInfoPeriods = togetherClassCourseInfo.stream().map(oneCourseInfo -> oneCourseInfo.getPeriods()).collect(Collectors.toSet());
                if (courseInfoPeriods.size() > 1) {
                    //抛出异常
                    System.out.println("合班课程的课时务必相同！");
                }

                //取课时
                int periods = togetherClassCourseInfo.get(0).getPeriods();

                //取当前学科优先排课的时段
                List<String> currentSubjectPriority = new ArrayList<>(subjectPriorityArrangeHour.get(oneSubject.getKey()));

                List<String> arrangeDays = new ArrayList<>(); //用于记录该合班课已安排的天

                //获取所有的时段
                List<String> allIntervalHour = new ArrayList<>();
                intervalMaxLesson.values().stream().forEach(oneInterval -> {
                    allIntervalHour.addAll(oneInterval);
                });
                //移除已安排优先的时段
                allIntervalHour.removeAll(currentSubjectPriority);

                currentSubjectPriority.addAll(allIntervalHour);

                //根据优先级进行安排
                for (String onePriority : currentSubjectPriority) {
                    if (periods == 0) break;

                    //根据onePriority,取出这些合班班级都可以安排的时间段
                    Vector<String> allClassCanArrangeHours =
                            getAllClassCanArrangeHours(
                                    onePriority,
                                    oneGroupTogetherClass,
                                    togetherClassCourseInfo,
                                    teacherOccupyHourAndCampus,
                                    classroomOccupyHour,
                                    classOccupyHour,
                                    classCanArrangeHours
                            );

                    if (allClassCanArrangeHours.size() > 0) {
                        for (String oneHour : allClassCanArrangeHours) {
                            if (periods == 0) break;

                            //合班课为杂科合班，不要安排在同一天
                            if (arrangeDays.contains(oneHour.substring(0, 1))) continue;

                            //进行安排
                            for (AutoCourseInfo oneCourseInfo : togetherClassCourseInfo) {
                                String teacherID = oneCourseInfo.getTeacherId();
                                String classroomID = oneCourseInfo.getClassroomId();
                                String classID = oneCourseInfo.getClassId();

                                if (!teacherOccupyHourAndCampus.get(teacherID).containsKey(oneHour)) {
                                    teacherOccupyHourAndCampus.get(teacherID).put(oneHour, oneCourseInfo.getCampus());
                                }

                                if (!classroomOccupyHour.get(classroomID).contains(oneHour)) {
                                    classroomOccupyHour.get(classroomID).add(oneHour);
                                }

                                if (!classOccupyHour.get(classID).contains(oneHour)) {
                                    classOccupyHour.get(classID).add(oneHour);
                                }

                                //合班课安排完成后不可变动，从班级可安排的课程时段中删除该时段
                                classCanArrangeHours.get(classID).remove(oneHour);

                                //记录安排
                                if (!wholeOccupy.getHours().containsKey(oneCourseInfo.getCourseInfoID())) {
                                    wholeOccupy.getHours().put(oneCourseInfo.getCourseInfoID(), new Vector<>());
                                }
                                wholeOccupy.getHours().get(oneCourseInfo.getCourseInfoID()).add(oneHour);
                            }
                            arrangeDays.add(oneHour.substring(0, 1));
                            periods--;
                        }
                    }
                }

                //如果课时未安排完，则报错
                if (periods > 0) {
                    System.out.println("合班课无法完全安排！");
                }

                //合班课安排完成后不在变动，不参与自动排课
                courseInfos.removeAll(togetherClassCourseInfo);

            });
        });
    }


    /**
     * 根据优先时段获取所有合班班级都空闲的时段
     * @param priorityHour 给定的优先时段，格式为：1-0
     * @param togetherClasses 给定的合班班级
     * @param togetherClassCourseInfo 合班的CourseInfo
     * @param teacherOccupyHourAndCampus 教师被占用的时段
     * @param classroomOccupyHour 教室被占用的时段
     * @param classOccupyHour 班级被占用的时段
     * @param classCanArrangeHours 班级可以安排的时段（去除走班和长课时后剩余的时段）
     * @return
     */
    public static Vector<String> getAllClassCanArrangeHours (
            String priorityHour,
            Vector<String> togetherClasses,
            List<AutoCourseInfo> togetherClassCourseInfo,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours) {
        Vector<String> allClassCanArrangeHours = new Vector<>();

        //记录符合的时段
        Vector<String> eligibleHours = new Vector<>();

        Vector<String> togetherClassesTemp = new Vector<>(togetherClasses); //拷贝合班班级
        //先考虑第一个班级符合条件的时段
        eligibleHours.addAll(
                classCanArrangeHours.get(togetherClassesTemp.get(0)).stream()
                        .filter(oneHour -> oneHour.substring(2, 5).equals(priorityHour))
                        .collect(Collectors.toList())
        );
        togetherClassesTemp.remove(0); //移除第一个班级

        //遍历其他班级，将其他班级不满足的时段从eligibleHours中剔除
        togetherClassesTemp.stream().forEach(oneClass -> {
            List<String> currentClassEligibleHours = classCanArrangeHours.get(oneClass).stream()
                    .filter(oneHour -> oneHour.substring(2, 5).equals(priorityHour))
                    .collect(Collectors.toList());

            eligibleHours.retainAll(currentClassEligibleHours);
        });

        //从符合条件的时段中移除老师、教师和班级已被占用的时段
        if (eligibleHours.size() > 0) {
            for (String oneEligibleHour : eligibleHours) {
                boolean isOK = true;

                for (AutoCourseInfo oneCourseInfo : togetherClassCourseInfo) {
                    if (teacherOccupyHourAndCampus.get(oneCourseInfo.getTeacherId()).containsKey(oneEligibleHour)
                            || classroomOccupyHour.get(oneCourseInfo.getClassroomId()).contains(oneEligibleHour)
                            || classOccupyHour.get(oneCourseInfo.getClassId()).contains(oneEligibleHour)) {
                        isOK = false;
                        break;
                    }
                }

                if (isOK) allClassCanArrangeHours.add(oneEligibleHour);
            }
        }

        return allClassCanArrangeHours;
    }
}
