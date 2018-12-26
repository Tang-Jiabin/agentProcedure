package cn.xykoo.agent.vo;

import cn.xykoo.agent.common.em.PayStatusEnum;
import cn.xykoo.agent.common.em.RedeemCodeAllotEnum;
import lombok.Data;

import java.util.Date;

/**
 * 兑换码
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/26
 * @email : seven_tjb@163.com
 **/
@Data
public class RedeemCodeVO {

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
    private Integer redeemCodeAgentId;

    /**
     * 分配时间
     */
    private Date allotDate;

    /**
     * 分配状态 0-全部 1-未分配 2-分配部分 3-已分配
     */
    private RedeemCodeAllotEnum allotEnum;

    /**
     * 激活用户ID
     */
    private Integer userId;

    /**
     * 激活状态 1-已激活 2-未激活
     */
    private Integer activationState;

    /**
     * 激活时间
     */
    private Date activationTime;

    /**
     * 激活用户付费状态 0-未付费 1-已付费
     */
    private PayStatusEnum payStatusEnum;

    /**
     * 手机号
     */
    private String phone;
}
