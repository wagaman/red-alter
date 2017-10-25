package com.bbd.dafei.biz.shared;

import com.bbd.dafei.common.modal.dto.RelationInfoDTO;
import com.bbd.dafei.common.modal.dto.RelationNowDTO;
import com.bbd.dafei.common.modal.vo.RelationDataVO;

/**
 * 关联方service
 * Created by wish on 2017/4/23.
 */
public interface RelationService {

    /**
     * 根据公司id查询关联信息
     *
     * @param companyId 公司id
     * @return
     * @throws Exception
     */
    RelationInfoDTO getRelationInfoByCompanyId(String companyId) throws Exception;

    /**
     * 根据数据平台公司id查询关联方信息
     *
     * @param qyxxId 数据平台公司id
     * @param degree 关联度
     * @return
     * @throws Exception
     */
    RelationNowDTO.RelationData getRelationDataByQyxxIdAndDegree(String qyxxId, int degree) throws Exception;

    /**
     * 根据公司id和关联度查询关联方节点和连线
     *
     * @param qyxxId 数据平台公司id
     * @param degree 关联度
     * @return
     */
    RelationDataVO getRelationNodesAndLinks(String qyxxId, int degree) throws Exception;
}
