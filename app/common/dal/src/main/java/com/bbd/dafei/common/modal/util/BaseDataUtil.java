package com.bbd.dafei.common.modal.util;

import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.dto.BaseDataAbstractDTO;
import com.bbd.dafei.common.modal.dto.BaseDataOverviewDTO;
import com.bbd.dafei.common.modal.dto.BlackFocusNumDTO;
import com.bbd.dafei.common.modal.vo.BaseDataAbstractVO;
import com.bbd.dafei.common.modal.vo.BaseDataOverviewVO;
import com.bbd.dafei.common.util.Constants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 基本信息工具类
 * Created by wish on 2017/4/21.
 */
public class BaseDataUtil {

    /**
     * 生成企业信息概览VO
     *
     * @param baseDataOverviewDTO
     * @param blackFocusNumDTO
     * @return
     * @throws Exception
     */
    public static BaseDataOverviewVO transToBaseDataOverviewVO(BaseDataOverviewDTO baseDataOverviewDTO, BlackFocusNumDTO blackFocusNumDTO) throws Exception {
        BaseDataOverviewVO baseDataOverviewVO = new BaseDataOverviewVO();
        if (baseDataOverviewDTO != null) {
            BeanUtils.copyProperties(baseDataOverviewVO, baseDataOverviewDTO);
            baseDataOverviewVO.setRegcap(BaseDataUtil.getRegcap(baseDataOverviewDTO.getRegcapAmount(), baseDataOverviewDTO.getRegcapCurrency()));
        }
        if (blackFocusNumDTO != null) {
            //企业关注数量
            baseDataOverviewVO.setFocusNum(blackFocusNumDTO.getFocusNum());
            //是否拉黑
            baseDataOverviewVO.setBlack(blackFocusNumDTO.isBlack());
            //该公司的拉黑id
            baseDataOverviewVO.setBlackId(blackFocusNumDTO.getBlackId());
            //拉黑时间
            baseDataOverviewVO.setAddBlackDate(blackFocusNumDTO.getAddBlackDate());
            //拉黑原因
            baseDataOverviewVO.setBlackReasons(blackFocusNumDTO.getBlackReasons());

            //用户是否关注
            baseDataOverviewVO.setUserFocus(blackFocusNumDTO.isUserFocus());
            //用户对该公司的关注id
            baseDataOverviewVO.setFocusId(blackFocusNumDTO.getFocusId());

            RaCompanyPO raCompanyPO = blackFocusNumDTO.getRaCompanyPO();
            //本地数据库中的风险信息和行业信息
            if (raCompanyPO != null) {
                baseDataOverviewVO.setIndustry(raCompanyPO.getIndustry());
                baseDataOverviewVO.setRiskIndex(raCompanyPO.getRiskIndex());
                baseDataOverviewVO.setRiskLevel(raCompanyPO.getRiskLevel());
                baseDataOverviewVO.setRise(raCompanyPO.getRise());
            }
        }

        //如果没有新金融行业标签，显示行业
        if (baseDataOverviewVO.getIndustry() == null && baseDataOverviewDTO != null) {
            baseDataOverviewVO.setIndustry(Constants.INDUSTRY_DESCRIBE_MAP.get(baseDataOverviewDTO.getCompanyIndustry()));
        }

        return baseDataOverviewVO;
    }

    /**
     * 生成企业摘要信息VO
     *
     * @param baseDataAbstractDTO
     * @param raCompanyPO
     * @param black
     * @return
     */
    public static BaseDataAbstractVO transToBaseDataAbstractVO(BaseDataAbstractDTO baseDataAbstractDTO, RaCompanyPO raCompanyPO, boolean black) throws Exception {
        BaseDataAbstractVO baseDataAbstractVO = new BaseDataAbstractVO();
        if (baseDataAbstractDTO != null) {
            BeanUtils.copyProperties(baseDataAbstractVO, baseDataAbstractDTO);
        }

        //本地数据库中的风险信息和行业信息
        if (raCompanyPO != null) {
            baseDataAbstractVO.setIndustry(raCompanyPO.getIndustry());
            baseDataAbstractVO.setRiskIndex(raCompanyPO.getRiskIndex());
            baseDataAbstractVO.setRiskLevel(raCompanyPO.getRiskLevel());
        }
        //如果没有新金融行业标签，显示非新金融行业
        if (baseDataAbstractVO.getIndustry() == null && baseDataAbstractDTO != null) {
            baseDataAbstractVO.setIndustry(Constants.INDUSTRY_DESCRIBE_MAP.get(baseDataAbstractDTO.getCompanyIndustry()));
        }
        //是否拉黑
        baseDataAbstractVO.setBlack(black);
        return baseDataAbstractVO;
    }

    /**
     * 格式化注册资金，去掉小数点和小数点后的数字
     *
     * @param regcap
     * @return
     */
    public static String formatRegcap(String regcap) {
        if (StringUtils.isBlank(regcap)) {
            return regcap;
        }
        return regcap.replaceAll("\\.([0-9])*", "");
    }

    public static String getRegcap(String regAmount, String regCurrency) {
        if (StringUtils.isEmpty(regAmount)) {
            return null;
        }
        if (StringUtils.isEmpty(regCurrency)) {
            regCurrency = "";
        }
        Double regAmountDouble = Double.valueOf(regAmount);
        if (regAmount == null) {
            return null;
        }
        regAmount = formatRegAmount(regAmountDouble);
        if (regAmount == null) {
            return null;
        }
        return regAmount + regCurrency;
    }

    public static String formatRegAmount(double regAmount) {
        if (regAmount != 0.00) {
            java.text.DecimalFormat df = new java.text.DecimalFormat("########万");
            return df.format(regAmount / 10000);
        } else {
            return null;
        }
    }
}
