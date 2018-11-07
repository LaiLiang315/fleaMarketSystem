package carousel;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fleaMarket.carouselManager.service.CarouselManagerService;

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
	 * 上传图片测试
	 */
	@Test
	public void fileUpLoad() {
		
		
		
		
		
	}
}
