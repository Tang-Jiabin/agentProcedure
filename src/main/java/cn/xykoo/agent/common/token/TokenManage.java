package cn.xykoo.agent.common.token;

import com.auth0.jwt.exceptions.JWTVerificationException;

import java.io.UnsupportedEncodingException;

public interface TokenManage {

    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(Integer userId);

    /**
     * 检查token是否有效
     *
     */
    public boolean checkToken(String token) throws UnsupportedEncodingException,JWTVerificationException;

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication) throws UnsupportedEncodingException,JWTVerificationException;

}
