package com.testscenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.Commonfunctions;

public class Popuphandling extends Commonfunctions {
	Locators loc = new Locators();

	  @BeforeClass
	  public void beforeClass() {
		  ChromeBrowserLaunch();
	  }
  @Test
  public void f() throws Exception {

	  //POPUPHANDLING
	  driver.get("https://justrechargeit.com/SignIn.aspx");
	  Thread.sleep(5000);
	  clickByAnyLocator(loc.justrechargeitsignin_facebooksignin_button);
	  Thread.sleep(5000);
	  popuphandling() ;
	 }
}
