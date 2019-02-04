package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class ITHtmlUnitBrowser {
	
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
	driver = new HtmlUnitDriver();
	}
/*
	@Test
	public void test1() {
		driver.get("http://localhost:9090");
		String expectedTitle = "Welcome";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
	}
*/

	@Test
	public void test2() {
		driver.get("http://newtours.demoaut.com/");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);
		System.out.println("Hello");
	}
     
        @Test
    	public void test3() {
        	driver.get("https://www.google.co.in/");
    		String expectedTitle = "Google";
    		String actualTitle = driver.getTitle();
    		assertEquals(expectedTitle, actualTitle);
            System.out.println(actualTitle);
	}
	
	@After
	public void tearDown() throws Exception {
	}


}
