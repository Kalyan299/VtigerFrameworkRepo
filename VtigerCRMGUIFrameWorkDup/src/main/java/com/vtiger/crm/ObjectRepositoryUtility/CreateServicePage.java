package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateServicePage {
	//WebDriver driver;
	WebDriverUtility web=new WebDriverUtility();
	public CreateServicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="servicename")private WebElement serviceNameEdt;
	@FindBy(name="servicecategory")private WebElement serviceCatDD;
	@FindBy(name="qty_per_unit")private WebElement unitsEdt;
	@FindBy(name="unit_price")private WebElement priceEdt;
	@FindBy(name="commissionrate")private WebElement commEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	public WebElement getServiceNameEdt() {
		return serviceNameEdt;
	}
	public WebElement getServiceCatDD() {
		return serviceCatDD;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getUnitsDD() {
		return unitsEdt;
	}
	public WebElement getPriceEdt() {
		return priceEdt;
	}
	public WebElement getCommEdt() {
		return commEdt;
	}
	
	public void createNewService(String Service, String Units, String Price, String Comm) {
		serviceNameEdt.sendKeys(Service);
		unitsEdt.sendKeys(Units);
		priceEdt.sendKeys(Price);
		commEdt.sendKeys(Comm);
		web.select(serviceCatDD, "Support");
		saveBtn.click();
	}
	
	
	
}
