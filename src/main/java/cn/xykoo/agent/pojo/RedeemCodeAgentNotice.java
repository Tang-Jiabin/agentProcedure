package cn.xykoo.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 兑换码代理商通知
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
@Data
@Entity
@Table(name = "yiku_redeem_code_agent_notice")
public class RedeemCodeAgentNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId;
    /**
     * 代理商ID
     */
    private Integer agentId;

    /**
     * 钱数
     */
    private String money;

    /**
     * 类型
     */
    private String type;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 日期
     */
    private Date date;

    /**
     * 状态 1-未读  2-已读
     */
    private Integer state;
}
