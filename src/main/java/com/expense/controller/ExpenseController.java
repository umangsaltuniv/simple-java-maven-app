package com.expense.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.expense.dto.ExpenseDTO;
import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.mapper.ExpenseMapper;
import com.expense.service.ExpenseService;
import com.expense.service.UserService;

@Controller
public class ExpenseController {

	Logger log = Logger.getLogger(ExpenseController.class.getName());

	@Autowired
	ExpenseService expenseService;

	@Autowired
	UserService userService;

	@Autowired
	ExpenseMapper expenseMapper;

	// ---------------------------

	/*
	 * These get and post mappings have been implemented for the further
	 * modification of database like add new expenses, edit an existing data and
	 * delete data from database
	 */

	// It will map to the home.jsp page
	@GetMapping("/expense-home")
	public String getHomePage() {

		log.info(" processing to home page");
		return "home.jsp";
	}

	/*
	 * This mapping will show default list of expenses of an user and also add the
	 * new expense list created by the user
	 */
	@GetMapping("/expense-list")
	public String getExpenseList(Model model) {

		log.info(" processing");
		User user = userService.getDefaultUser();
		List<Expense> expenseList = expenseService.getExpenseByUserId(user.getId());
		System.out.println("expenseList: " + expenseList.size());
		model.addAttribute("user", user);
		model.addAttribute("expeseList", expenseList);
		log.info("login successful: " + expenseList);
		return "expenseList.jsp";
	}

	// It will map to the newExpense.jsp page to creating new expense list for the
	// user
	@GetMapping("/new-expense")
	public String addNewExpense(Model model) {
		User user = userService.getDefaultUser();
		ExpenseDTO expenseDTO = new ExpenseDTO();
		expenseDTO.setUserId(user.getId());
		expenseDTO.setCurrency(user.getCurrency());
		log.info("expenseDTO: " + expenseDTO);
		model.addAttribute("user", user);
		model.addAttribute("Expense", expenseDTO);
		return "newExpense.jsp";
	}

	// here after getting list of expenses, we can edit an existing expense data
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long expenseId, Model model) {

		Expense expense = expenseService.getById(expenseId);
		ExpenseDTO expenseDTO = expenseMapper.modelToDTOMap(expense);
		model.addAttribute("Expense", expenseDTO);
		log.info("in submitForm1: " + expenseDTO);

		User user = userService.getDefaultUser();
		model.addAttribute("user", user);
		return "/newExpense.jsp";
	}

	/*
	 * This mapping is for storing list of expense data of an user after clicking on
	 * submit botton first it will check expense id if expense id will match then
	 * only it will go for further processing
	 */
	@PostMapping("/submit-form")
	public String submitForm(@ModelAttribute("Expense") ExpenseDTO expenseDTO, Model model) {
		log.info("in submitForm: " + expenseDTO);

		if (expenseDTO.getId() != null) {
			log.info("Modify: " + expenseDTO.getId());
			Expense expense = expenseService.getById(expenseDTO.getId());
			expense = expenseMapper.dtoToModelMap(expenseDTO);
			expenseService.saveExpense(expense);
		} else {
			log.info("New");
			Expense expense = mapDTOToModel(expenseDTO);
			expenseService.saveExpense(expense);
		}
		return "redirect:/expense-list";
	}

	/*
	 * this method is used for getting all data of an entity by creating
	 * corresponding dto of an entity here ExpenseDTO is the corresponding dto for
	 * an Expense class where it can store data of an Expense class and also can get
	 * data from an Expense class
	 */

	private Expense mapDTOToModel(ExpenseDTO expenseDTO) {
		Expense expense = new Expense();
		expense = expenseMapper.dtoToModelMap(expenseDTO);
		User user = userService.getById(expenseDTO.getUserId());
		log.info("Got User" + user);
		expense.setUser(user);
		return expense;
	}

	// This mapping will delete an unused data from repository
	@GetMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long expenseId) {
		log.info("expenseId : " + expenseId);
		if (expenseId != null) {
			expenseService.deleteById(expenseId);

			log.info("count: " + expenseService.getExpenseByUserId(1l).size());
			log.info("deleted id: " + expenseId);

		} else {
			return "Something went wrong !";
		}
		return "redirect:/expense-list";
	}

	// This mapping is for logout
	@GetMapping("/logout")
	public String logoutPage() {

		return "redirect:/login?logout";
	}
	// You can redirect wherever you want, but generally it's a good practice to
	// show login screen again.

}