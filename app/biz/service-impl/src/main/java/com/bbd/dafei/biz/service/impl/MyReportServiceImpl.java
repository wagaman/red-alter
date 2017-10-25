package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.MyReportService;
import com.bbd.dafei.common.dal.mapper.MyReportMapper;
import com.bbd.dafei.common.dal.mapper.RaBlackListMapper;
import com.bbd.dafei.common.modal.vo.MyReportListVO;
import com.bbd.dafei.common.modal.vo.MyReportPageInfoListVO;
import com.bbd.dafei.common.util.Paging;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuanhong on 2017-04-24.
 */
@Service
public class MyReportServiceImpl implements MyReportService {
    @Autowired
    private MyReportMapper myReportMapper;

    @Autowired
    private RaBlackListMapper raBlackListMapper;

    @Override
    public Paging<MyReportPageInfoListVO> query(int userId, String username,Integer start, Integer size) throws Exception {

        int count = myReportMapper.count(userId);

        Paging<MyReportPageInfoListVO> paging = new Paging<>();

        paging.setCount(count);

        paging.setSize(size);

        paging.setStart(start);

        if(count == 0){
            return paging;
        }

        List<MyReportListVO> myReportListVOS = myReportMapper.query(userId, start, size);
        List<MyReportPageInfoListVO> myReportPageInfoListVOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(myReportListVOS)){
            for(MyReportListVO data : myReportListVOS){
                MyReportPageInfoListVO myReportPageInfoListVO = new MyReportPageInfoListVO();
                //用户Id
                myReportPageInfoListVO.setUserId(data.getUserId());
                //企业ID
                myReportPageInfoListVO.setCompanyId(data.getCompanyId());
                //企业名称
                myReportPageInfoListVO.setCompany(data.getCompany());
                //省份
                myReportPageInfoListVO.setProvince(data.getProvince());
                //市
                myReportPageInfoListVO.setCity(data.getCity());
                //区县
                myReportPageInfoListVO.setArea(data.getArea());
                //易燃指数
                myReportPageInfoListVO.setRiskIndex(data.getRiskIndex());
                //风险等级
                myReportPageInfoListVO.setRiskLevel(data.getRiskLevel());
                //易燃指数是否上升  1:上升，0：持平，-1：下降
                myReportPageInfoListVO.setRise(data.getRise());
               //所属行业
                myReportPageInfoListVO.setIndustry(data.getIndustry());
               //简报下载日期
                myReportPageInfoListVO.setDownloadTime(data.getDownloadTime());
                //研报申请日期
                myReportPageInfoListVO.setApplyTime(data.getApplyTime());
                //研报申请状态
                myReportPageInfoListVO.setReportStatus(data.getReportStatus());
                //是否黑名单企业
                /*根据企业id,用户名 查看是否存在黑名单里面 如果存在 则为true,没有存在则为false*/
                int dataNumber = raBlackListMapper.findDataByAddUserAndCompanyIdForPersonalCenter(data.getCompanyId());
                if(dataNumber > 0){
                    myReportPageInfoListVO.setBackList(true);
                }else{
                    myReportPageInfoListVO.setBackList(false);
                }

                //研报申请ID
                myReportPageInfoListVO.setReportId(data.getReportId());

                myReportPageInfoListVOS.add(myReportPageInfoListVO);
            }
        }
        paging.setRecords(myReportPageInfoListVOS);

        return paging;
    }

    @Override
    public int queryCount(int userId, String reportStatus) {
        return myReportMapper.queryCount(userId,reportStatus);
    }

    @Override
    public String getApplyTime(int userId, String companyId, String reportStatus) {
        return myReportMapper.getApplyTime(userId,companyId,reportStatus);
    }

    @Override
    public String getMaxApplyTime(int userId, String companyId, String reportStatus) {
        return myReportMapper.getMaxApplyTime(userId,companyId,reportStatus);
    }
}
