package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.FeatureService;
import com.bbd.dafei.biz.shared.RaProblemPlatformService;
import com.bbd.dafei.common.modal.dto.ExchangeDTO;
import com.bbd.dafei.common.modal.dto.PlatformDTO;
import com.bbd.dafei.common.modal.dto.PrivateFundDTO;
import com.bbd.dafei.common.modal.dto.RaProblemPlatformDTO;
import com.bbd.dafei.common.modal.util.FeatureUtil;
import com.bbd.dafei.common.modal.vo.ExchangeVO;
import com.bbd.dafei.common.modal.vo.WljdFeatureVO;
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
import java.util.Set;

/**
 * 特征信息Controller
 * Created by wish on 2017/4/25.
 */
@Controller
@RequestMapping("/feature")
@Api(value = "/feature", tags = "企业特征信息")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @Autowired
    private RaProblemPlatformService raProblemPlatformService;

    @RequestMapping(value = "/getExchangeFeature.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询交易场所特征信息", notes = "根据公司id查询交易场所特征信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<ExchangeVO> getExchangeFeature(@RequestParam String companyId) throws Exception {
        ExchangeDTO exchangeDTO = featureService.getExchangeByCompanyId(companyId);
        ExchangeVO exchangeVO = FeatureUtil.transExchangeDTOToExchangeVO(exchangeDTO);
        return ResponseBean.successResponse(exchangeVO);
    }

    @RequestMapping(value = "/getPrivateFundFeature.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询私募基金特征信息", notes = "根据公司id查询私募基金特征信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<PrivateFundDTO> getPrivateFundFeature(@RequestParam String companyId) throws Exception {
        PrivateFundDTO privateFundDTO = featureService.getPrivateFundBycompanyId(companyId);
        return ResponseBean.successResponse(privateFundDTO);
    }

    @RequestMapping(value = "/getP2PFeature.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询网络借贷特征信息", notes = "根据公司id查询网络借贷特征信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<List<WljdFeatureVO>> getP2PFeature(@RequestParam String companyId) throws Exception {
        PlatformDTO platformDTO = featureService.getP2PPlatformByCompanyId(companyId);
        //得到所有平台名称
        Set<String> platformNames = FeatureUtil.getPlatformNamesByPlatformDTO(platformDTO);
        //查询所有的问题平台
        List<RaProblemPlatformDTO> raProblemPlatformDTOList = raProblemPlatformService.findProblemPlatformsByNames(platformNames);
        List<WljdFeatureVO> wljdFeatureVOList = FeatureUtil.transWljdDTOListToWljdVOList(platformDTO, raProblemPlatformDTOList);
        return ResponseBean.successResponse(wljdFeatureVOList);

    }
}
