package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
// test
public class HomePage extends TestBase {
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactLink;
	@FindBy(xpath="//*[@title='New Contact']")
	WebElement NewContactLink;
	@FindBy(xpath = "//*[@title='Deals']")
	WebElement DealsLink;
	@FindBy(xpath = "//*[@title='Tasks']")
	WebElement TasksLink;
	@FindBy(xpath = "//td[contains(text(),'User: Rana Best')]")
	WebElement userId;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactPage verifyContactLink() {
		ContactLink.click();
		return new ContactPage();
	}
	
	public  NewContactPage verifyNewContactLink() {
		Actions act =new Actions(driver);
		act.moveToElement(ContactLink).build().perform();
		NewContactLink.click();
		return new NewContactPage();
	}

	public DealsPage verifyDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}

	public TasksPage verifyTasksLink() {
		TasksLink.click();
		return new TasksPage();
	}

	public boolean verifyCorrectUser() {
		return userId.isDisplayed();
	}

}