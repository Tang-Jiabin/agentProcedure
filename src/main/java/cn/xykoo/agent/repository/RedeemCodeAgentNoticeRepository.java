package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodeAgentNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 兑换码代理商通知
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeAgentNoticeRepository extends JpaRepository<RedeemCodeAgentNotice,Integer> {
    List<RedeemCodeAgentNotice> findAllByAgentId(Integer agentId);
}
