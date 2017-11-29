package com.dragon.springcloud.microservicesimpleprovideruser;

import com.dragon.springcloud.microservicesimpleprovideruser.dao.UserRepository;
import com.dragon.springcloud.microservicesimpleprovideruser.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroserviceSimpleProviderUserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MicroserviceSimpleProviderUserApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void test() {
		User user=userRepository.findOne(1L);
		System.out.println(user);

		ResponseEntity<String> responseEntity=testRestTemplate.getForEntity("/user/2", String.class);
		System.out.println(responseEntity.getBody());

		System.out.println(testRestTemplate.getForObject("/user/3", User.class).toString());
	}

}
