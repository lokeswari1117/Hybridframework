package com.testscenarios;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.Commonfunctions;

public class Assignment18 extends Commonfunctions {
	Locators loc = new Locators();
	@BeforeClass
	  public void beforeClass() {
		  ChromeBrowserLaunch();
	  }
  @Test
  public void f() throws Exception {
	  driver.get("https://demoqa.com/browser-windows");
	  Thread.sleep(5000);
	  clickByAnyLocator(loc.demoqa_newtab_button);
	  Thread.sleep(5000);
	  windowhandling();
	  clickByAnyLocator(loc.demoqa_newwindow_button);
	  Thread.sleep(5000);
	  popuphandling() ;
}
  }
