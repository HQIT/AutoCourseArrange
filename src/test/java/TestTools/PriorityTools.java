package TestTools;

import com.github.arrange.model.AutoCourseInfo;

import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PriorityTools {
    /**
     * 获取课程优先安排的时段
     * @return
     */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> setSubjectPriorityArrangeHour(Vector<AutoCourseInfo> courseInfos) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> gradeStageSubjectPriorityArrangeHour = new ConcurrentHashMap<>();

        //获取所有的年级-学段
        Set<String> gradeWithStage = courseInfos.stream().map(one -> one.getGradeAndStage()).collect(Collectors.toSet());

        gradeWithStage.stream().forEach(one -> {
            ConcurrentHashMap<String, Vector<String>> subjectPriorityArrangeHour = new ConcurrentHashMap<>();

            //语文优先安排在上午
            subjectPriorityArrangeHour.put("语文", new Vector<>());
            subjectPriorityArrangeHour.get("语文").add("1-0");
            subjectPriorityArrangeHour.get("语文").add("1-1");
            subjectPriorityArrangeHour.get("语文").add("1-2");
            subjectPriorityArrangeHour.get("语文").add("1-3");
            subjectPriorityArrangeHour.get("语文").add("1-4");

            //英语优先安排在上午
            subjectPriorityArrangeHour.put("英语", new Vector<>());
            subjectPriorityArrangeHour.get("英语").add("1-0");
            subjectPriorityArrangeHour.get("英语").add("1-1");
            subjectPriorityArrangeHour.get("英语").add("1-2");
            subjectPriorityArrangeHour.get("英语").add("1-3");
            subjectPriorityArrangeHour.get("英语").add("1-4");

            //数学优先安排在上午
            subjectPriorityArrangeHour.put("数学", new Vector<>());
            subjectPriorityArrangeHour.get("数学").add("1-0");
            subjectPriorityArrangeHour.get("数学").add("1-1");
            subjectPriorityArrangeHour.get("数学").add("1-2");
            subjectPriorityArrangeHour.get("数学").add("1-3");
            subjectPriorityArrangeHour.get("数学").add("1-4");
            subjectPriorityArrangeHour.get("数学").add("3-0");

            //物理优先安排在下午、上午5节
            subjectPriorityArrangeHour.put("物理", new Vector<>());
            subjectPriorityArrangeHour.get("物理").add("1-4");
            subjectPriorityArrangeHour.get("物理").add("3-0");
            subjectPriorityArrangeHour.get("物理").add("3-1");
            subjectPriorityArrangeHour.get("物理").add("3-2");
            subjectPriorityArrangeHour.get("物理").add("3-3");
            subjectPriorityArrangeHour.get("物理").add("3-4");

            //化学优先安排在下午、上午5节
            subjectPriorityArrangeHour.put("化学", new Vector<>());
            subjectPriorityArrangeHour.get("化学").add("1-4");
            subjectPriorityArrangeHour.get("化学").add("3-0");
            subjectPriorityArrangeHour.get("化学").add("3-1");
            subjectPriorityArrangeHour.get("化学").add("3-2");
            subjectPriorityArrangeHour.get("化学").add("3-3");
            subjectPriorityArrangeHour.get("化学").add("3-4");

            //美术优先安排在上午第5节和下午
            subjectPriorityArrangeHour.put("美术", new Vector<>());
            subjectPriorityArrangeHour.get("美术").add("1-4");
            subjectPriorityArrangeHour.get("美术").add("3-0");
            subjectPriorityArrangeHour.get("美术").add("3-1");
            subjectPriorityArrangeHour.get("美术").add("3-2");
            subjectPriorityArrangeHour.get("美术").add("3-3");
            subjectPriorityArrangeHour.get("美术").add("3-4");

            //音乐优先安排在上午第5节和下午
            subjectPriorityArrangeHour.put("音乐", new Vector<>());
            subjectPriorityArrangeHour.get("音乐").add("1-4");
            subjectPriorityArrangeHour.get("音乐").add("3-0");
            subjectPriorityArrangeHour.get("音乐").add("3-1");
            subjectPriorityArrangeHour.get("音乐").add("3-2");
            subjectPriorityArrangeHour.get("音乐").add("3-3");
            subjectPriorityArrangeHour.get("音乐").add("3-4");

            //劳技优先安排在上午第5节和下午
            subjectPriorityArrangeHour.put("劳技", new Vector<>());
            subjectPriorityArrangeHour.get("劳技").add("1-4");
            subjectPriorityArrangeHour.get("劳技").add("3-0");
            subjectPriorityArrangeHour.get("劳技").add("3-1");
            subjectPriorityArrangeHour.get("劳技").add("3-2");
            subjectPriorityArrangeHour.get("劳技").add("3-3");
            subjectPriorityArrangeHour.get("劳技").add("3-4");

            //体育优先安排在上午第5节和下午
            subjectPriorityArrangeHour.put("体育", new Vector<>());
            subjectPriorityArrangeHour.get("体育").add("1-4");
            subjectPriorityArrangeHour.get("体育").add("3-0");
            subjectPriorityArrangeHour.get("体育").add("3-1");
            subjectPriorityArrangeHour.get("体育").add("3-2");
            subjectPriorityArrangeHour.get("体育").add("3-3");
            subjectPriorityArrangeHour.get("体育").add("3-4");

            gradeStageSubjectPriorityArrangeHour.put(one, subjectPriorityArrangeHour);
        });


        return gradeStageSubjectPriorityArrangeHour;
    }
}
