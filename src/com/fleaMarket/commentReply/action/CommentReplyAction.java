package com.fleaMarket.commentReply.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fleaMarket.commentReply.service.CommentReplyService;
import com.fleaMarket.domain.comment;
import com.fleaMarket.domain.goodsInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	 * 评论
	 */
	private comment comm;
	/**
	 * 评论所属用户
	 * @return
	 */
	
	private goodsInfo info;
	
	public comment getComm() {
		return comm;
	}

	public void setComm(comment comm) {
		this.comm = comm;
	}
	
	public goodsInfo getInfo() {
		return info;
	}

	public void setInfo(goodsInfo info) {
		this.info = info;
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
	 * 增加评论
	 * @throws IOException 
	 */
	public void addComment() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		String comment = commentReplyService.addComent(comm,info);
		response.getWriter().write(gson.toJson(comment));
	}
	/**
	 * 查询评论回复
	 * @throws IOException 
	 */
	public void queryComment() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		response.setContentType("text/html;charset=utf-8");
		List<comment> listcomment = commentReplyService.queryComment(info);
		response.getWriter().write(gson.toJson(listcomment));
		
	}
}
