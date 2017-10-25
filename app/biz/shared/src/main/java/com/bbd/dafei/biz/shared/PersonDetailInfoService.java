package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.vo.PersonDetailInfoVO;

import java.util.Map;

/**
 * Created by Administrator on 2017-07-31.
 */
public interface PersonDetailInfoService {
    /**
     * 取个人关联方详细信息
     * @param personId
     * @return
     */
    PersonDetailInfoVO getPersonDetailInfo(String personId) throws Exception;

    /**
     * 判断传入ID 是否为个人
     * @param valueId
     * @return
     * @throws Exception
     */
    Map<String,String> isPerson(String valueId) throws Exception;
}
