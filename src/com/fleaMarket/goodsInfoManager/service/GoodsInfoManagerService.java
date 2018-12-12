package com.fleaMarket.goodsInfoManager.service;

import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.type;
import com.fleaMarket.domain.user;
import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;
import com.fleaMarket.goodsInfoManager.VO.GoodsManagerVO;
import com.fleaMarket.goodsInfoManager.VO.GoodsPicVO;
import com.fleaMarket.goodsInfoManager.VO.TypeInfoPicVO;

/**
 * 商品信息管理的service层
 * 
 * @author LL
 *
 */
public interface GoodsInfoManagerService {

	/**
	 * 分页查询六条商品信息的vo
	 * 
	 * @param goodsManagerVO
	 * @return
	 */
	public GoodsManagerVO findSixGoodsVO(GoodsManagerVO goodsManagerVO);

	/**
	 * 查询图片的DTO
	 * 
	 * @return
	 */

	public List<GoodsManagerDTO> queryGoodsManagerDTO();

	/**
	 * 添加商品信息
	 * 
	 * @param info
	 * @return
	 */
	public String addGoods(goodsInfo info);

	/**
	 * 查询最新六条信息和第一张图片
	 * 
	 * @return
	 */
	public List<GoodsPicDTO> findFirstPicLatestDTO();

	/**
	 * 查询每个类型的前四条信息和图片
	 * 
	 * @return
	 */
	public List<GoodsManagerDTO> findFourInfoDTO();

	public TypeInfoPicVO findAllGoodsByTypeVO(TypeInfoPicVO typeInfoPicVO, type typeId);

	/**
	 * 跟据二级菜单id找一级菜单
	 */
	public type getTypeOneByTypeId(type typeId);

	/**
	 * 根基商品id查询商品信息
	 * 
	 * @param data_id
	 * @return
	 */
	public List<picture> getPicsByGoodsId(String data_id);

	/**
	 * 跟据信息id查询信息
	 * 
	 * @param data_id
	 * @return
	 */
	public goodsInfo getgoodsInfoByGoodsId(String data_id);

	/**
	 * 跟据商品Id查询用户信息
	 * 
	 * @param data_id
	 * @return
	 */
	public user getUserInfoByGoodsId(String data_id);

	/**
	 * 查询用户发布的商品
	 * 
	 * @param newUser
	 * @return
	 */
	public GoodsPicVO getPublishedGoodsVO(user newUser);

	/**
	 * 跟据id删除商品西信息和图片
	 * 
	 * @param data_id
	 * @return
	 */
	public String deleteGoods(String data_id);

}
