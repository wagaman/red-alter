package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bbd.dafei.biz.service.sys.SystemThreadPool;
import com.bbd.dafei.biz.shared.BaseDataService;
import com.bbd.dafei.biz.shared.PersonDetailInfoService;
import com.bbd.dafei.biz.shared.RaBlackListService;
import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.commonenum.RiskLevelEnum;
import com.bbd.dafei.common.modal.dto.BaseDataDTO;
import com.bbd.dafei.common.modal.util.BaseDataUtil;
import com.bbd.dafei.common.modal.vo.ApiFinancialVO;
import com.bbd.dafei.common.modal.vo.PersonDetailInfoVO;
import com.bbd.dafei.common.modal.vo.PersonRelationInfoVO;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.Constants;
import com.components.service.ApiExecuteEngineService;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017-07-31.
 */
@Service
public class PersonDetailInfoServiceImpl implements PersonDetailInfoService {

    @Autowired
    private ApiExecuteEngineService defaultApiExecEngine;

    @Autowired
    private BaseDataService baseDataService;

    @Autowired
    private RaCompanyService raCompanyService;

    @Autowired
    private RaBlackListService raBlackListService;

    @Value("${api.components.getSubgraph.apiId}")
    private String getSubgraphId;

    @Value("${api.components.qyxxBatch.apiId}")
    private String qyxxBatchId;

    @Value("${api.components.financial.apiId}")
    private String financialApiId;

    /**
     * 对关联企业进行分类
     *
     * @param personDetailInfoVO
     * @return
     */
    private PersonDetailInfoVO filterPersonDetialInfo(PersonDetailInfoVO personDetailInfoVO) {
        if (personDetailInfoVO == null || CollectionUtils.isEmpty(personDetailInfoVO.getPersonRelationInfoVOS())) {
            return personDetailInfoVO;
        }
        //黑名单
        List<PersonRelationInfoVO> blackPersonRelationInfos = new ArrayList<>();
        //高风险
        List<PersonRelationInfoVO> highRiskPersonRelationInfos = new ArrayList<>();
        //新金融
        List<PersonRelationInfoVO> financePersonRelationInfos = new ArrayList<>();
        //注吊销
        List<PersonRelationInfoVO> revokePersonRelationInfos = new ArrayList<>();

        for (PersonRelationInfoVO personRelationInfoVO : personDetailInfoVO.getPersonRelationInfoVOS()) {
            //黑名单
            if (personRelationInfoVO.getBlack()) {
                blackPersonRelationInfos.add(personRelationInfoVO);
            }
            //高危预警
            if (RiskLevelEnum.RISK_LEVEL_HIGH.equals(personRelationInfoVO.getRiskLevel())) {
                highRiskPersonRelationInfos.add(personRelationInfoVO);
            }
            //新金融
            if (CommonUtil.isNewFinance(personRelationInfoVO.getIndustry())) {
                financePersonRelationInfos.add(personRelationInfoVO);
            }
            //注吊销
            if ("吊销".equals(personRelationInfoVO.getEnterpriseStatus()) || "注销".equals(personRelationInfoVO.getEnterpriseStatus())) {
                revokePersonRelationInfos.add(personRelationInfoVO);
            }
        }
        personDetailInfoVO.setBlackPersonRelationInfos(blackPersonRelationInfos);
        personDetailInfoVO.setHighRiskPersonRelationInfos(highRiskPersonRelationInfos);
        personDetailInfoVO.setFinancePersonRelationInfos(financePersonRelationInfos);
        personDetailInfoVO.setRevokePersonRelationInfos(revokePersonRelationInfos);
        return personDetailInfoVO;
    }


