package com.fleaMarket.goodsType.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fleaMarket.domain.type;
import com.fleaMarket.goodsType.dao.GoodsTypeDao;

/**
 * 商品类型管理dao层实现层
 * 
 * @author LL
 *
 */
public class GoodsTypeDaoImpl implements GoodsTypeDao {

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
	 * 跟据类型名称查找类型
	 * @param trim 
	 */
	
	@Override
	public type getTypeByTypeName(Object trim) {
		type type = new type();
		Session session = getSession();
		String hql ="from type where type_name= :ID ";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		type = (type)query.uniqueResult();
		if(type!=null) {
			return type;
		}
		return null;
	}
	/**
	 * 跟据类型id查找类型
	 * @param trim 
	 */
	@Override
	public type getTypeByTypeId(Object trim) {
		type type = new type();
		Session session = getSession();
		String hql ="from type where type_id= :ID ";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		type = (type)query.uniqueResult();
		if(type!=null) {
			return type;
		}
		return null;
	}
}
