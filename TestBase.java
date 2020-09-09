package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public TestBase() {
		try {
			prop=new Properties();
		 fis=new FileInputStream("\\Users\\vimal786singhrana\\Desktop\\selenium project\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\confiq\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void initalisation() {
		System.setProperty("webdriver.gecko.driver","C://Users//vimal786singhrana//Desktop//software//geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.implicity_wait,TimeUnit.SECONDS);
				
		driver.get(prop.getProperty("URL"));
	
	}
}
