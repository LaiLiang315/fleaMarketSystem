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

	//用户登陆
	@Override
	public user login(user newUser) {
		if (newUser != null) {
			user user = new user();
			user = loginRegisterDao.getUserByUserName(newUser.getUsername());
//			System.out.println("1:" + newUser.getPassword());
			if (user != null) {
				if (user.getPassword().equals(newUser.getPassword())) {
//					System.out.println("ioioioio");
					return user;
				}
				return null;
			}
		}
		return null;
	}

	/**
	 * 更新session
	 */
		@Override
		public user updataSess(user newUser) {
			System.out.println("1:"+newUser);
			if (newUser != null) {
				user user = new user();
				user = loginRegisterDao.getUserByUserName(newUser.getUsername());
//				System.out.println("2:" + newUser.getPassword());
						return user;
					}
			return null;
		}
	/**
	 * 注册
	 */
	@Override
	public user userRegister(user newUser) {
		user user = new user();
		//判断是否手机号是一样的
		user = loginRegisterDao.getUserByUserName(newUser.getUsername());
		if (user == null) {
			newUser.setUser_id(BuildUuid.getUuid());
			newUser.setUser_creationtime(TimeUtil.getStringSecond());
			newUser.setUser_modifytime(TimeUtil.getStringSecond());
			newUser.setIs_delete(0);
			loginRegisterDao.saveOrUpdateObject(newUser);
			return newUser;
		}

		return null;
	}

	/**
	 * 跟据用户名查询用户
	 */
	@Override
	public user getUserByUserName(user newUser) {
		System.out.println("MMM"+newUser);
		user user = new user();
		if(newUser.getUsername()!=null) {
			user = loginRegisterDao.getUserByUserName(newUser.getUsername());
			System.out.println("KK"+user);
			if(user!=null) {
				return user;
			}
		}
		return null;
	}


}
