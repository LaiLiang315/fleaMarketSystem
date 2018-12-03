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

	public String intoUpLoadPic() {
		return "intoUpLoadPic";
	}
	
	public String intoRegister() {
		return "intoRegister";
		
		
		
	}
	
	
	/*//跳转详情页
	public String kkk() {
		
		
		return "kkk";
		
		
	}*/
}
