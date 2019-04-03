package TestTools;

import com.github.arrange.model.AutoCourseInfo;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ExportUtils {

    /**
     * 导出课表（临时，正式项目无需此方法）
     * @param individual
     * @param courseInfoMap
     * @param name
     */
    public static void exportIndividual(ConcurrentHashMap<String, ConcurrentHashMap<String, Vector<String>>> individual, ConcurrentHashMap<String, AutoCourseInfo> courseInfoMap, String name) {

        Consumer<HSSFRow> createWeekdayCell = (row) -> {
            row.createCell(1);
            row.createCell(2);
            row.createCell(3);
            row.createCell(4);
            row.createCell(5);
        };

        HSSFWorkbook wb = new HSSFWorkbook();

        individual.entrySet().stream().forEach(oneClass -> {
            HSSFSheet sheet = wb.createSheet(oneClass.getKey());
            sheet.setDefaultColumnWidth(15);

            //创建表头
            HSSFRow row = sheet.createRow(0);
            row.createCell(0);
            row.createCell(1).setCellValue("周一");
            row.createCell(2).setCellValue("周二");
            row.createCell(3).setCellValue("周三");
            row.createCell(4).setCellValue("周四");
            row.createCell(5).setCellValue("周五");

            //表格内容初始值
            row = sheet.createRow(1);
            row.createCell(0).setCellValue("上第一节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(2);
            row.createCell(0).setCellValue("上第二节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(3);
            row.createCell(0).setCellValue("上第三节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(4);
            row.createCell(0).setCellValue("上第四节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(5);
            row.createCell(0).setCellValue("上第五节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(6);
            row.createCell(0).setCellValue("下第一节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(7);
            row.createCell(0).setCellValue("下第二节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(8);
            row.createCell(0).setCellValue("下第三节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(9);
            row.createCell(0).setCellValue("下第四节");
            createWeekdayCell.accept(row);

            row = sheet.createRow(10);
            row.createCell(0).setCellValue("下第五节");
            createWeekdayCell.accept(row);

            //时段对应CourseInfo的map
            Map<String, String> hourCourseInfo = new HashMap<>();
            oneClass.getValue().entrySet().stream().forEach(entry -> {
                entry.getValue().stream().forEach(oneHour -> {
                    hourCourseInfo.put(oneHour, entry.getKey());
                });
            });

            //设置换行
            HSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setWrapText(true);

            //周一上午
            if (hourCourseInfo.containsKey("0-1-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-1-0"));
                sheet.getRow(1).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(1).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-1-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-1-1"));
                sheet.getRow(2).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(2).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-1-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-1-2"));
                sheet.getRow(3).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(3).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-1-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-1-3"));
                sheet.getRow(4).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(4).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-1-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-1-4"));
                sheet.getRow(5).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(5).getCell(1).setCellStyle(cellStyle);
            }

            //周一下午
            if (hourCourseInfo.containsKey("0-3-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-3-0"));
                sheet.getRow(6).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(6).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-3-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-3-1"));
                sheet.getRow(7).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(7).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-3-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-3-2"));
                sheet.getRow(8).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(8).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-3-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-3-3"));
                sheet.getRow(9).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(9).getCell(1).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("0-3-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("0-3-4"));
                sheet.getRow(10).getCell(1).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(10).getCell(1).setCellStyle(cellStyle);
            }

            //周二上午
            if (hourCourseInfo.containsKey("1-1-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-1-0"));
                sheet.getRow(1).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(1).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-1-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-1-1"));
                sheet.getRow(2).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(2).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-1-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-1-2"));
                sheet.getRow(3).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(3).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-1-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-1-3"));
                sheet.getRow(4).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(4).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-1-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-1-4"));
                sheet.getRow(5).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(5).getCell(2).setCellStyle(cellStyle);
            }

            //周二下午
            if (hourCourseInfo.containsKey("1-3-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-3-0"));
                sheet.getRow(6).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(6).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-3-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-3-1"));
                sheet.getRow(7).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(7).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-3-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-3-2"));
                sheet.getRow(8).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(8).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-3-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-3-3"));
                sheet.getRow(9).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(9).getCell(2).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("1-3-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("1-3-4"));
                sheet.getRow(10).getCell(2).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(10).getCell(2).setCellStyle(cellStyle);
            }

            //周三上午
            if (hourCourseInfo.containsKey("2-1-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-1-0"));
                sheet.getRow(1).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(1).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-1-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-1-1"));
                sheet.getRow(2).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(2).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-1-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-1-2"));
                sheet.getRow(3).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(3).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-1-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-1-3"));
                sheet.getRow(4).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(4).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-1-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-1-4"));
                sheet.getRow(5).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(5).getCell(3).setCellStyle(cellStyle);
            }

            //周三下午
            if (hourCourseInfo.containsKey("2-3-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-3-0"));
                sheet.getRow(6).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(6).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-3-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-3-1"));
                sheet.getRow(7).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(7).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-3-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-3-2"));
                sheet.getRow(8).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(8).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-3-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-3-3"));
                sheet.getRow(9).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(9).getCell(3).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("2-3-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("2-3-4"));
                sheet.getRow(10).getCell(3).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(10).getCell(3).setCellStyle(cellStyle);
            }

            //周四上午
            if (hourCourseInfo.containsKey("3-1-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-1-0"));
                sheet.getRow(1).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(1).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-1-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-1-1"));
                sheet.getRow(2).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(2).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-1-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-1-2"));
                sheet.getRow(3).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(3).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-1-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-1-3"));
                sheet.getRow(4).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(4).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-1-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-1-4"));
                sheet.getRow(5).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(5).getCell(4).setCellStyle(cellStyle);
            }

            //周四下午
            if (hourCourseInfo.containsKey("3-3-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-3-0"));
                sheet.getRow(6).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(6).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-3-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-3-1"));
                sheet.getRow(7).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(7).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-3-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-3-2"));
                sheet.getRow(8).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(8).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-3-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-3-3"));
                sheet.getRow(9).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(9).getCell(4).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("3-3-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("3-3-4"));
                sheet.getRow(10).getCell(4).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(10).getCell(4).setCellStyle(cellStyle);
            }

            //周五上午
            if (hourCourseInfo.containsKey("4-1-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-1-0"));
                sheet.getRow(1).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(1).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-1-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-1-1"));
                sheet.getRow(2).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(2).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-1-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-1-2"));
                sheet.getRow(3).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(3).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-1-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-1-3"));
                sheet.getRow(4).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(4).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-1-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-1-4"));
                sheet.getRow(5).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(5).getCell(5).setCellStyle(cellStyle);
            }

            //周五下午
            if (hourCourseInfo.containsKey("4-3-0")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-3-0"));
                sheet.getRow(6).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(6).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-3-1")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-3-1"));
                sheet.getRow(7).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(7).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-3-2")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-3-2"));
                sheet.getRow(8).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(8).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-3-3")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-3-3"));
                sheet.getRow(9).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(9).getCell(5).setCellStyle(cellStyle);
            }
            if (hourCourseInfo.containsKey("4-3-4")) {
                AutoCourseInfo courseInfo = courseInfoMap.get(hourCourseInfo.get("4-3-4"));
                sheet.getRow(10).getCell(5).setCellValue(new HSSFRichTextString(courseInfo.getSubjectId() + "\r\n" + courseInfo.getTeacherId() + "\r\n" + courseInfo.getClassroomId()));
                sheet.getRow(10).getCell(5).setCellStyle(cellStyle);
            }

        });

        try {
            String fileName = "D:/" + name + ".xls";
            FileOutputStream fout = new FileOutputStream(fileName);
            wb.write(fout);
            fout.close();
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
