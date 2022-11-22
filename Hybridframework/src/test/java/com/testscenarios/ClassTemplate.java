package com.testscenarios;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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

import io.github.bonigarcia.wdm.WebDriverManager;


public class ClassTemplate {
	WebDriver driver;
	Locators loc = new Locators();
  @Test
  public void f() throws Exception {
	  
	  driver.get("https://www.facebook.com");
	  driver.findElement(loc.Fb_login_Email_editbox).sendKeys("swathi");
  	driver.findElement(loc.Fb_login_password_editbox).sendKeys("chowdhary");
  	Thread.sleep(5000);
		driver.findElement(loc.Fb_login_login_button).click();
  }
  @AfterMethod
  public void afterMethod() throws Exception {
		 Date d = new Date();
		 DateFormat abcd = new SimpleDateFormat("ddMMYYYY_HHmmss");
		 String timeStamp = abcd.format(d);
		File abc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(abc, new File(".\\screenshots\\test_"+timeStamp+".png"));
  }

  @BeforeClass
  public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();	 
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
