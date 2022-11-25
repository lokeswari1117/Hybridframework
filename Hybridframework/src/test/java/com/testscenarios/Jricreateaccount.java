package com.testscenarios;


import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.Commonfunctions;




public class Jricreateaccount extends Commonfunctions{
Locators loc = new Locators();

@Parameters("browserName")
@BeforeClass // Pre-condition
public void beforeClass(@Optional("edge") String browserName) {
	if (browserName.equalsIgnoreCase("Edge")) {
		driver = new EdgeDriver();
	} else if (browserName.equalsIgnoreCase("Firefox")) {
		driver = new FirefoxDriver();
	} else if (browserName.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	} else {
		System.out.println("Please give browser name chrome/edge/firefox only......");
	}

}

  @Test
  public void f() throws Exception {
	  
	  driver.get("https://www.Justrechargeit.com");
	  clickByAnyLocator(loc.jri_login_creataccount_hyperlink);
	
		Thread.sleep(5000);
		//To read the data from property file
		String path=".\\src\\test\\resources\\testdata\\QA_testdata.properties";
		FileInputStream fi= new FileInputStream(path);
		Properties p=new Properties();
		p.load(fi);
		sendKeysByAnyLocator(loc.jri_login_name_editbox, p.getProperty("Name"));
//        sendKeysByAnyLocator(loc.jri_login_mobilenum_editbox,p.getProperty("Mobile"));
//		sendKeysByAnyLocator(loc.jri_login_Email_editbox,p.getProperty("Email"));
//		sendKeysByAnyLocator(loc.jri_login_password_editbox,p.getProperty("password"));
  	Thread.sleep(5000);
  	clickByAnyLocator(loc.jri_login_checkbox_editbox);
  	
		clickByAnyLocator(loc.jri_login_creteaccount_button);
  }
  @AfterMethod
  public void afterMethod() throws Exception {
	  Screenshot();
  }

//  @BeforeClass
//  public void beforeClass() {
//	  ChromeBrowserLaunch();	 
//  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
