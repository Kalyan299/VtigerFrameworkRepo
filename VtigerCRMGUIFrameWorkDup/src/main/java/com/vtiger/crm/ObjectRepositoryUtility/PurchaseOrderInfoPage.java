package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInfoPage {
//WebDriver driver;
public PurchaseOrderInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[@class='lvtHeaderText']") private WebElement headerMsg;
@FindBy(id="mouseArea_Vendor Name") private WebElement verifyVendor;
@FindBy(xpath="(//td[@class='dvtCellInfo'])[2]") private WebElement verifyPONum;

public WebElement getHeaderMsg() {
	return headerMsg;
}

public WebElement getVerifyVendor() {
	return verifyVendor;
}

public WebElement getVerifyPONum() {
	return verifyPONum;
}




}
