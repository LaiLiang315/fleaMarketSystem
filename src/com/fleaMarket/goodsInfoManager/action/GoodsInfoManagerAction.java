package com.fleaMarket.goodsInfoManager.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicsDTO;
import com.fleaMarket.goodsInfoManager.VO.GoodsManagerVO;
import com.fleaMarket.goodsInfoManager.service.GoodsInfoManagerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 商品信息管理的Action层
 * @author LL
 *
 */
public class GoodsInfoManagerAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{
	private static final long serialVersionUID = 1L;

	private GoodsInfoManagerService goodsInfoManagerService;
	
	public GoodsInfoManagerService getGoodsInfoManagerService() {
		return goodsInfoManagerService;
	}
	
	public List<GoodsManagerDTO> listGoodsManagerDTO;
	public List<GoodsManagerDTO> getListGoodsManagerDTO() {
		return listGoodsManagerDTO;
	}
	public void setListGoodsManagerDTO(List<GoodsManagerDTO> listGoodsManagerDTO) {
		this.listGoodsManagerDTO = listGoodsManagerDTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setGoodsInfoManagerService(GoodsInfoManagerService goodsInfoManagerService) {
		this.goodsInfoManagerService = goodsInfoManagerService;
	}

	private GoodsManagerVO goodsManagerVO;
	
	
	
	public GoodsManagerVO getGoodsManagerVO() {
		return goodsManagerVO;
	}

	public void setGoodsManagerVO(GoodsManagerVO goodsManagerVO) {
		this.goodsManagerVO = goodsManagerVO;
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
	/**
	 * 分页按类型查询六条商品信息显示
	 */
	public void findSixGoodsVO() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		GoodsManagerVO goodsManagerVO = new GoodsManagerVO();
		goodsManagerVO = goodsInfoManagerService.findSixGoodsVO(goodsManagerVO);
		try {
			response.getWriter().write(gson.toJson(goodsManagerVO));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询图集DTO
	 * @throws IOException 
	 */
	public void queryGoodsManagerDTO() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		listGoodsManagerDTO = goodsInfoManagerService.queryGoodsManagerDTO();
		response.getWriter().write(gson.toJson(listGoodsManagerDTO));
	}
	
	
	/**
	 * 查询图集DTO
	 * @throws IOException 
	 */
	public String qudsManagerDTO() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		listGoodsManagerDTO = goodsInfoManagerService.queryGoodsManagerDTO();
		return "fd";
//		response.getWriter().write(gson.toJson(listGoodsManagerDTO));
	}
	
	
}
