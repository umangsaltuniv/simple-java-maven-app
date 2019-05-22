package com.expense.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpenseManagerSystemTests {
 
WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
	driver = new HtmlUnitDriver();
	}

	@Test
	public void titleTest() {
		driver.get("http://localhost:8089");
		String expectedTitle = "Login page";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
	}

	
	@AfterTest
	public void tearDown() throws Exception {
	}

	  
	  
  
}
