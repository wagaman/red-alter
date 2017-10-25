package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.IndexService;
import com.bbd.dafei.common.dal.mapper.RaAreaChartMapper;
import com.bbd.dafei.common.dal.mapper.RaAreaCountMapper;
import com.bbd.dafei.common.dal.mapper.RaCompanyMapper;
import com.bbd.dafei.common.dal.mapper.RaHighCompanyMapper;
import com.bbd.dafei.common.modal.dto.AreaCountDTO;
import com.bbd.dafei.common.modal.dto.HealthDTO;
import com.bbd.dafei.common.modal.dto.IndustryRealTimeMonitoringDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaAreaCountFoucsAndSustainVO;
import com.bbd.dafei.common.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ian.Su
 * @version $Id: IndexServiceImpl.java, v 0.1 2017/4/18 9:55 Ian.Su Exp $
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RaAreaCountMapper areaMapper;

    @Autowired
    private RaHighCompanyMapper highCompanyMapper;

    @Autowired
    private RaCompanyMapper raCompanyMapper;

    @Autowired
    private RaAreaChartMapper raAreaChartMapper;

    @Override
    public HealthDTO health(int top, String province) {

        List<String> provinces = areaMapper.rankByProvince();

        top = provinces.size() < top ? provinces.size() : top;

        HealthDTO po = new HealthDTO();
        po.setProvince(province);
        po.setCount(provinces.size());
        po.setTop(provinces.subList(0, top));
        int rank = 1;
        for (String p : provinces) {
            if (StringUtils.endsWithIgnoreCase(p, province))
                break;
            rank++;
        }
        po.setRanking(rank);
        return po;
    }

    @Override
    public List<AreaCountDTO> mapProvince(String province, String industry) {

        List<AreaCountDTO> list = areaMapper.mapProvince(province, industry);

        list.forEach(dto -> {
            if (dto.getHighCollect() != null) {
                dto.setHighCollect(dto.getHighCollect().replaceAll("无、", "").replaceAll("、无", ""));
                String[] collect = dto.getHighCollect().split("、");
                if (collect.length > 2) {
                    dto.setHighCollect(collect[0] + "、" + collect[1] + "、" + collect[2]);
                }
            }
            //监控区域为0，更正为1
            if (dto.getMonitorRegion() == 0) {
                dto.setMonitorRegion(1);
            }
        });

        return list;
    }

    @Override
    public List<AreaCountDTO> mapCity(String province, String city, String industry) {
        List<AreaCountDTO> list = areaMapper.mapCity(province, city, industry);
        list.forEach(dto -> {
            //监控区域为0，更正为1
            if (dto.getMonitorRegion() == 0) {
                dto.setMonitorRegion(1);
            }
        });
        return list;
    }

    @Override
    public AreaCountDTO provinceRealTimeMonitoring(String province) {

        AreaCountDTO dto = areaMapper.provinceRealTimeMonitoring(province);
        //监控区域为0，更正为1
        if (dto.getMonitorRegion() == 0) {
            dto.setMonitorRegion(1);
        }

        // 按产品要求,为了保证数据一致,暂时直接统计 ra_high_company表
        dto.setHighCompany(highCompanyMapper.count(province, null, null, null, null));

        return dto;
    }

    @Override
    public AreaCountDTO provinceRealTimeMonitorByIndustry(String province, String industry) {
        IndustryRealTimeMonitoringDTO dataDto = areaMapper.provinceRealTimeMonitorByIndustry(province);

        AreaCountDTO areaCountDTO = new AreaCountDTO();

        if (null != dataDto) {
            //地区
            areaCountDTO.setRegion(dataDto.getRegion());
            //监测地区 : 监控区域如果为0，更正为1
            if (dataDto.getMonitorRegion() == 0) {
                areaCountDTO.setMonitorRegion(1);
            } else {
                areaCountDTO.setMonitorRegion(dataDto.getMonitorRegion());
            }

            // 高危企业数 : 根据行业直接统计ra_high_company表
            int highNumber = highCompanyMapper.count(province, null, null, industry, null);
            areaCountDTO.setHighCompany(highNumber);
//            //监控企业数：根据行业直接统计ra_company表
//            int monitorNumber = raCompanyMapper.count(province, industry, null, null);
//            areaCountDTO.setMonitorCompany(monitorNumber);
            //处理不同行业的变动数，增加与减少数
            setDTO(industry,areaCountDTO,dataDto);


            int monitorNumber = areaCountDTO.getMonitorCompany();

            if(monitorNumber != 0){
                areaCountDTO.setProportion(BigDecimal.valueOf(new Double(highNumber) / new Double(monitorNumber)).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
        }
        return areaCountDTO;
    }


    @Override
    public AreaCountDTO cityRealTimeMonitoring(String province, String city, String area) {

//        if (!StringUtils.isEmpty(city) && !StringUtils.isEmpty(area)) {
//            areaMapper.updateCount(province, city, area);
//        }

        AreaCountDTO dto = areaMapper.cityRealTimeMonitoring(province, city, area);
        //监控区域为0，更正为1
        if (dto.getMonitorRegion() == 0) {
            dto.setMonitorRegion(1);
        }
        // 按产品要求,为了保证数据一致,暂时直接统计 ra_high_company表
        dto.setHighCompany(highCompanyMapper.count(province, city, area, null, null));

        return dto;
    }

    @Override
    public AreaCountDTO cityRealTimeMonitoringByIndustry(String province, String industry, String city, String area) {

        IndustryRealTimeMonitoringDTO cityDataDto = areaMapper.cityRealTimeMonitoringByIndustry(province, city, area);
        AreaCountDTO areaCountDTO = new AreaCountDTO();

        if (null != cityDataDto) {
            //地区
            areaCountDTO.setRegion(cityDataDto.getRegion());
            //监测地区 : 监控区域如果为0，更正为1
            if (cityDataDto.getMonitorRegion() == 0) {
                areaCountDTO.setMonitorRegion(1);
            } else {
                areaCountDTO.setMonitorRegion(cityDataDto.getMonitorRegion());
            }

            // 高危企业数 : 根据行业直接统计ra_high_company表
            int highNumber = highCompanyMapper.count(province, city, area, industry, null);
            areaCountDTO.setHighCompany(highNumber);
            //监控企业数：根据行业直接统计ra_company表
//            int monitorNumber = raCompanyMapper.count(province, industry, city, area);
//            areaCountDTO.setMonitorCompany(monitorNumber);

            //处理不同行业的变动数，增加与减少数
            setDTO(industry,areaCountDTO,cityDataDto);

            int monitorNumber = areaCountDTO.getMonitorCompany();
            //占比
            if(monitorNumber != 0){
                areaCountDTO.setProportion(BigDecimal.valueOf(new Double(highNumber) / new Double(monitorNumber)).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
        }
        return areaCountDTO;
    }

    @Override
    public List<AreaCountDTO> highCompanyTop(String province, String city) {
        List<AreaCountDTO> areaCountDTOS = highCompanyMapper.highCompanyTop(province, city);
        return changeData(areaCountDTOS);
    }

    @Override
    public List<AreaCountDTO> industryHighCompanyTop(String province, String industry, String city) {
        List<AreaCountDTO> areaCountDTOS = highCompanyMapper.industryHighCompanyTop(province, industry, city);
        return changeData(areaCountDTOS);
    }

    private List<AreaCountDTO> changeData(List<AreaCountDTO> areaCountDTOS) {
        List<AreaCountDTO> data = new ArrayList<>();
        int dataNum = 1;
        for(AreaCountDTO areaCountDTO: areaCountDTOS){
            if(dataNum > 3){
                break;
            }

            String region = areaCountDTO.getRegion();
            if(region.equals("无")){
                continue;
            }
            data.add(areaCountDTO);

            dataNum++;
        }
        return data;
    }

    @Override
    public List<KeyValDTO<String, Integer>> highIndustry(String province, String city, String area) {
        return areaMapper.highIndustry(province, city, area);
    }

    @Override
    public AreaCountDTO monitorTypeCount(String province, String city, String area) {

//        if (!StringUtils.isEmpty(city) && !StringUtils.isEmpty(area)) {
//            areaMapper.updateCount(province, city, area);
//        }

        AreaCountDTO areaCountDTO = areaMapper.monitorTypeCount(province, city, area);

        if (areaCountDTO != null) {
            // 按产品要求,为了保证数据一致,暂时直接统计 ra_high_company表
            areaCountDTO.setHighCompany(highCompanyMapper.count(province, city, area, null, null));
        }
        return areaCountDTO;
    }

    @Override
    public AreaCountDTO industryMonitorTypeCount(String province, String industry, String city, String area) {

        AreaCountDTO areaCountDTO = new AreaCountDTO();
        //地区
        areaCountDTO.setRegion(area);
        // 高危企业数：按产品要求,为了保证数据一致,暂时直接统计 ra_high_company表
        areaCountDTO.setHighCompany(highCompanyMapper.count(province, city, area, industry, null));

        RaAreaCountFoucsAndSustainVO raAreaCountFoucsAndSustainVO = areaMapper.getFoucsAndSustainData(province,city,area);
        if(industry.equals(Constants.COMPANY_INDUSTRY_PETTY_LOAN)){
            areaCountDTO.setFocusOn(raAreaCountFoucsAndSustainVO.getPettyLoanFocusOn());//重点关注
            areaCountDTO.setSustainMonitor(raAreaCountFoucsAndSustainVO.getPettyLoanSustainMonitor());//持续监控企业数
        }else if(industry.equals(Constants.COMPANY_INDUSTRY_TRADING_PLACE)){
            areaCountDTO.setFocusOn(raAreaCountFoucsAndSustainVO.getTradePlaceFocusOn());//重点关注
            areaCountDTO.setSustainMonitor(raAreaCountFoucsAndSustainVO.getTradePlaceSustainMonitor());//持续监控企业数
        }else if (industry.equals(Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE)){
            areaCountDTO.setFocusOn(raAreaCountFoucsAndSustainVO.getFinancingGuaranteeFocusOn());//重点关注
            areaCountDTO.setSustainMonitor(raAreaCountFoucsAndSustainVO.getFinancingGuaranteeSustainMonitor());//持续监控企业数
        }else if(industry.equals(Constants.COMPANY_INDUSTRY_P2P)){
            areaCountDTO.setFocusOn(raAreaCountFoucsAndSustainVO.getNetFocusOn());//重点关注
            areaCountDTO.setSustainMonitor(raAreaCountFoucsAndSustainVO.getNetSustainMonitor());//持续监控企业数
        }else if (industry.equals(Constants.COMPANY_INDUSTRY_PRIVATE_EQUIT)){
            areaCountDTO.setFocusOn(raAreaCountFoucsAndSustainVO.getPrivateFundFocusOn());//重点关注
            areaCountDTO.setSustainMonitor(raAreaCountFoucsAndSustainVO.getPrivateFundSustainMonitor());//持续监控企业数
        }else{
            areaCountDTO.setFocusOn(raAreaCountFoucsAndSustainVO.getOtherFocusOn());//重点关注
            areaCountDTO.setSustainMonitor(raAreaCountFoucsAndSustainVO.getOtherSustainMonitor());//持续监控企业数
        }

//        //取重点关注 和持续监控 企业数：从ra_company里面直接取
//        areaCountDTO.setFocusOn(raCompanyMapper.industryCount(province, city, area, industry, "重点关注"));//重点关注
//        areaCountDTO.setSustainMonitor(raCompanyMapper.industryCount(province, city, area, industry, "持续监控"));//重点关注
        return areaCountDTO;
    }

    @Override
    public String getNetAvgReturnRate(String province, String city, String area) {
        return raAreaChartMapper.getNetAvgReturnRate(province, city, area);
    }

    @Override
    public String getNetAvgLoanDate(String province, String city, String area) {
        return raAreaChartMapper.getNetAvgLoanDate(province, city, area);
    }

    @Override
    public String getPrivateFundProductNum(String province, String city, String area) {
        return raAreaChartMapper.getPrivateFundProductNum(province, city, area);
    }

    @Override
    public String getPrivateFundProductType(String province, String city, String area) {
        return raAreaChartMapper.getPrivateFundProductType(province, city, area);
    }

    @Override
    public String getPrivateFundCompanyType(String province, String city, String area) {
        return raAreaChartMapper.getPrivateFundCompanyType(province, city, area);
    }

    @Override
    public String getPrivateFundEmployeeScale(String province, String city, String area) {
        return raAreaChartMapper.getPrivateFundEmployeeScale(province, city, area);
    }

    @Override
    public String getTradePlaceType(String province, String city, String area) {
        return raAreaChartMapper.getTradePlaceType(province, city, area);
    }

    @Override
    public String getTradePlaceTradeType(String province, String city, String area) {
        return raAreaChartMapper.getTradePlaceTradeType(province, city, area);
    }

    @Override
    public Map<String, String> getHighCompanySort(String industry, String province, String city, String area) {
        Map<String, String> message = new HashMap<String, String>();

        //查核调用接口的行业类型必须为：融资担保，小额贷款，其他新兴金融 三个行业之一
        if (!industry.equals(Constants.COMPANY_INDUSTRY_PETTY_LOAN) &&
                !industry.equals(Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE) &&
                !industry.equals(Constants.COMPANY_INDUSTRY_EMERGING_FINANCE)) {
            //提示行业不为 融资担保，小额贷款，其他新兴金融三个行业之一
            message.put("msg", "所属行业不为 融资担保，小额贷款，其他新兴金融三个行业之一");
            return message;
        } else {
            message.put("data", raAreaChartMapper.getHighCompanySort(industry, province, city, area));
            return message;
        }
    }

    private void setDTO(String industry,AreaCountDTO areaCountDTO,IndustryRealTimeMonitoringDTO cityDataDto){
        if (null == industry || industry.equals("")) {
            //高危企业变动数
            areaCountDTO.setChangeHighCompany(cityDataDto.getChangeHighCompany());
            //减少高危企业数
            areaCountDTO.setLessenHighRisk(cityDataDto.getLessenHighRisk());
            //增加高危企业数
            areaCountDTO.setAddHighRisk(cityDataDto.getAddHighRisk());

            //监控企业数
            areaCountDTO.setMonitorCompany(cityDataDto.getMonitorCompany());
            //监控变动企业数
            areaCountDTO.setChangeMonitorCompany(cityDataDto.getChangeMonitorCompany());
            //减少监控企业数
            areaCountDTO.setLessenMonitor(cityDataDto.getLessenMonitor());
            //增加监控企业数
            areaCountDTO.setAddMonitor(cityDataDto.getAddMonitor());
        } else if (industry.equals(Constants.COMPANY_INDUSTRY_P2P)) {//网络借贷
            // 高危企业变动数
            areaCountDTO.setChangeHighCompany(cityDataDto.getNetChangeHighCompany());
            //减少高危企业数
            areaCountDTO.setLessenHighRisk(cityDataDto.getNetLessenHighRisk());
            //增加高危企业数
            areaCountDTO.setAddHighRisk(cityDataDto.getNetAddHighRisk());

            //网络借贷监控企业数
            areaCountDTO.setMonitorCompany(cityDataDto.getNetLoan());
            //监控企业变动数
            areaCountDTO.setChangeMonitorCompany(cityDataDto.getNetChangeMonitorCompany());
            //减少监控企业数
            areaCountDTO.setLessenMonitor(cityDataDto.getNetLessenmonitor());
            //增加监控企业数
            areaCountDTO.setAddMonitor(cityDataDto.getNetAddMonitor());
        } else if (industry.equals(Constants.COMPANY_INDUSTRY_PRIVATE_EQUIT)) {//私募基金
            //高危企业变动数
            areaCountDTO.setChangeHighCompany(cityDataDto.getPrivateFundChangeHighCompany());
            //减少高危企业数
            areaCountDTO.setLessenHighRisk(cityDataDto.getPrivateFundLessenHighRisk());
            //增加高危企业数
            areaCountDTO.setAddHighRisk(cityDataDto.getPrivateFundAddHighRisk());

            //私募基金监控企业数
            areaCountDTO.setMonitorCompany(cityDataDto.getPrivateFund());
            //监控企业变动数
            areaCountDTO.setChangeMonitorCompany(cityDataDto.getPrivateFundChangeMonitorCompany());
            //减少监控企业数
            areaCountDTO.setLessenMonitor(cityDataDto.getPrivateFundLessenmonitor());
            //增加监控企业数
            areaCountDTO.setAddMonitor(cityDataDto.getPrivateFundAddMonitor());
        } else if (industry.equals(Constants.COMPANY_INDUSTRY_TRADING_PLACE)) {//交易场所
            //高危企业变动数
            areaCountDTO.setChangeHighCompany(cityDataDto.getTradePlaceChangeHighCompany());
            //减少高危企业数
            areaCountDTO.setLessenHighRisk(cityDataDto.getTradePlaceLessenHighRisk());
            //增加高危企业数
            areaCountDTO.setAddHighRisk(cityDataDto.getTradePlaceAddHighRisk());

            //交易场所监控企业数
            areaCountDTO.setMonitorCompany(cityDataDto.getTradePlace());
            //监控企业变动数
            areaCountDTO.setChangeMonitorCompany(cityDataDto.getTradePlaceChangeMonitorCompany());
            //减少监控企业数
            areaCountDTO.setLessenMonitor(cityDataDto.getTradePlaceLessenmonitor());
            //增加监控企业数
            areaCountDTO.setAddMonitor(cityDataDto.getTradePlaceAddMonitor());
        } else if (industry.equals(Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE)) {//融资担保
            // 高危企业变动数
            areaCountDTO.setChangeHighCompany(cityDataDto.getFinancingGuaranteeChangeHighCompany());
            //减少高危企业数
            areaCountDTO.setLessenHighRisk(cityDataDto.getFinancingGuaranteeLessenHighRisk());
            //增加高危企业数
            areaCountDTO.setAddHighRisk(cityDataDto.getFinancingGuaranteeAddHighRisk());

            //融资担保监控企业数
            areaCountDTO.setMonitorCompany(cityDataDto.getFinancingGuarantee());
            //监控企业变动数
            areaCountDTO.setChangeMonitorCompany(cityDataDto.getFinancingGuaranteeChangeMonitorCompany());
            //减少监控企业数
            areaCountDTO.setLessenMonitor(cityDataDto.getFinancingGuaranteeLessenmonitor());
            //增加监控企业数
            areaCountDTO.setAddMonitor(cityDataDto.getFinancingGuaranteeAddMonitor());

        } else if (industry.equals(Constants.COMPANY_INDUSTRY_PETTY_LOAN)) {//小额贷款
            //高危企业变动数
            areaCountDTO.setChangeHighCompany(cityDataDto.getPettyLoanChangeHighCompany());
            //减少高危企业数
            areaCountDTO.setLessenHighRisk(cityDataDto.getPettyLoanLessenHighRisk());
            //增加高危企业数
            areaCountDTO.setAddHighRisk(cityDataDto.getPettyLoanAddHighRisk());

            //小额贷款监控企业数
            areaCountDTO.setMonitorCompany(cityDataDto.getPettyLoan());
            //监控企业变动数
            areaCountDTO.setChangeMonitorCompany(cityDataDto.getPettyLoanChangeMonitorCompany());
            //减少监控企业数
            areaCountDTO.setLessenMonitor(cityDataDto.getPettyLoanLessenmonitor());
            //增加监控企业数
            areaCountDTO.setAddMonitor(cityDataDto.getPettyLoanAddMonitor());
        } else {//其他新兴金融
            // /高危企业变动数
            areaCountDTO.setChangeHighCompany(cityDataDto.getOtherChangeHighCompany());
            //减少高危企业数
            areaCountDTO.setLessenHighRisk(cityDataDto.getOtherLessenHighRisk());
            //增加高危企业数
            areaCountDTO.setAddHighRisk(cityDataDto.getOtherAddHighRisk());

            //其他新兴金融监控企业数
            areaCountDTO.setMonitorCompany(cityDataDto.getRisingFinancial());
            //监控企业变动数
            areaCountDTO.setChangeMonitorCompany(cityDataDto.getOtherChangeMonitorCompany());
            //减少监控企业数
            areaCountDTO.setLessenMonitor(cityDataDto.getOtherLessenmonitor());
            //增加监控企业数
            areaCountDTO.setAddMonitor(cityDataDto.getOtherAddMonitor());
        }
    }

}
