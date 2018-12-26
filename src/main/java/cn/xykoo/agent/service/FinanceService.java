package cn.xykoo.agent.service;

import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.pojo.RedeemCodeAgentBankCard;

/**
 * 财务
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
public interface FinanceService {
    /**
     * 添加会员卡信息
     * @param bankCard 会员卡信息
     * @param agentId 代理商Id
     * @return 添加状态
     */
    KVResult addBankCardInfo(RedeemCodeAgentBankCard bankCard, Integer agentId);

    /**
     * 提取现金
     * @param money 提取金额
     * @param agentId 代理商ID
     * @return 提取状态
     */
    KVResult applyCash(Integer money, Integer agentId);

    /**
     * 提现明细
     * @param agentId 代理商ID
     * @return 明细
     */
    KVResult extractDetails(Integer agentId);

    /**
     * 获取银行卡信息
     * @param agentId 代理商ID
     * @return 银行卡信息
     */
    KVResult getBankCardInfo(Integer agentId);
}
