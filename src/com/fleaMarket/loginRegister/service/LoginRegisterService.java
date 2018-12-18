package com.fleaMarket.loginRegister.service;

import com.fleaMarket.domain.user;
import com.fleaMarket.loginRegister.VO.UserVO;

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
	/**
	 * 更新session
	 * @param newUser
	 * @return
	 */
	public user updataSess(user newUser);
	/**
	 * 用户列表分页
	 * @return
	 */
	public UserVO getUserVO();
	/**
	 * 封禁用户
	 * @param idList
	 * @return
	 */
	public String deleteUser(String idList);
	//解除封禁用户
	public String unDeleteUser(String idList);

}
