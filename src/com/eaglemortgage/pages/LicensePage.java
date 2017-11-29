package com.eaglemortgage.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LicensePage extends BasePage {

	
	       //Finding actitime version link within Production Edition field
			@FindBy (xpath=".//nobr[text()='Product Edition:']/../../td[2]/b")
			private WebElement productEdition;
			
			
			//Initialization of all the webelements in current page class (i.e. License page) declared above
			public LicensePage(WebDriver driver) {
					
				 super(driver);
					
				}
			
			//non static method to perform action on Logout field (Utilization) 
			 public void verifyProductEdition(String eValue)
			 {
				String aValue = productEdition.getText();
				Assert.assertEquals(aValue, eValue);
			 }
}		 
 
