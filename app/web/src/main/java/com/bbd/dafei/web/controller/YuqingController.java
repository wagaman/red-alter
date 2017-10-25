package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.YuqingService;
import com.bbd.dafei.common.modal.dto.YuqingContentDTO;
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
 * Created by wish on 2017/8/20.
 */
@Controller
@RequestMapping("/yuqing")
@Api(value = "/yuqing", tags = "舆情")
public class YuqingController {

    @Autowired
    private YuqingService yuqingService;

    @RequestMapping(value = "/getYuqingContentByCompanyId.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据公司id查询舆情", notes = "根据公司id查询舆情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序（情感分数升序，情感分数降序，发布时间升序，发布时间降序）", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<YuqingContentDTO>> getYuqingContentByCompanyId(@RequestParam String companyId, @RequestParam(defaultValue = "情感分数升序") String sort, @RequestParam(defaultValue = "1") Integer page,
                                                                                @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        PageInfo<YuqingContentDTO> pageInfo = yuqingService.getYuqingContentByCompanyId(companyId, sort, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/getYuqingContentByCompanyIdAndRelate.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据公司id和相关公司人物查询舆情", notes = "根据公司id和相关公司人物查询舆情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序（情感分数升序，情感分数降序，发布时间升序，发布时间降序）", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "qc", value = "相关公司或人物", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "1：相关公司，2：相关人物", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    public ResponseBean<PageInfo<YuqingContentDTO>> getYuqingContentByCompanyIdAndRelate(@RequestParam String companyId, @RequestParam String qc, @RequestParam String type, @RequestParam(defaultValue = "情感分数升序") String sort,
                                                                                         @RequestParam(defaultValue = "1") Integer page,
                                                                                         @RequestParam(defaultValue = "3") Integer pageSize
    ) throws Exception {
        PageInfo<YuqingContentDTO> pageInfo = yuqingService.getYuqingContentByCompanyIdAndRelate(companyId, qc, type, sort, page, pageSize);
        return ResponseBean.successResponse(pageInfo);
    }
}
