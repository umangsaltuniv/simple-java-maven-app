package com.expense.service;

import java.util.List;

import com.expense.entity.User;


public interface UserService {
	public void saveUser(List<User> userList);

	public List<User> getUser();

	public User getById(Long userId);

	public User getByPassword(String password);

	public User getByUsername(String username);
	
	public User save(User user);
	
	public User getDefaultUser();

}
