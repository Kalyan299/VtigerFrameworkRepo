package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationPage {
//WebDriver driver;
WebDriverUtility web=new WebDriverUtility();

	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")private WebElement createBtn;
    @FindBy(name="search_text")private WebElement searchEdt;
	@FindBy(name="search_field")private WebElement searchDD;
    @FindBy(name="submit")private WebElement searchNowBtn;
	
	public WebElement getCreateBtn() {
		return createBtn;
	}
    public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSearchDD() {
		return searchDD;
	}
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	public void selectOrgName() {
		web.select(searchDD, "Organization Name");
	}
	
}
