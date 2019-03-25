package com.github.arrange.utils;

import com.github.arrange.model.AutoCourseInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class ClassHourUtils {
    /**
     * 获取CourseInfo在班级中可以安排的时段
     * @param courseInfo
     * @param classCanArrangeHours
     * @return
     */
    public static List<String> getCourseInfoCanArrangeHours(
            AutoCourseInfo courseInfo,
            ConcurrentHashMap<String, Vector<String>> classCanArrangeHours,
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus,
            ConcurrentHashMap<String, Vector<String>> classroomOccupyHour) {

        List<String> courseInfoCanArrangeHours = new ArrayList<>(classCanArrangeHours.get(courseInfo.getClassId())); //当前班级可以安排的时段

        //移除教师已有安排的课时
        if (teacherOccupyHourAndCampus.containsKey(courseInfo.getTeacherId())) {
            courseInfoCanArrangeHours.removeAll(teacherOccupyHourAndCampus.get(courseInfo.getTeacherId()).keySet());
        }

        //移除教室已有安排的课时
        if (classroomOccupyHour.containsKey(courseInfo.getClassroomId())) {
            courseInfoCanArrangeHours.removeAll(classroomOccupyHour.get(courseInfo.getClassroomId()));
        }

        return courseInfoCanArrangeHours;
    }
}
