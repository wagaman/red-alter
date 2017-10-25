package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.vo.RelationListInfoVO;
import com.bbd.dafei.common.modal.vo.RelationTotalInfoVO;

import java.util.List;

/**
 * Created by Administrator on 2017-07-25.
 */
public interface RelationTotalInfoService {

    /**
     * 查询企业详情右侧关联方数据
     * @param companyId
     */
    RelationTotalInfoVO getRightRelation(String companyId) throws Exception;
     /**
     *取得企业详情页面-下方关联方列表信息
     * @param companyId
     * @param degree
     * @param type
     * @param companyIdList
     * @param sortColumn
     * @param sortType
      *@param isSort
     * @return
     * @throws Exception
     */
    List<RelationListInfoVO> queryBottomRelationInfo(String companyId, int degree, String type, String companyIdList,String sortColumn,String sortType,int isSort) throws Exception;

    /**
     * 取得导出Excel的资料
     * @param companyId
     * @param degree
     * @param type
     * @return
     * @throws Exception
     */
    List<RelationListInfoVO> getDataForExcel(String companyId,int degree,String type) throws Exception;
}
