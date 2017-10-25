package com.bbd.dafei.biz.shared;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tuanhong on 2017-05-22.
 */
public interface CaptureImgService {
    String captureImg(HttpServletRequest re, String url, String size) throws Exception;
}
