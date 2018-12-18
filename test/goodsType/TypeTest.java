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
import com.fleaMarket.goodsType.DTO.TypeDTO;
import com.fleaMarket.goodsType.VO.TypeVO;
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
		typeOne typeOne = new typeOne();
		typeOne.setTypeOne_name("一级衣服");
		type.setType_name("11");
		goodsTypeService.addType(type,typeOne);
		
		
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
   /**
    * 查询类型的分页
    */
   @Test
   public void TestgetTypeVO(){
	   TypeVO typeVO = new TypeVO();
	   typeVO = goodsTypeService.getTypeVO();
	   System.out.println("dd"+typeVO);
   }
   /**
    * 查询类型的分页
    */
   @Test
   public void TestgetTypeDTO(){
	   List<TypeDTO> listTypeDTO = new ArrayList<>();
	   listTypeDTO = goodsTypeService.getTypeDTO();
	   System.out.println("dd"+listTypeDTO);
   }
}
