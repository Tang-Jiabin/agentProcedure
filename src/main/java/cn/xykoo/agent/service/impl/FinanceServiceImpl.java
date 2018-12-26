package cn.xykoo.agent.service.impl;
import java.util.Date;
import java.util.List;

import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.pojo.RedeemCodeAgent;
import cn.xykoo.agent.pojo.RedeemCodeAgentAccount;
import cn.xykoo.agent.pojo.RedeemCodeAgentBankCard;
import cn.xykoo.agent.pojo.RedeemCodeAgentExtractDetails;
import cn.xykoo.agent.repository.RedeemCodeAgentAccountRepository;
import cn.xykoo.agent.repository.RedeemCodeAgentBankCardRepository;
import cn.xykoo.agent.repository.RedeemCodeAgentExtractDetailsRepository;
import cn.xykoo.agent.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * 财务
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Service
public class FinanceServiceImpl implements FinanceService {


    @Autowired
    private RedeemCodeAgentAccountRepository redeemCodeAgentAccountRepository;
    @Autowired
    private RedeemCodeAgentBankCardRepository redeemCodeAgentBankCardRepository;
    @Autowired
    private RedeemCodeAgentExtractDetailsRepository redeemCodeAgentExtractDetailsRepository;

    @Override
    public synchronized KVResult addBankCardInfo(RedeemCodeAgentBankCard bankCard, Integer agentId) {
        RedeemCodeAgentBankCard bankCardInfo = redeemCodeAgentBankCardRepository.findByAgentId(agentId);

        if (bankCardInfo == null) {
            bankCardInfo = new RedeemCodeAgentBankCard();
            bankCardInfo.setAgentId(agentId);
            bankCardInfo.setName(bankCard.getName());
            bankCardInfo.setCardNo(bankCard.getCardNo());
            bankCardInfo.setOpeningBank(bankCard.getOpeningBank());
            bankCardInfo.setCreateDate(new Date());
            bankCardInfo = redeemCodeAgentBankCardRepository.save(bankCardInfo);
        }else {
            if(bankCard.getBankCardId() != 0 ){
                bankCardInfo.setName(bankCard.getName());
                bankCardInfo.setCardNo(bankCard.getCardNo());
                bankCardInfo.setOpeningBank(bankCard.getOpeningBank());
                bankCardInfo.setCreateDate(new Date());
                bankCardInfo = redeemCodeAgentBankCardRepository.save(bankCardInfo);
            }
        }

        return KVResult.put(HttpStatus.OK,bankCardInfo);
    }

    @Override
    public KVResult applyCash(Integer money, Integer agentId) {

        RedeemCodeAgentExtractDetails extractDetails = redeemCodeAgentExtractDetailsRepository.findByAgentIdAndState(agentId, 1);

        if (extractDetails == null) {

            RedeemCodeAgentAccount redeemCodeAgentAccount = redeemCodeAgentAccountRepository.findByAgentId(agentId);

            if (redeemCodeAgentAccount != null) {
                int balance = redeemCodeAgentAccount.getBalance();
                if(balance<money){
                    return KVResult.put(412,"余额不足");
                }
                extractDetails = new RedeemCodeAgentExtractDetails();
                extractDetails.setAgentId(agentId);
                extractDetails.setMoney(money);
                extractDetails.setExtractionDate(new Date());
                extractDetails.setState(1);
                redeemCodeAgentExtractDetailsRepository.save(extractDetails);
                redeemCodeAgentAccount.setBalance(balance-money);
                redeemCodeAgentAccountRepository.save(redeemCodeAgentAccount);
            }

        }else {
            return KVResult.put(411,"提现审核中，请勿重复提交。");
        }

        return KVResult.put(HttpStatus.OK);
    }

    @Override
    public KVResult extractDetails(Integer agentId) {
        List<RedeemCodeAgentExtractDetails> allByAgentId = redeemCodeAgentExtractDetailsRepository.findAllByAgentId(agentId);
        return KVResult.put(HttpStatus.OK,allByAgentId);
    }

    @Override
    public KVResult getBankCardInfo(Integer agentId) {
        RedeemCodeAgentBankCard bankCardInfo = redeemCodeAgentBankCardRepository.findByAgentId(agentId);

        return KVResult.put(HttpStatus.OK,bankCardInfo);
    }
}
