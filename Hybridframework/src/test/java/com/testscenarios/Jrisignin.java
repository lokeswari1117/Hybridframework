package com.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

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


public class Jrisignin extends Commonfunctions {
	
	Locators loc = new Locators();
  @Test
  public void f() throws Exception {
	  
	  driver.get("https://www.Justrechargeit.com");
	//To read the data from property file
			String path=".\\src\\test\\resources\\testdata\\QA_testdata.properties";
			FileInputStream fi= new FileInputStream(path);
			Properties p=new Properties();
			p.load(fi);
	  //driver.findElement(loc.jri_login_signin_hyperlink).click();
	  clickByAnyLocator(loc.jri_login_signin_hyperlink);
	  Thread.sleep(5000);
	  sendKeysByAnyLocator(loc.jri_login_signin_Email_editbox,p.getProperty("Email"));
	  sendKeysByAnyLocator(loc.jri_login_signin_password_editbox,p.getProperty("password"));
	  Scanner s = new Scanner(System.in);
	  	System.out.println("Enter the Captcha");
	  	String Captcha = s.next();
	  	Thread.sleep(5000);
	  	driver.findElement(loc. jri_login_signin_captchacode_editbox).sendKeys(Captcha);
	  
	  Thread.sleep(5000);
//	  driver.findElement(loc.jri_login_signin_Email_editbox).sendKeys(p.getProperty("Email"));
//	  	driver.findElement(loc.jri_login_signin_password_editbox).sendKeys(p.getProperty("password"))
//	  	Scanner s = new Scanner(System.in);
//	  	System.out.println("Enter the Captcha");
//	  	String Captcha = s.next();
//	  	Thread.sleep(5000);
//	  	driver.findElement(loc. jri_login_signin_captchacode_editbox).sendKeys("captcha");
	  	//driver.findElement(loc. jri_login_signin_signin_button).click();
	  	 clickByAnyLocator(loc. jri_login_signin_signin_button);
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
