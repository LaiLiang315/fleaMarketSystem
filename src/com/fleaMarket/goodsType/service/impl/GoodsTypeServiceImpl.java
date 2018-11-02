package com.fleaMarket.goodsType.service.impl;

import com.fleaMarket.domain.type;
import com.fleaMarket.goodsType.dao.GoodsTypeDao;
import com.fleaMarket.goodsType.service.GoodsTypeService;
import com.google.gson.JsonElement;

import util.BuildUuid;
import util.TimeUtil;

/**
 * 商品类型管理的service实现层
 * 
 * @author LL
 *
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {

	private GoodsTypeDao goodsTypeDao;

	public GoodsTypeDao getGoodsTypeDao() {
		return goodsTypeDao;
	}

	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}

	/**
	 * 添加类型
	 */
	@Override
	public String addType(type newType) {

		if (newType.getType_name() != null && newType.getType_name().trim().length() > 0) {

			type type = new type();
			type = goodsTypeDao.getTypeByTypeName(newType.getType_name());
			if (type.getType_name() == null) {
				newType.setType_id(BuildUuid.getUuid());
				newType.setType_creationtime(TimeUtil.getStringSecond());
				newType.setType_modifytime(TimeUtil.getStringSecond());
				newType.setIs_delete(0);
				goodsTypeDao.saveOrUpdateObject(newType);
			}
			if (type.getType_name() != null && type.getType_name().trim().length() > 0) {
				newType.setIs_delete(0);
				newType.setType_modifytime(TimeUtil.getStringSecond());
				goodsTypeDao.saveOrUpdateObject(newType);
			}
		}
		return null;
	}

	/**
	 * 批量删除类型
	 */
	@Override
	public String deleteType(String idList) {
		String result = "";
		if (!idList.isEmpty()) {
			/*
			 * 将获得的对象转化为数组
			 */
			String[] deleteTypeById = idList.split(",");
			/**
			 * 遍历需要删除的类型数组
			 */
			for (String id : deleteTypeById) {
				type type = new type();
				type = goodsTypeDao.getTypeByTypeId(id);
				if (type.getType_id() != null && type.getType_id().trim().length() > 0) {
					type.setIs_delete(1);
					goodsTypeDao.saveOrUpdateObject(type);
					result = "deleteSuccess";
				} else {
					result = "deleteFail";
				}
			}
		}
		return result;
	}

	/**
	 * 查询类型
	 */
	@Override
	public String findType() {
		
		return null;
	}

}
