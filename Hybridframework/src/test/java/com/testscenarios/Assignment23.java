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
import com.utilities.Commonfunctions;




public class Assignment23 extends Commonfunctions  {
	
Locators loc = new Locators();
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("https://www.toyota.co.uk/order-a-brochure");
	  Thread.sleep(3000);
	  loopAllFramesForElement(loc.Toyota_cookie_yesagreebutton);
	  clickByAnyLocator(loc.Toyota_cookie_yesagreebutton);
	  Thread.sleep(3000);
	  loopAllFramesForElement(loc.Toyota_cookie2_yesagreebutton);
	  clickByAnyLocator(loc.Toyota_cookie2_yesagreebutton);
	  Thread.sleep(3000);
	  loopAllFramesForElement(loc.Toyota_page_radiobutton);
	  clickByAnyLocator(loc.Toyota_page_radiobutton);

	  }

	    
  
//  @AfterMethod
//  public void afterMethod() throws Exception {
//		 Date d = new Date();
//		 DateFormat abcd = new SimpleDateFormat("ddMMYYYY_HHmmss");
//		 String timeStamp = abcd.format(d);
//		File abc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	    FileHandler.copy(abc, new File(".\\screenshots\\test_"+timeStamp+".png"));
//  }

  @BeforeClass
  public void beforeClass() {
        
        driver = new ChromeDriver();	 
 }
//
//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//  }

}
