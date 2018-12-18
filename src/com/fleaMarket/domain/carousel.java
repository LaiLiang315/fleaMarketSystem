package com.fleaMarket.domain;

/**
 * 轮播图实体类
 * 
 * @author LL
 *
 */
public class carousel {
	private String carousel_id; // 轮播图id
	private String carousel_picture; // 轮播图图片
	private String carousel_name;
	private Integer carousel_sequence;
	private String carousel_creationtime; // 创建时间
	private String carousel_modifytime; // 修改时间
	private Integer is_delete; // 是否删除

	public String getCarousel_id() {
		return carousel_id;
	}

	public void setCarousel_id(String carousel_id) {
		this.carousel_id = carousel_id;
	}

	public String getCarousel_picture() {
		return carousel_picture;
	}

	public void setCarousel_picture(String carousel_picture) {
		this.carousel_picture = carousel_picture;
	}

	public String getCarousel_name() {
		return carousel_name;
	}

	public void setCarousel_name(String carousel_name) {
		this.carousel_name = carousel_name;
	}

	public Integer getCarousel_sequence() {
		return carousel_sequence;
	}

	public void setCarousel_sequence(Integer carousel_sequence) {
		this.carousel_sequence = carousel_sequence;
	}

	public String getCarousel_creationtime() {
		return carousel_creationtime;
	}

	public void setCarousel_creationtime(String carousel_creationtime) {
		this.carousel_creationtime = carousel_creationtime;
	}

	public String getCarousel_modifytime() {
		return carousel_modifytime;
	}

	public void setCarousel_modifytime(String carousel_modifytime) {
		this.carousel_modifytime = carousel_modifytime;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "carousel [carousel_id=" + carousel_id + ", carousel_picture=" + carousel_picture + ", carousel_name="
				+ carousel_name + ", carousel_sequence=" + carousel_sequence + ", carousel_creationtime="
				+ carousel_creationtime + ", carousel_modifytime=" + carousel_modifytime + ", is_delete=" + is_delete
				+ "]";
	}

}
