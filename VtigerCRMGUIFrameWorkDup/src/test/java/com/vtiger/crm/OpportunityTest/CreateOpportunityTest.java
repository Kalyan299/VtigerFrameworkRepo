package com.vtiger.crm.OpportunityTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.ListenerUtility.ListenerImpClass;
import com.vtiger.crm.ObjectRepositoryUtility.CreateOpportunityPage;
import com.vtiger.crm.ObjectRepositoryUtility.CreateOrganizationPage;
import com.vtiger.crm.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.ObjectRepositoryUtility.OpportunitiesPage;
import com.vtiger.crm.ObjectRepositoryUtility.OpportunityInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.OrganizationPage;
import com.vtiger.crm.generic.BaseUtility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
@Listeners(ListenerImpClass.class)
public class CreateOpportunityTest extends BaseClass {

	@Test(groups={"Smoke_Test"})
	public void createOpportunityTest() throws Exception {

		UtilityClassObject.getTest().log(Status.INFO, "Read data from the excel");
		String OpportunityName = excel.getDataFromExcelFile("Opportunities", 1, 3) + java.getRandomNumber();
		String OrgName = excel.getDataFromExcelFile("Opportunities", 1, 2) + java.getRandomNumber();
		String Industry = excel.getDataFromExcelFile("org", 4, 3);
		String Type = excel.getDataFromExcelFile("org", 4, 4);
		String Amt = excel.getDataFromExcelFile("Opportunities", 1, 4);

		OrganizationPage orgPage = new OrganizationPage(driver);
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		CreateOpportunityPage createOpp = new CreateOpportunityPage(driver);
		OpportunityInfoPage oppInfo = new OpportunityInfoPage(driver);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Organization page");
		home.getOrgLink().click();
		orgPage.getCreateBtn().click();
		// create organization
		createOrg.createOrg(OrgName, Industry, Type);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Opportunities page");
		home.getOpportunityLink().click();
		opp.getCreateOppBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new opportunity");
		createOpp.createOpportunity(OpportunityName, Amt);
		createOpp.switchToOrgInOppty(driver, OrgName);
		createOpp.saveOpportunity();

		UtilityClassObject.getTest().log(Status.PASS, "Verify the header info data with new created Opportunity Name");
		String actOpp = oppInfo.getHeaderMsg().getText();
		Assert.assertEquals(actOpp.contains(OpportunityName), true);
		Reporter.log(OpportunityName + " is verified ", true);

		UtilityClassObject.getTest().log(Status.PASS, "Verify the org name in opportunity info page");
		String actOrg = driver.findElement(By.linkText(OrgName)).getText();
		Assert.assertEquals(actOrg.contains(OrgName), true);
		Reporter.log(actOrg + " is checked & verified ", true);
	}

	@Test(groups={"Regression_Test"})
	public void checkOpportunityNameTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from the excel");
		String OpportunityName = excel.getDataFromExcelFile("Opportunities", 4, 3) + java.getRandomNumber();
		String OrgName = excel.getDataFromExcelFile("Opportunities", 4, 2) + java.getRandomNumber();
		String Industry = excel.getDataFromExcelFile("org", 4, 3);
		String Type = excel.getDataFromExcelFile("org", 4, 4);
		String Amt = excel.getDataFromExcelFile("Opportunities", 4, 4);

		OrganizationPage orgPage = new OrganizationPage(driver);
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		CreateOpportunityPage createOpp = new CreateOpportunityPage(driver);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Organization page");
		home.getOrgLink().click();
		orgPage.getCreateBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new organization");
		createOrg.createOrg(OrgName, Industry, Type);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Opportunities page");
		home.getOpportunityLink().click();
		opp.getCreateOppBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new opportunity");
		createOpp.createOpportunity(OpportunityName, Amt);
		createOpp.switchToOrgInOppty(driver, OrgName);
		createOpp.saveOpportunity();

		home.getOpportunityLink().click();
		opp.checkOpportunity(OpportunityName);
		UtilityClassObject.getTest().log(Status.PASS, "Verify the created opportunity name is displayed in main opportunities page");
		String actOpprt = driver.findElement(By.linkText(OpportunityName)).getText();
		Assert.assertEquals(actOpprt.contains(OpportunityName), true);
		Reporter.log(OpportunityName + " is verified and displayed in Opporunities main page", true);

	}
}
