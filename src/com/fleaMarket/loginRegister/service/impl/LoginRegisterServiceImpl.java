package com.fleaMarket.loginRegister.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;
import com.fleaMarket.domain.user;
import com.fleaMarket.loginRegister.VO.UserVO;
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

	/**
	 * 用户列表分页
	 */
	@Override
	public UserVO getUserVO() {
		UserVO userVO = new UserVO();
		List<user> listUser = new ArrayList<user>();
		String listUserHql = "from user where 1=1";
		String userCountHql = "select count(*) from user where 1=1";
		
		// 这里如果不加desc表示正序，如果加上desc表示倒序
		userCountHql = userCountHql + "order by user_creationtime desc";
				int userCount = loginRegisterDao.getCount(userCountHql);
				// 设置总数量
				userVO.setTotalRecords(userCount);
				// 设置总页数
				userVO.setTotalPages(((userCount - 1) / userVO.getPageSize()) + 1);
				// 判断是否拥有上一页
				if (userVO.getPageIndex() <= 1) {
					userVO.setHavePrePage(false);
				} else {
					userVO.setHavePrePage(true);
				}
				// 判断是否拥有下一页
				if (userVO.getPageIndex() >= userVO.getTotalPages()) {

					userVO.setHaveNextPage(false);
				} else {
					userVO.setHaveNextPage(true);
				}
				listUser = (List<user>) loginRegisterDao.queryForPage(
						"from user order by user_creationtime desc", userVO.getPageIndex(),
						userVO.getPageSize());
				userVO.setListUser(listUser);
				return userVO;
	}

	/**
	 * 封禁用户
	 */
	@Override
	public String deleteUser(String idList) {
		String result = "";
		if (!idList.isEmpty()) {
			/*
			 * 将获得的对象转化为数组
			 */
			String[] deleteTypeById = idList.split(",");
			/**
			 * 遍历需要删除的类型数组
			 */
			for (String id : deleteTypeById) {
				user user = new user();
				user = loginRegisterDao.getUserById(id);
				if (user != null ) {
					user.setIs_delete(1);
					user.setUser_modifytime(TimeUtil.getStringSecond());
					loginRegisterDao.saveOrUpdateObject(user);
					result = "deleteSuccess";
				} else {
					result = "deleteFail";
				}
			}
		}
		return result;
	}
	//解除封禁用户
	@Override
	public String unDeleteUser(String idList) {
		String result = "";
		if (!idList.isEmpty()) {
			/*
			 * 将获得的对象转化为数组
			 */
			String[] deleteTypeById = idList.split(",");
			/**
			 * 遍历需要删除的类型数组
			 */
			for (String id : deleteTypeById) {
				user user = new user();
				user = loginRegisterDao.getUserById(id);
				System.out.println("");
				if (user != null ) {
					user.setIs_delete(0);
					user.setUser_modifytime(TimeUtil.getStringSecond());
					loginRegisterDao.saveOrUpdateObject(user);
					result = "unDeleteSuccess";
				} else {
					result = "unDeleteFailed";
				}
			}
		}
		return result;
	}


}
