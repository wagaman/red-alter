package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RelationService;
import com.bbd.dafei.common.modal.dto.RelationInfoDTO;
import com.bbd.dafei.common.modal.util.RelationUtil;
import com.bbd.dafei.common.modal.vo.RelationDataVO;
import com.bbd.dafei.common.modal.vo.RelationInfoVO;
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
 * Created by wish on 2017/4/23.
 */
@Controller
@RequestMapping("/relation")
@Api(value = "/relation", tags = "企业关联方信息")
public class RelationController extends BaseController {

    @Autowired
    private RelationService relationService;

    @RequestMapping(value = "/getRelationInfo.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询企业关联信息", notes = "根据公司id查询企业关联信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<RelationInfoVO> getRelationInfo(@RequestParam String companyId) throws Exception {
        RelationInfoDTO relationInfoDTO = relationService.getRelationInfoByCompanyId(companyId);
        RelationInfoVO relationInfoVO = RelationUtil.transRelationInfoDTOToRelationInfoVO(relationInfoDTO);
        return ResponseBean.successResponse(relationInfoVO);
    }

    @RequestMapping(value = "/getRelationNodeAndLink.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询企业的关联节点和关联关系", notes = "根据数据平台的id查询企业的关联节点和关联关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qyxxId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "degree", value = "关联度(1到3)", required = true, paramType = "query", dataType = "Integer")
    })
    public ResponseBean<RelationDataVO> getRelationNodeAndLink(@RequestParam String qyxxId, @RequestParam int degree) throws Exception {
        RelationDataVO relationDataVO = relationService.getRelationNodesAndLinks(qyxxId, degree);
        return ResponseBean.successResponse(relationDataVO);
    }

}
