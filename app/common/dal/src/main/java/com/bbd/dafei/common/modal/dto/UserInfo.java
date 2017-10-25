package com.bbd.dafei.common.modal.dto;

/**
 * 用户信息
 * @author Ian.Su
 * @version $Id: UserInfo.java, v 0.1 2017/4/27 16:38 Ian.Su Exp $
 */
public class UserInfo {

    /**
     * 用户当前登录的ip地址
     * */
    String ip;

    /**
     * 用户当前登录的ip归属地
     * */
    String ipLocation;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }
}
