package Generic_Scripts;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage 
{
    public FileInputStream fis;
	public WebDriver driver;
	
	
	@BeforeTest
	public void ConfigReports()
	{
		
	}
	
	@BeforeClass
	public void BrowserConfiguration()
	{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void LaunchApplication()//Login
	{
		
	}
	 
	@Test
	public void TestCase()
	{
		System.out.println("Done");
	}
	@AfterMethod
	public void CloseApplication()//Logout
	{
		
	}
    
	@AfterClass
	public void CloaseBrowser()
	{
		
	}
	
	@AfterTest
	public void FlushReports()
	{
		
	}
	

}

