package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller基类
 *
 * @author Ian.Su
 * @version $Id: BaseController.java, v 0.1 2017/4/20 11:12 Ian.Su Exp $
 */
public class BaseController {

    protected Logger LOGGER = LoggerFactory.getLogger(getClass());



    @Autowired
    private RaCompanyService raCompanyService;


    protected UserPO getSessionUser() {

        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();

        UserPO userPO = (UserPO) attrs.getRequest().getSession().getAttribute(Constants.SESSION_USER);

        return userPO;
    }

    /**
     * 获取用户的所在省份
     */
    protected String getUserProvince() {

        UserPO userPO = getSessionUser();

        return userPO.getProvince();

    }


    /**
     *
     * 检查是否有对当前数据的操作权限
     *
     * */
    protected void checkData(String companyId){
       RaCompanyPO po = raCompanyService.findCompanyById(companyId);
       if(po == null || !StringUtils.equals(po.getProvince(),getUserProvince())){
           throw new CommonException(403,"此账号无权限操作此数据");
       }
    }

}
