package com.fleaMarket.domain;
/**
 * 类型二级栏目实体类
 * @author LL
 *
 */
public class typeOne {
	private String typeOne_id; // 类型id
	private String typeOne_name; // 类型名称
	private String typeOne_creationtime; // 创建时间
	private String typeOne_modifytime; // 修改时间
	private Integer is_delete; // 是否删除
	
	public String getTypeOne_id() {
		return typeOne_id;
	}
	public void setTypeOne_id(String typeOne_id) {
		this.typeOne_id = typeOne_id;
	}
	public String getTypeOne_name() {
		return typeOne_name;
	}
	public void setTypeOne_name(String typeOne_name) {
		this.typeOne_name = typeOne_name;
	}
	public String getTypeOne_creationtime() {
		return typeOne_creationtime;
	}
	public void setTypeOne_creationtime(String typeOne_creationtime) {
		this.typeOne_creationtime = typeOne_creationtime;
	}
	public String getTypeOne_modifytime() {
		return typeOne_modifytime;
	}
	public void setTypeOne_modifytime(String typeOne_modifytime) {
		this.typeOne_modifytime = typeOne_modifytime;
	}
	public Integer getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}
	@Override
	public String toString() {
		return "typeOne [typeOne_id=" + typeOne_id + ", typeOne_name=" + typeOne_name + ", typeOne_creationtime="
				+ typeOne_creationtime + ", typeOne_modifytime=" + typeOne_modifytime + ", is_delete=" + is_delete
				+ "]";
	}
}
