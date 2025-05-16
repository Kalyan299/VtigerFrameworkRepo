package com.vtiger.crm.ContactTest;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.ContactsPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateContactsPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateOrganizationPage;
import com.vtiger.crm.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.ObjectRepositoryUtility.OrganizationPage;
import com.vtiger.crm.generic.BaseUtility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
public class CreateContactTest extends BaseClass {
	@Test
	public void createContact() throws Exception {
        UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
		// read test script data from excel
		String LastName = excel.getDataFromExcelFile("Contacts", 1, 2) + java.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the application");
		// navigate to application
		home.getContactLink().click();
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.getCreateBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new LastName in contacts Page");
		// create LastName in contacts
		CreateContactsPage createContact = new CreateContactsPage(driver);
		createContact.createContact(LastName);
		createContact.saveContact();
		UtilityClassObject.getTest().log(Status.INFO, "Verify the header contact info with created contact name");
		// verify header info data
		ContactsInfoPage contactInfo = new ContactsInfoPage(driver);
		String actLastName = contactInfo.getHeaderMsg().getText();
		Assert.assertEquals(actLastName.contains(LastName), true);
	}
	
	@Test
	public void createConatctWithSupportedDateTest() throws Exception {
		ContactsPage contactPage = new ContactsPage(driver);
		CreateContactsPage createContact = new CreateContactsPage(driver);
		ContactsInfoPage contactInfo = new ContactsInfoPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
		// read test script data from excel
		String LastName = excel.getDataFromExcelFile("Contacts", 4, 2) + java.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the application");
		// navigate to application
		home.getContactLink().click();
		contactPage.getCreateBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new LastName in contacts Page");
		// create Contact LastName
		createContact.createContact(LastName);
		createContact.saveContact();
		UtilityClassObject.getTest().log(Status.INFO, "Verify the header contact info with created contact name");
		// verify LastName info data
		String actLastName = contactInfo.getHeaderMsg().getText();
		Assert.assertEquals(actLastName.contains(LastName), true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the StartDate with created StartDate");
		// verify StartDate info data
		String StartDate = createContact.getStartdateDD().getText();
		String actStartDate = contactInfo.getVerifyStartDate().getText();
		Assert.assertEquals(actStartDate.contains(StartDate), true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the EndDate with created EndDate");
		// verify EndDate info data
		String EndDate = createContact.getEnddateDD().getText();
		String actEndDate = contactInfo.getVerifyEndDate().getText();
		Assert.assertEquals(actEndDate.contains(EndDate), true);
	}
	
	@Test
    public void createContactWithOrgTest() throws Exception
    {
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
		//read test script data from excel
		String OrgName=excel.getDataFromExcelFile("Contacts", 7, 2) + java.getRandomNumber();
		String Industry=excel.getDataFromExcelFile("org", 4, 3);
		String Type=excel.getDataFromExcelFile("org", 4, 4);
		String Lastname=excel.getDataFromExcelFile("Contacts", 7, 3) + java.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Organization tab");
		 //navigate to Organization tab
		OrganizationPage orgPage=new OrganizationPage(driver);
		home.getOrgLink().click();
		orgPage.getCreateBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new Organization");
        //create Organization name
		CreateOrganizationPage org=new CreateOrganizationPage(driver);
		org.createOrg(OrgName, Industry, Type);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Contacts tab");
        //navigate to contacts tab
        Thread.sleep(2000);
        home.getContactLink().click();
        ContactsPage conPage=new ContactsPage(driver);
        conPage.getCreateBtn().click();
        UtilityClassObject.getTest().log(Status.INFO, "Create new LastName in contacts Page");
        //create LastName in contacts
        CreateContactsPage contact=new CreateContactsPage(driver);
        contact.createContact(Lastname);
        contact.switchToOrgInContact(driver, OrgName);
        contact.saveContact();
        UtilityClassObject.getTest().log(Status.INFO, "Verify the header contact info with created contact name");
        Thread.sleep(2000);
        //verify LastName info data
        ContactsInfoPage contactInfo=new ContactsInfoPage(driver);
        String actLast=contactInfo.getHeaderMsg().getText();
        Assert.assertEquals(actLast.contains(Lastname), true);
        UtilityClassObject.getTest().log(Status.INFO, "Verify the OrgName with created OrgName in Contacts Info Page");
        //verify orgName info data
        String actOrgName=contactInfo.getVerifyOrgName().getText();
        Assert.assertEquals(actOrgName.contains(OrgName), true);
    }

}
