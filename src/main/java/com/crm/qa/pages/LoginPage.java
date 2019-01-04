package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory or Object Repository: we create pageFactory to store all
	// individual page webElements(locators) and page actions(methods).
	
	// All Elements/Locator
	
	@FindBy(name="username")
	WebElement userName;
	@FindBy(name="password")
	WebElement passWord;
	@FindBy(css=".img-responsive")
	WebElement crmLogo;	
	@FindBy(css=".btn.btn-small")
	WebElement loginBTN;
	// All kind of Action 
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmLogo() {
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login1(String un, String pass) {
		userName.sendKeys(un);
		passWord.sendKeys(pass);
		Actions action = new Actions (driver);
		action.moveToElement(loginBTN).click().build().perform();
		//loginBTN.click(); //driver.findElement(ById.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		return new HomePage();
		//creating a object for class HomePage
	}
		
}
