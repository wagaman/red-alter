package com.bbd.dafei.web.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * description:
 * author:liaohao
 * date:2017/4/24 0024 17:58.
 */
public class ImageBackgroundEvent implements PdfPCellEvent {
    protected Image image;

    public ImageBackgroundEvent(Image image) {
        this.image = image;
    }

    @Override

    public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
        try {
            PdfContentByte cb = canvases[PdfPTable.BACKGROUNDCANVAS];
            image.scaleAbsolute(position);
            image.setAbsolutePosition(position.getLeft(), position.getBottom());
            cb.addImage(image);
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }
}
