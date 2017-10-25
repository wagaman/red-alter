package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业详情页面右侧关联方信息
 * @author anhong.Tu
 * @version $Id: RelationTotalInfoVO.java, v 0.1 2017/7/25 9:30 anhong.Tu Exp $
 */
@ApiModel(value = "企业详情页面右侧关联方信息")
public class RelationTotalInfoVO {
    @ApiModelProperty(value ="1度关联方信息")
    private RelationTotalInfoDetail1dVO relationTotalInfoDetail1dVO;
    @ApiModelProperty(value ="2度关联方信息")
    private RelationTotalInfoDetail2dVO relationTotalInfoDetail2dVO;
    @ApiModelProperty(value ="3度关联方信息")
    private RelationTotalInfoDetail3dVO relationTotalInfoDetail3dVO;

    public RelationTotalInfoDetail1dVO getRelationTotalInfoDetail1dVO() {
        return relationTotalInfoDetail1dVO;
    }

    public void setRelationTotalInfoDetail1dVO(RelationTotalInfoDetail1dVO relationTotalInfoDetail1dVO) {
        this.relationTotalInfoDetail1dVO = relationTotalInfoDetail1dVO;
    }

    public RelationTotalInfoDetail2dVO getRelationTotalInfoDetail2dVO() {
        return relationTotalInfoDetail2dVO;
    }

    public void setRelationTotalInfoDetail2dVO(RelationTotalInfoDetail2dVO relationTotalInfoDetail2dVO) {
        this.relationTotalInfoDetail2dVO = relationTotalInfoDetail2dVO;
    }

    public RelationTotalInfoDetail3dVO getRelationTotalInfoDetail3dVO() {
        return relationTotalInfoDetail3dVO;
    }

    public void setRelationTotalInfoDetail3dVO(RelationTotalInfoDetail3dVO relationTotalInfoDetail3dVO) {
        this.relationTotalInfoDetail3dVO = relationTotalInfoDetail3dVO;
    }
}
