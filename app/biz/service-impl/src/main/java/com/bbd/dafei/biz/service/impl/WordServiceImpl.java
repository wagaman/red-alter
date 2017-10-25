package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.dafei.biz.shared.*;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.modal.util.FeatureUtil;
import com.bbd.dafei.common.modal.util.RelationUtil;
import com.bbd.dafei.common.modal.util.YearReportUtil;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.Constants;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.higgs.utils.DateUtils;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.field.RtfPageNumber;
import com.lowagie.text.rtf.field.RtfTotalPageNumber;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.List;


/**
 * Created by tuanhong on 2017-05-23.
 */
@Service
public class WordServiceImpl implements WordService {

    Logger logger = LoggerFactory.getLogger(WordServiceImpl.class);

    @Autowired
    private RaCompanyService raCompanyService;

    @Autowired
    private RaBlackListService raBlackListService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private RaProblemPlatformService raProblemPlatformService;

    @Autowired
    private BaseDataService baseDataService;

    @Autowired
    private ManageDataService manageDataService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private RelationService relationService;

    @Autowired
    private RaBlackListFocusService raBlackListFocusService;

    @Autowired
    private RelationTotalInfoService relationTotalInfoService;

    @Autowired
    private CaptureImgService captureImgService;

    private String none = "--";

    private final int page = 1;

    private final int pageSize = 9999;

    @Override
    public void createWord(HttpServletRequest request, ServletOutputStream out, String companyName, String companyId, String index, String indexBottom, String reportImg, String backCoverImage) {

        boolean isBlack = false;

        Map<String, Object> dataMap = new HashedMap();

        //取得生成word所需要的资料
        try {
            getDataForWord(dataMap, companyId, companyName);
        } catch (Exception e) {
            logger.error("获取word数据失败", e);
        }

        RaCompanyPO raCompanyPO = (RaCompanyPO) dataMap.get("raCompanyPO");
        String industry = raCompanyPO.getIndustry();
        boolean isP2P = false;
        if (Constants.COMPANY_INDUSTRY_P2P.equals(industry)) {
            isP2P = true;
        }

        Document document = new Document(PageSize.A4, 50, 50, 70, 0);
        RtfWriter2.getInstance(document, out);
        document.open();
        //页眉页脚
        try {
            headFooter(document);
        } catch (Exception e) {
            logger.error("添加页眉页脚失败", e);
        }
        //首页
        try {
            index(companyName, index, indexBottom, document);
        } catch (Exception e) {
            logger.error("添加首页失败", e);
        }
        document.newPage();
        //首页第二页
        try {
            surveyReport(reportImg, document);
        } catch (Exception e) {
            logger.error("添加首页第二页失败", e);
        }
        document.newPage();
        //免责申明
        try {
            exceptions(document, index);
        } catch (Exception e) {
            logger.error("添加免责申明失败", e);
        }
        document.newPage();
        //企业风险总览
        try {
            isBlack = totalInfo(dataMap, document, isP2P, request);
        } catch (Exception e) {
            logger.error("添加企业风险总览失败", e);
        }
        //基本信息
        try {
            baseInfo(isBlack, dataMap, document, isP2P);
        } catch (Exception e) {
            logger.error("添加基本信息失败", e);
        }
        //关联方信息
        try {
            relationInfo(isBlack, dataMap, document, isP2P, request, raCompanyPO.getProvince());
        } catch (Exception e) {
            logger.error("添加关联方信息失败", e);
        }
        //经营信息
        try {
            manageInfo(isBlack, dataMap, document, isP2P);
        } catch (Exception e) {
            logger.error("添加经营信息失败", e);
        }
        //信用信息
        try {
            xinYongInfo(isBlack, dataMap, document, isP2P);
        } catch (Exception e) {
            logger.error("添加信用信息失败", e);
        }
        document.newPage();
        //封底
        try {
            backCover(backCoverImage, document);
        } catch (Exception e) {
            logger.error("添加封底失败", e);
        }
        document.close();
    }

    /**
     * 取得所有资料
     *
     * @param dataMap
     * @param companyId
     * @param companyName
     * @return
     */
    private void getDataForWord(Map<String, Object> dataMap, String companyId, String companyName) throws Exception {
        //取得公司基本信息
        RaCompanyPO raCompanyPO = this.raCompanyService.findCompanyById(companyId);
        if (null != raCompanyPO) {
            //企业风险信息
            dataMap.put("raCompanyPO", raCompanyPO);
            //判断是否是黑名单企业
            WrodBlackListInfoVO wrodBlackListInfoVO = this.raBlackListService.getBlackListInfoByCompanyId(companyId);
            dataMap.put("wrodBlackListInfoVO", wrodBlackListInfoVO);
            //企业特征信息
            getFeatureInfo(dataMap, raCompanyPO);
            //获取企业基本信息
            getBasiceInfo(dataMap, raCompanyPO.getId(), companyName, page, pageSize);
            //关联方信息
            getRelationInfo(dataMap, raCompanyPO.getId());
            //经营信息
            getManageInfo(dataMap, raCompanyPO.getId(), page, pageSize);
            //信用信息
            getXinYongInfo(dataMap, companyId, page, pageSize);
        }
    }

    /**
     * 根据公司名称获取企业特征信息
     *
     * @param dataMap
     * @param raCompanyPO
     */
    private void getFeatureInfo(Map<String, Object> dataMap, RaCompanyPO raCompanyPO) throws Exception {
        if (raCompanyPO.getIndustry().equals(Constants.COMPANY_INDUSTRY_P2P)) { //特征信息 -- 网络借贷
            getFeatureP2PInfo(dataMap, raCompanyPO.getId());
        } else if (raCompanyPO.getIndustry().equals(Constants.COMPANY_INDUSTRY_PRIVATE_EQUIT)) {//特征信息 -- 私募基金信息
            getFeaturePrivateFundInfo(dataMap, raCompanyPO.getId());
        } else if (raCompanyPO.getIndustry().equals(Constants.COMPANY_INDUSTRY_TRADING_PLACE)) {//特征信息 -- 交易所信息
            getExchangeInfo(dataMap, raCompanyPO.getId());
        } else {
            //其他类型不取特征信息
        }
    }

    /**
     * 根据企业名称取得企业基本信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getBasiceInfo(Map<String, Object> dataMap, String companyId, String company, int page, int pageSize) throws Exception {
        BaseDataVO baseDataVO = baseDataService.getBaseDataByCompanyId(companyId);
        //基本信息 -- 工商信息
        getJbxxInfo(dataMap, companyId, baseDataVO);
        //基本信息 -- 股东信息
        getGdxxInfo(dataMap, baseDataVO);
        //基本信息 -- 董事/监事/高管
        getBaxxInfo(dataMap, baseDataVO);
        //分支机构
        getFzjgInfo(dataMap, companyId, page, pageSize);
        //海外投资机构
        getOverseasInfo(dataMap, companyId, page, pageSize);
        //行政处罚
        getXzcfInfo(dataMap, baseDataVO);
    }

    /**
     * 取得关联方信息
     *
     * @param dataMap
     * @param companyId
     */
    private void getRelationInfo(Map<String, Object> dataMap, String companyId) throws Exception {
        RelationInfoDTO relationInfoDTO = relationService.getRelationInfoByCompanyId(companyId);
        RelationInfoVO relationInfoVO = RelationUtil.transRelationInfoDTOToRelationInfoVO(relationInfoDTO);
        //关键自然人
        getKeyNatureInfo(dataMap, relationInfoVO);
        //关键非自然人
        getKeyNoNatureInfo(dataMap, relationInfoVO);
        //关联集聚行业
        getIndustryInfo(dataMap, relationInfoVO);
        //关联聚集地
        getGatherPlathInfo(dataMap, companyId);
    }

    /**
     * 取得经营信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getManageInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        // 经营信息-- 工商变更
        getBgxxInfo(dataMap, companyId, page, pageSize);
        //经营信息 -- 域名备案
        getYmbaInfo(dataMap, companyId, page, pageSize);
        //经营信息  -- 招聘信息
        getZhaoPinInfo(dataMap, companyId, page, pageSize);
        //经营信息 -- 年报
        getYearReportInfo(dataMap, companyId);
    }

    /**
     * 获取信用信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getXinYongInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        //开庭公告
        getKtggInfo(dataMap, companyId, page, pageSize);
        //裁判文书
        getCpwsInfo(dataMap, companyId, page, pageSize);
        //法院公告
        getFyggInfo(dataMap, companyId, page, pageSize);
        //被执行人
        getBzxrInfo(dataMap, companyId, page, pageSize);
        //失信被执行人
        getSxbzxrInfo(dataMap, companyId, page, pageSize);
        //司法拍卖
        getSfpmInfo(dataMap, companyId, page, pageSize);
        //经营异常
        getJyycInfo(dataMap, companyId, page, pageSize);
        //欠税情况
        getQsqkInfo(dataMap, companyId, page, pageSize);
        //清算情况
        getQinsqkInfo(dataMap, companyId, page, pageSize);
        //股权出质
        getGqczInfo(dataMap, companyId, page, pageSize);
        //动产抵押
        getDcdyInfo(dataMap, companyId, page, pageSize);
    }

    /**
     * 特征信息
     *
     * @param dataMap
     * @param companyId
     * @throws Exception
     */
    private void getFeatureP2PInfo(Map<String, Object> dataMap, String companyId) throws Exception {
        //网络借贷
        PlatformDTO platformDTO = featureService.getP2PPlatformByCompanyId(companyId);
        //得到所有平台名称
        Set<String> platformNames = FeatureUtil.getPlatformNamesByPlatformDTO(platformDTO);
        //查询所有的问题平台
        List<RaProblemPlatformDTO> raProblemPlatformDTOList = raProblemPlatformService.findProblemPlatformsByNames(platformNames);
        List<WljdFeatureVO> wljdFeatureVOList = FeatureUtil.transWljdDTOListToWljdVOList(platformDTO, raProblemPlatformDTOList);

        for (WljdFeatureVO data : wljdFeatureVOList) {
            //网络借贷  特征信息
            List<List<String>> p2pInfoList = new ArrayList<>();
            List<List<String>> p2pRzjlInfoList = new ArrayList<>();
            List<List<String>> p2pJgxhInfoList = new ArrayList<>();
            List<List<String>> p2pDbjgInfoList = new ArrayList<>();
            //平台名称
            String platformName = data.getPlatformName();
            dataMap.put(platformName + "wljdFeatureVO", data);
            List<String> element1 = new ArrayList<>();
            element1.add("上线时间");
            element1.add(changeNullData(data.getOnlinetime()));
            element1.add("平均参考收益率");
            element1.add(changeNullData(data.getAvgReturn()));
            element1.add("总成交额（万）");
            element1.add(changeNullData(data.getTotalTurnover()));
            p2pInfoList.add(element1);

            List<String> element2 = new ArrayList<>();
            element2.add("银行存管");
            element2.add(changeNullData(data.getBankCustody()));
            element2.add("参考投资期限");
            element2.add(changeNullData(data.getInvestTerm()));
            element2.add("平均借款期限（天）");
            element2.add(changeNullData(data.getAvgLendTime()));
            p2pInfoList.add(element2);

            List<String> element3 = new ArrayList<>();
            element3.add("自动投标");
            element3.add(changeNullData(data.getAutomaticBidding()));
            element3.add("成交量（万元）");
            element3.add(changeNullData(data.getDealVolume()));
            element3.add("平均满标时间（小时）");
            element3.add(changeNullData(data.getAvgSoldoutTime()));
            p2pInfoList.add(element3);

            List<String> element4 = new ArrayList<>();
            element4.add("债权转让");
            element4.add(changeNullData(data.getClaimTransfer()));
            element4.add("投资人数（人）");
            element4.add(changeNullData(data.getNumOfLender()));
            element4.add("人均借款金额（万）");
            element4.add(changeNullData(data.getPerBorrowingAmount()));
            p2pInfoList.add(element4);

            List<String> element5 = new ArrayList<>();
            element5.add("投标保障");
            element5.add(changeNullData(data.getBidGuarantee()));
            element5.add("借款人数（人）");
            element5.add(changeNullData(data.getNumOfBorrower()));
            element5.add("人均投资金额（万）");
            element5.add(changeNullData(data.getPerLendingAmount()));
            p2pInfoList.add(element5);

            List<String> element6 = new ArrayList<>();
            element6.add("保障模式");
            element6.add(changeNullData(data.getGuaranteeMode()));
            element6.add("日资金净流入（万元）");
            element6.add(changeNullData(data.getLastFundNetInflow()));
            element6.add("人均借款次数（次）");
            element6.add(changeNullData(data.getPerBorrowingNum()));
            p2pInfoList.add(element6);

            List<String> element7 = new ArrayList<>();
            element7.add("风险准备金存管");
            element7.add(changeNullData(data.getRiskReserve()));
            element7.add("日待还余额（万元）");
            element7.add(changeNullData(data.getLastDailyPending()));
            element7.add("人均投资次数（次）");
            element7.add(changeNullData(data.getPerLendingNum()));
            p2pInfoList.add(element7);
            dataMap.put(platformName + "p2pInfo", p2pInfoList);

            List<String> p2pRzjlInfoData = new ArrayList<String>();
            p2pRzjlInfoData.add("融资记录");
            p2pRzjlInfoData.add(changeNullData(data.getFinancingRecord()));
            p2pRzjlInfoList.add(p2pRzjlInfoData);
            dataMap.put(platformName + "p2pRzjlInfo", p2pRzjlInfoList);

            List<String> p2pJgxhInfoData = new ArrayList<String>();
            p2pJgxhInfoData.add("监管协会");
            p2pJgxhInfoData.add(changeNullData(data.getSuperviseAssociation()));
            p2pJgxhInfoList.add(p2pJgxhInfoData);
            dataMap.put(platformName + "p2pJgxhInfo", p2pJgxhInfoList);

            List<String> p2pDbjgInfoData = new ArrayList<String>();
            p2pDbjgInfoData.add("担保机构");
            p2pDbjgInfoData.add(changeNullData(data.getGuaranteeInstitution()));
            p2pDbjgInfoList.add(p2pDbjgInfoData);
            dataMap.put(platformName + "p2pDbjgInfo", p2pDbjgInfoList);
        }
    }

