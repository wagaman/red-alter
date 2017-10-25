package com.bbd.dafei.common.modal.util;

import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.modal.vo.ExchangeVO;
import com.bbd.dafei.common.modal.vo.WljdFeatureVO;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by wish on 2017/4/25.
 */
public class FeatureUtil {

    //零壹正常数据状态
    private static final String LINGYI_STATUS_NORMAL = "正常";

    /**
     * 生成交易场所特征信息VO
     *
     * @param exchangeDTO
     * @return
     */
    public static ExchangeVO transExchangeDTOToExchangeVO(ExchangeDTO exchangeDTO) throws Exception {
        ExchangeVO exchangeVO = new ExchangeVO();
        if (exchangeDTO == null) {
            return exchangeVO;
        }
        BeanUtils.copyProperties(exchangeVO, exchangeDTO);

        //解析交易信息json
        String json = exchangeDTO.getTradingVarietyInfo();
        if (StringUtils.isNotBlank(json)) {
            Gson gson = new Gson();
            List<ExchangeVO.TradingVarietyInfo> tradingVarietyInfos = gson.fromJson(json, new TypeToken<List<ExchangeVO.TradingVarietyInfo>>() {
            }.getType());
            exchangeVO.setTradingVarietyInfos(tradingVarietyInfos);
        }

        return exchangeVO;
    }

    /**
     * 生成网络借贷特征信息VO集合
     *
     * @param platformDTO
     * @return
     * @throws Exception
     */
    public static List<WljdFeatureVO> transWljdDTOListToWljdVOList(PlatformDTO platformDTO, List<RaProblemPlatformDTO> problemPlatformDTOList) throws Exception {
        //将问题平台放到map
        Map<String, RaProblemPlatformDTO> problemPlatformDTOMap = new HashMap<>();
        for (RaProblemPlatformDTO raProblemPlatformDTO : problemPlatformDTOList) {
            problemPlatformDTOMap.put(raProblemPlatformDTO.getName(), raProblemPlatformDTO);
        }

        List<WljdFeatureVO> wljdFeatureVOList = new ArrayList<>();

        if (platformDTO == null) {
            return wljdFeatureVOList;
        }

        //网贷之家,放入map，方便取值
        Map<String, WdzjDTO> wdzjMap = new HashMap<String, WdzjDTO>();

        if (CollectionUtils.isNotEmpty(platformDTO.getWdzjs())) {
            for (WdzjDTO wdzjDTO : platformDTO.getWdzjs()) {
                if (wdzjDTO == null) {
                    continue;
                }
                wdzjMap.put(wdzjDTO.getPlatformName(), wdzjDTO);
            }
        }

        //遍历零壹数据，匹配网贷之家的数据，构建VO
        if (CollectionUtils.isNotEmpty(platformDTO.getPlatformDatas())) {
            for (PlatformDataDTO platformDataDTO : platformDTO.getPlatformDatas()) {
                if (platformDataDTO == null) {
                    continue;
                }
                //网贷之家
                WdzjDTO wdzjDTO = wdzjMap.get(platformDataDTO.getPlatformName());

                //本地数据库存放的问题平台信息
                RaProblemPlatformDTO raProblemPlatformDTO = problemPlatformDTOMap.get(platformDataDTO.getPlatformName());

                //移除已处理的数据
                wdzjMap.remove(platformDataDTO.getPlatformName());

                WljdFeatureVO wljdFeatureVO = transWljdDTOToWljdVO(platformDataDTO, wdzjDTO, raProblemPlatformDTO);
                wljdFeatureVOList.add(wljdFeatureVO);
            }
        }

        //处理网贷之家和零壹数据未匹配的数据
        for (Map.Entry<String, WdzjDTO> entry : wdzjMap.entrySet()) {
            //网贷之家
            WdzjDTO wdzjDTO = entry.getValue();
            //本地数据库存放的问题平台信息
            RaProblemPlatformDTO raProblemPlatformDTO = problemPlatformDTOMap.get(wdzjDTO.getPlatformName());
            WljdFeatureVO wljdFeatureVO = transWljdDTOToWljdVO(null, wdzjDTO, raProblemPlatformDTO);
            wljdFeatureVOList.add(wljdFeatureVO);
        }

        return wljdFeatureVOList;
    }

