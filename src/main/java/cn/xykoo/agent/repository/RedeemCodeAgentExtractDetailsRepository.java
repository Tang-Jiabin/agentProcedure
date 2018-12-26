package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodeAgentExtractDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 代理商提现申请
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/25
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeAgentExtractDetailsRepository extends JpaRepository<RedeemCodeAgentExtractDetails,Integer> {
    RedeemCodeAgentExtractDetails findByAgentIdAndState(Integer agentId, int state);

    List<RedeemCodeAgentExtractDetails> findAllByAgentId(Integer agentId);
}
