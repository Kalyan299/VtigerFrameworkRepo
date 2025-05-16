package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateProductPage {
//WebDriver driver;
WebDriverUtility web= new WebDriverUtility();

public CreateProductPage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}

	@FindBy(name="productname")private WebElement prodNameEdt;
	@FindBy(name="unit_price")private WebElement prodUnitEdt;
	@FindBy(name="productcategory")private WebElement prodCatDD;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	public WebElement getProdNameEdt() {
		return prodNameEdt;
	}
	public WebElement getProdCatDD() {
		return prodCatDD;
	}
	
	public WebElement getProdUnitEdt() {
		return prodUnitEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createProduct(String ProdName, String Unit) {
		prodNameEdt.sendKeys(ProdName);
		prodUnitEdt.sendKeys(Unit);
		web.select(prodCatDD, "Hardware");
		saveBtn.click();
	}



}
