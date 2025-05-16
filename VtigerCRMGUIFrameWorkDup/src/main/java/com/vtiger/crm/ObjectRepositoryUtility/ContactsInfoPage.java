package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

		//WebDriver driver;
		public ContactsInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement headerMsg;
		@FindBy(id="mouseArea_Organization Name")private WebElement verifyOrgName;
		@FindBy(id="dtlview_Support Start Date")private WebElement verifyStartDate;
		@FindBy(id="dtlview_Support End Date")private WebElement verifyEndDate;
		
		public WebElement getVerifyStartDate() {
			return verifyStartDate;
		}
		public WebElement getVerifyEndDate() {
			return verifyEndDate;
		}
		public WebElement getHeaderMsg() {
		return headerMsg;
		}
		public WebElement getVerifyOrgName() {
			return verifyOrgName;
			}
		
		
}
