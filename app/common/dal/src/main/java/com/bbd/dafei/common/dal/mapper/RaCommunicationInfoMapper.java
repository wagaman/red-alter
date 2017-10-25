package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.dto.RaCommunicationInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tuanhong on 2017-05-16.
 */
public interface RaCommunicationInfoMapper {
    /**
     * 取得通讯信息
     * @param userType
     * @param status
     * @return
     */
    List<RaCommunicationInfoDTO> getInfoByUserType(@Param("userType") String userType, @Param("status") String status);
}
