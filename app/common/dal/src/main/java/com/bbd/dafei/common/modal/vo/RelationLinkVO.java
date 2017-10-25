package com.bbd.dafei.common.modal.vo;

import com.bbd.wellspring.common.service.facade.relation.LineTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/5/3.
 */
@ApiModel(value = "关联")
public class RelationLinkVO {

    private String addflag = "false";
    private String guanlian;
    @ApiModelProperty(value = "连线类型")
    private LineTypeEnum line;
    @ApiModelProperty(value = "目标节点")
    private String target;
    @ApiModelProperty(value = "起始节点")
    private String source;
    private String relatedParyName;

    public String getAddflag() {
        return addflag;
    }

    public void setAddflag(String addflag) {
        this.addflag = addflag;
    }

    public String getGuanlian() {
        return guanlian;
    }

    public void setGuanlian(String guanlian) {
        this.guanlian = guanlian;
    }

    public LineTypeEnum getLine() {
        return line;
    }

    public void setLine(LineTypeEnum line) {
        this.line = line;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRelatedParyName() {
        return relatedParyName;
    }

    public void setRelatedParyName(String relatedParyName) {
        this.relatedParyName = relatedParyName;
    }
}
