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

    private Integer agentId;

    private String money;

    private String type;

    private String userPhone;

    private String cardNo;

    private Date date;
}
