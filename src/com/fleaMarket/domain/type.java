package com.fleaMarket.domain;

/**
 * 商品类型实体类
 * 
 * @author LL
 *
 */
public class type {
	private String type_id; // 类型id
	private String type_name; // 类型名称
	private String type_creationtime; // 创建时间
	private String type_modifytime; // 修改时间
	private Integer is_delete; // 是否删除

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getType_creationtime() {
		return type_creationtime;
	}

	public void setType_creationtime(String type_creationtime) {
		this.type_creationtime = type_creationtime;
	}

	public String getType_modifytime() {
		return type_modifytime;
	}

	public void setType_modifytime(String type_modifytime) {
		this.type_modifytime = type_modifytime;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "type [type_id=" + type_id + ", type_name=" + type_name + ", type_creationtime=" + type_creationtime
				+ ", type_modifytime=" + type_modifytime + ", is_delete=" + is_delete + "]";
	}

}
