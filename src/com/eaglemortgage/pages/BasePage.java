package com.eaglemortgage.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	
	// declaration of driver
	public WebDriver driver;
	String aTitle;
	
	// Initialization of driver
	public BasePage (WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
		 this.driver=driver;
	}
	
	//common code to verify page title
	public void verifyTitle (String eTitle)
	{
		WebDriverWait wait = new WebDriverWait (driver,10);
				
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			aTitle = driver.getTitle();
			//Reporter.log(aTitle,true);
			Assert.assertEquals(eTitle, aTitle);
			Reporter.log("Title is matching" + " " + aTitle, true);
		}
		
		catch (Exception e)
		{
			Reporter.log("Title is NOT matching:"  + " " + "Expected is >> " + eTitle, true);
			Assert.fail();
		}
	}
	
	
	//common code to verify whether element is present or not
	public void verifyElementIsPresent (WebElement element)
	{
		WebDriverWait wait = new WebDriverWait (driver,20);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		    boolean elementDisp = element.isDisplayed();
		    if (elementDisp == true)
		    {
			Reporter.log("Title is present", true);
		    }
		    
		    else
		    {
		    	Reporter.log("Title is not found here", true);	
		    }
		}
		
		catch (Exception e)
		{
			Reporter.log("Title is NOT present" , true);
			//Assert.fail();
		}
	}

}
