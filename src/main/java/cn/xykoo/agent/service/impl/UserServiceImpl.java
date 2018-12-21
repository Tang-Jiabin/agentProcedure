package cn.xykoo.agent.service.impl;

import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.common.token.TokenManage;
import cn.xykoo.agent.common.token.TokenModel;
import cn.xykoo.agent.pojo.RedeemCodeAgent;
import cn.xykoo.agent.pojo.RedeemCodeAgentAccount;
import cn.xykoo.agent.repository.RedeemCodeAgentAccountRepository;
import cn.xykoo.agent.repository.RedeemCodeAgentRepository;
import cn.xykoo.agent.service.UserService;
import cn.xykoo.agent.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedeemCodeAgentRepository redeemCodeAgentRepository;
    @Autowired
    private RedeemCodeAgentAccountRepository redeemCodeAgentAccountRepository;

    @Autowired
    private TokenManage tokenManage;

    @Override
    public KVResult signIn(String name, String password) {

        RedeemCodeAgent redeemCodeAgent = redeemCodeAgentRepository.findByLoginAccountAndLoginPassword(name,password);

        TokenModel token = null;
        if (redeemCodeAgent != null) {
            token = tokenManage.createToken(redeemCodeAgent.getRedeemCodeAgentId());
        }else {
            return KVResult.put(411,"账号或密码错误！");
        }

        return KVResult.put(HttpStatus.OK,token);
    }

    @Override
    public KVResult changePassword(Integer agentId, String password) {
        RedeemCodeAgent redeemCodeAgent = redeemCodeAgentRepository.findByRedeemCodeAgentId(agentId);
        if (password.length()<6) {
            return KVResult.put(411,"密码长度不能少于6位");
        }
        redeemCodeAgent.setLoginPassword(password);
        redeemCodeAgentRepository.save(redeemCodeAgent);
        return KVResult.put(HttpStatus.OK);
    }

    @Override
    public KVResult getUserInfo(Integer agentId) {

        RedeemCodeAgentAccount redeemCodeAgentAccount = redeemCodeAgentAccountRepository.findByAgentId(agentId);

        UserVO userVO = new UserVO();
        if (redeemCodeAgentAccount != null) {
            BeanUtils.copyProperties(redeemCodeAgentAccount,userVO);
        }


        return KVResult.put(HttpStatus.OK,userVO);
    }
}
