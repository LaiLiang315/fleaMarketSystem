package com.fleaMarket.loginRegister.service.impl;

import com.fleaMarket.domain.user;
import com.fleaMarket.loginRegister.dao.LoginRegisterDao;
import com.fleaMarket.loginRegister.service.LoginRegisterService;

import util.BuildUuid;
import util.TimeUtil;

/**
 * 登录注册的service实现层
 * 
 * @author LL
 *
 */
public class LoginRegisterServiceImpl implements LoginRegisterService {

	private LoginRegisterDao loginRegisterDao;

	public LoginRegisterDao getLoginRegisterDao() {
		return loginRegisterDao;
	}

	public void setLoginRegisterDao(LoginRegisterDao loginRegisterDao) {
		this.loginRegisterDao = loginRegisterDao;
	}

	@Override
	public user login(user newUser) {
		if (newUser != null) {
			user user = new user();
			user = loginRegisterDao.getUserByUserName(newUser.getUsername());
			System.out.println("1:" + newUser.getPassword());
			if (user != null) {
				if (user.getPassword().equals(newUser.getPassword())) {
					System.out.println("ioioioio");
					return user;
				}
				return null;
			}
		}
		return null;
	}

	/**
	 * 注册
	 */
	@SuppressWarnings("null")
	@Override
	public user userRegister(user newUser) {
		user user = new user();
		user = loginRegisterDao.getUserByUserName(newUser.getUsername());
		if (user == null) {
			user.setUser_id(BuildUuid.getUuid());
			user.setUser_creationtime(TimeUtil.getStringSecond());
			return user;
		}

		return null;
	}


}
