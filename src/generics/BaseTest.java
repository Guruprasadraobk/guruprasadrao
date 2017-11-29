package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@Listeners(FwListener.class)
public abstract class BaseTest implements IAutoConst
{
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun=true)
	public void SetDriverPath()
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, CHROME_VALUE);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void openApp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String main_url = UtilityLib.getPropertyValue(IAutoConst.CONFIG_PATH,"URL");
		driver.get(main_url);
	}
	
	@AfterMethod(alwaysRun=true)
	public void CloseApp()
	{
		driver.quit();
	}
	
	
	

}

