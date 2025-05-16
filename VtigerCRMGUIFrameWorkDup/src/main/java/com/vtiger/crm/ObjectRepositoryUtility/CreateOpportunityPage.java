package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.JavaUtlity;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOpportunityPage {
//WebElement driver;
JavaUtlity java=new JavaUtlity();
WebDriverUtility web=new WebDriverUtility();

public CreateOpportunityPage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
	@FindBy(name="potentialname")private WebElement oppNameEdt;
	@FindBy(name="closingdate")private WebElement closeDate;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	@FindBy(name="amount")private WebElement amtEdt;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")private WebElement orgLink;
	@FindBy(name="search_text")private WebElement orgSearchEdt;
	@FindBy(xpath="//input[@type='button']")private WebElement orgSearchBtn;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}
	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	public WebElement getAmtEdt() {
		return amtEdt;
	}
	public WebElement getOppName() {
		return oppNameEdt;
	}
	public WebElement getCloseDate() {
		return closeDate;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOpportunity(String OppName, String Amount) {
		oppNameEdt.sendKeys(OppName);
		closeDate.clear();
		String Close=java.getRequireddate(45);
		closeDate.sendKeys(Close);
		amtEdt.sendKeys(Amount);
	}
	public void switchToOrgInOppty(WebDriver driver, String orgName) {
		orgLink.click();
		web.switchToNewWindowonUrl(driver, "Accounts&action");
		orgSearchEdt.sendKeys(orgName);
		orgSearchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		web.switchToNewWindowonUrl(driver, "Potentials&action");
	}
	public void saveOpportunity() {
		saveBtn.click();
	}
	
}
