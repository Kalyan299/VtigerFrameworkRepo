package com.vtiger.crm.OrgTest;

import java.util.Properties;
import java.util.Random;

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
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.ListenerUtility.ListenerImpClass;
import com.vtiger.crm.ObjectRepositoryUtility.CreateOrganizationPage;
import com.vtiger.crm.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.OrganizationPage;
import com.vtiger.crm.generic.BaseUtility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
public class CreateOrgTest extends BaseClass {

	@Test
    public void createOrg() throws Exception{
		//read test script data from excel
		UtilityClassObject.getTest().log(Status.INFO,"Read data from the excel");
		String OrgName=excel.getDataFromExcelFile("Org", 1, 2)+ java.getRandomNumber();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
		OrganizationInfoPage orgInfo=new OrganizationInfoPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the application");
        //navigate to application
		home.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Organization page");
		orgPage.getCreateBtn().click();
        //create Organization name
		UtilityClassObject.getTest().log(Status.INFO,"Create new organization");
		createOrg.createOrg(OrgName);
        Thread.sleep(2000);
        UtilityClassObject.getTest().log(Status.PASS,"Verify the header info data with new created Org Name");
        //verify header info data
		String hexp=orgInfo.getHeaderMsg().getText();
		Assert.assertEquals(hexp.contains(OrgName), true);
		Reporter.log(OrgName+" is created & verified ", true);
    }
	
	@Test
	public void createOrgWithIndustryTypeTest() throws Exception {
		// read test script data from excel
		UtilityClassObject.getTest().log(Status.INFO,"Read data from the excel");
		String OrgName = excel.getDataFromExcelFile("org", 4, 2) + java.getRandomNumber();
		String Industry = excel.getDataFromExcelFile("org", 4, 3);
		String Type = excel.getDataFromExcelFile("org", 4, 4);
		OrganizationPage orgPage = new OrganizationPage(driver);
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the application");
		// navigate to application
		home.getOrgLink().click();
		orgPage.getCreateBtn().click();
		UtilityClassObject.getTest().log(Status.INFO,"Create new organization with Industry and Type");
		// create Organization name
		createOrg.createOrg(OrgName, Industry, Type);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,"Verify the header info data with new created Org Name");
		// verify header info data
		String headerMsg = orgInfo.getHeaderMsg().getText();
		Assert.assertEquals(headerMsg.contains(OrgName), true);
		Reporter.log(OrgName + " is created & verified ", true);
		UtilityClassObject.getTest().log(Status.PASS,"Verify the Industry data with new created Industry");
		// verify Industry data with expected
		String actIndustry = orgInfo.getVerifyIndustryDD().getText();
		Assert.assertEquals(actIndustry.contains(Industry), true);
		Reporter.log(Industry + " is created & verified ", true);
		UtilityClassObject.getTest().log(Status.PASS,"Verify the type of org data with new created Org Type");
		// verify Type data with expected
		String actType = orgInfo.getVerifyTypeDD().getText();
		Assert.assertEquals(actType.contains(Type), true);
       //Reporter.log(Type + " is created & verified ", true);
	}
	@Test
	public void createOrgWithPhoneNumberTest() throws Exception {
		// read test script data from excel
		UtilityClassObject.getTest().log(Status.INFO,"Read data from the excel");
		String OrgName = excel.getDataFromExcelFile("org", 7, 2) + java.getRandomNumber();
		String PhoneNumber = excel.getDataFromExcelFile("org", 7, 3);

		OrganizationPage orgPage = new OrganizationPage(driver);
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the application");
		// navigate to application
		home.getOrgLink().click();
		orgPage.getCreateBtn().click();
		UtilityClassObject.getTest().log(Status.INFO,"Create new organization with PhoneNumber");
		// create Organization name
		createOrg.createOrg(OrgName, PhoneNumber);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,"Verify the header info data with new created Org Name");
		// verify header info data
		String headerMsg = orgInfo.getHeaderMsg().getText();
		Assert.assertEquals(headerMsg.contains(OrgName), true);
		Reporter.log(OrgName + " is created & verified ", true);
		UtilityClassObject.getTest().log(Status.PASS,"Verify the PhoneNumber data with new created Org Name with PhoneNumber");
		// verify phone number data with expected
		String actPhone = orgInfo.getVerifyPhone().getText();
		Assert.assertEquals(actPhone.contains(PhoneNumber), true);
		Reporter.log(PhoneNumber + " is created & verified ", true);
	}
	
}
