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
//		data_id = getData_id();
		
		return "intoGoodsDetals";
	}

	//发布商品页
	public String intoUpLoadPic() {
		return "intoUpLoadPic";
	}
	//登录页
    public String intoLogin() {
		
		return "intoLogin";
	}
	//注册页
	public String intoRegister() {
		return "intoRegister";
		
	}
	//用户页
	public String intoUser() {
		
		return "intoUser";
		
	}
	//跳转用户信息页
	public String intoUserInfo() {
		
		return "intoUserInfo";
	}

	
	
	/*//跳转详情页
	public String kkk() {
		
		
		return "kkk";
		
		
	}*/
}
