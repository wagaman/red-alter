package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 关联聚集地
 * Created by wish on 2017/5/6.
 */
public class GatherPlaceDTO {
    /** 1度关联聚集地 */
    @SerializedName("1")
    private List<String> gatherPlaceTop1d;
    /** 2度关联聚集地 */
    @SerializedName("2")
    private List<String> gatherPlaceTop2d;
    /** 3度关联聚集地 */
    @SerializedName("3")
    private List<String> gatherPlaceTop3d;

    public List<String> getGatherPlaceTop1d() {
        return gatherPlaceTop1d;
    }

    public void setGatherPlaceTop1d(List<String> gatherPlaceTop1d) {
        this.gatherPlaceTop1d = gatherPlaceTop1d;
    }

    public List<String> getGatherPlaceTop2d() {
        return gatherPlaceTop2d;
    }

    public void setGatherPlaceTop2d(List<String> gatherPlaceTop2d) {
        this.gatherPlaceTop2d = gatherPlaceTop2d;
    }

    public List<String> getGatherPlaceTop3d() {
        return gatherPlaceTop3d;
    }

    public void setGatherPlaceTop3d(List<String> gatherPlaceTop3d) {
        this.gatherPlaceTop3d = gatherPlaceTop3d;
    }
}
