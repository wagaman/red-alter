package com.bbd.dafei.common.modal.dto;

import java.util.Date;

/**
 * @author Ian.Su
 * @version $Id: BlackWhiteDTO.java, v 0.1 2017/5/18 14:38 Ian.Su Exp $
 */
public class BlackWhiteDTO {

    private String id;//	varchar	100	0	0	0	0	0	0		0	企业ID	utf8	utf8_general_ci		-1	0
    private String company;//	varchar	100	0	-1	0	0	0	0		0	企业名称	utf8	utf8_general_ci		0	0
    private String reason;//	varchar	255	0	-1	0	0	0	0		0	加入黑名单原因	utf8	utf8_general_ci		0	0
    private short isBlack;//	tinyint	4	0	0	0	0	0	0	0	0	0:白名单,1:黑名单				0	0
    private String province;
    private String city;
    private String area;
    private String joinSouce;
    private Date joinDate;

    public String getJoinSouce() {
        return joinSouce;
    }

    public void setJoinSouce(String joinSouce) {
        this.joinSouce = joinSouce;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public short getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(short isBlack) {
        this.isBlack = isBlack;
    }
}
