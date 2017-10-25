package com.bbd.dafei.web.util;


import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * description:
 * author:liaohao
 * date:2017/4/24 0024 17:35.
 */
public class PdfHeaderFooterUtil extends PdfPageEventHelper {

    Logger logger = LoggerFactory.getLogger(PdfHeaderFooterUtil.class);

    protected String      footer;
    protected PdfTemplate total;
    protected BaseFont    baseFont;
    protected String      domain;

    public PdfHeaderFooterUtil(BaseFont baseFont, String domain) {
        this.baseFont = baseFont;
        this.domain = domain;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
    public void onEndPage(PdfWriter writer, Document document) {
        try {

            int page = writer.getPageNumber();
            if(page != 1) {
                if (page <= 3) {
                    PdfPCell cell = new PdfPCell(new Paragraph(String.valueOf(writer.getPageNumber()), new Font(baseFont, 10, Font.NORMAL)));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setBorder(0);
                    PdfPTable footer = new PdfPTable(1);
                    footer.addCell(cell);
                    footer.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());
                    footer.writeSelectedRows(0, -1, 1, 45, writer.getDirectContent());
                } else {
                    PdfPCell cell = new PdfPCell(new Paragraph(String.valueOf(writer.getPageNumber() - 3), new Font(baseFont, 10, Font.NORMAL)));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setBorder(0);
                    PdfPTable footer = new PdfPTable(1);
                    footer.addCell(cell);
                    footer.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());
                    footer.writeSelectedRows(0, -1, 1, 45, writer.getDirectContent());

                    PdfPCell cell1 = new PdfPCell(new Paragraph(String.valueOf("BBD 监管科技风险全息报告（基础版）\n\n"), new Font(baseFont, 10, Font.NORMAL)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBorder(0);
                    cell1.setBorder(PdfPCell.BOTTOM);

                    PdfPTable header = new PdfPTable(1);
                    header.addCell(cell1);
                    header.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());
                    header.writeSelectedRows(0, -1, 50, 830, writer.getDirectContent());
                    Image image = null;
                    try {
                        image = Image.getInstance(this.getClass().getClassLoader().getResource("/pdf/img/waterMaker.png"));
                        image.setAlignment(Image.UNDERLYING);
                        image.scaleAbsolute(500, 800);
                        image.setAbsolutePosition(50, 10);
                        document.add(image);
                    } catch (Exception e) {
                        logger.error(e.getMessage(),e);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

}
