package com.bbd.dafei.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ian.Su
 * @version $Id: Constants.java, v 0.1 2017/4/20 10:38 Ian.Su Exp $
 */
public class Constants {


    //操作手册文件名
    public static final String OPERATION_GUIDE_FILE_NAME = "操作手册.pdf";


    /*
    * 研报状态
    * */
    public static final String REPORT_STATUS_UN_APPLY = "未申请";
    public static final String REPORT_STATUS_MAKING = "生成中";
    public static final String REPORT_STATUS_UN_DOWNLOAD = "未下载";
    public static final String REPORT_STATUS_DOWNLOAD = "已下载";


    // 加入黑名单方式
    /**
     * 0用户加入
     **/
    public static final short BLACKLIST_JOIN_TYPE_USER = 0;
    /**
     * 1网络爬取
     **/
    public static final short BLACKLIST_JOIN_TYPE_NET = 1;
    /**
     * 2后台导入
     **/
    public static final short BLACKLIST_JOIN_TYPE_IMPORT = 2;
    /**
     * 3后台用户加入
     **/
    public static final short BLACKLIST_JOIN_TYPE_MANAGE = 3;


    /**
     * 通讯信息 账户类型
     */
    public static final String RA_COMMUNICATION_INFO_USER_TYPE_ADMIN = "0";//系统账户（邮件发送者）
    public static final String RA_COMMUNICATION_INFO_USER_TYPE_USER = "1";//接收账户

    /**
     * 状态信息
     */
    public static final String DATA_STATUS_EFFECT = "1";//有效
    public static final String DATA_STATUS_UN_EFFECT = "0";//无效


    /**
     * 存储在session中的用户变量名称
     */
    public static final String SESSION_USER = "sessionUser";


    /**
     * 存储在session中的用户变量名称
     */
    public static final String SESSION_INFO = "sessionUserInfo";


    /**
     * 关注类型
     */
    public static final String RA_BACKLIST_FOCUS_TYPE_BALCK = "1";//黑名单
    public static final String RA_BACKLIST_FOCUS_TYPE_FOCUS = "2";//关注
    public static final String RA_BACKLIST_FOCUS_TYPE_MARK = "3";//关注

    /**
     * 企业类型
     */
    public static final String COMPANY_INDUSTRY_P2P = "网络借贷";
    public static final String COMPANY_INDUSTRY_TRADING_PLACE = "交易场所";
    public static final String COMPANY_INDUSTRY_PRIVATE_EQUIT = "私募基金";
    public static final String COMPANY_INDUSTRY_EMERGING_FINANCE = "新兴金融";
    public static final String COMPANY_INDUSTRY_PETTY_LOAN = "小额贷款";
    public static final String COMPANY_INDUSTRY_FIANACING_GUARANTEE = "融资担保";


    /**
     * 用户类型
     */
    public static final Integer USER_TYPE_FRONT = 1;//前台用户
    public static final Integer USER_TYPE_MANAGE = 2;//后台用户

    /*
     * 行业对应权重，对应多个行业时，优先显示一个行业
     * 小额贷款 -> 融资担保 -> 网络借贷 -> 私募基金 -> 交易场所 -> 新兴金融
     */
    public static final Map<String, Integer> INDUSTRY_WEIGHT_MAP = new HashMap<String, Integer>() {{
        put(COMPANY_INDUSTRY_EMERGING_FINANCE, 0);
        put(COMPANY_INDUSTRY_TRADING_PLACE, 1);
        put(COMPANY_INDUSTRY_PRIVATE_EQUIT, 2);
        put(COMPANY_INDUSTRY_P2P, 3);
        put(COMPANY_INDUSTRY_FIANACING_GUARANTEE, 4);
        put(COMPANY_INDUSTRY_PETTY_LOAN, 5);
    }};

    /**
     * 行业code对应描述
     */
    public static final Map<String, String> INDUSTRY_DESCRIBE_MAP = new HashMap<String, String>() {{
        put("A", "农、林、牧、渔服务业");
        put("B", "采矿业");
        put("C", "制造业");
        put("D", "电力、热力、燃气及水生产和供应业");
        put("E", "建筑业");
        put("F", "批发和零售业");
        put("G", "交通运输、仓储和邮政业");
        put("H", "住宿和餐饮业");
        put("I", "信息传输、软件和信息技术服务业");
        put("J", "金融业");
        put("K", "房地产业");
        put("L", "租赁和商务服务业");
        put("M", "科学研究和技术服务业");
        put("N", "水利、环境和公共设施管理业");
        put("O", "居民服务、修理和其他服务业");
        put("P", "教育");
        put("Q", "卫生和社会工作");
        put("R", "文化、体育和娱乐业");
        put("S", "公共管理、社会保障和社会组织");
        put("T", "国际组织");
        put("Z", "其他");
    }};

    /**
     * 关联方列表信息排序栏位
     */
    public static final String SORT_COLUMN_BGXX = "工商变更";//工商变更
    public static final String SORT_COLUMN_BLACK = "黑名单关联方";//黑名单
    public static final String SORT_COLUMN_DISHONESTY = "失信被执行人";//失信被执行人
    public static final String SORT_COLUMN_DOCUMENT = "诉讼";//诉讼
    public static final String SORT_COLUMN_HIGH = "高风险关联方";//高风险
    public static final String SORT_COLUMN_OUT_DEGREE = "对外投资";//对外投资
    public static final String SORT_COLUMN_PREIVATE_LENDING = "民间借贷法律文书";//民间借贷法律文书
    public static final String SORT_COLUMN_QYYC= "经营异常";//经营异常
    public static final String SORT_COLUMN_XZCF = "行政处罚";//行政处罚
    public static final String SORT_COLUMN_ZHI_XING = "被执行人";//被执行人
    public static final String SORT_COLUMN_CATEGORY = "关联度数";//关联度数排序，专供导出EXCEL 使用

    /**
    * 企业详情页面查询类型
    * */
    public static final String QUERY_TPYE_ALL = "全部";//全部
    public static final String QUERY_TYPE_BLACK="黑名单";//黑名单
    public static final String QUERY_TYPE_HIGH="高风险";//高风险
    public static final String QUERY_TYPE_SAME_ADRESS="地址相同";
    public static final String QUERY_TYPE_COMMON_INTERESTS="利益一致";
    public static final String QUERY_TYPE_ESTATE="注吊销";
    public static final String QUERY_TYPE_NEW_FINANCIAL="新金融";
    public static final String QUERY_TYPE_SEARCH="搜索";//搜素接口

    /**
     * 企业详情页面下方关联方列表排序方式
     */
    public static final String SORT_TYPE_DESC ="降序";
    public static final String SORT_TYPE_ASC ="升序";

    /**
     * 导出EXCEL时是否新增常量
     */
    public static final String IS_NEW_YES = "是";
    public static final String IS_NEW_NO = "否";

    /**
     * 风险等级
     */
    public static final String RISK_LEVEL_SUSTAIN_MONITOR = "持续监控";
    public static final String RISK_LEVEL_FOCUS_ON = "重点关注";

}
