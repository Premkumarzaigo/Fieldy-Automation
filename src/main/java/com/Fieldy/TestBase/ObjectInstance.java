package com.Fieldy.TestBase;

import com.Fieldy.PageObjects.AMCFormPage;
import com.Fieldy.PageObjects.DashBoardPage;
import com.Fieldy.PageObjects.LoginPage;

public class ObjectInstance {

	public static AMCFormPage getAMCFormPageInstance()
	{
		return new AMCFormPage();
	}
	
	public static DashBoardPage getDasdBoardPageInstance()
	{
		return new DashBoardPage();
	}
	
	public static LoginPage getLoginPageInstance()
	{
		return new LoginPage();
	}
}
