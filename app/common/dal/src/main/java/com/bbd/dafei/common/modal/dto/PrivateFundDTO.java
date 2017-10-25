package com.bbd.dafei.common.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wish on 2017/4/25.
 */
@ApiModel("私募基金信息")
public class PrivateFundDTO {

    @ApiModelProperty(value = "高管信息")
    private List<ExecutiveInfo> executiveInfoList;

    @ApiModelProperty(value = "基金管理信息")
    private List<ManageInfo> manageInfoList;

    public List<ExecutiveInfo> getExecutiveInfoList() {
        return executiveInfoList;
    }

    public void setExecutiveInfoList(List<ExecutiveInfo> executiveInfoList) {
        this.executiveInfoList = executiveInfoList;
    }

    public List<ManageInfo> getManageInfoList() {
        return manageInfoList;
    }

    public void setManageInfoList(List<ManageInfo> manageInfoList) {
        this.manageInfoList = manageInfoList;
    }

    @ApiModel(value = "高管信息")
    public static class ExecutiveInfo {

        @ApiModelProperty(value = "高管姓名")
        private String name;
        @ApiModelProperty(value = "是否具有基金从业资格")
        private String occupationalRequirements;
        @ApiModelProperty(value = "职务")
        private String job;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOccupationalRequirements() {
            return occupationalRequirements;
        }

        public void setOccupationalRequirements(String occupationalRequirements) {
            this.occupationalRequirements = occupationalRequirements;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }
    }

    @ApiModel("基金管理信息")
    public static class ManageInfo {

        @ApiModelProperty(value = "基金编号")
        private String fundNumber;

        @ApiModelProperty(value = "基金名称")
        private String fundName;

        @ApiModelProperty(value = "基金类型")
        private String fundType;

        @ApiModelProperty(value = "管理类型")
        private String managementType;

        @ApiModelProperty(value = "托管人名称")
        private String custodian;

        @ApiModelProperty(value = "运作状态")
        private String operationalStatus;
        @ApiModelProperty(value = "基金备案阶段")
        private String fundFilingStage;

        public String getFundNumber() {
            return fundNumber;
        }

        public void setFundNumber(String fundNumber) {
            this.fundNumber = fundNumber;
        }

        public String getFundName() {
            return fundName;
        }

        public void setFundName(String fundName) {
            this.fundName = fundName;
        }

        public String getFundType() {
            return fundType;
        }

        public void setFundType(String fundType) {
            this.fundType = fundType;
        }

        public String getManagementType() {
            return managementType;
        }

        public void setManagementType(String managementType) {
            this.managementType = managementType;
        }

        public String getCustodian() {
            return custodian;
        }

        public void setCustodian(String custodian) {
            this.custodian = custodian;
        }

        public String getOperationalStatus() {
            return operationalStatus;
        }

        public void setOperationalStatus(String operationalStatus) {
            this.operationalStatus = operationalStatus;
        }

        public String getFundFilingStage() {
            return fundFilingStage;
        }

        public void setFundFilingStage(String fundFilingStage) {
            this.fundFilingStage = fundFilingStage;
        }
    }
}
