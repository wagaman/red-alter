package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.*;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.dto.RaUpdateDTO;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.ResponseBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2017-04-20.
 */
@Controller
@RequestMapping("/companyDetail")
@Api(value = "/companyDetail", tags = "企业信息")
public class CompanyDetailController extends BaseController {

    @Autowired
    private RaUpdateService raUpdateService;

    @Autowired
    private RaBlackListFocusService focusSer;

    @Autowired
    private RaCompanyService raCompanyService;

    @Autowired
    private RaBlackListService blacklistSer;

    @Autowired
    private RaTimeSqueService raTimeSqueService;

    @Autowired
    private RelationTotalInfoService relationTotalInfoService;

    @RequestMapping(value = "/updateCompanyInfo.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "更正企业信息", notes = "提交企业相关错误信息供核实后修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业ID", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "company", value = "企业名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "content", value = "更正信息描述", required = true, paramType = "query", dataType = "String")})
    @UserLog
    public ResponseBean updateCompanyInfo(@RequestParam String companyId, @RequestParam String company, @RequestParam String content) {

        try {
            UserPO userPO = getSessionUser();
            //参数合法性检查
            if (null == content || content.equals("")) {
                return ResponseBean.errorResponse("更正内容为空，请从新输入");
            }
            if (null == companyId || companyId.equals("")) {
                return ResponseBean.errorResponse("企业ID为空，请从新输入");
            }
            if (null == company || company.equals("")) {
                return ResponseBean.errorResponse("企业名称为空，请从新输入");
            }

            //组装DTO信息
            RaUpdateDTO raUpdateDTO = new RaUpdateDTO();
            raUpdateDTO.setUsername(userPO.getUsername());//用户名
            raUpdateDTO.setCompanyId(companyId);//企业ID
            raUpdateDTO.setCompany(company);//企业名称
            raUpdateDTO.setContent(content);//更正内容描述
            raUpdateDTO.setGmtCreate(new Date());//创建时间
            raUpdateDTO.setGmtUpdate(new Date());//更新时间

            this.raUpdateService.insertCompanyInfo(raUpdateDTO);

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("更正企业信息失败");
            return ResponseBean.errorResponse("更正企业信息失败");
        }
        return ResponseBean.successResponse("更正信息已提交");
    }
    @RequestMapping(value = "/getRadarByCompanyId.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据企业ID查询易燃指数雷达图", notes = "查询企业易燃指数雷达图，如：启阳（成都）投资管理有限公司")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业ID", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<RaCompanyVO> getRadarByCompanyId(String companyId) throws Exception {
        return ResponseBean.successResponse(raCompanyService.getRadarByCompanyId(companyId));
    }
    @RequestMapping(value = "/getScanByCompanyId.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据企业ID查询风险提示", notes = "查询企业风险提示，如：启阳（成都）投资管理有限公司")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业ID", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<RaCompanyVO> getScanByCompanyId(String companyId) throws Exception {
        return ResponseBean.successResponse(raCompanyService.getScanByCompanyId(companyId));
    }
    @RequestMapping(value = "/getSortInfoByCompanyId.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据企业ID易燃指数时序图", notes = "查询企业易燃指数时序图，如：启阳（成都）投资管理有限公司")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业ID", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<RaCompanyVO> getSortInfoByCompanyId(String companyId) throws Exception {
        return ResponseBean.successResponse(raCompanyService.getSortByCompanyId(companyId));
    }
    @RequestMapping(value = "/add/focus.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "加入关注", notes = "将企业加入我的关注列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "企业名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "companyId", value = "企业ID", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "reasons", paramType = "query", value = "加入关注原因", dataType = "String", defaultValue = "[{\"k\":1,\"v\":\"1是标准选项,可能会有0-n 个1\"},{\"k\":2,\"v\":\"2是其他原因,最多只有一个2\"}]")

    })
    @UserLog
    public ResponseBean<String> addFocus(@RequestParam String company,
                                         @RequestParam String companyId,
                                         String reasons) {


        super.checkData(companyId);

        List<KeyValDTO<Integer, String>> addReasons = null;

        if (StringUtils.hasText(reasons)) {
            Gson gson = new Gson();
            addReasons = gson.fromJson(reasons, new TypeToken<List<KeyValDTO<Integer, String>>>() {
            }.getType());
        }


        focusSer.addFocus(getSessionUser().getUsername(), companyId, company, addReasons);

        return ResponseBean.successResponse("成功关注");
    }


    @RequestMapping(value = "/add/blacklist.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "加入黑名单", notes = "将企业加入黑名单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "企业名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "companyId", value = "企业ID", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "reasons", paramType = "query", value = "加入黑名单原因", dataType = "String", required = true, defaultValue = "[{\"k\":1,\"v\":\"1是标准选项,可能会有0-n 个1\"},{\"k\":2,\"v\":\"2是其他原因,最多只有一个2\"}]")

    })
    @UserLog
    public ResponseBean<String> addBlacklist(@RequestParam String company,
                                             @RequestParam String companyId,
                                             @RequestParam String reasons) {


        super.checkData(companyId);

        Gson gson = new Gson();

        List<KeyValDTO<Integer, String>> addReasons = gson.fromJson(reasons, new TypeToken<List<KeyValDTO<Integer, String>>>() {
        }.getType());


        blacklistSer.addBlacklist(getSessionUser().getUsername(), companyId, company, null, null, null, new Date(), Constants.BLACKLIST_JOIN_TYPE_USER, addReasons);

        return ResponseBean.successResponse("成功加入黑名单");
    }

    @RequestMapping(value = "/getTimeSque.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "时序图行业平均数和行业中位数", notes = "时序图行业平均数和行业中位数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", value = "行业名称", required = true, paramType = "query", dataType = "String")})
    public ResponseBean<List<RaTimeSqueVO>> getTimeSque(String industry) throws Exception {
        return ResponseBean.successResponse(raTimeSqueService.getTimeSqueInfo(industry));
    }

//    @RequestMapping(value ="/getRightRelation.do" ,method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="企业详情页面右侧关联方信息", notes = "企业详情页面右侧关联方信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="companyId",value="企业ID",required = true,paramType = "query", dataType="String")
    })
    public ResponseBean<RelationTotalInfoVO> getRightRelation(String companyId) throws Exception {
        return  ResponseBean.successResponse(relationTotalInfoService.getRightRelation(companyId));
    }

    @RequestMapping(value ="/queryBottomRelationInfo.do" ,method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="企业详情页面-下方关联方列表信息", notes = "企业详情页面关联方列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="companyId",value="企业ID",required = true,paramType = "query", dataType="String"),
            @ApiImplicitParam(name="degree",value="关联度数",required = true,paramType = "query", dataType="int"),
            @ApiImplicitParam(name="type",value="取值类型",required = true,paramType = "query", dataType="String"),
            @ApiImplicitParam(name="companyIdList",value="企业列表",required = false,paramType = "query", dataType="String"),
            @ApiImplicitParam(name="sortColumn",value="排序条件",required = false,paramType = "query", dataType="String"),
            @ApiImplicitParam(name="sortType",value="排序方式",required = false,paramType = "query", dataType="String"),
            @ApiImplicitParam(name="isSort",value="是否排序",required = true,paramType = "query", dataType="int")
    })
    public ResponseBean<List<RelationListInfoVO>> getBottomRelationInfo(String companyId,int degree,String type,String companyIdList,String sortColumn,String sortType,int isSort) throws Exception {
        return  ResponseBean.successResponse(relationTotalInfoService.queryBottomRelationInfo(companyId,degree,type,companyIdList,sortColumn,sortType,isSort));
    }

    @RequestMapping(value ="/isBlack.do" ,method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="企业详情页面-下方关联方列表信息(判断是否为黑名单企业)", notes = "企业详情页面-下方关联方列表信息(判断是否为黑名单企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name="companyId",value="企业ID",required = true,paramType = "query", dataType="String")
    })
    public ResponseBean<Map<String,String>> getBottomRelationInfo(String companyId) throws Exception {
        Map<String,String> dataMap = new HashMap<>();
        Set<String> companyIds = new HashSet<>();
        companyIds.add(companyId);
        List<String> value   = blacklistSer.findBlackListByCompanyIds(companyIds);
        if(CollectionUtils.isNotEmpty(value)){
            dataMap.put("isBlack","true");
        }else{
            dataMap.put("isBlack","false");
        }
        return ResponseBean.successResponse(dataMap);
    }

}

