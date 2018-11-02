package com.fleaMarket.commentReply.service.impl;

import com.fleaMarket.commentReply.dao.CommentReplyDao;
import com.fleaMarket.commentReply.service.CommentReplyService;

/**
 * 评论与回复的Service实现层
 * @author LL
 *
 */
public class CommentReplyServiceImpl implements CommentReplyService{
	
	private CommentReplyDao commentReplyDao;

	public CommentReplyDao getCommentReplyDao() {
		return commentReplyDao;
	}

	public void setCommentReplyDao(CommentReplyDao commentReplyDao) {
		this.commentReplyDao = commentReplyDao;
	}
	
	

}
