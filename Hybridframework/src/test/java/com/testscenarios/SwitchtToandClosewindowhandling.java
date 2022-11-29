package com.testscenarios;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.Commonfunctions;

public class SwitchtToandClosewindowhandling extends Commonfunctions {
	
	Locators loc = new Locators();
		
	@AfterMethod
	  public void afterMethod() throws Exception {
		  Screenshot();
	  }

	  @BeforeClass
	  public void beforeClass() {
		  ChromeBrowserLaunch();	 
	  }
  @Test
  public void f() throws Exception {
//WINDOWHANDLING
	  driver.get("https://myaccount.greenmountain.com/en_US/register");
	  Thread.sleep(5000);
	 clickByAnyLocator(loc.greenmountain_contactus_linktext);
	  windowhandling();
	 clickByAnyLocator(loc.greenmountain_cancel_botton);
      }
  
}
