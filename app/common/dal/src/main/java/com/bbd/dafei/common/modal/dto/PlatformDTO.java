package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * p2p特征信息DTO
 * Created by wish on 2017/5/4.
 */
public class PlatformDTO {
    /** 零壹数据 */
    @SerializedName("qyxg_platform_data")
    private List<PlatformDataDTO> platformDatas;
    /** 网贷之家 */
    @SerializedName("qyxg_wdzj")
    private List<WdzjDTO> wdzjs;

    public List<PlatformDataDTO> getPlatformDatas() {
        return platformDatas;
    }

    public void setPlatformDatas(List<PlatformDataDTO> platformDatas) {
        this.platformDatas = platformDatas;
    }

    public List<WdzjDTO> getWdzjs() {
        return wdzjs;
    }

    public void setWdzjs(List<WdzjDTO> wdzjs) {
        this.wdzjs = wdzjs;
    }
}
