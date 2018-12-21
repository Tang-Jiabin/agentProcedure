package cn.xykoo.agent.common.order;

/**
 * 订单状态
 *
 * @author : J.Tang
 * @version : v1.0
 * @email : seven_tjb@163.com
 * @create : 2018-09-12 10:36
 **/

public class OrderState {

    /**
     * 0-全部
     */
    public static final int ALL = 0;

    /**
     * 1-待分拣
     */
    public static final int TO_BE_SORTED = 1;

    /**
     * 2-待审核
     */
    public static final int TO_BE_AUDITED = 2;

    /**
     * 3-待出库
     */
    public static final int TO_BE_OUT_OF_STORAGE = 3;

    /**
     * 4-待发货
     */
    public static final int TO_BE_SHIPPED = 4;

    /**
     * 5-代签收（发货）
     */
    public static final int TO_BE_SIGNED = 5;

    /**
     * 6-待归还
     */
    public static final int TO_BE_RETURNED = 6;

    /**
     * 7-已预约
     */
    public static final int HAS_BEEN_RESERVED = 7;

    /**
     * 8-预约成功
     */
    public static final int IS_SUCCESSFULLY_BOOKED = 8;

    /**
     * 9-归还中（可以下单）
     */
    public static final int RETURN = 9;

    /**
     * 10-审核
     */
    public static final int AUDIT = 10;

    /**
     * 11-完成（退款）
     */
    public static final int COMPLETION = 11;

    /**
     * 12-异常
     */
    public static final int ANOMALY = 12;

    /**
     * 13-删除
     */
    public static final int DELETING = 13;
}
