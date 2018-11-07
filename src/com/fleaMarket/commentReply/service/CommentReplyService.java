package com.fleaMarket.commentReply.service;

import java.util.List;

import com.fleaMarket.domain.comment;
import com.fleaMarket.domain.goodsInfo;

/**
 * 评论与回复的service层
 * @author LL
 *
 */
public interface CommentReplyService {

	/**
	 * 添加评论
	 * @param comm
	 * @param info
	 * @return
	 */
	String addComent(comment comm, goodsInfo info);

	/**
	 * 查询商品的评论回复
	 * @param info
	 * @return
	 */
	List<comment> queryComment(goodsInfo info);

}
