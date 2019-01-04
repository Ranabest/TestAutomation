package com.crm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public static Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	
	LoginPage loginpage;
	HomePage homepage;	

	public LoginPageTest() {
		super();
	}	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("it successfully initialized");
		loginpage = new LoginPage();	
	}
	
	  @Test(priority=1)
	public void loginpageTitleTest() throws Exception{
		String title = loginpage.validateTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		log.info("Login Page title is verified");
	}
	
	@Test(priority=2)
	public void loginImageTest() {
		boolean image = loginpage.validatecrmLogo();
		Assert.assertTrue(image);
		log.info("log in logo is appeared accurately");
	}
	
	@Test(priority=3)
	public void loginTest() {
	  homepage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
	  log.info("logging in successfully");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("log in Page test closed");
		
	}
	
}