    /**
     * 根据网贷之家、零壹数据和数据库的问题平台生成网络借贷特征信息VO
     *
     * @param platformDataDTO      零壹数据
     * @param wdzjDTO              网络借贷
     * @param raProblemPlatformDTO 问题平台信息
     * @return
     * @throws Exception
     */
    private static WljdFeatureVO transWljdDTOToWljdVO(PlatformDataDTO platformDataDTO, WdzjDTO wdzjDTO, RaProblemPlatformDTO raProblemPlatformDTO) throws Exception {
        WljdFeatureVO wljdFeatureVO = new WljdFeatureVO();

        //取零壹数据的信息
        if (platformDataDTO != null) {
            wljdFeatureVO.setPlatformName(platformDataDTO.getPlatformName());
            wljdFeatureVO.setOnlinetime(platformDataDTO.getOnlinetime());
            wljdFeatureVO.setTotalTurnover(platformDataDTO.getTotalTurnover());
            wljdFeatureVO.setAvgLendTime(platformDataDTO.getAvgLendTime());
            wljdFeatureVO.setAvgSoldoutTime(platformDataDTO.getAvgSoldoutTime());
            wljdFeatureVO.setPerBorrowingAmount(platformDataDTO.getPerBorrowingAmount());
            wljdFeatureVO.setPerLendingAmount(platformDataDTO.getPerLendingAmount());
            wljdFeatureVO.setPerBorrowingNum(platformDataDTO.getPerBorrowingNum());
            wljdFeatureVO.setPerLendingNum(platformDataDTO.getPerLendingNum());
            wljdFeatureVO.setNumOfLender(platformDataDTO.getTotalNumOfLender());
            wljdFeatureVO.setNumOfBorrower(platformDataDTO.getTotalNumOfBorrower());
            wljdFeatureVO.setDealVolume(platformDataDTO.getTotalDealVolume());
        }
        //取网络借贷的信息
        if (wdzjDTO != null) {
            wljdFeatureVO.setPlatformName(wdzjDTO.getPlatformName());
            wljdFeatureVO.setOnlinetime(wdzjDTO.getOnlinetime());
            wljdFeatureVO.setBankCustody(wdzjDTO.getBankCustody());
            wljdFeatureVO.setInvestTerm(wdzjDTO.getInvestTerm());
            wljdFeatureVO.setAutomaticBidding(wdzjDTO.getAutomaticBidding());
            wljdFeatureVO.setClaimTransfer(wdzjDTO.getClaimTransfer());
            wljdFeatureVO.setBidGuarantee(wdzjDTO.getBidGuarantee());
            wljdFeatureVO.setGuaranteeMode(wdzjDTO.getGuaranteeMode());
            wljdFeatureVO.setRiskReserve(wdzjDTO.getRiskReserve());
            wljdFeatureVO.setFinancingRecord(wdzjDTO.getFinancingRecord());
            wljdFeatureVO.setSuperviseAssociation(wdzjDTO.getSuperviseAssociation());
            wljdFeatureVO.setGuaranteeInstitution(wdzjDTO.getGuaranteeInstitution());
            wljdFeatureVO.setAvgReturn(wdzjDTO.getAvgReturn());
            wljdFeatureVO.setSerious(isSerious(wdzjDTO));

            DynamicAnalysisDTO dynamicAnalysisDTO = getDynamicAnalysisFromJson(wdzjDTO.getDynamicAnalysis());
            if (dynamicAnalysisDTO != null) {
                wljdFeatureVO.setAvgReturn(dynamicAnalysisDTO.getAvgReturn());
                wljdFeatureVO.setDealVolume(dynamicAnalysisDTO.getDealVolume());
                wljdFeatureVO.setNumOfLender(dynamicAnalysisDTO.getNumOfLender());
                wljdFeatureVO.setNumOfBorrower(dynamicAnalysisDTO.getNumOfBorrower());
                wljdFeatureVO.setLastFundNetInflow(dynamicAnalysisDTO.getLastFundNetInflow());
                wljdFeatureVO.setLastDailyPending(dynamicAnalysisDTO.getLastDailyPending());
            }

        }

        //是否问题平台
        boolean problemPlatform = isProblemPlatform(platformDataDTO, wdzjDTO);
        wljdFeatureVO.setProblem(problemPlatform);
        //是问题平台，将数据库问题信息设置到VO
//        if (problemPlatform && raProblemPlatformDTO != null) {
//            wljdFeatureVO.setProblemTime(raProblemPlatformDTO.getProblemTime());
//            wljdFeatureVO.setProblemReason(raProblemPlatformDTO.getEventType());
//        }
        //问题平台发生原因，优先取网贷之家
        if (wdzjDTO != null) {
            wljdFeatureVO.setProblemReason(wdzjDTO.getPlatformState());
        } else if (platformDataDTO != null) {
            wljdFeatureVO.setProblemReason(platformDataDTO.getPlatformState());
        }

        return wljdFeatureVO;
    }