    /**
     * 私募基金特征信息
     *
     * @param dataMap
     * @param companyId
     * @throws Exception
     */
    private void getFeaturePrivateFundInfo(Map<String, Object> dataMap, String companyId) throws Exception {
        PrivateFundDTO privateFundDTO = this.featureService.getPrivateFundBycompanyId(companyId);
        //私募基金--管理者信息
        List<List<String>> executiveInfoList = new ArrayList<>();
        List<String> executiveInfoheader = new ArrayList<String>() {{
            add("高管姓名");
            add("职务");
            add("是否具有基金从业资格");
        }};
        executiveInfoList.add(executiveInfoheader);
        if (null == privateFundDTO || CollectionUtils.isEmpty(privateFundDTO.getExecutiveInfoList())) {
            dataMap.put("executiveInfo", new ArrayList<>());
        } else {
            for (PrivateFundDTO.ExecutiveInfo executiveInfo : privateFundDTO.getExecutiveInfoList()) {
                List<String> element = new ArrayList<>();
                element.add(changeNullData(executiveInfo.getName()));
                element.add(changeNullData(executiveInfo.getJob()));
                element.add(changeNullData(executiveInfo.getOccupationalRequirements()));
                executiveInfoList.add(element);
            }
            dataMap.put("executiveInfo", executiveInfoList);
        }
        //私募基金 -- 基金管理信息
        List<List<String>> manageInfoList = new ArrayList<>();
        List<String> manageInfoheader = new ArrayList<String>() {{
            add("基金编号");
            add("基金名称");
            add("基金类型");
            add("管理类型");
            add("托管人名称");
            add("运作状态");
            add("基金备案阶段");
        }};
        manageInfoList.add(manageInfoheader);
        if (null == privateFundDTO || CollectionUtils.isEmpty(privateFundDTO.getManageInfoList())) {
            dataMap.put("manageInfo", new ArrayList<>());
        } else {
            for (PrivateFundDTO.ManageInfo manageInfo : privateFundDTO.getManageInfoList()) {
                List<String> element = new ArrayList<>();
                element.add(changeNullData(manageInfo.getFundNumber()));
                element.add(changeNullData(manageInfo.getFundName()));
                element.add(changeNullData(manageInfo.getFundType()));
                element.add(changeNullData(manageInfo.getManagementType()));
                element.add(changeNullData(manageInfo.getCustodian()));
                element.add(changeNullData(manageInfo.getOperationalStatus()));
                element.add(changeNullData(manageInfo.getFundFilingStage()));
                manageInfoList.add(element);
            }
            dataMap.put("manageInfo", manageInfoList);
        }
    }

    /**
     * 交易场所特征信息
     *
     * @param dataMap
     * @param companyId
     * @throws Exception
     */
    private void getExchangeInfo(Map<String, Object> dataMap, String companyId) throws Exception {
        ExchangeDTO exchangeDTO = this.featureService.getExchangeByCompanyId(companyId);
        ExchangeVO exchangeVO = FeatureUtil.transExchangeDTOToExchangeVO(exchangeDTO);
        //交易所信息  -- 交易所信息
        List<List<String>> basicInfoList = new ArrayList<>();
        List<String> basicInfoheader = new ArrayList<String>() {{
            add("交易所简称");
            add("政府批文");
            add("交易所类型");
        }};
        basicInfoList.add(basicInfoheader);
        List<String> element = new ArrayList<>();
        if (null == exchangeVO) {
            dataMap.put("exchangeBasicInfo", new ArrayList<>());
        } else {
            element.add(changeNullData(exchangeVO.getExchangeShort()));
            element.add(changeNullData(exchangeVO.getGovDoc()));
            element.add(changeNullData(exchangeVO.getExchangeType()));

            basicInfoList.add(element);
            dataMap.put("exchangeBasicInfo", basicInfoList);
        }

        //交易品种
        List<String> typeDetailInfoheader1 = new ArrayList<String>() {{
            add("交易单位");
            add("最少交易量");
            add("报价单位");
            add("最小变动价格");
        }};
        List<String> typeDetailInfoheader2 = new ArrayList<String>() {{
            add("手续费");
            add("每日波动价格限制");
            add("最低保证金");
            add("最大单边交易量");
        }};
        List<String> typeDetailInfoheader3 = new ArrayList<String>() {{
            add("最大单表持仓量");
            add("交易时间");
            add("最小/大交收量");
            add("交收时间");
        }};
        List<String> typeName = new ArrayList<String>();
        if (null == exchangeVO || CollectionUtils.isEmpty(exchangeVO.getTradingVarietyInfos())) {
            typeName.add("--");
            dataMap.put("--", new ArrayList<>());
        } else {
            List<ExchangeVO.TradingVarietyInfo> tradingVarietyInfoList = exchangeVO.getTradingVarietyInfos();
            //品种名称
            for (ExchangeVO.TradingVarietyInfo tradingVarietyInfo : tradingVarietyInfoList) {
                typeName.add(tradingVarietyInfo.getTradeType());
                List<List<String>> tpyeDetailList = new ArrayList<>();

                tpyeDetailList.add(typeDetailInfoheader1);
                List<String> typeDetailInfoelement1 = new ArrayList<>();

                typeDetailInfoelement1.add(changeNullData(tradingVarietyInfo.getTradeUnit()));
                typeDetailInfoelement1.add(changeNullData(tradingVarietyInfo.getMinTradeNum()));
                typeDetailInfoelement1.add(changeNullData(tradingVarietyInfo.getOfferUnit()));
                typeDetailInfoelement1.add(changeNullData(tradingVarietyInfo.getMinChangePrice()));
                tpyeDetailList.add(typeDetailInfoelement1);

                tpyeDetailList.add(typeDetailInfoheader2);
                List<String> typeDetailInfoelement2 = new ArrayList<>();

                typeDetailInfoelement2.add(changeNullData(tradingVarietyInfo.getHandlingCharge()));//手续费
                typeDetailInfoelement2.add(changeNullData(tradingVarietyInfo.getPriceChangeLimitDaily()));//每日波动价格限制
                typeDetailInfoelement2.add(changeNullData(tradingVarietyInfo.getMinCashDeposit()));//最低保证金
                typeDetailInfoelement2.add(changeNullData(tradingVarietyInfo.getMaxTradeNum()));//最大单边交易量
                tpyeDetailList.add(typeDetailInfoelement2);

                tpyeDetailList.add(typeDetailInfoheader3);
                List<String> typeDetailInfoelement3 = new ArrayList<>();

                typeDetailInfoelement3.add(changeNullData(tradingVarietyInfo.getMaxInventory()));//最大单表持仓量
                typeDetailInfoelement3.add(changeNullData(tradingVarietyInfo.getTradeDate()));//交易时间
                typeDetailInfoelement3.add(changeNullData(tradingVarietyInfo.getMinDeliveryNum()) + "/" + changeNullData(tradingVarietyInfo.getMaxDeliveryNum()));//最小/大交收量
                typeDetailInfoelement3.add((tradingVarietyInfo.getDeliveryDate() == null || tradingVarietyInfo.getDeliveryDate().equals("")) ? "--" : tradingVarietyInfo.getDeliveryDate());//交收时间
                tpyeDetailList.add(typeDetailInfoelement3);

                dataMap.put(tradingVarietyInfo.getTradeType(), tpyeDetailList);
            }
        }
        dataMap.put("typeName", typeName);
    }

    /**
     * 获取公司工商信息
     *
     * @param dataMap
     * @param companyId
     * @param baseDataVO
     */
    private void getJbxxInfo(Map<String, Object> dataMap, String companyId, BaseDataVO baseDataVO) throws Exception {
        List<String> jbxxHeader = new ArrayList<String>();
        jbxxHeader.add("注册号/统一社会信用代码");
        jbxxHeader.add("名称");
        jbxxHeader.add("类型");
        jbxxHeader.add("法定代表人");
        jbxxHeader.add("注册资本");
        jbxxHeader.add("成立日期");
        jbxxHeader.add("企业地址");
        jbxxHeader.add("官方网址");
        jbxxHeader.add("经营期限自");
        jbxxHeader.add("经营期限至");
        jbxxHeader.add("经营范围");
        jbxxHeader.add("登记机关");
        jbxxHeader.add("核准日期");
        jbxxHeader.add("登记状态");
        List<String> jbxxElement = new ArrayList<String>();
        if (null == baseDataVO || null == baseDataVO.getJbxx()) {
            dataMap.put("jbxxData", new ArrayList<>());
        } else {
            BaseDataVO.Jbxx jbxx = baseDataVO.getJbxx();
            //注册号/统一社会信用代码
            if (StringUtils.isEmpty(jbxx.getCreditCode())) {
                jbxxElement.add(changeNullData(jbxx.getRegno()));
            } else {
                jbxxElement.add(changeNullData(jbxx.getCreditCode()));
            }
            jbxxElement.add(changeNullData(jbxx.getCompanyName()));//名称
            jbxxElement.add(changeNullData(jbxx.getCompanyType()));//类型
            jbxxElement.add(changeNullData(jbxx.getFrname()));//法定代表人
            jbxxElement.add(changeNullData(jbxx.getRegcap()));//注册资本
            jbxxElement.add(changeNullData(jbxx.getEsdate()));//成立日期
            jbxxElement.add(changeNullData(jbxx.getAddress()));//企业地址
            BaseDataOverviewDTO baseDataOverviewDTO = baseDataService.getBaseDataOverviewByCompanyId(companyId);
            jbxxElement.add(changeNullData(baseDataOverviewDTO.getWebsite()));//官方网址
            jbxxElement.add(changeNullData(jbxx.getOpenfrom()));//经营期限自
            jbxxElement.add(changeNullData(jbxx.getOpento()));//经营期限至
            jbxxElement.add(changeNullData(jbxx.getOperateScope()));//经营范围
            jbxxElement.add(changeNullData(jbxx.getRegorg()));//登记机关
            jbxxElement.add(changeNullData(jbxx.getApprovalDate()));//核准日期
            jbxxElement.add(changeNullData(jbxx.getCompanyEnterpriseStatus()));//登记状态

            List<List<String>> jbxxDataList = new ArrayList<>();
            for (int i = 0; i < jbxxElement.size(); i++) {
                List<String> data = new ArrayList<String>();
                data.add(jbxxHeader.get(i));
                data.add(jbxxElement.get(i));
                jbxxDataList.add(data);
            }
            //工商信息
            dataMap.put("jbxxData", jbxxDataList);
        }
    }

    /**
     * 获取公司股东信息
     *
     * @param dataMap
     * @param baseDataVO
     */
    private void getGdxxInfo(Map<String, Object> dataMap, BaseDataVO baseDataVO) {
        List<List<String>> gdxxDataList = new ArrayList<>();
        List<String> gdxxHeader = new ArrayList<String>() {{
            add("股东类型");
            add("股东");
            add("出资比例");
            add("出资额");
            add("出资方式");
            add("认缴出资额(万元)");
            add("实缴出资额(万元)");
        }};
        gdxxDataList.add(gdxxHeader);
        if (null == baseDataVO || CollectionUtils.isEmpty(baseDataVO.getGdxx())) {
            //股东信息
            dataMap.put("gdxxData", new ArrayList<>());
        } else {
            List<BaseDataVO.Gdxx> gdxxList = baseDataVO.getGdxx();
            for (BaseDataVO.Gdxx gdxx : gdxxList) {
                List<String> gdxxElement = new ArrayList<String>();
                gdxxElement.add(changeNullData(gdxx.getShareholderType()));//股东类型
                gdxxElement.add(changeNullData(gdxx.getShareholderName()));//股东
                gdxxElement.add(changeNullData(gdxx.getInvestRatio()));//出资比例
                gdxxElement.add(changeNullData(gdxx.getInvestAmount()));//出资额
                gdxxElement.add(changeNullData(gdxx.getInvestName()));//出资方式
                gdxxElement.add(changeNullData(gdxx.getSubscribedCapital()));//认缴出资额(万元)
                gdxxElement.add(changeNullData(gdxx.getPaidContribution()));//实缴出资额(万元)

                gdxxDataList.add(gdxxElement);
            }
            //股东信息
            dataMap.put("gdxxData", gdxxDataList);
        }
    }

    /**
     * 获取公司董高监信息
     *
     * @param dataMap
     * @param baseDataVO
     */
    private void getBaxxInfo(Map<String, Object> dataMap, BaseDataVO baseDataVO) {
        List<List<String>> baxxDataList = new ArrayList<>();
        List<String> baxxHeader = new ArrayList<String>() {{
            add("姓名");
            add("职务");
        }};
        baxxDataList.add(baxxHeader);
        if (null == baseDataVO) {
            dataMap.put("baxxData", new ArrayList<>());
        } else {
            if (CollectionUtils.isEmpty(baseDataVO.getDirectors()) &&
                    CollectionUtils.isEmpty(baseDataVO.getSupervisors()) &&
                    CollectionUtils.isEmpty(baseDataVO.getExecutives())) {
                dataMap.put("baxxData", new ArrayList<>());
            } else {
                //懂事
                if (CollectionUtils.isNotEmpty(baseDataVO.getDirectors())) {
                    List<BaseDataVO.Baxx> directorList = baseDataVO.getDirectors();
                    for (BaseDataVO.Baxx baxx : directorList) {
                        List<String> baxxElement = new ArrayList<String>();
                        baxxElement.add(changeNullData(baxx.getName()));//姓名
                        baxxElement.add(changeNullData(baxx.getPosition()));//职务
                        baxxDataList.add(baxxElement);
                    }
                }
                //监事
                if (CollectionUtils.isNotEmpty(baseDataVO.getSupervisors())) {
                    List<BaseDataVO.Baxx> supervisorList = baseDataVO.getSupervisors();
                    for (BaseDataVO.Baxx baxx : supervisorList) {
                        List<String> baxxElement = new ArrayList<String>();
                        baxxElement.add(changeNullData(baxx.getName()));//姓名
                        baxxElement.add(changeNullData(baxx.getPosition()));//职务
                        baxxDataList.add(baxxElement);
                    }
                }
                //高管
                if (CollectionUtils.isNotEmpty(baseDataVO.getExecutives())) {
                    List<BaseDataVO.Baxx> executivesList = baseDataVO.getExecutives();
                    for (BaseDataVO.Baxx baxx : executivesList) {
                        List<String> baxxElement = new ArrayList<String>();
                        baxxElement.add(changeNullData(baxx.getName()));//姓名
                        baxxElement.add(changeNullData(baxx.getPosition()));//职务
                        baxxDataList.add(baxxElement);
                    }
                }
                dataMap.put("baxxData", baxxDataList);
            }
        }
    }

    /**
     * 根据公司获取分支机构信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getFzjgInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> fzjgDataList = new ArrayList<>();
        List<String> fzjgHeader = new ArrayList<String>() {{
            add("分支机构名称");
            add("登记状态");
            add("法定代表人");
            add("成立日期");
            add("住所");
        }};
        fzjgDataList.add(fzjgHeader);
        PageInfo<FzjgDTO> pageInfo = baseDataService.getFzjgByCompanyId(companyId, page, pageSize);
        if (pageInfo == null) {
            dataMap.put("fzjg", new ArrayList<>());
        } else {
            List<FzjgDTO> fzjgList = pageInfo.getItems();
            for (FzjgDTO fzjg : fzjgList) {
                List<String> baxxElement = new ArrayList<String>();
                baxxElement.add(changeNullData(fzjg.getName()));//分支机构名称
                baxxElement.add(changeNullData(fzjg.getEnterpriseStatus()));//登记状态
                baxxElement.add(changeNullData(fzjg.getFrname()));//法定代表人
                baxxElement.add(changeNullData(fzjg.getEsdate()));//成立日期
                baxxElement.add(changeNullData(fzjg.getAddress()));//住所
                fzjgDataList.add(baxxElement);
            }
            dataMap.put("fzjg", fzjgDataList);
        }
    }

    /**
     * 根据公司名称获取海外机构信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getOverseasInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> overseasDataList = new ArrayList<>();
        List<String> overseasHeader = new ArrayList<String>() {{
            add("海外分支机构名称");
            add("核准日期");
            add("经营范围");
            add("境内投资主体");
            add("国家地区");
            add("省市");
        }};
        overseasDataList.add(overseasHeader);
        PageInfo<OverseasInvestDTO> overseasInvestInfo = baseDataService.getOverseasInvestByCompanyId(companyId, page, pageSize);
        if (null == overseasInvestInfo) {
            dataMap.put("overseasData", new ArrayList<>());
        } else {
            List<OverseasInvestDTO> overseasInvestList = overseasInvestInfo.getItems();
            for (OverseasInvestDTO overseasInvestDTO : overseasInvestList) {
                List<String> overseasInvestElement = new ArrayList<String>();
                overseasInvestElement.add(changeNullData(overseasInvestDTO.getForeignInvestEnterprises()));//海外分支机构名称
                overseasInvestElement.add(changeNullData(overseasInvestDTO.getApprovalDate()));//核准日期
                overseasInvestElement.add(changeNullData(overseasInvestDTO.getOperateScope()));//经营范围
                overseasInvestElement.add(changeNullData(overseasInvestDTO.getDomesticInvestSubject()));//境内投资主体
                overseasInvestElement.add(changeNullData(overseasInvestDTO.getCountryRegion()));//国家地区
                overseasInvestElement.add(changeNullData(overseasInvestDTO.getProvince()));//省市
                overseasDataList.add(overseasInvestElement);
            }
            dataMap.put("overseasData", overseasDataList);
        }
    }

    /**
     * 取得行政处罚信息
     *
     * @param dataMap
     * @param baseDataVO
     */
    private void getXzcfInfo(Map<String, Object> dataMap, BaseDataVO baseDataVO) throws Exception {

        List<List<String>> data = new ArrayList<>();
        dataMap.put("xzcfData", data);
        if (baseDataVO == null || CollectionUtils.isEmpty(baseDataVO.getXzcf())) {
            return;
        }
        for (BaseDataVO.Xzcf xzcf : baseDataVO.getXzcf()) {
            List<String> cxzcfElement = new ArrayList<String>();
            cxzcfElement.add(changeNullData(xzcf.getPublicDate()));//发布日期
            cxzcfElement.add(changeNullData(xzcf.getPunishCode()));//文书号
            cxzcfElement.add(changeNullData(xzcf.getPunishType()));//违法事实
            cxzcfElement.add(changeNullData(xzcf.getPunishOrg()));//处罚机关
            cxzcfElement.add(changeNullData(xzcf.getPunishContent()));//处罚结果
            data.add(cxzcfElement);
        }
    }

