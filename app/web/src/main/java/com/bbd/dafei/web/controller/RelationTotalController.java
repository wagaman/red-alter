package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RelationRightInfoService;
import com.bbd.dafei.common.modal.vo.RelationRightVO;
import com.bbd.dafei.common.modal.vo.RelationTotalInfoVO;
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

/**
 * Created by shi.jun on 2017/9/20.
 */
@Controller
@RequestMapping("/relationtotal")
@Api(value = "/relationtotal", tags = "企业详情页面右侧关联方信息")
public class RelationTotalController {

    @Autowired
    private RelationRightInfoService relationRightInfoService;

    @RequestMapping(value = "/getRelationTotal.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询企业关联全部信息", notes = "根据企业id和关联度查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qyxxId", value = "公司id", required = true, paramType = "query", dataType = "String"),
    })
    public ResponseBean<RelationTotalInfoVO> getRelationTotal(@RequestParam("companyId") String qyxxId) throws Exception {
        RelationTotalInfoVO relationTotalInfoVO = relationRightInfoService.getRightRelation(qyxxId);
        return ResponseBean.successResponse(relationTotalInfoVO);
    }

}
