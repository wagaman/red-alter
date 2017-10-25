package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.vo.RelationTotalInfoVO;

/**
 * Created by shi.jun on 2017/9/20.
 */
public interface RelationRightInfoService {

    /**
     * 查询企业详情右侧关联方数据
     * @param companyId
     */
    RelationTotalInfoVO getRightRelation(String companyId) throws Exception;

}
