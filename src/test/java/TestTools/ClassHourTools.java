package TestTools;

import com.github.arrange.model.AutoCourseInfo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ClassHourTools {
    /**
     * 生成时段
     * @return
     */
    public static Vector<String> generateClassHours() {
        Vector<String> classHours = new Vector<>();

        classHours.add("0-1-0"); classHours.add("0-1-1"); classHours.add("0-1-2"); classHours.add("0-1-3");
        classHours.add("0-3-0"); classHours.add("0-3-1"); classHours.add("0-3-2"); classHours.add("0-3-3");

        classHours.add("1-1-0"); classHours.add("1-1-1"); classHours.add("1-1-2"); classHours.add("1-1-3");
        classHours.add("1-3-0"); classHours.add("1-3-1"); classHours.add("1-3-2"); classHours.add("1-3-3");

        classHours.add("2-1-0"); classHours.add("2-1-1"); classHours.add("2-1-2"); classHours.add("2-1-3");
        classHours.add("2-3-0"); classHours.add("2-3-1"); classHours.add("2-3-2"); classHours.add("2-3-3");

        classHours.add("3-1-0"); classHours.add("3-1-1"); classHours.add("3-1-2"); classHours.add("3-1-3");
        classHours.add("3-3-0"); classHours.add("3-3-1"); classHours.add("3-3-2"); classHours.add("3-3-3");

        classHours.add("4-1-0"); classHours.add("4-1-1"); classHours.add("4-1-2"); classHours.add("4-1-3");
        classHours.add("4-3-0"); classHours.add("4-3-1"); classHours.add("4-3-2"); classHours.add("4-3-3");

        return classHours;
    }

    /**
     * 取每个时间区间（上午、下午等）可安排的最多的节次段
     * @param classHours
     * @return
     */
    public static ConcurrentHashMap<String, Vector<String>> getIntervalMaxLesson(Vector<String> classHours) {
        ConcurrentHashMap<String, Vector<String>> intervalMaxLesson = new ConcurrentHashMap<>();

        classHours.stream().forEach(oneHour -> {
            if (!intervalMaxLesson.containsKey(oneHour.substring(2, 3))) {
                intervalMaxLesson.put(oneHour.substring(2, 3), new Vector());
            }

            if (!intervalMaxLesson.get(oneHour.substring(2, 3)).contains(oneHour.substring(2, 5))) {
                intervalMaxLesson.get(oneHour.substring(2, 3)).add(oneHour.substring(2, 5));
            }
        });

        return intervalMaxLesson;
    }

    /**
     * 获取教师已被占用的时段
     * @param courseInfos
     * @return
     */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> setTeacherOccupyHourAndCampus(Vector<AutoCourseInfo> courseInfos) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus = new ConcurrentHashMap<>();

        courseInfos.stream().forEach(oneCourseInfo -> {
            String teacherID = oneCourseInfo.getTeacherId();
            String campus = oneCourseInfo.getCampus();

            if (!teacherOccupyHourAndCampus.containsKey(teacherID)) {
                teacherOccupyHourAndCampus.put(teacherID, new ConcurrentHashMap<>());
            }

            //设置语文老师周三下午不允许安排（教研活动）
            if (teacherID.contains("语文")) {
                ConcurrentHashMap<String, String> oneTeacherOccupy = new ConcurrentHashMap<>();

                oneTeacherOccupy.put("2-3-0", campus);
                oneTeacherOccupy.put("2-3-1", campus);
                oneTeacherOccupy.put("2-3-2", campus);
                oneTeacherOccupy.put("2-3-3", campus);

                teacherOccupyHourAndCampus.put(teacherID, oneTeacherOccupy);
            }

            //设置数学老师周二下午不允许安排（教研活动）
            else if (teacherID.contains("数学")) {
                ConcurrentHashMap<String, String> oneTeacherOccupy = new ConcurrentHashMap<>();

                oneTeacherOccupy.put("1-3-0", campus);
                oneTeacherOccupy.put("1-3-1", campus);
                oneTeacherOccupy.put("1-3-2", campus);
                oneTeacherOccupy.put("1-3-3", campus);

                teacherOccupyHourAndCampus.put(teacherID, oneTeacherOccupy);
            }

            //设置英语老师周一下午不允许安排（教研活动）
            else if (teacherID.contains("英语")) {
                ConcurrentHashMap<String, String> oneTeacherOccupy = new ConcurrentHashMap<>();

                oneTeacherOccupy.put("0-3-0", campus);
                oneTeacherOccupy.put("0-3-1", campus);
                oneTeacherOccupy.put("0-3-2", campus);
                oneTeacherOccupy.put("0-3-3", campus);

                teacherOccupyHourAndCampus.put(teacherID, oneTeacherOccupy);
            }

            //设置物理老师周二上午不允许安排（教研活动）
            else if (teacherID.contains("物理")) {
                ConcurrentHashMap<String, String> oneTeacherOccupy = new ConcurrentHashMap<>();

                oneTeacherOccupy.put("1-1-0", campus);
                oneTeacherOccupy.put("1-1-1", campus);
                oneTeacherOccupy.put("1-1-2", campus);
                oneTeacherOccupy.put("1-1-3", campus);

                teacherOccupyHourAndCampus.put(teacherID, oneTeacherOccupy);
            }

            //设置化学老师周一上午不允许安排（教研活动）
            else if (teacherID.contains("化学")) {
                ConcurrentHashMap<String, String> oneTeacherOccupy = new ConcurrentHashMap<>();

                oneTeacherOccupy.put("0-1-0", campus);
                oneTeacherOccupy.put("0-1-1", campus);
                oneTeacherOccupy.put("0-1-2", campus);
                oneTeacherOccupy.put("0-1-3", campus);

                teacherOccupyHourAndCampus.put(teacherID, oneTeacherOccupy);
            }

            //设置音乐老师周一上午1、2节不允许安排（教研活动）
            else if (teacherID.contains("音乐")) {
                ConcurrentHashMap<String, String> oneTeacherOccupy = new ConcurrentHashMap<>();

                oneTeacherOccupy.put("0-1-0", campus);
                oneTeacherOccupy.put("0-1-1", campus);

                teacherOccupyHourAndCampus.put(teacherID, oneTeacherOccupy);
            }


            //设置体育老师周三上午2、3节不允许安排（教研活动）
            else if (teacherID.contains("体育")) {
                ConcurrentHashMap<String, String> oneTeacherOccupy = new ConcurrentHashMap<>();

                oneTeacherOccupy.put("2-1-1", campus);
                oneTeacherOccupy.put("2-1-2", campus);

                teacherOccupyHourAndCampus.put(teacherID, oneTeacherOccupy);
            }
        });

        return teacherOccupyHourAndCampus;
    }

    /**
     * 获取教室已被占用的时段
     * @param courseInfos
     * @return
     */
    public static ConcurrentHashMap<String, Vector<String>> setClassroomOccupyHour(Vector<AutoCourseInfo> courseInfos) {
        ConcurrentHashMap<String, Vector<String>> classroomOccupyHour = new ConcurrentHashMap<>();

        //获取所有的教室
        List<String> classrooms = courseInfos.stream().map(oneCourseInfo -> oneCourseInfo.getClassroomId()).collect(Collectors.toList());

        classrooms.stream().forEach(oneClassroom -> {
            classroomOccupyHour.put(oneClassroom, new Vector<>());
        });

        //随机选择1个教室，设置周二上午三四节被占用
        /*Random random = new Random();
        int x = random.nextInt(classrooms.size());
        classroomOccupyHour.get(classrooms.get(x)).add("1-1-2");
        classroomOccupyHour.get(classrooms.get(x)).add("1-1-3");*/

        return classroomOccupyHour;
    }

    /**
     * 获取班级已安排课程的时段
     * @param courseInfos
     * @return
     */
    public static ConcurrentHashMap<String, Vector<String>> setClassOccupyHour(Vector<AutoCourseInfo> courseInfos) {
        ConcurrentHashMap<String, Vector<String>> classOccupyHour = new ConcurrentHashMap<>();

        /*//假设每个班级都被组合课占用了16个课时
        //分别为周一上午第4节，下午2、3、5节；周二下午2-5节；周三下午3-5节；周四下午1-3；周五下午1-2节
        Vector<String> shiftArrangeHour = new Vector<>();
        shiftArrangeHour.add("0-1-3"); shiftArrangeHour.add("0-3-1"); shiftArrangeHour.add("0-3-2");  shiftArrangeHour.add("0-3-4");
        shiftArrangeHour.add("1-3-1"); shiftArrangeHour.add("1-3-2"); shiftArrangeHour.add("1-3-3"); shiftArrangeHour.add("1-3-4");
        shiftArrangeHour.add("2-3-2"); shiftArrangeHour.add("2-3-3"); shiftArrangeHour.add("2-3-4");
        shiftArrangeHour.add("3-3-0"); shiftArrangeHour.add("3-3-1"); shiftArrangeHour.add("3-3-2");
        shiftArrangeHour.add("4-3-0"); shiftArrangeHour.add("4-3-1");

        //假设每个班级每周都有2节长课时
        //分别安排在周三上午后三节
        shiftArrangeHour.add("2-1-2-1110"); shiftArrangeHour.add("2-1-3-0111");
        //shiftArrangeHour.add("4-3-2-1110"); shiftArrangeHour.add("4-3-3-0111");*/

        //获取所有的班级ID
        List<String> classIDs = courseInfos.stream().map(oneCourseInfo -> oneCourseInfo.getClassId()).collect(Collectors.toList());

        Vector<String> shiftArrangeHour_1 = new Vector<>();
        shiftArrangeHour_1.add("0-1-3"); shiftArrangeHour_1.add("0-3-0"); shiftArrangeHour_1.add("0-3-1"); shiftArrangeHour_1.add("0-3-2"); shiftArrangeHour_1.add("0-3-3");
        shiftArrangeHour_1.add("1-1-3"); shiftArrangeHour_1.add("1-3-1"); shiftArrangeHour_1.add("1-3-2");
        shiftArrangeHour_1.add("2-3-0"); shiftArrangeHour_1.add("2-3-1"); shiftArrangeHour_1.add("2-3-2"); shiftArrangeHour_1.add("2-3-3");
        shiftArrangeHour_1.add("3-3-0"); shiftArrangeHour_1.add("3-3-1"); shiftArrangeHour_1.add("3-3-2");
        shiftArrangeHour_1.add("4-3-0"); shiftArrangeHour_1.add("4-3-2"); shiftArrangeHour_1.add("4-3-3");

        Vector<String> shiftArrangeHour_2 = new Vector<>();
        shiftArrangeHour_2.add("0-3-0"); shiftArrangeHour_2.add("0-3-1"); shiftArrangeHour_2.add("0-3-2"); shiftArrangeHour_2.add("0-3-3");
        shiftArrangeHour_2.add("1-1-3"); shiftArrangeHour_2.add("1-3-0"); shiftArrangeHour_2.add("1-3-2"); shiftArrangeHour_2.add("1-3-3");
        shiftArrangeHour_2.add("2-3-0"); shiftArrangeHour_2.add("2-3-2"); shiftArrangeHour_2.add("2-3-3");
        shiftArrangeHour_2.add("3-1-3"); shiftArrangeHour_2.add("3-3-1"); shiftArrangeHour_2.add("3-3-2"); shiftArrangeHour_2.add("3-3-3");
        shiftArrangeHour_2.add("4-3-0"); shiftArrangeHour_2.add("4-3-1"); shiftArrangeHour_2.add("4-3-3");

        //设置班级已安排课程的时段
        classIDs.stream().forEach(oneClass -> {
            //classOccupyHour.put(oneClass, new Vector<>(shiftArrangeHour));
            if (oneClass.equals("高一(1)班") || oneClass.equals("高一(2)班") || oneClass.equals("高一(3)班") || oneClass.equals("高一(4)班")) {
                classOccupyHour.put(oneClass, new Vector<>(shiftArrangeHour_1));

                //长课时
                if (oneClass.equals("高一(1)班")) {
                    classOccupyHour.get(oneClass).add("2-1-0"); classOccupyHour.get(oneClass).add("2-1-1"); classOccupyHour.get(oneClass).add("2-1-2");
                    classOccupyHour.get(oneClass).add("4-1-0"); classOccupyHour.get(oneClass).add("4-1-1"); classOccupyHour.get(oneClass).add("4-1-2");
                } else if (oneClass.equals("高一(2)班")) {
                    classOccupyHour.get(oneClass).add("3-1-0"); classOccupyHour.get(oneClass).add("3-1-1"); classOccupyHour.get(oneClass).add("3-1-2");
                    classOccupyHour.get(oneClass).add("4-1-0"); classOccupyHour.get(oneClass).add("4-1-1"); classOccupyHour.get(oneClass).add("4-1-2");
                } else if (oneClass.equals("高一(3)班")) {
                    classOccupyHour.get(oneClass).add("2-1-0"); classOccupyHour.get(oneClass).add("2-1-1"); classOccupyHour.get(oneClass).add("2-1-2");
                    classOccupyHour.get(oneClass).add("3-1-0"); classOccupyHour.get(oneClass).add("3-1-1"); classOccupyHour.get(oneClass).add("3-1-2");
                } else if (oneClass.equals("高一(4)班")) {
                    classOccupyHour.get(oneClass).add("2-1-0"); classOccupyHour.get(oneClass).add("2-1-1"); classOccupyHour.get(oneClass).add("2-1-2");
                    classOccupyHour.get(oneClass).add("4-1-0"); classOccupyHour.get(oneClass).add("4-1-1"); classOccupyHour.get(oneClass).add("4-1-2");
                }

            } else if (oneClass.equals("高二(1)班") || oneClass.equals("高二(2)班") || oneClass.equals("高二(3)班") || oneClass.equals("高二(4)班")) {
                classOccupyHour.put(oneClass, new Vector<>(shiftArrangeHour_2));

                //长课时
                if (oneClass.equals("高二(1)班")) {
                    classOccupyHour.get(oneClass).add("2-1-0"); classOccupyHour.get(oneClass).add("2-1-1"); classOccupyHour.get(oneClass).add("2-1-2");
                    classOccupyHour.get(oneClass).add("4-1-0"); classOccupyHour.get(oneClass).add("4-1-1"); classOccupyHour.get(oneClass).add("4-1-2");
                } else if (oneClass.equals("高二(2)班")) {
                    classOccupyHour.get(oneClass).add("3-1-0"); classOccupyHour.get(oneClass).add("3-1-1"); classOccupyHour.get(oneClass).add("3-1-2");
                    classOccupyHour.get(oneClass).add("4-1-0"); classOccupyHour.get(oneClass).add("4-1-1"); classOccupyHour.get(oneClass).add("4-1-2");
                } else if (oneClass.equals("高二(3)班")) {
                    classOccupyHour.get(oneClass).add("2-1-0"); classOccupyHour.get(oneClass).add("2-1-1"); classOccupyHour.get(oneClass).add("2-1-2");
                    classOccupyHour.get(oneClass).add("3-1-0"); classOccupyHour.get(oneClass).add("3-1-1"); classOccupyHour.get(oneClass).add("3-1-2");
                } else if (oneClass.equals("高二(4)班")) {
                    classOccupyHour.get(oneClass).add("2-1-0"); classOccupyHour.get(oneClass).add("2-1-1"); classOccupyHour.get(oneClass).add("2-1-2");
                    classOccupyHour.get(oneClass).add("4-1-0"); classOccupyHour.get(oneClass).add("4-1-1"); classOccupyHour.get(oneClass).add("4-1-2");
                }
            }
        });

        return classOccupyHour;
    }

    /**
     * 处理classOccupyHour，将其长课时占用转换成正常课时占用
     * @param classOccupyHour
     */
    public static void handleClassOccupyHour(ConcurrentHashMap<String, Vector<String>> classOccupyHour) {

        classOccupyHour.entrySet().stream().forEach(oneClassOccupyHour -> {

            //获取长课时课程占用的时段
            List<String> longHours = oneClassOccupyHour.getValue().stream().filter(oneHour -> oneHour.split("-").length == 4).collect(Collectors.toList());

            if (longHours.size() > 0) {
                //将长课时占用的时段移除
                oneClassOccupyHour.getValue().removeAll(longHours);

                //将长课时转化为正常课时的占用
                List<String> wrapLongToNormalHour = new ArrayList<>(wrapLongToNormal(longHours));

                wrapLongToNormalHour.stream().forEach(oneHour -> {
                    if (!oneClassOccupyHour.getValue().contains(oneHour)) {
                        oneClassOccupyHour.getValue().add(oneHour);
                    }
                });
            }

        });
    }

    /**
     * 获取班级可安排课程的时段
     * @param classHours 课时设置中安排的可上课的时间段
     * @param classOccupyHour 班级已被占用（安排了课）的时段
     * @return
     */
    public static ConcurrentHashMap<String, Vector<String>> getCanArrange(Vector<String> classHours, ConcurrentHashMap<String, Vector<String>> classOccupyHour) {
        ConcurrentHashMap<String, Vector<String>> classToHours = new ConcurrentHashMap<>();

        classOccupyHour.entrySet().stream().forEach(oneClassOccupyHour -> {

            List<String> currentClassCanArrangeHours = new ArrayList<>(classHours); //用于记录该班级可以安排的时间段

            //移除已经被占用的时间段
            currentClassCanArrangeHours.removeAll(oneClassOccupyHour.getValue());

            classToHours.put(oneClassOccupyHour.getKey(), new Vector<>(currentClassCanArrangeHours));
        });

        return classToHours;
    }

    /**
     * 将长课时转换成正常课时的占用
     * @param longHours
     * @return
     */
    public static Set<String> wrapLongToNormal(List<String> longHours) {
        Set<String> normalHours = new HashSet<>();

        longHours.stream().forEach(oneLongHour -> {
            String[] longHourSplit = oneLongHour.split("-");

            //考虑当前节
            normalHours.add(String.format("%s-%s-%s", longHourSplit[0], longHourSplit[1], longHourSplit[2]));

            //考虑下一节
            normalHours.add(String.format("%s-%s-%s", longHourSplit[0], longHourSplit[1], Integer.valueOf(longHourSplit[2]) + 1));

        });

        return normalHours;
    }
}
