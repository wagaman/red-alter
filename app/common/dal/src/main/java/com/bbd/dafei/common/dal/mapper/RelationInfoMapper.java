package com.bbd.dafei.common.dal.mapper;

import com.bbd.dafei.common.modal.vo.RelationRightVO;
import com.bbd.dafei.common.modal.vo.RelationTotalInfoDetail1dVO;
import com.bbd.dafei.common.modal.vo.RelationTotalInfoDetail2dVO;
import com.bbd.dafei.common.modal.vo.RelationTotalInfoDetail3dVO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by shi.jun on 2017/9/20.
 */
public interface RelationInfoMapper {

    /**
     * 查询企业详情右侧关联方数据
     * @param companyId
     * @param degree
     */
    RelationRightVO findRelationRightVO(@Param("companyId") String companyId, @Param("degree") Integer degree);

}
