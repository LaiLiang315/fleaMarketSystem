package goodsInfo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fleaMarket.domain.goodsInfo;
import com.fleaMarket.domain.picture;
import com.fleaMarket.domain.type;
import com.fleaMarket.goodsInfoManager.DTO.GoodsManagerDTO;
import com.fleaMarket.goodsInfoManager.DTO.GoodsPicDTO;
import com.fleaMarket.goodsInfoManager.VO.GoodsManagerVO;
import com.fleaMarket.goodsInfoManager.VO.TypeInfoPicVO;
import com.fleaMarket.goodsInfoManager.service.GoodsInfoManagerService;

/**
 * 类型测试类
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class GoodsInfoTest {
	@Resource
	private GoodsInfoManagerService goodsInfoManagerService;

	public GoodsInfoManagerService getGoodsInfoManagerService() {
		return goodsInfoManagerService;
	}

	public void setGoodsInfoManagerService(GoodsInfoManagerService goodsInfoManagerService) {
		this.goodsInfoManagerService = goodsInfoManagerService;
	}
	@Test
	public void TestFindSixGoodsVO() {
		GoodsManagerVO goodsManagerVO = new GoodsManagerVO();
		
		goodsManagerVO=goodsInfoManagerService.findSixGoodsVO(goodsManagerVO);
		System.out.println("6666666"+goodsManagerVO);
		
	}
	
	
	@Test
	public void TestGoodsManagerDTO() {
		List<GoodsManagerDTO> listGoodsManagerDTO = new ArrayList<>();
		GoodsManagerDTO goodsManagerDTO = new GoodsManagerDTO();
		type type = new type();
//		type.setType_id("Type001");
		listGoodsManagerDTO = goodsInfoManagerService.queryGoodsManagerDTO();
		System.out.println("++++"+listGoodsManagerDTO);
	}
	/**
	 * 按类型查询四条最便宜的条记录
	 */
	@Test
	public void TestFindFourInfoDTO() {
		List<GoodsManagerDTO> listGoodsManagerDTO = new ArrayList<>();
		listGoodsManagerDTO = goodsInfoManagerService.findFourInfoDTO();
		System.out.println("KKKKK"+listGoodsManagerDTO);
	}
	/**
	 * 查询罪行上架的六条记录
	 */
	@Test
	public void TestFindFirstPicLatestDTO() {
		List<GoodsPicDTO> listGoodsPicDTO = new ArrayList<>();
		listGoodsPicDTO = goodsInfoManagerService.findFirstPicLatestDTO();
	}
//	findAllGoodsByTypeVO
	@Test
	public void findAllGoodsByTypeVO() {
		TypeInfoPicVO typeInfoPicVO = new TypeInfoPicVO();
		type typeId = new type();
		typeId.setType_id("Type001");
		typeInfoPicVO.setPageIndex(1);
		typeInfoPicVO = goodsInfoManagerService.findAllGoodsByTypeVO(typeInfoPicVO, typeId);
	System.out.println("typeInfoPicVO"+typeInfoPicVO);
	}
	
	@Test
	public void getTypeOneByTypeId() {
		type type = new type();
		type.setType_id("Type001");
		 goodsInfoManagerService.getTypeOneByTypeId(type);
		System.out.println("wwww"+goodsInfoManagerService.getTypeOneByTypeId(type));
	}
	/**
	 * 跟据信息id查询图片
	 */
	@Test
	public void getPicsByGoodsIdTest() {
		String data_id = "a2b6a69b-d618-4f47-9138-4a7b0dbb9f8f";
		List<picture> listPics = new ArrayList<>();
		listPics = goodsInfoManagerService.getPicsByGoodsId(data_id);
		System.out.println("DFP:"+listPics);
	}
	/**
	 * 跟据商品id查询商品信息
	 */
	@Test
	public void getInfoByGoodsIdTest() {
		String data_id = "a2b6a69b-d618-4f47-9138-4a7b0dbb9f8f";
		goodsInfo info = new goodsInfo();
		info = goodsInfoManagerService.getgoodsInfoByGoodsId(data_id);
		System.out.println("SS:"+info);
	}
}
