package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.ManageDataService;
import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.modal.util.YearReportUtil;
import com.bbd.dafei.common.modal.vo.YearReportVO;
import com.bbd.dafei.common.util.PageInfo;
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

import java.util.List;

/**
 * 企业经营信息Controller
 * Created by wish on 2017/4/19.
 */
@Controller
@RequestMapping("/manageData")
@Api(value = "/manageData", tags = "企业经营信息")
public class ManageDataController {

    @Autowired
    private ManageDataService manageDataService;

    @RequestMapping(value = "/getBgxx.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询工商变更信息", notes = "根据公司id查询工商变更信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<BgxxDTO>> getBgxx(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<BgxxDTO> bgxxDTOList = manageDataService.getBgxxByCompanyId(companyId, page, pageSize, true);
        return ResponseBean.successResponse(bgxxDTOList);
    }

    @RequestMapping(value = "/getYuqing.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询舆情", notes = "根据公司id查询舆情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<YuqingDTO>> getYuqing(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                       @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<YuqingDTO> pageInfo = manageDataService.getYuqingByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getYmba.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询域名备案信息", notes = "根据公司id查询域名备案")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<YmbaDTO>> getYmba(@RequestParam String
                                                           companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<YmbaDTO> pageInfo = manageDataService.getYmbaBycompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getYearReport.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询年报信息", notes = "根据公司id查询年报信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<List<YearReportVO>> getYearReport(@RequestParam String companyId) throws Exception {
        YearReportDTO yearReportDTO = manageDataService.getYearReportByCompanyId(companyId);
        List<YearReportVO> yearReportVOList = YearReportUtil.transYearReportDTOToVO(yearReportDTO);
        return ResponseBean.successResponse(yearReportVOList);
    }

    @RequestMapping(value = "/getRecruit.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询招聘数据信息", notes = "根据公司id查询招聘数据信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<RecruitDTO>> getRecruit(@RequestParam String
                                                                 companyId, @RequestParam(defaultValue = "1") Integer page,
                                                         @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<RecruitDTO> pageInfo = manageDataService.getRecruitBycompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getRecruitKPI.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询招聘数据KPI信息", notes = "根据公司id查询招聘数据KPI信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<RecruitKPIDTO> getRecruitKPI(@RequestParam String companyId) throws Exception {
        RecruitKPIDTO recruitKPIDTO = manageDataService.getRecruitKPIByCompanyId(companyId);
        return ResponseBean.successResponse(recruitKPIDTO);
    }

}
