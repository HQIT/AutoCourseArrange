import TestTools.*;
import com.github.arrange.CourseArrangeUtils;
import com.github.arrange.model.AutoCourseInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {
        //获取所有的CourseInfo（正常课时类型的行政班课程的CourseInfo）
        Vector<AutoCourseInfo> courseInfos = CourseInfoTools.generateCourseInfoList3();
        ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap = new ConcurrentHashMap<>();
        courseInfos.stream().forEach(oneCourseInfo -> {
            courseInfoMap.put(oneCourseInfo.getCourseInfoID(), oneCourseInfo);
        });

        WholeOccupy wholeOccupy = new WholeOccupy();
        wholeOccupy.setOccupancies(courseInfoMap); //注意，浅拷贝

        //获取所有的教师ID
        List<String> teacherIDs = new ArrayList<>(courseInfos.stream().map(oneCourseInfo -> oneCourseInfo.getTeacherId()).collect(Collectors.toSet()));

        //获取每周可上课的时间段（课时设置中设置的）
        Vector<String> classHours = ClassHourTools.generateClassHours();

        //取每个时间区间（上午、下午等）可安排的最多的节次段
        ConcurrentHashMap<String, Vector<String>> intervalMaxLesson = ClassHourTools.getIntervalMaxLesson(classHours);

        //获取学科优先安排的时段（由节次优先规则得出）， {年级-学段, {学科, [优先时段]}}
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> gradeStageSubjectPriorityArrangeHour = PriorityTools.setSubjectPriorityArrangeHour(courseInfos);

        //获取教师已被占用的时段（由已被安排的组合课、长课时以及课时活动安排规则得出），{teacherID, {hour, 校区}}
        ConcurrentHashMap<String, ConcurrentHashMap<String, String>> teacherOccupyHourAndCampus = ClassHourTools.setTeacherOccupyHourAndCampus(courseInfos);

        //获取教室已被占用的时段
        ConcurrentHashMap<String, Vector<String>> classroomOccupyHour = ClassHourTools.setClassroomOccupyHour(courseInfos);

        //获取班级已安排课程的时段（已安排的组合课、长课时的占用）
        ConcurrentHashMap<String, Vector<String>> classOccupyHour = ClassHourTools.setClassOccupyHour(courseInfos);

        //处理classOccupyHour，将其长课时占用转换成正常课时占用
        ClassHourTools.handleClassOccupyHour(classOccupyHour);

        //获取班级可安排课程的时段（即去除走班课程、长课时占用后的时段）
        ConcurrentHashMap<String, Vector<String>> classCanArrangeHours = ClassHourTools.getCanArrange(classHours, classOccupyHour);

        //获取合班信息，{科目，[[班级id]]}
        ConcurrentHashMap<String, Vector<Vector<String>>> togetherClass = RuleTools.getTogetherClass();

        //获取教师互斥信息，{教师id, [互斥的教师id]}
        ConcurrentHashMap<String, Vector<String>> teacherMutex = RuleTools.getTeacherMutex();

        //获取连上设定(教师) （跨校区任课需要隔开的课时数由Const设定）
        ConcurrentHashMap<String, Integer> teacherMaxContinuousClassHour = RuleTools.getTeacherMaxContinuousClassHour(teacherIDs);

        //获取教师跨校区上课中间需要隔开的节数
        int teacherTrainsCampusNeedInterval = 2;

        //获取课程设定（部分课程后不上部分课），{subject, [subject]}
        ConcurrentHashMap<String, Vector<String>> subjectNextNotArrangeSubjects = RuleTools.getSubjectNextNotArrangeSubjects();

        //首先安排合班的课程，安排完合班课程后再安排其他课程
        //合班课程的课时务必是相同的
        if (!togetherClass.isEmpty()) {
            Temporary.handleTogetherClassArrange(
                    courseInfos, wholeOccupy, teacherOccupyHourAndCampus, classroomOccupyHour, classOccupyHour, classCanArrangeHours, togetherClass, gradeStageSubjectPriorityArrangeHour, intervalMaxLesson
            );
        }

        //自动排课
        ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> bestIndividual = CourseArrangeUtils.autoArrange(
                courseInfos,
                courseInfoMap,
                intervalMaxLesson,
                gradeStageSubjectPriorityArrangeHour,
                teacherOccupyHourAndCampus,
                classroomOccupyHour,
                classCanArrangeHours,
                teacherMutex,
                teacherMaxContinuousClassHour,
                teacherTrainsCampusNeedInterval,
                subjectNextNotArrangeSubjects,
                500,
                3000
        );

        if (!wholeOccupy.getHours().isEmpty()) {
            for (Map.Entry<String, Vector<String>> oneCourseInfoArrange : wholeOccupy.getHours().entrySet()) {
                AutoCourseInfo courseInfo = courseInfoMap.get(oneCourseInfoArrange.getKey());

                bestIndividual.get(courseInfo.getClassId()).put(courseInfo.getCourseInfoID(), oneCourseInfoArrange.getValue());
            }
        }

        ExportUtils.exportIndividual(bestIndividual, courseInfoMap, "schedule"); //打印测试
    }
}
