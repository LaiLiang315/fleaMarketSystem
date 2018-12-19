package carousel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fleaMarket.carouselManager.VO.CarouselVO;
import com.fleaMarket.carouselManager.service.CarouselManagerService;
import com.fleaMarket.domain.carousel;
import com.fleaMarket.loginRegister.VO.UserVO;

/**
 * 轮播图测试类
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class CarouselTest {
	@Resource
	private CarouselManagerService carouselManagerService;

	public CarouselManagerService getCarouselManagerService() {
		return carouselManagerService;
	}

	public void setCarouselManagerService(CarouselManagerService carouselManagerService) {
		this.carouselManagerService = carouselManagerService;
	}
	/**
	 * 查询轮播图测试
	 */
	@Test
	public void findCarouselTest() {
		
		
	}
	//测试跟据username查询用户
	@Test 
	public void getCarouselVOTest() {
		CarouselVO carouselVO = new CarouselVO();
		carouselVO=carouselManagerService.getCarouselVO();
		System.out.println("JJSS"+carouselVO);
	}
	
}
