package com.fleaMarket.loginRegister.VO;

import java.util.List;

import com.fleaMarket.domain.user;

//用户分页显示
public class UserVO {

	private List<user> listUser;
	/**
	 * 总记录条数,当前页,最大条数,总记录条数
	 */
	private int totalRecords = 0;

	private int pageIndex = 1;

	private int pageSize = 6;

	private int totalPages = 1;
	
	private String serch;
	/**
	 * 上一页，下一页
	 */
	private boolean havePrePage = false;
	private boolean haveNextPage = false;
	public List<user> getListUser() {
		return listUser;
	}
	public void setListUser(List<user> listUser) {
		this.listUser = listUser;
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
	public String getSerch() {
		return serch;
	}
	public void setSerch(String serch) {
		this.serch = serch;
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
		return "UserVO [listUser=" + listUser + ", totalRecords=" + totalRecords + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", serch=" + serch + ", havePrePage="
				+ havePrePage + ", haveNextPage=" + haveNextPage + "]";
	}

}
