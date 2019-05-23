package com.expense.tests;

//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExpenseManagerSystemTest {
 
WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
	driver = new HtmlUnitDriver();
	}

	@Test
	public void titleTest() {
		driver.get("http://localhost:9191");
		String expectedTitle = "Login page";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
	}

	
	@After
	public void tearDown() throws Exception {
	}

	  
	  
  
}
