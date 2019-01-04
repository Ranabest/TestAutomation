package com.crm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	public static Logger log = LogManager.getLogger(ContactPageTest.class.getName());
	TestUtil testUtil;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	NewContactPage newcontactpage;
	
	public ContactPageTest() {
		super();
		}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		testUtil.popUp();
		loginpage = new LoginPage();
		homepage= new HomePage();
		contactpage = new ContactPage();	
		homepage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactpage = homepage.verifyContactLink();
		//newcontactpage=homepage.verifyNewContactLink();
		log.info("contact PageTest is opened after logging in");
		
	}
	@Test(priority=1)
	public void verifyContactLogoTest() {
		Assert.assertTrue(contactpage.verifyContactLogo());
		log.info("Contact text label is appeared ");
		
	}
	@Test(priority=2)
	public void verifySavedContactLinkTest() {
		contactpage.verifySavedContactLink("Sonia Begum");//very important this test check the dynamic xpath
		log.info("contact link is working after saving the created new account");
	}
	@Test(priority=3)
	public void verifySelectSingleCheckboxTest() {
		contactpage.verifySelectSingleCheckbox();
		log.info("Single checkbox is selected");
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("contact PageTest is closed");
		
	}


}
