package cn.xykoo.agent.repository;

import cn.xykoo.agent.pojo.RedeemCodeRenewal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 兑换卡续费用户
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/17
 * @email : seven_tjb@163.com
 **/
@Repository
public interface RedeemCodeRenewalRepository extends JpaRepository<RedeemCodeRenewal,Integer>, JpaSpecificationExecutor<RedeemCodeRenewal> {

    List<RedeemCodeRenewal> findAllByCreateDateIsBetween(Date startDate, Date endDate);

}
