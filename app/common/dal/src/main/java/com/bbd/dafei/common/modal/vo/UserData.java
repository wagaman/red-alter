package com.bbd.dafei.common.modal.vo;

import com.bbd.dafei.common.dal.po.UserPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ian.Su
 * @version $Id: UserData.java, v 0.1 2017/4/24 15:45 Ian.Su Exp $
 */
@ApiModel(value = "个人中心-头部信息")
public class UserData {

    @ApiModelProperty("个人信息")
    private UserPO userPo;

    @ApiModelProperty("剩余研报次数")
    private int surplusResearchReport;

    @ApiModelProperty("关注企业数")
    private int attention;

    @ApiModelProperty("黑名单企业数")
    private int blackList;

    @ApiModelProperty("研报已下载次数")
    private int downloadResearchReport;

    public UserPO getUserPo() {
        return userPo;
    }

    public void setUserPo(UserPO userPo) {
        this.userPo = userPo;
    }

    public int getSurplusResearchReport() {
        return surplusResearchReport;
    }

    public void setSurplusResearchReport(int surplusResearchReport) {
        this.surplusResearchReport = surplusResearchReport;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public int getBlackList() {
        return blackList;
    }

    public void setBlackList(int blackList) {
        this.blackList = blackList;
    }

    public int getDownloadResearchReport() {
        return downloadResearchReport;
    }

    public void setDownloadResearchReport(int downloadResearchReport) {
        this.downloadResearchReport = downloadResearchReport;
    }
}
