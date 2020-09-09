package com.crm.qa.Testcase;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.Firstpage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase{

	Firstpage firstpage;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	
	@BeforeMethod
	public void setup() {
		initalisation();
		firstpage=new Firstpage();
		loginpage=new LoginPage();
		loginpage=firstpage.validatelogin();
		homepage=loginpage.LOGIN(prop.getProperty("username"),prop.getProperty("password"));
		contactpage=homepage.ClickOnContact();
	}
	
	@Test()
	public void ContactPagetilteTest() {
		Assert.assertEquals(contactpage.validatetitle(),"Cogmento CRM");
	}
	public void ClickOnNewTest() {
		contactpage.ClickOnNew();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
