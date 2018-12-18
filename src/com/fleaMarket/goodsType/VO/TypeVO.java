package com.fleaMarket.goodsType.VO;

import java.util.List;

import com.fleaMarket.goodsType.DTO.TypeDTO;

/**
 * 类型VO
 * @author Administrator
 *
 */
public class TypeVO {
	private List<TypeDTO> listTypeDTO;
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


	public List<TypeDTO> getListTypeDTO() {
		return listTypeDTO;
	}

	public void setListTypeDTO(List<TypeDTO> listTypeDTO) {
		this.listTypeDTO = listTypeDTO;
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
		return "TypeVO [listTypeDTO=" + listTypeDTO + ", totalRecords=" + totalRecords + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", havePrePage=" + havePrePage
				+ ", haveNextPage=" + haveNextPage + "]";
	}
}
