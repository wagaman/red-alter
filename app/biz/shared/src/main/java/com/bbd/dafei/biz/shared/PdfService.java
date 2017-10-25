package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.dal.po.UserPO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tuanhong on 2017-05-03.
 */
public interface PdfService {

    /**
     * 获取pdf下载地址
     *
     * @return
     */
    String getPdfUrl(String companyId, String companyName, UserPO userPO);

    /**
     * 取得PDF所需要的资料
     */
//    Map<String,Object> getDataForPdf(String company,String username,String province) throws  Exception;

    void makesPdf(HttpServletRequest request, HttpServletResponse response, String companyId, String companyName, UserPO userPO);
}
