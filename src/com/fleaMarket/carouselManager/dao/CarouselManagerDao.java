package com.fleaMarket.carouselManager.dao;

import java.util.List;

import com.fleaMarket.domain.carousel;
import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.user;

/**
 * 轮播图管理的DAO层接口
 * 
 * @author LL
 *
 */

public interface CarouselManagerDao {

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
	 * 跟据id查询轮播图
	 * @param trim
	 * @return
	 */
	carousel getCarouselById(String trim);

	/**
	 * 查询带有特殊标记的图片
	 * @param pictrueName
	 * @return
	 */
	List<picture> getSpectialPic(String pictrueName);

	/**
	 * 获取第一张图片
	 * @param goodsInfo
	 * @return
	 */
	picture getFirstPic(String goodsInfo);
    /**
     * 跟据图片id查询图片
     * @param trim
     * @return
     */
	picture getPicById(String trim);


	user getUserById(String trim);

	/**
	 * 得到最大顺序
	 * @param carousel_sequence
	 * @return
	 */

	public String getMaxSequenceNum(Integer carousel_sequence);

	/**
	 * 查询所有轮播图
	 */
//	List<carousel> listCarousel(); 
}
