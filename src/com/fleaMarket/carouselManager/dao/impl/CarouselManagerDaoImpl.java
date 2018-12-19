package com.fleaMarket.carouselManager.dao.impl;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fleaMarket.carouselManager.dao.CarouselManagerDao;
import com.fleaMarket.domain.carousel;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.user;

public class CarouselManagerDaoImpl implements CarouselManagerDao {

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
	 * 根据id获取图片
	 */
	@Override
	public carousel getCarouselById(String trim) {
		carousel carousel = new carousel();
		Session session = getSession();
		String hql = "from carousel where is_delete='0' and carousel_id= :ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		carousel = (carousel) query.uniqueResult();
		return carousel;
	}

	/**
	 * 根据id获取图片
	 */
	@Override
	public picture getPicById(String trim) {
		picture picture = new picture();
		Session session = getSession();
		String hql = "from picture where is_delete='0' and picture_id=:ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		picture = (picture) query.uniqueResult();
		return picture;
	}

	// 获取带有特殊标记的图集信息
	@Override
	public List<picture> getSpectialPic(String pictrueName) {
		Session session = getSession();
		String hql = "from picture where picture_sequence='9999' and picture_name like '%" + pictrueName + "%'";
		Query query = session.createQuery(hql);
		List<picture> listPicture = (List<picture>) query.list();
		return listPicture;
	}

	// 获取第一张图片
	@Override
	public picture getFirstPic(String goodsInfoId) {

		Session session = getSession();
		String hql = "from picture where  is_delete='0' and picture_belong= '" + goodsInfoId + "'";
		Query query = session.createQuery(hql);
		picture firstPic = (picture) query.list().get(0);
		return firstPic;
	}

	@Override
	public user getUserById(String trim) {
		user user = new user();
		Session session = getSession();
		String hql = "from user where  is_delete='0' and user_id=:ID";
		Query query = session.createQuery(hql);
		query.setParameter("ID", trim);
		 user =(user) query.uniqueResult();
		return user;
	}

	/**
	 * 得到最大顺序
	 */
	@Override
	public String getMaxSequenceNum(Integer carousel_sequence) {
		Session session = getSession();
		String hql = "from carousel where  is_delete='0' and user_id=:ID";
		return null;
	}

	// /**
	// * 查询所有轮播图
	// */
	// @Override
	// public List<carousel> listCarousel() {
	// Session session = getSession();
	// String hql = "from carousel where"
	// return null;
	// }
}
