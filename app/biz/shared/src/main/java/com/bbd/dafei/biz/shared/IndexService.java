package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.AreaCountDTO;
import com.bbd.dafei.common.modal.dto.HealthDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;

import java.util.List;
import java.util.Map;

/**
 * 首页相关接口
 *
 * @author Ian.Su
 * @version $Id: IndexService.java, v 0.1 2017/4/18 9:46 Ian.Su Exp $
 */
public interface IndexService {

    /**
     * 健康度查询
     *
     * @param top      指定需要前几的数据
     * @param province 查询指定省份的排名情况
     * @return HealthPO
     */
    HealthDTO health(int top, String province);

    /**
     * 根据省份查询各市散点图
     *
     * @param province 查询指定省份各市的散点图详细信息
     * @param industry 行业:新兴金融,私募基金,网络借贷,小额贷款,融资担保,交易场所
     * @return List<ScatterMapPO>
     */
    List<AreaCountDTO> mapProvince(String province, String industry);


    /**
     * 根据市查询各区散点图
     *
     * @param province 省份
     * @param city     查询指定市的各区散点图详细信息
     * @param industry 行业:新兴金融,私募基金,网络借贷,小额贷款,融资担保,交易场所
     * @return List<ScatterMapPO>
     */
    List<AreaCountDTO> mapCity(String province, String city, String industry);

    /**
     * 根据省份查询实时监测数据
     *
     * @param province 省份
     * @return AreaCountDTO
     */
    AreaCountDTO provinceRealTimeMonitoring(String province);

    /**
     * 根据省份查询实时监测数据
     *
     * @param province 省份
     * @param industry 所属行业
     * @return AreaCountDTO
     */
    AreaCountDTO provinceRealTimeMonitorByIndustry(String province, String industry);

    /**
     * 根据城市查询实时监测数据
     *
     * @param province 省份
     * @param city
     * @return AreaCountDTO
     */
    AreaCountDTO cityRealTimeMonitoring(String province, String city, String area);

    /**
     * 分行业查询不同城市实时监测数据
     *
     * @param province
     * @param industry
     * @param city
     * @param area
     * @return
     */
    AreaCountDTO cityRealTimeMonitoringByIndustry(String province, String industry, String city, String area);

    /**
     * 查询高危企业数top3
     *
     * @param province 省份
     * @param city
     * @return AreaCountDTO
     */
    List<AreaCountDTO> highCompanyTop(String province, String city);

    /**
     * 分行业查询高危企业数TOP3
     *
     * @param province
     * @param industry
     * @param city
     * @return
     */
    List<AreaCountDTO> industryHighCompanyTop(String province, String industry, String city);

    /**
     * 查询行业高危企业数
     *
     * @param province 省份
     * @param city
     * @param area
     * @return AreaCountDTO
     */
    List<KeyValDTO<String, Integer>> highIndustry(String province, String city, String area);


    /**
     * 查询行业高危企业数
     *
     * @param province 省份
     * @param city
     * @param area
     * @return AreaCountDTO
     */
    AreaCountDTO monitorTypeCount(String province, String city, String area);

    /**
     * 分行业查询行业高危企业数
     *
     * @param province
     * @param industry
     * @param city
     * @param area
     * @return
     */
    AreaCountDTO industryMonitorTypeCount(String province, String industry, String city, String area);

    /**
     * 查询网络借贷平均收益率
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getNetAvgReturnRate(String province, String city, String area);

    /**
     * 查询网络借贷平均贷款期限
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getNetAvgLoanDate(String province, String city, String area);

    /**
     * 取私募基金产品数量
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getPrivateFundProductNum(String province, String city, String area);

    /**
     * 取私募基金基金类型
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getPrivateFundProductType(String province, String city, String area);

    /**
     * 取得私募基金企业性质
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getPrivateFundCompanyType(String province, String city, String area);

    /**
     * 取得私募基金人员规模
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getPrivateFundEmployeeScale(String province, String city, String area);

    /**
     * 查询交易场所权益现货占比
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getTradePlaceType(String province, String city, String area);

    /**
     * 查询交易场所数量
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    String getTradePlaceTradeType(String province, String city, String area);

    /**
     * 查询不同行业区域高危企业时序图
     *
     * @param industry
     * @param province
     * @param city
     * @param area
     * @return
     */
    Map<String, String> getHighCompanySort(String industry, String province, String city, String area);
}
