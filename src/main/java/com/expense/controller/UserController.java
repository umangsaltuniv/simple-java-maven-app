package com.expense.controller;

import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.expense.entity.User;
import com.expense.service.UserService;

/*This UserController class and its action method handles incoming browser requests, retrieves necessary model data 
 * and returns appropriate responses*/
@Controller
public class UserController {

	Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	UserService userService;

	/*
	 * This method used to create a blank user registration list so that we can
	 * enter data using post mapping
	 */
	@GetMapping("/add-user")
	public String showForm(Model model) {

		User user = new User();
		model.addAttribute("User", user);
		return "register.jsp";
	}

	/*
	 * This method used to enter data for registration page
	 */

	@PostMapping(value = "/add-user")
	public String submit(@Valid @ModelAttribute("User") User user, BindingResult result, Model model) {

		log.info("Incoming user: " + user);

		if (userService.getByUsername(user.getUsername()) != null) {
			log.info("User already exist redirecting");
			model.addAttribute("ErrorText", "User already exist!");
			User userNew = new User();
			model.addAttribute("User", userNew);
			return "register.jsp";
			// return "redirect:/add-user";
		}
		if (result.hasErrors()) {
			return "error";
		}
		log.info("user page: " + user);

		User savedUser = userService.save(user);

		log.info("saved user " + savedUser);

		User principal = userService.getDefaultUser();

		return "login.jsp";
	}

}
