package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
//WebDriver driver;
public InvoicePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@title='Create Invoice...']") private WebElement createInoviceBtn;
public WebElement getCreateInoviceBtn() {
	return createInoviceBtn;
}
}
