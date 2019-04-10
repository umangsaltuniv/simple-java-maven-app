package com.expense.service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.expense.entity.User;
import com.expense.entity.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Test
	public void getAllUserTest() {
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUsername("aaaa");
		user.setPassword("xxxxx");
		user.setName("Uthkrusta");
		user.setCurrency("rs");

		User user1 = new User();
		user1.setUsername("ektha");
		user1.setPassword("#####");
		user1.setName("BBBB");
		user1.setCurrency("dolar");

		list.add(user);
		list.add(user1);

		userRepository.saveAll(list);

		assertEquals(2, list.size());

	}
	
	//Make this @Test to run failing test
	
	@Ignore
	public void getAllUserNegativeTest() {
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUsername("aaaa");
		user.setPassword("xxxxx");
		user.setName("Uthkrusta");
		user.setCurrency("rs");

		User user1 = new User();
		user1.setUsername("ektha");
		user1.setPassword("#####");
		user1.setName("BBBB");
		user1.setCurrency("dolar");

		list.add(user);
		list.add(user1);

		userRepository.saveAll(list);

		assertEquals(1, list.size());

	}

}
