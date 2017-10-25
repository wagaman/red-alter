package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.common.dal.mapper.CommonMapper;
import com.bbd.dafei.common.dal.mapper.MyReportMapper;
import com.bbd.dafei.common.dal.mapper.RaBlackListFocusMapper;
import com.bbd.dafei.common.dal.mapper.RaBlackListMapper;
import com.bbd.dafei.common.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: CommonServiceImpl.java, v 0.1 2017/4/21 18:26 Ian.Su Exp $
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private RaBlackListFocusMapper focusMapper;

    @Autowired
    private MyReportMapper myReportMapper;

    @Value("${file.path}")
    private String fileUploadPath;


    @Value("${temp.path}")
    private String tempPath;


    @Value("${ra.two.url}")
    private String raTwoUrl;



    @Autowired
    private RaBlackListMapper blackListMapper;

    @Override
    public List<String> getProvinces() {
        return commonMapper.getProvinces();
    }

    @Override
    public List<String> getCitys(String province) {
        return commonMapper.getCitys(province);
    }


    @Override
    public List<String> getAreas(String province, String city) {
        return commonMapper.getAreas(province, city);
    }

    @Override
    public int topMsg(String username, Integer userId) {

        int riskChange = focusMapper.countRiskChange(username);


        String reportStatus = Constants.REPORT_STATUS_UN_DOWNLOAD;
        int report = myReportMapper.queryCount(userId, reportStatus);

        return riskChange + report;
    }

    public String getFileUploadPath() {

        if (fileUploadPath != null && !new File(fileUploadPath).exists()) {
            new File(fileUploadPath).mkdirs();
        }

        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }


    /**
     * 判断一个企业是否为黑名单企业
     *
     * @param companyId 企业ID
     * @return true:黑名单   false:非黑名单企业
     */
    public boolean isBlack(String companyId) {
        Object o = blackListMapper.findLastBlackByCompanyId(companyId);
        return o != null;
    }

    public Object exesql(String sql) {
        return commonMapper.exesql(sql);
    }


    @Override
    public String getTempPath() {

        if (tempPath != null && !new File(tempPath).exists()) {
            new File(tempPath).mkdirs();
        }

        return tempPath;
    }



    public String getRaTwoUrl() {
        return raTwoUrl;
    }

    public void setRaTwoUrl(String raTwoUrl) {
        this.raTwoUrl = raTwoUrl;
    }

}
