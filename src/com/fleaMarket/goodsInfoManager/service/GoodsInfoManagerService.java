package com.fleaMarket.goodsInfoManager.service;

import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicsDTO;
import com.fleaMarket.goodsInfoManager.VO.GoodsManagerVO;

/**
 * 商品信息管理的service层
 * @author LL
 *
 */
public interface GoodsInfoManagerService {


	/**
	 * 分页查询六条商品信息的vo
	 * @param goodsManagerVO
	 * @return
	 */
	public GoodsManagerVO findSixGoodsVO(GoodsManagerVO goodsManagerVO);

	/**
	 * 查询图片的DTO
	 * @return
	 */

	public List<GoodsManagerDTO> queryGoodsManagerDTO();

	/**
	 * 添加商品信息
	 * @param info
	 * @return
	 */
	public String addGoods(goodsInfo info);

}
