package cn.xykoo.agent.service;

import cn.xykoo.agent.common.http.KVResult;

/**
 * 代理商通知
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
public interface NoticeService {
    /**
     * 获取通知
     * @param agentId 代理商ID
     * @return 消息
     */
    KVResult getNotice(Integer agentId);

    /**
     * 获取采购记录
     * @param agentId 代理商ID
     * @return 采购记录
     */
    KVResult getPurchaseRecord(Integer agentId);
}
