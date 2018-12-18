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
	private String goods_userWants; // 用户想要购买的商品
	private String exchange_adress;
	private String exchange_ways;
	private String user_qq;
	private String user_weixin;
	private String user_phoneNum;
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

	
	public String getGoods_userWants() {
		return goods_userWants;
	}

	public void setGoods_userWants(String goods_userWants) {
		this.goods_userWants = goods_userWants;
	}

	public String getExchange_adress() {
		return exchange_adress;
	}

	public void setExchange_adress(String exchange_adress) {
		this.exchange_adress = exchange_adress;
	}

	public String getExchange_ways() {
		return exchange_ways;
	}

	public void setExchange_ways(String exchange_ways) {
		this.exchange_ways = exchange_ways;
	}

	public String getUser_qq() {
		return user_qq;
	}

	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}

	public String getUser_weixin() {
		return user_weixin;
	}

	public void setUser_weixin(String user_weixin) {
		this.user_weixin = user_weixin;
	}

	public String getUser_phoneNum() {
		return user_phoneNum;
	}

	public void setUser_phoneNum(String user_phoneNum) {
		this.user_phoneNum = user_phoneNum;
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
				+ ", goods_type=" + goods_type + ", goods_userWants=" + goods_userWants + ", exchange_adress="
				+ exchange_adress + ", exchange_ways=" + exchange_ways + ", user_qq=" + user_qq + ", user_weixin="
				+ user_weixin + ", user_phoneNum=" + user_phoneNum + ", goods_creationtime=" + goods_creationtime
				+ ", goods_modifytime=" + goods_modifytime + "]";
	}
}
