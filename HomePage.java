package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//span[text()='Contacts' and @class='item-text']")
	WebElement contactbtn;
	
public HomePage() {
	PageFactory.initElements(driver, this);
	
}
public ContactPage ClickOnContact() {
	contactbtn.click();
	return new ContactPage();
}




}
