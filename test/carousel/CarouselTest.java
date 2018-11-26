package carousel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fleaMarket.carouselManager.service.CarouselManagerService;
import com.fleaMarket.domain.carousel;

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
	public void findCarouselsTest() {
		List<carousel> listCarousel = new ArrayList<>();
		
		listCarousel = carouselManagerService.findCarousels();
		
		System.out.println("listCarousel"+listCarousel);
	}
	
	
}
