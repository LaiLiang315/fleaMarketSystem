package com.fleaMarket.goodsType.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;
import com.fleaMarket.goodsType.dao.DTO.GoodsTypeDTO;
import com.fleaMarket.goodsType.service.GoodsTypeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品类型管理的Action层
 * 
 * @author LL
 *
 */
public class GoodsTypeAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private GoodsTypeService goodsTypeService;

	public GoodsTypeService getGoodsTypeService() {
		return goodsTypeService;
	}

	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}

	private typeOne typeOne;
	
	private type newType;

	private String idList;

	public typeOne getTypeOne() {
		return typeOne;
	}

	public void setTypeOne(typeOne typeOne) {
		this.typeOne = typeOne;
	}
	
	public type getNewType() {
		return newType;
	}

	public void setNewType(type newType) {
		this.newType = newType;
	}


	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
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
	 * 添加类型
	 */
	public void addType() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		String type = goodsTypeService.addType(newType);
		try {
			response.getWriter().write(gson.toJson(type));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 删除类型
	 */
	public void deleteType() {
		/*GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");*/
		try {
			response.getWriter().write("" + (goodsTypeService.deleteType(idList)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 查询所有类型
	 */

	public void findType() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(""+(goodsTypeService.findType()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 一级栏目二级栏目的dto
	 * @throws IOException
	 */
	public  void getListGoodsTypeDTO() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		List<GoodsTypeDTO> listDTO = goodsTypeService.getListGoodsTypeDTO();
		response.getWriter().write(gson.toJson(listDTO));
		
	}
	/**
	 * 跟据一级栏目id查询二级栏目
	 * @throws IOException 
	 */
	public void getListType() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		System.out.println("ssss");
		List<type> types = goodsTypeService.getListType(typeOne);
		response.getWriter().write(gson.toJson(types));
	}
}
