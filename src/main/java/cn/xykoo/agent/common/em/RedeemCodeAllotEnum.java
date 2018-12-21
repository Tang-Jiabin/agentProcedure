package cn.xykoo.agent.common.em;

/**
 * 兑换卡分配状态
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/12
 * @email : seven_tjb@163.com
 **/
public enum RedeemCodeAllotEnum {

    /**
     * 全部
     */
    ALL,
    /**
     * 未分配
     */
    UNALLOCATED,
    /**
     * 分配部分
     */
    SOME,
    /**
     * 已分配
     */
    ALREADY_ALLOCATED;
}
