package com.vtiger.crm.ServicesTest;
/* author Kalyan*/

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.ListenerUtility.ListenerImpClass;
import com.vtiger.crm.ObjectRepositoryUtility.CreateServicePage;
import com.vtiger.crm.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.ObjectRepositoryUtility.ServicesInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.ServicesPage;
import com.vtiger.crm.generic.BaseUtility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
@Listeners(ListenerImpClass.class)
public class CreateServicesTest extends BaseClass {
	@Test(groups={"Regression_Test"})
	public void createServiceTest() throws Exception {
		
		UtilityClassObject.getTest().log(Status.INFO,"Read data from the excel");
		String ServiceName = excel.getDataFromExcelFile("Services", 1, 2) + java.getRandomNumber();
		String Units = excel.getDataFromExcelFile("Services", 1, 3);
		String Price = excel.getDataFromExcelFile("Services", 1, 4);
		String Comm = excel.getDataFromExcelFile("Services", 1, 5);
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the application");
		HomePage home = new HomePage(driver);
		ServicesPage services = new ServicesPage(driver);
		CreateServicePage createService = new CreateServicePage(driver);
		ServicesInfoPage serviceInfo = new ServicesInfoPage(driver);

		UtilityClassObject.getTest().log(Status.INFO,"Navigate to the Services page");
		home.navigateToServices(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Create New Service");
		services.getCreateServiceBtn().click();
		createService.createNewService(ServiceName, Units, Price, Comm);
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.PASS,"Verify the header info data with new created Service");
		String actServiceName = serviceInfo.getHeaderMsg().getText();
		Assert.assertEquals(actServiceName.contains(ServiceName), true);
		Reporter.log(ServiceName + " is created and verified", true);
	}
}
