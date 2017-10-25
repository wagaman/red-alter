package com.bbd.dafei.web.controller;


import com.bbd.dafei.biz.shared.UserService;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.ReversibleEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author Ian.Su
 * @version CapitalSearchController.java, v 0.1 2017/7/31 11:12 Ian.Su Exp $
 **/
@Controller
@RequestMapping("/capital")
public class CapitalSearchController {

    @Autowired
    private UserService userService;


    @RequestMapping("/search")
    public void gotoCompanyDetail(@RequestParam String company , HttpServletRequest request,HttpServletResponse resp) throws Exception {

        company = ReversibleEncryption.decrypt(company, ReversibleEncryption.defaultKey);

        UserPO userPO = userService.findByName("capital");

        request.getSession().setAttribute(Constants.SESSION_USER, userPO);

        String type =  URLEncoder.encode("企业名", "utf-8");

        company = URLEncoder.encode(company, "utf-8");

        String redirect = "/main/search/" + type + "/" + company;

        resp.sendRedirect(redirect);

    }

}
