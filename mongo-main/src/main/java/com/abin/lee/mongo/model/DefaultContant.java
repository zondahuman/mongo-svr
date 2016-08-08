/**
 * 
 */
package com.abin.lee.mongo.model;

/**
 * @author lining
 */
public class DefaultContant {
    public static final String PL_10 = "100001";// 新增
    public static final String PL_10_UPDATE = "100002";// 修改记录
    public static final String PL_10_DELETE = "100003";// 删除记录

    public static final String PL_15 = "150001";// 身份证
    public static final String PL_23 = "230044";// 投放区域 -其他
    public static final String PL_24 = "240001";// 信用
    public static final String PL_25_MONTH = "250001";// 贷款期限-一个月以内
    public static final String PL_25_QUARTER = "250002";// 贷款期限-1～3个月
    public static final String PL_25_HALF_YEAR = "250003";// 贷款期限-3～6个月
    public static final String PL_25_YEAR = "250004";// 贷款期限-半年以上
    public static final String PL_25_YEAR_MORE = "250005";// 贷款期限-1年以上
    public static final String PL_26 = "260002";// 消费
    public static final String PL_27 = "270006";// 计息模式-等额本息
    public static final String PL_28 = "280003";// 个人消费贷款
    public static final String PL_29 = "290009";// 投放行业-其它
    public static final String PL_40 = "400001";// 法院
    public static final String PL_41 = "410001";// 个人贷款
    public static final String PL_43 = "430005";// 扣款方式- 其他
    public static final String PL_48 = "480001";// 个人
    public static final String PL_49_ENABLE = "490001";// 有效
    public static final String PL_49_TERMINATE = "490002";// 终止
    public static final String PL_51 = "510001";// 五星分类-正常
    public static final String PL_52 = "520001";// 固定利率
    public static final String PL_53 = "530001";// “自营”
    public static final String PL_54 = "540002";// 发放状态-已发放
    public static final String PL_55_NOLMAL = "550001";// 正常回款
    public static final String PL_55_OVERDUE = "550002";// 逾期回款
    public static final String PL_73 = "730001";// 人民币
    public static final String PL_74 = "740002";// 否

    /**
     * 根据系统的分期期数，获取上报报文对应的贷款期限值
     * 
     * @param term
     * @return
     */
    public static String getLoanTerm(int term) {
        String PL_25 = "";
        if (term == 1) {
            PL_25 = PL_25_MONTH;
        } else if (term <= 3) {
            PL_25 = PL_25_QUARTER;
        } else if (term <= 6) {
            PL_25 = PL_25_HALF_YEAR;
        } else if (term <= 12) {
            PL_25 = PL_25_YEAR;
        } else {
            PL_25 = PL_25_YEAR_MORE;
        }
        return PL_25;
    }
}
