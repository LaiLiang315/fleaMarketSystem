package com.fleaMarket.domain;

/**
 * 交易记录
 * 
 * @author LL
 *
 */
public class transaction_record {
	private String transaction_id; // 交易记录id
	private String transaction_orderNumber;  //订单号
	private String transaction_to_user; // 被交易者
	private String transaction_from_user; // 交易者
	private String transaction_belong; // 交易记录所属商品
	private String transaction_creationtime; // 创建时间
	private String transaction_modifytime; // 修改时间
	private Integer is_delete; // 是否删除

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getTransaction_orderNumber() {
		return transaction_orderNumber;
	}

	public void setTransaction_orderNumber(String transaction_orderNumber) {
		this.transaction_orderNumber = transaction_orderNumber;
	}

	public String getTransaction_to_user() {
		return transaction_to_user;
	}

	public void setTransaction_to_user(String transaction_to_user) {
		this.transaction_to_user = transaction_to_user;
	}

	public String getTransaction_from_user() {
		return transaction_from_user;
	}

	public void setTransaction_from_user(String transaction_from_user) {
		this.transaction_from_user = transaction_from_user;
	}

	public String getTransaction_belong() {
		return transaction_belong;
	}

	public void setTransaction_belong(String transaction_belong) {
		this.transaction_belong = transaction_belong;
	}

	public String getTransaction_creationtime() {
		return transaction_creationtime;
	}

	public void setTransaction_creationtime(String transaction_creationtime) {
		this.transaction_creationtime = transaction_creationtime;
	}

	public String getTransaction_modifytime() {
		return transaction_modifytime;
	}

	public void setTransaction_modifytime(String transaction_modifytime) {
		this.transaction_modifytime = transaction_modifytime;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "transaction_record [transaction_id=" + transaction_id + ", transaction_orderNumber="
				+ transaction_orderNumber + ", transaction_to_user=" + transaction_to_user + ", transaction_from_user="
				+ transaction_from_user + ", transaction_belong=" + transaction_belong + ", transaction_creationtime="
				+ transaction_creationtime + ", transaction_modifytime=" + transaction_modifytime + ", is_delete="
				+ is_delete + "]";
	}
}
