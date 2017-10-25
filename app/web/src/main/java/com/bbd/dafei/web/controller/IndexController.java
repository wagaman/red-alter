package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.*;
import com.bbd.dafei.common.dal.po.RaLongiLatitudePO;
import com.bbd.dafei.common.modal.dto.AreaCountDTO;
import com.bbd.dafei.common.modal.dto.HealthDTO;
import com.bbd.dafei.common.modal.dto.KeyValDTO;
import com.bbd.dafei.common.modal.vo.RaBlackListVO;
import com.bbd.dafei.common.modal.vo.RaIndexCompanyVO;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import com.bbd.dafei.common.util.Paging;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Ian.Su
 * @version $Id: IndexController.java, v 0.1 2017/4/18 9:33 Ian.Su Exp $
 */
@RestController
@RequestMapping("/index")
@Api(value = "/index", tags = "首页")
public class IndexController extends BaseController {


    @Autowired
    private IndexService indexSer;

    @Autowired
    private RaHighCompanyService highCompSer;

    @Autowired
    private RaBlackListService blackListSer;

    @Autowired
    private RaLongiLatitudeService longiLatiSer;

    @Autowired
    private RaCompanyService raCompanyService;

    @ApiOperation(value = "新金融健康度", notes = "查询当前用户所属省份排名及前5省份")
    @RequestMapping(value = "/health.do", method = RequestMethod.GET)
    public ResponseBean<HealthDTO> health() {

        Integer top = 5;

        return ResponseBean.successResponse(indexSer.health(top, getUserProvince()));

    }


