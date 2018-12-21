package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 兑换码
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/12
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeRepository extends JpaRepository<RedeemCode,Integer>, JpaSpecificationExecutor<RedeemCode> {

    @Query("SELECT redeemCode FROM RedeemCode")
    List<String> findAllRedeemCode();

    @Query("SELECT MAX(sequenceNo) FROM RedeemCode WHERE batchNo =?1")
    Integer findMaxSequenceNoByBatchNo(String batchNo);

    List<RedeemCode> findAllByBatchIdIn(List<Integer> batchIdList);

    List<RedeemCode> findAllBySequenceNoIsGreaterThanEqualAndSequenceNoLessThanEqualAndBatchNo(Integer greater, Integer less, String batchNo);

    List<RedeemCode> findAllByRedeemCodeAgentIdIn(List<Integer> agentIdList);

    List<RedeemCode> findAllByAllotDateIsBetween(Date startDate, Date endDate);

    RedeemCode findByCardNo(String cardNumber);

    List<RedeemCode> findAllByBatchId(Integer batchId);

    List<RedeemCode> findAllByRedeemCodeIdIn(List<Integer> redeemCodeIdList);
}
