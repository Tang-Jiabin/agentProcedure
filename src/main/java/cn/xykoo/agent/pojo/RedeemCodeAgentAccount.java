package cn.xykoo.agent.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 代理商账户
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
@Data
@Entity
@Table(name = "yiku_redeem_code_agent_account")
public class RedeemCodeAgentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    /**
     * 代理商ID
     */
    private Integer agentId;

    /**
     * 账户余额
     */
    private Integer balance;

    /**
     * 总卡数
     */
    private Integer cardTotal;

    /**
     * 激活卡数
     */
    private Integer activationCard;
}
