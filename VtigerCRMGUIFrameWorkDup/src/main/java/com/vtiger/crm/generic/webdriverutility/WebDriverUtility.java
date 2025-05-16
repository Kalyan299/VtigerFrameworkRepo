package com.vtiger.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForImplicit(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToNewWindowonUrl(WebDriver driver, String partialUrl) 
	{
	 
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl))
			{
				break;
			}
		}
	}
	
	public void switchToNewWindowonTitle(WebDriver driver, String partialTitle) 
	{
	 
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index) 
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String name) 
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertWithAccept(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertWithDismiss(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element, String text) 
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element, int index) 
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mouseHoverAction(WebDriver driver, WebElement element) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) 
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void maximize(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	public void minimize(WebDriver driver, int height, int width)
	{
		Dimension dim=new Dimension(height, width);
		driver.manage().window().setSize(dim);
	}
	
	public void waitForElementofTitle(WebDriver driver, String element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.titleContains(element));
	}
	
	public void waitForElementclick(WebDriver driver, WebElement elementclick) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.elementToBeClickable(elementclick));
	}
	
	public void waitForElementURL(WebDriver driver, String url) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	public void scrollActions(WebDriver driver, int x,int y)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void scrollDownForParticularELement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	public void scrollBottomOfPage(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight()");
	}
	
	public void scrollTopOfPage(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight()");
	}
	
	public void elementToBeClick(WebDriver driver, String locator, String address)
	{
	
	 switch(locator) {
	 case "id":
		driver.findElement(By.id(address)).click();
		 break;
	 case  "name":
		  driver.findElement(By.name(address)).click();
		break;
	 case "xpath":
		  driver.findElement(By.xpath(address)).click();
		break;
	 case "linkText":
		 driver.findElement(By.linkText(address)).click();
		break;
	 case "cssSelector":
		 driver.findElement(By.cssSelector(address)).click();
		break;
    default:
    	System.out.println("No case is available");
   
	}
	
	}
	
	public void elementToBeClear(WebDriver driver,String locator, String address)
	{
		switch(locator) {
		 case "id":
			driver.findElement(By.id(address)).clear();
			 break;
		 case  "name":
			  driver.findElement(By.name(address)).clear();
			break;
		 case "xpath":
			  driver.findElement(By.xpath(address)).clear();
			break;
		 case "linkText":
			 driver.findElement(By.linkText(address)).clear();
			break;
		 case "cssSelector":
			 driver.findElement(By.cssSelector(address)).clear();
			break;
	    default:
	    	System.out.println("No case is available");
	   
		}
	}
	
	public void  elementToBeEnter(WebDriver driver, String locator, String address, String data)
	{
		switch(locator) {
		 case "id":
			driver.findElement(By.id(address)).sendKeys(data);
			 break;
		 case  "name":
			  driver.findElement(By.name(address)).sendKeys(data);
			break;
		 case "xpath":
			  driver.findElement(By.xpath(address)).sendKeys(data);
			break;
		 case "linkText":
			 driver.findElement(By.linkText(address)).sendKeys(data);
			break;
		 case "cssSelector":
			 driver.findElement(By.cssSelector(address)).sendKeys(data);
			break;
	    default:
	    	System.out.println("No case is available");
	   
		}
	}
}
