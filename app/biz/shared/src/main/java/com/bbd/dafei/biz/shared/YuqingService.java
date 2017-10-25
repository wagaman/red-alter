package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.YuqingContentDTO;
import com.bbd.dafei.common.util.PageInfo;

/**
 * 舆情service
 * Created by wish on 2017/8/20.
 */
public interface YuqingService {
    PageInfo<YuqingContentDTO> getYuqingContentByCompanyId(String companyId, String sort, Integer page, Integer pageSize) throws Exception;

    PageInfo<YuqingContentDTO> getYuqingContentByCompanyIdAndRelate(String companyId, String qc, String type, String sort, int page, int pageSize) throws Exception;
}
