package com.fleaMarket.goodsInfoManager.DTO;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;

/**
 * 
 * 商品信息和第一张图片
 * 
 * @author Administrator
 *
 */
public class GoodsPicDTO {

	private goodsInfo info;

	private picture pic;

	public goodsInfo getInfo() {
		return info;
	}

	public void setInfo(goodsInfo info) {
		this.info = info;
	}

	public picture getPic() {
		return pic;
	}

	public void setPic(picture pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "GoodsPicDTO [info=" + info + ", pic=" + pic + "]";
	}

}
