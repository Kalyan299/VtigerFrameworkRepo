package com.vtiger.crm.PurchaseOrderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateContactsPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateProductPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreatePurchaseOrderPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateVendorPage;
import com.vtiger.crm.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.ObjectRepositoryUtility.ProductsPage;
import com.vtiger.crm.ObjectRepositoryUtility.PurchaseOrderInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.PurchaseOrderPage;
import com.vtiger.crm.ObjectRepositoryUtility.VendorsPage;
import com.vtiger.crm.generic.BaseUtility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreatePOTest extends BaseClass{
	@Test
	public void createPurchaseOrderTest() throws Exception{
	
	//get data from excel
	String LastName=excel.getDataFromExcelFile("Contacts", 1, 2)+java.getRandomNumber();
	String Product=excel.getDataFromExcelFile("PurchaseOrder", 1, 7)+java.getRandomNumber();
	String P_unitPrice=excel.getDataFromExcelFile("PurchaseOrder", 1, 8);
	String Vendor=excel.getDataFromExcelFile("PurchaseOrder", 1, 3)+java.getRandomNumber();
	String Billing=excel.getDataFromExcelFile("PurchaseOrder", 1, 4);
	String Shipping=excel.getDataFromExcelFile("PurchaseOrder", 1, 5);
	String POSubject=excel.getDataFromExcelFile("PurchaseOrder", 1, 2);
	String Qty=excel.getDataFromExcelFile("PurchaseOrder", 1, 9);
	String Pin=excel.getDataFromExcelFile("PurchaseOrder", 1, 6);
	
	ContactsPage contact=new ContactsPage(driver);
	CreateContactsPage createContact=new CreateContactsPage(driver);
	ProductsPage product=new ProductsPage(driver);
	CreateProductPage createProduct=new CreateProductPage(driver);
	VendorsPage vendor=new VendorsPage(driver);
	CreateVendorPage createVendor=new CreateVendorPage(driver);
	PurchaseOrderPage purchase=new PurchaseOrderPage(driver);
	CreatePurchaseOrderPage createPO=new CreatePurchaseOrderPage(driver);
	PurchaseOrderInfoPage prodInfo=new PurchaseOrderInfoPage(driver);
	
	//navigate to contacts tab
	home.getContactLink().click();
	contact.getCreateBtn().click();
	createContact.createContact(LastName);
	createContact.saveContact();
	
    //navigate to products tab
	home.getProductLink().click();
	product.getCreateProduct().click();
	createProduct.createProduct(Product, P_unitPrice);
	Thread.sleep(2000);
	
	//navigate to vendors tab
	home.naviagteToVendor(driver);
	vendor.getCreateBtn().click();
	createVendor.createVendor(Vendor, Pin);
	
	//navigate to Purchase order tab
	home.navigateToPO(driver);
	purchase.getCreatePOBtn().click();
	createPO.createPO(POSubject);
	
	//switch to vendor tab
	createPO.switchToVendorInPO(driver, Vendor);
	
	//switch to contact tab
	createPO.switchToContactInPO(driver, LastName);
	
	//scroll to particular element
	WebElement item=driver.findElement(By.name("productName1"));
	web.scrollDownForParticularELement(driver, item);
	
	//switch to products tab
	createPO.switchToProductInPO(driver, Product);
	createPO.createPO(Billing, Shipping);
    createPO.savePO(Qty);
    
	//verify header info with PO
    String actPO=prodInfo.getHeaderMsg().getText();
    Assert.assertEquals(actPO.contains(POSubject), true);
	Reporter.log(POSubject+" is created & verified ", true);
	
	//verify vendor info
	String actVendor=prodInfo.getVerifyVendor().getText();
	Assert.assertEquals(actVendor.contains(Vendor), true);
	Reporter.log(Vendor+" is created & verified in PO page", true);
	}	
}
