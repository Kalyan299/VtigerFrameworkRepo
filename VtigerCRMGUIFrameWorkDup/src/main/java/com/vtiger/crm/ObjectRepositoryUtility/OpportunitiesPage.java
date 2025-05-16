package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OpportunitiesPage {
//WebDriver driver;
WebDriverUtility web=new WebDriverUtility();
public OpportunitiesPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//img[@title='Create Opportunity...']")private WebElement createOppBtn;
	@FindBy(name="search_text")private WebElement oppSearchEdt;
	@FindBy(name="search_field")private WebElement searchDD;
	@FindBy(name="submit")private WebElement searchNowBtn;
	
	public WebElement getCreateOppBtn() {
		return createOppBtn;}

	public WebElement getOppSearchEdt() {
		return oppSearchEdt;}

	public WebElement getSearchDD() {
		return searchDD;}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;}
	
	public void checkOpportunity(String OpportunityName) 
	{
		oppSearchEdt.sendKeys(OpportunityName);
		web.select(searchDD, "Opportunity Name");
		searchNowBtn.click();
	}
}
