package com.fleaMarket.carouselManager.service.impl;

import javax.persistence.SecondaryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleaMarket.carouselManager.dao.CarouselManagerDao;
import com.fleaMarket.carouselManager.service.CarouselManagerService;

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
	

}
