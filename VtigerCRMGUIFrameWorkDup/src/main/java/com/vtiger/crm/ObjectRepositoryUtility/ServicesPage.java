package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {

	//WebDriver driver;
	public ServicesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Service...']") private WebElement createServiceBtn;

	public WebElement getCreateServiceBtn() {
		return createServiceBtn;
	}
}
