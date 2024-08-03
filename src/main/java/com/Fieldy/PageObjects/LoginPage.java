package com.Fieldy.PageObjects;

import org.openqa.selenium.By;

import com.Fieldy.TestUtility.DriverUtils;

public class LoginPage extends DriverUtils{



	By usernameField=By.xpath("//input[@id='login']");

	By passwordField=By.xpath("//input[@id='password']");

	By loginButton=By.xpath("//button[@id='submit-button']");

	

	public void verifyLogin(String userName,String password)
	{
			enterUserName(userName);
			enterpassword(password);
			clickLoginButton();
	}


	public void enterUserName(String userName)
	{
		sendKeys(usernameField, userName);
	}

	public void enterpassword(String password)
	{
		sendKeys(passwordField, password);
	}

	public void clickLoginButton()
	{
		click(loginButton);
	}


}
