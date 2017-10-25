package com.bbd.dafei.common.modal.dto;

import com.bbd.dafei.common.util.ReturnBeanable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shi.jun on 2017/9/20.
 */
public class RelationRightInfoDTO implements ReturnBeanable{

    @SerializedName("pivotal_natural_persons_top_1d")
    //一度关联自然人
    private String keyNature1d;
    @SerializedName("pivotal_natural_persons_top_2d")
    //二度关联自然人
    private String keyNature2d;
    @SerializedName("pivotal_natural_persons_top_3d")
    //三度关联自然人
    private String keyNature3d;
    @SerializedName("pivotal_non_natural_persons_top_1d")
    //一度关联非自然人
    private String keyNoNature1d;
    @SerializedName("pivotal_non_natural_persons_top_2d")
    //二度关联非自然人
    private String keyNoNature2d;
    @SerializedName("pivotal_non_natural_persons_top_3d")
    //三度关联非自然人
    private String keyNoNature3d;
    @SerializedName("industry_span_ratio_1d")
    //一度集聚行业
    private List<String[]> keyIndustry1d;
    @SerializedName("industry_span_ratio_2d")
    //二度集聚行业
    private List<String[]> keyIndustry2d;
    @SerializedName("industry_span_ratio_3d")
    //三度集聚行业
    private List<String[]> keyIndustry3d;
    @SerializedName("_id")
    //企业信息ID
    private String companyId;
    @SerializedName("error")
    private String errorCode;

    public String getKeyNature1d() {
        return keyNature1d;
    }

    public void setKeyNature1d(String keyNature1d) {
        this.keyNature1d = keyNature1d;
    }

    public String getKeyNature2d() {
        return keyNature2d;
    }

    public void setKeyNature2d(String keyNature2d) {
        this.keyNature2d = keyNature2d;
    }

    public String getKeyNature3d() {
        return keyNature3d;
    }

    public void setKeyNature3d(String keyNature3d) {
        this.keyNature3d = keyNature3d;
    }

    public String getKeyNoNature1d() {
        return keyNoNature1d;
    }

    public void setKeyNoNature1d(String keyNoNature1d) {
        this.keyNoNature1d = keyNoNature1d;
    }

    public String getKeyNoNature2d() {
        return keyNoNature2d;
    }

    public void setKeyNoNature2d(String keyNoNature2d) {
        this.keyNoNature2d = keyNoNature2d;
    }

    public String getKeyNoNature3d() {
        return keyNoNature3d;
    }

    public void setKeyNoNature3d(String keyNoNature3d) {
        this.keyNoNature3d = keyNoNature3d;
    }

    public List<String[]> getKeyIndustry1d() {
        return keyIndustry1d;
    }

    public void setKeyIndustry1d(List<String[]> keyIndustry1d) {
        this.keyIndustry1d = keyIndustry1d;
    }

    public List<String[]> getKeyIndustry2d() {
        return keyIndustry2d;
    }

    public void setKeyIndustry2d(List<String[]> keyIndustry2d) {
        this.keyIndustry2d = keyIndustry2d;
    }

    public List<String[]> getKeyIndustry3d() {
        return keyIndustry3d;
    }

    public void setKeyIndustry3d(List<String[]> keyIndustry3d) {
        this.keyIndustry3d = keyIndustry3d;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean accessApiSuccess() {
        if(errorCode == null) {
            return true;
        }
        return false;
    }

    @Override
    public String errorDescribe() {
        return null;
    }
}
