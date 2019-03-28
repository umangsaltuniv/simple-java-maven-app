package com.expense.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.entity.repository.ExpenseRepository;
import com.expense.service.impl.ExpenseServiceImpl;

public class ExpenseServiceTest {

	@Mock
	ExpenseRepository expenseRepository;

	@InjectMocks
	ExpenseServiceImpl expenseServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllUserTest() {
		List<Expense> expenseList = new ArrayList<Expense>();
		User user1 = new User("supriya", "*****", "AAAA", "rs", expenseList);
		Expense expense1 = new Expense("2016-03-01", "sssss", 678995.97, "rs", "****", 1, 1, "details", user1);
		Expense expense2 = new Expense("2017-02-21", "rrrrr", 600000.00, "dolar", "@@@@", 1, 0, "detail", user1);
		Expense expense3 = new Expense("2018-05-22", "tttttt", 200000.00, "rs", "####", 0, 0, "nothing", user1);

		expenseList.add(expense1);
		expenseList.add(expense2);
		expenseList.add(expense3);

		when(expenseServiceImpl.getExpense()).thenReturn(expenseList);
		List<Expense> expenseList1 = expenseServiceImpl.getExpense();
		assertEquals(3, expenseList1.size());
	}

}
