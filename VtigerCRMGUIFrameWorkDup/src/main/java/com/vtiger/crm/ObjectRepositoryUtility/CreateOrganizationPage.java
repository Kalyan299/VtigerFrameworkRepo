package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationPage {
//WebDriver driver;
WebDriverUtility web=new WebDriverUtility();
public CreateOrganizationPage(WebDriver driver)  //object initialization
{
	PageFactory.initElements(driver, this);
}
	@FindBy(name="accountname") private WebElement OrgNameEdt;
	@FindBy(name="industry") private WebElement IndustryDropdwn;
	@FindBy(name="accounttype") private WebElement TypeDropdwn;
	@FindBy(name="phone") private WebElement PhoneNumEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement SaveBtn;
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;}
	public WebElement getIndustryDropdwn() {
		return IndustryDropdwn;}
	public WebElement getTypeDropdwn() {
		return TypeDropdwn;}
	public WebElement getSaveBtn() {
		return SaveBtn;}
	public WebElement getPhoneNumEdt() {
		return PhoneNumEdt;}
	
	//Object utilization
	public void createOrg(String orgName) {
		OrgNameEdt.sendKeys(orgName);
		SaveBtn.click();
	}
	public void createOrg(String orgName, String Phone) {
		OrgNameEdt.sendKeys(orgName);
		PhoneNumEdt.sendKeys(Phone);
		SaveBtn.click();
	}
	
	public void createOrg(String orgName, String industry, String type) {
		OrgNameEdt.sendKeys(orgName);
		web.select(IndustryDropdwn, industry);
		web.select(TypeDropdwn, type);
		SaveBtn.click();
	}
	
}
