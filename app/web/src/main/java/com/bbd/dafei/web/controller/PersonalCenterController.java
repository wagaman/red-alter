package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RaBlackListFocusService;
import com.bbd.dafei.biz.shared.RaBlackListService;
import com.bbd.dafei.biz.shared.RaResearchReportService;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.RaResearchReportPO;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaBlackListFocusVO;
import com.bbd.dafei.common.modal.vo.RaBlackListVO;
import com.bbd.dafei.common.modal.vo.UserData;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import com.bbd.dafei.common.util.ResponseBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 个人中心（用户信息相关接口）
 *
 * @author Ian.Su
 * @version $Id: PersonalCenterController.java, v 0.1 2017/4/24 14:55 Ian.Su Exp $
 */
@Api(value = "/personal", tags = "个人中心(头部、我的关注及黑名单)")
@RestController
@RequestMapping("/personal")
public class PersonalCenterController extends BaseController {

    @Autowired
    private RaResearchReportService resrepSer;

    @Autowired
    private RaBlackListFocusService raBlackFocSer;

    @Autowired
    private RaBlackListService blackListSer;


    @ApiOperation(value = "个人中心-汇总信息", notes = "查询个人中心各种汇总信息")
    @RequestMapping(value = "/count/data.do", method = RequestMethod.GET)
    public ResponseBean<UserData> countData() throws Exception {

        UserData user = new UserData();

        UserPO userPo = getSessionUser();

        user.setUserPo(userPo);

        RaResearchReportPO resRep = resrepSer.findByUserId(userPo.getId());

        if (resRep != null) {
            user.setSurplusResearchReport(resRep.getRemainingNumber());
        }

        user.setDownloadResearchReport(resrepSer.countDoneAndApply(userPo.getId()));

        int attention = raBlackFocSer.countFocusByUserId(userPo.getUsername());
        user.setAttention(attention);

        int blacklist = raBlackFocSer.countBlackByUserId(userPo.getUsername());
        user.setBlackList(blacklist);

        return ResponseBean.successResponse(user);
    }


