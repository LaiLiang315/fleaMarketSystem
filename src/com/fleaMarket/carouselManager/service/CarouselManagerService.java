package com.fleaMarket.carouselManager.service;

import java.util.List;
import java.util.Map;

import com.fleaMarket.domain.carousel;
import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.user;

/**
 * 评论与回复的service层接口
 * @author LL
 *
 */
public interface CarouselManagerService {


	String addCarousel();

	/**
	 * 删除轮播图的数组
	 * @param idList
	 * @return
	 */
	String deleteCarousel(String idList);

	/**
	 * 用户添加图片
	 * @param picture
	 */
	void addPictrues(picture picture);

	/**
	 * 用户添加并完善商品信息
	 * @param goodsInfo
	 * @param listMap
	 * @return
	 */
	String addAndComplete(goodsInfo goodsInfo, String pictrueMap);
//	String addAndComplete(goodsInfo goodsInfo, List<Map<String, Object>> listMap);

	/**
	 * 用户添加轮播图
	 * @param carousel
	 */
	void addCarousel(carousel carousel);

	/**
	 * 查询所有轮播图
	 * @return
	 */
	List<carousel> findCarousels();

	/**
	 * 上传头像
	 * @param user
	 * @param fileFileName 
	 */
	void addHeadportrait(user user, String fileFileName);

	/**
	 * 保存个人信息
	 * @param user
	 * @return
	 */
	user savePersonalInfo(user user);


	

}
