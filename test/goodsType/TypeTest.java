package goodsType;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fleaMarket.domain.type;
import com.fleaMarket.domain.typeOne;
import com.fleaMarket.goodsType.dao.DTO.GoodsTypeDTO;
import com.fleaMarket.goodsType.service.GoodsTypeService;

/**
 * 类型测试类
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class TypeTest {
	@Resource
	private GoodsTypeService goodsTypeService;

	public GoodsTypeService getGoodsTypeService() {
		return goodsTypeService;
	}

	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	@Test
	public void addTypeTest() {
		type type = new type();
		type.setType_name("西瓜");
		goodsTypeService.addType(type);
		
		
	}
	@Test
	public void goodsTypeDTOTest() {
		List<GoodsTypeDTO> listGoodsTypeDTO = new ArrayList<>();
		listGoodsTypeDTO = goodsTypeService.getListGoodsTypeDTO();
		System.out.println("*******"+listGoodsTypeDTO);
	}
	/**
	 * 跟据一级菜单id查询二级菜单
	 */
   @Test
   public void TestGetListType() {
	   typeOne typeOne = new typeOne();
	   List<type> listType = new ArrayList<>();
	   typeOne.setTypeOne_id("T1");
	   listType = goodsTypeService.getListType(typeOne);
	   System.out.println("HHHHHH"+listType);
   }
   
   
}
