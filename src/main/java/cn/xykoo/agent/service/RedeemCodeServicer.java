package cn.xykoo.agent.service;

import cn.xykoo.agent.common.http.KVResult;

import java.util.Date;

/**
 * 兑换码
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
public interface RedeemCodeServicer {
    /**
     * 获取新增
     * @param start 开始日期
     * @param end 结束日期
     * @param agentId 代理商id
     * @return 新增结果
     */
    KVResult getAdded(Date start, Date end, Integer agentId);

    /**
     * 获取续费
     * @param renewalType 续费类型 1-续费 2-ip
     * @param start 开始日期
     * @param end 结束日期
     * @param agentId 代理商ID
     * @return 结果
     */
    KVResult getRenewal(Integer renewalType, Date start, Date end, Integer agentId);

}
