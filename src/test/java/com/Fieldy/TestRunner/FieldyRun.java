package com.Fieldy.TestRunner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Fieldy.PageObjects.AMCFormPage;
import com.Fieldy.PageObjects.DashBoardPage;
import com.Fieldy.PageObjects.LoginPage;
import com.Fieldy.TestBase.BaseClass;
import com.Fieldy.TestBase.Constants;
import com.Fieldy.TestUtility.DriverUtils;
import com.Fieldy.TestUtility.ListenersUtils;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

@Listeners(ListenersUtils.class)
public class FieldyRun extends BaseClass{

	DriverUtils helper;

	LoginPage loginPage;

	DashBoardPage dashBoardPage;

	AMCFormPage amcFormPage;

	@BeforeClass
	public void beforeClass()
	{
		getDriver(Constants.chromeBrowser, Constants.incognito);
		System.out.println("Info : --> : WebBrowser has been launched successfully");

		DriverUtils.maximize();
		System.out.println("Info : --> : The window has been maximized successfully");

		DriverUtils.implicitWait(2);
		System.out.println("Info : --> : ImplictWait for all the WebElements Triggered successfully");

		DriverUtils.get(Constants.pageURL);
		System.out.println("Info : --> : URL has been Passed successfully");


		loginPage=new LoginPage();
		dashBoardPage=new DashBoardPage();
		amcFormPage=new AMCFormPage();
	}

	public void printTitle()
	{
		String title = DriverUtils.getTitle();
		System.out.println("Info : --> : The title of the page : " +title);
		System.out.println("Info : --> : Identified the title of the page successfully");
	}

	public void printCurrentURL()
	{
		String currentURL = DriverUtils.getCurrentURL();
		System.out.println("Info : --> : The Current URL of the page : " +currentURL);
		System.out.println("Info : --> : Identified the URL of the page successfully");
	}

	@Test(priority = 0)
	public void validateLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try
		{
			loginPage.verifyLogin(Constants.userName, Constants.password);
			System.out.println("Info : --> : UserName and Password Entered successfully");

			WebElement welcomePageMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/section/div[4]/div/div[1]/div/ol/li/div")));
			Assert.assertTrue(welcomePageMessage.isDisplayed());
			System.out.println("Info : --> : Login SuccessFully.....");
		}

		catch(TimeoutException e)
		{
			System.out.println("Info : --> : Login Failed....");
			System.out.println("Info : --> : Please Check Entered Username and Password Details.....");
			Assert.fail("Entered Details InCorrect");
		}

		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			Assert.fail("Unable to locate element....");
		}


	}
	
	@Test(priority = 1,dependsOnMethods = "validateLogin",enabled = false)
	public void editAMCForm() throws InterruptedException
	{
		Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		dashBoardPage.clickAMCModule();
		amcFormPage.editAMCForm(7,"03-08-2024","03-08-2024","3.5");
	}

	@Test(priority = 1,dependsOnMethods = "validateLogin")
	public void formAMCCreation() throws InterruptedException
	{
		Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		dashBoardPage.clickAMCModule();
		try
		{
			amcFormPage.createAMCForm("Sa","Te","20-07-2024","20-07-2024","1.5");
			WebElement welcomePageMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='tables']")));
			Assert.assertTrue(welcomePageMessage.isDisplayed());

			System.out.println("Info : --> : AMC Form Created SuccessFully.....");
			
			
		}
		catch(TimeoutException e)
		{
			System.out.println("Info : --> : AMC Form Creation Failed.....");
			System.out.println("Info : --> : Please Check entered mandatory Fields.....");
			Assert.fail("Entered Details InCorrect.....");
		}

		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			Assert.fail("Unable to locate element....");
		}
	}
}

Hello
