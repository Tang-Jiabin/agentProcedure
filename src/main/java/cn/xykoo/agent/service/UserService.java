package cn.xykoo.agent.service;

import cn.xykoo.agent.common.http.KVResult;

/**
 * 用户
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
public interface UserService {
    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return 登录结果
     */
    KVResult signIn(String name, String password);

    /**
     * 修改密码
     *
     * @param agentId 代理商ID
     * @param password 密码
     * @return
     */
    KVResult changePassword(Integer agentId, String password);

    /**
     * 获取用户信息
     * @param agentId 代理ID
     * @return 用户信息
     */
    KVResult getUserInfo(Integer agentId);
}
