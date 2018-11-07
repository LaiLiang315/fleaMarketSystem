package com.fleaMarket.goodsType.dao;

import java.util.List;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;

/**
 * 商品类型管理的dao层
 * @author LL
 *
 */
public interface GoodsTypeDao {

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
	 * 跟据类型名称查询类型
	 * @return
	 */
	public type getTypeByTypeName(Object trim);

	/**
	 * 跟据类型id查找类型
	 * @param trim 
	 */
	public type getTypeByTypeId(Object trim);

	/**
	 * 根据一级栏目id查询二级栏目
	 * @param trim
	 * @return
	 */
	
	public List<type> getTypeByTypeOneId(Object trim);

	/**
	 * 跟据一级栏目的name得到二级栏目
	 * @param trim
	 * @return
	 */
	typeOne getTypeOneByTypeOneName(Object trim);

}
