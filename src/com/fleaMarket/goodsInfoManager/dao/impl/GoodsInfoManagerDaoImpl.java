package com.fleaMarket.goodsInfoManager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.goodsInfoManager.dao.GoodsInfoManagerDao;
/**
 * 商品信息管理的dao层实现层
 * @author LL
 *
 */
public class GoodsInfoManagerDaoImpl implements GoodsInfoManagerDao {
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
	 * 根据类型Id查询商品信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<goodsInfo> getSixGoodsInfoByTypeId(String trim) {
		List<goodsInfo> listGoodsInfo = new ArrayList<>();
		Session session = getSession();
		String hql = "from goodsInfo where is_delete ='0' and  and production_info_type= :ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		if (!query.list().isEmpty()) {
			listGoodsInfo = (List<goodsInfo>) query.list();
		}
		return listGoodsInfo;
	}
	/**
	 * 通过信息id得到第一张图片
	 */
	@Override
	public picture getFirstPicByInfoId(String trim) {
		picture pic = new picture();
		Session session = getSession();
		String hql = "from picture where is_delete ='0' and picture_belong= :ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		if (!query.list().isEmpty()) {
			pic = (picture) query.list().get(0);
		}
		return pic;
	}
	/**
	 * 通过类型id查询商品信息
	 */
	@Override
	public List<goodsInfo> getGoodsInfoByTypeId(String trim) {
		List<goodsInfo> listInfo = new ArrayList<>();
		Session session = getSession();
		String hql = "from goodsInfo where goods_type= :ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		if (!query.list().isEmpty()) {
			listInfo = (List<goodsInfo>) query.list();
		}
		return listInfo;
	}
	/**
	 * 通过信息id查询商品图片
	 */
	@Override
	public List<picture> getPicsByInfoId(String trim) {
		List<picture> listPic = new ArrayList<>();
		Session session = getSession();
		String hql = "from picture where picture_belong= :ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		if (!query.list().isEmpty()) {
			listPic = (List<picture>) query.list();
		}
		return listPic;
	}
}
