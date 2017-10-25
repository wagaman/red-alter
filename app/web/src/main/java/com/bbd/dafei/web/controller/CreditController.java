package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CreditService;
import com.bbd.dafei.common.modal.dto.*;
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
 * 企业信用信息Controller
 * Created by wish on 2017/4/20.
 */
@Controller
@RequestMapping("/credit")
@Api(value = "/credit", tags = "企业信用信息")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @RequestMapping(value = "/getKtgg.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询开庭公告信息", notes = "根据公司id查询开庭公告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<KtggDTO>> getKtgg(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<KtggDTO> pageInfo = creditService.getKtggByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getCpws.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询裁判文书信息", notes = "根据公司id查询裁判文书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<CpwsDTO>> getCpws(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<CpwsDTO> pageInfo = creditService.getCpwsByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getFygg.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询法院公告", notes = "根据公司id查询法院公告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<FyggDTO>> getFygg(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<FyggDTO> pageInfo = creditService.getFyggByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getBzxr.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询被执行人信息", notes = "根据公司id查询被执行人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<BzxrDTO>> getBzxr(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<BzxrDTO> pageInfo = creditService.getBzxrByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getSxbzxr.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询失信被执行人信息", notes = "根据公司id查询失信被执行人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<SxbzxrDTO>> getSxbzxr(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                       @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<SxbzxrDTO> pageInfo = creditService.getSxbzxrByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getSfpm.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询司法拍卖信息", notes = "根据公司id查询司法拍卖信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<SfpmDto>> getSfpm(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<SfpmDto> pageInfo = creditService.getSfpmByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getJyyc.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询经营异常信息", notes = "根据公司id查询经营异常信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<JyycDTO>> getJyyc(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<JyycDTO> pageInfo = creditService.getJyycByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getQsmd.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询欠税名单", notes = "根据公司id查询欠税名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<QsmdDTO>> getQsmd(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<QsmdDTO> pageInfo = creditService.getQsmdByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getQsxx.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询清算信息", notes = "根据公司id查询清算信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<QsxxDTO>> getQsxx(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<QsxxDTO> pageInfo = creditService.getQsxxByCompanyId(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);

    }

    @RequestMapping(value = "/getSharesPawn.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询股权出质信息", notes = "根据公司id查询股权出质信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<SharesPawnDTO>> getSharesPawn(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                               @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<SharesPawnDTO> pageInfo = creditService.getSharesPawn(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);

    }

    @RequestMapping(value = "/getMortgageDetail.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询动产抵押信息", notes = "根据公司id查询动产抵押信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<MortgageDetailDTO>> getMortgageDetail(@RequestParam String companyId, @RequestParam(defaultValue = "1") Integer page,
                                                                       @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<MortgageDetailDTO> pageInfo = creditService.getMortgageDetail(companyId, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }
}
