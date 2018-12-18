package com.fleaMarket.goodsType.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;
import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;
import com.fleaMarket.goodsType.DTO.TypeDTO;
import com.fleaMarket.goodsType.VO.TypeVO;
import com.fleaMarket.goodsType.dao.GoodsTypeDao;
import com.fleaMarket.goodsType.dao.DTO.GoodsTypeDTO;
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
	public String addType(type newType, typeOne typeOne) {
		String result = null;
		if (typeOne.getTypeOne_name()!=null&&typeOne.getTypeOne_name().trim().length()>0) {
			typeOne type1 = new typeOne();
			type1 = goodsTypeDao.getTypeOneByTypeOneName(typeOne.getTypeOne_name());
			if (type1 != null) {

					type type = new type();
					type = goodsTypeDao.getTypeByTypeName(newType.getType_name());
					
					if (type == null) {
						newType.setType_id(BuildUuid.getUuid());
						newType.setType_creationtime(TimeUtil.getStringSecond());
						newType.setType_modifytime(TimeUtil.getStringSecond());
						newType.setIs_delete(0);
						newType.setType_belong(type1.getTypeOne_id());
						System.out.println("qq" + newType);
						goodsTypeDao.saveOrUpdateObject(newType);
						result = "addSuccess";
					} else {
						result = "addFailed";
					}

				}
			}
		return result;
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
				System.out.println("123"+type);
				if (type!= null) {
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

	/**
	 * 类型的分级DTO
	 */
	@Override
	public List<GoodsTypeDTO> getListGoodsTypeDTO() {
		List<GoodsTypeDTO> listGoodsTypeDTO = new ArrayList<GoodsTypeDTO>();
		List<typeOne> typeOnes = new ArrayList<>();
		List<type> types = new ArrayList<>();
		typeOnes = (List<typeOne>) goodsTypeDao
				.listObject("from typeOne where is_delete='0' order by typeOne_modifytime desc");
		// System.out.println("1111"+typeOnes);
		if (!typeOnes.isEmpty()) {
			for (typeOne typeOne : typeOnes) {
				types = goodsTypeDao.getTypeByTypeOneId(typeOne.getTypeOne_id());
				GoodsTypeDTO goodsTypeDTO = new GoodsTypeDTO();
				if (!types.isEmpty()) {

					goodsTypeDTO.setListType(types);
				}
				goodsTypeDTO.setTypeOne(typeOne);
				listGoodsTypeDTO.add(goodsTypeDTO);
			}

		}
		return listGoodsTypeDTO;
	}

	/**
	 * 跟据一级栏目id查询二级栏目
	 * 
	 * @throws IOException
	 */
	@Override
	public List<type> getListType(typeOne typeOne) {
		List<type> types = new ArrayList<>();
		// System.out.println("hhh"+typeOne);
		types = goodsTypeDao.getTypeByTypeOneId(typeOne.getTypeOne_id());
		// System.out.println("qqqq"+types);
		if (!types.isEmpty()) {

			return types;
		}
		return null;
	}

	/**
	 * 类型的分类
	 */
	@Override
	public TypeVO getTypeVO() {
		TypeVO typeVO = new TypeVO();
		List<TypeDTO> listTypeDTO = new ArrayList<>();
		List<typeOne> listTypeOne = new ArrayList<>();
		List<type> listType;
		String listTypeHql = "from type where 1=1";
		String typeCountHql = "select count(*) from type where 1=1";
		// 这里如果不加desc表示正序，如果加上desc表示倒序
		typeCountHql = typeCountHql + "and is_delete='0' order by type_creationtime desc";
		int typeCount = goodsTypeDao.getCount(typeCountHql);
		// 设置总数量
		typeVO.setTotalRecords(typeCount);
		// 设置总页数
		typeVO.setTotalPages(((typeCount - 1) / typeVO.getPageSize()) + 1);
		// 判断是否拥有上一页
		if (typeVO.getPageIndex() <= 1) {
			typeVO.setHavePrePage(false);
		} else {
			typeVO.setHavePrePage(true);
		}
		// 判断是否拥有下一页
		if (typeVO.getPageIndex() >= typeVO.getTotalPages()) {

			typeVO.setHaveNextPage(false);
		} else {
			typeVO.setHaveNextPage(true);
		}
		listTypeOne = (List<typeOne>) goodsTypeDao.queryForPage(
				"from typeOne where is_delete='0' order by typeOne_modifytime desc", typeVO.getPageIndex(),
				typeVO.getPageSize());

		if (!listTypeOne.isEmpty()) {

			/**
			 * 遍历类型集合
			 */
			for (typeOne typeOne : listTypeOne) {
				TypeDTO typeDTO = new TypeDTO();
				listType = new ArrayList<>();

				listType = goodsTypeDao.getTypeByTypeOneId(typeOne.getTypeOne_id());
				typeDTO.setTypeOne(typeOne);
				typeDTO.setListType(listType);
				listTypeDTO.add(typeDTO);
			}
			typeVO.setListTypeDTO(listTypeDTO);
		}
		return typeVO;
	}

	/**
	 * 得到类型的DTO
	 */
	@Override
	public List<TypeDTO> getTypeDTO() {
		List<TypeDTO> listTypeDTO = new ArrayList<>();
		List<typeOne> listTypeOne = new ArrayList<>();
		List<type> listType;
		listTypeOne = (List<typeOne>) goodsTypeDao
				.listObject("from typeOne where is_delete='0' order by typeOne_modifytime desc");
		if (!listTypeOne.isEmpty()) {
			/**
			 * 遍历类型集合
			 */
			for (typeOne typeOne : listTypeOne) {
				TypeDTO typeDTO = new TypeDTO();
				listType = new ArrayList<>();
				listType = goodsTypeDao.getTypeByTypeOneId(typeOne.getTypeOne_id());
				typeDTO.setTypeOne(typeOne);
				typeDTO.setListType(listType);
				listTypeDTO.add(typeDTO);
			}
		}
		return listTypeDTO;
	}

	/**
	 * 添加一级类型
	 */
	@Override
	public String addTypeOne(typeOne typeOne) {
		String result = null;
		typeOne type1 = new typeOne();
		type1 = goodsTypeDao.getTypeOneByTypeOneName(typeOne.getTypeOne_name());
		if(type1 == null) {
		typeOne.setTypeOne_id(BuildUuid.getUuid());
		typeOne.setIs_delete(0);
		typeOne.setTypeOne_creationtime(TimeUtil.getStringSecond());
		typeOne.setTypeOne_modifytime(TimeUtil.getStringSecond());
		goodsTypeDao.saveOrUpdateObject(typeOne);
		result = "success";
		}else {
			result = "failed";
		}
		return result;
	}

}
