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




public class Fb_login extends Commonfunctions {
	
	Locators loc = new Locators();
  @Test
  public void f() throws Exception {
	  
	  driver.get("https://www.facebook.com");

		//To read the data from property file
		String path=".\\src\\test\\resources\\testdata\\QA_testdata.properties";
		FileInputStream fi= new FileInputStream(path);
		Properties p=new Properties();
		p.load(fi);
		sendKeysByAnyLocator(loc.Fb_login_Email_editbox, p.getProperty("Email"));
	  
	  
//	driver.findElement(loc.Fb_login_Email_editbox).sendKeys(p.getproperty("Email"));
//  	driver.findElement(loc.Fb_login_password_editbox).sendKeys(p.getproperty("password"));
// 	Thread.sleep(5000);
//		driver.findElement(loc.Fb_login_login_button).click();
		clickByAnyLocator(loc.Fb_login_login_button);
		
  }
  @AfterMethod
  public void afterMethod() throws Exception {
	  Screenshot();
  }

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

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
