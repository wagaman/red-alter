package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 公共数据接口
 * @author Ian.Su
 * @version $Id: CommonController.java, v 0.1 2017/4/21 18:15 Ian.Su Exp $
 */
@Api(tags = "公共接口")
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController {


    @Autowired
    private CommonService comSer;

    @ApiOperation(value="获取城市列表", notes="查询当前用户所属省份的所有城市")
    @RequestMapping(value = "/citys.do",method = RequestMethod.GET)
    public ResponseBean<List<String>> citys(){

        return ResponseBean.successResponse(comSer.getCitys(getUserProvince()));

    }

    @ApiOperation(value="获取区县列表", notes="根据城市获取区县列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query",value = "查询城市", required = true,dataType = "String")
    })
    @RequestMapping(value = "/areas.do",method = RequestMethod.GET)
    public ResponseBean<List<String>> areas(@RequestParam String city){

        return ResponseBean.successResponse(comSer.getAreas(getUserProvince(),city));

    }


    @ApiOperation(value="头部消息提醒", notes="头部邮件图标的消息提醒,返回0表示无新消息,其他表示有新消息")
    @RequestMapping(value = "/top/msg.do",method = RequestMethod.GET)
    public ResponseBean<Integer> msg(){

        return ResponseBean.successResponse(comSer.topMsg(getSessionUser().getUsername(),getSessionUser().getId()));

    }

    @ApiOperation(value="判断一个企业是否为黑名单企业", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", paramType = "query",value = "企业ID", required = true,dataType = "String")
    })
    @RequestMapping(value = "/check/is/black.do",method = RequestMethod.GET)
    public ResponseBean<Boolean> isBlack(@RequestParam String companyId ){

        boolean isBlack = this.comSer.isBlack(companyId);
        return ResponseBean.successResponse(isBlack);
    }

}
