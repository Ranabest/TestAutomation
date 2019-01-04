package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase {

	@FindBy(xpath = "//*[@name='owner_user_id']")
	WebElement Owner;
	@FindBy(name = "title")
	WebElement nameTitle;
	@FindBy(name = "first_name")
	WebElement ftName;
	@FindBy(name = "surname")
	WebElement ltName;
	@FindBy(xpath = "//*[@name='contact_lookup_sup']")
	WebElement supervisor;
	@FindBy(name = "suffix")
	WebElement suffix;
	@FindBy(xpath="//*[contains(text(),'Contact Information')]")
	WebElement contactinfologo;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement savebtn;
	@FindBy(xpath = "//*[@name='client_lookup']")
	WebElement company;
	@FindBy(xpath = "//input[@id='department']")
	WebElement department;
	@FindBy(xpath = "//*[@name='phone']")
	WebElement phone;
	@FindBy(xpath = "//*[@name='fax']")
	WebElement fax;
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOwner() {
		return Owner.isDisplayed();
	}
	public boolean verifyContactInfoLogo() {
		return contactinfologo.isDisplayed();
	}

	/*public void createNewAccount(String title, String firstName, String lastName, String supervisorName,
			String suffixtitle) {
		Select ab = new Select(nameTitle);
		ab.selectByVisibleText(title);
		ftName.sendKeys(firstName);
		ltName.sendKeys(lastName);
		supervisor.sendKeys(supervisorName);
		Select abc = new Select(suffix);
		abc.selectByVisibleText(suffixtitle);
		savebtn.click();
		*/
	
	public void createNewAccount(String firstName, String lastName, String companyName,String supervisorName,
			String departmentName, String phoneNum, String faxNum) {
		
		ftName.sendKeys(firstName);
		ltName.sendKeys(lastName);
		supervisor.sendKeys(supervisorName);
		company.sendKeys(companyName);
		department.sendKeys(departmentName);
		phone.sendKeys(phoneNum);
	
		fax.sendKeys(faxNum);
		savebtn.click();

	}

}