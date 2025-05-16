package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
//WebDriver driver;
	public ContactsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createBtn;
	
	public WebElement getCreateBtn() {
	return createBtn;
	}
}
