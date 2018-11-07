package com.fleaMarket.domain;

/**
 * 图片表实体类
 * 
 * @author LL
 *
 */
public class picture {
	private String picture_id; // 图片id
	private String picture_name; // 图片名称
	private String picture_belong; // 图片所属商品
	private Integer picture_sequence;
	private String picture_creationtime; // 创建时间
	private String picture_modifytime; // 修改时间
	private Integer is_delete; // 是否删除

	public String getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(String picture_id) {
		this.picture_id = picture_id;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

	public String getPicture_belong() {
		return picture_belong;
	}

	public void setPicture_belong(String picture_belong) {
		this.picture_belong = picture_belong;
	}


	public Integer getPicture_sequence() {
		return picture_sequence;
	}

	public void setPicture_sequence(Integer picture_sequence) {
		this.picture_sequence = picture_sequence;
	}

	public String getPicture_creationtime() {
		return picture_creationtime;
	}

	public void setPicture_creationtime(String picture_creationtime) {
		this.picture_creationtime = picture_creationtime;
	}

	public String getPicture_modifytime() {
		return picture_modifytime;
	}

	public void setPicture_modifytime(String picture_modifytime) {
		this.picture_modifytime = picture_modifytime;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "picture [picture_id=" + picture_id + ", picture_name=" + picture_name + ", picture_belong="
				+ picture_belong + ", picture_sequence=" + picture_sequence + ", picture_creationtime="
				+ picture_creationtime + ", picture_modifytime=" + picture_modifytime + ", is_delete=" + is_delete
				+ "]";
	}

}
