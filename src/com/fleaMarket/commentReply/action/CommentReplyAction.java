package com.fleaMarket.commentReply.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.commentReply.service.CommentReplyService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 评论与回复的Action层
 * @author LL
 *
 */
public class CommentReplyAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	private static final long serialVersionUID = 1L;

	private CommentReplyService commentReplyService;
	
	public CommentReplyService getCommentReplyService() {
		return commentReplyService;
	}

	public void setCommentReplyService(CommentReplyService commentReplyService) {
		this.commentReplyService = commentReplyService;
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
}
