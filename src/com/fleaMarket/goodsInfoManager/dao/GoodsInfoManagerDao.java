package com.fleaMarket.goodsInfoManager.dao;

import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;

/**
 * 商品信息管理里的dao层
 * @author LL
 *
 */
public interface GoodsInfoManagerDao {
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
	 * 查询六条商品信息
	 * @param trim
	 * @return
	 */
	List<goodsInfo> getSixGoodsInfoByTypeId(String trim);

	/**
	 * 查询第一张图片
	 * @param trim
	 * @return
	 */
	picture getFirstPicByInfoId(String trim);

	/**
	 * 跟据类型id查询list信息
	 * @param trim
	 * @return
	 */
	List<goodsInfo> getGoodsInfoByTypeId(String trim);

	/**
	 * 跟据信息id查询list图片
	 * @param trim
	 * @return
	 */
	List<picture> getPicsByInfoId(String trim);

}