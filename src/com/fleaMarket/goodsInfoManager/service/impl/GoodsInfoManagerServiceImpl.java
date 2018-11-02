package com.fleaMarket.goodsInfoManager.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.type;
import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicsDTO;
import com.fleaMarket.goodsInfoManager.VO.GoodsManagerVO;
import com.fleaMarket.goodsInfoManager.dao.GoodsInfoManagerDao;
import com.fleaMarket.goodsInfoManager.service.GoodsInfoManagerService;

/**
 * 商品信息的service层实现层
 * 
 * @author LL
 *
 */
public class GoodsInfoManagerServiceImpl implements GoodsInfoManagerService {

	private GoodsInfoManagerDao goodsInfoManagerDao;

	public GoodsInfoManagerDao getGoodsInfoManagerDao() {
		return goodsInfoManagerDao;
	}

	public void setGoodsInfoManagerDao(GoodsInfoManagerDao goodsInfoManagerDao) {
		this.goodsInfoManagerDao = goodsInfoManagerDao;
	}

	/**
	 * 分页查询六条
	 */
	@Override
	public GoodsManagerVO findSixGoodsVO(GoodsManagerVO goodsManagerVO) {
		List<GoodsManagerDTO> listGoodsManagerDTO = new ArrayList<>();
		List<goodsInfo> listGoodsInfo;
		List<type> listType = new ArrayList<>();
		String listGoodsInfoHql = "from goodsInfo where 1=1";
		String goodsInfoCountHql = "select count(*) from goodsInfo where 1=1";

		/*
		 * listGoodsInfo = (List<goodsInfo>)
		 * goodsInfoManagerDao.queryForPage(listGoodsInfoHql,
		 * goodsManagerVO.getPageIndex(), goodsManagerVO.getPageSize());
		 */
		// 这里如果不加desc表示正序，如果加上desc表示倒序
		goodsInfoCountHql = goodsInfoCountHql + " order by production_info_creationtime desc";
		int goodsInfoCount = goodsInfoManagerDao.getCount(goodsInfoCountHql);
		// 设置总数量
		goodsManagerVO.setTotalRecords(goodsInfoCount);
		// 设置总页数
		goodsManagerVO.setTotalPages(((goodsInfoCount - 1) / goodsManagerVO.getPageSize()) + 1);
		// 判断是否拥有上一页
		if (goodsManagerVO.getPageIndex() <= 1) {
			goodsManagerVO.setHavePrePage(false);
		} else {
			goodsManagerVO.setHavePrePage(true);
		}
		// 判断是否拥有下一页
		if (goodsManagerVO.getPageIndex() >= goodsManagerVO.getTotalPages()) {

			goodsManagerVO.setHaveNextPage(false);
		} else {
			goodsManagerVO.setHaveNextPage(true);
		}
		listType = (List<type>) goodsInfoManagerDao.queryForPage(
				"from type where is_delete='0' order by type_modifytime desc", goodsManagerVO.getPageIndex(),
				goodsManagerVO.getPageSize());

		if (!listType.isEmpty()) {

			/**
			 * 遍历类型集合
			 */
			for (type type : listType) {
				listGoodsInfo = new ArrayList<>();
				List<GoodsPicDTO> listGoodsPicDTO = new ArrayList<>();
				listGoodsInfo = goodsInfoManagerDao.getSixGoodsInfoByTypeId(type.getType_id());
				
				if(!listGoodsInfo.isEmpty()) {
					/**
					 * 遍历信息集合
					 */
					for (goodsInfo info : listGoodsInfo) {

						GoodsPicDTO goodsPicDTO = new GoodsPicDTO();
						picture pic = new picture();
						pic = goodsInfoManagerDao.getFirstPicByInfoId(info.getGoods_id());
						goodsPicDTO.setInfo(info);

						if (pic.getPicture_id() != null) {
							goodsPicDTO.setPic(pic);
						}
						listGoodsPicDTO.add(goodsPicDTO);
					}
					GoodsManagerDTO goodsManagerDTO = new GoodsManagerDTO();
					goodsManagerDTO.setListGoodsPicDTO(listGoodsPicDTO);
					goodsManagerDTO.setType(type);
					listGoodsManagerDTO.add(goodsManagerDTO);
				}
			}

		}

		return goodsManagerVO;
	}

	/**
	 * 类型信息图片dto
	 */
	@Override
	public List<GoodsManagerDTO> queryGoodsManagerDTO() {
		List<GoodsManagerDTO> listGoodsManagerDTO = new ArrayList<>();
		List<type> listType = new ArrayList<>();

		listType = (List<type>) goodsInfoManagerDao
				.listObject("from type where is_delete='0' order by type_modifytime desc");
		if (!listType.isEmpty()) {
			for (type type : listType) {
				List<goodsInfo> ListInfo = new ArrayList<>();
				List<GoodsPicsDTO> listGoodsPicsDTO = new ArrayList<>();
				ListInfo = (List<goodsInfo>) goodsInfoManagerDao.getGoodsInfoByTypeId(type.getType_id());
				/**
				 * 把类型set进dto
				 */
				/**
				 * 遍历所有类型
				 * 跟据类型id查询listInfo
				 * 遍历listInfo
				 * 跟据info_Id查询listPic
				 */
				if (!ListInfo.isEmpty()) {
					for (goodsInfo info : ListInfo) {
						List<picture> listPics = new ArrayList<>();
						GoodsPicsDTO goodsPicsDTO = new GoodsPicsDTO();
						goodsPicsDTO.setInfo(info);
						listPics = goodsInfoManagerDao.getPicsByInfoId(info.getGoods_id());
						
						if (!listPics.isEmpty()) {
							goodsPicsDTO.setListpic(listPics);
							listGoodsPicsDTO.add(goodsPicsDTO);
						}
					}
					GoodsManagerDTO goodsManagerDTO = new GoodsManagerDTO();
					goodsManagerDTO.setListGoodsPicsDTO(listGoodsPicsDTO);
					goodsManagerDTO.setType(type);
					listGoodsManagerDTO.add(goodsManagerDTO);
				}
			}
			
		}
		return listGoodsManagerDTO;
		
	}

}
