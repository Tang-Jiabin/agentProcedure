package cn.xykoo.agent.pojo;

import cn.xykoo.agent.common.em.PayStatusEnum;
import cn.xykoo.agent.common.em.RedeemCodeAllotEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * 兑换卡
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/12
 * @email : seven_tjb@163.com
 **/
@Accessors(chain = true)
@Data
@Entity
@Table(name = "yiku_redeem_code")
public class RedeemCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer redeemCodeId;

    /**
     * 批次ID
     */
    private Integer batchId;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 兑换码
     */
    private String redeemCode;

    /**
     * 批次号 (YK1812)
     */
    private String batchNo;

    /**
     * 顺序号 （10001）
     */
    private Integer sequenceNo;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 兑换码代理商ID
     */
    @Column(name="redeem_code_agent_id" ,nullable=false,columnDefinition="INT default 0")
    private Integer redeemCodeAgentId;

    /**
     * 分配时间
     */
    private Date allotDate;

    /**
     * 分配状态 0-全部 1-未分配 2-分配部分 3-已分配
     */
    @Column(name="allot_enum" ,nullable=false,columnDefinition="INT default 1")
    private RedeemCodeAllotEnum allotEnum;

    /**
     * 激活用户ID
     */
    @Column(name="user_id" ,nullable=false,columnDefinition="INT default 0")
    private Integer userId;

    /**
     * 激活状态 1-已激活 2-未激活
     */
    @Column(name="activation_state" ,nullable=false,columnDefinition="INT default 2")
    private Integer activationState;

    /**
     * 激活时间
     */
    private Date activationTime;

    /**
     * 激活用户付费状态 0-未付费 1-已付费
     */
    private PayStatusEnum payStatusEnum;


}
