package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gondr.domain.UserVO;
import net.gondr.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class UserServiceTest {
	@Autowired
	private UserService service;
	
	//@Test
	public void insertUser(){
		UserVO user = new UserVO();
		user.setName("최선한");
		user.setPassword("1234");
		user.setUserid("gondr99");
		user.setImg("");
		
		service.register(user);
	}
	
	//@Test
	public void loginUser() {
		UserVO user = service.login("gondr99", "1234");
		System.out.println(user);
	}
	
	//@Test
	public void userInfo() {
		UserVO user = service.getUserInfo("gondr99");
		System.out.println(user);
	}
	
}

