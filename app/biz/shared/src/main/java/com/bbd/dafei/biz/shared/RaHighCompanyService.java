package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.util.Paging;
import com.bbd.dafei.common.modal.vo.RaIndexCompanyVO;

import java.util.List;

/**
 * Created by tuanhong on 2017-04-19.
 */
public interface RaHighCompanyService {

    /**
     * 导出高危企业列表
     * @param province
     * @param city
     * @param area
     * @param industry
     * @param isNew
     * @return
     */
    public List<RaIndexCompanyVO> findByProvince(
                                                String province,
                                                String city,
                                                String area ,
                                                String industry,
                                                String isNew
                                                );


    /**
     *
     * 分页查询高风险
     *
     * */
    public Paging<RaIndexCompanyVO> query(String province, String city,
                                          String area, String industry,
                                          String isNew,
                                          Integer start, Integer size,
                                          String order, String descAsc);


}
