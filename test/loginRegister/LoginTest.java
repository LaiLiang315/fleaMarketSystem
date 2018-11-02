package loginRegister;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fleaMarket.domain.user;
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
@Test
public void loginTest1() {
	  user newUser = new user();
	  newUser.setUsername("111");
	  newUser.setPassword("12");
	  user user2= loginRegisterService.login(newUser);
	  System.out.println("wwwwwwwwwww"+user2);
  }
}
