package com.bbd.dafei.web.util;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.io.IOException;

/**
 * description:
 * author:liaohao
 * date:2017/4/24 0024 17:56.
 */
public class PdfUtil {

    /**
     * 创建PDF文本样式
     *
     * @param baseFont
     * @param fontSize
     * @param isBold
     * @param isUnderline
     * @return
     */
    public static Font createFont(BaseFont baseFont, int fontSize, boolean isBold,
                                  boolean isUnderline) {
        Font font = new Font(baseFont);
        font.setSize(fontSize);
        if (isBold)
            font.setStyle(Font.BOLD);
        else
            font.setStyle(Font.NORMAL);
        if (isUnderline)
            font.setStyle(Font.UNDERLINE);
        return font;
    }

    /**
     * 创建PDF文本样式
     *
     * @param baseFont
     * @param fontSize
     * @param isBold
     * @param isUnderline
     * @param baseColor
     * @return
     */
    public static Font createFont(BaseFont baseFont, int fontSize, boolean isBold,
                                  boolean isUnderline, BaseColor baseColor) {
        Font font = new Font(baseFont);
        font.setSize(fontSize);
        if (isBold)
            font.setStyle(Font.BOLD);
        else
            font.setStyle(Font.NORMAL);
        if (isUnderline)
            font.setStyle(Font.UNDERLINE);
        font.setColor(baseColor);
        return font;
    }

    /**
     * 创建段落
     *
     * @param content
     * @param font
     * @param alignment
     * @param before
     * @param after
     * @return
     */
    public static Paragraph createParagraph(String content, Font font, int alignment, float before,
                                            float after) {
        return createParagraph(content, font, alignment, 0, before, after);
    }

    public static Paragraph createParagraph(String content, Font font, int alignment, float leading,
                                            float before, float after) {
        Paragraph paragraph = new Paragraph(content, font);
        paragraph.setAlignment(alignment);
        if (Math.abs(leading) > 0) {
            paragraph.setLeading(leading);
        }
        if (Math.abs(before) > 0) {
            paragraph.setSpacingBefore(before);
        }
        if (Math.abs(after) > 0) {
            paragraph.setSpacingAfter(after);
        }
        return paragraph;
    }

    /**
     * 写PDF内容
     *
     * @param baseFont
     * @param doc
     * @param title
     * @throws Exception
     */
    public static void writeContent(BaseFont baseFont, Document doc,
                                    String title) throws Exception {
        // TODO: 2016/9/29 静态工具方法中，只返回创建的内容，不直接添加到 doc 上面

        // TODO: 2016/9/29   公司AAAAA
        String content = "公司AAAAA";
        if (!StringUtils.isEmpty(content)) {
            Font f_title = createFont(baseFont, 16, true, true);
            Paragraph p_title = createParagraph(title, f_title, Label.LEFT, 0, 15);
            doc.add(p_title);
            Font f_content = createFont(baseFont, 14, false, false);
            // TODO: 2016/9/29   公司AAAAA
            Paragraph p_content = createParagraph("公司AAAAA", f_content, Label.LEFT, 0, 15);
            p_content.setLeading(20); // 段落间隔
            doc.add(p_content);
        }
    }

    //    public static PdfPTable createTable(Document doc, BaseFont baseFont, Map<String, String> datas) throws DocumentException {
    //        PdfPTable table = new PdfPTable(2);
    //        Font fContent = createFont(baseFont, 16, true, true);
    //        for (Map.Entry<String, String> element : datas.entrySet()) {
    //            table.addCell(createParagraph(element.getKey(), fContent, Label.CENTER, 0, 0));
    //            table.addCell(createParagraph(element.getValue(), fContent, Label.CENTER, 0, 0));
    //        }
    //        return table;
    //    }

