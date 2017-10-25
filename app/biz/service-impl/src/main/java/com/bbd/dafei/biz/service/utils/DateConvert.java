package com.bbd.dafei.biz.service.utils;


import com.bbd.dafei.common.exception.CommonException;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局日期处理类
 * Convert<T,S>
 *         泛型T:代表客户端提交的参数 String
 *         泛型S:通过convert转换的类型
 * @author Ian.Su
 * @version $Id: DateConvert.java, v 0.1 2017/5/27 15:33 Ian.Su Exp $
 */
public class DateConvert implements Converter<String, Date> {

    Logger logger = LoggerFactory.getLogger(DateConvert.class);

    @Override
    public Date convert(String stringDate) {

        try {
            return DateUtils.parseDate(stringDate,"yyyy-MM-dd","yyyyMMdd","yyyy/MM/dd");
        } catch (ParseException e) {
            logger.error(e.getMessage(),e);
            throw new CommonException("日期转换出错");
        }

    }

}