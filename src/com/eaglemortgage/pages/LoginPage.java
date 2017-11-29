package com.eaglemortgage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends BasePage {
	
	//Finding Username
	@FindBy (id="username")
	private WebElement unTXB;
	
	//Finding password
	@FindBy (name="pwd")
	private WebElement pwTXB;
	
	//Finding login button
	@FindBy (id="loginButton")
	private WebElement loginBTN;
	
	//Finding Actitime version
	@FindBy (xpath="//nobr[contains(text(),'actiTIME 201')]")
	private WebElement actiTIMEVersion;
	
	//Finding the error message after clicking submit without valid USN/PWD
	@FindBy (xpath=".//span[text()='Username or Password is invalid. Please try again.']")
	private WebElement errMsg;
	
	
    //Initialization of all the webelements in current page class (i.e. Login page) declared above
	public LoginPage (WebDriver driver)
	{
		super(driver);
	}
	
	//non static method to perform action on USN field (Utilization)
	public void setUserName (String un)
	{
		unTXB.sendKeys(un);
	}
	
	//non static method to perform action on PWD field (Utilization)
	public void setPassword (String pw)
	{
		pwTXB.sendKeys(pw);
	}
	
	
	//non static method to perform action on login button (Utilization)
	public void clickLogin ()
	{
		loginBTN.click();
		
		try {
			Thread.sleep(20);
		} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//non static method to perform action on error message displayed (Utilization)
	public void verifyErrorMessageIsDisplayed()
	{
		verifyElementIsPresent(errMsg);
		
		//System.out.println(errMsg);
	}

	
	//non static method to perform action on Actitime version field (Utilization)
	public String getVersion()
	{
		return actiTIMEVersion.getText();
	}
}
