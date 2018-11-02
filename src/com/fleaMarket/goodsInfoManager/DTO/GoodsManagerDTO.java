package com.fleaMarket.goodsInfoManager.DTO;

import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.type;

/**
 * 商品分页的DTO
 * 
 * @author Administrator
 *
 */
public class GoodsManagerDTO {

	/**
	 * 类型
	 */
	private type type;

	/**
	 * 信息和图片
	 */
	private List<GoodsPicDTO> listGoodsPicDTO;

	/**
	 * 信息和图集
	 */
	private List<GoodsPicsDTO> listGoodsPicsDTO;
	/**
	 * 单条信息和图集DTO
	 */
	private GoodsPicsDTO goodsPicsDTO;

	public type getType() {
		return type;
	}

	public void setType(type type) {
		this.type = type;
	}

	public List<GoodsPicDTO> getListGoodsPicDTO() {
		return listGoodsPicDTO;
	}

	public void setListGoodsPicDTO(List<GoodsPicDTO> listGoodsPicDTO) {
		this.listGoodsPicDTO = listGoodsPicDTO;
	}

	public List<GoodsPicsDTO> getListGoodsPicsDTO() {
		return listGoodsPicsDTO;
	}

	public void setListGoodsPicsDTO(List<GoodsPicsDTO> listGoodsPicsDTO) {
		this.listGoodsPicsDTO = listGoodsPicsDTO;
	}

	public GoodsPicsDTO getGoodsPicsDTO() {
		return goodsPicsDTO;
	}

	public void setGoodsPicsDTO(GoodsPicsDTO goodsPicsDTO) {
		this.goodsPicsDTO = goodsPicsDTO;
	}

	@Override
	public String toString() {
		return "GoodsManagerDTO [type=" + type + ", listGoodsPicDTO=" + listGoodsPicDTO + ", listGoodsPicsDTO="
				+ listGoodsPicsDTO + ", goodsPicsDTO=" + goodsPicsDTO + "]";
	}
}
