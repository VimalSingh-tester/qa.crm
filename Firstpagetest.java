package com.crm.qa.Testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Firstpage;

import junit.framework.Assert;

public class Firstpagetest extends TestBase {
	Firstpage firstpage;
	public Firstpagetest()
	{
		super();
		
	}
	@BeforeMethod
	public void setup() {
		initalisation();
		firstpage=new Firstpage();
	}
	@Test(priority=1)
	public void FirstPageTitleTest() {
		String title=firstpage.validatetitle();
		Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small");
	}
	@Test(priority=2)
	public void Firstpageloginbtn() {
		firstpage.validatelogin();
	
	}
	@Test(priority=3)
	public void Firstpagesignupbtn() {
		firstpage.validateSignup();	
	}
	@Test(priority=4)
	public void Firstpagecomparebtn() {
		firstpage.validateCompare();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
