package com.fleaMarket.goodsType.DTO;

import java.util.List;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;

/**
 * 类型DTO
 * @author Administrator
 *
 */
public class TypeDTO {

	//一级类型
	private typeOne typeOne;
	//二级类型
	private List<type> ListType;
	public typeOne getTypeOne() {
		return typeOne;
	}
	public void setTypeOne(typeOne typeOne) {
		this.typeOne = typeOne;
	}
	public List<type> getListType() {
		return ListType;
	}
	public void setListType(List<type> listType) {
		ListType = listType;
	}
	@Override
	public String toString() {
		return "TypeDTO [typeOne=" + typeOne + ", ListType=" + ListType + "]";
	}
}
