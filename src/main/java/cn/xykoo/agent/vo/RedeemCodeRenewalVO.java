package cn.xykoo.agent.vo;

import cn.xykoo.agent.common.em.CardTypeEnum;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 兑换码续费
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/26
 * @email : seven_tjb@163.com
 **/
@Data
public class RedeemCodeRenewalVO {

    /**
     * 续费ID
     */
    private Integer renewalId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 兑换卡ID
     */
    private Integer redeemCodeId;

    /**
     * 兑换卡代理商ID
     */
    private Integer redeemCodeAgentId;

    /**
     * 用户续费日期
     */
    private Date createDate;

    /**
     * 用户续费会员卡类型
     */
    private CardTypeEnum cardType;

    /**
     * 续费金额
     */
    private String renewalAmount;

    /**
     * 提成金额
     */
    private Integer commission;

    /**
     * 提成类型 1-续费 2-ip
     */
    private Integer royaltyType;

    /**
     * 手机号
     */
    private String phone;
}
