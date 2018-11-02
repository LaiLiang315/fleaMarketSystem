package com.fleaMarket.goodsType.service;

import com.fleaMarket.domain.type;

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

}
