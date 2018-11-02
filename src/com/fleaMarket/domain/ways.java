package com.fleaMarket.domain;
/**
 * 点赞表实体类
 * @author LL
 *
 */
public class ways {
	private String ways_id;  //点赞id
	private String ways_belong;  //点赞所属交易
	private String ways_content;  //点赞内容
	private String ways_creationtime;  //创建时间
	private String ways_modifytime;  //修改时间
	private Integer is_delete;  //是否删除
	public String getWays_id() {
		return ways_id;
	}
	public void setWays_id(String ways_id) {
		this.ways_id = ways_id;
	}
	public String getWays_belong() {
		return ways_belong;
	}
	public void setWays_belong(String ways_belong) {
		this.ways_belong = ways_belong;
	}
	public String getWays_content() {
		return ways_content;
	}
	public void setWays_content(String ways_content) {
		this.ways_content = ways_content;
	}
	public String getWays_creationtime() {
		return ways_creationtime;
	}
	public void setWays_creationtime(String ways_creationtime) {
		this.ways_creationtime = ways_creationtime;
	}
	public String getWays_modifytime() {
		return ways_modifytime;
	}
	public void setWays_modifytime(String ways_modifytime) {
		this.ways_modifytime = ways_modifytime;
	}
	public Integer getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}
	@Override
	public String toString() {
		return "ways [ways_id=" + ways_id + ", ways_belong=" + ways_belong + ", ways_content=" + ways_content
				+ ", ways_creationtime=" + ways_creationtime + ", ways_modifytime=" + ways_modifytime + ", is_delete="
				+ is_delete + "]";
	}
	
	

}