    /**
     * 关键自然人信息
     *
     * @param dataMap
     * @param relationInfoVO
     */
    private void getKeyNatureInfo(Map<String, Object> dataMap, RelationInfoVO relationInfoVO) {
        List<List<String>> keyNatureDataList = new ArrayList<>();
        List<String> keyNatureHeader = new ArrayList<String>() {{
            add("");
            add("关联范围");
            add("NO.1");
            add("NO.2");
            add("NO.3");
        }};
        keyNatureDataList.add(keyNatureHeader);
        List<String> pivotalNaturalPersonsTop1d = relationInfoVO.getPivotalNaturalPersonsTop1d();
        List<String> cxzcfElement1 = new ArrayList<String>();
        cxzcfElement1.add("关键自然人");
        cxzcfElement1.add("一度内");
        if (CollectionUtils.isEmpty(pivotalNaturalPersonsTop1d)) {
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
        } else {
            int oneSize = pivotalNaturalPersonsTop1d.size();
            cxzcfElement1.add(pivotalNaturalPersonsTop1d.get(0));
            if (oneSize > 1) {
                cxzcfElement1.add(pivotalNaturalPersonsTop1d.get(1));
                if (oneSize > 2) {
                    cxzcfElement1.add(pivotalNaturalPersonsTop1d.get(2));
                } else {
                    cxzcfElement1.add("--");
                }
            } else {
                cxzcfElement1.add("--");
                cxzcfElement1.add("--");
            }
        }
        keyNatureDataList.add(cxzcfElement1);


        List<String> pivotalNaturalPersonsTop2d = relationInfoVO.getPivotalNaturalPersonsTop2d();
        List<String> cxzcfElement2 = new ArrayList<String>();
        cxzcfElement2.add("");
        cxzcfElement2.add("二度内");
        if (CollectionUtils.isEmpty(pivotalNaturalPersonsTop2d)) {
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
        } else {
            int twoSize = pivotalNaturalPersonsTop2d.size();
            cxzcfElement2.add(pivotalNaturalPersonsTop2d.get(0));
            if (twoSize > 1) {
                cxzcfElement2.add(pivotalNaturalPersonsTop2d.get(1));
                if (twoSize > 2) {
                    cxzcfElement2.add(pivotalNaturalPersonsTop2d.get(2));
                } else {
                    cxzcfElement2.add("--");
                }
            } else {
                cxzcfElement2.add("--");
                cxzcfElement2.add("--");
            }
        }
        keyNatureDataList.add(cxzcfElement2);

        List<String> pivotalNaturalPersonsTop3d = relationInfoVO.getPivotalNaturalPersonsTop3d();
        List<String> cxzcfElement3 = new ArrayList<String>();
        cxzcfElement3.add("");
        cxzcfElement3.add("三度内");
        if (CollectionUtils.isEmpty(pivotalNaturalPersonsTop3d)) {
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
        } else {
            int threeSize = pivotalNaturalPersonsTop3d.size();
            cxzcfElement3.add(pivotalNaturalPersonsTop3d.get(0));
            if (threeSize > 1) {
                cxzcfElement3.add(pivotalNaturalPersonsTop3d.get(1));
                if (threeSize > 2) {
                    cxzcfElement3.add(pivotalNaturalPersonsTop3d.get(2));
                } else {
                    cxzcfElement3.add("--");
                }
            } else {
                cxzcfElement3.add("--");
                cxzcfElement3.add("--");
            }
        }
        keyNatureDataList.add(cxzcfElement3);
        dataMap.put("keyNatureData", keyNatureDataList);
    }

    /**
     * 关键非自然人信息
     *
     * @param dataMap
     * @param relationInfoVO
     */
    private void getKeyNoNatureInfo(Map<String, Object> dataMap, RelationInfoVO relationInfoVO) {
        List<List<String>> keyNonNatureDataList = new ArrayList<>();
        List<String> pivotalNonNaturalPersonsTop1d = relationInfoVO.getPivotalNonNaturalPersonsTop1d();
        List<String> cxzcfElement1 = new ArrayList<String>();
        cxzcfElement1.add("非关键自然人");
        cxzcfElement1.add("一度内");
        if (CollectionUtils.isEmpty(pivotalNonNaturalPersonsTop1d)) {
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
        } else {
            int oneSize = pivotalNonNaturalPersonsTop1d.size();
            cxzcfElement1.add(pivotalNonNaturalPersonsTop1d.get(0));
            if (oneSize > 1) {
                cxzcfElement1.add(pivotalNonNaturalPersonsTop1d.get(1));
                if (oneSize > 2) {
                    cxzcfElement1.add(pivotalNonNaturalPersonsTop1d.get(2));
                } else {
                    cxzcfElement1.add("--");
                }
            } else {
                cxzcfElement1.add("--");
                cxzcfElement1.add("--");
            }
        }
        keyNonNatureDataList.add(cxzcfElement1);

        List<String> pivotalNonNaturalPersonsTop2d = relationInfoVO.getPivotalNonNaturalPersonsTop2d();

        List<String> cxzcfElement2 = new ArrayList<String>();
        cxzcfElement2.add("");
        cxzcfElement2.add("二度内");
        if (CollectionUtils.isEmpty(pivotalNonNaturalPersonsTop2d)) {
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
        } else {
            int twoSize = pivotalNonNaturalPersonsTop2d.size();
            cxzcfElement2.add(pivotalNonNaturalPersonsTop2d.get(0));
            if (twoSize > 1) {
                cxzcfElement2.add(pivotalNonNaturalPersonsTop2d.get(1));
                if (twoSize > 2) {
                    cxzcfElement2.add(pivotalNonNaturalPersonsTop2d.get(2));
                } else {
                    cxzcfElement2.add("--");
                }
            } else {
                cxzcfElement2.add("--");
                cxzcfElement2.add("--");
            }
        }
        keyNonNatureDataList.add(cxzcfElement2);

        List<String> pivotalNonNaturalPersonsTop3d = relationInfoVO.getPivotalNonNaturalPersonsTop3d();

        List<String> cxzcfElement3 = new ArrayList<String>();
        cxzcfElement3.add("");
        cxzcfElement3.add("三度内");
        if (CollectionUtils.isEmpty(pivotalNonNaturalPersonsTop3d)) {
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
        } else {
            int threeSize = pivotalNonNaturalPersonsTop3d.size();
            cxzcfElement3.add(pivotalNonNaturalPersonsTop3d.get(0));
            if (threeSize > 1) {
                cxzcfElement3.add(pivotalNonNaturalPersonsTop3d.get(1));
                if (threeSize > 2) {
                    cxzcfElement3.add(pivotalNonNaturalPersonsTop3d.get(2));
                } else {
                    cxzcfElement3.add("--");
                }
            } else {
                cxzcfElement3.add("--");
                cxzcfElement3.add("--");
            }
        }
        keyNonNatureDataList.add(cxzcfElement3);
        dataMap.put("keyNonNatureData", keyNonNatureDataList);
    }

    /**
     * 关联集聚行业信息
     *
     * @param dataMap
     * @param relationInfoVO
     */
    private void getIndustryInfo(Map<String, Object> dataMap, RelationInfoVO relationInfoVO) {
        List<List<String>> industrySpanTop1dDataList = new ArrayList<>();
        List<String> industrySpanTop1d = relationInfoVO.getIndustrySpanTop1d();

        List<String> cxzcfElement1 = new ArrayList<String>();
        cxzcfElement1.add("关联集聚行业");
        cxzcfElement1.add("一度内");
        if (CollectionUtils.isEmpty(industrySpanTop1d)) {
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
        } else {
            int oneSize = industrySpanTop1d.size();
            cxzcfElement1.add(industrySpanTop1d.get(0));
            if (oneSize > 1) {
                cxzcfElement1.add(industrySpanTop1d.get(1));
                if (oneSize > 2) {
                    cxzcfElement1.add(industrySpanTop1d.get(2));
                } else {
                    cxzcfElement1.add("--");
                }
            } else {
                cxzcfElement1.add("--");
                cxzcfElement1.add("--");
            }
        }
        industrySpanTop1dDataList.add(cxzcfElement1);

        List<String> industrySpanTop2d = relationInfoVO.getIndustrySpanTop2d();
        List<String> cxzcfElement2 = new ArrayList<String>();
        cxzcfElement2.add("");
        cxzcfElement2.add("二度内");
        if (CollectionUtils.isEmpty(industrySpanTop2d)) {
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
        } else {
            int twoSize = industrySpanTop2d.size();
            cxzcfElement2.add(industrySpanTop2d.get(0));
            if (twoSize > 1) {
                cxzcfElement2.add(industrySpanTop2d.get(1));
                if (twoSize > 2) {
                    cxzcfElement2.add(industrySpanTop2d.get(2));
                } else {
                    cxzcfElement2.add("--");
                }
            } else {
                cxzcfElement2.add("--");
                cxzcfElement2.add("--");
            }
        }
        industrySpanTop1dDataList.add(cxzcfElement2);

        List<String> industrySpanTop3d = relationInfoVO.getIndustrySpanTop3d();
        List<String> cxzcfElement3 = new ArrayList<String>();
        cxzcfElement3.add("");
        cxzcfElement3.add("三度内");
        if (CollectionUtils.isEmpty(industrySpanTop3d)) {
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
        } else {
            int threeSize = industrySpanTop3d.size();
            cxzcfElement3.add(industrySpanTop3d.get(0));
            if (threeSize > 1) {
                cxzcfElement3.add(industrySpanTop3d.get(1));
                if (threeSize > 2) {
                    cxzcfElement3.add(industrySpanTop3d.get(2));
                } else {
                    cxzcfElement3.add("--");
                }
            } else {
                cxzcfElement3.add("--");
                cxzcfElement3.add("--");
            }
        }
        industrySpanTop1dDataList.add(cxzcfElement3);
        dataMap.put("industrySpanTop1dData", industrySpanTop1dDataList);
    }

    /**
     * 关联集聚地信息
     *
     * @param dataMap
     * @param companyId
     */
    private void getGatherPlathInfo(Map<String, Object> dataMap, String companyId) throws Exception {

        RelationTotalInfoVO relationTotalInfoVO = relationTotalInfoService.getRightRelation(companyId);
        if (relationTotalInfoVO == null) {
            return;
        }
        List<List<String>> gatherPlathTop1dDataList = new ArrayList<>();
        List<String> gatherPlathTop1d = null;
        if (relationTotalInfoVO.getRelationTotalInfoDetail1dVO() != null && relationTotalInfoVO.getRelationTotalInfoDetail1dVO().getRelationPlace() != null) {
            gatherPlathTop1d = Arrays.asList(relationTotalInfoVO.getRelationTotalInfoDetail1dVO().getRelationPlace().split("、"));
        }
        List<String> cxzcfElement1 = new ArrayList<String>();
        cxzcfElement1.add("关联集聚地");
        cxzcfElement1.add("一度内");
        if (CollectionUtils.isEmpty(gatherPlathTop1d)) {
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
            cxzcfElement1.add("--");
        } else {
            int oneSize = gatherPlathTop1d.size();
            cxzcfElement1.add(gatherPlathTop1d.get(0));
            if (oneSize > 1) {
                cxzcfElement1.add(gatherPlathTop1d.get(1));
                if (oneSize > 2) {
                    cxzcfElement1.add(gatherPlathTop1d.get(2));
                } else {
                    cxzcfElement1.add("--");
                }
            } else {
                cxzcfElement1.add("--");
                cxzcfElement1.add("--");
            }
        }
        gatherPlathTop1dDataList.add(cxzcfElement1);

        List<String> gatherPlathTop2d = null;
        if (relationTotalInfoVO.getRelationTotalInfoDetail2dVO() != null && relationTotalInfoVO.getRelationTotalInfoDetail2dVO().getRelationPlace() != null) {
            gatherPlathTop2d = Arrays.asList(relationTotalInfoVO.getRelationTotalInfoDetail2dVO().getRelationPlace().split("、"));
        }
        List<String> cxzcfElement2 = new ArrayList<String>();
        cxzcfElement2.add("");
        cxzcfElement2.add("二度内");
        if (CollectionUtils.isEmpty(gatherPlathTop2d)) {
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
            cxzcfElement2.add("--");
        } else {
            int twoSize = gatherPlathTop2d.size();
            cxzcfElement2.add(gatherPlathTop2d.get(0));
            if (twoSize > 1) {
                cxzcfElement2.add(gatherPlathTop2d.get(1));
                if (twoSize > 2) {
                    cxzcfElement2.add(gatherPlathTop2d.get(2));
                } else {
                    cxzcfElement2.add("--");
                }
            } else {
                cxzcfElement2.add("--");
                cxzcfElement2.add("--");
            }
        }
        gatherPlathTop1dDataList.add(cxzcfElement2);
        List<String> gatherPlathTop3d = null;
        if (relationTotalInfoVO.getRelationTotalInfoDetail3dVO() != null && relationTotalInfoVO.getRelationTotalInfoDetail3dVO().getRelationPlace() != null) {
            gatherPlathTop3d = Arrays.asList(relationTotalInfoVO.getRelationTotalInfoDetail3dVO().getRelationPlace().split("、"));
        }
        List<String> cxzcfElement3 = new ArrayList<String>();
        cxzcfElement3.add("");
        cxzcfElement3.add("三度内");
        if (CollectionUtils.isEmpty(gatherPlathTop3d)) {
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
            cxzcfElement3.add("--");
        } else {
            int threeSize = gatherPlathTop3d.size();
            cxzcfElement3.add(gatherPlathTop3d.get(0));
            if (threeSize > 1) {
                cxzcfElement3.add(gatherPlathTop3d.get(1));
                if (threeSize > 2) {
                    cxzcfElement3.add(gatherPlathTop3d.get(2));
                } else {
                    cxzcfElement3.add("--");
                }
            } else {
                cxzcfElement3.add("--");
                cxzcfElement3.add("--");
            }
        }
        gatherPlathTop1dDataList.add(cxzcfElement3);
        dataMap.put("gatherPlathData", gatherPlathTop1dDataList);
    }

