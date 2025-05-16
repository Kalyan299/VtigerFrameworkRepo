package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
//WebDriver driver;
public CreateVendorPage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
	
	@FindBy(name="vendorname")private WebElement vendorNameEdt;
	@FindBy(name="postalcode")private WebElement postalEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	
	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}
	public WebElement getPostalEdt() {
		return postalEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createVendor(String Vendor, String Postal)
	{
		vendorNameEdt.sendKeys(Vendor);
		postalEdt.sendKeys(Postal);
		saveBtn.click();
	}
}
