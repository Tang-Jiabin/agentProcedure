package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodePurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 兑换码采购记录
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodePurchaseRecordRepository extends JpaRepository<RedeemCodePurchaseRecord,Integer> {
    /**
     * 查询代理商购卡记录
     * @param agentId 代理商ID
     * @return 购卡记录
     */
    List<RedeemCodePurchaseRecord> findAllByAgentId(Integer agentId);
}
