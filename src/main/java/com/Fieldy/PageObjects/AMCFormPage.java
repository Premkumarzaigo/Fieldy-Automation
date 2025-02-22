package com.Fieldy.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Fieldy.TestUtility.DriverUtils;

public class AMCFormPage extends DriverUtils{


	By tableList=By.xpath("//table[@class='tables']/tbody/tr");

	By chooseServiceField=By.xpath("//input[starts-with(@id,'inservice')][@maxlength='256']");

	By chooseServiceList=By.xpath("//div[starts-with(@id,'servicesdropdownlist')]/div[1]/div[starts-with(@id,'drop')]");

	By startDate=By.xpath("//input[@id='schedule_from_date']");

	By endDate=By.xpath("//input[@id='schedule_end_date']");
	
	By amcCostfield=By.xpath("//input[@id='value']");
	
	By menuArrow=By.xpath("(//button[@data-coreui-toggle='unfoldable'])[1]");
	
	By jobsMenuArrow=By.xpath("//li[@id='jobs']/div/i");
	
	By amcMenu=By.xpath("//a[@data-n-linkto='amc_job_listing']"); 
	
	By updateButton=By.xpath("//button[@id='amcsubmit']");
	
	By createButton=By.xpath("/html/body/div[2]/div[1]/section/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]");
	
	By titleName=By.xpath("//input[@name='tilte']");//value wrong
	
	By contactNameField=By.xpath("//input[@name='id_customer_group'][@maxlength='256']");

	By contactNameList=By.xpath("//div[@id='contactdropdownlist']/div[1]/div[starts-with(@id,'drop')]");
	
	By createAMCButton=By.xpath("//button[@id='amcsubmit']");
	
	By assetMenu=By.xpath("//li[@id='assetlist']");
	
	By createButtonasset=By.xpath("//div[@id='activesubscription']/section/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]");
	
	By assetName=By.xpath("//input[@id='title']");
	
	By contactNameAsset=By.xpath("//input[@id='id_customer_group']");
	
	By assetcontactNameList=By.xpath("//div[@id='dropid-63182']");
	
	By createAssetButton=By.xpath("//button[@id='amcsubmit']");
	
	By updateButton1=By.xpath("//button[@id='amcsubmit']");
	
	public void clickassetMenu()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(menuArrow)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(jobsMenuArrow)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(assetMenu)).click();
		
	}
	
public void clickcreateButtonasset() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(createButtonasset)).click();
		
	}

public void enterAssetname(String assetName)
{
	sendKeys(titleName, assetName);
}

public void chooseContactNameasset(String contactNameasset)
{
	sendKeys(contactNameField, contactNameasset);

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
		if(list.getText().startsWith(contactNameasset))
		{
			list.click();
			break;
		}
	}
}
public void clickAssetMenuAgain()
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(assetMenu)).click();
}


public void createAssetForm(String assetName,String contactNameasset) 
{
	clickassetMenu();
	
	clickCreateButton();
	
	enterAssetname(assetName);

	chooseContactNameasset(contactNameasset);

	clickCreateAssetButton();
}

public void clickCreateAssetButton()
{
	click(createAssetButton);
}

public void editAssetForm(int listNumber, String assetname)
{
	
	clickassetMenu();
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	clickAssetMenuAgain();
	clickListOnAMCFormTable(listNumber);
	
	//clickListOnAssetFormTable(listNumber);
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//enterStartDate(startDate);
	
	//enterEndDate(endDate);

	enterAssetname(assetname);

	clickUpdateButton();
}

	public void editAMCForm(int listNumber, String amcCost)
	{
		
		clickAMCMenu();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clickAMCMenuAgain();
		
		clickListOnAMCFormTable(listNumber);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//enterStartDate(startDate);
		
		//enterEndDate(endDate);

		enterAmcCost(amcCost);

		clickUpdateButton();
	}
	
	public void clickAssetMenu()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(menuArrow)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(jobsMenuArrow)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(assetMenu)).click();
		
	}

	public void clickAMCMenu()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(menuArrow)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(jobsMenuArrow)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(amcMenu)).click();
		
	}
	
	public void clickAMCMenuAgain()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(amcMenu)).click();
	}
	
	public void createAMCForm(String title,String contactName,String startDate,String endDate,String amcCost) 
	{
		clickAMCMenu();
		
		clickCreateButton();
		
		enterTitle(title);

		chooseContactName(contactName);
		
		enterStartDate(startDate);
		
		enterEndDate(endDate);
		
		enterAmcCost(amcCost);

		clickCreateAMCButton();
	}
	
	public void clickCreateButton() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(createButton)).click();
		
	}

	public void enterTitle(String title)
	{
		sendKeys(titleName, title);
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
		clear(amcCostfield);
		sendKeys(amcCostfield, amcCost);
	}
	
	public void clickCreateAMCButton()
	{
		click(createAMCButton);
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

	public void clickListOnAMCFormTable(int listNumber)
	{
		List<WebElement> table = driver.findElements(tableList);
		int tableSize = table.size();
		for(int i=1;i<=tableSize;i++)
		{
			if(i==listNumber)
			{
				driver.findElement(By.xpath("//table[@class='tables']/tbody/tr["+i+"]/td/div/div/i")).click();
				driver.findElement(By.xpath("(//table[@class='tables']/tbody/tr["+i+"]/td[1]/div/div[2]/ul/li[1])[1]")).click();
				break;
			}
		}

	}

	public void clickUpdateButton()
	{
		click(updateButton);
	}

}
