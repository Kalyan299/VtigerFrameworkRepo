package com.vtiger.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceInfoPage {
public InvoiceInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[@class='lvtHeaderText']") private WebElement headerMsg;
@FindBy(xpath="(//td[@class='dvtCellInfo'])[4]\"") private WebElement invoiceNoEdt;
public WebElement getHeaderMsg() {
	return headerMsg;
}
public WebElement getInvoiceNoEdt() {
	return invoiceNoEdt;
}

}
