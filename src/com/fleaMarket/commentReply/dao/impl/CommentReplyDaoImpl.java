package com.fleaMarket.commentReply.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fleaMarket.commentReply.dao.CommentReplyDao;
import com.fleaMarket.domain.carousel;
import com.fleaMarket.domain.comment;
import com.fleaMarket.domain.transaction_record;

public class CommentReplyDaoImpl implements CommentReplyDao {

	/**
	 * session注入
	 */
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * session注入结束
	 */

	/**
	 * 保存、更新对象
	 * 
	 * @author JXX
	 * @date 2018/04/12
	 * @param obj
	 * @modify JXX 2018/04/12
	 */
	@Override
	public void saveOrUpdateObject(Object obj) {
		Session session = getSession();
		session.saveOrUpdate(obj);
		session.flush();
	}

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
	@Override
	public List<?> queryForPage(String hql, int offset, int length) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult((offset - 1) * length);
		query.setMaxResults(length);
		List<?> list = query.list();
		session.clear();
		return list;
	}

	/**
	 * 获取对象总数量
	 * 
	 * @param hql
	 * @return
	 */
	@Override
	public int getCount(String hql) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (query.list().size() > 0) {
			return Integer.parseInt(query.list().get(0).toString());
		} else {
			return 0;
		}
	}

	/**
	 * 移除对象
	 */
	@Override
	public int removeObject(Object obj) {
		getSession().delete(obj);
		return 1;
	}

	/**
	 * 获取对象列表
	 */
	@Override
	public List<?> listObject(String hql) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		List<?> list = query.list();
		session.clear();
		return list;
	}

	/**
	 * 跟据信息id查询交易记录表中的买家
	 * 
	 * @param trim
	 */
	@Override
	public transaction_record getRecordByInfoId(String trim) {
		transaction_record record = new transaction_record();
		Session session = getSession();
		String hql = "from transaction_record where is_delete='0' and transaction_belong= :ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		record = (transaction_record) query.uniqueResult();
		return record;
	}

	/**
	 * 跟据信息id查询评论回复表中的信息
	 * 
	 * @param trim
	 */
	@Override
	public List<comment> getCommentByInfoId(String trim) {
		List<comment> listComment = new ArrayList<>();
		Session session = getSession();
		String hql = "from comment where is_delete='0' and comment_goods= :ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		listComment = (List<comment>) query.list();
		return listComment;
	}
}
