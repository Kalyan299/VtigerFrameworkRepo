package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {

	//WebDriver driver;
	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	
}
