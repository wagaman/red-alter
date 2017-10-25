package com.bbd.dafei.common.dal.po;

import java.util.Date;

/** 公司PO
 * Created by wish on 2017/4/25.
 */
public class RaCompanyPO {
    /** id */
    private String id;
    /** 省份 */
    private String province;
    /** 市 */
    private String city;
    /** 区/县 */
    private String area;
    /** 企业名称 */
    private String company;
    /** 易燃指数 */
    private Float riskIndex;
    /** 风险等级 */
    private String riskLevel;
    /** 易燃指数是否上升；1:上升，0：持平，-1：下降 */
    private Integer rise;
    /** 行业；如：网络借贷 */
    private String industry;
    /** 易燃指数雷达图;Json值，格式为：{"平台合规性风险":42.1, "平台关联方综合风险":92.1, "综合实力风险":72.1, "声誉风险":2.8, "交易指标风险":2.1,"综合":76.2} */
    private String indexRadar;
    /** 风险扫描；{"交易指标风险":["企业的诉讼数量较多","企业受到行政处罚"],"企业声誉风险":["地址相同的关联企","地址相同的关联企"]} */
    private String riskScan;
    /** 易燃指数时序图;{"2016-01":30,"2016-02":20,"207-01":10} */
    private String indexSort;
    /** 企业详细信息;Json:格式为：[{"type":"工商变更","value":1,"isupdate":"y"},{"type":"诉讼信息","value":2,"isupdate":"n"},....] */
    private String companyDetail;
    /** 创建时间 */
    private Date gmtCreate;
    /** 修改时间 */
    private Date gmtUpdate;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Float getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(Float riskIndex) {
        this.riskIndex = riskIndex;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Integer getRise() {
        return rise;
    }

    public void setRise(Integer rise) {
        this.rise = rise;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndexRadar() {
        return indexRadar;
    }

    public void setIndexRadar(String indexRadar) {
        this.indexRadar = indexRadar;
    }

    public String getRiskScan() {
        return riskScan;
    }

    public void setRiskScan(String riskScan) {
        this.riskScan = riskScan;
    }

    public String getIndexSort() {
        return indexSort;
    }

    public void setIndexSort(String indexSort) {
        this.indexSort = indexSort;
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail;
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
