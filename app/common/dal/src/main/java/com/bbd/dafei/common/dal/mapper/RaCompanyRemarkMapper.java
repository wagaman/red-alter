package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.dto.RaCompanyRemarkDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 备注相关
 * Created by wish on 2017/5/2.
 */
public interface RaCompanyRemarkMapper {
    /**
     * 根据公司id、平台和用户名查询备注
     * @param companyId 公司id
     * @param platform  平台
     * @param userName 用户名
     * @return
     */
    List<RaCompanyRemarkDTO> findRemarkByCompanyIdAndUserName(@Param("companyId") String companyId,
                                                              @Param("platform") String platform,
                                                              @Param("userName") String userName);

    /**
     * 根据id查询备注
     * @param id
     * @return
     */
    RaCompanyRemarkDTO findRemarkById(Integer id);

    /**
     * 根据id删除备注
     * @param id
     */
    int deleteRemarkById(Integer id);

    /**
     * 保存备注
     * @param raCompanyRemarkDTO
     */
    void insertRemark(RaCompanyRemarkDTO raCompanyRemarkDTO);
}
