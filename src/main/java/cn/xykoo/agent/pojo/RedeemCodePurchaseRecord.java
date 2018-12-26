package cn.xykoo.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 兑换码采购记录
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Data
@Entity
@Table(name = "yiku_redeem_code_purchase_record")
public class RedeemCodePurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    /**
     * 代理商ID
     */
    private Integer agentId;

    /**
     * 购买日期
     */
    private Date purchase;

    /**
     * 总数
     */
    private Integer count;

    /**
     * 起始卡号
     */
    private String initialCardNumber;

    /**
     * 结束卡号
     */
    private String endCardNumber;

}
