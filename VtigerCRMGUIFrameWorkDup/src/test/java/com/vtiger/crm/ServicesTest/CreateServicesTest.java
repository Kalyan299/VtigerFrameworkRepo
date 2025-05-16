package com.vtiger.crm.ServicesTest;
/* author Kalyan*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.crm.ObjectRepositoryUtility.CreateServicePage;
import com.vtiger.crm.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.ObjectRepositoryUtility.ServicesInfoPage;
import com.vtiger.crm.ObjectRepositoryUtility.ServicesPage;
import com.vtiger.crm.generic.BaseUtility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateServicesTest extends BaseClass {
	@Test
	public void createServiceTest() throws Exception {
		// read data from excel
		String ServiceName = excel.getDataFromExcelFile("Services", 1, 2) + java.getRandomNumber();
		String Units = excel.getDataFromExcelFile("Services", 1, 3);
		String Price = excel.getDataFromExcelFile("Services", 1, 4);
		String Comm = excel.getDataFromExcelFile("Services", 1, 5);

		HomePage home = new HomePage(driver);
		ServicesPage services = new ServicesPage(driver);
		CreateServicePage createService = new CreateServicePage(driver);
		ServicesInfoPage serviceInfo = new ServicesInfoPage(driver);

		// navigate to Services tab
		home.navigateToServices(driver);
		services.getCreateServiceBtn().click();
		createService.createNewService(ServiceName, Units, Price, Comm);
		Thread.sleep(2000);

		// verify the header service information
		String actServiceName = serviceInfo.getHeaderMsg().getText();
		Assert.assertEquals(actServiceName.contains(ServiceName), true);
		Reporter.log(ServiceName + " is created and verified", true);
	}
}
