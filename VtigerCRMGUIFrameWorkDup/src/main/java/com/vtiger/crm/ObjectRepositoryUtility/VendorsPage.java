package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
//WebDriver driver;
public VendorsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//img[@title='Create Vendor...']") private WebElement createBtn;

	public WebElement getCreateBtn() {
		return createBtn;
	}
	
}
