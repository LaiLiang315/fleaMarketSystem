package com.fleaMarket.goodsInfoManager.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.type;
import com.fleaMarket.domain.user;
import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicsDTO;
import com.fleaMarket.goodsInfoManager.VO.GoodsManagerVO;
import com.fleaMarket.goodsInfoManager.VO.GoodsPicVO;
import com.fleaMarket.goodsInfoManager.VO.TypeInfoPicVO;
import com.fleaMarket.goodsInfoManager.dao.GoodsInfoManagerDao;
import com.fleaMarket.goodsInfoManager.service.GoodsInfoManagerService;

import util.BuildUuid;
import util.TimeUtil;

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
	 * 按类型分页查询每条信息的第一张图片
	 */
	@Override
	public GoodsManagerVO findSixGoodsVO(GoodsManagerVO goodsManagerVO) {
		List<GoodsManagerDTO> listGoodsManagerDTO = new ArrayList<>();
		List<goodsInfo> listGoodsInfo;
		List<type> listType = new ArrayList<>();
		String listGoodsInfoHql = "from goodsInfo where 1=1";
		String goodsInfoCountHql = "select count(*) from goodsInfo where 1=1";
		// 这里如果不加desc表示正序，如果加上desc表示倒序
		goodsInfoCountHql = goodsInfoCountHql + " order by goods_creationtime desc";
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
				if (!listGoodsInfo.isEmpty()) {
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
			goodsManagerVO.setListGoodsManagerDTO(listGoodsManagerDTO);
		}

		return goodsManagerVO;
	}

	/**
	 * 查询每个类型的所有信息的所有图集
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
				 * 遍历所有类型 跟据类型id查询listInfo 遍历listInfo 跟据info_Id查询listPic
				 */
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
		return listGoodsManagerDTO;

	}

	/**
	 * 添加商品信息
	 */
	@Override
	public String addGoods(goodsInfo info) {
		info.setGoods_id(BuildUuid.getUuid());
		info.setGoods_creationtime(TimeUtil.getStringSecond());
		info.setGoods_modifytime(TimeUtil.getStringSecond());
		info.setGoods_state("出售中");
		goodsInfoManagerDao.saveOrUpdateObject(info);
		return null;
	}

	/**
	 * 查询最新六条信息和第一张图片
	 * 
	 * @return
	 */
	@Override
	public List<GoodsPicDTO> findFirstPicLatestDTO() {
		List<GoodsPicDTO> listGoodsPicDTO = new ArrayList<>();
		List<goodsInfo> ListInfo = new ArrayList<>();
		ListInfo = goodsInfoManagerDao.getSixInfoBytime();
		if (!ListInfo.isEmpty()) {
			for (goodsInfo info : ListInfo) {
				GoodsPicDTO goodsPicDTO = new GoodsPicDTO();
				picture pic = new picture();
				pic = goodsInfoManagerDao.getFirstPicByInfoId(info.getGoods_id());
				if (pic != null) {
					goodsPicDTO.setPic(pic);
				}
				goodsPicDTO.setInfo(info);
				listGoodsPicDTO.add(goodsPicDTO);
			}

		}
		return listGoodsPicDTO;
	}

	/**
	 * 查询每个类型售价最低的四条信息和第一张图片
	 */
	@Override
	public List<GoodsManagerDTO> findFourInfoDTO() {
		List<GoodsManagerDTO> listGoodsManagerDTO = new ArrayList<>();
		List<type> listType = new ArrayList<>();
		listType = (List<type>) goodsInfoManagerDao
				.listObject("from type where is_delete='0' order by type_modifytime desc");
		for (type type : listType) {
			List<goodsInfo> ListInfo = new ArrayList<>();
			List<GoodsPicDTO> listGoodsPicDTO = new ArrayList<>();
			ListInfo = (List<goodsInfo>) goodsInfoManagerDao.getCheapestFourInfoByTypeId(type.getType_id());
			/**
			 * 把类型set进dto
			 */
			/**
			 * 遍历所有类型 跟据类型id查询listInfo 遍历listInfo 跟据info_Id查询listPic
			 */
			if (!ListInfo.isEmpty()) {
				for (goodsInfo info : ListInfo) {
					picture Pic = new picture();
					GoodsPicDTO goodsPicDTO = new GoodsPicDTO();
					goodsPicDTO.setInfo(info);
					Pic = goodsInfoManagerDao.getFirstPicByInfoId(info.getGoods_id());

					if (Pic != null) {
						goodsPicDTO.setPic(Pic);
						listGoodsPicDTO.add(goodsPicDTO);
					}
				}
				GoodsManagerDTO goodsManagerDTO = new GoodsManagerDTO();
				goodsManagerDTO.setListGoodsPicDTO(listGoodsPicDTO);
				goodsManagerDTO.setType(type);
				listGoodsManagerDTO.add(goodsManagerDTO);
			}
		}
		return listGoodsManagerDTO;
	}

	/**
	 * 根据类型id查询所有信息
	 */
	@Override
	public TypeInfoPicVO findAllGoodsByTypeVO(TypeInfoPicVO typeInfoPicVO, type typeId) {
		List<GoodsPicDTO> listGoodsPicDTO = new ArrayList<>();
		List<goodsInfo> listGoodsInfo = new ArrayList<>();

		String listGoodsInfoHql = "from goodsInfo where goods_type='" + typeId.getType_id() + "'";
		String goodsInfoCountHql = "select count(*) from goodsInfo where goods_type='" + typeId.getType_id() + "'";
		// 这里如果不加desc表示正序，如果加上desc表示倒序
		goodsInfoCountHql = goodsInfoCountHql + " order by goods_creationtime desc";
		int goodsInfoCount = goodsInfoManagerDao.getCount(goodsInfoCountHql);
		// 设置总数量
		typeInfoPicVO.setTotalRecords(goodsInfoCount);
		// 设置总页数
		typeInfoPicVO.setTotalPages(((goodsInfoCount - 1) / typeInfoPicVO.getPageSize()) + 1);
		// 判断是否拥有上一页
		if (typeInfoPicVO.getPageIndex() <= 1) {
			typeInfoPicVO.setHavePrePage(false);
		} else {
			typeInfoPicVO.setHavePrePage(true);
		}
		// 判断是否拥有下一页
		if (typeInfoPicVO.getPageIndex() >= typeInfoPicVO.getTotalPages()) {

			typeInfoPicVO.setHaveNextPage(false);
		} else {
			typeInfoPicVO.setHaveNextPage(true);
		}
		listGoodsInfo = (List<goodsInfo>) goodsInfoManagerDao.queryForPage(
				"from goodsInfo where goods_type='" + typeId.getType_id() + "' order by goods_creationtime desc",
				typeInfoPicVO.getPageIndex(), typeInfoPicVO.getPageSize());
		if (!listGoodsInfo.isEmpty()) {
			for (goodsInfo info : listGoodsInfo) {
				GoodsPicDTO goodsPicDTO = new GoodsPicDTO();
				picture pic = new picture();
				pic = goodsInfoManagerDao.getFirstPicByInfoId(info.getGoods_id());
				if (pic != null) {
					goodsPicDTO.setPic(pic);
				}
				goodsPicDTO.setInfo(info);
				listGoodsPicDTO.add(goodsPicDTO);
			}
			typeInfoPicVO.setListGoodsPicDTO(listGoodsPicDTO);
		}
		return typeInfoPicVO;
	}

	/**
	 * 跟据二级菜单id找一级菜单
	 */
	@Override
	public type getTypeOneByTypeId(type typeId) {
		type type = new type();
		type = goodsInfoManagerDao.getTypeOneByTypeId(typeId.getType_id());

		return type;
	}

	/**
	 * 跟据商品信息id查询图片
	 */
	@Override
	public List<picture> getPicsByGoodsId(String data_id) {
		List<picture> listPics = new ArrayList<>();
		listPics = goodsInfoManagerDao.getPicsByInfoId(data_id);
		if (!listPics.isEmpty()) {
			return listPics;
		}
		return null;
	}

	/**
	 * 跟据商品信息查询商品
	 */
	@Override
	public goodsInfo getgoodsInfoByGoodsId(String data_id) {
		goodsInfo info = new goodsInfo();
		info = goodsInfoManagerDao.getInfoByGoodsId(data_id);
		if (info != null) {
			return info;
		}
		return null;
	}

	/**
	 * 根据商品id查询用户信息
	 * 
	 */
	@Override
	public user getUserInfoByGoodsId(String data_id) {
		goodsInfo info = new goodsInfo();
		info = goodsInfoManagerDao.getInfoByGoodsId(data_id);
		if (info != null) {
			user user = new user();
			user = goodsInfoManagerDao.getUserByGoodsId(info.getGoods_belong());
			if (user != null) {
				return user;
			}
		}
		return null;
	}

	/**
	 * 查询用户发布的商品
	 */
	@Override
	public GoodsPicVO getPublishedGoodsVO(user newUser) {
		GoodsPicVO goodsPicVO = new GoodsPicVO();
		List<GoodsPicDTO> listGoodsPicDTO = new ArrayList<>();
		List<goodsInfo> listInfo = new ArrayList<>();
		String listGoodsInfoHql = "from goodsInfo where 1=1";
		String goodsInfoCountHql = "select count(*) from goodsInfo where 1=1";
		// 这里如果不加desc表示正序，如果加上desc表示倒序
		goodsInfoCountHql = goodsInfoCountHql + " order by goods_creationtime desc";
		int goodsInfoCount = goodsInfoManagerDao.getCount(goodsInfoCountHql);
		// 设置总数量
		goodsPicVO.setTotalRecords(goodsInfoCount);
		// 设置总页数
		goodsPicVO.setTotalPages(((goodsInfoCount - 1) / goodsPicVO.getPageSize()) + 1);
		// 判断是否拥有上一页
		if (goodsPicVO.getPageIndex() <= 1) {
			goodsPicVO.setHavePrePage(false);
		} else {
			goodsPicVO.setHavePrePage(true);
		}
		// 判断是否拥有下一页
		if (goodsPicVO.getPageIndex() >= goodsPicVO.getTotalPages()) {

			goodsPicVO.setHaveNextPage(false);
		} else {
			goodsPicVO.setHaveNextPage(true);
		}
		listInfo = goodsInfoManagerDao.getInfoByUserId(newUser.getUser_id());
		if (listInfo!=null) {
			for (goodsInfo info : listInfo) {
				picture pic = new picture();
				pic = goodsInfoManagerDao.getFirstPicByInfoId(info.getGoods_id());
				if(pic!=null) {
					GoodsPicDTO goodsPicDTO = new GoodsPicDTO();
					goodsPicDTO.setPic(pic);
					goodsPicDTO.setInfo(info);
					listGoodsPicDTO.add(goodsPicDTO);
				}
			}
			goodsPicVO.setListGoodsPicDTO(listGoodsPicDTO);
		}
		System.out.println("JJJ"+goodsPicVO);
		return goodsPicVO;
	}

	/**
	 * 跟据id删除商品和图片
	 */
	@Override
	public String deleteGoods(String data_id) {
		goodsInfo info = new goodsInfo();
		info = goodsInfoManagerDao.getInfoByGoodsId(data_id);
		System.out.println("11:"+info);
		goodsInfoManagerDao.removeObject(info);
		if(info!=null) {
			List<picture> listPic = new ArrayList<>();
			listPic =goodsInfoManagerDao.getPicsByInfoId(data_id);
			for (picture pic : listPic) {
				System.out.println("22:"+pic);
				goodsInfoManagerDao.removeObject(pic);
			}
		}
		return null;
	}

	//跟据用户id查询用户收藏的信息
	@Override
	public GoodsPicVO getUserWangtsVO(user newUser) {
		if(newUser!=null && newUser.getUser_id().trim().length()>0) {GoodsPicVO goodsPicVO = new GoodsPicVO();
		List<GoodsPicDTO> listGoodsPicDTO = new ArrayList<>();
		List<goodsInfo> listInfo = new ArrayList<>();
		String listGoodsInfoHql = "from goodsInfo where 1=1";
		String goodsInfoCountHql = "select count(*) from goodsInfo where 1=1";
		// 这里如果不加desc表示正序，如果加上desc表示倒序
		goodsInfoCountHql = goodsInfoCountHql + " order by goods_creationtime desc";
		int goodsInfoCount = goodsInfoManagerDao.getCount(goodsInfoCountHql);
		// 设置总数量
		goodsPicVO.setTotalRecords(goodsInfoCount);
		// 设置总页数
		goodsPicVO.setTotalPages(((goodsInfoCount - 1) / goodsPicVO.getPageSize()) + 1);
		// 判断是否拥有上一页
		if (goodsPicVO.getPageIndex() <= 1) {
			goodsPicVO.setHavePrePage(false);
		} else {
			goodsPicVO.setHavePrePage(true);
		}
		// 判断是否拥有下一页
		if (goodsPicVO.getPageIndex() >= goodsPicVO.getTotalPages()) {

			goodsPicVO.setHaveNextPage(false);
		} else {
			goodsPicVO.setHaveNextPage(true);
		}
		listInfo = goodsInfoManagerDao.getUserWangtsByUserId(newUser.getUser_id());
		if (listInfo!=null) {
			for (goodsInfo info : listInfo) {
				picture pic = new picture();
				pic = goodsInfoManagerDao.getFirstPicByInfoId(info.getGoods_id());
				if(pic!=null) {
					GoodsPicDTO goodsPicDTO = new GoodsPicDTO();
					goodsPicDTO.setPic(pic);
					goodsPicDTO.setInfo(info);
					listGoodsPicDTO.add(goodsPicDTO);
				}
			}
			goodsPicVO.setListGoodsPicDTO(listGoodsPicDTO);
		}
		return goodsPicVO;
		}
		return null;
	}
	/**
	 * 跟据id删除收藏商品和图片
	 */
	@Override
	public String deleteGoodsUserWant(String data_id) {
		 goodsInfo info = new goodsInfo();
		info = goodsInfoManagerDao.getInfoByGoodsId(data_id);
		if(info!=null) {
			info.setGoods_userWants(null);
			goodsInfoManagerDao.saveOrUpdateObject(info);
		}
		return null;
	}

}
