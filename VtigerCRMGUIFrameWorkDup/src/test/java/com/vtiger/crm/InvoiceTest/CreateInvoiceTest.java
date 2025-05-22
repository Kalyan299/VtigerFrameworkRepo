package com.vtiger.crm.InvoiceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.ListenerUtility.ListenerImpClass;
import com.vtiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateContactsPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateInvoicePage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateOrganizationPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateProductPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreatePurchaseOrderPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateVendorPage;
import com.vtiger.crm.ObjectRepositoryUtility.InvoiceInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.InvoicePage;
import com.vtiger.crm.ObjectRepositoryUtility.OrganizationPage;
import com.vtiger.crm.ObjectRepositoryUtility.ProductsPage;
import com.vtiger.crm.ObjectRepositoryUtility.PurchaseOrderInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.PurchaseOrderPage;
import com.vtiger.crm.ObjectRepositoryUtility.VendorsPage;
import com.vtiger.crm.generic.BaseUtility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;

import junit.framework.Assert;
@Listeners(ListenerImpClass.class)
public class CreateInvoiceTest extends BaseClass {

	@Test(groups={"Regression_Test"})
	public void createInvoicewithPO_SO() throws Exception{
		
		UtilityClassObject.getTest().log(Status.INFO,"Read data from the excel");
		String OrgName=excel.getDataFromExcelFile("Invoice", 1, 5)+ java.getRandomNumber();
		String LastName=excel.getDataFromExcelFile("Invoice", 1, 3)+java.getRandomNumber();
		String Product=excel.getDataFromExcelFile("Invoice", 1, 6)+java.getRandomNumber();
		String ProdUnit=excel.getDataFromExcelFile("Invoice", 1, 10);
		String Vendor=excel.getDataFromExcelFile("Invoice", 1, 4)+java.getRandomNumber();
		String Pin=excel.getDataFromExcelFile("PurchaseOrder", 1, 6);
		String POSubject=excel.getDataFromExcelFile("PurchaseOrder", 1, 2)+java.getRandomNumber();
		String Industry=excel.getDataFromExcelFile("org", 4, 3);
		String Type=excel.getDataFromExcelFile("org", 4, 4);
		String PO_Billing=excel.getDataFromExcelFile("Invoice", 1, 7);
		String PO_Shipping=excel.getDataFromExcelFile("Invoice", 1, 8);
		String Prod_Qty=excel.getDataFromExcelFile("PurchaseOrder", 1, 9);
		String InvoiceSub=excel.getDataFromExcelFile("Invoice", 1, 2)+java.getRandomNumber();
		String Inv_Billing=excel.getDataFromExcelFile("Invoice", 1, 7);
		String Inv_Shipping=excel.getDataFromExcelFile("Invoice", 1, 8);
		String Inv_Qty=excel.getDataFromExcelFile("Invoice", 1, 11);
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the application");
		web.waitForImplicit(driver);
		web.maximize(driver);
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
		ContactsPage contact=new ContactsPage(driver);
		CreateContactsPage createContact=new CreateContactsPage(driver);
		ProductsPage product=new ProductsPage(driver);
		CreateProductPage createProduct=new CreateProductPage(driver);
		VendorsPage vendor=new VendorsPage(driver);
		CreateVendorPage createVendor=new CreateVendorPage(driver);
		PurchaseOrderPage purchase=new PurchaseOrderPage(driver);
		CreatePurchaseOrderPage createPO=new CreatePurchaseOrderPage(driver);
		PurchaseOrderInfoPage poInfo=new PurchaseOrderInfoPage(driver);
		InvoicePage invoice=new InvoicePage(driver);
		CreateInvoicePage createInvoice=new CreateInvoicePage(driver);
		InvoiceInfoPage invoiceInfo=new InvoiceInfoPage(driver);
		
		
		home.getOrgLink().click();
		orgPage.getCreateBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Organization page");
		createOrg.createOrg(OrgName, Industry, Type);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Contacts page");
		home.getContactLink().click();
		contact.getCreateBtn().click();
		createContact.createContact(LastName);
		Thread.sleep(2000);
		
		//switch to orgTab in contacts
		createContact.switchToOrgInContact(driver, OrgName);
		createContact.saveContact();
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Products page and create new product");
		home.getProductLink().click();
		product.getCreateProduct().click();
		createProduct.createProduct(Product, ProdUnit);
		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Vendors page and create new vendor");
		home.naviagteToVendor(driver);
		vendor.getCreateBtn().click();
		createVendor.createVendor(Vendor, Pin);
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the PO page and create new PO");
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
		createPO.createPO(PO_Billing, PO_Shipping);
		createPO.savePO(Prod_Qty);
	    String PONum=poInfo.getVerifyPONum().getText();
	    
	    UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Invoice page and create new Invoice");
		home.navigateToInvoice(driver);
		invoice.getCreateInoviceBtn().click();
		createInvoice.createInvoice(InvoiceSub);
		
		//switch to contacts in invoice
		createInvoice.switchToContactInInv(driver, LastName);
		
		//switch to organization in invoice
		createInvoice.switchToOrgInInv(driver, OrgName);
		
		//enter the mandatory details for creating invoice
		createInvoice.createInvoice(PONum, Inv_Billing, Inv_Shipping);
		
		//scroll down to particular element
		WebElement item1 = driver.findElement(By.name("productName1"));
		web.scrollDownForParticularELement(driver, item1);
		
		//switch to products page
		createInvoice.switchToProductInInv(driver, Product);
		
		//switch back to invoice page
		createInvoice.saveInvoice(Inv_Qty);
		
		UtilityClassObject.getTest().log(Status.PASS,"Verify the header info data with new created Invoice Subject");
		String actInvoice=invoiceInfo.getHeaderMsg().getText();
		Assert.assertEquals(actInvoice.contains(InvoiceSub), true);
		
	}
}
