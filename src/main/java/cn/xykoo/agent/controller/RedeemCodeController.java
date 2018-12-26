package cn.xykoo.agent.controller;

import cn.xykoo.agent.common.annotation.Authorization;
import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.common.http.ServerResponse;
import cn.xykoo.agent.service.RedeemCodeServicer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

/**
 * 兑换码
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Api(value = "兑换码", description = "redeemCode")
@RestController
@RequestMapping("/redeemCode")
public class RedeemCodeController {


    @Autowired
    private RedeemCodeServicer redeemCodeServicer;


    @Authorization
    @ApiOperation(value = "本月新增")
    @PostMapping(value = "/getAdded")
    public ServerResponse getAdded(@RequestParam Date start, @RequestParam Date end, @ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = redeemCodeServicer.getAdded(start, end, agentId);
        return ServerResponse.createMessage(result);
    }

    @Authorization
    @ApiOperation(value = "续费")
    @PostMapping(value = "/getRenewal")
    public ServerResponse getRenewal(@ApiParam(value = "1-续费 2-ip") @RequestParam Integer renewalType, @RequestParam Date start, @RequestParam Date end, @ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = redeemCodeServicer.getRenewal(renewalType, start, end, agentId);
        return ServerResponse.createMessage(result);
    }



}
