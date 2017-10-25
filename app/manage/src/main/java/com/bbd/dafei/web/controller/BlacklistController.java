package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.CommonService;
import com.bbd.dafei.biz.shared.RaBlackListService;
import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.common.modal.commonenum.BlackReasonTypeEnum;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.BlacklistVO;
import com.bbd.dafei.common.modal.vo.BlacklistVerifyVO;
import com.bbd.dafei.common.modal.vo.RaCompanyVO;
import com.bbd.dafei.common.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: BlacklistController.java, v 0.1 2017/6/8 14:24 Ian.Su Exp $
 */

@RestController
@RequestMapping("/blacklist")
@Api(value = "/blacklist", tags = "黑名单管理")
public class BlacklistController extends BaseController {

    @Autowired
    private RaBlackListService blackListService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private RaCompanyService companyService;


    @ApiOperation(value = "根据名称搜索企业", notes = "根据名称搜索企业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "企业名称关键字", paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/search.do", method = RequestMethod.GET)
    public ResponseBean<PageInfo<RaCompanyVO>> query(String company) {

        return ResponseBean.successResponse(companyService.search(company));

    }


    //黑名单导出EXCEL表头
    private static final String blacklistExport = "[" +
            "{\"key\":\"companyId\",\"value\":\"企业id\"}" +
            "{\"key\":\"company\",\"value\":\"企业名\"}" +
            "{\"key\":\"industry\",\"value\":\"所属行业\"}" +
            "{\"key\":\"province\",\"value\":\"省份\"}" +
            "{\"key\":\"gmtCreate\",\"value\":\"入库时间\"}" +
            "{\"key\":\"joinReason\",\"value\":\"加入原因\"}" +
            "{\"key\":\"joinSrouce\",\"value\":\"加入来源\"}" +
            "{\"key\":\"joinDate\",\"value\":\"加入时间\"}" +
            "{\"key\":\"cancelReason\",\"value\":\"移出原因\"}" +
            "{\"key\":\"cancelDate\",\"value\":\"移出时间\"}" +
            "]";

    //黑名单待核实导出EXCEL表头
    private static final String blacklistVerifyExport = "[" +
            "{\"key\":\"companyId\",\"value\":\"企业id\"}" +
            "{\"key\":\"companyName\",\"value\":\"企业名\"}" +
            "{\"key\":\"industry\",\"value\":\"行业\"}" +
            "{\"key\":\"province\",\"value\":\"省份\"}" +
            "{\"key\":\"dataVersion\",\"value\":\"计算版本\"}" +
            "{\"key\":\"typeName\",\"value\":\"类型\"}" +
            "{\"key\":\"blackCreateDate\",\"value\":\"入库时间\"}" +
            "{\"key\":\"joinReason\",\"value\":\"加入原因\"}" +
            "{\"key\":\"addSource\",\"value\":\"加入来源\"}" +
            "{\"key\":\"joinDate\",\"value\":\"加入时间\"}" +
            "{\"key\":\"cancelReason\",\"value\":\"移出原因\"}" +
            "{\"key\":\"cancelDate\",\"value\":\"移出时间\"}" +
            "]";


