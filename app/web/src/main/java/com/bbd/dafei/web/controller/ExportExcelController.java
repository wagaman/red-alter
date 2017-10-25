package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.*;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.UserPO;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.ExportExcel;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by tuanhong on 2017-04-19.
 */
@Controller
@RequestMapping("/exportExcel")
@Api(value = "/exportExcel", tags = "导出EXCEL列表")
public class ExportExcelController extends BaseController {

    @Autowired
    private RaHighCompanyService highCompany;

    @Autowired
    private RaBlackListService blackListSer;

    @Autowired
    private RaBlackListFocusService focusService;

    @Autowired
    private RelationService relationService;

    @Autowired
    private RelationTotalInfoService relationTotalInfoService;

    @Autowired
    private PersonDetailInfoService personDetailInfoService;

    @Autowired
    private RaCompanyService raCompanyService;

    @Value("${exportExcel.columnHighCompany}")
    private String columnHighCompany;

    @Value("${exportExcel.columnCompany}")
    private String columnCompany;

    @Value("${exportExcel.columnBlackList}")
    private String columnBlackList;

    @Value("${exportExcel.columnPersonalExport}")
    private String columnPersonalExport;

    @Value("${exportExcel.columnPersonalBlackExport}")
    private String columnPersonalBlackExport;

    @Value("${exportExcel.columnRelationExport}")
    private String columnRelationExport;

    @Value("${exportExcel.newColumnRelationExprot}")
    private String newColumnRelationExprot;

    @Value("${exportExcel.columnPersonRelationExport}")
    private String columnPersonRelationExport;


