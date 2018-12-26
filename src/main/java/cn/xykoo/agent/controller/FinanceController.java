package cn.xykoo.agent.controller;

import cn.xykoo.agent.common.annotation.Authorization;
import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.common.http.ServerResponse;
import cn.xykoo.agent.pojo.RedeemCodeAgentBankCard;
import cn.xykoo.agent.service.FinanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 财务
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/24
 * @email : seven_tjb@163.com
 **/
@Api(value = "财务", description = "finance")
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @Authorization
    @ApiOperation(value = "新增银行卡信息")
    @PostMapping(value = "/addBankCardInfo")
    public ServerResponse addBankCardInfo(@ApiParam(value = "id 0-添加 x-修改") @RequestBody RedeemCodeAgentBankCard bankCard, @ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = financeService.addBankCardInfo(bankCard,agentId);
        return ServerResponse.createMessage(result);
    }

    @Authorization
    @ApiOperation(value = "银行卡信息")
    @PostMapping(value = "/getBankCardInfo")
    public ServerResponse getBankCardInfo( @ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = financeService.getBankCardInfo(agentId);
        return ServerResponse.createMessage(result);
    }

    @Authorization
    @ApiOperation(value = "申请提现")
    @PostMapping(value = "/applyCash")
    public ServerResponse applyCash(@ApiParam(value = "提现金额") @RequestParam Integer money, @ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = financeService.applyCash(money,agentId);
        return ServerResponse.createMessage(result);
    }

    @Authorization
    @ApiOperation(value = "提现明细")
    @PostMapping(value = "/extractDetails")
    public ServerResponse extractDetails(@ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = financeService.extractDetails(agentId);
        return ServerResponse.createMessage(result);
    }
}
