package com.fleaMarket.commentReply.dao;

import java.util.List;
/**
 * 评论与回复的dao层
 * @author LL
 *
 */
public interface CommentReplyDao {
	/**
	 * 保存、更新对象
	 * 
	 * @author LL
	 * @date 2018/10/18
	 * @param obj
	 * @modify LL 2018/10/18
	 */
	public void saveOrUpdateObject(Object obj);

	/**
	 * 分页获取对象，这里是获取一页中的数据
	 * 
	 * @param hql
	 * @param offset
	 *            当前页
	 * @param length
	 *            获取每页记录数
	 * @return
	 */
	public List<?> queryForPage(String hql, int offset, int length);

	/**
	 * 获取对象总数量
	 * 
	 * @param hql
	 * @return
	 */
	public int getCount(String hql);

	/**
	 * 删除对象记录
	 * 
	 * @param obj
	 */
	public int removeObject(Object obj);

	/**
	 * 获取对象列表
	 */
	public List<?> listObject(String hql);
}
