package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreatePurchaseOrderPage {
//WebDriver driver;
WebDriverUtility web=new WebDriverUtility();
public CreatePurchaseOrderPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="subject") private WebElement poSubjectEdt;
@FindBy(name="bill_street") private WebElement billingEdt;
@FindBy(name="ship_street") private WebElement shippingEdt;
@FindBy(id="qty1") private WebElement poQtyEdt;
@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]") private WebElement vendorBtn;
@FindBy(name="search_text") private WebElement vendorSearchEdt;
@FindBy(name="search") private WebElement vendorSearchBtn;
@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[2]") private WebElement contactBtn;
@FindBy(name="search_text") private WebElement contactSearchEdt;
@FindBy(name="search") private WebElement contactSearchBtn;
@FindBy(id="searchIcon1") private WebElement productBtn;
@FindBy(name="search_text") private WebElement prodSearchEdt;
@FindBy(name="search") private WebElement prodSearchBtn;
@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveBtn;

public WebElement getPoSubjectEdt() {
	return poSubjectEdt;}
public WebElement getBillingEdt() {
	return billingEdt;}
public WebElement getShippingEdt() {
	return shippingEdt;}
public WebElement getPoQtyEdt() {
	return poQtyEdt;}
public WebElement getVendorBtn() {
	return vendorBtn;}
public WebElement getContactBtn() {
	return contactBtn;}
public WebElement getProductBtn() {
	return productBtn;}
public WebElement getSaveBtn() {
	return saveBtn;}
public WebElement getVendorSearchEdt() {
	return vendorSearchEdt;}
public WebElement getVendorSearchBtn() {
	return vendorSearchBtn;}
public WebElement getContactSearchEdt() {
	return contactSearchEdt;}
public WebElement getContactSearchBtn() {
	return contactSearchBtn;}
public WebElement getProdSearchEdt() {
	return prodSearchEdt;}
public WebElement getProdSearchBtn() {
	return prodSearchBtn;}

public void createPO(String POSubject) {
	poSubjectEdt.sendKeys(POSubject);
}
public void switchToVendorInPO(WebDriver driver, String Vendor) {
	vendorBtn.click();
	web.switchToNewWindowonUrl(driver, "Vendors&action");
	vendorSearchEdt.sendKeys(Vendor);
	vendorSearchBtn.click();
	driver.findElement(By.linkText(Vendor)).click();
	web.switchToNewWindowonUrl(driver, "PurchaseOrder&action");
}
public void switchToContactInPO(WebDriver driver, String LastName) {
	contactBtn.click();
	web.switchToNewWindowonUrl(driver, "Contacts&action");
	contactSearchEdt.sendKeys(LastName);
	contactSearchBtn.click();
	driver.findElement(By.linkText(LastName)).click();
	web.switchToAlertWithAccept(driver);
	web.switchToNewWindowonUrl(driver, "PurchaseOrder&action");
}

public void switchToProductInPO(WebDriver driver, String Product) {
	productBtn.click();
	web.switchToNewWindowonUrl(driver, "Products&action");
	prodSearchEdt.sendKeys(Product);
	prodSearchBtn.click();
	driver.findElement(By.linkText(Product)).click();
	web.switchToNewWindowonUrl(driver, "PurchaseOrder&action");
}
public void createPO(String Billing, String Shipping) {
	billingEdt.sendKeys(Billing);
	shippingEdt.sendKeys(Shipping);
}
public void savePO(String POQty) {
	poQtyEdt.sendKeys(POQty);
	saveBtn.click();
}
}
