package com.bbd.dafei.biz.shared;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by tuanhong on 2017-05-23.
 */
public interface WordService {
    /**
     *
     * @param out
     * @param companyName
     */
    void createWord(HttpServletRequest req,ServletOutputStream out, String companyName, String companyId, String index, String indexBottom, String reportImg,String backCoverImage);
}
