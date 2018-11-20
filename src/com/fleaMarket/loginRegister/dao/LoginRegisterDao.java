package com.fleaMarket.loginRegister.dao;

import java.util.List;

import com.fleaMarket.domain.user;

/**
 * 登陆注册的dao层
 * 
 * @author LL
 *
 */
public interface LoginRegisterDao {

	/**
	 * 保存、更新对象
	 * 
	 * @author LL
	 * @date 2018/10/18
	 * @param obj
	 * @modify LL 2018/10/18
	 */
	public void saveOrUpdateObject(Object obj);

	/**
	 * 分页获取对象，这里是获取一页中的数据
	 * 
	 * @param hql
	 * @param offset
	 *            当前页
	 * @param length
	 *            获取每页记录数
	 * @return
	 */
	public List<?> queryForPage(String hql, int offset, int length);

	/**
	 * 获取对象总数量
	 * 
	 * @param hql
	 * @return
	 */
	public int getCount(String hql);

	/**
	 * 删除对象记录
	 * 
	 * @param obj
	 */
	public int removeObject(Object obj);

	/**
	 * 获取对象列表
	 */
	public List<?> listObject(String hql);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	public user getUserByUserName(String username);

//	public user getUserByUserName(user username);

}
