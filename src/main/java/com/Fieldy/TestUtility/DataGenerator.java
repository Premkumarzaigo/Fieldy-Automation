package com.Fieldy.TestUtility;

import org.testng.annotations.DataProvider;

import com.Fieldy.TestBase.Constants;

public class DataGenerator {

	@DataProvider(name="loginData")
	public String[][] generatorUserLoginData()
	{
		ExcelUtils excel=new ExcelUtils(Constants.excelSheetsPath+"//DataDriven.xlsx", "Sheet3");
		int rows=excel.getRowCount();
		int columns=excel.getColumnCount();
		return excel.getEntireValue(rows, columns);
	}
}
