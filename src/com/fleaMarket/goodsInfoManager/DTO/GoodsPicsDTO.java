package com.fleaMarket.goodsInfoManager.DTO;

import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
/**
 * 商品信息和图集
 * @author Administrator
 *
 */
public class GoodsPicsDTO {

	/**
	 * 图集
	 */
	private List<picture> listpic ;
	/**
	 * 信息
	 */
	private goodsInfo info ;
	
	public List<picture> getListpic() {
		return listpic;
	}
	public void setListpic(List<picture> listpic) {
		this.listpic = listpic;
	}
	public goodsInfo getInfo() {
		return info;
	}
	public void setInfo(goodsInfo info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "TypeGoodsPicDTO [listpic=" + listpic + ", info=" + info + "]";
	}
	
}