    @RequestMapping(value = "/indexHighCompany.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出高危企业列表(首页)", notes = "导出高危企业列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String"),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业", dataType = "String"),
            @ApiImplicitParam(name = "isNew", paramType = "query", value = "是否新增", dataType = "String", defaultValue = "否")
    })
    @UserLog
    public Object indexHighCompany(String city, String area, String industry, @RequestParam(defaultValue = "否") String isNew, HttpServletRequest req, HttpServletResponse response) {
        UserPO userPO = getSessionUser();

        isNew = Constants.IS_NEW_NO.equals(isNew) ? null : Constants.IS_NEW_YES;
//        isNew = "否".equals(isNew) ? null : "是";

        //取得该用户所属省份的所有高位企业名单信息（因为权限使用的是省份，所以权限即为所在省份）
        List<RaIndexCompanyVO> raIndexCompanyVOS = this.highCompany.findByProvince(userPO.getProvince(), city, area, industry, isNew);
        if (CollectionUtils.isEmpty(raIndexCompanyVOS)) {
            return ResponseBean.errorResponse("未查询到该用户下的高危企业名单信息");
        } else {

            HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("高危企业名单", columnHighCompany, raIndexCompanyVOS, "yyyyMMdd");
            response.setCharacterEncoding("utf-8");
            if (null != hssfWorkbook) {
                try {
                    // 清空response
                    response.reset();
                    response.addHeader("Content-Disposition", "attachment;filename=" + getFileName("高危企业名单-导出.xls", req));
//                    response.addHeader("Content-Disposition","attachment;filename=" + new String("高危企业名单-导出.xls".getBytes("gb2312"),"iso-8859-1"));
                    response.setContentType("application/octet-stream");
                    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
                    hssfWorkbook.write(outputStream);
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    LOGGER.error("导出高危企业列表失败", e);
                }
            }
        }
        return ResponseBean.successResponse("");
    }

    @RequestMapping(value = "/indexBalckList.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出黑名单列表(首页)", notes = "导出黑名单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String"),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "行业", dataType = "String")
    })
    @UserLog
    public Object indexBalckList(String city, String area, String industry, HttpServletRequest req, HttpServletResponse response) {

        UserPO userPO = getSessionUser();

        //取得该所有黑名单信息
        List<RaBlackListVO> raBlackListVOS = this.blackListSer.getDataForExcel(userPO.getProvince(), city, area, industry);
        if (CollectionUtils.isEmpty(raBlackListVOS)) {
            return ResponseBean.errorResponse("未查询到该用户下的黑名单信息");
        } else {

            HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("黑名单", columnBlackList, raBlackListVOS, "yyyyMMdd");
            response.setCharacterEncoding("utf-8");
            if (null != hssfWorkbook) {
                try {
                    // 清空response
                    response.reset();
                    response.addHeader("Content-Disposition",
                            "attachment;filename=" + getFileName("黑名单-导出.xls", req));
                    response.setContentType("application/octet-stream");
                    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
                    hssfWorkbook.write(outputStream);
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    LOGGER.error("导出黑名单失败", e);
                }
            }
        }
        return ResponseBean.successResponse("");
    }

    @RequestMapping(value = "/personalFocus.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "个人中心列表导出", notes = "导出我的关注列表，导出类型（我的黑名单，我的关注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "exportType", value = "导出类型", required = true, paramType = "query", dataType = "String")
    })
    @UserLog
    public Object personalFocus(String exportType, HttpServletResponse response, HttpServletRequest req) throws Exception {
        UserPO userPO = getSessionUser();
        String username = userPO.getUsername();
        //检查权限合法性问题
        if (StringUtils.isEmpty(username)) {
            return ResponseBean.errorResponse("无权操作");
        }

        if (StringUtils.isEmpty(exportType)) {
            return ResponseBean.errorResponse("导出类型为空");
        }

        List<RaBlackListFocusVO> raBlackListFocusVOS = null;

        if (exportType.equals("我的黑名单")) {
            raBlackListFocusVOS = this.blackListSer.getDataForPersonExcel(userPO.getProvince(), username);
        } else if (exportType.equals("我的关注")) {
            raBlackListFocusVOS = this.focusService.findByUsernameForExport(username);
        } else {
            return ResponseBean.errorResponse("你输入的导出类型不是[我的黑名单]和[我的关注]其中之一");
        }
        if (CollectionUtils.isEmpty(raBlackListFocusVOS)) {
            return ResponseBean.errorResponse("未查询到该用户下的关注信息");
        } else {

            HSSFWorkbook hssfWorkbook = null;
            if (exportType.equals("我的黑名单")) {
                hssfWorkbook = ExportExcel.exportExcel(exportType, columnPersonalBlackExport, raBlackListFocusVOS, "yyyyMMdd");
            } else {
                hssfWorkbook = ExportExcel.exportExcel(exportType, columnPersonalExport, raBlackListFocusVOS, "yyyyMMdd");
            }
            response.setCharacterEncoding("utf-8");
            if (null != hssfWorkbook) {
                try {
                    // 清空response
                    response.reset();
                    response.addHeader("Content-Disposition",
                            "attachment;filename=" + getFileName((exportType + "-导出.xls"), req));
                    response.setContentType("application/octet-stream");
                    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
                    hssfWorkbook.write(outputStream);
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    LOGGER.error("导出个人中心列表失败", e);
                }
            }
        }
        return ResponseBean.successResponse("");
    }

    @RequestMapping(value = "/relationNodes.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出关联方列表", notes = "导出关联方列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qyxxId", value = "公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "degree", value = "关联度(1到3)", required = true, paramType = "query", dataType = "Integer")
    })
    @UserLog
    public Object relationNodes(@RequestParam String qyxxId, @RequestParam int degree, HttpServletResponse response, HttpServletRequest req) {
        try {
            RelationDataVO relationDataVO = relationService.getRelationNodesAndLinks(qyxxId, degree);
            if (relationDataVO == null || CollectionUtils.isEmpty(relationDataVO.getNodes())) {
                return ResponseBean.errorResponse("未查询到数据");
            }
            HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("关联方", columnRelationExport, relationDataVO.getNodes(), "yyyyMMdd");
            response.setCharacterEncoding("utf-8");
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + getFileName("关联方-导出.xls", req));
            response.setContentType("application/octet-stream");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            hssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("导出关联方列表失败", e);
        }
        return ResponseBean.successResponse("");
    }


    @RequestMapping(value = "/newRelationNodes.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出关联方列表", notes = "导出关联方列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "目标公司id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "degree", value = "关联度(1到3)", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "type", value = "资料类型", required = true, paramType = "query", dataType = "String")
    })
    @UserLog
    public Object realationDetailInfo(@RequestParam String companyId, @RequestParam int degree, @RequestParam String type, HttpServletResponse response, HttpServletRequest req) {
        try {
            if (Constants.QUERY_TYPE_SEARCH.equals(type)) {
                type = Constants.QUERY_TPYE_ALL;
            }
            List<RelationListInfoVO> relationListInfoVOS = relationTotalInfoService.getDataForExcel(companyId, degree, type);
            if (CollectionUtils.isEmpty(relationListInfoVOS)) {
                return ResponseBean.errorResponse("未查询到数据");
            }
            //处理导出格式
            handleStyleExportRelationNode(relationListInfoVOS);
            HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("关联方", newColumnRelationExprot, relationListInfoVOS, "yyyyMMdd");
            response.setCharacterEncoding("utf-8");
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + getFileName("关联方-导出.xls", req));
            response.setContentType("application/octet-stream");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            hssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("导出个人中心列表失败", e);
        }
        return ResponseBean.successResponse("");
    }

    @RequestMapping(value = "/personRelationNodes.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出个人关联方", notes = "导出个人关联方列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "personId", value = "人员id", required = true, paramType = "query", dataType = "String")
    })
    @UserLog
    public Object personRelationNodes(@RequestParam String personId, HttpServletResponse response, HttpServletRequest req) {
        try {
            PersonDetailInfoVO personDetailInfoVO = personDetailInfoService.getPersonDetailInfo(personId);
            if (personDetailInfoVO == null || CollectionUtils.isEmpty(personDetailInfoVO.getPersonRelationInfoVOS())) {
                return ResponseBean.errorResponse("未查询到数据");
            }
            String personName = personDetailInfoVO.getPersonName();
            //处理导出显示
            handleStyleExportPersonRelatoin(personDetailInfoVO.getPersonRelationInfoVOS());
            HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel(personName == null ? "" : personName + "个人关联方", columnPersonRelationExport, personDetailInfoVO.getPersonRelationInfoVOS(), "yyyyMMdd");
            response.setCharacterEncoding("utf-8");
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + getFileName(personName == null ? "" : personName + "关联方-导出.xls", req));
            response.setContentType("application/octet-stream");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            hssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("导出个人关联方失败", e);
        }
        return ResponseBean.successResponse("");
    }

    @RequestMapping(value = "/indexMonitoringCompany.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出首页持续监控企业", notes = "导出首页持续监控企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String"),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业（全部行业）", dataType = "String"),
            @ApiImplicitParam(name = "order", paramType = "query", value = "排序字段（易燃指数）", defaultValue = "易燃指数", dataType = "String"),
            @ApiImplicitParam(name = "descAsc", paramType = "query", value = "升序降序（升序，降序）", defaultValue = "降序", dataType = "String")
    })
    @UserLog
    public Object indexMonitoringCompany(String city,
                                         String area,
                                         String industry,
                                         @RequestParam(defaultValue = "易燃指数") String order,
                                         @RequestParam(defaultValue = "降序") String descAsc,
                                         HttpServletResponse response, HttpServletRequest req) {
        try {
            String riskLevel = "持续监控";

            industry = "全部行业".equals(industry) ? null : industry;

            order = "易燃指数".equals(order) ? "risk_index" : "gmt_create";

            descAsc = "降序".equals(descAsc) ? "desc" : "asc";

            PageInfo<RaIndexCompanyVO> pageInfo = raCompanyService.findIndexCompanyPage(getUserProvince(),
                    city, area, industry, riskLevel,
                    0, 0,
                    order, descAsc);
            if (pageInfo == null || CollectionUtils.isEmpty(pageInfo.getItems())) {
                return ResponseBean.errorResponse("未查询到数据");
            }
            HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel(riskLevel + "企业", columnCompany, pageInfo.getItems(), null);
            response.setCharacterEncoding("utf-8");
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + getFileName(riskLevel + "企业.xls", req));
            response.setContentType("application/octet-stream");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            hssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("导出企业失败", e);
        }
        return ResponseBean.successResponse("");
    }

    @RequestMapping(value = "/indexFocusCompany.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出首页重点关注企业", notes = "导出首页重点关注企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String"),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业（全部行业）", dataType = "String"),
            @ApiImplicitParam(name = "order", paramType = "query", value = "排序字段（易燃指数）", defaultValue = "易燃指数", dataType = "String"),
            @ApiImplicitParam(name = "descAsc", paramType = "query", value = "升序降序（升序，降序）", defaultValue = "降序", dataType = "String")
    })
    @UserLog
    public Object indexFocusCompany(String city,
                                    String area,
                                    String industry,
                                    @RequestParam(defaultValue = "易燃指数") String order,
                                    @RequestParam(defaultValue = "降序") String descAsc,
                                    HttpServletResponse response, HttpServletRequest req) {
        try {
            String riskLevel = "重点关注";

            industry = "全部行业".equals(industry) ? null : industry;

            order = "易燃指数".equals(order) ? "risk_index" : "gmt_create";

            descAsc = "降序".equals(descAsc) ? "desc" : "asc";

            PageInfo<RaIndexCompanyVO> pageInfo = raCompanyService.findIndexCompanyPage(getUserProvince(),
                    city, area, industry, riskLevel,
                    0, 0,
                    order, descAsc);
            if (pageInfo == null || CollectionUtils.isEmpty(pageInfo.getItems())) {
                return ResponseBean.errorResponse("未查询到数据");
            }
            HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel(riskLevel + "企业", columnCompany, pageInfo.getItems(), null);
            response.setCharacterEncoding("utf-8");
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + getFileName(riskLevel + "企业.xls", req));
            response.setContentType("application/octet-stream");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            hssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("导出企业失败", e);
        }
        return ResponseBean.successResponse("");
    }


    private String getFileName(String fileName, HttpServletRequest req) {
        try {
            String agent = getBrowserName(req.getHeader("User-Agent").toLowerCase());
            if (agent.equals("Firefox")) {
                return new String(fileName.getBytes("utf-8"), "iso-8859-1");
//                return "=?UTF-8?B?" + (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
            } else {
                return java.net.URLEncoder.encode(fileName, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("获取文件名出错", e);
            return fileName;
        }
    }

    /**
     * 取得浏览器类型
     *
     * @param agent
     * @return
     */
    private String getBrowserName(String agent) {
        if (agent.indexOf("firefox") > 0) {
            return "Firefox";
        } else {
            return "Others";
        }
    }

    /**
     * 处理导出管理方格式
     *
     * @param relationListInfoVOList
     */
    private void handleStyleExportRelationNode(List<RelationListInfoVO> relationListInfoVOList) {
        final String defaultValue = "--";
        for (RelationListInfoVO relationListInfoVO : relationListInfoVOList) {
            if (relationListInfoVO.getBlack()) {
                relationListInfoVO.setRiskIndex(null);
                relationListInfoVO.setRiskLevel(defaultValue);
            }
        }
    }

    /**
     * 处理导出个人关联方格式
     *
     * @param personRelationInfoVOList 关联方
     */
    private void handleStyleExportPersonRelatoin(List<PersonRelationInfoVO> personRelationInfoVOList) {
        final String defaultValue = "--";
        for (PersonRelationInfoVO personRelationInfoVO : personRelationInfoVOList) {
            //处理出资比例为空的默认显示
            if (StringUtils.isEmpty(personRelationInfoVO.getInvestRatio())) {
                personRelationInfoVO.setInvestRatio(defaultValue);
            }
            if (personRelationInfoVO.getBlack()) {
                personRelationInfoVO.setRiskIndex(null);
                personRelationInfoVO.setRiskLevel(defaultValue);
            }
        }
    }

}
