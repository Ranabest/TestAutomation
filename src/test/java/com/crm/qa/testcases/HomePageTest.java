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

public class HomePageTest extends TestBase {
	
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	TestUtil testUtil;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	NewContactPage newcontactpage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		testUtil.popUp();
		loginpage = new LoginPage();
		contactpage = new ContactPage();
		homepage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Logged in successfully");
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO");
		log.info("HomePage title is verified");
	}

	@Test(priority = 2)
	public void verifyContactLinkTest() {
		testUtil.switchToFrame();
		contactpage = homepage.verifyContactLink();
		log.info("Contact Links are working appropriately");
	}

	@Test(priority = 3)
	public void verifyNewContactLinkTest() {
		testUtil.switchToFrame();
		newcontactpage=homepage.verifyNewContactLink();
		log.info("HomePage title in verified");
	}

	@Test(priority = 4)
	public void verifyDealsLinkTest() {
		// testUtil.popUp();
		testUtil.switchToFrame();
		homepage.verifyDealsLink();
		log.info("Deals Link is tested");
	}

	@Test(priority = 5)
	public void verifyTasksLinkTest() {
		testUtil.switchToFrame();
		homepage.verifyTasksLink();
		log.info("Tasks Link is tested");
	}

	@Test(priority = 6)
	public void verifyCorrectUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUser());
		log.info("User Name text is visible");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Home PageTest is closed");
	}
}
