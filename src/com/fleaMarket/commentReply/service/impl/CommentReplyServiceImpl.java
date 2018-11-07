package com.fleaMarket.commentReply.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fleaMarket.commentReply.dao.CommentReplyDao;
import com.fleaMarket.commentReply.service.CommentReplyService;
import com.fleaMarket.domain.comment;
import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.transaction_record;

import util.BuildUuid;

/**
 * 评论与回复的Service实现层
 * 
 * @author LL
 *
 */
public class CommentReplyServiceImpl implements CommentReplyService {

	private CommentReplyDao commentReplyDao;

	public CommentReplyDao getCommentReplyDao() {
		return commentReplyDao;
	}

	public void setCommentReplyDao(CommentReplyDao commentReplyDao) {
		this.commentReplyDao = commentReplyDao;
	}

	/**
	 * 添加评论
	 * 
	 * 找到交易记录表 判断是不是第一次评论 如果是直接品论 如果不是找到回复然后在进行评论 买家对这次交易进行评价
	 */
	@Override
	public String addComent(comment comm, goodsInfo info) {
		transaction_record record = new transaction_record();
		record = commentReplyDao.getRecordByInfoId(info.getGoods_id());
		if (record.getTransaction_id() != null && record.getTransaction_id().trim().length() > 0) {
			comm.setComment_id(BuildUuid.getUuid());
			comm.setComment_goods(info.getGoods_id());
			//set评论的用户
			comm.setComment_from_user(record.getTransaction_from_user());
			//set回复的用户
			comm.setComment_to_user(record.getTransaction_to_user());
		}

		return null;
	}

	/**
	 * 查询用户的评论和回复
	 */
	@Override
	public List<comment> queryComment(goodsInfo info) {
		List<comment> lsitComm = new ArrayList<comment>();
		lsitComm =  commentReplyDao.getCommentByInfoId(info.getGoods_id());
		return lsitComm;
	}

}
