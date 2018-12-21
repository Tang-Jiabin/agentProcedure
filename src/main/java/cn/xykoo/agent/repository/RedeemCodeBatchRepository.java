package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodeBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 兑换码批次
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/12
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeBatchRepository extends JpaRepository<RedeemCodeBatch,Integer>, JpaSpecificationExecutor<RedeemCodeBatch> {

    RedeemCodeBatch findByBatchDate(String batchDate);

}
