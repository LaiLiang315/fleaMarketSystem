package com.fleaMarket.domain;

/**
 * 商品信息实体类
 * 
 * @author LL
 *
 */
public class goodsInfo {
	private String goods_id; // 商品信息id
	private String goods_name; // 商品名称
	private String goods_belong; // 商品所属用户
	private String goods_price; // 商品价格
	private String goods_state; // 商品状态
	private String goods_describe; // 商品描述
	private String goods_type; // 商品类型
	private String goods_creationtime; // 创建时间
	private String goods_modifytime; // 修改时间

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_belong() {
		return goods_belong;
	}

	public void setGoods_belong(String goods_belong) {
		this.goods_belong = goods_belong;
	}

	public String getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_state() {
		return goods_state;
	}

	public void setGoods_state(String goods_state) {
		this.goods_state = goods_state;
	}

	public String getGoods_describe() {
		return goods_describe;
	}

	public void setGoods_describe(String goods_describe) {
		this.goods_describe = goods_describe;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public String getGoods_creationtime() {
		return goods_creationtime;
	}

	public void setGoods_creationtime(String goods_creationtime) {
		this.goods_creationtime = goods_creationtime;
	}

	public String getGoods_modifytime() {
		return goods_modifytime;
	}

	public void setGoods_modifytime(String goods_modifytime) {
		this.goods_modifytime = goods_modifytime;
	}

	@Override
	public String toString() {
		return "goodsInfo [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_belong=" + goods_belong
				+ ", goods_price=" + goods_price + ", goods_state=" + goods_state + ", goods_describe=" + goods_describe
				+ ", goods_type=" + goods_type + ", goods_creationtime=" + goods_creationtime + ", goods_modifytime="
				+ goods_modifytime + "]";
	}

}
