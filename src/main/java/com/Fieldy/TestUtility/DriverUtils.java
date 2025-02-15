package com.Fieldy.TestUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.Fieldy.TestBase.BaseClass;
import com.Fieldy.TestBase.Constants;

public class DriverUtils extends BaseClass{
	
	static Select select;

	public static void maximize()
	{
		driver.manage().window().maximize();
	}
	
	public static void minimized()
	{
		driver.manage().window().minimize();
	}
	
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static void implicitWait(int wait)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}
	
	public static void get(String pageURL)
	{
		driver.get(pageURL);
	}
	
	public static String getTitle()
	{
		return driver.getTitle();
	}
	
	public static String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	public static void quit()
	{
		driver.quit();
	}
	
	public static void close()
	{
		driver.close();
	}
	
	public static void sendKeys(By locator,String value)
	{
		WebElement element=driver.findElement(locator);
		element.sendKeys(value);
	}
	
	public static void click(By locator)
	{
		WebElement element=driver.findElement(locator);
		element.click();
	}
	
	public static void clear(By locator)
	{
		WebElement element=driver.findElement(locator);
		element.clear();
	}
	
	public static String getText(By locator)
	{
		WebElement element=driver.findElement(locator);
		return element.getText();
	}
	
	public static void selectByIndex(By locator,int index)
	{
		WebElement element=driver.findElement(locator);
		select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValue(By locator,String value)
	{
		WebElement element=driver.findElement(locator);
		select=new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByVisibleText(By locator,String visibleText)
	{
		WebElement element=driver.findElement(locator);
		select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public static void clickOkOnAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public static void clickCancelOnAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static String getTextOnAlert()
	{
		return driver.switchTo().alert().getText();
	}
	
	public static void sendKeysOnAlert(String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	public static void captureScreenShot(String fileName)
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File screenShotAs=screen.getScreenshotAs(OutputType.FILE);
		File screenShotTo=new File(Constants.screenShotPath+"\\"+fileName+System.currentTimeMillis()+".png");
		try {
		FileHandler.copy(screenShotAs, screenShotTo);
		}
		catch(FileNotFoundException e)
		{
			e.getMessage();
		}
		
		catch(IOException e)
		{
			e.getMessage();
		}
		
	}
	
	public static String captureScreenShotBASE64()
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		return screen.getScreenshotAs(OutputType.BASE64);
	}
	
}
