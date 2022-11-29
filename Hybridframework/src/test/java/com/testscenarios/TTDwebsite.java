package com.testscenarios;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.Commonfunctions;

public class TTDwebsite extends Commonfunctions {
	Locators loc = new Locators();

	  @BeforeClass
	  public void beforeClass() {
		  ChromeBrowserLaunch();
	  }
  @Test
  public void f() throws Exception {
	  driver.get("https://tirupatibalaji.ap.gov.in/#/registration");
	  Thread.sleep(5000);
	  
	  Selectcustomiseoptionfromdropdownvalues(loc.TTDWebsite_country_dropdown,  "Australia");
  }
}
