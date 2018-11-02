package com.fleaMarket.domain;

/**
 * 评论回复的实体类
 * 
 * @author LL
 *
 */
public class comment {
	private String comment_id; // 评论id
	private String comment_goods; // 评论商品
	private String comment_content; // 评论的文字
	private String comment_ways; // 对应点赞
	private String comment_from_user; // 评论的用户
	private String comment_to_user; // 回复的用户
	private String comment_creationtime; // 创建时间
	private String comment_modifytime; // 修改时间
	private Integer is_delete; // 是否删除

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_goods() {
		return comment_goods;
	}

	public void setComment_goods(String comment_goods) {
		this.comment_goods = comment_goods;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_ways() {
		return comment_ways;
	}

	public void setComment_ways(String comment_ways) {
		this.comment_ways = comment_ways;
	}

	public String getComment_from_user() {
		return comment_from_user;
	}

	public void setComment_from_user(String comment_from_user) {
		this.comment_from_user = comment_from_user;
	}

	public String getComment_to_user() {
		return comment_to_user;
	}

	public void setComment_to_user(String comment_to_user) {
		this.comment_to_user = comment_to_user;
	}

	public String getComment_creationtime() {
		return comment_creationtime;
	}

	public void setComment_creationtime(String comment_creationtime) {
		this.comment_creationtime = comment_creationtime;
	}

	public String getComment_modifytime() {
		return comment_modifytime;
	}

	public void setComment_modifytime(String comment_modifytime) {
		this.comment_modifytime = comment_modifytime;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "comment [comment_id=" + comment_id + ", comment_goods=" + comment_goods + ", comment_content="
				+ comment_content + ", comment_ways=" + comment_ways + ", comment_from_user=" + comment_from_user
				+ ", comment_to_user=" + comment_to_user + ", comment_creationtime=" + comment_creationtime
				+ ", comment_modifytime=" + comment_modifytime + ", is_delete=" + is_delete + "]";
	}

}
