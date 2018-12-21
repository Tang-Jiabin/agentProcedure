package cn.xykoo.agent.pojo;

import cn.xykoo.agent.common.em.RedeemCodeAllotEnum;
import cn.xykoo.agent.common.em.RedeemCodePrintEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 兑换码批次
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/12
 * @email : seven_tjb@163.com
 **/
@Data
@Entity
@Table(name = "yiku_redeem_code_batch")
public class RedeemCodeBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer batchId;

    /**
     * 批次制卡日期
     */
    private String batchDate;

    /**
     * 批次制卡总数
     */
    private Integer batchCount;

    /**
     * 印制状态 0-全部 1-未打印 2-已打印
     */
    @Column(name="print_enum" ,nullable=false,columnDefinition="INT default 1")
    private RedeemCodePrintEnum printEnum;

    /**
     * 起始卡号
     */
    private String initialCardNumber;

    /**
     * 结束卡号
     */
    private String endCardNumber;

    /**
     * 分配状态 0-全部 1-未分配 2-分配部分 3-已分配
     */
    @Column(name="allot_enum" ,nullable=false,columnDefinition="INT default 1")
    private RedeemCodeAllotEnum allotEnum;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 添加日期
     */
    private Date createDate;

    /**
     * 管理ID
     */
    private Integer adminId;

}