    @ApiOperation(value = "查询黑名单列表", notes = "分页查询黑名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "企业名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", defaultValue = "10", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "order", value = "排序字段", defaultValue = "入库时间", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "ascDesc", value = "排序方式", defaultValue = "倒序", paramType = "query", dataType = "String", required = true)
    })
    @RequestMapping(value = "/query.do", method = RequestMethod.GET)
    public ResponseBean<PageInfo<BlacklistVO>> query(String company, PageInfoIgnore pageInfo,
                                                     @RequestParam(defaultValue = "入库时间") String order,
                                                     @RequestParam(defaultValue = "倒序") String ascDesc) {


        order = parseOrder(order);

        ascDesc = ("倒序".equals(ascDesc) ? "desc" : "asc");

        pageInfo = blackListService.queryAndReason(company, order, ascDesc, pageInfo);

        return ResponseBean.successResponse(pageInfo);

    }


    @ApiOperation(value = "导入黑名单", notes = "导入黑名单")
    @RequestMapping(value = "/import.do", method = RequestMethod.POST)
    public ResponseBean<String> importBlacklist(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        File excel = null;
        try {

            String filename = file.getOriginalFilename();
            filename = System.nanoTime() + filename.substring(filename.lastIndexOf("."));
            String path = commonService.getTempPath() + "/" + filename;
            excel = new File(path);
            file.transferTo(excel);
            ResponseBean<Workbook> rb = blackListService.importBlacklist(excel);
            Workbook wb = rb.getContent();
            //导入成功
            if (wb == null) {
                ResponseBean<String> responseBean = new ResponseBean<>();
                responseBean.setCode(rb.getCode());
                responseBean.setMsg(rb.getMsg());
                return ResponseBean.successResponse(null, "导入成功");
            } else {
                //导入的excel数据重复，将生成的workbook保存到文件，返回文件名到前端
                String errorFileName = System.nanoTime() + filename.substring(filename.lastIndexOf("."));
                FileOutputStream os = new FileOutputStream(commonService.getTempPath() + errorFileName);
                os.flush();
                //将Excel写出
                wb.write(os);
                //关闭流
                os.close();
                return ResponseBean.errorResponse(203, "excel数据有误", errorFileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("导入黑名单失败", e);
            return ResponseBean.errorResponse("导入黑名单失败：" + e.getMessage());
        } finally {
            if (excel != null) {
                excel.delete();
            }
        }

    }

    @RequestMapping(value = "/addBlacklist.do", method = RequestMethod.GET)
    @ApiOperation(value = "添加到黑名单", notes = "后台添加黑名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "company", value = "公司名称）", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "addFrontUser", value = "加入来源）", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "joinDate", value = "加入时间(yyyy-MM-dd，yyyy-MM-dd HH:mm:ss)", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "addReason", value = "加入原因", paramType = "query", required = true, dataType = "String")
    })
    public ResponseBean addBlacklist(String companyId, String company, String addUser, String joinDate, String addReason) throws Exception {
        List<KeyValDTO<Integer, String>> addReasons = new ArrayList<>();
        KeyValDTO keyValDTO = new KeyValDTO();
        //添加黑名单原因：其他
        keyValDTO.setK(BlackReasonTypeEnum.ADD_REASON_OTHER.getCode());
        keyValDTO.setV(addReason);
        addReasons.add(keyValDTO);
        blackListService.addBlacklistManage(addUser, companyId, company,
                null, null, null, DateUtils.parseDate(joinDate, new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"}), Constants.BLACKLIST_JOIN_TYPE_MANAGE, addReasons);
        return ResponseBean.successResponse(null, "添加成功");
    }

    @RequestMapping(value = "/deleteBlackListByIds.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除黑名单", notes = "删除黑名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "黑名单id", paramType = "query", required = true, dataType = "Integer")
    })
    public ResponseBean deleteBlackListByIds(@RequestParam("ids") List<Integer> ids) throws Exception {
        blackListService.deleteBlackListByIds(ids);
        return ResponseBean.successResponse(null, "删除成功");
    }

    @RequestMapping(value = "/updateBlacklist.do", method = RequestMethod.GET)
    @ApiOperation(value = "修改黑名单", notes = "后台修改黑名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blackId", value = "黑名单id", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "addFrontUser", value = "加入来源）", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "joinDate", value = "加入时间(yyyy-MM-dd)", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "addReason", value = "加入原因", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "cancelDate", value = "移出时间(yyyy-MM-dd)", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "cancelReason", value = "移出原因", paramType = "query", dataType = "String")
    })
    public ResponseBean updateBlacklist(Integer blackId, String addUser, String joinDate, String addReason, String cancelDate, String cancelReason) throws Exception {
        Date cancel = null;
        if (StringUtils.isNotEmpty(cancelDate)) {
            cancel = DateUtils.parseDate(cancelDate, new String[]{"yyyy-MM-dd"});
        }
        blackListService.updateBlacklist(blackId, addUser,
                DateUtils.parseDate(joinDate, new String[]{"yyyy-MM-dd"}), addReason, cancel, cancelReason);
        return ResponseBean.successResponse(null, "修改成功");
    }

    @RequestMapping(value = "/exportBlacklist.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出黑名单", notes = "导出黑名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blacklistIds", value = "黑名单id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "company", value = "企业名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "order", value = "排序字段", defaultValue = "入库时间", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "ascDesc", value = "排序方式", defaultValue = "倒序", paramType = "query", dataType = "String", required = true)
    })
    public Object exportBlacklist(@RequestParam(value = "blacklistIds", required = false) List<Integer> blacklistIds, String company,
                                  @RequestParam(defaultValue = "入库时间") String order,
                                  @RequestParam(defaultValue = "倒序") String ascDesc, HttpServletResponse response, HttpServletRequest req) throws Exception {


        ascDesc = ("倒序".equals(ascDesc) ? "desc" : "asc");
        order = parseOrder(order);
        PageInfoIgnore pageInfo = new PageInfoIgnore();
        //page = 0 查询全部
        pageInfo.setPage(0);
        pageInfo.setPageSize(0);
        List<BlacklistVO> blacklistVOList = null;
        //如果有黑名单id参数，则直接通过id查询，否则按其他条件查询
        if (CollectionUtils.isNotEmpty(blacklistIds)) {
            blacklistVOList = blackListService.queryAndReasonByIds(blacklistIds, order, ascDesc);
        } else {
            pageInfo = blackListService.queryAndReason(company, order, ascDesc, pageInfo);
            if (pageInfo != null) {
                blacklistVOList = pageInfo.getItems();
            }
        }


        HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("黑名单", blacklistExport, blacklistVOList, "yyyy-MM-dd");
        response.setCharacterEncoding("utf-8");
        // 清空response
        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename=" + CommonUtil.getFileName("黑名单.xls", req));
        response.setContentType("application/octet-stream");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        hssfWorkbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

        return ResponseBean.successResponse("");
    }

    @ApiOperation(value = "移除黑名单", notes = "个人中心-黑名单移除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "黑名单ID值", dataType = "Integer"),
            @ApiImplicitParam(name = "companyId", paramType = "query", value = "企业ID", dataType = "String"),
            @ApiImplicitParam(name = "cancelReason", paramType = "query", value = "移除原因", dataType = "String", required = true),
            @ApiImplicitParam(name = "cancelDate", paramType = "query", value = "移除时间(yyyy-MM-dd)", dataType = "String", required = true)
    })
    @RequestMapping(value = "/cancel.do", method = RequestMethod.GET)
    public ResponseBean<String> cancelBlacklist(@RequestParam Integer id,
                                                String companyId,
                                                @RequestParam String cancelReason,
                                                String cancelDate) throws Exception {

        if (id == null) {
            id = blackListService.findBlackListByCompanyId(companyId);
        }
        Date cancel = null;
        if (StringUtils.isNotEmpty(cancelDate)) {
            cancel = DateUtils.parseDate(cancelDate, new String[]{"yyyy-MM-dd"});
        }
        List<KeyValDTO<Integer, String>> reasons = new ArrayList<>();
        KeyValDTO<Integer, String> keyValDTO = new KeyValDTO();
        //移出黑名单原因：其他
        keyValDTO.setK(BlackReasonTypeEnum.CANCEL_REASON_OTHER.getCode());
        keyValDTO.setV(cancelReason);
        reasons.add(keyValDTO);
        blackListService.cancelBlack(id, companyId, reasons, getSessionUser().getUsername(), cancel, false);
        return ResponseBean.successResponse("已成功移除黑名单");
    }

    @ApiOperation(value = "删除所有黑名单", notes = "删除所有黑名单")
    @RequestMapping(value = "/deleteAllBlackList.do", method = RequestMethod.GET)
    public ResponseBean<Object> deleteAllBlackList() throws Exception {
        blackListService.deleteAllBlacklist();
        return ResponseBean.successResponse("成功删除所有黑名单");
    }

    @ApiOperation(value = "删除所有非用户添加的黑名单", notes = "删除所有非用户添加的黑名单")
    @RequestMapping(value = "/deleteAllManageBlackList.do", method = RequestMethod.GET)
    public ResponseBean<Object> deleteAllManageBlackList() throws Exception {
        blackListService.deleteAllManagedBlackList();
        return ResponseBean.successResponse("成功删除所有非用户添加的黑名单");
    }


    @ApiOperation(value = "查询黑名单核实列表", notes = "分页查询黑名单核实列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型:1新增黑名单，2已移除->本次为黑，3已加入->本次为灰", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", defaultValue = "10", paramType = "query", dataType = "Integer", required = true)
    })
    @RequestMapping(value = "/findBlackListVerifyPage.do", method = RequestMethod.GET)
    public ResponseBean<PageInfo<BlacklistVerifyVO>> findBlackListVerifyPage(String type, int page, int pageSize) {
        PageInfo<BlacklistVerifyVO> pageInfo = blackListService.findBlackListVerifyPage(page, pageSize, type);
        return ResponseBean.successResponse(pageInfo);
    }

    @RequestMapping(value = "/exportBlacklistVerify.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "导出待核实黑名单", notes = "导出待核实黑名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型:1新增黑名单，2已移除->本次为黑，3已加入->本次为灰", paramType = "query", dataType = "String")
    })
    public Object exportBlacklistVerify(String type, HttpServletResponse response, HttpServletRequest req) throws Exception {

        PageInfo<BlacklistVerifyVO> pageInfo = blackListService.findBlackListVerifyPage(0, 0, type);
        List<BlacklistVerifyVO> blacklistVerifyVOList = pageInfo.getItems();

        HSSFWorkbook hssfWorkbook = ExportExcel.exportExcel("黑名单待核实", blacklistVerifyExport, blacklistVerifyVOList, "yyyy-MM-dd");
        response.setCharacterEncoding("utf-8");
        // 清空response
        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename=" + CommonUtil.getFileName("黑名单待核实.xls", req));
        response.setContentType("application/octet-stream");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        hssfWorkbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

        return ResponseBean.successResponse("");
    }


    /**
     * 解析排序参数
     *
     * @param orderParam
     * @return
     */
    private String parseOrder(String orderParam) {
        if ("加入时间".equals(orderParam)) {
            return "join_date";
        }
        if ("移出时间".equals(orderParam)) {
            return "cancelDate";
        }
        return "gmt_create";

    }


}
