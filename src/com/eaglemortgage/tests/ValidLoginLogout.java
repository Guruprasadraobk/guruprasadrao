package com.eaglemortgage.tests;

import org.testng.annotations.Test;

import bsh.Variable;

import com.eaglemortgage.pages.BasePage;
import com.eaglemortgage.pages.EnterTimeTrackPage;
import com.eaglemortgage.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class ValidLoginLogout extends BaseTest {
	
	@Test(priority=1, groups={"smoke", "login"})
	public void testValidLoginLogout()
	{
		/* UtilityLib.getCellValue will call the getCellValue method in UtilityLib class
		with provided input parameters. Then getCellValue runs with provided parameters and returns
		the current cell value. This cell value is then stored in temp Variable. In this case,
		the value returned from first iteration of getCellValue is stored in variable called un*/
		
		String un = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pw = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);
		String hp = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 2);
		String lp = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 3);
		
		//create LoginPage object and pass the username to SetUserName method
		LoginPage l = new LoginPage (driver);
		l.setUserName(un);
		
		//pass the passowrd to SetPassword method
		l.setPassword(pw);
		
		//click on login
		l.clickLogin();
		
		//create EnterTimeTrackPage object and pass the homePageTitle to verifyHomePageTitle method
		/*EnterTimeTrackPage e = new EnterTimeTrackPage (driver);
		e.verifyHomePageTitle(hp);*/
		
		BasePage b = new BasePage(driver);
		b.verifyTitle(hp);
		
		//click on logout by creating object of EnterTimeTrackPage
		EnterTimeTrackPage e = new EnterTimeTrackPage (driver);
		e.clickLogout();
		
		/*//pass the LoginPageTitle to verifyLoginPageTitle method
		e.verifyLoginPageTitle(lp);*/
		
		b.verifyTitle(lp);
	}

}
