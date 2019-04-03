package TestTools;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class RuleTools {
    /**
     * 获取合班信息
     * @return
     */
    public static ConcurrentHashMap<String, Vector<Vector<String>>> getTogetherClass() {

        ConcurrentHashMap<String, Vector<Vector<String>>> togetherClass = new ConcurrentHashMap<>();

        /*//体育合班
        Vector<Vector<String>> sportsTogether = new Vector<>();

        //高一1、2、3、4班的体育为合班
        Vector<String> sports_1 = new Vector<>();
        sports_1.add("高一(1)班"); sports_1.add("高一(2)班"); sports_1.add("高一(3)班"); sports_1.add("高一(4)班");
        sportsTogether.add(sports_1);

        togetherClass.put("体育", sportsTogether);*/

        //音乐合班
        Vector<Vector<String>> musicTogether = new Vector<>();

        //高一1、2班的音乐为合班
        Vector<String> music_1 = new Vector<>();
        music_1.add("高一(1)班"); music_1.add("高一(2)班");
        musicTogether.add(music_1);

        //高一3、4班的音乐为合班
        Vector<String> music_2 = new Vector<>();
        music_2.add("高一(3)班"); music_2.add("高一(4)班");
        musicTogether.add(music_2);

        togetherClass.put("音乐", musicTogether);

        return togetherClass;
    }

    /**
     * 获取教师互斥信息
     * @return
     */
    public static ConcurrentHashMap<String, Vector<String>> getTeacherMutex() {
        Vector<Vector<String>> teacherMutexRule = new Vector<>();

        //设定语文老师1、语文老师2、语文老师3不同时上课
        /*Vector<String> mutex_1 = new Vector<>();
        mutex_1.add("语文老师1"); mutex_1.add("语文老师2");
        teacherMutexRule.add(mutex_1);*/

        //设定物理老师1、物理老师2不同时上课
        /*Vector<String> mutex_2 = new Vector<>();
        mutex_2.add("物理老师1"); mutex_2.add("物理老师2");
        teacherMutexRule.add(mutex_2);*/

        /*****对教师互斥规则的处理******/
        ConcurrentHashMap<String, Vector<String>> teacherMutex = new ConcurrentHashMap<>();

        teacherMutexRule.stream().forEach(oneMutexRuleList -> {
            oneMutexRuleList.stream().forEach(oneTeacherID -> {
                teacherMutex.put(oneTeacherID, new Vector<>(oneMutexRuleList));
                teacherMutex.get(oneTeacherID).remove(oneTeacherID);
            });
        });

        return teacherMutex;
        /******************************/
    }

    /**
     * 获取连上设定（教师）
     * @param teacherIDs
     * @return
     */
    public static ConcurrentHashMap<String, Integer> getTeacherMaxContinuousClassHour(List<String> teacherIDs) {
        ConcurrentHashMap<String, Integer> teacherMaxContinuousClassHour = new ConcurrentHashMap<>();

        //设定所有的老师连续上课不超过两节
        teacherIDs.stream().forEach(oneTeacherID -> {
            teacherMaxContinuousClassHour.put(oneTeacherID, 2);
        });

        return teacherMaxContinuousClassHour;
    }

    /**
     * 获取课程设定（部分课程后不上部分课程）
     * @return
     */
    public static ConcurrentHashMap<String, Vector<String>> getSubjectNextNotArrangeSubjects() {
        ConcurrentHashMap<String, Vector<String>> subjectNextNotArrangeSubjects = new ConcurrentHashMap<>();

        //设定语文课后不上体育
        subjectNextNotArrangeSubjects.put("语文", new Vector<>(Arrays.asList("体育")));

        //设定美术课后不上劳技、体育、音乐课
        subjectNextNotArrangeSubjects.put("美术", new Vector<>(Arrays.asList("劳技", "音乐", "体育")));

        //设定物理课后不上化学课
        subjectNextNotArrangeSubjects.put("物理", new Vector<>(Arrays.asList("化学")));

        return subjectNextNotArrangeSubjects;
    }
}
