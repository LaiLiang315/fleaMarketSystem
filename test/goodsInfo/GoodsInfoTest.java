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
	public void TestTypePicInfoDTO() {
		List<GoodsManagerDTO> listGoodsManagerDTO = new ArrayList<>();
		GoodsManagerDTO goodsManagerDTO = new GoodsManagerDTO();
		type type = new type();
//		type.setType_id("Type001");
		listGoodsManagerDTO = goodsInfoManagerService.queryGoodsManagerDTO();
		System.out.println("++++"+listGoodsManagerDTO);
	}
}