    @Override
    public PersonDetailInfoVO getPersonDetailInfo(String personId) throws Exception {

        PersonDetailInfoVO personDetailInfoVO = new PersonDetailInfoVO();

        List<PersonRelationInfoVO> personRelationInfoVOS = new ArrayList<>();

        boolean judgeIsIpo = true;

        //取得个人关联方信息
        Map externalParam = new HashedMap();
        externalParam.put("unikey", personId);
        JSONObject rawData = null;
        rawData = (JSONObject) defaultApiExecEngine.execute(getSubgraphId, externalParam);
        JSONObject data = (JSONObject) rawData.get("data");
        List<List<Object>> nodes = new ArrayList<>();
        nodes = (List<List<Object>>) data.get("nodes");
        List<List<Object>> relationships = new ArrayList<>();
        relationships = (List<List<Object>>) data.get("relationships");

        //产生角色MAP
        Map<String, String> roleMap = new HashedMap();
        if (CollectionUtils.isNotEmpty(relationships)) {
            for (List<Object> objectData : relationships) {
                if (CollectionUtils.isNotEmpty(objectData)) {
                    Object o = objectData.get(3);
                    JSONObject valueObject = (JSONObject) o;
                    String role = valueObject.get("position") == null ? "" : valueObject.get("position").toString();
                    String startId = objectData.get(0).toString();
                    String endId = objectData.get(1).toString();

                    String mapKey = startId + "@" + endId;
                    if (roleMap.containsKey(mapKey)) {//已经存在这个key,将数据更新
                        String value = null;
                        if (null != role && !role.equals("")) {
                            value = roleMap.get(mapKey) + "," + role;
                            roleMap.put(mapKey, value);
                        }
                    } else {//不存在加入 值
                        if (null != role && !role.equals("")) {
                            roleMap.put(mapKey, role);
                        }
                    }
                }
            }
        }

        StringBuffer keys = new StringBuffer();
        Set<String> companyIds = new HashSet<String>();
        if (CollectionUtils.isNotEmpty(nodes)) {
            for (int i = 0; i < nodes.size(); i++) {
                if (CollectionUtils.isNotEmpty(nodes.get(i))) {
                    Integer type = (Integer) nodes.get(i).get(3);
                    if (type != 0) {
                        PersonRelationInfoVO personRelationInfoVO = new PersonRelationInfoVO();

                        String name = nodes.get(i).get(0) == null ? "" : nodes.get(i).get(0).toString();

                        //企业ID
                        personRelationInfoVO.setRelationCompanyId(name);
                        keys.append(keys.length() == 0 ? name : "," + name);
                        companyIds.add(name);
                        //企业名称
                        personRelationInfoVO.setRelationCompanyName(nodes.get(i).get(1).toString());
                        //角色
                        String mapKey = personId + "@" + name;
                        String role = roleMap.get(mapKey);
                        personRelationInfoVO.setRole(role);
                        personRelationInfoVOS.add(personRelationInfoVO);

                    } else {
                        personDetailInfoVO.setPersonName(nodes.get(i).get(1).toString());
                    }
                }
            }
        }
        HashMap<String, BaseDataDTO> baseDataMap = new HashMap<String, BaseDataDTO>();
        HashMap<String, ApiFinancialVO> financialMap = new HashMap<String, ApiFinancialVO>();
        Map<String, RaCompanyPO> map = new HashMap<String, RaCompanyPO>();

        CountDownLatch latch = new CountDownLatch(3);
        getData(keys, baseDataMap, financialMap, map, companyIds, latch);
        latch.await();

        //查询数据库中的黑名单公司id
        List<String> blackCompanyIds = raBlackListService.findBlackListByCompanyIds(companyIds);

        //组装基本信息与数仓信息
        for (PersonRelationInfoVO dataPerson : personRelationInfoVOS) {

            //黑名单
            dataPerson.setBlack(blackCompanyIds.contains(dataPerson.getRelationCompanyId()));

            //行业信息等
            RaCompanyPO raCompanyPO = map.get(dataPerson.getRelationCompanyId());
            if (raCompanyPO == null) {
                //风险等级
                dataPerson.setRiskLevel("--");
                //风险分值
                dataPerson.setRiskIndex(new Float(0));
            } else {
                //所属行业
                dataPerson.setIndustry(raCompanyPO.getIndustry());
                //风险等级
                dataPerson.setRiskLevel(stringNullChange(raCompanyPO.getRiskLevel()));
                //风险分值
                dataPerson.setRiskIndex(raCompanyPO.getRiskIndex());
            }


            //基本信息部分
            BaseDataDTO baseDataDTO = baseDataMap.get(dataPerson.getRelationCompanyId());
            boolean baseIsNull = false;
            if (baseDataDTO != null) {
                if (baseDataDTO.getJbxx() == null) {
                    baseIsNull = true;
                }
            } else {
                baseIsNull = true;
            }

            if (baseIsNull) {
                //省份地区
                dataPerson.setProvince("--");
                //注册日期  esdate
                dataPerson.setEsdate("--");
                //法定代表人 frname
                dataPerson.setFrname("--");
                //登记状态 enterpriseStatus
                dataPerson.setEnterpriseStatus("--");
                //注册资本  regcap
                dataPerson.setRegcap("--");
            } else {
                BaseDataDTO.Jbxx jbxx = baseDataDTO.getJbxx();
                //省份地区
                dataPerson.setProvince(jbxx.getCompanyProvince());
                //注册日期  esdate
                dataPerson.setEsdate(stringNullChange(jbxx.getEsdate()));
                //法定代表人 frname
                dataPerson.setFrname(stringNullChange(jbxx.getFrname()));
                //登记状态 enterpriseStatus
                dataPerson.setEnterpriseStatus(stringNullChange(jbxx.getCompanyEnterpriseStatus()));
                //注册资本  regcap
                String regcap = stringNullChange(BaseDataUtil.getRegcap(jbxx.getRegcapAmount(), jbxx.getRegcapCurrency()));

                dataPerson.setRegcap(regcap);

                //行业
                if (dataPerson.getIndustry() == null || dataPerson.getIndustry().equals("")) {
                    String baseIndustry = jbxx.getCompanyIndustry();
                    if (baseIndustry != null) {
                        dataPerson.setIndustry(Constants.INDUSTRY_DESCRIBE_MAP.get(jbxx.getCompanyIndustry()));
                    }
                }

                //出资比例  investRatio
                if (dataPerson.getRole() != null && dataPerson.getRole().contains("股东")) {
                    List<BaseDataDTO.Gdxx> gdxxList = baseDataDTO.getGdxx();
                    if (CollectionUtils.isNotEmpty(gdxxList)) {
                        for (BaseDataDTO.Gdxx gdxx : gdxxList) {
                            String shareholderName = gdxx.getShareholderName();
                            if (personDetailInfoVO.getPersonName().equals(shareholderName)) {
                                dataPerson.setInvestRatio(gdxx.getInvestRatio());
                            }
                        }
                    }
                }
                //判断是否上市公司
                if (judgeIsIpo) {
                    String isIpo = jbxx.getIpoCompany();
                    if (isIpo != null && isIpo.equals("上市公司")) {
                        List<BaseDataDTO.Baxx> directors = baseDataDTO.getBaxx();

                        if (CollectionUtils.isNotEmpty(directors)) {
                            for (BaseDataDTO.Baxx baxx : directors) {
                                String name = baxx.getName();
                                if (name.equals(personDetailInfoVO.getPersonName())) {
                                    personDetailInfoVO.setProfile(baxx.getResume());
                                    break;
                                }
                            }
                        }
                        judgeIsIpo = false;
                    }
                }

                //取得行业
            }
            //数仓信息部分
            ApiFinancialVO apiFinancialVO = financialMap.get(dataPerson.getRelationCompanyId());

            if (apiFinancialVO != null) {
                //民间借贷法律文书
                dataPerson.setTotalPrivateLendingNum(integerNullDataChange(apiFinancialVO.getTotalPrivateLendingNum()));
                //失信被执行人
                dataPerson.setTotalDishonestyNum(integerNullDataChange(apiFinancialVO.getTotalDishonestyNum()));
                //被执行人
                dataPerson.setTotalZhixingNum(integerNullDataChange(apiFinancialVO.getTotalZhixingNum()));
                //行政处罚
                dataPerson.setTotalXzcfNum(integerNullDataChange(apiFinancialVO.getTotalXzcfNum()));
                //经营异常
                dataPerson.setTotalQyycNum(integerNullDataChange(apiFinancialVO.getTotalQyycNum()));
                //诉讼
                dataPerson.setTotalDocumentNum(integerNullDataChange(apiFinancialVO.getTotalDocumentNum()));
                //工商变更
                dataPerson.setTotalBgxxNum(integerNullDataChange(apiFinancialVO.getTotalBgxxNum()));
                //对外投资
                dataPerson.setTotalOutDegreeNum(integerNullDataChange(apiFinancialVO.getTotalOutDegreeNum()));
                //黑名单
                dataPerson.setTotalBlackNum(integerNullDataChange(apiFinancialVO.getBlackNum3d()));
                //高风险
                dataPerson.setTotalHighNum(integerNullDataChange(apiFinancialVO.getHighRiskNum3d()));
            } else {
                //民间借贷法律文书
                dataPerson.setTotalPrivateLendingNum(0);
                //失信被执行人
                dataPerson.setTotalDishonestyNum(0);
                //被执行人
                dataPerson.setTotalZhixingNum(0);
                //行政处罚
                dataPerson.setTotalXzcfNum(0);
                //经营异常
                dataPerson.setTotalQyycNum(0);
                //诉讼
                dataPerson.setTotalDocumentNum(0);
                //工商变更
                dataPerson.setTotalBgxxNum(0);
                //对外投资
                dataPerson.setTotalOutDegreeNum(0);
                //黑名单
                dataPerson.setTotalBlackNum(0);
                //高风险
                dataPerson.setTotalHighNum(0);
            }
        }
        personDetailInfoVO.setPersonRelationInfoVOS(personRelationInfoVOS);
        return filterPersonDetialInfo(personDetailInfoVO);
    }

