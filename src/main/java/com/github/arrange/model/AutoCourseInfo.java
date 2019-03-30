package com.github.arrange.model;

import java.io.Serializable;

public class AutoCourseInfo implements Serializable {
    public AutoCourseInfo(){}

    public AutoCourseInfo(String courseInfoID, String grade, int stage, String classId, String subjectId, String teacherId, String classroomId, String campus, String type, int periods) {
        this.courseInfoID = courseInfoID;
        this.grade = grade;
        this.stage = stage;
        this.classId = classId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.classroomId = classroomId;
        this.campus = campus;
        this.type = type;
        this.periods = periods;
    }

    /**
     * id
     */
    private String courseInfoID;

    /**
     * 年级
     */
    private String grade;

    /**
     * 学段
     */
    private int stage;

    /**
     * 班级id
     */
    private String classId;

    /**
     * 科目id
     */
    private String subjectId;

    /**
     * 教师id
     */
    private String teacherId;

    /**
     * 教室id
     */
    private String classroomId;

    /**
     * 校区
     */
    private String campus;

    /**
     * 学科类型
     */
    private String type;

    /**
     * 课时数
     */
    private int periods;

    public String getCourseInfoID() {
        return courseInfoID;
    }

    public void setCourseInfoID(String courseInfoID) {
        this.courseInfoID = courseInfoID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public String getGradeAndStage() {
        return String.format("%s-%d", this.grade, this.stage);
    }
}
