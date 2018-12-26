package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodeAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * 兑换卡代理商
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/13
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeAgentRepository extends JpaRepository<RedeemCodeAgent, Integer>, JpaSpecificationExecutor<RedeemCodeAgent> {

    /**
     * 账号密码查询
     * @param name 账号
     * @param pwd 密码
     * @return 实体
     */
    RedeemCodeAgent findByLoginAccountAndLoginPassword(String name, String pwd);

    /**
     * ID查询
     * @param id ID
     * @return
     */
    RedeemCodeAgent findByRedeemCodeAgentId(Integer id);

    /**
     * 登录
     * @param loginAccount 账号
     * @param loginPassword 密码
     * @param state 状态
     * @return 账户
     */
    RedeemCodeAgent findByLoginAccountAndLoginPasswordAndState(String loginAccount, String loginPassword, int state);
}
