package com.bbd.dafei.common.modal.util;

import com.bbd.dafei.common.modal.dto.YearReportDTO;
import com.bbd.dafei.common.modal.vo.YearReportVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 年报工具类
 * Created by wish on 2017/4/20.
 */
public class YearReportUtil {
    /**
     * 将年报DTO转化为年报VO
     * @param yearReportDTO
     * @return
     * @throws Exception
     */
    public static List<YearReportVO> transYearReportDTOToVO(YearReportDTO yearReportDTO) throws Exception{
        Map<String,YearReportVO> yearReportVOMap = new HashMap<String,YearReportVO>();
        List<YearReportVO> yearReportVOList = new ArrayList<YearReportVO>();
        if(yearReportDTO != null) {
            setListToYearReportVO("qyxxNbJbxx", yearReportVOMap, YearReportVO.Jbxx.class, yearReportDTO.getQyxxNbJbxx());
            setListToYearReportVO("qyxxNbXgxx", yearReportVOMap, YearReportVO.Xgxx.class, yearReportDTO.getQyxxNbXgxx());
            setListToYearReportVO("qyxxNbTzxx", yearReportVOMap, YearReportVO.Tzxx.class, yearReportDTO.getQyxxNbTzxx());
            setListToYearReportVO("qyxxNbBgxx", yearReportVOMap, YearReportVO.Bgxx.class, yearReportDTO.getQyxxNbBgxx());
            setListToYearReportVO("qyxxNbDbxx", yearReportVOMap, YearReportVO.Dbxx.class, yearReportDTO.getQyxxNbDbxx());
            setListToYearReportVO("qyxxNbFzjg", yearReportVOMap, YearReportVO.Fzjg.class, yearReportDTO.getQyxxNbFzjg());
            setListToYearReportVO("qyxxNbXzxk", yearReportVOMap, YearReportVO.Xzxk.class, yearReportDTO.getQyxxNbXzxk());
            setListToYearReportVO("qyxxNbGzsm", yearReportVOMap, YearReportVO.Gzsm.class, yearReportDTO.getQyxxNbGzsm());
            setListToYearReportVO("qyxxNbCzxx", yearReportVOMap, YearReportVO.Czxx.class, yearReportDTO.getQyxxNbCzxx());
            setListToYearReportVO("qyxxNbWzxx", yearReportVOMap, YearReportVO.Wzxx.class, yearReportDTO.getQyxxNbWzxx());
            setListToYearReportVO("qyxxNbZcxx", yearReportVOMap, YearReportVO.Zcxx.class, yearReportDTO.getQyxxNbZcxx());
            Collection<YearReportVO> yearReportVOCollection = yearReportVOMap.values();
            yearReportVOList = new ArrayList<YearReportVO>(yearReportVOCollection);
            yearReportVOList.sort(Comparator.comparingInt(yearReportVO ->  Integer.valueOf(yearReportVO.getYear())));
        }
        return yearReportVOList;
    }

    /**
     * 遍历年报dto中的属性，设置到对应年的年报VO中
     * @param voFiedName 年报vo中的属性名
     * @param yearReportVOMap 年对应年报VO的映射
     * @param voClazz 年报VO中的list属性中的类型
     * @param dtos 年报DTO中的属性集合
     * @param <T> DTO类型
     * @throws Exception
     */
    private static <T> void setListToYearReportVO(String voFiedName, Map<String,YearReportVO> yearReportVOMap, Class voClazz, List<T> dtos) throws Exception {
        if(CollectionUtils.isEmpty(dtos)) {
            return;
        }
        Class clazz = YearReportVO.class;
        voFiedName = StringUtils.capitalize(voFiedName);
        Method setMethod = clazz.getMethod("set" + voFiedName, List.class);
        Method getMethod = clazz.getMethod("get" + voFiedName);

        Class dtoClazz = dtos.get(0).getClass();
        Method getYearMethod = dtoClazz.getMethod("getYear");
        for (T dto : dtos) {
            if(dto == null) {
                continue;
            }
            String year = (String) getYearMethod.invoke(dto);
            YearReportVO yearReportVO = yearReportVOMap.get(year);
            if(yearReportVO == null) {
                yearReportVO = new YearReportVO();
                yearReportVO.setYear(year);
                yearReportVOMap.put(year,yearReportVO);
            }
            List list = (List)getMethod.invoke(yearReportVO);
            if(list == null) {
                list = new ArrayList();
                setMethod.invoke(yearReportVO, list);
            }

            Object vo = voClazz.newInstance();
            PropertyUtils.copyProperties(vo, dto);
            list.add(vo);
        }
    }
}
