package cn.xykoo.agent.service.impl;

import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.service.NoticeService;
import com.google.common.collect.Lists;
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
    @Override
    public KVResult getNotice(Integer agentId) {
        List list = Lists.newArrayList();

        return KVResult.put(list);
    }
}
