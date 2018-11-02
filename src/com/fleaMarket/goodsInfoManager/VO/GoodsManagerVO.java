package com.fleaMarket.goodsInfoManager.VO;

import java.util.List;

import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;

/**
 * 商品信息管理的vo
 * 
 * @author Administrator
 *
 */
public class GoodsManagerVO {
	/**
	 * 生成list集合
	 */
	private List<GoodsManagerDTO> listGoodsManagerDTO;
	/**
	 * 总记录条数
	 */
	private int totalRecords = 0;

	private int pageIndex = 1;

	private int pageSize = 10;

	private int totalPages = 1;
	/**
	 * 模糊查询
	 */
	private String search;

	private boolean havePrePage = false;
	private boolean haveNextPage = false;

	public List<GoodsManagerDTO> getListGoodsManagerDTO() {
		return listGoodsManagerDTO;
	}

	public void setListGoodsManagerDTO(List<GoodsManagerDTO> listGoodsManagerDTO) {
		this.listGoodsManagerDTO = listGoodsManagerDTO;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public boolean isHavePrePage() {
		return havePrePage;
	}

	public void setHavePrePage(boolean havePrePage) {
		this.havePrePage = havePrePage;
	}

	public boolean isHaveNextPage() {
		return haveNextPage;
	}

	public void setHaveNextPage(boolean haveNextPage) {
		this.haveNextPage = haveNextPage;
	}

	@Override
	public String toString() {
		return "GoodsManagerVO [listGoodsManagerDTO=" + listGoodsManagerDTO + ", totalRecords=" + totalRecords
				+ ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", search="
				+ search + ", havePrePage=" + havePrePage + ", haveNextPage=" + haveNextPage + "]";
	}

}
