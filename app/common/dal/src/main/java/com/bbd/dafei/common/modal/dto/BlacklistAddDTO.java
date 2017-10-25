package com.bbd.dafei.common.modal.dto;

import java.util.Date;

/**
 * @author Ian.Su
 * @version $Id: BlacklistAddDTO.java, v 0.1 2017/6/10 11:25 Ian.Su Exp $
 */
public class BlacklistAddDTO extends CommonDTO {



    private Date joinDate;

    private short joinType;

    public short getJoinType() {
        return joinType;
    }

    public void setJoinType(short joinType) {
        this.joinType = joinType;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