    /**
     * 根据公司获取工商变更信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getBgxxInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> bgxxDataList = new ArrayList<>();
        List<String> bgxxHeader = new ArrayList<String>() {{
            add("序号");
            add("变更时间");
            add("变更项目");
            add("变更前");
            add("变更后");
        }};
        bgxxDataList.add(bgxxHeader);
        PageInfo<BgxxDTO> bgxxDTO = manageDataService.getBgxxByCompanyId(companyId, page, pageSize, false);
        if (null == bgxxDTO) {
            dataMap.put("bgxxData", new ArrayList<>());
        } else {
            List<BgxxDTO> bgxxList = bgxxDTO.getItems();
            int bgxxIndex = 1;
            for (BgxxDTO data : bgxxList) {
                List<String> bgxxElement = new ArrayList<String>();
                bgxxElement.add(String.valueOf(bgxxIndex));//序号
                bgxxElement.add(changeNullData(data.getChangeDate()));//变更时间
                bgxxElement.add(changeNullData(data.getChangeItems()));//变更项目
                bgxxElement.add(changeNullData(data.getContentBeforeChange()));//变更前
                bgxxElement.add(changeNullData(data.getContentAfterChange()));//国家地区
                bgxxDataList.add(bgxxElement);
                bgxxIndex++;
            }
            dataMap.put("bgxxData", bgxxDataList);
        }

    }

    /**
     * 根据公司获取域名备案信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getYmbaInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> ymbaDataList = new ArrayList<>();
        List<String> ymbaHeader = new ArrayList<String>() {{
            add("序号");
            add("网址");
            add("网站名称");
            add("网站备案/许可证号");
            add("登记批准日期");
        }};
        ymbaDataList.add(ymbaHeader);
        PageInfo<YmbaDTO> ymbaInfo = manageDataService.getYmbaBycompanyId(companyId, page, pageSize);
        if (null == ymbaInfo) {
            dataMap.put("ymbaData", new ArrayList<>());
        } else {
            List<YmbaDTO> ymbaList = ymbaInfo.getItems();
            int ymbaIndex = 1;
            for (YmbaDTO data : ymbaList) {
                List<String> ymbaElement = new ArrayList<String>();
                ymbaElement.add(String.valueOf(ymbaIndex));//序号
                ymbaElement.add(changeNullData(data.getHomepageUrl()));//网址
                ymbaElement.add(changeNullData(data.getWebsiteName()));//网站名称
                ymbaElement.add(changeNullData(data.getRecordLicense()));//网站备案/许可证号
                ymbaElement.add(changeNullData(data.getApprovalTime()));//登记批准日期
                ymbaDataList.add(ymbaElement);
                ymbaIndex++;
            }
            dataMap.put("ymbaData", ymbaDataList);
        }
    }

    /**
     * 根据公司名称获取招聘信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getZhaoPinInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> recruitDataList = new ArrayList<>();
        List<String> recruitHeader = new ArrayList<String>() {{
            add("序号");
            add("职位");
            add("薪资");
            add("经验");
            add("地点");
            add("学历");
            add("信息来源");
            add("发布日期");
        }};
        recruitDataList.add(recruitHeader);
        PageInfo<RecruitDTO> recruitInfo = manageDataService.getRecruitBycompanyId(companyId, page, pageSize);
        if (null == recruitInfo) {
            dataMap.put("recruitData", new ArrayList<>());
        } else {
            List<RecruitDTO> recruitList = recruitInfo.getItems();
            int recruitIndex = 1;
            for (RecruitDTO data : recruitList) {
                List<String> recruitElement = new ArrayList<String>();
                recruitElement.add(String.valueOf(recruitIndex));//序号
                recruitElement.add(changeNullData(data.getJobTitle()));//职位
                recruitElement.add(changeNullData(data.getSalary()));//薪资
                recruitElement.add(changeNullData(data.getServiceYear()));//经验
                recruitElement.add(changeNullData(data.getLocation()));//地点
                recruitElement.add(changeNullData(data.getEducationRequired()));//学历要求
                recruitElement.add(changeNullData(data.getSource()));//信息来源
                recruitElement.add(changeNullData(data.getPubdate()));//发布日期
                recruitDataList.add(recruitElement);
                recruitIndex++;
            }
            dataMap.put("recruitData", recruitDataList);
        }
    }

    /**
     * 根据公司名称获取年报信息
     *
     * @param dataMap
     * @param companyId
     */
    private void getYearReportInfo(Map<String, Object> dataMap, String companyId) throws Exception {
        YearReportDTO yearReportDTO = manageDataService.getYearReportByCompanyId(companyId);
        List<YearReportVO> yearReportVOList = YearReportUtil.transYearReportDTOToVO(yearReportDTO);
        List<String> yearList = new ArrayList<String>();

        List<List<String>> cxzzDataTitle = new ArrayList<>();
        List<String> czxxHeader1 = new ArrayList<String>() {{
            add("股东及出资信息");
        }};
        cxzzDataTitle.add(czxxHeader1);

        List<List<String>> zxxxDataTitle = new ArrayList<>();
        List<String> zcxxElement1 = new ArrayList<String>() {{
            add("企业资产状况信息");
        }};
        zxxxDataTitle.add(zcxxElement1);

        List<List<String>> dbxxDataTitle = new ArrayList<>();
        List<String> dbxxHeader1 = new ArrayList<String>() {{
            add("担保信息");
        }};
        dbxxDataTitle.add(dbxxHeader1);

        List<List<String>> gqdbxxDataTitle = new ArrayList<>();
        List<String> gqdbxxHeader1 = new ArrayList<String>() {{
            add("股权变更信息");
        }};
        gqdbxxDataTitle.add(gqdbxxHeader1);

        List<List<String>> gzsmDataTitle = new ArrayList<>();
        List<String> gzsmHeader1 = new ArrayList<String>() {{
            add("年报信息更正说明");
        }};
        gzsmDataTitle.add(gzsmHeader1);

        List<String> czxxHeader2 = new ArrayList<String>() {{
            add("股东");
            add("认缴出资（万元）");
            add("认缴出资时间");
            add("认缴出资方式");
            add("实缴出资（万元）");
            add("实缴出资时间");
            add("实缴出资方式");
        }};
        List<String> zcxxElement2 = new ArrayList<String>() {{
            add("资产负债情况");
            add("");
            add("收入情况");
            add("");
            add("纳税情况");
            add("");
        }};
        List<String> dbxxHeader2 = new ArrayList<String>() {{
            add("债权人");
            add("债务人");
            add("主债权种类");
            add("主债权数额");
            add("履行债务的期限");
            add("保证的期间");
            add("保证的方式");
            add("保证担保的范围");
        }};
        List<String> gqdbxxHeader2 = new ArrayList<String>() {{
            add("股东");
            add("变更前股权比例");
            add("变更后股权比例");
            add("股权变更日期");
        }};
        List<String> gzsmHeader2 = new ArrayList<String>() {{
            add("修改事项");
            add("修改时间");
            add("修改理由");
        }};
        if (null == yearReportDTO || CollectionUtils.isEmpty(yearReportVOList)) {
            String year = "--";
            yearList.add(year);
            dataMap.put(year + "czxx", new ArrayList<>());

            //企业资产状况信息
            dataMap.put(year + "zcxx", new ArrayList<>());

            //担保信息
            dataMap.put(year + "dbxx", new ArrayList<>());

            //股权变更信息
            dataMap.put(year + "gqbgxx", new ArrayList<>());

            //年报信息更正说明
            dataMap.put(year + "gzsm", new ArrayList<>());
        } else {
            dataMap.put("gzsmDataTitle", gzsmDataTitle);
            dataMap.put("gqdbxxDataTitle", gqdbxxDataTitle);
            dataMap.put("dbxxDataTitle", dbxxDataTitle);
            dataMap.put("zxxxDataTitle", zxxxDataTitle);
            dataMap.put("cxzzDataTitle", cxzzDataTitle);

            for (YearReportVO yearReportVO : yearReportVOList) {
                String year = yearReportVO.getYear();
                yearList.add(year);
                //股东及出资信息
                List<List<String>> cxzzDataList = new ArrayList<>();
                List<YearReportVO.Czxx> qyxxNbCzxx = yearReportVO.getQyxxNbCzxx();
                cxzzDataList.add(czxxHeader2);

                if (CollectionUtils.isEmpty(qyxxNbCzxx)) {
                    List<String> czxxElement = new ArrayList<String>();
                    for (int i = 0; i < czxxHeader2.size(); i++) {
                        czxxElement.add("--");
                    }
                    cxzzDataList.add(czxxElement);
                } else {
                    for (YearReportVO.Czxx czxx : qyxxNbCzxx) {
                        List<String> czxxElement = new ArrayList<String>();
                        czxxElement.add(changeNullData(czxx.getShareholderName()));//股东
                        czxxElement.add(changeNullData(czxx.getSubscribedCapital()));//认缴出资额
                        czxxElement.add(changeNullData(czxx.getSubscribedDate()));//认缴出资时间
                        czxxElement.add(changeNullData(czxx.getSubscribedType()));//认缴出资方式
                        czxxElement.add(changeNullData(czxx.getPaidinCapital()));//实缴出资
                        czxxElement.add(changeNullData(czxx.getPaidinDate()));//实缴出资时间
                        czxxElement.add(changeNullData(czxx.getPaidinType()));//实缴出资方式
                        cxzzDataList.add(czxxElement);
                    }
                }
                dataMap.put(year + "czxx", cxzzDataList);

                //企业资产状况信息
                List<List<String>> zcxxDataList = new ArrayList<>();
                List<YearReportVO.Zcxx> zcxxList = yearReportVO.getQyxxNbZcxx();
                zcxxDataList.add(zcxxElement2);
                if (CollectionUtils.isEmpty(zcxxList)) {
                    List<String> zcxxElement3 = new ArrayList<String>();
                    zcxxElement3.add("资产总额：");
                    zcxxElement3.add("--");
                    zcxxElement3.add("营业总收入：");
                    zcxxElement3.add("--");
                    zcxxElement3.add("纳税总额：");
                    zcxxElement3.add("--");
                    zcxxDataList.add(zcxxElement3);

                    List<String> zcxxElement4 = new ArrayList<String>();
                    zcxxElement4.add("负债总额：");
                    zcxxElement4.add("--");
                    zcxxElement4.add("营业总收入中主营业务收入：");
                    zcxxElement4.add("--");
                    zcxxElement4.add("");
                    zcxxElement4.add("");
                    zcxxDataList.add(zcxxElement4);

                    List<String> zcxxElement5 = new ArrayList<String>();
                    zcxxElement5.add("所有者权益合计：");
                    zcxxElement5.add("--");
                    zcxxElement5.add("利润总额：");
                    zcxxElement5.add("--");
                    zcxxElement5.add("");
                    zcxxElement5.add("");
                    zcxxDataList.add(zcxxElement5);

                    List<String> zcxxElement6 = new ArrayList<String>();
                    zcxxElement6.add("");
                    zcxxElement6.add("");
                    zcxxElement6.add("净利润：");
                    zcxxElement6.add("--");
                    zcxxElement6.add("");
                    zcxxElement6.add("");
                    zcxxDataList.add(zcxxElement6);
                } else {
                    List<String> zcxxElement3 = new ArrayList<String>();
                    zcxxElement3.add("资产总额：");
                    zcxxElement3.add(changeNullData(zcxxList.get(0).getAssetsTotal()));
                    zcxxElement3.add("营业总收入：");
                    zcxxElement3.add(changeNullData(zcxxList.get(0).getTotalBusinessIncome()));
                    zcxxElement3.add("纳税总额：");
                    zcxxElement3.add(changeNullData(zcxxList.get(0).getTaxTotal()));
                    zcxxDataList.add(zcxxElement3);

                    List<String> zcxxElement4 = new ArrayList<String>();
                    zcxxElement4.add("负债总额：");
                    zcxxElement4.add(changeNullData(zcxxList.get(0).getLiabilitiesTotal()));
                    zcxxElement4.add("营业总收入中主营业务收入：");
                    zcxxElement4.add(changeNullData(zcxxList.get(0).getMainBusinessIncome()));
                    zcxxElement4.add("");
                    zcxxElement4.add("");
                    zcxxDataList.add(zcxxElement4);

                    List<String> zcxxElement5 = new ArrayList<String>();
                    zcxxElement5.add("所有者权益合计：");
                    zcxxElement5.add(changeNullData(zcxxList.get(0).getEquityTotal()));
                    zcxxElement5.add("利润总额：");
                    zcxxElement5.add(changeNullData(zcxxList.get(0).getProfitTotal()));
                    zcxxElement5.add("");
                    zcxxElement5.add("");
                    zcxxDataList.add(zcxxElement5);

                    List<String> zcxxElement6 = new ArrayList<String>();
                    zcxxElement6.add("");
                    zcxxElement6.add("");
                    zcxxElement6.add("净利润：");
                    zcxxElement6.add(changeNullData(zcxxList.get(0).getProfitNet()));
                    zcxxElement6.add("");
                    zcxxElement6.add("");
                    zcxxDataList.add(zcxxElement6);
                }
                dataMap.put(year + "zcxx", zcxxDataList);

                //担保信息
                List<List<String>> dbxxDataList = new ArrayList<>();
                List<YearReportVO.Dbxx> dbxxList = yearReportVO.getQyxxNbDbxx();
                dbxxDataList.add(dbxxHeader2);
                if (CollectionUtils.isEmpty(dbxxList)) {
                    List<String> dbxxElement = new ArrayList<String>();
                    for (int i = 0; i < dbxxHeader2.size(); i++) {
                        dbxxElement.add("--");
                    }
                    dbxxDataList.add(dbxxElement);
                } else {
                    for (YearReportVO.Dbxx dbxx : dbxxList) {
                        List<String> dbxxElement = new ArrayList<String>();
                        dbxxElement.add(changeNullData(dbxx.getCreditor()));//债权人
                        dbxxElement.add(changeNullData(dbxx.getDebtor()));//债务人
                        dbxxElement.add(changeNullData(dbxx.getCreditorType()));//主债权种类
                        dbxxElement.add(changeNullData(dbxx.getCreditorNum()));//主债权数额
                        dbxxElement.add(changeNullData(dbxx.getDebtDeadline()));//履行债务的期限
                        dbxxElement.add(changeNullData(dbxx.getGuaranteePeriod()));//保证的期间
                        dbxxElement.add(changeNullData(dbxx.getGuaranteeType()));//保证的方式
                        dbxxElement.add(changeNullData(dbxx.getGuaranteeScope()));//保证担保的范围
                        dbxxDataList.add(dbxxElement);
                    }
                }
                dataMap.put(year + "dbxx", dbxxDataList);

                //股权变更信息
                List<List<String>> gqbgxxDataList = new ArrayList<>();
                List<YearReportVO.Bgxx> gqbgxxList = yearReportVO.getQyxxNbBgxx();
                gqbgxxDataList.add(gqdbxxHeader2);
                if (CollectionUtils.isEmpty(gqbgxxList)) {
                    List<String> gqbgxxElement = new ArrayList<String>();
                    for (int i = 0; i < gqdbxxHeader2.size(); i++) {
                        gqbgxxElement.add("--");
                    }
                    gqbgxxDataList.add(gqbgxxElement);
                } else {
                    for (YearReportVO.Bgxx gqbgxx : gqbgxxList) {
                        List<String> gqbgxxElement = new ArrayList<String>();
                        gqbgxxElement.add(changeNullData(gqbgxx.getShareholderName()));//股东
                        gqbgxxElement.add(changeNullData(gqbgxx.getContentBeforeChange()));//变更前股权比例
                        gqbgxxElement.add(changeNullData(gqbgxx.getContentAfterChange()));//变更后股权比例
                        gqbgxxElement.add(changeNullData(gqbgxx.getChangeDate()));//股权变更日期
                        gqbgxxDataList.add(gqbgxxElement);
                    }
                }
                dataMap.put(year + "gqbgxx", gqbgxxDataList);

                //年报信息更正说明
                List<List<String>> gzsmDataList = new ArrayList<>();
                List<YearReportVO.Gzsm> gzsmList = yearReportVO.getQyxxNbGzsm();
                gzsmDataList.add(gzsmHeader2);
                if (CollectionUtils.isEmpty(gzsmList)) {
                    List<String> gzsmElement = new ArrayList<String>();
                    for (int i = 0; i < gzsmHeader2.size(); i++) {
                        gzsmElement.add("--");
                    }
                    gzsmDataList.add(gzsmElement);
                } else {
                    for (YearReportVO.Gzsm gzsm : gzsmList) {
                        List<String> gzsmElement = new ArrayList<String>();
                        gzsmElement.add(changeNullData(gzsm.getGzsmContent()));//修改事项
                        gzsmElement.add(changeNullData(gzsm.getGzsmDate()));//修改时间
                        gzsmElement.add(changeNullData(gzsm.getGzsmReason()));//修改理由
                        gzsmDataList.add(gzsmElement);
                    }
                }
                dataMap.put(year + "gzsm", gzsmDataList);
            }
        }
        dataMap.put("year", yearList);
    }

