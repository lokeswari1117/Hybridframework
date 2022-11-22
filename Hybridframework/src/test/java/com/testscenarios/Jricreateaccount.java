package com.testscenarios;

import java.io.File;
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
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.Commonfunctions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Jricreateaccount extends Commonfunctions{
	
	Locators loc = new Locators();
  @Test
  public void f() throws Exception {
	  
	  driver.get("https://www.Justrechargeit.com");
	  //driver.findElement(loc.jri_login_creataccount_hyperlink).click();
	
		Thread.sleep(5000);
		//To read the data from property file
		String path=".\\src\\test\\resources\\testdata\\UAT_testdata2.properties";
		FileInputStream fi= new FileInputStream(path);
		Properties p=new Properties();
		p.load(fi);
		sendKeysByAnyLocator(loc.jri_login_name_editbox, p.getProperty("Name"));
//	  driver.findElement(loc.jri_login_name_editbox).sendKeys(p.getProperty("Name"));
//	  driver.findElement(loc.jri_login_mobilenum_editbox).sendKeys(p.getProperty("Mobile"));
//	  driver.findElement(loc.jri_login_Email_editbox).sendKeys(p.getProperty("Email"));
//  	driver.findElement(loc.jri_login_password_editbox).sendKeys(p.getProperty("password"));
//  	Thread.sleep(5000);
//  	driver.findElement(loc.jri_login_checkbox_editbox).click();
//  	driver.findElement(loc. jri_login_creteaccount_button ).click();
		clickByAnyLocator(loc.jri_login_creteaccount_button);
  }
  @AfterMethod
  public void afterMethod() throws Exception {
	  Screenshot();
  }

  @BeforeClass
  public void beforeClass() {
	  ChromeBrowserLaunch();	 
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
