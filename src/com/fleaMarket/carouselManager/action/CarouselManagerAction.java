package com.fleaMarket.carouselManager.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.carouselManager.service.CarouselManagerService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 轮播图管理的Action层
 */
public class CarouselManagerAction extends ActionSupport implements ServletResponseAware,ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private CarouselManagerService carouselManagerService;
	
	public CarouselManagerService getCarouselManagerService() {
		return carouselManagerService;
	}

	public void setCarouselManagerService(CarouselManagerService carouselManagerService) {
		this.carouselManagerService = carouselManagerService;
	}

	/**
	 * 实现request和response
	 */
	private HttpServletResponse response;

	private HttpServletRequest request;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * 实现结束
	 */
	public String fdfd() {
		System.out.println();
		return "fdf";
	}
	
}
