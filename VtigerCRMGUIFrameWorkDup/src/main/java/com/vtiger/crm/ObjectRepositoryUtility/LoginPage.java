package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Object Initialization
	@FindBy(name="user_name")private WebElement UserNameEdt;
	
	@FindBy(name="user_password")private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")private WebElement loginBtn;
	//Object Encapsulation
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Object Utilization and provide action
	public void loginApp(String Username, String Password) {
		
		UserNameEdt.sendKeys(Username);
		PasswordEdt.sendKeys(Password);
		loginBtn.click();
	}
	
}
