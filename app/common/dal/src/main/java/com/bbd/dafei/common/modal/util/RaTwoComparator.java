package com.bbd.dafei.common.modal.util;
import com.bbd.dafei.common.modal.vo.RelationListInfoVO;
import com.bbd.dafei.common.util.Constants;

import java.util.Comparator;

/**
 * 根据不同的参数进行对象排序
 * @author anhong.Tu
 * @version $Id: RaTwoComparator.java, v 0.1 2017/08/04 9:30 anhong.Tu Exp $
 */
public class RaTwoComparator implements Comparator<RelationListInfoVO> {

    private String sortColumn;

    public RaTwoComparator(String sortColumn){
        this.sortColumn = sortColumn;
    }

    @Override
    public int compare(RelationListInfoVO o1, RelationListInfoVO o2) {
        int resultNum = 0;
        if(this.sortColumn.equals(Constants.SORT_COLUMN_BGXX)){//工商变更
            resultNum = o1.getTotalBgxxNum() - o2.getTotalBgxxNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_BLACK)){//黑名单
            resultNum = o1.getTotalBlackNum() - o2.getTotalBlackNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_DISHONESTY)){//失信被执行人
            resultNum = o1.getTotalDishonestyNum() - o2.getTotalDishonestyNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_DOCUMENT)){//诉讼
            resultNum = o1.getTotalDocumentNum() - o2.getTotalDocumentNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_HIGH)){//高风险
            resultNum = o1.getTotalHighNum() - o2.getTotalHighNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_OUT_DEGREE)){//对外投资
            resultNum = o1.getTotalOutDegreeNum() - o2.getTotalOutDegreeNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_PREIVATE_LENDING)){//民间借贷法律文书
            resultNum = o1.getTotalPrivateLendingNum() - o2.getTotalPrivateLendingNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_QYYC)){//经营异常
            resultNum = o1.getTotalQyycNum() - o2.getTotalQyycNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_XZCF)){//行政处罚
            resultNum = o1.getTotalXzcfNum() - o2.getTotalXzcfNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_ZHI_XING)){//被执行人
            resultNum = o1.getTotalZhixingNum() - o2.getTotalZhixingNum();
        }else if(this.sortColumn.equals(Constants.SORT_COLUMN_CATEGORY)){
            resultNum = o1.getCategory() - o2.getCategory();
        }
        return resultNum;
    }
}

