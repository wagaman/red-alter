package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.*;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.modal.util.BaseDataUtil;
import com.bbd.dafei.common.modal.util.CompanyPermissionUtil;
import com.bbd.dafei.common.modal.vo.BaseDataAbstractVO;
import com.bbd.dafei.common.modal.vo.BaseDataOverviewVO;
import com.bbd.dafei.common.modal.vo.BaseDataVO;
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

/**
 * 企业基本信息Controller
 * Created by wish on 2017/4/17.
 */
@Controller
@RequestMapping("/baseData")
@Api(value = "/baseData", tags = "企业基本信息")
public class BaseDataController extends BaseController {

    @Autowired
    private BaseDataService baseDataService;

    @Autowired
    private RaReportDetailService raReportDetailService;

    @Autowired
    private RaBlackListFocusService raBlackListFocusService;

    @Autowired
    private RaCompanyService raCompanyService;

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/getBaseData.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询工商数据", notes = "根据公司id查询工商数据,包含工商信息，股东信息，董事，监事，高管")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<BaseDataVO> getBaseData(@RequestParam String companyId) throws Exception {
        BaseDataVO baseDataVO = baseDataService.getBaseDataByCompanyId(companyId);
        return ResponseBean.successResponse(baseDataVO);
    }

    @RequestMapping(value = "/getOverseasInvest.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询境外投资信息", notes = "根据公司id查询境外投资信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<OverseasInvestDTO>> getOverseasInvest(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                                       @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<OverseasInvestDTO> pageInfo = baseDataService.getOverseasInvestByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getBaseDataOverview.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询基本信息概览", notes = "根据公司id查询基本信息概览(需用户登录)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<BaseDataOverviewVO> getBaseDataOverview(@RequestParam String companyId) throws Exception {

        UserPO userPo = getSessionUser();
        BaseDataOverviewDTO baseDataOverviewDTO = baseDataService.getBaseDataOverviewByCompanyId(companyId);
        BlackFocusNumDTO blackFocusNumDTO = raBlackListFocusService.findBlackAndFocusNum(companyId, userPo.getUsername(), userPo.getProvince());

        BaseDataOverviewVO baseDataOverviewVO = BaseDataUtil.transToBaseDataOverviewVO(baseDataOverviewDTO, blackFocusNumDTO);
        if (!CompanyPermissionUtil.hasPermission(userPo.getProvince(), baseDataOverviewVO.getCompanyProvince())) {
            return ResponseBean.errorResponse(403, "当前用户无查看该公司权限");
        }
        String reportStatus = raReportDetailService.findLastReportStatus(userPo.getId(), companyId);
        baseDataOverviewVO.setReportStatus(reportStatus);

        return ResponseBean.successResponse(baseDataOverviewVO);

    }

    @RequestMapping(value = "/getCompanyAbstract.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询企业摘要信息", notes = "根据公司id查询企业摘要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<BaseDataAbstractVO> getCompanyAbstract(@RequestParam String companyId) throws Exception {
        BaseDataAbstractDTO baseDataAbstractDTO = baseDataService.getBaseDataAbstractByCompanyId(companyId);
        RaCompanyPO raCompanyPO = raCompanyService.findCompanyById(companyId);
        boolean black = commonService.isBlack(companyId);
        BaseDataAbstractVO baseDataAbstractVO = BaseDataUtil.transToBaseDataAbstractVO(baseDataAbstractDTO, raCompanyPO, black);

        return ResponseBean.successResponse(baseDataAbstractVO);
    }

    @RequestMapping(value = "/getFzjg.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询分支机构信息", notes = "根据公司id查询分支机构信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<FzjgDTO>> getFzjg(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<FzjgDTO> pageInfo = baseDataService.getFzjgByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

}
