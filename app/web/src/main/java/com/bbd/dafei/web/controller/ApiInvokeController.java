package com.bbd.dafei.web.controller;


import com.bbd.dafei.common.util.ResponseBean;
import com.components.web.controller.ApiDataController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/api/invoke")
@Api(value = "/api/invoke", tags = "第三方接口调用公共类")
public class ApiInvokeController extends ApiDataController {


    @ApiOperation(value = "接口调用", notes = "根据apiID获取数据，其他的参数参考实际接口文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "apiId",
                    paramType = "query",
                    value = "要调用的api的id",
                    required = true,
                    dataType = "String")
    })
    @RequestMapping(value = {"/data.do"},method = {RequestMethod.POST,RequestMethod.GET})
    public ResponseBean<Object> getApiData(@RequestParam String apiId, HttpServletRequest request) throws Exception {

        return ResponseBean.successResponse(super.getApiData(apiId, request));

    }


}
