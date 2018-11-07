package com.fleaMarket.goodsType.service;

import java.util.List;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;
import com.fleaMarket.goodsType.dao.DTO.GoodsTypeDTO;

/**
 * 商品类型管理的service层
 * @author LL
 *
 */
public interface GoodsTypeService {

	/**
	 * 添加类型
	 * @param newType
	 * @return
	 */
	public String addType(type newType);

	/**
	 * 删除类型
	 * @param idList
	 * @return
	 */
	public String deleteType(String idList);

	public String findType();

	/**
	 * 类型分级DTO
	 * @param typeOne 
	 * @param listGoodsTypeDTO
	 * @return
	 */
	public List<GoodsTypeDTO> getListGoodsTypeDTO();

}
