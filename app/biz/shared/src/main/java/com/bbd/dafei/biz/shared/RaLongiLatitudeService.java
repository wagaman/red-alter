package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.dal.po.RaLongiLatitudePO;

import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: RaLongiLatitudeService.java, v 0.1 2017/4/25 16:32 Ian.Su Exp $
 */
public interface RaLongiLatitudeService {

    List<RaLongiLatitudePO> query(String province,String city,String area);

}
