package com.crm.qa.Testcase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddContactPage;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.Firstpage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class AddContactPageTest extends TestBase {

	public String sheetname="contact";
	
	public AddContactPageTest() {
		super();
	}
	
	
	Firstpage firstpage;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	AddContactPage addcontactpage;
	@BeforeMethod
	public void setup() {
		initalisation();
		firstpage=new Firstpage();
		loginpage=new LoginPage();
		contactpage=new ContactPage();
		addcontactpage=new AddContactPage();
		loginpage=firstpage.validatelogin();
		homepage=loginpage.LOGIN(prop.getProperty("username"),prop.getProperty("password"));
		contactpage=homepage.ClickOnContact();
		addcontactpage=contactpage.ClickOnNew();
		}
	@DataProvider(name="data-provider")
	public Iterator<Object[]> getCRMTestData()  {
	
	ArrayList<Object[]> data= TestUtil.getdata(sheetname);
		
	
	return data.iterator();
	} 
	@Test(priority =1)
	public void verifyTitletest() {
		addcontactpage.validatetitle();
	}
	
	@Test(priority=2,dataProvider="data-provider")
	public void AddMemberTest(String firstname,String lastname ) {
		addcontactpage.AddNewMembers(firstname, lastname);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