    @ApiOperation(value = "省份散点图", notes = "查询全省各市散点图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry",
                    paramType = "query",
                    value = "行业:新兴金融,私募基金,网络借贷,小额贷款,融资担保,交易场所",
                    dataType = "String")
    })
    @RequestMapping(value = "/map/province.do", method = RequestMethod.GET)
    public ResponseBean<List<AreaCountDTO>> mapProvince(String industry) {


        return ResponseBean.successResponse(indexSer.mapProvince(getUserProvince(), industry));

    }

    @ApiOperation(value = "城市散点图", notes = "查询全市各区散点图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",
                    paramType = "query",
                    value = "查询城市",
                    dataType = "String",
                    required = true),
            @ApiImplicitParam(name = "industry",
                    paramType = "query",
                    value = "行业:新兴金融,私募基金,网络借贷,小额贷款,融资担保,交易场所",
                    dataType = "String")
    })
    @RequestMapping(value = "/map/city.do", method = RequestMethod.GET)
    public ResponseBean<List<AreaCountDTO>> mapCity(@RequestParam String city, String industry) {

        return ResponseBean.successResponse(indexSer.mapCity(getUserProvince(), city, industry));
    }


    @ApiOperation(value = "省份实时监测数据", notes = "查询省份实时监测数据")
    @RequestMapping(value = "/province/real/time/monitoring.do", method = RequestMethod.GET)
    public ResponseBean<AreaCountDTO> provinceRealTimeMonitoring() {

        return ResponseBean.successResponse(indexSer.provinceRealTimeMonitoring(getUserProvince()));

    }

    @ApiOperation(value = "城市实时监测数据", notes = "查询城市实时监测数据,区域可不传,当传递时表示查询区域")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String", required = true),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区域", dataType = "String")
    })
    @RequestMapping(value = "/city/real/time/monitoring.do", method = RequestMethod.GET)
    public ResponseBean<AreaCountDTO> cityRealTimeMonitoring(@RequestParam String city, String area) {

        return ResponseBean.successResponse(indexSer.cityRealTimeMonitoring(getUserProvince(), city, area));

    }

    @ApiOperation(value = "区域高危企业数TOP3", notes = "查询区域高危企业数TOP3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city",
                    paramType = "query",
                    value = "查询城市,不传则表示查询省份",
                    dataType = "String")
    })
    @RequestMapping(value = "/high/company/top3.do", method = RequestMethod.GET)
    public ResponseBean<List<AreaCountDTO>> top3(String city) {

        return ResponseBean.successResponse(indexSer.highCompanyTop(getUserProvince(), city));

    }

    @ApiOperation(value = "区域风险企业数", notes = "查询区域风险企业数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String", required = true),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String", required = true)
    })
    @RequestMapping(value = "/area/risk/company.do", method = RequestMethod.GET)
    public ResponseBean<List<AreaCountDTO>> monitorTypeCount(@RequestParam String city,
                                                             @RequestParam String area) {

        return ResponseBean.successResponse(indexSer.monitorTypeCount(getUserProvince(), city, area));

    }

    @ApiOperation(value = "行业高危企业数", notes = "查询行业高危企业数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市,不传则表示查询省份", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询城市,不传则表示查询市", dataType = "String")
    })
    @RequestMapping(value = "/high/industry.do", method = RequestMethod.GET)
    public ResponseBean<List<KeyValDTO<String, Integer>>> highIndustry(String city, String area) {

        return ResponseBean.successResponse(indexSer.highIndustry(getUserProvince(), city, area));

    }


    @ApiOperation(value = "高危企业查询", notes = "查询高危企业列表,排序直接传入要排序字段的中文名称如:'易燃指数',排序方式如:'升序'")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String"),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业", dataType = "String"),
            @ApiImplicitParam(name = "isNew", paramType = "query", value = "是否新增", dataType = "String", defaultValue = "否"),
            @ApiImplicitParam(name = "order", paramType = "query", value = "排序字段", defaultValue = "易燃指数", dataType = "String"),
            @ApiImplicitParam(name = "descAsc", paramType = "query", value = "升序降序", defaultValue = "降序", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页数据量", defaultValue = "10", dataType = "Integer"),
            @ApiImplicitParam(name = "page", paramType = "query", value = "页码", defaultValue = "1", dataType = "Integer")
    })
    @RequestMapping(value = "/query/high/company.do", method = RequestMethod.GET)
    public ResponseBean<Paging<RaIndexCompanyVO>> queryHighCompany(String city,
                                                                   String area,
                                                                   String industry,
                                                                   @RequestParam(defaultValue = "否") String isNew,
                                                                   @RequestParam(defaultValue = "进入日期") String order,
                                                                   @RequestParam(defaultValue = "降序") String descAsc,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(defaultValue = "1") Integer page) {

        industry = "全部行业".equals(industry) ? null : industry;

        order = "易燃指数".equals(order) ? "risk_index" : "join_date";

        descAsc = "降序".equals(descAsc) ? "desc" : "asc";

        isNew = "否".equals(isNew) ? null : "是";

        Object r = highCompSer.query(getUserProvince(),
                city, area, industry, isNew,
                (page - 1) * pageSize, pageSize,
                order, descAsc);

        return ResponseBean.successResponse(r);

    }

    @ApiOperation(value = "重点关注和持续监控企业查询", notes = "查询重点关注和持续监控企业列表,排序直接传入要排序字段的中文名称如:'易燃指数',排序方式如:'升序'")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String"),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业（全部行业）", dataType = "String"),
            @ApiImplicitParam(name = "riskLevel", paramType = "query", value = "风险等级（重点关注，持续监控）", required = true, dataType = "String"),
            @ApiImplicitParam(name = "order", paramType = "query", value = "排序字段（易燃指数）", defaultValue = "易燃指数", dataType = "String"),
            @ApiImplicitParam(name = "descAsc", paramType = "query", value = "升序降序（升序，降序）", defaultValue = "降序", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页数据量", defaultValue = "10", dataType = "Integer"),
            @ApiImplicitParam(name = "page", paramType = "query", value = "页码", defaultValue = "1", dataType = "Integer")
    })
    @RequestMapping(value = "/query/findIndexCompanyPage.do", method = RequestMethod.GET)
    public ResponseBean<Paging<RaIndexCompanyVO>> findIndexCompanyPage(String city,
                                                                   String area,
                                                                   String industry,
                                                                   String riskLevel,
                                                                   @RequestParam(defaultValue = "进入日期") String order,
                                                                   @RequestParam(defaultValue = "降序") String descAsc,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(defaultValue = "1") Integer page) {

        industry = "全部行业".equals(industry) ? null : industry;

        order = "易燃指数".equals(order) ? "risk_index" : "gmt_create";

        descAsc = "降序".equals(descAsc) ? "desc" : "asc";

        PageInfo<RaIndexCompanyVO> pageInfo = raCompanyService.findIndexCompanyPage(getUserProvince(),
                city, area, industry, riskLevel,
                page, pageSize,
                order, descAsc);

        return ResponseBean.successResponse(pageInfo);

    }

    @ApiOperation(value = "黑名单查询", notes = "查询黑名单列表（首页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String"),
            @ApiImplicitParam(name = "riskLevel", paramType = "query", value = "风险等级", dataType = "String"),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "行业", dataType = "String"),
            @ApiImplicitParam(name = "descAsc", paramType = "query", value = "易燃指数排序方式", defaultValue = "降序", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", paramType = "query", value = "每页数据量", defaultValue = "10", dataType = "Integer"),
            @ApiImplicitParam(name = "page", paramType = "query", value = "页码", defaultValue = "1", dataType = "Integer")
    })
    @RequestMapping(value = "/query/blackList.do", method = RequestMethod.GET)
    public ResponseBean<PageInfo<RaBlackListVO>> queryBlackList(String city,
                                                                String area,
                                                                String industry,
                                                                String riskLevel,
                                                                @RequestParam(defaultValue = "降序") String descAsc,
                                                                PageInfoIgnore p) {

        industry = "全部行业".equals(industry) ? null : industry;
        riskLevel = "全部风险".equals(riskLevel) ? null : riskLevel;


        descAsc = "降序".equals(descAsc) ? "desc" : "asc";

        Object r = blackListSer.query(null,
                getUserProvince(), city, area,
                industry, riskLevel,
                p.getStart(), p.getPageSize(),
                "a.join_date", descAsc);


        return ResponseBean.successResponse(r);
    }


    @ApiOperation(value = "查询经纬度", notes = "查询经纬度（首页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/longi/Latitude.do", method = RequestMethod.GET)
    public ResponseBean<List<RaLongiLatitudePO>> longiLatitude(String city, String area) {

        Object r = longiLatiSer.query(getUserProvince(), city, area);

        return ResponseBean.successResponse(r);
    }

    /*
    * 红警2.1需求：分行业查询
    * */
    @ApiOperation(value = "省份实时监测数据（分行业）", notes = "查询省份不同行业实时监测数据")
    @RequestMapping(value = "/province/real/time/monitorByIndustry.do", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业", dataType = "String")
    })
    public ResponseBean<AreaCountDTO> provinceRealTimeMonitoringByIndustry(String industry) {
        return ResponseBean.successResponse(indexSer.provinceRealTimeMonitorByIndustry(getUserProvince(), industry));
    }

    @ApiOperation(value = "城市实时监测数据（分行业）", notes = "查询城市实时监测数据,区域可不传,当传递时表示查询区域")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业", dataType = "String"),
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String", required = true),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区域", dataType = "String")
    })
    @RequestMapping(value = "/city/real/time/monitoringByIndustry.do", method = RequestMethod.GET)
    public ResponseBean<AreaCountDTO> cityRealTimeMonitoringByIndustry(String industry, @RequestParam String city, String area) {
        return ResponseBean.successResponse(indexSer.cityRealTimeMonitoringByIndustry(getUserProvince(), industry, city, area));

    }

    @ApiOperation(value = "查询区域高危企业数TOP3(分行业)", notes = "分行业查询区域高危企业数TOP3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业", dataType = "String"),
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市,不传则表示查询省份", dataType = "String")
    })
    @RequestMapping(value = "/high/company/industryTop3.do", method = RequestMethod.GET)
    public ResponseBean<List<AreaCountDTO>> industryTop3(String industry, String city) {
        return ResponseBean.successResponse(indexSer.industryHighCompanyTop(getUserProvince(), industry, city));
    }

    @ApiOperation(value = "区域风险企业数（分行业）", notes = "查询区域风险企业数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "查询城市", dataType = "String", required = true),
            @ApiImplicitParam(name = "area", paramType = "query", value = "查询区县", dataType = "String", required = true),
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业", dataType = "String",required = true)
    })
    @RequestMapping(value = "/area/risk/industryCompany.do", method = RequestMethod.GET)
    public ResponseBean<List<AreaCountDTO>> industryMonitorTypeCount(@RequestParam String city, @RequestParam String area, @RequestParam String industry) {
        return ResponseBean.successResponse(indexSer.industryMonitorTypeCount(getUserProvince(), industry, city, area));
    }

    @ApiOperation(value = "网络借贷平均收益率", notes = "首页-网络借贷平均收益率")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/p2p/netAvgReturnRate.do", method = RequestMethod.GET)
    public ResponseBean<String> getNetAvgReturnRate(String city, String area) {
        return ResponseBean.successResponse(indexSer.getNetAvgReturnRate(getUserProvince(), city, area));
    }

    @ApiOperation(value = "网络借贷平均贷款期限", notes = "首页-网络借贷平均贷款期限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/p2p/getNetAvgLoanDate.do", method = RequestMethod.GET)
    public ResponseBean<String> getNetAvgLoanDate(String city, String area) {
        return ResponseBean.successResponse(indexSer.getNetAvgLoanDate(getUserProvince(), city, area));
    }

    @ApiOperation(value = "私募基金产品数量", notes = "首页-首页私募基金产品数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/privateFund/getPrivateFundProductNum.do", method = RequestMethod.GET)
    public ResponseBean<String> getPrivateFundProductNum(String city, String area) {
        return ResponseBean.successResponse(indexSer.getPrivateFundProductNum(getUserProvince(), city, area));
    }

    @ApiOperation(value = "私募基金基金类型", notes = "首页-私募基金基金类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/privateFund/getPrivateFundProductType.do", method = RequestMethod.GET)
    public ResponseBean<String> getPrivateFundProductType(String city, String area) {
        return ResponseBean.successResponse(indexSer.getPrivateFundProductType(getUserProvince(), city, area));
    }

    @ApiOperation(value = "私募基金企业性质", notes = "首页-私募基金企业性质")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/privateFund/getPrivateFundCompanyType.do", method = RequestMethod.GET)
    public ResponseBean<String> getPrivateFundCompanyType(String city, String area) {
        return ResponseBean.successResponse(indexSer.getPrivateFundCompanyType(getUserProvince(), city, area));
    }

    @ApiOperation(value = "私募基金人员规模", notes = "首页-私募基金人员规模")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/privateFund/getPrivateFundEmployeeScale.do", method = RequestMethod.GET)
    public ResponseBean<String> getPrivateFundEmployeeScale(String city, String area) {
        return ResponseBean.successResponse(indexSer.getPrivateFundEmployeeScale(getUserProvince(), city, area));
    }

    @ApiOperation(value = "交易场所权益现货占比", notes = "首页-交易场所权益现货占比")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/tradePlace/getTradePlaceType.do", method = RequestMethod.GET)
    public ResponseBean<String> getTradePlaceType(String city, String area) {
        return ResponseBean.successResponse(indexSer.getTradePlaceType(getUserProvince(), city, area));
    }

    @ApiOperation(value = "交易场所数量", notes = "首页-交易场所权益现货占比")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/tradePlace/getTradePlaceTradeType.do", method = RequestMethod.GET)
    public ResponseBean<String> getTradePlaceTradeType(String city, String area) {
        return ResponseBean.successResponse(indexSer.getTradePlaceTradeType(getUserProvince(), city, area));
    }

    @ApiOperation(value = "区域高危企业时序图(分行业)", notes = "首页-区域高危企业时序图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry", paramType = "query", value = "所属行业", dataType = "String", required = true),
            @ApiImplicitParam(name = "city", paramType = "query", value = "城市", dataType = "String"),
            @ApiImplicitParam(name = "area", paramType = "query", value = "区县", dataType = "String")
    })
    @RequestMapping(value = "/query/tradePlace/getHighCompanySort.do", method = RequestMethod.GET)
    public ResponseBean<String> getHighCompanySort(@Param("industry") String industry, String city, String area) {
        Map<String, String> data = indexSer.getHighCompanySort(industry, getUserProvince(), city, area);

        if (data.get("msg") != null) {
            return ResponseBean.errorResponse(400, data.get("msg"));
        } else {
            return ResponseBean.successResponse(data.get("data"));
        }
    }
}