    @ApiOperation(value = "风险变动提示列表查询", notes = "风险变动提示分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query", value = "当前页", dataType = "Integer", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页记录数", dataType = "Integer", defaultValue = "10", required = true)
    })
    @RequestMapping(value = "/risk/change.do", method = RequestMethod.GET)
    public ResponseBean<PageInfo<RaBlackListFocusVO>> riskChange(PageInfoIgnore p) throws Exception {

        String username = getSessionUser().getUsername();

        Object ro = raBlackFocSer.queryRiskChange(username, p);

        return ResponseBean.successResponse(ro);
    }


    @ApiOperation(value = "风险变动提示-查看企业信息", notes = "风险变动提示-点击企业名后将该企业的状态设置为已查看")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "关注id", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "company", paramType = "query", value = "企业名称", dataType = "String", required = true)
    })
    @RequestMapping(value = "/look/over/risk/company.do", method = RequestMethod.GET)
    public ResponseBean<String> lookOverRiskCompany(@RequestParam Integer id,
                                                    @RequestParam String company) {

        raBlackFocSer.updateLookOverById(id);

        return ResponseBean.successResponse("已设置状态为已查看");
    }


    @ApiOperation(value = "关注列表", notes = "个人中心-我的关注-关注列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", paramType = "query", value = "行业", dataType = "String", defaultValue = "全部行业", required = true),
            @ApiImplicitParam(name = "riskLevel", paramType = "query", value = "风险级别", dataType = "String", defaultValue = "全部风险", required = true),
            @ApiImplicitParam(name = "order", paramType = "query", value = "排序字段", dataType = "String", defaultValue = "易燃指数", required = true),
            @ApiImplicitParam(name = "descAsc", paramType = "query", value = "排序方式", dataType = "String", defaultValue = "降序", required = true),
            @ApiImplicitParam(name = "page", paramType = "query", value = "当前页", dataType = "Integer", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页记录数", dataType = "Integer", defaultValue = "10", required = true)
    })
    @RequestMapping(value = "/my/focus.do", method = RequestMethod.GET)
    public ResponseBean<PageInfo<RaBlackListFocusVO>> myFocus(PageInfoIgnore p,
                                                              @RequestParam String industry,
                                                              @RequestParam String riskLevel,
                                                              @RequestParam String order,
                                                              @RequestParam String descAsc) throws Exception {

        industry = ("全部行业".equals(industry) ? null : industry);
        riskLevel = ("全部风险".equals(riskLevel) ? null : riskLevel);
        order = ("易燃指数".equals(order) ? "b.risk_index" : "a.gmt_create");
        descAsc = ("降序".equals(descAsc) ? "desc" : "asc");

        String username = getSessionUser().getUsername();

        Object ro = raBlackFocSer.queryMyFocus(p, 2, username, industry, riskLevel, order, descAsc);

        return ResponseBean.successResponse(ro);
    }


    @ApiOperation(value = "取消关注", notes = "个人中心-我的关注-关注列表-取消关注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "取消关注id", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "company", paramType = "query", value = "企业名称", dataType = "String", required = true)
    })
    @RequestMapping(value = "/cancel/focus.do", method = RequestMethod.GET)
    @UserLog
    public ResponseBean<String> cancelFocus(@RequestParam Integer id,
                                            @RequestParam String company) {

        raBlackFocSer.cancelFocus(id, 1);

        return ResponseBean.successResponse("已成功取消关注.");
    }


    @ApiOperation(value = "黑名单列表", notes = "个人中心-黑名单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", paramType = "query", value = "行业", dataType = "String", defaultValue = "全部行业", required = true),
            @ApiImplicitParam(name = "riskLevel", paramType = "query", value = "风险级别", dataType = "String", defaultValue = "全部风险", required = true),
            @ApiImplicitParam(name = "order", paramType = "query", value = "排序字段", dataType = "String", defaultValue = "易燃指数", required = true),
            @ApiImplicitParam(name = "descAsc", paramType = "query", value = "排序方式", dataType = "String", defaultValue = "降序", required = true),
            @ApiImplicitParam(name = "page", paramType = "query", value = "当前页", dataType = "Integer", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页记录数", dataType = "Integer", defaultValue = "10", required = true)
    })
    @RequestMapping(value = "/my/blacklist.do", method = RequestMethod.GET)
    public ResponseBean<PageInfo<RaBlackListVO>> myBlacklist(PageInfoIgnore p,
                                                             @RequestParam String industry,
                                                             @RequestParam String riskLevel,
                                                             @RequestParam String order,
                                                             @RequestParam String descAsc) throws Exception {

        industry = ("全部行业".equals(industry) ? null : industry);
        riskLevel = ("全部风险".equals(riskLevel) ? null : riskLevel);
        order = ("易燃指数".equals(order) ? "risk_index" : "a.join_date");
        descAsc = ("降序".equals(descAsc) ? "desc" : "asc");

        String username = getSessionUser().getUsername();

        Object ro = blackListSer.queryAddCancel(username, null,
                null, null,
                industry, riskLevel,
                p.getStart(), p.getPageSize(),
                order, descAsc);

        return ResponseBean.successResponse(ro);
    }

    @ApiOperation(value = "黑名单列表", notes = "个人中心-黑名单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", paramType = "query", value = "行业", dataType = "String", defaultValue = "全部行业", required = true),
            @ApiImplicitParam(name = "riskLevel", paramType = "query", value = "风险级别", dataType = "String", defaultValue = "全部风险", required = true)
    })
    @RequestMapping(value = "/my/blacklistCount.do", method = RequestMethod.GET)
    public ResponseBean<Integer> myBlacklistCount(@RequestParam String industry,@RequestParam String riskLevel) throws Exception {

        industry = ("全部行业".equals(industry) ? null : industry);
        riskLevel = ("全部风险".equals(riskLevel) ? null : riskLevel);
        String order = "a.join_date";
        String descAsc = "asc";

        String username = getSessionUser().getUsername();

        int exportTotal = blackListSer.getExportTotal(username, null, null, null,industry, riskLevel, 0, 99999,order, descAsc);

        return ResponseBean.successResponse(exportTotal);

    }


    @ApiOperation(value = "查看被别人移除的黑名单", notes = "个人中心-被别人移除的黑名单企业详情查看点击调用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "黑名单ID值", dataType = "String", required = true),
            @ApiImplicitParam(name = "company", paramType = "query", value = "企业名称", dataType = "String", required = true)
    })
    @RequestMapping(value = "/look/cancel/blacklist.do", method = RequestMethod.GET)
    public ResponseBean<String> lookOverCancel(@RequestParam Integer id, @RequestParam String company) {

        blackListSer.lookOverCancel(getSessionUser().getUsername(), id);

        return ResponseBean.successResponse("操作成功");
    }


    @ApiOperation(value = "移除黑名单", notes = "个人中心-黑名单移除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "黑名单ID值", dataType = "Integer"),
            @ApiImplicitParam(name = "companyId", paramType = "query", value = "企业ID", dataType = "String"),
            @ApiImplicitParam(name = "company", paramType = "query", value = "移除企业", dataType = "String", required = true),
            @ApiImplicitParam(name = "cancelReason", paramType = "query", value = "移除原因", dataType = "String", required = true, defaultValue = "[{\"k\":3,\"v\":\"3是标准选项,可能会有0-n 个3\"},{\"k\":4,\"v\":\"4是其他原因,最多只有一个4\"}]")
    })
    @RequestMapping(value = "/cancel/blacklist.do", method = RequestMethod.GET)
    @UserLog
    public ResponseBean<String> cancelBlacklist(Integer id,
                                                @RequestParam String companyId,
                                                @RequestParam String company,
                                                @RequestParam String cancelReason) {

        super.checkData(companyId);

        if (id == null) {
            id = blackListSer.findBlackListByCompanyId(companyId);
        }
        if (id == null) {
            return ResponseBean.successResponse("已成功移除黑名单");
        }

        Gson gson = new Gson();

        List<KeyValDTO<Integer, String>> reasons = gson.fromJson(cancelReason, new TypeToken<List<KeyValDTO<Integer, String>>>() {
        }.getType());

        blackListSer.cancelBlack(id, companyId, reasons, getSessionUser().getUsername(), null, true);

        return ResponseBean.successResponse("已成功移除黑名单");
    }


    @ApiOperation(value = "查看由于加入黑名单引起的取消关注企业", notes = "查看由于加入黑名单引起的取消关注企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "关注ID值", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "company", paramType = "query", value = "查看企业", dataType = "String", required = true)
    })
    @RequestMapping(value = "/look/black/change/cancel.do", method = RequestMethod.GET)
    public ResponseBean<String> lookBlackChangeCancel(@RequestParam Integer id,
                                                      @RequestParam String company) {
        raBlackFocSer.lookBlackChangeCancelFoucs(id);

        return ResponseBean.successResponse("已查看取消关注原因");
    }

}
