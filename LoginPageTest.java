package com.crm.qa.Testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Firstpage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	Firstpage firstpage;
	LoginPage loginpage;
public LoginPageTest() {
	super();
}
@BeforeMethod
public void setup() {
	initalisation();
	firstpage=new Firstpage();
	loginpage=new LoginPage();
	loginpage=firstpage.validatelogin();
}
@Test(priority=1)
public void LoginPageTitleTest() {
	 Assert.assertEquals(loginpage.VerifyLoginPageTitle(),"Cogmento CRM");
}
@Test(priority=2)
public void LoginTest() {
	
	loginpage.LOGIN(prop.getProperty("username"),prop.getProperty("password"));
	
}

@AfterMethod
public void teardown() {
	driver.quit();
}








}