package generics;

import java.awt.AWTException;
import java.awt.event.*;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

 public class FwListener implements ITestListener, IAutoConst{

	public void onTestStart(ITestResult result) {
				
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}
    
	// We are writing our code only in onTestFailure because we are interested in taking screenshot only if our test fails
	public void onTestFailure(ITestResult result) {
		String name = UtilityLib.now();
		String path = IAutoConst.PHOTO_PATH + name + ".png";
		try {
			UtilityLib.getScreenShot(path);
		} catch (AWTException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Reporter.log("photo is taken:" + path, true);
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
	
		
	}
	 
	 
 }