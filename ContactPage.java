package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{

	@FindBy(xpath="//button[@class='ui linkedin button' and text()='New']")
	WebElement newbtn;
	
	public ContactPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validatetitle() {
		String title=driver.getTitle();
	return title;}
	public AddContactPage ClickOnNew() {
		newbtn.click();
		return new AddContactPage();
	}
}
