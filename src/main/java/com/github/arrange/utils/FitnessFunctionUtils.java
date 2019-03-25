package com.github.arrange.utils;

import com.github.arrange.model.AutoCourseInfo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FitnessFunctionUtils {

    /**
     * 计算个体节次优度
     *
     * 违反科目优先安排时段的次数越多，节次优度越小
     * @param classArranges
     * @return
     */
    public static double f1(ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> classArranges, ConcurrentHashMap<String, Vector<String>> subjectPriorityArrangeHour, ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap) {

        int violations = 0; //用于记录违反的次数

        //遍历所有的班级
        for (ConcurrentHashMap<String, Vector<String>> oneClassArrange : classArranges.values()) {

            //获取当前班级所有CourseInfoID
            List<String> currentClassCourseInfoIDs = new ArrayList<>(oneClassArrange.keySet());

            for (String courseInfoID : currentClassCourseInfoIDs) {

                //获取科目
                String subject = courseInfoMap.get(courseInfoID).getSubjectId();

                for (String hour : oneClassArrange.get(courseInfoID)) {
                    String[] hourSplit = hour.split("-");

                    //获取day的时段
                    String dayHour = String.format("%s-%s", hourSplit[1], hourSplit[2]);

                    if (!subjectPriorityArrangeHour.get(subject).contains(dayHour))
                        violations++;

                }
            }
        }

        return 1 * Math.pow(0.99, violations);
    }

    /**
     * 计算个体课程分配均匀度
     * @param classArranges
     * @return
     */
    public static double f2(ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> classArranges) {

        //取得当前个体课程分配均匀度
        double currentIndividualEvenness = 0.0;

        //遍历所有的班级
        for (ConcurrentHashMap<String, Vector<String>> oneClassArrange : classArranges.values()) {
            //取得当前班级课程分配均匀度
            double currentClassEvenness = 0.0;

            //遍历班级中所有科目的安排
            for (List<String> currentSubjecthours : oneClassArrange.values()) {
                //取得当前科目的课程分配均匀度
                double currentSubjectEvenness = 0.0;

                //获得当前科目一周中每天安排的课时
                int[] currentSubjectArrangeHoursPerdays = new int[5];
                //每周上五天课，周一到周五
                for (int i = 0; i < 5; i++) {
                    String day = String.valueOf(i);
                    currentSubjectArrangeHoursPerdays[i] = currentSubjecthours.stream().filter(oneHour -> oneHour.split("-")[0].equals(day)).collect(Collectors.toList()).size();
                }

                //计算标准课时(课时除以上课的天数)
                double standardizedHour = (double)currentSubjecthours.size() / 5;

                for (int i = 0; i < 5; i++) {
                    currentSubjectEvenness += Math.abs(currentSubjectArrangeHoursPerdays[i] - standardizedHour);
                }

                //计算该科目的均匀度
                currentSubjectEvenness = 1 / (1 + ((double)1 / 5) * currentSubjectEvenness);

                currentClassEvenness += currentSubjectEvenness;
            }

            //取得平均值
            currentClassEvenness /= oneClassArrange.keySet().size();

            currentIndividualEvenness += currentClassEvenness;
        }

        //取得平均值
        currentIndividualEvenness /= classArranges.size();

        return currentIndividualEvenness;
    }

    /**
     * 计算课时均匀度
     * @param individual
     * @return
     */
    public static double f3(HashMap<String, HashMap<String, List<String>>> individual) {
        //获得所有班级的安排
        List<Map<String, List<String>>> chromosomes = individual.values().stream().collect(Collectors.toList());

        //取得当前个体课时均匀度
        double currentIndividualEvenness = 0.0;

        //遍历所有的班级
        for (Map<String, List<String>> chromosome : chromosomes) {

            int[] dayPeriods = new int[5];  //用来记录周一到周五每天的课时

            //计算当前班级每天上课的课时数
            for (List<String> currentSubjectHour : chromosome.values()) {
                for (String hour : currentSubjectHour) {
                    dayPeriods[Integer.valueOf(hour.split("-")[0])]++;
                }
            }

            //获得当前班级在一周上课节数的均值
            double dayPeriodEvenness = 0.0;
            for (int i = 0; i < 5; i++ ) {
                dayPeriodEvenness += dayPeriods[i];
            }
            dayPeriodEvenness /= 5;

            double temp = 0.0; //获取根号中式子的值
            for (int i = 0; i < 5; i++ ) {
                temp += Math.pow(dayPeriods[i] - dayPeriodEvenness, 2);
            }

            //取得当前班级课时均匀度
            double currentClassEvenness = 1 / Math.sqrt(temp);

            currentIndividualEvenness += currentClassEvenness;
        }

        //取得平均值
        currentIndividualEvenness /= chromosomes.size();

        return currentIndividualEvenness;
    }
}
