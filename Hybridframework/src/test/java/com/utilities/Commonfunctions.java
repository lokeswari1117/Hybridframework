package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

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
	
	
}