    public static PdfPTable createImage(Document doc, String imgPath) throws IOException,
            BadElementException {
        com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imgPath);
        float scaler = ((doc.getPageSize().getWidth() - doc.leftMargin() - doc.rightMargin() - 10f)
                / image.getWidth())
                * 100;
        image.scalePercent(scaler);
        PdfPCell cell = new PdfPCell(image, true);
        cell.setBorder(0);
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.addCell(cell);
        return table;
    }

    public static PdfPTable createTable(Document doc, Font font,
                                        java.util.List<java.util.List<String>> datas) throws DocumentException {
        return createTable(doc, font, false, datas);
    }

    public static PdfPTable createTable(Document doc, Font font, boolean hasHeader,
                                        java.util.List<java.util.List<String>> datas) throws DocumentException {
        if (datas == null || datas.size() == 0) {
            return new PdfPTable(1);
        }
        PdfPTable table = new PdfPTable(datas.get(0).size());
        if (true == hasHeader) {
            table.setHeaderRows(1);
        }
        table.setWidthPercentage(100);
        for (java.util.List list : datas) {
            for (Object element : list) {
                PdfPCell cell = new PdfPCell(createParagraph(String.valueOf(element), font, Element.ALIGN_CENTER, 20f, 0, 0));
                cell.setPaddingLeft(8f);
                cell.setPaddingRight(7f);
                cell.setPaddingTop(1f);
                cell.setPaddingBottom(11f);
                cell.setLeading(0f, 2f);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
                table.addCell(cell);

            }
        }
        return table;
    }

    public static PdfPTable createTable(Document doc, Font font,
                                        java.util.List<java.util.List<String>> datas,
                                        int[] width) throws DocumentException {
        return createTable(doc, font, false, datas, width);
    }

    /**
     * @param doc
     * @param font
     * @param datas
     * @param widthInfo  设置每个单元格显示比例 exp:int[1,2,3] 第一个单元格显示1/6,第二个单元格显示1/3,第三个单元格显示1/2
     * @param mergedInfo 设置合并单元格信息 exp:int{1,2,3} 表示 在第一笔资料的 第二列 执行合并单元格，合并数量3
     * @return
     * @throws DocumentException
     */
    public static PdfPTable createTable(Document doc, Font font,
                                        java.util.List<java.util.List<String>> datas,
                                        int[] widthInfo, int[] mergedInfo) throws DocumentException {
        return createTable(doc, font, false, datas, widthInfo, mergedInfo);
    }

    public static PdfPTable createTable(Document doc, Font font, boolean hasHeader,
                                        java.util.List<java.util.List<String>> datas,
                                        int[] widths) throws DocumentException {
        if (datas == null || datas.size() == 0) {
            return new PdfPTable(1);
        }
        PdfPTable table = new PdfPTable(datas.get(0).size());
        if (true == hasHeader) {
            table.setHeaderRows(1);
        }
//        table.setWidths(new int[] { width / 3, width * 2 / 3 });
        table.setWidths(new int[]{widths[0], widths[1]});
        //        table.setLockedWidth(true);

        table.setWidthPercentage(100);
        for (java.util.List list : datas) {
            for (Object element : list) {
                PdfPCell cell = new PdfPCell(
                        createParagraph(String.valueOf(element), font, Element.ALIGN_CENTER, 0, 0, 0));
                cell.setPaddingLeft(8f);
                cell.setPaddingRight(7f);
                cell.setPaddingTop(1f);
                cell.setPaddingBottom(11f);
                cell.setLeading(0f, 2f);
                table.addCell(cell);

            }
        }
        return table;
    }

    public static PdfPTable createTable(Document doc, Font font, boolean hasHeader,
                                        java.util.List<java.util.List<String>> datas,
                                        int[] widthInfo, int[] mergedInfo) throws DocumentException {

        if (datas == null || datas.size() == 0) {
            return new PdfPTable(1);
        }
        PdfPTable table = new PdfPTable(datas.get(0).size());
        if (true == hasHeader) {
            table.setHeaderRows(1);
        }
        //设置每个单元格显示比例 exp:int[1,2,3] 第一个单元格显示1/6,第二个单元格显示1/3,第三个单元格显示1/2
        table.setWidths(widthInfo);
        //设置table在页面上的显示百分比
        table.setWidthPercentage(100);

        //当前资料是LIST当中的第几笔资料，默认为第一笔
        int nowDataNumber = 1;
        //是否已执行单元格合并 默认：false
        boolean haveMerged = false;
        //执行合并单元格过后的第N笔资料 默认：0
        int haveMergedNumber = 0;

        //循环每一笔资料
        for (java.util.List list : datas) {
            //是否执行合并单元格参数 默认false
            boolean merged = false;
            //要合并资料的位置 等于 当前资料在LIST的位置，则是否合并单元格 参数设为：true
            if (mergedInfo[0] == nowDataNumber) {
                merged = true;
            }
            //每笔资料的列，默认为第一列
            int cellNumber = 1;

            //循环当前资料的每一列
            for (Object element : list) {
                /*
                * 如果已经执行了合并  并且 执行合并单元格过后的第N笔资料 小于合并单元格的数量时，空白部分不处理
                * exp:合并单元格数量为3，合并时 执行合并单元格过后的资料为第1笔，那么往下2笔资料当中的空白部分都不在生成列
                * */
                if (haveMerged && haveMergedNumber < mergedInfo[2]) {
                    if (element != null && !element.equals("")) {
                        PdfPCell cell = new PdfPCell(createParagraph(String.valueOf(element), font, Element.ALIGN_CENTER, 0, 0, 0));
                        cell.setPaddingLeft(8f);
                        cell.setPaddingRight(7f);
                        cell.setPaddingTop(1f);
                        cell.setPaddingBottom(11f);
                        cell.setLeading(0f, 2f);
                        table.addCell(cell);
                    }
                } else {//还没有执行过单元格合并，或者执行后 循环次数没有到
                    PdfPCell cell = new PdfPCell(
                            createParagraph(String.valueOf(element), font, Element.ALIGN_CENTER, 0, 0, 0));
                    cell.setPaddingLeft(8f);
                    cell.setPaddingRight(7f);
                    cell.setPaddingTop(1f);
                    cell.setPaddingBottom(11f);
                    cell.setLeading(0f, 2f);

                    if (merged) {//需要执行合并单元格的资料位置
                        if (cellNumber == mergedInfo[1]) { //且为执行合并单元格列的位置
                            //执行合并
                            cell.setRowspan(mergedInfo[2]);
                            //是否已执行合并单元格 变为true
                            haveMerged = true;
                        }
                    }
                    table.addCell(cell);
                }
                //当前笔资料的列数 +1
                cellNumber++;
            }
            //每笔资料的每一列循环完毕后，判断如果已执行过单元格合并，那么当前笔算是 执行合并单元格过后的第1笔资料 默认：0
            if (haveMerged) {
                haveMergedNumber++;
            }
            //循环资料+1
            nowDataNumber++;
        }
        return table;

//                if(haveMerged && haveMergedNumber <mergedInfo[2]){
//                    if(element != null && !element.equals("")){
//                        PdfPCell cell = new PdfPCell(createParagraph(String.valueOf(element), font, Element.ALIGN_CENTER, 0, 0, 0));
//                        cell.setPaddingLeft(8f);
//                        cell.setPaddingRight(7f);
//                        cell.setPaddingTop(1f);
//                        cell.setPaddingBottom(11f);
//                        cell.setLeading(0f, 2f);
//                        if(merged){
//                            if(cellNumber == mergedInfo[1]){
//                                cell.setRowspan(mergedInfo[2]);
//                                haveMerged = true;
//                            }
//                        }
//                        table.addCell(cell);
//                    }
//                }else{
//                    PdfPCell cell = new PdfPCell(
//                            createParagraph(String.valueOf(element), font, Element.ALIGN_CENTER, 0, 0, 0));
//                    cell.setPaddingLeft(8f);
//                    cell.setPaddingRight(7f);
//                    cell.setPaddingTop(1f);
//                    cell.setPaddingBottom(11f);
//                    cell.setLeading(0f, 2f);
//                    if(merged){
//                        if(cellNumber == mergedInfo[1]){
//                            cell.setRowspan(mergedInfo[2]);
//                            haveMerged = true;
//                        }
//                    }
//                    table.addCell(cell);
//                }
//                cellNumber ++;
//            }


//            if(haveMerged){
//                haveMergedNumber ++;
//            }
//            nowDataNumber ++;
//        }
//        return table;
    }

}
