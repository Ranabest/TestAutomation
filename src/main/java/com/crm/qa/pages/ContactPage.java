package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath="//*[contains(text(),'Contacts')]")
	WebElement contactlogo;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactLogo() {
		return contactlogo.isDisplayed();
	}
	public void verifySavedContactLink(String name) {
		
	driver.findElement(By.xpath("//a[(text()='"+name+"')]")).click();
	//this is a very tricky xpath so pay attention
	}
	public void verifySelectSingleCheckbox() {
		driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/input[1]")).click();
	}
}
