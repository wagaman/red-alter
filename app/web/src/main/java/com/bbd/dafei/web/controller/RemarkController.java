package com.bbd.dafei.web.controller;

/**
 * Created by wish on 2017/4/26.
 */

import com.bbd.dafei.biz.shared.RaCompanyRemarkService;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.RaCompanyRemarkDTO;
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

@Controller
@RequestMapping("/remark")
@Api(value = "/remark", tags = "备注")
public class RemarkController extends BaseController {

    @Autowired
    private RaCompanyRemarkService raCompanyRemarkService;

    @RequestMapping(value = "saveRemark.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "保存备注", notes = "用户对公司保存备注信息(需登录)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司Id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "platform", value = "平台", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "mark", value = "备注", required = true, paramType = "query", dataType = "String")
    })
    @UserLog
    public ResponseBean saveRemark(@RequestParam String companyId, String platform, @RequestParam String mark) {
        UserPO userPO = getSessionUser();
        raCompanyRemarkService.saveRemark(companyId, platform, userPO.getUsername(), mark);
        return ResponseBean.successResponse(null, "保存成功");
    }

    @RequestMapping(value = "findRemarkList.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询备注", notes = "根据公司id和平台（可选）查询备注(需登录)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司Id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "platform", value = "平台", paramType = "query", dataType = "String")
    })
    public ResponseBean<List<RaCompanyRemarkDTO>> findRemarkList(@RequestParam String companyId, String platform) {
        UserPO userPO = getSessionUser();
        List<RaCompanyRemarkDTO> raCompanyRemarkDTOList = raCompanyRemarkService.findRemarkByCompanyIdAndUserName(companyId, platform, userPO.getUsername());
        return ResponseBean.successResponse(raCompanyRemarkDTOList);
    }

    @RequestMapping(value = "deleteRemark.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除备注", notes = "根据id删除备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "备注id", required = true, paramType = "query", dataType = "Integer")
    })
    @UserLog
    public ResponseBean deleteRemark(@RequestParam Integer id) {
        UserPO userPO = getSessionUser();
        raCompanyRemarkService.deleteRemarkById(id, userPO.getUsername());
        return ResponseBean.successResponse(null, "删除成功");
    }

}
