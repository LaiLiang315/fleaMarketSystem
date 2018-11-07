package com.fleaMarket.goodsType.dao.DTO;

import java.util.List;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;

/**
 * 一级栏目和多个二级栏目DTO
 * @author LL
 *
 */
public class GoodsTypeDTO {
 
	private typeOne typeOne;
	private List<type> listType;
	public typeOne getTypeOne() {
		return typeOne;
	}
	public void setTypeOne(typeOne typeOne) {
		this.typeOne = typeOne;
	}
	public List<type> getListType() {
		return listType;
	}
	public void setListType(List<type> listType) {
		this.listType = listType;
	}
	
	@Override
	public String toString() {
		return "GoodsTypeDTO [typeOne=" + typeOne + ", listType=" + listType + "]";
	}
}
