package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
//WebDriver driver;
WebDriverUtility web=new WebDriverUtility();

	public HomePage(WebDriver driver)
	{
//		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(linkText = "Organizations") private WebElement OrgLink;
	@FindBy(linkText = "Contacts") private WebElement ContactLink;
	@FindBy(linkText = "Opportunities") private WebElement OpportunityLink;
	@FindBy(linkText = "Products") private WebElement ProductLink;
	@FindBy(linkText = "Purchase Order") private WebElement PurchaseOrderLink;
	@FindBy(linkText = "Services") private WebElement ServicesLink;
	@FindBy(linkText = "Vendors")private WebElement VendorLink;
	@FindBy(linkText = "Invoice")private WebElement InvoiceLink;
	@FindBy(linkText = "More") private WebElement MoreLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")private WebElement adminImg;
	@FindBy(linkText = "Sign Out")private WebElement SignoutLink;

	public WebElement getOrgLink() {
		return OrgLink;
	}
	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getOpportunityLink() {
		return OpportunityLink;
	}

	public WebElement getServicesLink() {
		return ServicesLink;
	}
	public WebElement getProductLink() {
		return ProductLink;
	}
	public WebElement getadminImg() {
		return adminImg;
	}
	
	public WebElement getInvoiceLink() {
		return InvoiceLink;
	}
	public void navigateToPO(WebDriver driver) {
		web.mouseHoverAction(driver, MoreLink);
		PurchaseOrderLink.click();}
	public void naviagteToVendor(WebDriver driver) {
		web.mouseHoverAction(driver, MoreLink);
		VendorLink.click();}
	public void navigateToServices(WebDriver driver) {
		web.mouseHoverAction(driver, MoreLink);
		ServicesLink.click();}
	public void navigateToInvoice(WebDriver driver) {
		web.mouseHoverAction(driver, MoreLink);
		InvoiceLink.click();}
	public void signOut(WebDriver driver) {
		web.mouseHoverAction(driver, adminImg);
		SignoutLink.click();}	
}
