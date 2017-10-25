package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.commonenum.SearchTypeEnum;
import com.bbd.dafei.common.modal.dto.SearchCompanyDTO;
import com.bbd.dafei.common.util.PageInfo;

/**
 * Created by wish on 2017/4/25.
 */
public interface SearchService {
    /**
     * 搜索公司
     * @param key 关键字
     * @param searchTypeEnum 搜索类型
     * @param page 页
     * @param pageSize 每页数量
     * @return
     * @throws Exception
     */
    PageInfo<SearchCompanyDTO> searchCompany(String key, SearchTypeEnum searchTypeEnum, Integer page, Integer pageSize) throws Exception;
}
