package cn.xykoo.agent.common.token.impl;

import cn.xykoo.agent.common.token.TokenManage;
import cn.xykoo.agent.common.token.TokenModel;
import cn.xykoo.agent.pojo.RedeemCodeAgent;
import cn.xykoo.agent.repository.RedeemCodeAgentRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @author : J.Tang
 * @version : v1.0
 * @email : seven_tjb@163.com
 * @create : 2018-08-29 18:35
 **/
@Service
public class TokenManageImpl implements TokenManage {

    private static final String secret = "AR78{7(53!~3&>5}3}61^~LX,0m";
    private static final String issuer = "www.xykoo.cn";
    private static final String key = "agent";

    @Autowired
    private RedeemCodeAgentRepository redeemCodeAgentRepository;

    @Override
    public TokenModel createToken(Integer userId){
        String token = null;
        try {
            token = JWT.create()
                    .withIssuer(issuer)
                    .withJWTId(UUID.randomUUID().toString().toUpperCase())
                    .withClaim(key, userId)
                    .sign(Algorithm.HMAC256(secret));
        } catch (UnsupportedEncodingException e) {
            token = "error";
        }

        TokenModel model = new TokenModel(userId, token);
        RedeemCodeAgent redeemCodeAgent = redeemCodeAgentRepository.findByRedeemCodeAgentId(userId);
        redeemCodeAgent.setToken(token);
        redeemCodeAgentRepository.save(redeemCodeAgent);

        return model;
    }

    @Override
    public boolean checkToken(String token) throws UnsupportedEncodingException, JWTVerificationException {
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        TokenModel tokenModel = getToken(token);
        String dbtoken = null;
        try {
            RedeemCodeAgent redeemCodeAgent = null;
            if (!StringUtils.isEmpty(tokenModel)) {
                redeemCodeAgent = redeemCodeAgentRepository.findByRedeemCodeAgentId(tokenModel.getUserId());
            }
            if (redeemCodeAgent != null) {
                dbtoken = redeemCodeAgent.getToken();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbtoken != null && token.equals(dbtoken);
    }

    @Override
    public TokenModel getToken(String authentication) throws UnsupportedEncodingException, JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(issuer)
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(authentication);
        Integer adminId = jwt.getClaim(key).asInt();
        return new TokenModel(adminId, jwt.getToken());
    }
}
