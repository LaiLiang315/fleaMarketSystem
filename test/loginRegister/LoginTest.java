package loginRegister;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fleaMarket.domain.user;
import com.fleaMarket.loginRegister.VO.UserVO;
import com.fleaMarket.loginRegister.service.LoginRegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class LoginTest {
	@Resource
	private LoginRegisterService loginRegisterService;
	
  public LoginRegisterService getLoginRegisterService() {
		return loginRegisterService;
	}

	public void setLoginRegisterService(LoginRegisterService loginRegisterService) {
		this.loginRegisterService = loginRegisterService;
	}
	//登陆测试
@Test
public void loginTest1() {
	  user newUser = new user();
	  newUser.setUsername("111");
	  newUser.setPassword("1");
	   loginRegisterService.login(newUser);
	  
  }
//测试跟据username查询用户
@Test 
 public void getUserByUserNameTest() {
	user newUser = new user();
	newUser.setUsername("15079917292");
	loginRegisterService.getUserByUserName(newUser);
	System.out.println("JJSS"+loginRegisterService.getUserByUserName(newUser));
}
//测试跟据username查询用户
@Test 
public void getUserVOTest() {
	UserVO userVO = new UserVO();
	userVO=loginRegisterService.getUserVO();
	System.out.println("JJSS"+userVO);
}
}
