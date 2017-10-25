package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.dto.AreaCountDTO;
import com.bbd.dafei.common.modal.dto.IndustryRealTimeMonitoringDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaAreaCountFoucsAndSustainVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 区域统计表
 *
 * @author Ian.Su
 * @version $Id: RaAreaCountMapper.java, v 0.1 2017/4/18 10:10 Ian.Su Exp $
 */
public interface RaAreaCountMapper {

    List<String> rankByProvince();

    /**
     * 查询省份散点信息
     *
     * @param province 省
     * @param industry 行业:新兴金融,私募基金,网络借贷,小额贷款,融资担保,交易场所
     * @return
     */
    List<AreaCountDTO> mapProvince(@Param("province") String province, @Param("industry") String industry);

    /**
     * 查询市散点信息
     *
     * @param province 省
     * @param city     市
     * @param industry 行业:新兴金融,私募基金,网络借贷,小额贷款,融资担保,交易场所
     * @return
     */
    List<AreaCountDTO> mapCity(@Param("province") String province, @Param("city") String city, @Param("industry") String industry);

    AreaCountDTO provinceRealTimeMonitoring(@Param("province") String province);

    IndustryRealTimeMonitoringDTO provinceRealTimeMonitorByIndustry(@Param("province") String province);


    AreaCountDTO cityRealTimeMonitoring(@Param("province") String province,
                                        @Param("city") String city,
                                        @Param("area") String area);

    IndustryRealTimeMonitoringDTO cityRealTimeMonitoringByIndustry(@Param("province") String province,
                                                                   @Param("city") String city,
                                                                   @Param("area") String area);

    List<AreaCountDTO> highCompanyTop(@Param("province") String province, @Param("city") String city);

    List<KeyValDTO<String, Integer>> highIndustry(@Param("province") String province,
                                                  @Param("city") String city,
                                                  @Param("area") String area);

    AreaCountDTO monitorTypeCount(@Param("province") String province,
                                  @Param("city") String city,
                                  @Param("area") String area);

    void addHigh(@Param("province") String province,
                 @Param("city") String city,
                 @Param("area") String area,
                 @Param("add") Integer add);

    void updateCount(@Param("province") String province,
                     @Param("city") String city,
                     @Param("area") String area);

    RaAreaCountFoucsAndSustainVO getFoucsAndSustainData(@Param("province") String province,
                                                        @Param("city") String city,
                                                        @Param("area") String area);

    void updateColumnValue(@Param("columnNames") Set<String> columnNames ,
                           @Param("columnValue") int columnValue,
                           @Param("province") String province,
                           @Param("city") String city,
                           @Param("area") String area);
}
