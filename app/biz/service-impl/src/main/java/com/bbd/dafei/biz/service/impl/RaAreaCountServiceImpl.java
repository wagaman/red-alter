package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.RaAreaCountService;
import com.bbd.dafei.common.dal.mapper.RaAreaCountMapper;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tuanhong on 2017-09-06.
 */
@Service
public class RaAreaCountServiceImpl implements RaAreaCountService{

    @Autowired
    private RaAreaCountMapper areaCountMapper;

    @Override
    public void updateAreaCountNum(RaCompanyPO raCompanyPO, int columnValue) {

        String riskLevel = raCompanyPO.getRiskLevel();

        if(!riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON) && !riskLevel.equals(Constants.RISK_LEVEL_SUSTAIN_MONITOR)){
            return;
        }

        Set<String> columnNames = new HashSet<>();

        setCloumnNameByIndustry(columnNames,raCompanyPO.getIndustry(),riskLevel);

        if(riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON)){//重点关注
            columnNames.add("focus_on");
        }else {//持续监控
            columnNames.add("sustain_monitor");
        }

        //地区空值 转化为无
        String province = changeProvinceOrCityOrArea(raCompanyPO.getProvince());
        String city = changeProvinceOrCityOrArea(raCompanyPO.getCity());
        String area = changeProvinceOrCityOrArea(raCompanyPO.getArea());

        areaCountMapper.updateColumnValue(columnNames,columnValue,province,city,area);
    }

    /**
     * 如果地区为null 或者 “”转换成 “无”
     * @param changeValue
     * @return
     */
    private String changeProvinceOrCityOrArea(String changeValue) {
        if(changeValue == null || changeValue.equals("")){
            return "无";
        }
        return changeValue;
    }

    /**
     * 根据不同行业设置不同的值
     * @param columnNames
     * @param industry
     */
    private void setCloumnNameByIndustry(Set<String> columnNames, String industry,String riskLevel) {
        switch (industry){
            case Constants.COMPANY_INDUSTRY_EMERGING_FINANCE :
                columnNames.add(riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON)? "other_focus_on":"other_sustain_monitor");
                break;
            case Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE :
                columnNames.add(riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON)? "financing_guarantee_focus_on":"financing_guarantee_sustain_monitor");
                break;
            case Constants.COMPANY_INDUSTRY_P2P :
                columnNames.add(riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON)? "net_focus_on":"net_sustain_monitor");
                break;
            case Constants.COMPANY_INDUSTRY_PETTY_LOAN :
                columnNames.add(riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON)? "petty_loan_focus_on":"petty_loan_sustain_monitor");
                break;
            case Constants.COMPANY_INDUSTRY_PRIVATE_EQUIT :
                columnNames.add(riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON)? "private_fund_focus_on":"private_fund_sustain_monitor");
                break;
            case Constants.COMPANY_INDUSTRY_TRADING_PLACE :
                columnNames.add(riskLevel.equals(Constants.RISK_LEVEL_FOCUS_ON)? "trade_place_focus_on":"trade_place_sustain_monitor");
                break;
            default :
                break;
        }
    }
}
