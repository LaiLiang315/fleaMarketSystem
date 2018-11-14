package goodsInfo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	public void TestTypePicInfoDTO() {
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
}
