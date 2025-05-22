package com.vtiger.crm.generic.BaseUtility;
/**
 * author Kalyan
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.crm.ObjectRepositoryUtility.HomePage;
import com.vtiger.crm.ObjectRepositoryUtility.LoginPage;
import com.vtiger.crm.generic.databaseutility.DataBaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass{
	
public WebDriver driver;	
String url="Jdbc:mysql://49.249.28.218:3333/ninza_hrm";
String username="root";
String password="root";
public FileUtility file=new FileUtility();
public WebDriverUtility web=new WebDriverUtility();
public ExcelUtility excel=new ExcelUtility();
public JavaUtlity java=new JavaUtlity();
public DataBaseUtility dB=new DataBaseUtility();
public HomePage home;
public LoginPage login;
public static WebDriver sdriver;

	
	@BeforeSuite(groups= {"Smoke_Test","Regression_Test"})
	public void GetConnectionDB() throws Exception
	{
		System.out.println("Connect to DB");
		dB.getdBConnection(url, username, password);
	}
	
	@BeforeClass(groups= {"Smoke_Test","Regression_Test"})
	public void LaunchBrowser() throws Exception 
	{
	String Browser = file.getDatafromPropertiesFile("browser");
	  
		if(Browser.equals("chrome")) {
			driver= new ChromeDriver();}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();}
		else {
			driver= new ChromeDriver();}
		UtilityClassObject.setDriver(driver);
		web.waitForImplicit(driver);
		web.maximize(driver);
		sdriver=driver;
		
	}
	
	@BeforeMethod(groups= {"Smoke_Test","Regression_Test"})
	public void LoginToApplication() throws Exception 
	{
		home=new HomePage(driver);
		web.waitForImplicit(driver);
	    login=new LoginPage(driver);
		String Url = file.getDatafromPropertiesFile("url");
		String Username = System.getProperty("username");
		String Password = System.getProperty("password");
		driver.get(Url);
		login.loginApp(Username, Password);
	}
	
	@AfterMethod(groups= {"Smoke_Test","Regression_Test"})
	public void LogOutApplication() 
	{
		web.waitForImplicit(driver);
	    HomePage home=new HomePage(driver);
		home.signOut(driver);
	}
	
	@AfterClass(groups= {"Smoke_Test","Regression_Test"})
	public void CloseBrowser() 
	{
		web.waitForImplicit(driver);
		driver.quit();
	}
	
	@AfterSuite(groups= {"Smoke_Test","Regression_Test"})
	public void CloseConnection() 
	{
		System.out.println("--Close dB--");
	}
	
   
	
	
}
