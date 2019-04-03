package TestTools;

import com.github.arrange.model.AutoCourseInfo;

import java.util.Vector;

public class CourseInfoTools {
    /**
     * 生成一组CourseInfo
     * @return
     */
    public static Vector<AutoCourseInfo> generateCourseInfoList() {
        Vector<AutoCourseInfo> courseInfoList = new Vector();

        //高一 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "语文", "语文老师1", "高一(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "数学", "数学老师1", "高一(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "英语", "英语老师1", "高一(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "物理", "物理老师1", "高一(1)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "化学", "化学老师1", "高一(1)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "美术", "美术老师1", "高一(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "音乐", "音乐老师1", "高一(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "劳技", "劳技老师1", "高一(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "体育", "体育老师1", "高一(1)", "北校区", "else", 1));


        //高一 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "语文", "语文老师1", "高一(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "数学", "数学老师1", "高一(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "英语", "英语老师1", "高一(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "物理", "物理老师1", "高一(2)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "化学", "化学老师1", "高一(2)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "美术", "美术老师1", "高一(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "音乐", "音乐老师1", "高一(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "劳技", "劳技老师1", "高一(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "体育", "体育老师1", "高一(2)", "北校区", "else", 1));

        //高一 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "语文", "语文老师2", "高一(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "数学", "数学老师2", "高一(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "英语", "英语老师2", "高一(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "物理", "物理老师1", "高一(3)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "化学", "化学老师1", "高一(3)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "美术", "美术老师1", "高一(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "音乐", "音乐老师1", "高一(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "劳技", "劳技老师1", "高一(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "体育", "体育老师1", "高一(3)", "北校区", "else", 1));

        //高一 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "语文", "语文老师2", "高一(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "数学", "数学老师2", "高一(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "英语", "英语老师2", "高一(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "物理", "物理老师2", "高一(4)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "化学", "化学老师2", "高一(4)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "美术", "美术老师1", "高一(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "音乐", "音乐老师1", "高一(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "劳技", "劳技老师1", "高一(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "体育", "体育老师1", "高一(4)", "北校区", "else", 1));

        //高二 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "语文", "语文老师3", "高二(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "数学", "数学老师3", "高二(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "英语", "英语老师3", "高二(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "物理", "物理老师2", "高二(1)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "化学", "化学老师2", "高二(1)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "美术", "美术老师1", "高二(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "音乐", "音乐老师1", "高二(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "劳技", "劳技老师1", "高二(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "体育", "体育老师1", "高二(1)", "北校区", "else", 1));

        //高二 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "语文", "语文老师3", "高二(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "数学", "数学老师3", "高二(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "英语", "英语老师3", "高二(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "物理", "物理老师2", "高二(2)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "化学", "化学老师2", "高二(2)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "美术", "美术老师1", "高二(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "音乐", "音乐老师1", "高二(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "劳技", "劳技老师1", "高二(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "体育", "体育老师1", "高二(2)", "北校区", "else", 1));

        //高二 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "语文", "语文老师4", "高二(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "数学", "数学老师4", "高二(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "英语", "英语老师4", "高二(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "物理", "物理老师3", "高二(3)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "化学", "化学老师3", "高二(3)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "美术", "美术老师2", "高二(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "音乐", "音乐老师2", "高二(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "劳技", "劳技老师2", "高二(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "体育", "体育老师2", "高二(3)", "北校区", "else", 1));

        //高二 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "语文", "语文老师4", "高二(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "数学", "数学老师4", "高二(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "英语", "英语老师4", "高二(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "物理", "物理老师3", "高二(4)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "化学", "化学老师3", "高二(4)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "美术", "美术老师2", "高二(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "音乐", "音乐老师2", "高二(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "劳技", "劳技老师2", "高二(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "体育", "体育老师2", "高二(4)", "北校区", "else", 1));

        //高三 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "语文", "语文老师5", "高三(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "数学", "数学老师5", "高三(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "英语", "英语老师5", "高三(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "物理", "物理老师3", "高三(1)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "化学", "化学老师3", "高三(1)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "美术", "美术老师2", "高三(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "音乐", "音乐老师2", "高三(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "劳技", "劳技老师2", "高三(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(1)班", "体育", "体育老师2", "高三(1)", "北校区", "else", 1));

        //高三 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "语文", "语文老师5", "高三(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "数学", "数学老师5", "高三(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "英语", "英语老师5", "高三(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "物理", "物理老师4", "高三(2)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "化学", "化学老师4", "高三(2)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "美术", "美术老师2", "高三(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "音乐", "音乐老师2", "高三(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "劳技", "劳技老师2", "高三(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(2)班", "体育", "体育老师2", "高三(2)", "北校区", "else", 1));

        //高三 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "语文", "语文老师6", "高三(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "数学", "数学老师6", "高三(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "英语", "英语老师6", "高三(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "物理", "物理老师4", "高三(3)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "化学", "化学老师4", "高三(3)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "美术", "美术老师2", "高三(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "音乐", "音乐老师2", "高三(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "劳技", "劳技老师2", "高三(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(3)班", "体育", "体育老师2", "高三(3)", "北校区", "else", 1));

        //高三 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "语文", "语文老师6", "高三(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "数学", "数学老师6", "高三(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "英语", "英语老师6", "高三(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "物理", "物理老师4", "高三(4)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "化学", "化学老师4", "高三(4)", "北校区", "minor", 3));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "美术", "美术老师2", "高三(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "音乐", "音乐老师2", "高三(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "劳技", "劳技老师2", "高三(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 1, "高三(4)班", "体育", "体育老师2", "高三(4)", "北校区", "else", 1));

        return courseInfoList;
    }
}
