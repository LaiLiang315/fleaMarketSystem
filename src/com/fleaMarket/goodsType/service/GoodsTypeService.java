package com.fleaMarket.goodsType.service;

import java.io.IOException;
import java.util.List;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;
import com.fleaMarket.goodsType.DTO.TypeDTO;
import com.fleaMarket.goodsType.VO.TypeVO;
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
	 * @param typeOne 
	 * @return
	 */
	public String addType(type newType, typeOne typeOne);

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

	/**
	 * 跟据一级栏目id查询二级栏目
	 * @throws IOException 
	 */
	public List<type> getListType(typeOne typeOne);

	/**
	 * 得到类型的分页
	 * @return
	 */
	public TypeVO getTypeVO();

	/**
	 * 得到类型的DTO
	 * @return
	 */
	public List<TypeDTO> getTypeDTO();

	/**
	 *添加一级类型
	 * @param typeOne
	 * @return
	 */
	public String addTypeOne(typeOne typeOne);

}
