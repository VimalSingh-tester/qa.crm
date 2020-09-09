package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class Firstpage extends TestBase {

@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
WebElement loginbtn;

@FindBy(xpath="//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
WebElement signupbtn;

@FindBy(xpath="//a[contains(text(),'Compare')]")
WebElement comparebtn;

public Firstpage() {
	PageFactory.initElements(driver, this);
}
public LoginPage validatelogin() {
	loginbtn.click();
	driver.manage().timeouts().implicitlyWait(TestUtil.implicity_wait, TimeUnit.SECONDS);
	return new LoginPage();
}
public SignUpPage validateSignup() {
	
	signupbtn.click();
	return new SignUpPage();
}
public ComparePage validateCompare() {

	comparebtn.click();
	return new ComparePage();
}
public String validatetitle() {
	String title=driver.getTitle();
return title;
}
}
