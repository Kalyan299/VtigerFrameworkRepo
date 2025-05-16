package com.vtiger.crm.ObjectRepositoryUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
//WebDriver driver;

public OrganizationInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
	
	@FindBy(className="dvHeaderText") private WebElement headerMsg;
	@FindBy(id="mouseArea_Industry") private WebElement verifyIndustryDD;
	@FindBy(id="mouseArea_Type") private WebElement verifyTypeDD;
	@FindBy(id="dtlview_Phone") private WebElement verifyPhone;

	public WebElement getVerifyPhone() {
		return verifyPhone;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;}

	public WebElement getVerifyIndustryDD() {
		return verifyIndustryDD;
	}

	public WebElement getVerifyTypeDD() {
		return verifyTypeDD;
	}
	
}
