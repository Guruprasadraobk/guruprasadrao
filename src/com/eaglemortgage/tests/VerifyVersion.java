package com.eaglemortgage.tests;

import org.testng.annotations.Test;

import com.eaglemortgage.pages.BasePage;
import com.eaglemortgage.pages.EnterTimeTrackPage;
import com.eaglemortgage.pages.LicensePage;
import com.eaglemortgage.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class VerifyVersion extends BaseTest {
	
	@Test(priority=3, groups={"smoke"})
	public void testVerifyVersion()
	{
		String un = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pw = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);
		
		       //create LoginPage object and pass the username to SetUserName method
				LoginPage l = new LoginPage (driver);
				String version = l.getVersion();
				
				l.setUserName(un);
				
				//pass the passowrd to SetPassword method
				l.setPassword(pw);
				
				//click on login
				l.clickLogin();
				
				//click on logout by creating object of EnterTimeTrackPage
				EnterTimeTrackPage e = new EnterTimeTrackPage (driver);
				e.clickSetting();
				
				//click on Licences
				e.clickLicenses();
				
				LicensePage lp = new LicensePage(driver);
				lp.verifyProductEdition(version);
				
				e.clickLogout();
				
				
	}

}
