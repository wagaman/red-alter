package com.bbd.dafei.common.util;

import org.apache.commons.lang.time.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wish on 2017/5/3.
 */
public class CommonUtil {
    /**
     * 返回传入时间的第二天凌晨
     *
     * @param date
     * @return
     */
    public static Date getNextDayWithoutHour(Date date) {
        return DateUtils.truncate(DateUtils.addDays(date, 1), Calendar.DATE);//第二天凌晨
    }

    /**
     * 取得下载文件名
     *
     * @param fileName
     * @param req
     * @return
     * @throws Exception
     */
    public static String getFileName(String fileName, HttpServletRequest req) throws Exception {
        String agent = getBrowserName(req.getHeader("User-Agent").toLowerCase());
        if (agent.equals("Firefox")) {
            return new String(fileName.getBytes("utf-8"), "iso-8859-1");
        } else {
            return java.net.URLEncoder.encode(fileName, "UTF-8");
        }
    }

    /**
     * 取得浏览器类型
     *
     * @param agent
     * @return
     */
    private static String getBrowserName(String agent) {
        if (agent.indexOf("firefox") > 0) {
            return "Firefox";
        } else {
            return "Others";
        }
    }

    /**
     * 判断行业是否是新兴金融
     * @param industry
     * @return
     */
    public static boolean isNewFinance(String industry) {
        if(industry == null) {
            return false;
        }
        return Constants.COMPANY_INDUSTRY_P2P.equals(industry)
                || Constants.COMPANY_INDUSTRY_TRADING_PLACE.equals(industry)
                || Constants.COMPANY_INDUSTRY_PRIVATE_EQUIT.equals(industry)
                || Constants.COMPANY_INDUSTRY_EMERGING_FINANCE.equals(industry)
                || Constants.COMPANY_INDUSTRY_PETTY_LOAN.equals(industry)
                || Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE.equals(industry);
    }
}
