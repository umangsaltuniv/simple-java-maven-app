package com.expense;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*This annotation is used for auto-configuration, component scan 
*and be able to define extra configuration on their "application class".
*It is same as @Configuration @EnableAutoConfiguration @ComponentScan
*/
@SpringBootApplication 
public class ExpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseApplication.class, args);
	}
	
	/*
	 * @Bean is only a method-level annotation and it cannot be used with classes
	 * and object declaration.
	 * This annotation is used to register the bean 
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	
}
