package cn.xykoo.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 兑换卡代理商
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/13
 * @email : seven_tjb@163.com
 **/
@Data
@Entity
@Table(name = "yiku_redeem_code_agent")
public class RedeemCodeAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer redeemCodeAgentId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 状态 1-启用 2-禁用
     */
    private Integer state;

    /**
     * 登录账号
     */
    private String loginAccount;

    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * token
     */
    private String token;

}