    /**
     * 判断是否是问题平台
     *
     * @param platformDataDTO 零壹数据
     * @param wdzjDTO         网贷之家
     * @return
     */
    private static boolean isProblemPlatform(PlatformDataDTO platformDataDTO, WdzjDTO wdzjDTO) {
        //是否问题平台
        boolean platformProblem = false;

        //如果网贷之家有数据，优先通过网贷之家来判断是否是问题平台
        if (wdzjDTO != null) {
            //网贷之家状态值不为空，则为问题平台
            platformProblem = StringUtils.isNotBlank(wdzjDTO.getPlatformState());
        } else if (platformDataDTO != null) {
            //零壹数据状态值不等于'正常'则为问题平台
            platformProblem = !LINGYI_STATUS_NORMAL.equals(platformDataDTO.getPlatformState());
        }
        return platformProblem;
    }

    /**
     * 解析动态分析json
     *
     * @param json
     * @return
     */
    private static DynamicAnalysisDTO getDynamicAnalysisFromJson(String json) {
        DynamicAnalysisDTO dynamicAnalysisDTO = new Gson().fromJson(json, new TypeToken<DynamicAnalysisDTO>() {
        }.getType());
        if (dynamicAnalysisDTO != null) {
            //字段以逗号分隔数值和百分比如64061.08,1.24%，取数值
            dynamicAnalysisDTO.setDealVolume(StringUtils.substringBefore(dynamicAnalysisDTO.getDealVolume(), ","));
            dynamicAnalysisDTO.setNumOfBorrower(StringUtils.substringBefore(dynamicAnalysisDTO.getNumOfBorrower(), ","));
            dynamicAnalysisDTO.setLastDailyPending(StringUtils.substringBefore(dynamicAnalysisDTO.getLastDailyPending(), ","));
            dynamicAnalysisDTO.setNumOfLender(StringUtils.substringBefore(dynamicAnalysisDTO.getNumOfLender(), ","));
            dynamicAnalysisDTO.setLastFundNetInflow(StringUtils.substringBefore(dynamicAnalysisDTO.getLastFundNetInflow(), ","));
        }

        return dynamicAnalysisDTO;
    }

    /**
     * 获取所有平台名称
     *
     * @param platformDTO
     * @return
     */
    public static Set<String> getPlatformNamesByPlatformDTO(PlatformDTO platformDTO) {
        Set<String> platformNames = new HashSet<String>();
        if (platformDTO != null) {
            if (CollectionUtils.isNotEmpty(platformDTO.getWdzjs())) {
                for (WdzjDTO wdzjDTO : platformDTO.getWdzjs()) {
                    platformNames.add(wdzjDTO.getPlatformName());
                }
            }
            if (CollectionUtils.isNotEmpty(platformDTO.getPlatformDatas())) {
                for (PlatformDataDTO platformDataDTO : platformDTO.getPlatformDatas()) {
                    platformNames.add(platformDataDTO.getPlatformName());
                }
            }
        }
        return platformNames;
    }

    /**
     * 是否是严重问题平台
     * 网贷之家的 platform_state = 经侦介入 或 提现困难 或 跑路  这三种情况
     *
     * @param wdzjDTO
     * @return
     */
    private static boolean isSerious(WdzjDTO wdzjDTO) {
        if (wdzjDTO == null || wdzjDTO.getPlatformState() == null) {
            return false;
        }
        return "经侦介入".equals(wdzjDTO.getPlatformState())
                || "提现困难".equals(wdzjDTO.getPlatformState())
                || "跑路".equals(wdzjDTO.getPlatformState());

    }

}
