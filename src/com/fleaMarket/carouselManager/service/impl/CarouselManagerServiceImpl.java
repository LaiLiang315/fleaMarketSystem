package com.fleaMarket.carouselManager.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.SecondaryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleaMarket.carouselManager.dao.CarouselManagerDao;
import com.fleaMarket.carouselManager.service.CarouselManagerService;
import com.fleaMarket.domain.carousel;
import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.user;

import util.BuildUuid;
import util.ImgCompress;
import util.TimeUtil;

/**
 * 轮播图管理的service实现层
 * 
 * @author Administrator
 *
 */
public class CarouselManagerServiceImpl implements CarouselManagerService {

	private CarouselManagerDao carouselManageDao;

	public CarouselManagerDao getCarouselManageDao() {
		return carouselManageDao;
	}

	public void setCarouselManageDao(CarouselManagerDao carouselManageDao) {
		this.carouselManageDao = carouselManageDao;
	}

	/**
	 * 添加轮播图
	 */
	@Override
	public String addCarousel() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 删除轮播图
	 */
	@Override
	public String deleteCarousel(String idList) {
		String result = null;
		if (idList != null && idList.trim().length() > 0) {
			/**
			 * 将多个对象id去掉分隔符转化为数组
			 */
			String[] deleteIdList = idList.split(",");
			System.out.println(Arrays.toString(deleteIdList) + "uuuu" + deleteIdList[1]);
			/**
			 * 遍历数组String id : deleteIdList
			 */
			for (String id : deleteIdList) {
//				System.out.println("111111" + deleteIdList);
				carousel carousel = new carousel();
				carousel = carouselManageDao.getCarouselById(id);

//				System.out.println("AAAAA" + carousel);
				if (carousel != null) {
					carousel.setIs_delete(1);
					carousel.setCarousel_modifytime(TimeUtil.getStringSecond());
//					System.out.println("DDDDDD" + carousel);
					carouselManageDao.saveOrUpdateObject(carousel);
//					System.out.println("=======");
					result = "deleteSuccess";
				} else {
					result = "deleteFailed";
				}
				/**
				 * 如果数据库不存在需要删除的中转站的id
				 */
			}
		} else {
			result = "error";
		}
		return result;
	}

	/**
	 * 添加图片
	 */
	public void addPictrues(picture pic) {
		pic.setPicture_id(BuildUuid.getUuid());
		// 将图集顺序设置为特殊值，便去后面补充信息是重置
		pic.setPicture_creationtime(TimeUtil.getStringSecond());
		pic.setPicture_modifytime(TimeUtil.getStringSecond());
		pic.setIs_delete(0);
		carouselManageDao.saveOrUpdateObject(pic);
	}
	/**
	 * 添加并完善商品信息
	 */
	@Override
	public String addAndComplete(goodsInfo goodsInfo, String pictrueMap) {
		String result = null;
		// 首先添加作品信息
		// 生成uuid
		String goodsInfoId = BuildUuid.getUuid();
		goodsInfo.setGoods_id(goodsInfoId);
		goodsInfo.setGoods_state("出售中");
		goodsInfo.setGoods_creationtime(TimeUtil.getStringSecond());
		goodsInfo.setGoods_modifytime(TimeUtil.getStringSecond());
		carouselManageDao.saveOrUpdateObject(goodsInfo);
		String[] picIds = pictrueMap.split(",");
		int i=0;
		for (String picId : picIds) {
			i=i+1;
			picture pic = carouselManageDao.getPicById(picId.trim());
			//设置图片顺序
			pic.setPicture_sequence(i);
			if(pic!=null) {
				pic.setPicture_belong(goodsInfoId);
				carouselManageDao.saveOrUpdateObject(pic);
				result = "success";
			}else {
				result = "error";
			}
		}
		return result;
	}

	/**
	 * 用户添加轮播图
	 */
	@Override
	public void addCarousel(carousel carousel) {

		carousel.setCarousel_id(BuildUuid.getUuid());
		// 将图集顺序设置为特殊值，便去后面补充信息是重置
		carousel.setCarousel_creationtime(TimeUtil.getStringSecond());
		carousel.setCarousel_modifytime(TimeUtil.getStringSecond());
		carousel.setIs_delete(0);;
		carouselManageDao.saveOrUpdateObject(carousel);
	}

	//查询所有轮播图
	@Override
	public List<carousel> findCarousels() {
		List<carousel> listCarousel = new ArrayList<>();
		listCarousel = (List<carousel>) carouselManageDao.listObject("from carousel where is_delete='0' order by carousel_creationtime desc");
		if(!listCarousel.isEmpty()) {
			return listCarousel;
		}
		return null;
	}

	/**
	 * 添加头像
	 */
	@Override
	public void addHeadportrait(user user,String fileFileName) {
		user newUser = new user();
		newUser = carouselManageDao.getUserById(user.getUser_id());
		if(newUser!=null) {
			newUser.setUser_modifytime(TimeUtil.getStringSecond());
			newUser.setHeadportrait(fileFileName);
			carouselManageDao.saveOrUpdateObject(newUser);
		}
	}

	/**
	 * 保存个人信息
	 */
	@Override
	public user savePersonalInfo(user user) {
		System.out.println("JJ"+user);
		
		user newUser = new user();
		newUser = carouselManageDao.getUserById(user.getUser_id());
		if(newUser!=null) {
			newUser.setUser_modifytime(TimeUtil.getStringSecond());
			newUser.setAddress(user.getAddress());
			newUser.setNickname(user.getNickname());
			newUser.setSex(user.getSex());
			carouselManageDao.saveOrUpdateObject(newUser);
		}
		return user;
	}


}
