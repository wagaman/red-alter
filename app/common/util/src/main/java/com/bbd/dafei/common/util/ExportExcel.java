package com.bbd.dafei.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:Excel导出工具类
 * author:liaohao
 * date:2017/2/20 0020 10:11.
 */
public class ExportExcel {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    /**
     * @param sheetTitle excel-sheet Name
     * @param jsonStr    数据字段名称
     * @param dataset    数据集合
     * @param pattern    转换日期类型的规则 (默认 "yyyy-MM-dd")
     * @return
     */
    public static HSSFWorkbook exportExcel(String sheetTitle, String jsonStr, List dataset,
                                           String pattern) {
        try {
            if (null == pattern) {
                pattern = "yyy-MM-dd";
            }
            // title集合
            List<String> titleStringList = new ArrayList<String>();
            // 列表字段集合
            List<String> fieldStringList = new ArrayList<String>();
            // 数据字段初始化
            init(jsonStr, titleStringList, fieldStringList);
            // 声明一个工作薄
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(sheetTitle);
            // 样式声明
            HSSFCellStyle headStyle = workbook.createCellStyle();
            HSSFCellStyle headStyleTitle = workbook.createCellStyle();
            HSSFCellStyle bodyStyle = workbook.createCellStyle();
            // 初始化各种样式
            initStyle(workbook, sheet, headStyle, headStyleTitle, bodyStyle);
            // 定义注释的大小和位置,详见文档 设置注释内容和表格标题行
            // setComment(patriarch);
            // 产生表格标题行
            HSSFRow row = sheet.createRow(0);
            int tilteNum = 0;
            for (String titleFor : titleStringList) {
//                HSSFCell cell = row.createCell(tilteNum);
                HSSFCell cell = row.createCell(tilteNum);
                cell.setCellStyle(headStyle);
                HSSFRichTextString text = new HSSFRichTextString(titleFor);
                cell.setCellValue(text);
                tilteNum++;
            }
            // 产生数据开始--遍历集合数据，产生数据行
            setExcelValue(pattern, fieldStringList, workbook, sheet, bodyStyle, dataset);
            // 返回excel文件 byte[]

            return workbook;
        } catch (Exception e) {
        }
        return null;

    }

    // 处理值到Excel中
    private static void setExcelValue(String pattern, List<String> fieldStringList,
                                      HSSFWorkbook workbook, HSSFSheet sheet,
                                      HSSFCellStyle headStyleTitle, Collection dataset) {
        Iterator<Object> it = dataset.iterator();
        HSSFRow row = null;
        int index = 0;
        HSSFFont font3 = workbook.createFont();
        // 内容颜色
        font3.setColor(HSSFColor.BLACK.index);
        font3.setFontName("微软雅黑");

        while (it.hasNext()) {
            index++;
            // 依次产生行
            row = sheet.createRow(index);
            // 获得改行所属对象
            Object t = it.next();
            // 根据配置json数组对象内容属性顺序--通过依次获取值-然后赋值
            int i = -1;
            for (String fieldFor : fieldStringList) {
                // 依次遍历一行中的单元格
                i++;
                // 获得一个单元格
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(headStyleTitle);
                String fieldName = fieldFor;
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    // 利用反射动态获取值
                    String textValue = getValue(pattern, t, getMethodName);
                    // 放值到单元格中
                    setValue(workbook, cell, textValue == null||textValue.equals("") ? "--":textValue, font3);

                } catch (Exception e){
                    throw  new RuntimeException(e);
                }
            }

        }
    }

    // 将值放入到单元格中
    private static void setValue(HSSFWorkbook workbook, HSSFCell cell, String textValue, HSSFFont font3) {
        if (null != textValue) {
            Pattern p = Pattern.compile("^//d+(//.//d+)?$");
            Matcher matcher = p.matcher(textValue);
            if (matcher.matches()) {
                try {
                    // 保留两位小数
                    cell.setCellValue(String.valueOf(decimalFormat.parse(textValue + "")));
                } catch (ParseException e) {
                }
            } else {
                HSSFRichTextString richString = new HSSFRichTextString(textValue);
                richString.applyFont(font3);
                cell.setCellValue(richString);
            }
        }
    }

    // 获取每个单元格需要放入的值-并且进行处理
    private static String getValue(String pattern, Object t,
                                   String getMethodName) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        Class tCls = t.getClass();
        Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
        Object value = getMethod.invoke(t, new Object[]{});
        //判断值的类型后进行强制类型转换
        String textValue = null;
        if (value instanceof Boolean) {
            Boolean bValue = (Boolean) value;
            textValue = bValue ? "是" : "否";
        } else if (value instanceof Date) {
            Date date = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            textValue = sdf.format(date);
        } else if (value instanceof byte[]) {
            // 有图片时，设置行高为60px;
            // setPicture(workbook, sheet, patriarch, row, index, i, (byte[]) value);
        } else {
            if (null == value) {
                textValue = "";
            } else {
                //其它数据类型都当作字符串简单处理
                textValue = value.toString();
            }
        }
        return textValue;
    }

    // 数据字段初始化
    private static void init(String jsonStr, List<String> titleStringList,
                             List<String> fieldStringList) {
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        Iterator iterator = jsonArray.iterator();
        // 遍历出初始化数据
        while (iterator.hasNext()) {
            JSONObject object = (JSONObject) iterator.next();
            // 取出列头
            titleStringList.add(object.get("value") + "");
            // 取出字段
            fieldStringList.add(object.get("key") + "");
        }
    }

    // 样式初始化
    private static void initStyle(HSSFWorkbook workbook, HSSFSheet sheet, HSSFCellStyle headStyle,
                                  HSSFCellStyle headStyleTitle, HSSFCellStyle bodyStyle) {
        sheet.setDefaultColumnWidth(30);
        // 表头样式设置
        headStyle.setFillBackgroundColor((short) 4);
        headStyle.setBorderBottom((short) 1);
        headStyle.setBorderLeft((short) 1);
        headStyle.setBorderRight((short) 1);
        headStyle.setBorderTop((short) 1);
        headStyle.setWrapText(true);
        headStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        headStyle.setLocked(false);
        // 字体设置
        HSSFFont font = workbook.createFont();
        font.setColor((short) 8);
        font.setFontHeightInPoints((short) 10);
        font.setFontName("宋体");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        headStyle.setFont(font);

        // 内容样式设置
        bodyStyle.setLocked(false);
        bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        font2.setFontName("宋体");
        // 把字体应用到当前的样式
        bodyStyle.setFont(font2);

    }

    // 定义注释的大小和位置,详见文档 设置注释内容和表格标题行
    private static void setComment(HSSFPatriarch patriarch) {
        HSSFComment comment = patriarch
                .createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("system");
    }

    // 处理图片
    private static void setPicture(HSSFWorkbook workbook, HSSFSheet sheet, HSSFPatriarch patriarch,
                                   HSSFRow row, int index, short i, byte[] value) {
        row.setHeightInPoints(60);
        // 设置图片所在列宽度为80px,注意这里单位的一个换算
        sheet.setColumnWidth(i, (short) (35.7 * 80));
        // sheet.autoSizeColumn(i);
        byte[] bsValue = value;
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6,
                index);
        anchor.setAnchorType(2);
        patriarch.createPicture(anchor,
                workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
    }

}
