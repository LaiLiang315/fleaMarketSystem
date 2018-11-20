package com.fleaMarket.loginRegister.service;

import com.fleaMarket.domain.user;

/**
 * 登陆注册的service层
 * 
 * @author LL
 *
 */
public interface LoginRegisterService {
	/**
	 * 登陆
	 * 
	 * @param newUser
	 * @return
	 */
	public user login(user newUser);
    /**
     * 注册
     * @return
     */
	public user userRegister(user newUser);
	/**
	 * 跟据用户名查询用户
	 * @param username
	 * @return
	 */
	public user getUserByUserName(user newUser);

}
