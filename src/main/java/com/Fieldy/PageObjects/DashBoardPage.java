package com.Fieldy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Fieldy.TestUtility.DriverUtils;

public class DashBoardPage extends DriverUtils{

	
	By settingsIcon=By.xpath("//i[@data-n-linkto='settings']");
	
	By amcHeaderIcon=By.xpath("//div[@class='setting-header'][@data-n-linkto='amc']");
	
	By userMenu=By.xpath("//ul[@id='f_menu']/li[@id='user-active']/div/a/i");
	
	By trackingOption=By.xpath("//li[@id='team_live_location']");
	
	By attendanceMenu=By.xpath("//a[@class='nav-link attendance-icon']");
	
	By clockInOption=By.xpath("//div[@id='clock_in_button']");
	
	By clockOutOption=By.xpath("//div[@id='clock_out_button']");
	
	By clockInMessageText=By.xpath("//span[text()='Clocked in successfully']");
	
	By clockOutMessageText=By.xpath("//span[text()='Clocked out successfully']");
	
	
	
	
	public void clickAMCModule()
	{
		clickSettingIcon();
		clickamcHeaderIcon();
	}
	
	public void clickSettingIcon()
	{
		webDriverWaitForVisibilityOfElementLocated(settingsIcon).click();
	}
	
	public void clickamcHeaderIcon()
	{
		webDriverWaitForVisibilityOfElementLocated(amcHeaderIcon).click();
	}
	
	public void getAttendanceModule()
	{
		clickUserMenu();
		clickTrackingOption();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickAttendanceMenu();
	}
	
	public void clickUserMenu()
	{
		WebElement element = webDriverWaitForVisibilityOfElementLocated(userMenu);
		mouseHoverByElement(element);
	}
	
	public void clickTrackingOption()
	{
		webDriverWaitForVisibilityOfElementLocated(trackingOption).click();
	}
	public void clickAttendanceMenu()
	{
		webDriverWaitForVisibilityOfElementLocated(attendanceMenu).click();
	}
	
	public WebElement getClockinOption()
	{
		return webDriverWaitForVisibilityOfElementLocated(clockInOption);
	}
	
	public WebElement getClockOutOption()
	{
		return webDriverWaitForVisibilityOfElementLocated(clockOutOption);
	}
	
	public WebElement getClockinMessage()
	{
		return webDriverWaitForVisibilityOfElementLocated(clockInMessageText);
	}
	
	public WebElement getClockOutMessage()
	{
		return webDriverWaitForVisibilityOfElementLocated(clockOutMessageText);
	}
	
}
