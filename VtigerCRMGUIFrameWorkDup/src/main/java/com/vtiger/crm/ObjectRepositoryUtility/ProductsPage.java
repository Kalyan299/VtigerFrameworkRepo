package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
//WebElement driver;
public ProductsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProduct;
	
	public WebElement getCreateProduct() {
	return createProduct;
	}
}
