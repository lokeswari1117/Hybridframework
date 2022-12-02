package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Commonfunctions {
	public WebDriver driver;
//QA will create reusable methods(Functions)
	public void ChromeBrowserLaunch() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
	}
	public void Screenshot() throws Exception {
		 Date d = new Date();
		 DateFormat abcd = new SimpleDateFormat("ddMMYYYY_HHmmss");
		 String timeStamp = abcd.format(d);
		File abc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(abc, new File(".\\screenshots\\test_"+timeStamp+".png"));
  }
	public void sendKeysByAnyLocator (By locator, String inputdata) throws Exception {
		WebElement element = driver.findElement(locator);
		// Check your locator is displayed?
		if (element.isDisplayed()) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				System.out.println(locator+"Given locator is enable state");
				// Clear any existing data
				element.clear();
				highlightElement(element);
				// Send the test data to Edit box
				highlightElement(element);
				element.sendKeys(inputdata);
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}
	
	private void highlightElement(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='6px groove green'",element);
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border=''",element);
	}
	public void clickByAnyLocator(By locator) {
		WebElement element = driver.findElement(locator);
		// Check your locator is displayed?
		if (element.isDisplayed()) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				// Click on Button/radiobutton/checkbox/Link...
				element.click();
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}
	public void windowhandling() throws Exception {
		 
		  System.out.println(driver.getWindowHandle());
		  System.out.println(driver.getWindowHandles());
		 //switch to window using tab 
		  String ParentWindow = driver.getWindowHandle();
		  ArrayList<String> Alltabs = new ArrayList<String>(driver.getWindowHandles());
		  
		  driver.switchTo().window(Alltabs.get(1));
		//switch to window using tab and close the New tab again back to parent window
		  driver.close();
		  
		//  driver.switchTo().window(Alltabs.get(0));
		  driver.switchTo().window(ParentWindow);
	}
	public void popuphandling() throws Exception { 
	
	  System.out.println(driver.getWindowHandle());
	  System.out.println(driver.getWindowHandles());
	  Set<String> Allwindows = (driver.getWindowHandles());
	  String ParentWindow = driver.getWindowHandle();
	  for(String abc : Allwindows) {
		  if(!ParentWindow.equals(abc)) {
			  driver.switchTo().window(abc);
			  driver.close();
			  }
	  }
	  
	  driver.switchTo().window(ParentWindow);
	 }
	public void Selectbyvisibletext(By locator, String visibletext) {
		WebElement element=driver.findElement(locator);
		if(element.isDisplayed()) {
			if(element.isEnabled()) {
	Select dropdown=new Select(element);
			dropdown.selectByVisibleText(visibletext);
			}
			else {
				System.out.println("WebElement is not enabled");
			}
		}
			else {
				System.out.println("WebElement is not displayed");
			}
		
	}
	public void SelectbyIndex(By locator, int index) {
		WebElement element=driver.findElement(locator);
		if(element.isDisplayed()) {
			if(element.isEnabled()) {
	Select dropdown=new Select(element);
			dropdown.selectByIndex(index);
			}
			else {
				System.out.println("WebElement is not enabled");
			}
		}
			else {
				System.out.println("WebElement is not displayed");
			}
		
	}
	public void Selectbyvalue(By locator, int value) {
		WebElement element=driver.findElement(locator);
		if(element.isDisplayed()) {
			if(element.isEnabled()) {
	Select dropdown=new Select(element);
			dropdown.selectByIndex(value);
			}
			else {
				System.out.println("WebElement is not enabled");
			}
		}
			else {
				System.out.println("WebElement is not displayed");
			}
		
	}
	public void Printalldropdownvalues(By locator, int value) {
		WebElement element=driver.findElement(locator);
		if(element.isDisplayed()) {
			if(element.isEnabled()) {
	Select dropdown=new Select(element);
			List<WebElement> dropdownvalues = dropdown.getOptions();
			System.out.println(dropdownvalues.size());
			for(WebElement xyz:dropdownvalues) {
			System.out.println(xyz.getText());
			}
			}
			else {
				System.out.println("WebElement is not enabled");
			}
		}
			else {
				System.out.println("WebElement is not displayed");
			}
		
	}
	public void Selectcustomiseoptionfromdropdownvalues(By locator, String visibletext) {
		WebElement element=driver.findElement(locator);
		if(element.isDisplayed()) {
			if(element.isEnabled()) {
	Select dropdown=new Select(element);
			List<WebElement> dropdownvalues = dropdown.getOptions();
			System.out.println(dropdownvalues.size());
			for(int i=0;i<dropdownvalues.size();i++) {
			System.out.println(dropdownvalues.get(i).getText());
			if(dropdownvalues.get(i).getText().equals(visibletext)) {
				dropdown.selectByIndex(i);
				break;
			}
			}
			}
			else {
				System.out.println("WebElement is not enabled");
			}
		}
			else {
				System.out.println("WebElement is not displayed");
			}
		}

	/******************** Frames Handling *******************/

	public int iframeCount() {
		driver.switchTo().defaultContent();
		// js = ((JavascriptExecutor) driver);
		int numberOfFrames = Integer
				.parseInt(((JavascriptExecutor) driver).executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are: " + numberOfFrames);
		return numberOfFrames;
	}

	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	public int loopAllFramesForElement(By locator) {

		int elementpresenceCount = 0;
		int loop = 0;
		int maxFramecount = iframeCount();// 3
		
		// if given locater has present on webpage, then the element size would be '1' else '0'
		elementpresenceCount = driver.findElements(locator).size();// 0
		while (elementpresenceCount == 0 && loop < maxFramecount) {
			try {
				switchToFrameByInt(loop);
				elementpresenceCount = driver.findElements(locator).size();// 1
				System.out.println("Try LoopAllframesAndReturnWebEL : " + loop + "; ElementpresenceCount: "
						+ elementpresenceCount);
				if (elementpresenceCount > 0 || loop > maxFramecount) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Catch LoopAllframesAndReturnWebEL Old: " + loop + "; " + ex);
			}
			loop++;// 1
		}
		return elementpresenceCount;
	}
}
	


