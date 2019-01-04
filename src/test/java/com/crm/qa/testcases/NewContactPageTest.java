package com.crm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase {
	public static Logger log = LogManager.getLogger(NewContactPageTest.class.getName());
	TestUtil testUtil;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	NewContactPage newcontactpage;
	
	String sheetName= "NewContacts";
	
	public NewContactPageTest() {
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
		//contactpage = homepage.verifyContactLink();
		newcontactpage=homepage.verifyNewContactLink();
		log.info("New contactPageTest is opened after logging in");
	}

	@Test(priority=1)
	public void verifyOwnerTest() {
		Assert.assertTrue(newcontactpage.verifyOwner());
		log.info("Owner name is displayed");
	}
	
	@DataProvider
	
	public Object [][] XXX() {
		
		Object [][] data = TestUtil.getTestData(sheetName);
		
		return data;
	}
	
	@Test(dataProvider ="XXX" )
	public void createNew(String FirstName,String LastName, String Company, String Supervisor, String Department, String Phone,String Fax) {
		newcontactpage.createNewAccount(FirstName, LastName, Company, Supervisor, Department, Phone, Fax);
	
	}
	/*@Test(priority=2)
	public void createNewAccountTest() {
		newcontactpage.createNewAccount("Mr.", "Sonia", "Begum", "Rahat", "MD");
		log.info(" user created new account successfully");
	}
	@Test(priority=3)
	public void verifyContactInfoLogoTest() {
		Assert.assertTrue(newcontactpage.verifyContactInfoLogo());
		log.info("Contact info label is displayed");
	}*/
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
		log.info("New contactPageTest is closed");
		
	}
	
	
	
}
