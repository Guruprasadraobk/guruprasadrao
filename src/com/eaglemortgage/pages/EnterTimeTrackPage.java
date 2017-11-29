package com.eaglemortgage.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends BasePage {

	   	//Finding Logout link
		@FindBy (id="logoutLink")
		private WebElement logoutLNK;
		
		//Finding Logout link
		@FindBy (xpath="//div[@class='popup_menu_label' and contains(text(), 'Settings')]")
		private WebElement settings;
				
		//Finding Logout link
		@FindBy (linkText="Licenses")
		private WebElement licenses;
		
		//Initialization of all the webelements in current page class (i.e. Enter Time Track page) declared above
		public EnterTimeTrackPage(WebDriver driver) {
				
			 super(driver);
				
			}
		
		//non static method to perform action on Logout field (Utilization) 
		 public void clickLogout()
		 {
			 logoutLNK.click();
		 }
		 
		//non static method to verify home page title (Utilization) 
		 public void verifyHomePageTitle(String hp)
		 {
			String homePageTitle = driver.getTitle();
			Reporter.log(homePageTitle,true);
			Assert.assertEquals(hp, homePageTitle);
		 }
		 
		//non static method to verify login page title (Utilization) 
		 public void verifyLoginPageTitle(String lp)
		 {
			String loginPageTitle = driver.getTitle();
			Assert.assertEquals(lp, loginPageTitle);
		 }
		 
		 
		//non static method to perform action on Settings field (Utilization)
		 public void clickSetting()
		 {
			 settings.click();
		 }
		 
		//non static method to perform action on Licenses link within Settings (Utilization)
		 public void clickLicenses()
		 {
			 licenses.click();
		 }
}
