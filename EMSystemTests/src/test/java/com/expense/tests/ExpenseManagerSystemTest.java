package com.expense.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



public class ExpenseManagerSystemTest {

	
	@Test
	public void titleTest1() throws Exception{
		System.out.println("Start1");
		WebDriver driver;
		driver = new HtmlUnitDriver();
		
		driver.get("http://newtours.demoaut.com/");
		String expectedTitle = "Welcome: Mercury Tours";
		Thread.sleep(10000);
		//driver.get("http://localhost:9191");
		//String expectedTitle = "Login page";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
	}
	

}
