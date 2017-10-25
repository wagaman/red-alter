package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.common.modal.vo.RaCompanyVO;
import com.bbd.dafei.common.util.ResponseBean;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tuanhong on 2017-04-27.
 */
@Controller
@RequestMapping("/imagePage")
@Api(value = "/imagePage", tags = "导出PDF用的图片页面")
public class ImagePageCcontroller {
    @Autowired
    private RaCompanyService raCompanyService;

    @RequestMapping(value ="/getRadarImage.do",method = RequestMethod.GET)
    @ApiOperation(value = "易燃指数雷达图", notes = "查询企业易燃指数雷达图，如：启阳（成都）投资管理有限公司")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "企业名称", required = true, paramType = "query", dataType = "String")})
    public String getRadarImage(String company, HttpServletRequest request) throws Exception{


        RaCompanyVO raCompanyVO= raCompanyService.getRadarByCompany(company);

        String json = new Gson().toJson(raCompanyVO);

        request.setAttribute("data",json);

        return "main/pdfRadar";
    }
}
