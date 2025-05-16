package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateInvoicePage {
//	WebDriver driver;
    JavaUtlity java=new JavaUtlity();
	WebDriverUtility web=new WebDriverUtility();
	
	public CreateInvoicePage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="subject") private WebElement invoiceSubjectEdt;
	@FindBy(id="vtiger_purchaseorder") private WebElement poNumEdt;
	@FindBy(name="bill_street") private WebElement invoiceBilltEdt;
	@FindBy(name="ship_street") private WebElement invoiceShipEdt;
	@FindBy(name="duedate") private WebElement invoiceDueDateEdt;
	@FindBy(id="qty1") private WebElement invoiceQtyEdt;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[2]") private WebElement contactBtn;
	@FindBy(name="search_text") private WebElement contactSearchEdt;
	@FindBy(name="search") private WebElement contactSearchBtn;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[3]") private WebElement orgBtn;
	@FindBy(name="search_text")private WebElement orgSearchEdt;
	@FindBy(xpath="//input[@type='button']")private WebElement orgSearchBtn;
	@FindBy(id="searchIcon1") private WebElement productBtn;
	@FindBy(name="search_text") private WebElement prodSearchEdt;
	@FindBy(name="search") private WebElement prodSearchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	

	public WebElement getInvoiceSubjectEdt() {
		return invoiceSubjectEdt;}
	public WebElement getInvoiceBilltEdt() {
		return invoiceBilltEdt;}
	public WebElement getSaveBtn() {
		return saveBtn;}
	public WebElement getInvoiceShipEdt() {
		return invoiceShipEdt;}
	public WebElement getInvoiceDueDateEdt() {
		return invoiceDueDateEdt;}
	public WebElement getInvoiceQtyEdt() {
		return invoiceQtyEdt;}
	public WebElement getContactBtn() {
		return contactBtn;}
	public WebElement getOrgBtn() {
		return orgBtn;}
	public WebElement getProductBtn() {
		return productBtn;}
	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;}
	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;}
	public WebElement getContactSearchEdt() {
		return contactSearchEdt;}
	public WebElement getContactSearchBtn() {
		return contactSearchBtn;}
	public WebElement getPoNumEdt() {
		return poNumEdt;}
	
	public void createInvoice(String InvSubject) {
		invoiceSubjectEdt.sendKeys(InvSubject);
		invoiceDueDateEdt.clear();
		String Duedate=java.getRequireddate(62);
		invoiceDueDateEdt.sendKeys(Duedate);
	}
	public void switchToContactInInv(WebDriver driver, String LastName) {
		contactBtn.click();
		web.switchToNewWindowonUrl(driver, "Contacts&action");
		contactSearchEdt.sendKeys(LastName);
		contactSearchBtn.click();
		driver.findElement(By.linkText(LastName)).click();
		web.switchToAlertWithAccept(driver);
		web.switchToNewWindowonUrl(driver, "Invoice&action");
	}
	
	public void switchToOrgInInv(WebDriver driver, String OrgName) {
		orgBtn.click();
		web.switchToNewWindowonUrl(driver, "Accounts&action");
		orgSearchEdt.sendKeys(OrgName);
		orgSearchBtn.click();
		driver.findElement(By.linkText(OrgName)).click();
		web.switchToAlertWithAccept(driver);
		web.switchToNewWindowonUrl(driver, "Invoice&action");
	}
	public void switchToProductInInv(WebDriver driver, String Product) {
		productBtn.click();
		web.switchToNewWindowonUrl(driver, "Products&action");
		prodSearchEdt.sendKeys(Product);
		prodSearchBtn.click();
		driver.findElement(By.linkText(Product)).click();
		web.switchToNewWindowonUrl(driver, "Invoice&action");
	}
	public void createInvoice(String PoNum, String Billing, String Shipping) {
		poNumEdt.sendKeys(PoNum);
		invoiceBilltEdt.sendKeys(Billing);
		invoiceShipEdt.sendKeys(Shipping);
	}
	public void saveInvoice(String InvQty) {
		invoiceQtyEdt.sendKeys(InvQty);
		saveBtn.click();
	}
	
	
}
