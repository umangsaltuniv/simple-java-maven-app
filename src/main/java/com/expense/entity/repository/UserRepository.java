package com.expense.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.entity.User;

//repository interface and an implementation to access our User domain objects from an in-memory database.
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByName(String name);

	public User findByPassword(String password);

	public User findByUsername(String username);

}
