package cn.xykoo.agent.controller;

import cn.xykoo.agent.common.annotation.Authorization;
import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.common.http.ServerResponse;
import cn.xykoo.agent.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 通知
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
@Api(value = "通知", description = "notice")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Authorization
    @ApiOperation(value = "消息")
    @GetMapping(value = "/getNotice")
    public ServerResponse getNotice(@ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = noticeService.getNotice(agentId);
        return ServerResponse.createMessage(result);
    }

    @Authorization
    @ApiOperation(value = "获取采购记录")
    @GetMapping(value = "/getPurchaseRecord")
    public ServerResponse getPurchaseRecord(@ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = noticeService.getPurchaseRecord(agentId);
        return ServerResponse.createMessage(result);
    }
}
