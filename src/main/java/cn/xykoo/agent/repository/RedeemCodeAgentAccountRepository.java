package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodeAgentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 兑换卡代理商资金账户
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeAgentAccountRepository extends JpaRepository<RedeemCodeAgentAccount,Integer> {
    /**
     * 代理商ID查询
     * @param agentId 代理商ID
     * @return 账户
     */
    RedeemCodeAgentAccount findByAgentId(Integer agentId);
}
