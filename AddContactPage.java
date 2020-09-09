package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AddContactPage extends TestBase{
	

	@FindBy(name="first_name")
WebElement fname;
	@FindBy(name="last_name")
WebElement lname;

	public AddContactPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validatetitle() {
		String title=driver.getTitle();
	return title;}
	
	
	
	public void AddNewMembers(String Fname,String Lname) {
		fname.sendKeys(Fname);
		lname.sendKeys(Lname); 
		
		
}
}