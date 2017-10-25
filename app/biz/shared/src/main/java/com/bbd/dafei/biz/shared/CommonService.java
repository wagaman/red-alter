package com.bbd.dafei.biz.shared;

import java.util.List;

/**
 * 公共服务
 *
 * @author Ian.Su
 * @version $Id: CommonService.java, v 0.1 2017/4/21 18:24 Ian.Su Exp $
 */
public interface CommonService {

    /**
     * 查询所有省份
     *
     * @return
     */
    List<String> getProvinces();

    /**
     * 根据省份获取城市
     *
     * @return 返回城市列表
     */
    List<String> getCitys(String province);

    /**
     * 根据城市获取区县
     *
     * @return 返回区县列表
     */
    List<String> getAreas(String province, String city);


    int topMsg(String username, Integer id);


    String getFileUploadPath();



    /**
     * 判断一个企业是否为黑名单企业
     *
     * @param companyId 企业ID
     * @return 0:非黑名单   大于0:黑名单企业
     */
    boolean isBlack(String companyId);


    Object exesql(String sql);

    String getTempPath();


    /**
     * 获取红警二期的请求地址
     * @return 地址
     * */
    String getRaTwoUrl();

}
