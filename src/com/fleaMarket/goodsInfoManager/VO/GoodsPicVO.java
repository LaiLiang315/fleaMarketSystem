package com.fleaMarket.goodsInfoManager.VO;

import java.util.List;

import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;

/**
 * 商品图片vo
 * 
 * @author LL
 *
 */
public class GoodsPicVO {
	/**
	 * 商品图片DTO
	 */
	private List<GoodsPicDTO> listGoodsPicDTO;

	/**
	 * 总记录条数,当前页,最大条数,总记录条数
	 */
	private int totalRecords = 0;

	private int pageIndex = 1;

	private int pageSize = 6;

	private int totalPages = 1;
	/**
	 * 上一页，下一页
	 */
	private boolean havePrePage = false;
	private boolean haveNextPage = false;

	public List<GoodsPicDTO> getListGoodsPicDTO() {
		return listGoodsPicDTO;
	}

	public void setListGoodsPicDTO(List<GoodsPicDTO> listGoodsPicDTO) {
		this.listGoodsPicDTO = listGoodsPicDTO;
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
		return "GoodsPicVO [listGoodsPicDTO=" + listGoodsPicDTO + ", totalRecords=" + totalRecords + ", pageIndex="
				+ pageIndex + ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", havePrePage=" + havePrePage
				+ ", haveNextPage=" + haveNextPage + "]";
	}

}
