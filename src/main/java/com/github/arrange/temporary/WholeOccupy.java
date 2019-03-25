package com.github.arrange.temporary;

import com.github.arrange.model.AutoCourseInfo;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class WholeOccupy {
    /**
     * 占用的课时
     * {courseInfo, [courseHour]}
     */
    private ConcurrentHashMap<String, Vector<String>> hours = new ConcurrentHashMap<>();

    /**
     * 占用详情
     */
    private ConcurrentHashMap<String, AutoCourseInfo> occupancies = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, Vector<String>> getHours() {
        return hours;
    }

    public void setHours(ConcurrentHashMap<String, Vector<String>> hours) {
        this.hours = hours;
    }

    public ConcurrentHashMap<String, AutoCourseInfo> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(ConcurrentHashMap<String, AutoCourseInfo> occupancies) {
        this.occupancies = occupancies;
    }
}
