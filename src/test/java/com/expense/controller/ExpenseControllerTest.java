package com.expense.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.expense.ExpenseApplication;
import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.entity.repository.UserRepository;
import com.expense.service.ExpenseService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ExpenseApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ExpenseControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Mock
	private ExpenseService expenseService;

	@Autowired
	private UserRepository userRepository;

	@WithMockUser(value = "spring")
	@Test
	public void testGetExpense() throws Exception {

		mockMvc.perform(get("/expense-list")).andExpect(status().isOk()).andExpect(view().name("expenseList.jsp"))
				.andExpect(forwardedUrl("expenseList.jsp"))
				.andExpect(model().attribute("expeseList", Matchers.hasSize(2)));
	}

	@Before
	public void setUp() {
		User user = new User();
		user.setUsername("spring");
		user.setPassword("xxxxx");
		user.setName("Uthkrusta");
		user.setCurrency("rs");

		Expense expense = new Expense();
		expense.setDate("2016-03-01");
		expense.setExpenseHead("Taxi");
		expense.setAmount(600000.00);
		expense.setCurrency("dolar");
		expense.setExpenseCategory("xyz");
		expense.setIsRecurring(1);
		expense.setIsSelected(1);
		expense.setDetails("details");
		expense.setUser(user);

		Expense expense1 = new Expense();
		expense1.setDate("2015-01-07");
		expense1.setExpenseHead("Food");
		expense1.setAmount(900000.00);
		expense1.setCurrency("rs");
		expense1.setExpenseCategory("abc");
		expense1.setIsRecurring(0);
		expense1.setIsSelected(0);
		expense1.setDetails("detail");
		expense1.setUser(user);

		user.getExpenseList().add(expense);
		user.getExpenseList().add(expense1);

		userRepository.save(user);

	}

}
