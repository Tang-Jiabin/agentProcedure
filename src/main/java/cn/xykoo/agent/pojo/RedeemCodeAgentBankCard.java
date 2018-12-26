package cn.xykoo.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 兑换码代理商银行卡信息
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Data
@Entity
@Table(name = "yiku_redeem_code_agent_bank_card")
public class RedeemCodeAgentBankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bankCardId;

    /**
     * 代理商ID
     */
    private Integer agentId;

    /**
     * 开户名称
     */
    private String name;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 开户行
     */
    private String openingBank;

    /**
     * 添加日期
     */
    private Date createDate;
}
