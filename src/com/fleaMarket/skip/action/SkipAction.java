package com.fleaMarket.skip.action;

//页面跳转
public class SkipAction {

	private String data_id;

	public String getData_id() {
		return data_id;
	}

	public void setData_id(String data_id) {
		this.data_id = data_id;
	}

	// 到登陆界面
	public String intoIndex() {
		return "intoIndex";
	}

	public String intoGoodsDetals() {
		System.out.println("DDDDD:" + data_id);
		// data_id = getData_id();

		return "intoGoodsDetals";
	}

	// 发布商品页
	public String intoUpLoadPic() {
		return "intoUpLoadPic";
	}

	// 登录页
	public String intoLogin() {

		return "intoLogin";
	}

	// 注册页
	public String intoRegister() {
		return "intoRegister";

	}

	// 用户页
	public String intoUser() {

		return "intoUser";

	}

	// 跳转用户信息页
	public String intoUserInfo() {

		return "intoUserInfo";
	}

	// 进入用户想要购买的页面
	public String intoUserWants() {

		return "intoUserWants";
	}

	// 进入添加商品分类页面
	public String intoCategoryAdd() {
		return "intoCategoryAdd";
	}

	// 进入商品分类列表页面
	public String intoCategoryList() {
		return "intoCategoryList";
	}

	// 进入用户列表页面
	public String intoUserList() {
		return "intoUserList";
	}

	// 进入交易记录
	public String intoTransactionList() {
		return "intoTransactionList";
	}

	// 进入轮播图列表
	public String intoCarouselList() {
		return "intoCarouselList";
	}

	// 进入轮播图列表
	public String intoCarouselAdd() {
		return "intoCarouselAdd";
	}

	// 进入轮播图列表
	public String intoCarouselEdit() {
		return "intoCarouselEdit";
	}

	// 进入类型编辑页
	public String intoCategoryEdit() {
		return "intoCategoryEdit";
	}
	/*
	 * intoTransactionList //跳转详情页 public String kkk() {
	 * 
	 * 
	 * return "kkk";
	 * 
	 * 
	 * }
	 */
}
