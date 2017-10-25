package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaCompanyVO;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 导出报告
 * @author Ian.Su
 * @version $Id: DownloadReport.java, v 0.1 2017/5/25 15:40 Ian.Su Exp $
 */
@RestController
@RequestMapping("/download")
@Api(value = "/download", tags = "导出报告")
public class DownloadReportController extends BaseController {

    @Autowired
    private RaCompanyService companyService;


    @RequestMapping(value = "/search.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "研报查询", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "查询关键字", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query", dataType = "Integer")})
    public ResponseBean<PageInfo<RaCompanyPO>> search(@RequestParam String keyword,
                                                      PageInfoIgnore page){

        PageInfo<RaCompanyPO> pageInfo = companyService.search(page,keyword);

        return ResponseBean.successResponse(pageInfo);

    }

}
