package com.bbd.dafei.common.dal.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by tuanhong on 2017-04-21.
 */
@ApiModel("用户研报下载信息")
public class RaResearchReportPO {

    @ApiModelProperty("id--自增字段")
    private Integer id;
   @ApiModelProperty("研报可下载总次数")
   private Integer totalNumber;
   @ApiModelProperty("可下载研报剩余次数")
   private Integer remainingNumber;
   @ApiModelProperty("已下载研报次数")
   private Integer usedNumber;
   @ApiModelProperty("创建时间")
   private Date gmtCreate;
   @ApiModelProperty("修改时间")
    private Date gmtUpdate;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getRemainingNumber() {
        return remainingNumber;
    }

    public void setRemainingNumber(Integer remainingNumber) {
        this.remainingNumber = remainingNumber;
    }

    public Integer getUsedNumber() {
        return usedNumber;
    }

    public void setUsedNumber(Integer usedNumber) {
        this.usedNumber = usedNumber;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
