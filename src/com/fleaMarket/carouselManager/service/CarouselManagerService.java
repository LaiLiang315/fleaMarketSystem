package com.fleaMarket.carouselManager.service;

import java.util.List;
import java.util.Map;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;

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

	void addPictrues(picture picture);

	/**
	 * 添加并完善信息
	 * @param goodsInfo
	 * @param listMap
	 * @return
	 */
	String addAndComplete(goodsInfo goodsInfo, List<Map<String, Object>> listMap);

}
