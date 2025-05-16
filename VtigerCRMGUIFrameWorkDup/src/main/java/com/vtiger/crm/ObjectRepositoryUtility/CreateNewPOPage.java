package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewPOPage {
	//WebDriver driver;
	WebDriverUtility web= new WebDriverUtility();
	public CreateNewPOPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="subject")
	private WebElement poSubjectEdt;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorLink;
	@FindBy(name="bill_street")
	private WebElement billAddressEdt;
	@FindBy(name="ship_street")
	private WebElement shipAddressEdt;
	@FindBy(id="searchIcon1")
	private WebElement prodLink;
	@FindBy(id="qty1")
	private WebElement qtyEdt;
	@FindBy(name="search_text")
	private WebElement vendorTxt;
	@FindBy(name="search")
	private WebElement vendorSearchBtn;
	@FindBy(name="search_text")
	private WebElement productTxt;
	@FindBy(name="search")
	private WebElement productSearchBtn;
	
	public WebElement getProductTxt() {
		return productTxt;
	}
	public WebElement getProductSearchBtn() {
		return productSearchBtn;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebDriverUtility getWeb() {
		return web;
	}
	public WebElement getVendorTxt() {
		return vendorTxt;
	}
	public WebElement getVendorSearchBtn() {
		return vendorSearchBtn;
	}
	public WebElement getPoSubjectEdt() {
		return poSubjectEdt;
	}
	public WebElement getVendorLink() {
		return vendorLink;
	}
	public WebElement getBillAddressEdt() {
		return billAddressEdt;
	}
	public WebElement getShipAddressEdt() {
		return shipAddressEdt;
	}
	public WebElement getProdLink() {
		return prodLink;
	}
	public WebElement getQtyEdt() {
		return qtyEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createPO(String POSubject, String BillAddress, String ShipAddress, String Qty) {
		poSubjectEdt.sendKeys(POSubject);
		billAddressEdt.sendKeys(BillAddress);
		shipAddressEdt.sendKeys(ShipAddress);
		qtyEdt.sendKeys(Qty);
	}
	public void switchToVendorInPO(WebDriver driver, String Vendor) {
		vendorLink.click();
		web.switchToNewWindowonUrl(driver, "Vendors&action");
		vendorTxt.sendKeys(Vendor);
		vendorSearchBtn.click();
		driver.findElement(By.linkText(Vendor)).click();
		web.switchToNewWindowonUrl(driver, "PurchaseOrder&action");
	}
	public void switchToProductInPO(WebDriver driver, String ProductName) {
		prodLink.click();
		web.switchToNewWindowonUrl(driver, "Products&action");
		productTxt.sendKeys(ProductName);
		productSearchBtn.click();
		driver.findElement(By.linkText(ProductName)).click();
		web.switchToNewWindowonUrl(driver, "PurchaseOrder&action");
	}
	public void createPO() {
		saveBtn.click();
	}
	
}