    /**
     * 根据公司名称取得动产抵押信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getDcdyInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> mortgageDataList = new ArrayList<>();
        List<String> mortgageHeader = new ArrayList<String>() {{
            add("序号");
            add("申请抵押原因");
            add("抵押权人");
            add("抵押人");
            add("抵押ID");
            add("登记证号");
            add("履约起止日期");
            add("抵押物名称");
        }};
        mortgageDataList.add(mortgageHeader);
        PageInfo<MortgageDetailDTO> mortgageInfo = creditService.getMortgageDetail(companyId, page, pageSize);
        if (null == mortgageInfo) {
//            List<String> mortgageElement = new ArrayList<String>();
//            for (int i = 0; i < mortgageHeader.size(); i++) {
//                mortgageElement.add("--");
//            }
//            mortgageDataList.add(mortgageElement);
            dataMap.put("cmortgageData", new ArrayList<>());
        } else {
            List<MortgageDetailDTO> cmortgageDataList = mortgageInfo.getItems();
            int mortgageIndex = 1;
            for (MortgageDetailDTO data : cmortgageDataList) {
                List<String> mortgageElement = new ArrayList<String>();
                mortgageElement.add(String.valueOf(mortgageIndex));//序号
                mortgageElement.add(changeNullData(data.getAppregrea()));//申请抵押原因
                mortgageElement.add(changeNullData(data.getMore()));// 抵押权人
                mortgageElement.add(changeNullData(data.getMortgagor()));//抵押人
                mortgageElement.add(changeNullData(data.getMorregId()));//抵押ID
                mortgageElement.add(changeNullData(data.getMorregcno()));//登记证号
                mortgageElement.add(changeNullData(data.getPefperform()) + "-" + changeNullData(data.getPefperto()));//履约起止日期
                mortgageElement.add(changeNullData(data.getGuaname()));//抵押物名称
                mortgageDataList.add(mortgageElement);
                mortgageIndex++;
            }
            dataMap.put("cmortgageData", mortgageDataList);
        }
    }

    /**
     * 根据公司名称取得股权出资信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getGqczInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> sharesPawnDataList = new ArrayList<>();
        List<String> sharesPawnHeader = new ArrayList<String>() {{
            add("序号");
            add("出质备案日期");
            add("出质金额");
            add("出质人");
            add("出质人类别");
            add("质权人");
            add("状态");
        }};
        sharesPawnDataList.add(sharesPawnHeader);
        PageInfo<SharesPawnDTO> sharesPawnInfo = creditService.getSharesPawn(companyId, page, pageSize);
        if (null == sharesPawnInfo) {
            dataMap.put("csharesPawnData", new ArrayList<>());
        } else {
            List<SharesPawnDTO> csharesPawnDataList = sharesPawnInfo.getItems();
            int sharesPawnIndex = 1;
            for (SharesPawnDTO data : csharesPawnDataList) {
                List<String> sharesPawnElement = new ArrayList<String>();
                sharesPawnElement.add(String.valueOf(sharesPawnIndex));//序号
                sharesPawnElement.add(changeNullData(data.getImponrecdate()));//出质备案日期
                sharesPawnElement.add(changeNullData(data.getImpam()));// 出质金额
                sharesPawnElement.add(changeNullData(data.getImporg()));//出质人
                sharesPawnElement.add(changeNullData(data.getImporgtype()));//出质人类别
                sharesPawnElement.add(changeNullData(data.getPledgee()));//质权人
                sharesPawnElement.add(changeNullData(data.getImpstate()));//状态
                sharesPawnDataList.add(sharesPawnElement);
                sharesPawnIndex++;
            }
            dataMap.put("csharesPawnData", sharesPawnDataList);
        }
    }

    /**
     * 根据公司名称取得清算情况信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getQinsqkInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> qsxxDataList = new ArrayList<>();
        List<String> qsxxHeader = new ArrayList<String>() {{
            add("序号");
            add("清算责任人");
            add("清算完结情况");
            add("清算负责人");
            add("清算完结日期");
            add("债务承接人");
            add("债权承接人");
        }};
        qsxxDataList.add(qsxxHeader);
        PageInfo<QsxxDTO> qsxxInfo = creditService.getQsxxByCompanyId(companyId, page, pageSize);
        if (null == qsxxInfo) {
            dataMap.put("cqsxxData", new ArrayList<>());
        } else {
            List<QsxxDTO> cqsxxDataList = qsxxInfo.getItems();
            int qsxxIndex = 1;
            for (QsxxDTO data : cqsxxDataList) {
                List<String> qsxxElement = new ArrayList<String>();
                qsxxElement.add(String.valueOf(qsxxIndex));//序号
                qsxxElement.add(changeNullData(data.getLigentity()));//清算责任人
                qsxxElement.add(changeNullData(data.getLigst()));//清算完结情况
                qsxxElement.add(changeNullData(data.getLigprincipal()));//清算负责人
                qsxxElement.add(changeNullData(data.getLigenddate()));//清算完结日期
                qsxxElement.add(changeNullData(data.getDebttranee()));//债务承接人
                qsxxElement.add(changeNullData(data.getClaimtranee()));//债权承接人
                qsxxDataList.add(qsxxElement);
                qsxxIndex++;
            }
            dataMap.put("cqsxxData", qsxxDataList);
        }
    }

    /**
     * 根据公司名称取得欠税情况信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getQsqkInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> qsmdDataList = new ArrayList<>();
        List<String> qsmdHeader = new ArrayList<String>() {{
            add("序号");
            add("欠税日期");
            add("税种");
            add("欠税金额");
            add("纳税人识别号");
            add("主管税务机关");
        }};
        qsmdDataList.add(qsmdHeader);
        PageInfo<QsmdDTO> qsmdInfo = creditService.getQsmdByCompanyId(companyId, page, pageSize);
        if (null == qsmdInfo) {
            dataMap.put("cqsmdData", new ArrayList<>());
        } else {
            List<QsmdDTO> cqsmdDataList = qsmdInfo.getItems();
            int qsmdIndex = 1;
            for (QsmdDTO data : cqsmdDataList) {
                List<String> qsmdElement = new ArrayList<String>();
                qsmdElement.add(String.valueOf(qsmdIndex));//序号
                qsmdElement.add(changeNullData(data.getTaxesTime()));//欠税日期
                qsmdElement.add(changeNullData(data.getTaxesCategory()));//税种
                qsmdElement.add(changeNullData(data.getTaxesResidual()));//欠税金额
                qsmdElement.add(changeNullData(data.getTaxpayerId()));//纳税人识别号
                qsmdElement.add(changeNullData(data.getTaxAuthorities()));//主管税务机关
                qsmdDataList.add(qsmdElement);
                qsmdIndex++;
            }
            dataMap.put("cqsmdData", qsmdDataList);
        }
    }

    /**
     * 根据公司名称取得经营异常信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getJyycInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> jyycDataList = new ArrayList<>();
        List<String> jyycHeader = new ArrayList<String>() {{
            add("序号");
            add("列入原因");
            add("列入日期");
            add("移出原因");
            add("移出日期");
            add("作出决定机关");
        }};
        jyycDataList.add(jyycHeader);
        PageInfo<JyycDTO> jyycInfo = creditService.getJyycByCompanyId(companyId, page, pageSize);
        if (null == jyycInfo) {
            dataMap.put("cjyycData", new ArrayList<>());
        } else {
            List<JyycDTO> cjyycDataList = jyycInfo.getItems();
            int jyycIndex = 1;
            for (JyycDTO data : cjyycDataList) {
                List<String> jyycElement = new ArrayList<String>();
                jyycElement.add(String.valueOf(jyycIndex));//序号
                jyycElement.add(changeNullData(data.getBusexcepList()));//列入原因
                jyycElement.add(changeNullData(data.getRankDate()));//列入日期
                jyycElement.add(changeNullData(data.getRemoveBusexcepList()));//移出原因
                jyycElement.add(changeNullData(data.getRemoveDate()));//移出日期
                jyycElement.add(changeNullData(data.getDecisionOrg()));//作出决定机关
                jyycDataList.add(jyycElement);
                jyycIndex++;
            }
            dataMap.put("cjyycData", jyycDataList);
        }
    }

    /**
     * 根据公司名称取得司法拍卖信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getSfpmInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> sfpmDataList = new ArrayList<>();
        List<String> sfpmHeader = new ArrayList<String>() {{
            add("序号");
            add("拍卖日期");
            add("拍卖标的");
            add("起拍价");
            add("拍品介绍");
        }};
        sfpmDataList.add(sfpmHeader);
        PageInfo<SfpmDto> sfpmInfo = creditService.getSfpmByCompanyId(companyId, page, pageSize);
        if (null == sfpmInfo) {
            dataMap.put("csfpmData", new ArrayList<>());
        } else {
            List<SfpmDto> csfpmDataList = sfpmInfo.getItems();
            int sfpmIndex = 1;
            for (SfpmDto data : csfpmDataList) {
                List<String> csfpmElement = new ArrayList<String>();
                csfpmElement.add(String.valueOf(sfpmIndex));//序号
                csfpmElement.add(changeNullData(data.getAuctionDate()));//拍卖日期
                csfpmElement.add(changeNullData(data.getAuctionName()));//拍卖标的
                csfpmElement.add(changeNullData(data.getStartPrice()));//起拍价
                csfpmElement.add(changeNullData(data.getAuctionIntroduce()));//拍品介绍
                sfpmDataList.add(csfpmElement);
                sfpmIndex++;
            }
            dataMap.put("csfpmData", sfpmDataList);
        }
    }

    /**
     * 根据公司名称取得失信被执行人信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getSxbzxrInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> sxbzxrDataList = new ArrayList<>();
        List<String> sxbzxrHeader = new ArrayList<String>() {{
            add("序号");
            add("发布日期");
            add("案号");
            add("被执行人");
            add("执行法院");
            add("被执行人履行情况");
        }};
        sxbzxrDataList.add(sxbzxrHeader);
        PageInfo<SxbzxrDTO> sxbzxrInfo = creditService.getSxbzxrByCompanyId(companyId, page, pageSize);
        if (null == sxbzxrInfo) {
            dataMap.put("csxbzxrData", new ArrayList<>());
        } else {
            List<SxbzxrDTO> csxbzxrDataList = sxbzxrInfo.getItems();
            int sxbzxrIndex = 1;
            for (SxbzxrDTO data : csxbzxrDataList) {
                List<String> csxbzxrElement = new ArrayList<String>();
                csxbzxrElement.add(String.valueOf(sxbzxrIndex));//序号
                csxbzxrElement.add(changeNullData(data.getCaseCreateTime()));//立案日期
                csxbzxrElement.add(changeNullData(data.getCaseCode()));//案号
                csxbzxrElement.add(changeNullData(data.getPname()));//被执行人
                csxbzxrElement.add(changeNullData(data.getExecCourtName()));//执行法院
                csxbzxrElement.add(changeNullData(data.getPerformDegree()));//被执行人履行情况
                sxbzxrDataList.add(csxbzxrElement);
                sxbzxrIndex++;
            }
            dataMap.put("csxbzxrData", sxbzxrDataList);
        }
    }

    /**
     * 根据公司名称取得被执行人信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getBzxrInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> bzxrDataList = new ArrayList<>();
        List<String> bzxrHeader = new ArrayList<String>() {{
            add("序号");
            add("立案日期");
            add("案号");
            add("被执行人");
            add("执行法院");
            add("执行标的");
        }};
        bzxrDataList.add(bzxrHeader);
        PageInfo<BzxrDTO> bzxrInfo = creditService.getBzxrByCompanyId(companyId, page, pageSize);
        if (null == bzxrInfo) {
            dataMap.put("cbzxrData", new ArrayList<>());
        } else {
            List<BzxrDTO> cbzxrDataList = bzxrInfo.getItems();
            int bzxrIndex = 1;
            for (BzxrDTO data : cbzxrDataList) {
                List<String> cfyggElement = new ArrayList<String>();
                cfyggElement.add(String.valueOf(bzxrIndex));//序号
                cfyggElement.add(changeNullData(data.getCaseCreateTime()));//立案日期
                cfyggElement.add(changeNullData(data.getCaseCode()));//案号
                cfyggElement.add(changeNullData(data.getPname()));//被执行人
                cfyggElement.add(changeNullData(data.getExecCourtName()));//执行法院
                cfyggElement.add(String.valueOf(new BigDecimal(data.getExecSubject())));//执行标的
                bzxrDataList.add(cfyggElement);
                bzxrIndex++;
            }
            dataMap.put("cbzxrData", bzxrDataList);
        }
    }

    /**
     * 根据公司名称取得法院公告信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getFyggInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> fyggDataList = new ArrayList<>();
        List<String> fyggHeader = new ArrayList<String>() {{
            add("序号");
            add("公告日期");
            add("公告人");
            add("公告类型");
            add("公告内容");
        }};
        fyggDataList.add(fyggHeader);
        PageInfo<FyggDTO> fyggInfo = creditService.getFyggByCompanyId(companyId, page, pageSize);
        if (null == fyggInfo) {
            dataMap.put("cfyggData", new ArrayList<>());
        } else {
            List<FyggDTO> cfyggDataList = fyggInfo.getItems();
            int fyggIndex = 1;
            for (FyggDTO data : cfyggDataList) {
                List<String> cfyggElement = new ArrayList<String>();
                cfyggElement.add(String.valueOf(fyggIndex));//序号
                cfyggElement.add(changeNullData(data.getNoticeTime()));//公告日期
                cfyggElement.add(changeNullData(data.getNoticePeople()));//公告人
                cfyggElement.add(changeNullData(data.getNoticeType()));//公告类型
                cfyggElement.add(changeNullData(data.getNoticeContent()));//公告内容
                fyggDataList.add(cfyggElement);
                fyggIndex++;
            }
            dataMap.put("cfyggData", fyggDataList);
        }
    }

    /**
     * 根据公司名称取得裁判文书信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     * @throws Exception
     */
    private void getCpwsInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> cpwsDataList = new ArrayList<>();
        List<String> cpwsHeader = new ArrayList<String>() {{
            add("序号");
            add("审判日期");
            add("案号");
            add("案件标题");
            add("案由");
            add("案件类型");
            add("当事人类型");
            add("案件结果");
        }};
        cpwsDataList.add(cpwsHeader);
        PageInfo<CpwsDTO> cpwsInfo = creditService.getCpwsByCompanyId(companyId, page, pageSize);
        if (null == cpwsInfo) {
            dataMap.put("cpwsData", new ArrayList<>());
        } else {
            List<CpwsDTO> ccpwsDataList = cpwsInfo.getItems();
            int cpwsIndex = 1;
            for (CpwsDTO data : ccpwsDataList) {
                List<String> cpwsElement = new ArrayList<String>();
                cpwsElement.add(String.valueOf(cpwsIndex));//序号
                cpwsElement.add(changeNullData(data.getSentenceDate()));//审判日期
                cpwsElement.add(changeNullData(data.getCasecode()));//案号
                cpwsElement.add(changeNullData(data.getTitle()));//案件标题
                cpwsElement.add(changeNullData(data.getActionCause()));//案由
                cpwsElement.add(changeNullData(data.getCaseType()));//案件类型
                cpwsElement.add(changeNullData(data.getLitigantType()));//当事人类型
                cpwsElement.add(changeNullData(data.getCaseoutCome()));//案件结果
                cpwsDataList.add(cpwsElement);
                cpwsIndex++;
            }
            dataMap.put("cpwsData", cpwsDataList);
        }
    }

    /**
     * 根据公司名称获得开庭公告信息
     *
     * @param dataMap
     * @param companyId
     * @param page
     * @param pageSize
     */
    private void getKtggInfo(Map<String, Object> dataMap, String companyId, int page, int pageSize) throws Exception {
        List<List<String>> ktggDataList = new ArrayList<>();
        List<String> ktggHeader = new ArrayList<String>() {{
            add("序号");
            add("开庭日期");
            add("案由");
            add("当事人");
        }};
        ktggDataList.add(ktggHeader);
        PageInfo<KtggDTO> ktggInfo = creditService.getKtggByCompanyId(companyId, page, pageSize);
        if (null == ktggInfo) {
            dataMap.put("cktggData", new ArrayList<>());
        } else {
            List<KtggDTO> cktggDataList = ktggInfo.getItems();
            int ktggIndex = 1;
            for (KtggDTO data : cktggDataList) {
                List<String> ktggElement = new ArrayList<String>();
                ktggElement.add(String.valueOf(ktggIndex));//序号
                ktggElement.add(changeNullData(data.getTrialDate()));//开庭日期
                ktggElement.add(changeNullData(data.getActionCause()));//案由
                ktggElement.add(changeNullData(data.getLitigant()));//当事人
                ktggDataList.add(ktggElement);
                ktggIndex++;
            }
            dataMap.put("cktggData", ktggDataList);
        }
    }
    //-------------------组装 word-----------------------BEGIN-------------

    /**
     * 设置页眉页脚
     *
     * @param document
     * @throws Exception
     */
    private void headFooter(Document document) throws Exception {
        /**
         * 插入表格
         * 三列二行
         */
        Table table = new Table(1);
        table.setBorderWidth(0);
        table.setBorder(0);
        table.setPadding(0);
        table.setSpacing(0);
        table.setWidth(100);

        Phrase headerPara = new Phrase();
        Cell cellHeader = new Cell();
        cellHeader.setBorder(0);
        cellHeader.setBorder(Cell.BOTTOM);

        Paragraph paraheader = new Paragraph();
        paraheader.setFont(new Font(Font.ITALIC, 10, Font.ITALIC, new Color(0, 0, 0)));
        paraheader.add("BBD 监管科技风险全息报告（基础版）");
        paraheader.setAlignment(Paragraph.ALIGN_CENTER);

        cellHeader.add(paraheader);
        table.addCell(cellHeader);
        headerPara.add(table);
        HeaderFooter header = new HeaderFooter(headerPara, false);
        header.setTop(1);
        header.setAlignment(HeaderFooter.ALIGN_RIGHT);
//        document.setHeader(header);

        Table table1 = new Table(1);
        table1.setBorderWidth(0);
        table1.setBorder(0);
        table1.setPadding(0);
        table1.setSpacing(0);
        table1.setWidth(100f);

        Phrase footerPara = new Phrase();

        Cell cellFooter = new Cell();
        cellFooter.setBorder(0);
        Paragraph parafooter = new Paragraph();

        parafooter.setFont(new Font(Font.ITALIC, 10, Font.ITALIC, new Color(0, 0, 0)));
        parafooter.add(new RtfPageNumber());
        parafooter.add(new Phrase("/"));
        parafooter.add(new RtfTotalPageNumber());
        parafooter.add("  ");
        parafooter.add("\nBBD 监管科技风险全息报告（基础版）");
        parafooter.setAlignment(Paragraph.ALIGN_RIGHT);

        cellFooter.add(parafooter);
        table1.addCell(cellFooter);
        footerPara.add(table1);

        footerPara.add(new RtfTotalPageNumber());

        HeaderFooter foo = new HeaderFooter(footerPara, false);
        foo.setAlignment(HeaderFooter.ALIGN_RIGHT);
        document.setFooter(foo);
    }

    /**
     * 首页
     */
    public void index(String companyName, String imgtop, String imgbuttom, Document document) throws Exception {
        Image image = Image.getInstance(createIndexImg(companyName, imgtop));
        image.scaleToFit(PageSize.A4.getHeight(), PageSize.A4.getWidth() - 105);
        image.setAlignment(Image.TEXTWRAP);
        document.add(image);

        Image buttom = Image.getInstance(imgbuttom);
        buttom.scaleToFit(500, PageSize.A4.getWidth() - 105);
        document.add(buttom);
    }

    /**
     * 调查报告
     */
    public void surveyReport(String imgPath, Document document) throws Exception {
        Image image = Image.getInstance(createReportImg(imgPath));
        image.scaleToFit(678, 678);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);
    }

    /**
     * 免责条款
     */
    public void exceptions(Document document, String index) throws Exception {
        Paragraph p = new Paragraph("\n\n免责条款\n\n", new Font(1, 18, Font.NORMAL, new Color(0, 0, 0)));
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        String c1 = "    本报告的使用仅限于客户对目标公司之初步评估，不得将报告内容作为诉讼、仲裁、传媒所引用之证明或依据，不得用于营利或未经允许的其他用途。";
        addParagraph(c1, document);
        String c2 = "    本企业风险预警报告是基于公司认为可靠的数据撰写，本公司力求但不保证该数据的准确性和完整性，客户也不应该认为该数据是准确和完整的。客户不应以本报告取代其独立判断或仅根据本报告做出决策。同时，本公司不保证文中观点或陈述不会发生任何变更，在不同时期，本公司可发出与本报告所载资料、意见及推测不一致的报告。";
        addParagraph(c2, document);
    }

    /**
     * 组装企业风险信息总览
     *
     * @param dataMap
     * @param document
     * @param isP2P
     * @param request
     * @throws Exception
     */
    private boolean totalInfo(Map<String, Object> dataMap, Document document, boolean isP2P, HttpServletRequest request) throws Exception {
        boolean isBlack = false;
        //是不是黑名单企业
        WrodBlackListInfoVO wrodBlackListInfoVO = (WrodBlackListInfoVO) dataMap.get("wrodBlackListInfoVO");

        //取得企业信息
        RaCompanyPO raCompanyPO = (RaCompanyPO) dataMap.get("raCompanyPO");
        //取得企业平台总类
        String radar = raCompanyPO.getIndexRadar();
        JSONObject jsonObject = JSON.parseObject(radar);
        List<String> keyValue = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            keyValue.add(key);
        }

        if (null != wrodBlackListInfoVO && !isP2P) {//不为空，表示是黑名单企业
            addTitle("1. 企业风险总览", document, 1);

            addTable(2, Paragraph.ALIGN_LEFT, document,
                    "企业名称", wrodBlackListInfoVO.getCompany(),
                    "所属行业", wrodBlackListInfoVO.getIndustry(),
                    "平台属性", "黑名单",
                    "加入时间", wrodBlackListInfoVO.getJoinDate(),
                    "原因", wrodBlackListInfoVO.getReasons());

            isBlack = true;

            addTitle("2. 风险点提示", document, 1);

            String scan = raCompanyPO.getRiskScan();
            JSONObject jsonObjectScan = JSON.parseObject(scan);
            String value = jsonObjectScan.get(keyValue.get(0)).toString();
            JSONObject jsonObjectScanValue = JSON.parseObject(value);
            int number = 1;
            for (Map.Entry<String, Object> entry : jsonObjectScanValue.entrySet()) {
                String key = entry.getKey();

                addTitle("2." + (number) + "." + key, document, 2);

                JSONArray valueArray = (JSONArray) entry.getValue();
                if (valueArray.size() != 0) {
                    for (int j = 0; j < valueArray.size(); j++) {
                        addParagraph(valueArray.get(j).toString(), document);
                    }
                } else {
                    addParagraph(this.nullData(), document);
                }
                number++;
            }
        } else {//为空，表示不为黑名单企业

            if (isP2P) {
                addTitle("1. " + raCompanyPO.getCompany() + "平台风险信息", document, 1);
            } else {
                addTitle("1. 企业风险总览", document, 1);
            }

            //开始循坏企业平台总类
            for (int i = 0; i < keyValue.size(); i++) {
                boolean isPro = false;
                if (isP2P) {
                    //判断是否是问题平台
                    WljdFeatureVO wljdFeatureVO = (WljdFeatureVO) dataMap.get(keyValue.get(i) + "wljdFeatureVO");
                    if (null == wljdFeatureVO) {
                        //提示未查询到该企业的平台信息 + keyValue.get(i)[平台名称]
                    } else {
                        isPro = wljdFeatureVO.isProblem();
                    }
                }

                //设置table属性
                Table table = null;
                if (isP2P && isPro) {//网络借贷的问题平台
                    table = new Table(2);
                    ;
                } else {
                    table = new Table(3);
                }
                table.setPadding(15f);

                if (isP2P) {
                    addTitle("1." + (i + 1) + ". " + keyValue.get(i), document, 2);
                    addTitle("1." + (i + 1) + ".1. 平台风险总览", document, 3);
                    Cell cell = createCell("平台名称");
                    table.addCell(cell);
                    Cell cell1 = createCell(keyValue.get(i));
                    table.addCell(cell1);
                } else {
                    Cell cell = createCell("企业名称");
                    table.addCell(cell);
                    Cell cell1 = createCell(raCompanyPO.getCompany());
                    table.addCell(cell1);
                }

                if (isP2P && isPro) {
                    WljdFeatureVO wljdFeatureVO = (WljdFeatureVO) dataMap.get(keyValue.get(i) + "wljdFeatureVO");

                    Cell cell3 = createCell("所属行业");
                    table.addCell(cell3);
                    Cell cell4 = createCell(raCompanyPO.getIndustry());
                    table.addCell(cell4);
                    Cell cell5 = createCell("平台属性");
                    table.addCell(cell5);
                    Cell cell6 = createCell("问题平台");
                    table.addCell(cell6);
                    Cell cell7 = createCell("问题发生时间");
                    table.addCell(cell7);
                    String happendTime = wljdFeatureVO.getProblemTime();
                    if (null == happendTime) {
                        happendTime = "--";
                    }
                    Cell cell8 = createCell(happendTime);
                    table.addCell(cell8);
                    Cell cell9 = createCell("问题原因");
                    table.addCell(cell9);
                    String reason = wljdFeatureVO.getProblemReason();
                    if (null == reason) {
                        reason = "--";
                    }
                    Cell cell10 = createCell(reason);
                    table.addCell(cell10);

                    if (reason.contains("歇业") || reason.contains("停业") || reason.contains("异常")) {
                        Cell cell11 = createCell("风险指数");
                        table.addCell(cell11);

                        String valueRadar = jsonObject.get(keyValue.get(i)).toString();
                        JSONObject jsonObjectRadarValue = JSON.parseObject(valueRadar);
                        for (Map.Entry<String, Object> entry : jsonObjectRadarValue.entrySet()) {
                            String key = entry.getKey();
                            if (key.equals("total_score")) {
                                BigDecimal bigDecimal = (BigDecimal) entry.getValue();
                                Cell cell = createCell(String.valueOf(bigDecimal));
                                table.addCell(cell);
                            }
                        }
                    }
                    document.add(table);

                    addTitle("1." + (i + 1) + ".2 平台风险点提示", document, 3);

                    String scan = raCompanyPO.getRiskScan();
                    JSONObject jsonObjectScan = JSON.parseObject(scan);
                    String value = jsonObjectScan.get(keyValue.get(i)).toString();
                    JSONObject jsonObjectScanValue = JSON.parseObject(value);
                    int number = 1;
                    for (Map.Entry<String, Object> entry : jsonObjectScanValue.entrySet()) {
                        String key = entry.getKey();
                        addTitle("1." + (i + 1) + ".2." + number + ". " + key, document, 4);

                        JSONArray valueArray = (JSONArray) entry.getValue();
                        if (valueArray.size() != 0) {
                            for (int j = 0; j < valueArray.size(); j++) {
                                addParagraph(valueArray.get(j).toString(), document);
                            }
                        } else {
                            addParagraph(this.nullData(), document);
                        }
                        number++;
                    }

                } else {
                    Image image2 = Image.getInstance(captureImgService.captureImg(request, "pdfRadar?companyId=" + URLEncoder.encode(raCompanyPO.getId(), "utf8") + "&keyValue=" + URLEncoder.encode(keyValue.get(i), "utf8"), "600px*500px"));
                    Cell cell2 = new Cell();
                    cell2.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER);
                    Image image = Image.getInstance(image2);
                    image.scaleToFit(126, 100);
                    cell2.add(image);
                    cell2.setRowspan(4);
                    table.addCell(cell2);

                    Cell cell3 = createCell("所属行业");
                    table.addCell(cell3);
                    Cell cell4 = createCell(raCompanyPO.getIndustry());
                    table.addCell(cell4);
                    Cell cell5 = createCell("风险等级");
                    table.addCell(cell5);
                    Cell cell6 = createCell(raCompanyPO.getRiskLevel());
                    table.addCell(cell6);
                    Cell cell7 = createCell("风险指数");
                    table.addCell(cell7);

                    String valueRadar = jsonObject.get(keyValue.get(i)).toString();
                    JSONObject jsonObjectRadarValue = JSON.parseObject(valueRadar);
                    for (Map.Entry<String, Object> entry : jsonObjectRadarValue.entrySet()) {
                        String key = entry.getKey();
                        if (key.equals("total_score")) {
                            BigDecimal bigDecimal = (BigDecimal) entry.getValue();
                            Cell cell8 = createCell(String.valueOf(bigDecimal));
                            table.addCell(cell8);
                            document.add(table);
                        }
                    }

                    if (isP2P) {
                        addTitle("1." + (i + 1) + ".2 平台风险点提示", document, 3);
                    } else {
                        addTitle("2. 风险点提示", document, 1);
                    }
                    String scan = raCompanyPO.getRiskScan();
                    JSONObject jsonObjectScan = JSON.parseObject(scan);
                    String value = jsonObjectScan.get(keyValue.get(i)).toString();
                    JSONObject jsonObjectScanValue = JSON.parseObject(value);
                    int number = 1;
                    for (Map.Entry<String, Object> entry : jsonObjectScanValue.entrySet()) {
                        String key = entry.getKey();
                        if (isP2P) {
                            addTitle("1." + (i + 1) + ".2." + number + ". " + key, document, 4);
                        } else {
                            addTitle("2." + (number) + "." + key, document, 2);
                        }

                        JSONArray valueArray = (JSONArray) entry.getValue();
                        if (valueArray.size() != 0) {
                            for (int j = 0; j < valueArray.size(); j++) {
                                addParagraph(valueArray.get(j).toString(), document);
                            }
                        } else {
                            addParagraph(this.nullData(), document);
                        }
                        number++;
                    }
                    //平台特征信息
                    if (isP2P) {
                        addTitle("1." + (i + 1) + ".3 平台特征信息", document, 3);

                        List<List<String>> p2pInfo = (List<List<String>>) dataMap.get(keyValue.get(i) + "p2pInfo");
                        List<Object> data = new ArrayList<>();
                        List<List<String>> p2pRzjlInfo = (List<List<String>>) dataMap.get(keyValue.get(i) + "p2pRzjlInfo");
                        List<List<String>> p2pJgxhInfo = (List<List<String>>) dataMap.get(keyValue.get(i) + "p2pJgxhInfo");
                        List<List<String>> p2pDbjgInfo = (List<List<String>>) dataMap.get(keyValue.get(i) + "p2pDbjgInfo");
                        data.add(p2pRzjlInfo);
                        data.add(p2pJgxhInfo);
                        data.add(p2pDbjgInfo);
                        addTableForTeZhengInfo(Paragraph.ALIGN_LEFT, document, p2pInfo, data);
                    } else {
                        if (raCompanyPO.getIndustry().equals(Constants.COMPANY_INDUSTRY_TRADING_PLACE)) {//交易场所

                            //企业特征信息（交易场所）
                            addTitle("3. 企业特征信息（交易场所）", document, 1);
                            //交易所信息
                            addTitle("3.1 交易所信息", document, 2);
                            List<List<String>> data = (List<List<String>>) dataMap.get("exchangeBasicInfo");
                            if (CollectionUtils.isEmpty(data)) {
                                addParagraph(this.nullData(), document);
                            } else {
                                addTableForList(Paragraph.ALIGN_LEFT, document, data);
                            }

                            //交易品种
                            addTitle("3.2 交易品种", document, 2);
                            //交易品总名称
                            List<String> typeName = (List<String>) dataMap.get("typeName");
                            if (CollectionUtils.isEmpty(typeName)) {
                                addParagraph(this.nullData(), document);
                            } else {
                                for (int m = 0; m < typeName.size(); m++) {
                                    if (typeName.get(m).toString().equals("--")) {
                                        addParagraph(this.nullData(), document);
                                    } else {
                                        addParagraph(typeName.get(m).toString(), document);
                                        List<List<String>> detailData = (List<List<String>>) dataMap.get(typeName.get(m).toString());
                                        if (CollectionUtils.isEmpty(detailData)) {
                                            addParagraph(this.nullData(), document);
                                        } else {
                                            addTableForList(Paragraph.ALIGN_LEFT, document, detailData);
                                        }
                                    }
                                }
                            }
                        } else if (raCompanyPO.getIndustry().equals(Constants.COMPANY_INDUSTRY_PRIVATE_EQUIT)) {//私募基金
                            //取得私募基金信息
                            addTitle("3. 企业特征信息（私募基金)", document, 1);
                            addTitle("3.1 高管从业资格信息", document, 2);
                            List<List<String>> data = (List<List<String>>) dataMap.get("executiveInfo");
                            if (CollectionUtils.isEmpty(data)) {
                                addParagraph(this.nullData(), document);
                            } else {
                                addTableForList(Paragraph.ALIGN_LEFT, document, data);
                            }
                            addTitle("3.2 基金管理信息", document, 2);
                            List<List<String>> data2 = (List<List<String>>) dataMap.get("manageInfo");
                            if (CollectionUtils.isEmpty(data2)) {
                                addParagraph(this.nullData(), document);
                            } else {
                                addTableForList(Paragraph.ALIGN_LEFT, document, data2);
                            }
                        } else {
                            //新兴金融不做任何处理
                        }
                    }
                }
            }
        }
        return isBlack;
    }

    /**
     * 组装基本信息
     *
     * @param isBlack
     * @param dataMap
     * @param document
     * @param isP2P
     * @throws Exception
     */
    private void baseInfo(boolean isBlack, Map<String, Object> dataMap, Document document, boolean isP2P) throws Exception {
        int numb = 0;
        if (isP2P) {
            numb = 2;
        } else {
            RaCompanyPO raCompanyPO = (RaCompanyPO) dataMap.get("raCompanyPO");
            String industry = raCompanyPO.getIndustry();
            if (isBlack) {
                numb = 3;
            } else {
                if (industry.equals(Constants.COMPANY_INDUSTRY_EMERGING_FINANCE) || industry.equals(Constants.COMPANY_INDUSTRY_PETTY_LOAN) || industry.equals(Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE)) {
                    numb = 3;
                } else {
                    numb = 4;
                }
            }
        }
        addTitle(numb + ". 基本信息", document, 1);
        addTitle(numb + ".1. 工商信息", document, 2);

        List<List<String>> jbxxDataList = (List<List<String>>) dataMap.get("jbxxData");
        if (CollectionUtils.isEmpty(jbxxDataList)) {
            addParagraph(nullData(), document);
        } else {
            int[] widths = new int[]{1, 2};
            addTableForList(Paragraph.ALIGN_LEFT, document, jbxxDataList, widths);
        }
        addTitle(numb + ".2. 股东信息", document, 2);

        List<List<String>> gdxxDataList = (List<List<String>>) dataMap.get("gdxxData");
        if (CollectionUtils.isEmpty(gdxxDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, gdxxDataList);
        }

        addTitle(numb + ".3. 董事/监事/高管", document, 2);

        List<List<String>> baxxDataList = (List<List<String>>) dataMap.get("baxxData");
        if (CollectionUtils.isEmpty(baxxDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, baxxDataList);
        }

        addTitle(numb + ".4. 分支机构", document, 2);
        List<List<String>> fzjgDataList = (List<List<String>>) dataMap.get("fzjg");
        if (CollectionUtils.isEmpty(fzjgDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, fzjgDataList);
        }

        addTitle(numb + ".5. 海外投资机构", document, 2);
        List<List<String>> overseasDataList = (List<List<String>>) dataMap.get("overseasData");
        if (CollectionUtils.isEmpty(fzjgDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, overseasDataList);
        }
    }

    /**
     * 组装关联方信息
     *
     * @param isBlack
     * @param dataMap
     * @param document
     * @param isP2P
     */
    private void relationInfo(boolean isBlack, Map<String, Object> dataMap, Document document, boolean isP2P, HttpServletRequest req, String province) throws Exception {
        RaCompanyPO raCompanyPO = (RaCompanyPO) dataMap.get("raCompanyPO");
        int numb = 0;
        if (isP2P) {
            numb = 3;
        } else {
            if (isBlack) {
                numb = 4;
            } else {
                String industry = raCompanyPO.getIndustry();
                if (industry.equals(Constants.COMPANY_INDUSTRY_EMERGING_FINANCE) || industry.equals(Constants.COMPANY_INDUSTRY_PETTY_LOAN) || industry.equals(Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE)) {
                    numb = 4;
                } else {
                    numb = 5;
                }
            }
        }
        addTitle(numb + ". 关联方信息", document, 1);

        String ImageURL = captureImgService.captureImg(req, "pdfMaps?companyId=" + URLEncoder.encode(raCompanyPO.getId(), "utf8") + "&degree=2&province=" + URLEncoder.encode(province, "utf8"), "780px*850px");
        addImg(document, 425, 390, ImageURL);

        List<List<String>> keyNatureData = (List<List<String>>) dataMap.get("keyNatureData");
        List<List<String>> keyNoNatureData = (List<List<String>>) dataMap.get("keyNonNatureData");
        List<List<String>> industrySpanTop1dData = (List<List<String>>) dataMap.get("industrySpanTop1dData");
        List<List<String>> gatherPlathData = (List<List<String>>) dataMap.get("gatherPlathData");

        List<Object> listData = new ArrayList<>();
        listData.add(keyNatureData);
        listData.add(keyNoNatureData);
        listData.add(industrySpanTop1dData);
        listData.add(gatherPlathData);
        if (CollectionUtils.isEmpty(keyNatureData)) {
            addParagraph(nullData(), document);
        } else {
            addTableGuanLianFang(Paragraph.ALIGN_LEFT, document, listData);
        }
    }

    /**
     * 经营信息
     *
     * @param isBlack
     * @param dataMap
     * @param document
     * @param isP2P
     * @throws Exception
     */
    private void manageInfo(boolean isBlack, Map<String, Object> dataMap, Document document, boolean isP2P) throws Exception {
        int numb = 0;
        if (isP2P) {
            numb = 4;
        } else {
            if (isBlack) {
                numb = 5;
            } else {
                RaCompanyPO raCompanyPO = (RaCompanyPO) dataMap.get("raCompanyPO");
                String industry = raCompanyPO.getIndustry();
                if (industry.equals(Constants.COMPANY_INDUSTRY_EMERGING_FINANCE) || industry.equals(Constants.COMPANY_INDUSTRY_PETTY_LOAN) || industry.equals(Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE)) {
                    numb = 5;
                } else {
                    numb = 6;
                }
            }
        }

        addTitle(numb + ". 经营信息", document, 1);
        addTitle(numb + ".1. 工商变更", document, 2);
        List<List<String>> bgxxDataList = (List<List<String>>) dataMap.get("bgxxData");
        if (CollectionUtils.isEmpty(bgxxDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, bgxxDataList);
        }
        addTitle(numb + ".2. 域名备案", document, 2);
        List<List<String>> ymbaDataList = (List<List<String>>) dataMap.get("ymbaData");
        if (CollectionUtils.isEmpty(ymbaDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, ymbaDataList);
        }
        addTitle(numb + ".3. 招聘信息", document, 2);
        List<List<String>> recruitDataList = (List<List<String>>) dataMap.get("recruitData");
        if (CollectionUtils.isEmpty(recruitDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, recruitDataList);
        }
        addTitle(numb + ".4. 年报", document, 2);

        //tiitle
        List<List<String>> gzsmDataTitle = (List<List<String>>) dataMap.get("gzsmDataTitle");//年报信息更正说明
        List<List<String>> gqdbxxDataTitle = (List<List<String>>) dataMap.get("gqdbxxDataTitle");//股权变更信息
        List<List<String>> dbxxDataTitle = (List<List<String>>) dataMap.get("dbxxDataTitle");//担保信息
        List<List<String>> zxxxDataTitle = (List<List<String>>) dataMap.get("zxxxDataTitle");//企业资产状况信息
        List<List<String>> cxzzDataTitle = (List<List<String>>) dataMap.get("cxzzDataTitle");//股东及出资信息
        //交易品总名称
        List<String> years = (List<String>) dataMap.get("year");

        if (CollectionUtils.isEmpty(years)) {
            addParagraph(nullData(), document);
        } else {
            for (int m = 0; m < years.size(); m++) {
                if (years.get(m).toString().equals("--")) {
                    addParagraph(nullData(), document);
                } else {
                    addParagraph(years.get(m).toString(), document);

                    //股东及出资信息
                    String keyA = years.get(m).toString() + "czxx";
                    List<List<String>> cxzzData = (List<List<String>>) dataMap.get(keyA);
                    List<Object> listCxzz = new ArrayList<>();
                    listCxzz.add(cxzzDataTitle);
                    listCxzz.add(cxzzData);
                    if (CollectionUtils.isEmpty(cxzzData)) {
                        addParagraph(nullData(), document);
                    } else {
                        addTableForYears(Paragraph.ALIGN_LEFT, document, listCxzz);
                    }
                    //企业资产状况信息
                    String keyB = years.get(m).toString() + "zcxx";
                    List<List<String>> zcxxData = (List<List<String>>) dataMap.get(keyB);
                    List<Object> listZxzz = new ArrayList<>();
                    listZxzz.add(zxxxDataTitle);
                    listZxzz.add(zcxxData);

                    if (CollectionUtils.isEmpty(zcxxData)) {
                        addParagraph(nullData(), document);
                    } else {
                        addTableForYears(Paragraph.ALIGN_LEFT, document, listZxzz);
                    }
                    //担保信息
                    String keyC = years.get(m).toString() + "dbxx";
                    List<List<String>> dbxxData = (List<List<String>>) dataMap.get(keyC);
                    List<Object> listDbxx = new ArrayList<>();
                    listDbxx.add(dbxxDataTitle);
                    listDbxx.add(dbxxData);
                    if (CollectionUtils.isEmpty(dbxxData)) {
                        addParagraph(nullData(), document);
                    } else {
                        addTableForYears(Paragraph.ALIGN_LEFT, document, listDbxx);
                    }
                    //股权变更信息
                    String keyD = years.get(m).toString() + "gqbgxx";
                    List<List<String>> gqbgxxData = (List<List<String>>) dataMap.get(keyD);
                    List<Object> listGqbgxx = new ArrayList<>();
                    listGqbgxx.add(gqdbxxDataTitle);
                    listGqbgxx.add(gqbgxxData);
                    if (CollectionUtils.isEmpty(gqbgxxData)) {
                        addParagraph(nullData(), document);
                    } else {
                        addTableForYears(Paragraph.ALIGN_LEFT, document, listGqbgxx);
                    }
                    //年报信息更正说明
                    String keyE = years.get(m).toString() + "gzsm";
                    List<List<String>> gzsmData = (List<List<String>>) dataMap.get(keyE);
                    List<Object> listGzsm = new ArrayList<>();
                    listGzsm.add(gzsmDataTitle);
                    listGzsm.add(gzsmData);
                    if (CollectionUtils.isEmpty(gzsmData)) {
                        addParagraph(nullData(), document);
                    } else {
                        addTableForYears(Paragraph.ALIGN_LEFT, document, listGzsm);
                    }
                }
            }
        }
    }

    /**
     * 信用信息
     *
     * @param isBlack
     * @param dataMap
     * @param isP2P
     */
    private void xinYongInfo(boolean isBlack, Map<String, Object> dataMap, Document document, boolean isP2P) throws Exception {
        int numb = 0;
        if (isP2P) {
            numb = 5;
        } else {
            if (isBlack) {
                numb = 6;
            } else {
                RaCompanyPO raCompanyPO = (RaCompanyPO) dataMap.get("raCompanyPO");
                String industry = raCompanyPO.getIndustry();
                if (industry.equals(Constants.COMPANY_INDUSTRY_EMERGING_FINANCE) || industry.equals(Constants.COMPANY_INDUSTRY_PETTY_LOAN) || industry.equals(Constants.COMPANY_INDUSTRY_FIANACING_GUARANTEE)) {
                    numb = 6;
                } else {
                    numb = 7;
                }
            }
        }
        addTitle(numb + ". 信用信息", document, 1);
        addTitle(numb + ".1. 行政处罚", document, 2);
        List<List<String>> xzcfDataList = (List<List<String>>) dataMap.get("xzcfData");
        if (CollectionUtils.isEmpty(xzcfDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, xzcfDataList);
        }
        addTitle(numb + ".2. 开庭公告", document, 2);
        List<List<String>> cktggDataList = (List<List<String>>) dataMap.get("cktggData");
        if (CollectionUtils.isEmpty(cktggDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cktggDataList);
        }
        addTitle(numb + ".3. 裁判文书", document, 2);
        List<List<String>> cpwsDataList = (List<List<String>>) dataMap.get("cpwsData");
        if (CollectionUtils.isEmpty(cpwsDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cpwsDataList);
        }
        addTitle(numb + ".4. 法院公告", document, 2);
        List<List<String>> cfyggDataDataList = (List<List<String>>) dataMap.get("cfyggData");
        if (CollectionUtils.isEmpty(cfyggDataDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cfyggDataDataList);
        }
        addTitle(numb + ".5. 被执行人", document, 2);
        List<List<String>> cbzxrDataDataList = (List<List<String>>) dataMap.get("cbzxrData");
        if (CollectionUtils.isEmpty(cbzxrDataDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cbzxrDataDataList);
        }
        addTitle(numb + ".6. 失信被执行人", document, 2);
        List<List<String>> csxbzxrDataList = (List<List<String>>) dataMap.get("csxbzxrData");
        if (CollectionUtils.isEmpty(csxbzxrDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, csxbzxrDataList);
        }
        addTitle(numb + ".7. 司法拍卖", document, 2);
        List<List<String>> csfpmDataList = (List<List<String>>) dataMap.get("csfpmData");
        if (CollectionUtils.isEmpty(csfpmDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, csfpmDataList);
        }
        addTitle(numb + ".8. 经营异常", document, 2);
        List<List<String>> cjyycDataList = (List<List<String>>) dataMap.get("cjyycData");
        if (CollectionUtils.isEmpty(cjyycDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cjyycDataList);
        }
        addTitle(numb + ".9. 欠税情况", document, 2);
        List<List<String>> cqsmdDataList = (List<List<String>>) dataMap.get("cqsmdData");
        if (CollectionUtils.isEmpty(cqsmdDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cqsmdDataList);
        }
        addTitle(numb + ".10. 清算情况", document, 2);
        List<List<String>> cqsxxDataList = (List<List<String>>) dataMap.get("cqsxxData");
        if (CollectionUtils.isEmpty(cqsxxDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cqsxxDataList);
        }
        addTitle(numb + ".11. 股权出质", document, 2);
        List<List<String>> csharesPawnDataList = (List<List<String>>) dataMap.get("csharesPawnData");
        if (CollectionUtils.isEmpty(csharesPawnDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, csharesPawnDataList);
        }
        addTitle(numb + ".12. 动产抵押", document, 2);
        List<List<String>> cmortgageDataList = (List<List<String>>) dataMap.get("cmortgageData");
        if (CollectionUtils.isEmpty(cmortgageDataList)) {
            addParagraph(nullData(), document);
        } else {
            addTableForList(Paragraph.ALIGN_LEFT, document, cmortgageDataList);
        }
    }

    private void backCover(String backCoverImage, Document document) throws DocumentException, IOException {
        Image buttom = Image.getInstance(backCoverImage);
        buttom.scaleToFit(678, 678);
        buttom.setAlignment(Element.ALIGN_CENTER);
        document.add(buttom);
    }

    /**
     * 没有内容时，统一显示内容
     *
     * @return
     */
    private String nullData() {
        return "截止" + DateUtils.format(new Date(), "yyyy年MM月dd日") + "，根据国内相关网站检索以及浩格云信数据库分析，未查询到目标公司相关信息。不排除因信息公开源尚未公开、公开形式存在差异等情况导致的信息与客观事实不完全一致的情形。";
    }

    /**
     * 创建Cell
     */
    private Cell createCell(String value) {
        Cell cell = new Cell();
        cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
        if (null != value) {
            cell.add(paragraph(value, 0, 0, 15, Font.NORMAL, Paragraph.ALIGN_LEFT, new Color(0, 0, 0)));
        }
        return cell;
    }

    private void addParagraph(String text, Document document) throws Exception {
        Paragraph p = paragraph(text, 35f, 35f, 30f, Font.NORMAL, Paragraph.ALIGN_LEFT, new Color(0, 0, 0));
        document.add(p);
    }

    private Paragraph paragraph(String text, float iRight, float iLeft, float lead, int fontStyle, int alignment, Color color) {
        Paragraph p = new Paragraph();
        p.setIndentationRight(iRight);
        p.setIndentationLeft(iLeft);
        p.setLeading(lead, lead);
        p.setAlignment(alignment);

        p.setFont(new Font(1, 12, fontStyle, color));
        p.add("    " + text);
        return p;
    }

    private Paragraph paragraphForCell(String text, float iRight, float iLeft, float lead, int fontStyle, int alignment, Color color) {
        Paragraph p = new Paragraph();
        p.setIndentationRight(iRight);
        p.setIndentationLeft(iLeft);
        p.setLeading(lead, lead);
        p.setAlignment(alignment);

        p.setFont(new Font(1, 12, fontStyle, color));
        p.add(text);
        return p;
    }

    private byte[] createIndexImg(String companyName, String imagepPath) throws Exception {
        BufferedImage image = ImageIO.read(new File(imagepPath));
        int width = image.getWidth(null) == -1 ? 200 : image.getWidth(null);
        int height = image.getHeight(null) == -1 ? 200 : image.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.setFont(new java.awt.Font("仿宋", java.awt.Font.PLAIN, 22)); //字体、字型、字号
        g.setColor(Color.black);
        g.drawString(companyName, 150, height / 2); //画文字
        g.drawString("——大数据监控（金融）风险全息报告（基础版）", 170, height / 2 + 50); //画文字
        g.dispose();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(bimage, "gif", out);
        return out.toByteArray();
    }

    private byte[] createReportImg(String imagepPath) throws Exception {
        BufferedImage image = ImageIO.read(new File(imagepPath));
        int width = image.getWidth(null) == -1 ? 200 : image.getWidth(null);
        int height = image.getHeight(null) == -1 ? 200 : image.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.setFont(new java.awt.Font("仿宋", java.awt.Font.PLAIN, 22)); //字体、字型、字号
        g.setColor(Color.black);
        g.drawString(DateUtils.format(new Date(), "yyyy年MM月dd日"), width / 2 - 70, height - 50); //画文字
        g.dispose();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(bimage, "gif", out);
        return out.toByteArray();
    }

    /**
     * 根据标题等级设置标题字体信息
     *
     * @param title
     * @param document
     * @param level
     * @throws Exception
     */
    private void addTitle(String title, Document document, int level) throws Exception {
        Paragraph p = new Paragraph();
        if (level == 1) {
            p.setIndentationRight(35f);
            p.setIndentationLeft(35f);
            p.setLeading(45f, 45f);
            p.setFont(new Font(1, 19, Font.BOLD, new Color(0, 0, 0)));
        } else if (level == 2) {
            p.setIndentationRight(35f);
            p.setIndentationLeft(35f);
            p.setLeading(40f, 40f);
            p.setFont(new Font(1, 18, Font.BOLD, new Color(0, 0, 0)));
        } else if (level == 3) {
            p.setIndentationRight(35f);
            p.setIndentationLeft(35f);
            p.setLeading(35f, 35f);
            p.setFont(new Font(1, 17, Font.BOLD, new Color(0, 0, 0)));
        } else {
            p.setIndentationRight(35f);
            p.setIndentationLeft(35f);
            p.setLeading(30f, 30f);
            p.setFont(new Font(1, 16, Font.BOLD, new Color(0, 0, 0)));
        }
        p.add(title);
        document.add(p);
    }

    /**
     * 生成特征信息表格
     *
     * @param paragraphAlign
     * @param document
     * @param listValue
     * @param listValuebjectColspan
     * @throws DocumentException
     */
    private void addTableForTeZhengInfo(int paragraphAlign, Document document, List<List<String>> listValue, List<Object> listValuebjectColspan) throws DocumentException {
        Table table = new Table(6);
        table.setPadding(15f);
        for (int i = 0; i < listValue.size(); i++) {
            List<String> element = listValue.get(i);
            if (!CollectionUtils.isEmpty(element)) {
                for (int j = 0; j < element.size(); j++) {
                    Cell cell = new Cell();
                    cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                    cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                    table.addCell(cell);
                }
            }
        }
        for (int m = 0; m < listValuebjectColspan.size(); m++) {
            List<List<String>> data = (List<List<String>>) listValuebjectColspan.get(m);
            for (int i = 0; i < data.size(); i++) {
                List<String> element = data.get(i);
                if (!CollectionUtils.isEmpty(element)) {
                    for (int j = 0; j < element.size(); j++) {
                        Cell cell = new Cell();
                        cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                        cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                        if (j == 1) {
                            cell.setColspan(5);
                        }
                        table.addCell(cell);
                    }
                }
            }
        }
        document.add(table);
    }

    /**
     * 关联方表格
     *
     * @param paragraphAlign
     * @param document
     * @param listValuebjectColspan
     * @throws DocumentException
     */
    private void addTableGuanLianFang(int paragraphAlign, Document document, List<Object> listValuebjectColspan) throws DocumentException {
        Table table = new Table(5);
        table.setPadding(15f);

        for (int m = 0; m < listValuebjectColspan.size(); m++) {
            List<List<String>> data = (List<List<String>>) listValuebjectColspan.get(m);
            if (m == 0) {
                for (int i = 0; i < data.size(); i++) {
                    List<String> element = data.get(i);
                    if (i == 0) {
                        if (!CollectionUtils.isEmpty(element)) {
                            for (int j = 0; j < element.size(); j++) {
                                Cell cell = new Cell();
                                cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                                cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                                cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                                table.addCell(cell);
                            }
                        }
                    } else if (i == 1) {
                        if (!CollectionUtils.isEmpty(element)) {
                            for (int j = 0; j < element.size(); j++) {
                                Cell cell = new Cell();
                                cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                                cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                                if (j == 0) {
                                    cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                                    cell.setRowspan(3);
                                } else {
                                    cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                                }
                                table.addCell(cell);
                            }
                        }
                    } else {
                        if (!CollectionUtils.isEmpty(element)) {
                            for (int j = 0; j < element.size(); j++) {
                                if (null != element.get(j) && !element.get(j).equals("")) {
                                    Cell cell = new Cell();
                                    cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                                    cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                                    cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                                    table.addCell(cell);
                                }
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i < data.size(); i++) {
                    List<String> element = data.get(i);
                    if (i == 0) {
                        if (!CollectionUtils.isEmpty(element)) {
                            for (int j = 0; j < element.size(); j++) {
                                Cell cell = new Cell();
                                cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                                cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                                if (j == 0) {
                                    cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                                    cell.setRowspan(3);
                                } else {
                                    cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                                }
                                table.addCell(cell);
                            }
                        }
                    } else {
                        if (!CollectionUtils.isEmpty(element)) {
                            for (int j = 0; j < element.size(); j++) {
                                if (null != element.get(j) && !element.get(j).equals("")) {
                                    Cell cell = new Cell();
                                    cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                                    cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                                    cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                                    table.addCell(cell);
                                }
                            }
                        }
                    }
                }
            }
        }
        document.add(table);
    }

    /**
     * 企业年报表格
     *
     * @param paragraphAlign
     * @param document
     * @param listValuebjectColspan
     * @throws DocumentException
     */
    private void addTableForYears(int paragraphAlign, Document document, List<Object> listValuebjectColspan) throws DocumentException {
        int tableSize = ((List<List<String>>) listValuebjectColspan.get(1)).get(0).size();
        Table table = new Table(tableSize);
        table.setPadding(15f);
        for (int m = 0; m < listValuebjectColspan.size(); m++) {
            List<List<String>> data = (List<List<String>>) listValuebjectColspan.get(m);
            if (m == 0) {
                String title = data.get(0).get(0);
                Cell cell = new Cell();
                cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                cell.setColspan(tableSize);
                cell.add(paragraphForCell(title, 0, 0, 15, Font.NORMAL, Paragraph.ALIGN_CENTER, new Color(0, 0, 0)));
                table.addCell(cell);
            } else {
                for (int i = 0; i < data.size(); i++) {
                    List<String> element = data.get(i);
                    if (!CollectionUtils.isEmpty(element)) {
                        for (int j = 0; j < element.size(); j++) {
                            Cell cell = new Cell();
                            cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                            cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                            cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                            table.addCell(cell);
                        }
                    }
                }
            }
        }
        document.add(table);
    }

    /**
     * 生成没有单元格合并的表格
     *
     * @param paragraphAlign
     * @param document
     * @param listValue
     * @throws Exception
     */
    private void addTableForList(int paragraphAlign, Document document, List<List<String>> listValue) throws Exception {
        if (!CollectionUtils.isEmpty(listValue)) {
            Table table = new Table(listValue.get(0).size());
            table.setPadding(15f);
            table.setTop(-1);

            for (int i = 0; i < listValue.size(); i++) {
                List<String> element = listValue.get(i);
                if (!CollectionUtils.isEmpty(element)) {
                    for (int j = 0; j < element.size(); j++) {
                        Cell cell = new Cell();
                        cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                        cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                        table.addCell(cell);
                    }
                }
            }
            document.add(table);
        }
    }

    /**
     * 生成没有合并单元格的表格，可指定每个单元格大小
     *
     * @param paragraphAlign
     * @param document
     * @param listValue
     * @param widths
     * @throws Exception
     */
    private void addTableForList(int paragraphAlign, Document document, List<List<String>> listValue, int[] widths) throws Exception {
        if (!CollectionUtils.isEmpty(listValue)) {
            Table table = new Table(listValue.get(0).size());
            table.setPadding(15f);
            table.setWidths(widths);

            for (int i = 0; i < listValue.size(); i++) {
                List<String> element = listValue.get(i);
                if (!CollectionUtils.isEmpty(element)) {
                    for (int j = 0; j < element.size(); j++) {
                        Cell cell = new Cell();
                        cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
                        cell.add(paragraphForCell(element.get(j), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
                        table.addCell(cell);
                    }
                }
            }
            document.add(table);
        }
    }

    private void addTable(int columns, int paragraphAlign, Document document, Object... cellContent) throws Exception {

        Table table = new Table(columns);

        table.setPadding(15f);

        for (Object con : cellContent) {
            if (con instanceof Cell) {
                table.addCell((Cell) con);
                continue;
            }
            Cell cell = new Cell();
            cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
            if (con instanceof Paragraph) {
                cell.add((Paragraph) con);
            } else {
                con = con == null ? none : con;
                cell.add(paragraphForCell(con.toString(), 0, 0, 15, Font.NORMAL, paragraphAlign, new Color(0, 0, 0)));
            }
            table.addCell(cell);
        }
        document.add(table);
    }

    private void addImg(Document document, float height, float width, String imgPath) throws Exception {
        if (new File(imgPath).exists()) {
            Image img = Image.getInstance(imgPath);
            img.scaleToFit(height, width);
            img.setAlignment(ImgCCITT.ALIGN_CENTER);
            document.add(img);
        }
    }

    /**
     * 空白值转换为“--”
     *
     * @param value
     * @return
     */
    private String changeNullData(String value) {
        String changeData = null;
        if (null == value || value.equals("")) {
            changeData = "--";
        } else {
            changeData = value;
        }
        return changeData;
    }
}
