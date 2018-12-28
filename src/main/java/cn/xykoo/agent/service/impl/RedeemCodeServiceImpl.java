package cn.xykoo.agent.service.impl;

import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.pojo.RedeemCode;
import cn.xykoo.agent.pojo.RedeemCodeRenewal;
import cn.xykoo.agent.pojo.User;
import cn.xykoo.agent.repository.RedeemCodeRenewalRepository;
import cn.xykoo.agent.repository.RedeemCodeRepository;
import cn.xykoo.agent.repository.UserRepository;
import cn.xykoo.agent.service.RedeemCodeServicer;
import cn.xykoo.agent.utils.BeanUtil;
import cn.xykoo.agent.vo.RedeemCodeRenewalVO;
import cn.xykoo.agent.vo.RedeemCodeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 兑换码
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Service
public class RedeemCodeServiceImpl  implements RedeemCodeServicer {


    @Autowired
    private RedeemCodeRepository redeemCodeRepository;
    @Autowired
    private RedeemCodeRenewalRepository redeemCodeRenewalRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public KVResult getAdded(Date start, Date end, Integer agentId) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<RedeemCode> redeemCodeList = redeemCodeRepository.findAllByRedeemCodeAgentIdAndActivationTimeBetweenAndActivationState(agentId, start, end,1);

        List<Integer> userIdList = new ArrayList<>();
        for (RedeemCode redeemCode : redeemCodeList) {
            if(redeemCode.getUserId()!=null && redeemCode.getUserId() != 0){
                userIdList.add(redeemCode.getUserId());
            }
        }
        List<User> userList = userRepository.findAllByUserIdIn(userIdList);

        List<RedeemCodeVO> redeemCodeVOList = new ArrayList<>();
        RedeemCodeVO redeemCodeVO;
        for (RedeemCode redeemCode : redeemCodeList) {
            System.out.println(redeemCode.getActivationTime().getTime());
            System.out.println(sf.format(redeemCode.getActivationTime()));

            redeemCodeVO = new RedeemCodeVO();
            BeanUtils.copyProperties(redeemCode,redeemCodeVO);
            for (User user : userList) {
                if(redeemCode.getUserId().equals(user.getUserId())){
                    redeemCodeVO.setPhone(user.getPhone());
                }
            }
            System.out.println(sf.format(redeemCodeVO.getActivationTime()));
            System.out.println("-------");

            redeemCodeVOList.add(redeemCodeVO);
        }

        return KVResult.put(HttpStatus.OK,redeemCodeVOList);
    }

    @Override
    public KVResult getRenewal(Integer renewalType, Date start, Date end, Integer agentId) {

        List<RedeemCodeRenewal> renewalList = redeemCodeRenewalRepository.findAllByRedeemCodeAgentIdAndRoyaltyTypeAndCreateDateIsBetween(agentId, renewalType, start, end);

        List<Integer> userIdList = new ArrayList<>();
        for (RedeemCodeRenewal redeemCodeRenewal : renewalList) {
            if(redeemCodeRenewal.getUserId()!=null && redeemCodeRenewal.getUserId() != 0){
                userIdList.add(redeemCodeRenewal.getUserId());
            }
        }
        List<User> userList = userRepository.findAllByUserIdIn(userIdList);

        List<RedeemCodeRenewalVO> redeemCodeVOList = new ArrayList<>();
        RedeemCodeRenewalVO redeemCodeRenewalVO;
        for (RedeemCodeRenewal redeemCodeRenewal : renewalList) {
            redeemCodeRenewalVO = new RedeemCodeRenewalVO();
            BeanUtils.copyProperties(redeemCodeRenewal,redeemCodeRenewalVO);
            for (User user : userList) {
                if(redeemCodeRenewal.getUserId().equals(user.getUserId())){
                    redeemCodeRenewalVO.setPhone(user.getPhone());
                }
            }
            redeemCodeVOList.add(redeemCodeRenewalVO);
        }

        return KVResult.put(HttpStatus.OK,redeemCodeVOList);
    }
}
