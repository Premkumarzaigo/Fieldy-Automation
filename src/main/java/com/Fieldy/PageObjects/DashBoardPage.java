package com.Fieldy.PageObjects;

import org.openqa.selenium.By;

import com.Fieldy.TestUtility.DriverUtils;

public class DashBoardPage extends DriverUtils{

	
	By settingsIcon=By.xpath("//i[@data-n-linkto='settings']");
	
	By amcHeaderIcon=By.xpath("//div[@class='setting-header'][@data-n-linkto='amc']");
	
	
	public void clickAMCModule()
	{
		clickSettingIcon();
		clickamcHeaderIcon();
	}
	
	public void clickSettingIcon()
	{
		click(settingsIcon);
	}
	
	public void clickamcHeaderIcon()
	{
		click(amcHeaderIcon);
	}
	
}
