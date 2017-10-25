package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.PersonDetailInfoService;
import com.bbd.dafei.common.modal.vo.PersonDetailInfoVO;
import com.bbd.dafei.common.modal.vo.RaCompanyVO;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *  个人信息页-关联企业列表
 * @author anhong.Tu
 * @version $Id: PersonDetailController.java, v 0.1 2017/7/3114:55 Ian.Su Exp $
 */
@Controller
@RequestMapping("/personDetail")
@Api(value = "/personDetail", tags = " 个人信息页-关联企业列表")
public class PersonDetailController extends BaseController{
    @Autowired
    private PersonDetailInfoService personDetailInfoService;

    @RequestMapping(value = "/getDetailInfo.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID查询关联企业信息", notes = "根据ID查询关联企业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "personId", value = "个人ID", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<PersonDetailInfoVO> getRadarByCompanyId(@RequestParam String personId) throws Exception {
        return ResponseBean.successResponse(personDetailInfoService.getPersonDetailInfo(personId));
    }

    @RequestMapping(value = "/isPerson.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "判断传入ID是否为个人", notes = "判断传入ID是否为个人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "valueId", value = "id", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<Map<String,String>> isPerson(@RequestParam String valueId) throws Exception {
        return ResponseBean.successResponse(personDetailInfoService.isPerson(valueId));
    }
}
