package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodeAgentBankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 兑换码代理上银行卡信息
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeAgentBankCardRepository  extends JpaRepository<RedeemCodeAgentBankCard,Integer> {

    /**
     * 查询代理商
     * @param agentId 代理商ID
     * @return 代理商银行卡信息
     */
    RedeemCodeAgentBankCard findByAgentId(Integer agentId);
}