    @Override
    public Map<String, String> isPerson(String personId) throws Exception {
        Map<String, String> isPersonMap = new HashMap<>();
        //取得个人关联方信息
        Map externalParam = new HashedMap();
        externalParam.put("unikey", personId);
        JSONObject rawData = null;
        rawData = (JSONObject) defaultApiExecEngine.execute(getSubgraphId, externalParam);
        JSONObject data = (JSONObject) rawData.get("data");
        List<List<Object>> nodes = new ArrayList<>();
        nodes = (List<List<Object>>) data.get("nodes");
        List<List<Object>> relationships = new ArrayList<>();
        relationships = (List<List<Object>>) data.get("relationships");

        if (CollectionUtils.isNotEmpty(nodes) || CollectionUtils.isNotEmpty(relationships)) {
            isPersonMap.put("isPerson", "true");
        } else {
            isPersonMap.put("isPerson", "false");
        }
        return isPersonMap;
    }

    /**
     * 多线程取得所需资料
     *
     * @param keys
     * @param baseDataMap
     * @param financialMap
     * @param map
     * @param companyIds
     * @param latch
     */
    private void getData(StringBuffer keys, HashMap<String, BaseDataDTO> baseDataMap, HashMap<String, ApiFinancialVO> financialMap, Map<String, RaCompanyPO> map, Set<String> companyIds, CountDownLatch latch) {
        //线程1：批量取得基本信息
        SystemThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<BaseDataDTO> baseDataDTOS = new ArrayList<BaseDataDTO>();
                    baseDataDTOS = getBaseInfoData(keys.toString());
                    if (CollectionUtils.isNotEmpty(baseDataDTOS)) {
                        for (BaseDataDTO baseData : baseDataDTOS) {
                            if (baseData == null) {
                                continue;
                            }
                            baseDataMap.put(baseData.getJbxx().getBbdQyxxId(), baseData);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });
        //线程2：批量取得数仓信息
        SystemThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                //批量取得数仓信息
                List<ApiFinancialVO> shuCangDataList = new ArrayList<>();
                try {
                    shuCangDataList = getApiFinancialData(keys.toString());

                    if (CollectionUtils.isNotEmpty(shuCangDataList)) {
                        for (ApiFinancialVO apiFinancialVO : shuCangDataList) {
                            if (apiFinancialVO == null) {
                                continue;
                            }
                            financialMap.put(apiFinancialVO.getCompanyId(), apiFinancialVO);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });
        //线程3：取得本地库中行业，风险等级，风险指数等信息
        SystemThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                //取得数据库中企业的 行业，风险等级，风险指数
                try {
                    List<RaCompanyPO> companyPOList = raCompanyService.findCompanysByIds(companyIds);
                    if (CollectionUtils.isNotEmpty(companyPOList)) {
                        for (RaCompanyPO raCompanyPO : companyPOList) {
                            if (raCompanyPO == null) {
                                continue;
                            }
                            map.put(raCompanyPO.getId(), raCompanyPO);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });
    }

    /**
     * 批量取得基本信息
     *
     * @param keys
     * @return
     * @throws Exception
     */
    private List<BaseDataDTO> getBaseInfoData(String keys) throws Exception {
        Vector<BaseDataDTO> data = new Vector<BaseDataDTO>();
        int pageSize = 50;
        String[] keysValue = keys.split(",");
        List<String> keysList = getKeys(keysValue, pageSize);
        CountDownLatch latch = new CountDownLatch(keysList.size());

        for (int i = 0; i < keysList.size(); i++) {

            String keysData = keysList.get(i);

            SystemThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Map externalParam = new HashedMap();
                    externalParam.put("keys", keysData);
                    JSONObject rawData = null;
                    try {
                        rawData = (JSONObject) defaultApiExecEngine.execute(qyxxBatchId, externalParam);

                        TypeToken token = new TypeToken<ApiReturnBean<BaseDataDTO>>() {
                        };
                        Gson gson = new Gson();
                        ApiReturnBean<BaseDataDTO> baseDataVOApiReturnBean = gson.fromJson(rawData.toString(), token.getType());

                        List<BaseDataDTO> baseDataDTOS = baseDataVOApiReturnBean.getResults();

                        data.addAll(baseDataDTOS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        return data;
    }

    /**
     * 批量数仓数据
     *
     * @param companyIdList
     * @return
     * @throws InterruptedException
     */
    private List<ApiFinancialVO> getApiFinancialData(String companyIdList) throws InterruptedException {
        Vector<ApiFinancialVO> dataList = new Vector<>();
        String[] keysValue = StringUtils.split(companyIdList, ",");
        int pageSize = 25;
        List<String> keys = getKeys(keysValue, pageSize);
        if (CollectionUtils.isEmpty(keys)) {
            return dataList;
        }
        CountDownLatch latch = new CountDownLatch(keys.size());

        for (int m = 0; m < keys.size(); m++) {
            String companyId = keys.get(m);
            SystemThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Map externalParam = new HashedMap();
                    externalParam.put("qyId", companyId);
                    try {
                        JSONObject rawData = (JSONObject) defaultApiExecEngine.execute(financialApiId, externalParam);

                        List<Object> objectsData = (List<Object>) rawData.get("data");
                        Gson gson = new Gson();
                        for (Object o : objectsData) {
                            JSONObject value = (JSONObject) o;
                            ApiFinancialVO apiFinancialVO = gson.fromJson(value.toString(), ApiFinancialVO.class);
                            dataList.add(apiFinancialVO);
                        }
                        latch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        latch.await();
        return dataList;
    }

    /**
     * 将传入的数据根据pageSize转换成对应的list
     *
     * @param keysValue
     * @param pageSize
     * @return
     */
    private List<String> getKeys(String[] keysValue, int pageSize) {
        List<String> keys = new ArrayList<String>();
        int keysLength = keysValue.length;
        int num = 0;
        for (int i = keysLength; i > 0; i -= pageSize) {
            StringBuffer value = new StringBuffer();
            if (i <= pageSize) {
                for (int j = 0; j < i; j++) {
                    value.append(value.length() == 0 ? keysValue[j + num * pageSize] : "," + keysValue[j + num * pageSize]);
                }
            } else {
                for (int j = 0; j < pageSize; j++) {
                    value.append(value.length() == 0 ? keysValue[j + num * pageSize] : "," + keysValue[j + num * pageSize]);
                }
            }
            keys.add(value.toString());
            num++;
        }
        return keys;
    }

    /**
     * 当值为空时返回“--”
     *
     * @param value
     * @return
     */
    private String stringNullChange(String value) {
        if (null == value || value.equals("")) {
            return "--";
        } else {
            return value;
        }
    }

    /**
     * Interger类型为NULL时设定为0
     *
     * @param value
     * @return
     */
    private int integerNullDataChange(Integer value) {
        if (null == value) {
            return 0;
        } else {
            return value;
        }
    }
}
