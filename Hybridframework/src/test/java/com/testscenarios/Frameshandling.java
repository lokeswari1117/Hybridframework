package com.testscenarios;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.Commonfunctions;

public class Frameshandling extends Commonfunctions{

	Locators loc = new Locators();

	@BeforeClass
	public void beforeClass() {

		ChromeBrowserLaunch();

	}
  @Test
  public void f() throws Exception {
	  driver.get("http://mis.nyiso.com/public/");
		Thread.sleep(5000);		
		loopAllFramesForElement(By.name("P-24Alist"));		
		clickByAnyLocator(By.name("P-24Alist"));
		Thread.sleep(5000);			
		loopAllFramesForElement(By.linkText("Most recent interval"));
		clickByAnyLocator(By.linkText("Most recent interval"));
	
  }
}
