package TestTools;

import com.github.arrange.model.AutoCourseInfo;

import java.util.Vector;

public class CourseInfoTools {
    /**
     * 生成一组CourseInfo
     *
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

    /**
     * 生成一组CourseInfo，模拟黉学
     *
     * @return
     */
    /*public static Vector<AutoCourseInfo> generateCourseInfoList2() {
        Vector<AutoCourseInfo> courseInfoList = new Vector();

        //初一 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "语文", "语文老师1", "初一(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "数学", "数学老师1", "初一(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "英语", "英语老师1", "初一(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "物理", "物理老师1", "初一(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "化学", "化学老师1", "初一(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "历史", "历史老师1", "初一(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "政治", "政治老师1", "初一(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "微机", "微机老师1", "初一(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "音乐", "音乐老师1", "初一(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(1)班", "体育", "体育老师1", "初一(1)", "北校区", "else", 1));

        //初一 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "语文", "语文老师1", "初一(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "数学", "数学老师1", "初一(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "英语", "英语老师1", "初一(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "物理", "物理老师1", "初一(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "化学", "化学老师1", "初一(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "历史", "历史老师1", "初一(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "政治", "政治老师1", "初一(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "微机", "微机老师1", "初一(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "音乐", "音乐老师1", "初一(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(2)班", "体育", "体育老师1", "初一(2)", "北校区", "else", 1));

        //初一 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "语文", "语文老师2", "初一(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "数学", "数学老师2", "初一(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "英语", "英语老师2", "初一(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "物理", "物理老师2", "初一(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "化学", "化学老师2", "初一(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "历史", "历史老师2", "初一(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "政治", "政治老师2", "初一(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "微机", "微机老师1", "初一(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "音乐", "音乐老师1", "初一(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(3)班", "体育", "体育老师1", "初一(3)", "北校区", "else", 1));

        //初一 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "语文", "语文老师3", "初一(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "数学", "数学老师3", "初一(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "英语", "英语老师3", "初一(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "物理", "物理老师2", "初一(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "化学", "化学老师2", "初一(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "历史", "历史老师2", "初一(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "政治", "政治老师2", "初一(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "微机", "微机老师1", "初一(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "音乐", "音乐老师1", "初一(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(4)班", "体育", "体育老师1", "初一(4)", "北校区", "else", 1));

        //初一 5班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "语文", "语文老师3", "初一(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "数学", "数学老师3", "初一(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "英语", "英语老师3", "初一(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "物理", "物理老师3", "初一(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "化学", "化学老师3", "初一(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "历史", "历史老师3", "初一(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "政治", "政治老师3", "初一(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "微机", "微机老师1", "初一(5)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "音乐", "音乐老师1", "初一(5)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(5)班", "体育", "体育老师1", "初一(5)", "北校区", "else", 1));

        //初一 6班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "语文", "语文老师4", "初一(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "数学", "数学老师4", "初一(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "英语", "英语老师4", "初一(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "物理", "物理老师3", "初一(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "化学", "化学老师3", "初一(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "历史", "历史老师3", "初一(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "政治", "政治老师3", "初一(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "微机", "微机老师2", "初一(6)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "音乐", "音乐老师2", "初一(6)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(6)班", "体育", "体育老师2", "初一(6)", "北校区", "else", 1));

        //初一 7班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "语文", "语文老师4", "初一(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "数学", "数学老师4", "初一(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "英语", "英语老师4", "初一(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "物理", "物理老师4", "初一(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "化学", "化学老师4", "初一(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "历史", "历史老师4", "初一(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "政治", "政治老师4", "初一(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "微机", "微机老师2", "初一(7)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "音乐", "音乐老师2", "初一(7)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(7)班", "体育", "体育老师2", "初一(7)", "北校区", "else", 1));

        //初一 8班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "语文", "语文老师5", "初一(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "数学", "数学老师5", "初一(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "英语", "英语老师5", "初一(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "物理", "物理老师4", "初一(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "化学", "化学老师4", "初一(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "历史", "历史老师4", "初一(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "政治", "政治老师4", "初一(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "微机", "微机老师2", "初一(8)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "音乐", "音乐老师2", "初一(8)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(8)班", "体育", "体育老师2", "初一(8)", "北校区", "else", 1));

        //初一 9班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "语文", "语文老师6", "初一(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "数学", "数学老师6", "初一(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "英语", "英语老师6", "初一(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "物理", "物理老师5", "初一(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "化学", "化学老师5", "初一(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "历史", "历史老师5", "初一(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "政治", "政治老师5", "初一(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "微机", "微机老师2", "初一(9)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "音乐", "音乐老师2", "初一(9)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(9)班", "体育", "体育老师2", "初一(9)", "北校区", "else", 1));

        //初一 10班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "语文", "语文老师6", "初一(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "数学", "数学老师6", "初一(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "英语", "英语老师6", "初一(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "物理", "物理老师5", "初一(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "化学", "化学老师5", "初一(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "历史", "历史老师5", "初一(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "政治", "政治老师5", "初一(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "微机", "微机老师2", "初一(10)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "音乐", "音乐老师2", "初一(10)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 2, "初一(10)班", "体育", "体育老师2", "初一(10)", "北校区", "else", 1));

        //初二 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "语文", "语文老师7", "初二(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "数学", "数学老师7", "初二(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "英语", "英语老师7", "初二(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "物理", "物理老师6", "初二(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "化学", "化学老师6", "初二(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "历史", "历史老师6", "初二(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "政治", "政治老师6", "初二(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "微机", "微机老师3", "初二(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "音乐", "音乐老师3", "初二(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(1)班", "体育", "体育老师3", "初二(1)", "北校区", "else", 1));

        //初二 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "语文", "语文老师8", "初二(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "数学", "数学老师8", "初二(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "英语", "英语老师8", "初二(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "物理", "物理老师6", "初二(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "化学", "化学老师6", "初二(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "历史", "历史老师6", "初二(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "政治", "政治老师6", "初二(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "微机", "微机老师3", "初二(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "音乐", "音乐老师3", "初二(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(2)班", "体育", "体育老师3", "初二(2)", "北校区", "else", 1));

        //初二 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "语文", "语文老师8", "初二(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "数学", "数学老师8", "初二(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "英语", "英语老师8", "初二(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "物理", "物理老师7", "初二(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "化学", "化学老师7", "初二(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "历史", "历史老师7", "初二(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "政治", "政治老师7", "初二(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "微机", "微机老师3", "初二(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "音乐", "音乐老师3", "初二(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(3)班", "体育", "体育老师3", "初二(3)", "北校区", "else", 1));

        //初二 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "语文", "语文老师9", "初二(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "数学", "数学老师9", "初二(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "英语", "英语老师9", "初二(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "物理", "物理老师7", "初二(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "化学", "化学老师7", "初二(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "历史", "历史老师7", "初二(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "政治", "政治老师7", "初二(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "微机", "微机老师3", "初二(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "音乐", "音乐老师3", "初二(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(4)班", "体育", "体育老师3", "初二(4)", "北校区", "else", 1));

        //初二 5班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "语文", "语文老师10", "初二(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "数学", "数学老师10", "初二(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "英语", "英语老师10", "初二(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "物理", "物理老师8", "初二(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "化学", "化学老师8", "初二(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "历史", "历史老师8", "初二(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "政治", "政治老师8", "初二(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "微机", "微机老师3", "初二(5)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "音乐", "音乐老师3", "初二(5)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(5)班", "体育", "体育老师3", "初二(5)", "北校区", "else", 1));

        //初二 6班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "语文", "语文老师10", "初二(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "数学", "数学老师10", "初二(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "英语", "英语老师10", "初二(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "物理", "物理老师8", "初二(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "化学", "化学老师8", "初二(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "历史", "历史老师8", "初二(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "政治", "政治老师8", "初二(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "微机", "微机老师4", "初二(6)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "音乐", "音乐老师4", "初二(6)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(6)班", "体育", "体育老师4", "初二(6)", "北校区", "else", 1));

        //初二 7班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "语文", "语文老师11", "初二(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "数学", "数学老师11", "初二(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "英语", "英语老师11", "初二(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "物理", "物理老师9", "初二(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "化学", "化学老师9", "初二(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "历史", "历史老师9", "初二(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "政治", "政治老师9", "初二(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "微机", "微机老师4", "初二(7)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "音乐", "音乐老师4", "初二(7)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(7)班", "体育", "体育老师4", "初二(7)", "北校区", "else", 1));

        //初二 8班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "语文", "语文老师12", "初二(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "数学", "数学老师12", "初二(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "英语", "英语老师12", "初二(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "物理", "物理老师9", "初二(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "化学", "化学老师9", "初二(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "历史", "历史老师9", "初二(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "政治", "政治老师9", "初二(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "微机", "微机老师4", "初二(8)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "音乐", "音乐老师4", "初二(8)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(8)班", "体育", "体育老师4", "初二(8)", "北校区", "else", 1));

        //初二 9班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "语文", "语文老师12", "初二(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "数学", "数学老师12", "初二(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "英语", "英语老师12", "初二(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "物理", "物理老师10", "初二(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "化学", "化学老师10", "初二(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "历史", "历史老师10", "初二(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "政治", "政治老师10", "初二(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "微机", "微机老师4", "初二(9)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "音乐", "音乐老师4", "初二(9)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(9)班", "体育", "体育老师4", "初二(9)", "北校区", "else", 1));

        //初二 10班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "语文", "语文老师13", "初二(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "数学", "数学老师13", "初二(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "英语", "英语老师13", "初二(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "物理", "物理老师10", "初二(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "化学", "化学老师10", "初二(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "历史", "历史老师10", "初二(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "政治", "政治老师10", "初二(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "微机", "微机老师4", "初二(10)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "音乐", "音乐老师4", "初二(10)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 2, "初二(10)班", "体育", "体育老师4", "初二(10)", "北校区", "else", 1));

        //初三 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "语文", "语文老师14", "初三(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "数学", "数学老师14", "初三(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "英语", "英语老师14", "初三(1)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "物理", "物理老师11", "初三(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "化学", "化学老师11", "初三(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "历史", "历史老师11", "初三(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "政治", "政治老师11", "初三(1)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "微机", "微机老师5", "初三(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "音乐", "音乐老师5", "初三(1)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(1)班", "体育", "体育老师5", "初三(1)", "北校区", "else", 1));

        //初三 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "语文", "语文老师14", "初三(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "数学", "数学老师14", "初三(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "英语", "英语老师14", "初三(2)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "物理", "物理老师11", "初三(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "化学", "化学老师11", "初三(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "历史", "历史老师11", "初三(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "政治", "政治老师11", "初三(2)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "微机", "微机老师5", "初三(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "音乐", "音乐老师5", "初三(2)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(2)班", "体育", "体育老师5", "初三(2)", "北校区", "else", 1));

        //初三 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "语文", "语文老师15", "初三(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "数学", "数学老师15", "初三(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "英语", "英语老师15", "初三(3)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "物理", "物理老师12", "初三(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "化学", "化学老师12", "初三(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "历史", "历史老师12", "初三(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "政治", "政治老师12", "初三(3)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "微机", "微机老师5", "初三(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "音乐", "音乐老师5", "初三(3)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(3)班", "体育", "体育老师5", "初三(3)", "北校区", "else", 1));

        //初三 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "语文", "语文老师16", "初三(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "数学", "数学老师16", "初三(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "英语", "英语老师16", "初三(4)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "物理", "物理老师12", "初三(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "化学", "化学老师12", "初三(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "历史", "历史老师12", "初三(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "政治", "政治老师12", "初三(4)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "微机", "微机老师5", "初三(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "音乐", "音乐老师5", "初三(4)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(4)班", "体育", "体育老师5", "初三(4)", "北校区", "else", 1));

        //初三 5班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "语文", "语文老师16", "初三(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "数学", "数学老师16", "初三(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "英语", "英语老师16", "初三(5)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "物理", "物理老师13", "初三(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "化学", "化学老师13", "初三(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "历史", "历史老师13", "初三(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "政治", "政治老师13", "初三(5)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "微机", "微机老师5", "初三(5)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "音乐", "音乐老师5", "初三(5)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(5)班", "体育", "体育老师5", "初三(5)", "北校区", "else", 1));

        //初三 6班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "语文", "语文老师17", "初三(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "数学", "数学老师17", "初三(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "英语", "英语老师17", "初三(6)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "物理", "物理老师13", "初三(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "化学", "化学老师13", "初三(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "历史", "历史老师13", "初三(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "政治", "政治老师13", "初三(6)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "微机", "微机老师6", "初三(6)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "音乐", "音乐老师6", "初三(6)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(6)班", "体育", "体育老师6", "初三(6)", "北校区", "else", 1));

        //初三 7班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "语文", "语文老师18", "初三(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "数学", "数学老师18", "初三(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "英语", "英语老师18", "初三(7)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "物理", "物理老师14", "初三(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "化学", "化学老师14", "初三(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "历史", "历史老师14", "初三(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "政治", "政治老师14", "初三(7)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "微机", "微机老师6", "初三(7)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "音乐", "音乐老师6", "初三(7)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(7)班", "体育", "体育老师6", "初三(7)", "北校区", "else", 1));

        //初三 8班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "语文", "语文老师18", "初三(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "数学", "数学老师18", "初三(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "英语", "英语老师18", "初三(8)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "物理", "物理老师14", "初三(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "化学", "化学老师14", "初三(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "历史", "历史老师14", "初三(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "政治", "政治老师14", "初三(8)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "微机", "微机老师6", "初三(8)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "音乐", "音乐老师6", "初三(8)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(8)班", "体育", "体育老师6", "初三(8)", "北校区", "else", 1));

        //初三 9班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "语文", "语文老师19", "初三(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "数学", "数学老师19", "初三(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "英语", "英语老师19", "初三(9)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "物理", "物理老师15", "初三(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "化学", "化学老师15", "初三(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "历史", "历史老师15", "初三(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "政治", "政治老师15", "初三(9)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "微机", "微机老师6", "初三(9)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "音乐", "音乐老师6", "初三(9)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(9)班", "体育", "体育老师6", "初三(9)", "北校区", "else", 1));

        //初三 10班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "语文", "语文老师20", "初三(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "数学", "数学老师20", "初三(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "英语", "英语老师20", "初三(10)", "北校区", "major", 7));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "物理", "物理老师15", "初三(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "化学", "化学老师15", "初三(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "历史", "历史老师15", "初三(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "政治", "政治老师15", "初三(10)", "北校区", "minor", 4));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "微机", "微机老师6", "初三(10)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "音乐", "音乐老师6", "初三(10)", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2016", 2, "初三(10)班", "体育", "体育老师6", "初三(10)", "北校区", "else", 1));
        return courseInfoList;
    }*/

