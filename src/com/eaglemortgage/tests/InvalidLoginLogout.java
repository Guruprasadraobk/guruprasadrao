package com.eaglemortgage.tests;

import org.testng.annotations.Test;

import com.eaglemortgage.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;


public class InvalidLoginLogout extends BaseTest{
	
	@Test(priority=2, groups="login")
	public void testInValidLoginLogout()
	{
	
      int row_count = UtilityLib.getRowCount(INPUT_PATH,"InvalidLogin");
      
      
	for (int i=1; i <=row_count;i++)
	{
      String un = UtilityLib.getCellValue(INPUT_PATH, "InvalidLogin", i, 0);
      String pw = UtilityLib.getCellValue(INPUT_PATH, "InvalidLogin", i, 1);

           //create LoginPage object and pass the username to SetUserName method
    		LoginPage l = new LoginPage (driver);
    		l.setUserName(un);
    		
    		//pass the passowrd to SetPassword method
    		l.setPassword(pw);
    		
    		//click on login
    		l.clickLogin();
    		
    		l.verifyErrorMessageIsDisplayed();
    		
}
	}
}
