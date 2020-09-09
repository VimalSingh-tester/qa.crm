package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
		
	public String VerifyLoginPageTitle() {
		return driver.getTitle();
	}
	public HomePage LOGIN(String un,String pswd) {
		username.sendKeys(un);
		password.sendKeys(pswd);
		loginbtn.click();
		return new HomePage();
	}
	
}