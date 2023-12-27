package com.dynamite.facebook;

import com.dynamite.facebook.model.entity.User;
import com.dynamite.facebook.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FacebookApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Test
	void contextLoads() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setEmail("admin");
		userRepository.save(user);
	}

}
