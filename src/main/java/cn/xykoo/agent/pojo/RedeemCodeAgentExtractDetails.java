package cn.xykoo.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 兑换码代理商提取明细
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/25
 * @email : seven_tjb@163.com
 **/
@Data
@Entity
@Table(name = "yiku_redeem_code_agent_extract_details")
public class RedeemCodeAgentExtractDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer extractDetailsId;

    /**
     * 代理商ID
     */
    private Integer agentId;

    /**
     * 提现金额
     */
    private Integer money;

    /**
     * 提现日期
     */
    private Date extractionDate;

    /**
     * 提现状态 1-对账中 2-已提现
     */
    private Integer state;

}
