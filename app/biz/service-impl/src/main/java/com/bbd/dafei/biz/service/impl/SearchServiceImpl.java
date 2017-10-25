package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiExceptionUtils;
import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.SearchService;
import com.bbd.dafei.common.modal.commonenum.SearchTypeEnum;
import com.bbd.dafei.common.modal.dto.SearchCompanyDTO;
import com.bbd.dafei.common.modal.dto.SearchCompanyPageDTO;
import com.bbd.dafei.common.modal.util.BaseDataUtil;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.PageInfo;
import com.google.common.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wish on 2017/4/25.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ApiUtils api;

    //搜索url
    @Value("${api.search}")
    private String searchUrl;

    @Override
    public PageInfo<SearchCompanyDTO> searchCompany(String key, SearchTypeEnum searchTypeEnum, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("query", key));
        if (searchTypeEnum != null) {
            nvps.add(new BasicNameValuePair("type", searchTypeEnum.getCode()));
        }
        nvps.add(new BasicNameValuePair("highlight", "true"));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        nvps.add(new BasicNameValuePair("page_no", String.valueOf(page - 1)));//这个接口，page_no是从0开始的。。
        nvps.add(new BasicNameValuePair("page_size", String.valueOf(pageSize)));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        SearchCompanyPageDTO searchCompanyPageDTO = api.cacheThenGet(searchUrl,
                new TypeToken<SearchCompanyPageDTO>() {
                }, validDate, nvps);
        if (!searchCompanyPageDTO.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(searchUrl, searchCompanyPageDTO, nvps);
        }
        //数据平台返回的分页数据结构不能用PageInfo接收，单独处理
        if (searchCompanyPageDTO != null) {
            if (CollectionUtils.isNotEmpty(searchCompanyPageDTO.getSearchCompanyDTOList())) {
                for (SearchCompanyDTO searchCompanyDTO : searchCompanyPageDTO.getSearchCompanyDTOList()) {
                    String companyName = searchCompanyDTO.getCompanyName();
                    String unHightLightCompanyName = companyName.replace("<em>", "").replace("</em>", "");
                    searchCompanyDTO.setUnHighLightCompanyName(unHightLightCompanyName);

                    //注册资本
                    searchCompanyDTO.setRegcap(BaseDataUtil.getRegcap(searchCompanyDTO.getRegcapAmount(), searchCompanyDTO.getRegcapCurrency()));
                }

            }

            PageInfo<SearchCompanyDTO> pageInfo = new PageInfo<>();
            pageInfo.setItems(searchCompanyPageDTO.getSearchCompanyDTOList());
            pageInfo.setPage(page);
            pageInfo.setPageSize(pageSize);
            pageInfo.setTotalCount(searchCompanyPageDTO.getSum());
            pageInfo.setTotalPage(searchCompanyPageDTO.getSum() / pageSize);

            int totalPage = searchCompanyPageDTO.getSum() / pageSize;
            if (searchCompanyPageDTO.getSum() % pageSize != 0) {
                totalPage++;
            }
            pageInfo.setTotalPage(totalPage);
            return pageInfo;
        }

        return null;
    }
}
