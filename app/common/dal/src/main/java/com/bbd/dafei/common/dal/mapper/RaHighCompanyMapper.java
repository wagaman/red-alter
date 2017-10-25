package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.dto.AreaCountDTO;
import com.bbd.dafei.common.modal.vo.RaIndexCompanyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017-04-19.
 */
public interface RaHighCompanyMapper {

    List<RaIndexCompanyVO> findByProvince(@Param("province") String province,
                                          @Param("city") String city,
                                          @Param("area") String area,
                                          @Param("industry") String industry,
                                          @Param("isNew") String isNew);


    int count(@Param("province") String province,
              @Param("city") String city,
              @Param("area") String area,
              @Param("industry") String industry,
              @Param("isNew") String isNew);


    List<RaIndexCompanyVO> query(@Param("province") String province,
                                 @Param("city") String city,
                                 @Param("area") String area,
                                 @Param("industry") String industry,
                                 @Param("isNew") String isNew,
                                 @Param("start") Integer start,
                                 @Param("size") Integer size,
                                 @Param("order") String order,
                                 @Param("descAsc") String descAsc);

    List<AreaCountDTO> highCompanyTop(@Param("province") String province, @Param("city") String city);

    List<AreaCountDTO> industryHighCompanyTop(@Param("province") String province, @Param("industry") String industry,@Param("city") String city);

    void addHighCompany(@Param("po") RaCompanyPO po);

    /**
     * 批量添加到高危企业
     *
     * @param pos
     */
    void addHighCompanys(@Param("pos") List<RaCompanyPO> pos);

    int deleteByCompanyId(@Param("companyId") String companyId);
}
