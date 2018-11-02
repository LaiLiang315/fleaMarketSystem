package com.fleaMarket.domain;

/**
 * 用户实体类
 * 
 * @author LL
 *
 */
public class user {
	private String user_id; // 用户id
	private String nickname; // 昵称
	private String username; // 用户名
	private String password; // 密码
	private String headportrait; // 头像
	private String address; // 地址
	private String sex; // 性别
	private String collection; // 收藏
	private String user_creationtime; // 创建时间
	private String user_modifytime; // 修改时间
	private Integer is_delete; // 是否删除

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadportrait() {
		return headportrait;
	}

	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getUser_creationtime() {
		return user_creationtime;
	}

	public void setUser_creationtime(String user_creationtime) {
		this.user_creationtime = user_creationtime;
	}

	public String getUser_modifytime() {
		return user_modifytime;
	}

	public void setUser_modifytime(String user_modifytime) {
		this.user_modifytime = user_modifytime;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", nickname=" + nickname + ", username=" + username + ", password="
				+ password + ", headportrait=" + headportrait + ", address=" + address + ", sex=" + sex
				+ ", collection=" + collection + ", user_creationtime=" + user_creationtime + ", user_modifytime="
				+ user_modifytime + ", is_delete=" + is_delete + "]";
	}

}