    /**
     * 生成一组CourseInfo
     * 论文数据
     * @return
     */
    public static Vector<AutoCourseInfo> generateCourseInfoList3() {
        Vector<AutoCourseInfo> courseInfoList = new Vector();

        //高一 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "语文", "语文老师1", "教学楼101", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "数学", "数学老师1", "教学楼101", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "英语", "英语老师1", "教学楼101", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "劳技", "劳技老师1", "教学楼101", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(1)班", "自习", "自习老师1", "教学楼101", "北校区", "else", 1));

        //高一 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "语文", "语文老师1", "教学楼102", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "数学", "数学老师1", "教学楼102", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "英语", "英语老师1", "教学楼102", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "劳技", "劳技老师1", "教学楼102", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(2)班", "自习", "自习老师2", "教学楼102", "北校区", "else", 1));

        //高一 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "语文", "语文老师2", "教学楼103", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "数学", "数学老师2", "教学楼103", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "英语", "英语老师2", "教学楼103", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "劳技", "劳技老师1", "教学楼103", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(3)班", "自习", "自习老师3", "教学楼103", "北校区", "else", 1));

        //高一 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "语文", "语文老师2", "教学楼104", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "数学", "数学老师2", "教学楼104", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "英语", "英语老师2", "教学楼104", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "劳技", "劳技老师1", "教学楼104", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2018", 1, "高一(4)班", "自习", "自习老师4", "教学楼104", "北校区", "else", 1));

        //高二 1班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "语文", "语文老师3", "教学楼105", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "数学", "数学老师3", "教学楼105", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "英语", "英语老师3", "教学楼105", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "劳技", "劳技老师1", "教学楼105", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(1)班", "自习", "自习老师5", "教学楼105", "北校区", "else", 1));

        //高二 2班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "语文", "语文老师3", "教学楼106", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "数学", "数学老师3", "教学楼106", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "英语", "英语老师3", "教学楼106", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "劳技", "劳技老师1", "教学楼106", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(2)班", "自习", "自习老师6", "教学楼106", "北校区", "else", 1));

        //高二 3班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "语文", "语文老师4", "教学楼107", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "数学", "数学老师4", "教学楼107", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "英语", "英语老师4", "教学楼107", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "劳技", "劳技老师1", "教学楼107", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(3)班", "自习", "自习老师7", "教学楼107", "北校区", "else", 1));

        //高二 4班
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "语文", "语文老师4", "教学楼108", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "数学", "数学老师4", "教学楼108", "北校区", "major", 6));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "英语", "英语老师4", "教学楼108", "北校区", "major", 5));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "体育", "体育老师1", "操场1区", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "劳技", "劳技老师1", "教学楼108", "北校区", "else", 1));
        courseInfoList.add(new AutoCourseInfo(StringUtils.generateID(), "2017", 1, "高二(4)班", "自习", "自习老师8", "教学楼108", "北校区", "else", 1));

        return courseInfoList;
    }
}
