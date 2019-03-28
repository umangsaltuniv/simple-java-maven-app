package com.expense.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.expense.entity.Expense;
import com.expense.entity.User;

//repository interface and an implementation to access our Expense domain objects from an in-memory database.
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	public List<Expense> findByExpenseHead(String name);

	public List<Expense> findByUser(User user);
	
	/*
	 * @Modifying annotation is used to enhance the 
	 * @Query annotation to execute not only SELECT queries but also INSERT, UPDATE, DELETE, and even DDL queries(non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */

	@Modifying
	@Query("delete from Expense where id = :id ")
	public void deleteById(@Param("id") Long id);
}
