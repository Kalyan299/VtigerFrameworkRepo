package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactsPage {
//WebDriver driver;
JavaUtlity java=new JavaUtlity();
WebDriverUtility web=new WebDriverUtility();

	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")private WebElement lastnameEdt;
	@FindBy(name="support_start_date")private WebElement startdateDD;
	@FindBy(name="support_end_date")private WebElement enddateDD;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")private WebElement orgLink;
	@FindBy(name="search_text")private WebElement orgSearchEdt;
	@FindBy(xpath="//input[@type='button']")private WebElement orgSearchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}
	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	public WebElement getStartdateDD() {
		return startdateDD;
	}
	public WebElement getEnddateDD() {
		return enddateDD;
	}
	public void createContact(String Lastname) {
		lastnameEdt.sendKeys(Lastname);
		startdateDD.clear();
		String Startdate=java.getSystemDate();
		startdateDD.sendKeys(Startdate);
		enddateDD.clear();
		String EndDate=java.getRequireddate(30);
		enddateDD.sendKeys(EndDate);
	}
	public void switchToOrgInContact(WebDriver driver, String orgName) {
		orgLink.click();
		web.switchToNewWindowonUrl(driver, "Accounts&action");
		orgSearchEdt.sendKeys(orgName);
		orgSearchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		web.switchToNewWindowonUrl(driver, "Contacts&action");
	}
	public void saveContact() {
		saveBtn.click();
	}
	
	
	
}
