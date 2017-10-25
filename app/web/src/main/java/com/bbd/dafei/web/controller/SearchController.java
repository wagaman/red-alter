package com.bbd.dafei.web.controller;

import com.bbd.dafei.biz.shared.RaBlackListService;
import com.bbd.dafei.biz.shared.RaCompanyService;
import com.bbd.dafei.biz.shared.SearchService;
import com.bbd.dafei.common.annotation.UserLog;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.commonenum.SearchTypeEnum;
import com.bbd.dafei.common.modal.dto.SearchCompanyDTO;
import com.bbd.dafei.common.modal.util.BaseDataUtil;
import com.bbd.dafei.common.modal.util.SearchUtil;
import com.bbd.dafei.common.modal.vo.SearchCompanyVO;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by wish on 2017/4/25.
 */
@Controller
@RequestMapping("/search")
@Api(value = "/search", tags = "搜索企业信息")
public class SearchController extends BaseController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private RaBlackListService raBlackListService;

    @Autowired
    private RaCompanyService raCompanyService;

    private static final Map<String, SearchTypeEnum> SEARCH_TYPE_MAP = new HashMap<String, SearchTypeEnum>() {{
        put("综合", SearchTypeEnum.SEARCH_TYPE_MIX);
        put("企业名", SearchTypeEnum.SEARCH_TYPE_COMPANY);
        put("平台名", SearchTypeEnum.SEARCH_TYPE_PINGTAI);
        put("法人或股东", SearchTypeEnum.SEARCH_TYPE_GDXX);
        put("董监高", SearchTypeEnum.SEARCH_TYPE_DJG);
    }};

    @RequestMapping(value = "/searchCompany.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "搜索公司信息", notes = "按公司名、法人、董监高搜索公司信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "关键字", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "搜索类型(综合,企业名,平台名,法人或股东,董监高)", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
    })
    @UserLog
    public ResponseBean<PageInfo<SearchCompanyVO>> searchCompany(@RequestParam String key, @RequestParam(defaultValue = "综合") String type, @RequestParam(defaultValue = "1") Integer page,
                                                                 @RequestParam(defaultValue = "20") Integer pageSize) throws Exception {
        String userProvince = getUserProvince();
        SearchTypeEnum searchTypeEnum = SEARCH_TYPE_MAP.get(type);
        if (searchTypeEnum == null) {
            //默认综合搜索
            searchTypeEnum = SearchTypeEnum.SEARCH_TYPE_MIX;
        }
        //搜索数据平台
        PageInfo<SearchCompanyDTO> pageInfo = searchService.searchCompany(key, searchTypeEnum, page, pageSize);
        if (pageInfo == null) {
            return ResponseBean.errorResponse("查询失败");
        }
        Set<String> companyIds = new HashSet<String>();
        List<SearchCompanyVO> searchCompanyVOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(pageInfo.getItems())) {
            for (SearchCompanyDTO searchCompanyDTO : pageInfo.getItems()) {
                //格式化注册资金，去掉小数点和小数点后的数字
                searchCompanyDTO.setRegcap(BaseDataUtil.formatRegcap(searchCompanyDTO.getRegcap()));
                companyIds.add(searchCompanyDTO.getBbdQyxxId());
            }
            //查询数据库中的企业信息
            List<RaCompanyPO> companyPOList = raCompanyService.findCompanysByIds(companyIds);
            //查询黑名单
            List<String> blackCompanyIds = raBlackListService.findBlackListByCompanyIds(companyIds);
            searchCompanyVOList = SearchUtil.transToSearchCompanyVO(pageInfo.getItems(), companyPOList, blackCompanyIds, userProvince);
        }

        PageInfo<SearchCompanyVO> pageInfoVO = new PageInfo<SearchCompanyVO>();
        pageInfoVO.setItems(searchCompanyVOList);
        pageInfoVO.setPage(pageInfo.getPage());
        pageInfoVO.setPageSize(pageInfo.getPageSize());
        pageInfoVO.setTotalPage(pageInfo.getTotalPage());
        pageInfoVO.setTotalCount(pageInfo.getTotalCount());

        return ResponseBean.successResponse(pageInfoVO);
    }
}
