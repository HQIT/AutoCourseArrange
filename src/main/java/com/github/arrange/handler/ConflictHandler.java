package com.github.arrange.handler;

import com.github.arrange.model.AutoCourseInfo;
import com.github.arrange.utils.ClassHourUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class ConflictHandler {

    /**
     * 消除当前班级的教室课时冲突
     * @param individual
     * @param courseInfoMap
     * @param classCanArrangeHours
     * @param classID
     * @param hourCourseInfosMap
     * @param conflictHourCourseInfosMap
     */
    public static void handleClassroomHourConflict(
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours,
            String classID,
            Map<String, List<String>> hourCourseInfosMap,
            Map<String, List<String>> conflictHourCourseInfosMap,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour
    ) {
        Random random = new Random();

        //获取该班级可以安排的节次
        List<String> currentClassCanArrangeHours = new ArrayList<>(classCanArrangeHours.get(classID));

        //获取该班级已经安排的节次
        List<String> currentClassExistArrangeHours = new ArrayList<>(hourCourseInfosMap.keySet());

        //取得当前班级空闲节次
        currentClassCanArrangeHours.removeAll(currentClassExistArrangeHours);

        conflictHourCourseInfosMap.entrySet().stream().forEach(one -> {
            IntStream.range(1, one.getValue().size()).forEach(index -> {
                AutoCourseInfo courseInfo = courseInfoMap.get(one.getValue().get(index));

                //获取该课程可以安排的时间段
                List<String> hours = ClassHourUtils.getCourseInfoCanArrangeHours(courseInfo, classCanArrangeHours, teacherOccupyHourAndCampus, classroomOccupyHour);

                hours.retainAll(currentClassCanArrangeHours); //取交集，去除了不可安排的时段

                if (hours.size() > 0) {

                    //随机选择一个时间段
                    String hour = hours.get(random.nextInt(hours.size()));
                    individual.get(classID).get(courseInfo.getCourseInfoID()).remove(one.getKey());
                    individual.get(classID).get(courseInfo.getCourseInfoID()).add(hour);

                    //移除空闲时段
                    currentClassCanArrangeHours.remove(hour);
                }
            });
        });
    }

    /**
     * 解决课表中教师科室的冲突（仅解决一个教师的冲突）
     * @param individual
     * @param courseInfoMap
     * @param teacherOccupyHourAndCampus
     * @param classCanArrangeHours
     */
    public static void handleTeacherHourConflict (
            ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual,
            ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours) {

        //记录第一次出现的冲突信息
        String conflictTeacherID = null;
        String conflictHour = null;
        List<String> conflictCourseInfoIDs = new ArrayList<>();

        //{teacherID, {hour, [courseInfoID]}}
        Map<String, Map<String, List<String>>> teacherHourCourseInfoMap = new HashMap<>();
        individual.values().stream().forEach(oneClassArranges -> {
            oneClassArranges.entrySet().stream().forEach(oneCourseInfoArranges -> {
                AutoCourseInfo courseInfo = courseInfoMap.get(oneCourseInfoArranges.getKey());

                if (!teacherHourCourseInfoMap.containsKey(courseInfo.getTeacherId()))
                    teacherHourCourseInfoMap.put(courseInfo.getTeacherId(), new HashMap<>());

                oneCourseInfoArranges.getValue().stream().forEach(oneHour -> {
                    if (!teacherHourCourseInfoMap.get(courseInfo.getTeacherId()).containsKey(oneHour))
                        teacherHourCourseInfoMap.get(courseInfo.getTeacherId()).put(oneHour, new ArrayList<>());

                    teacherHourCourseInfoMap.get(courseInfo.getTeacherId()).get(oneHour).add(courseInfo.getCourseInfoID());
                });
            });
        });

        boolean isGetFirstConflict = false; //标记是否获得第一次冲突
        for (Map.Entry<String, Map<String, List<String>>> oneTeacherEntry : teacherHourCourseInfoMap.entrySet()) {
            for (Map.Entry<String, List<String>> oneHourEntry : oneTeacherEntry.getValue().entrySet()) {
                if (oneHourEntry.getValue().size() > 1) {
                    conflictTeacherID = oneTeacherEntry.getKey();
                    conflictHour = oneHourEntry.getKey();
                    conflictCourseInfoIDs = oneHourEntry.getValue();
                    isGetFirstConflict = true;
                    break;
                }
            }

            if (isGetFirstConflict)
                break;
        }

        //存在教师冲突的情况
        if (isGetFirstConflict) {

            for (String oneCourseInfoID : conflictCourseInfoIDs) {
                AutoCourseInfo courseInfo = courseInfoMap.get(oneCourseInfoID);

                //获取该课程可以安排的时间段
                List<String> courseInfoCanArrangeHours = ClassHourUtils.getCourseInfoCanArrangeHours(courseInfo, classCanArrangeHours, teacherOccupyHourAndCampus, classroomOccupyHour);
                courseInfoCanArrangeHours.removeAll(teacherHourCourseInfoMap.get(conflictTeacherID).keySet()); //去除该科目老师已经安排的时段

                //遍历该班级其他的科目安排
                for (Map.Entry<String, Vector<String>> courseInfoArrangeEntry : individual.get(courseInfo.getClassId()).entrySet()) {
                    if (courseInfoArrangeEntry.getKey().equals(oneCourseInfoID))
                        continue;

                    AutoCourseInfo anotherCourseInfo = courseInfoMap.get(courseInfoArrangeEntry.getKey());

                    //若科目2的老师已经在冲突时段有安排了，则不行
                    if (teacherHourCourseInfoMap.get(anotherCourseInfo.getTeacherId()).keySet().contains(conflictHour))
                        continue;

                    //获取该班级可以安排的时间段
                    List<String> anotherCourseInfoCanArrangeHours = ClassHourUtils.getCourseInfoCanArrangeHours(anotherCourseInfo, classCanArrangeHours, teacherOccupyHourAndCampus, classroomOccupyHour);
                    anotherCourseInfoCanArrangeHours.removeAll(teacherHourCourseInfoMap.get(anotherCourseInfo.getTeacherId()).keySet()); //去除该科目老师已经安排的时段

                    //科目2可以安排在冲突时段
                    if (anotherCourseInfoCanArrangeHours.contains(conflictHour)) {

                        for (String anotherHour : individual.get(anotherCourseInfo.getClassId()).get(anotherCourseInfo.getCourseInfoID())) {

                            //判断这个时段是否符合
                            if (courseInfoCanArrangeHours.contains(anotherHour)) {
                                //变换
                                individual.get(courseInfo.getClassId()).get(courseInfo.getCourseInfoID()).remove(conflictHour);
                                individual.get(courseInfo.getClassId()).get(courseInfo.getCourseInfoID()).add(anotherHour);
                                individual.get(anotherCourseInfo.getClassId()).get(anotherCourseInfo.getCourseInfoID()).remove(anotherHour);
                                individual.get(anotherCourseInfo.getClassId()).get(anotherCourseInfo.getCourseInfoID()).add(conflictHour);

                                return;

                            }
                        }
                    }
                }
            }
        }
    }

}
