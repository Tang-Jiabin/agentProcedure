package cn.xykoo.agent.service.impl;

import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.pojo.RedeemCodeAgentNotice;
import cn.xykoo.agent.pojo.RedeemCodePurchaseRecord;
import cn.xykoo.agent.repository.RedeemCodeAgentNoticeRepository;
import cn.xykoo.agent.repository.RedeemCodePurchaseRecordRepository;
import cn.xykoo.agent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代理商通知
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private RedeemCodeAgentNoticeRepository redeemCodeAgentNoticeRepository;
    @Autowired
    private RedeemCodePurchaseRecordRepository redeemCodePurchaseRecordRepository;

    @Override
    public KVResult getNotice(Integer agentId) {
        List<RedeemCodeAgentNotice> noticeList = redeemCodeAgentNoticeRepository.findAllByAgentId(agentId);

        return KVResult.put(noticeList);
    }

    @Override
    public KVResult getPurchaseRecord(Integer agentId) {

        List<RedeemCodePurchaseRecord> purchaseRecordList = redeemCodePurchaseRecordRepository.findAllByAgentId(agentId);

        return KVResult.put(HttpStatus.OK,purchaseRecordList);
    }
}
