package generics;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityLib {
	
	//To get Screenshot of the current browser
	public static void getScreenShot(WebDriver driver, String path)
	{
		try{
		TakesScreenshot t = (TakesScreenshot) driver;
		File srcfile = (File) t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File (path));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//To get Screenshot of the Desktop or whole window
	public static void getScreenShot(String path) throws AWTException, IOException
	{
		
        Robot r = new Robot();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rt = new Rectangle(d);
        BufferedImage img = r.createScreenCapture(rt);
        ImageIO.write(img,"png", new File(path));
        
}
	
	// To get current time and formatting to user defined format
	public static String now()
	{
		SimpleDateFormat s = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return s.format(new Date());
	}
	
	
	//To read data from Excel
	public static String getCellValue(String path, String sheet, int r, int c)
	{
		String v = "";
		
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return v;
		}
	
	
	
	//To get Row Count
	public static int getRowCount(String path, String sheet)
	{
		int r=0;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			r = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	
	//To Handle Properties file (config.properties)
	public static String getPropertyValue(String configPath, String Key) 
	{
		String v = "";
		try{
			
			Properties p = new Properties();
		    p.load(new FileInputStream(configPath));
		    v  = p.getProperty(Key);
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	}