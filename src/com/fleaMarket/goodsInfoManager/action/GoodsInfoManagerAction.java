package com.fleaMarket.goodsInfoManager.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;
import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicsDTO;
import com.fleaMarket.goodsInfoManager.VO.GoodsManagerVO;
import com.fleaMarket.goodsInfoManager.VO.TypeInfoPicVO;
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
	
	public void setGoodsInfoManagerService(GoodsInfoManagerService goodsInfoManagerService) {
		this.goodsInfoManagerService = goodsInfoManagerService;
	}
	
	
	private goodsInfo info;
	
	private type typeId;
	public goodsInfo getInfo() {
		return info;
	}

	public void setInfo(goodsInfo info) {
		this.info = info;
	}

	public type getTypeId() {
		return typeId;
	}

	public void setTypeId(type typeId) {
		this.typeId = typeId;
	}


	private List<GoodsManagerDTO> listGoodsManagerDTO;
	
	public List<GoodsManagerDTO> getListGoodsManagerDTO() {
		return listGoodsManagerDTO;
	}
	public void setListGoodsManagerDTO(List<GoodsManagerDTO> listGoodsManagerDTO) {
		this.listGoodsManagerDTO = listGoodsManagerDTO;
	}
	

	/**
	 * 商品信息的分页
	 */
	private GoodsManagerVO goodsManagerVO;
	
	/**
	 * 
	 * @return
	 */
	private TypeInfoPicVO typeInfoPicVO;
	
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
	 * 分页按类型查询六条商品信息显示
	 */
	public void findAllGoodsByTypeVO() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		TypeInfoPicVO typeInfoPicVO = new TypeInfoPicVO();
		typeInfoPicVO = goodsInfoManagerService.findAllGoodsByTypeVO(typeInfoPicVO,typeId);
		try {
			response.getWriter().write(gson.toJson(typeInfoPicVO));
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
	
	/**
	 * 查询最近上线的六条商品
	 * @throws IOException 
	 */
	public void findFirstPicLatestDTO() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
	    List<GoodsPicDTO> listGoodsPicDTO = goodsInfoManagerService.findFirstPicLatestDTO();
	    response.getWriter().write(gson.toJson(listGoodsPicDTO));
	}
	
	/**
	 * 查询每个类型的最便宜的四条商品并拿到第一张图片
	 * @throws IOException 
	 */
	public void findFourInfoDTO() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		List<GoodsManagerDTO> listGoodsManagerDTO = goodsInfoManagerService.findFourInfoDTO();
		 response.getWriter().write(gson.toJson(listGoodsManagerDTO));
	}
	/**
	 * 用户添加商品
	 * @throws IOException 
	 */
	public void addGoods() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		String add = goodsInfoManagerService.addGoods(info);
		response.getWriter().write(gson.toJson(add));
	}
	/**
	 * 跟据二级菜单id找一级菜单
	 * @throws IOException 
	 */
	public void getTypeOneByTypeId() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		type type = goodsInfoManagerService.getTypeOneByTypeId(typeId);
		response.getWriter().write(gson.toJson(type));
	}
}
