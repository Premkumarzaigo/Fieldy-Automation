package com.Fieldy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Fieldy.TestUtility.DriverUtils;

public class AMCFormPage extends DriverUtils{


	By newButton=By.xpath("//div[@data-n-linkto='amc_create']");

	By contactNameField=By.xpath("//input[@name='id_customer_group'][@maxlength='256']");

	By contactNameList=By.xpath("//div[@id='contactdropdownlist']/div[1]/div[starts-with(@id,'drop')]");

	By chooseServiceField=By.xpath("//input[starts-with(@id,'inservice')][@maxlength='256']");

	By chooseServiceList=By.xpath("//div[starts-with(@id,'servicesdropdownlist')]/div[1]/div[starts-with(@id,'drop')]");

	By startDate=By.xpath("//input[starts-with(@id,'amc_details__start_date')]");
	
	By endDate=By.xpath("//input[starts-with(@id,'amc_details__expiry_date')]");
	
	By amcCostfield=By.xpath("//input[starts-with(@id,'amc_details__cost')]");
	
	By saveAndCompleteButton=By.xpath("//button[@id='amccreatesubmit']");
	
	
	public void createAMCForm(String contactName,String serviceName,String fromDate,String toDate,String amcCost) 
	{
		clickNewButton();

		chooseContactName(contactName);

		chooseServiceType(serviceName);
		
		enterStartDate(fromDate);
		
		enterEndDate(toDate);
		
		enterAmcCost(amcCost);
		
		clickSaveAndCompleteButton();
	}


	public void clickNewButton()
	{
		click(newButton);
	}

	public void chooseContactName(String contactName)
	{
		sendKeys(contactNameField, contactName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> nameList = driver.findElements(contactNameList);

		for (WebElement list : nameList) {
			System.out.println(list.getText());
		}

		for (WebElement list : nameList) {
			if(list.getText().startsWith(contactName))
			{
				list.click();
				break;
			}
		}
	}
	
	public void chooseServiceType(String serviceName)
	{
		sendKeys(chooseServiceField, serviceName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> serviceList = driver.findElements(chooseServiceList);

		for (WebElement list : serviceList) {
			System.out.println(list.getText());
		}

		for (WebElement list : serviceList) {
			if(list.getText().startsWith(serviceName))
			{
				list.click();
				break;
			}
		}
	}
	
	public void enterStartDate(String fromDate)
	{
		sendKeys(startDate, fromDate);
	}
	
	public void enterEndDate(String toDate)
	{
		sendKeys(endDate, toDate);
	}
	
	public void enterAmcCost(String amcCost)
	{
		sendKeys(amcCostfield, amcCost);
	}
	
	public void clickSaveAndCompleteButton()
	{
		click(saveAndCompleteButton);
	}
	
}
