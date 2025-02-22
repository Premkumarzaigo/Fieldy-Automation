package com.Fieldy.TestRunner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Fieldy.TestBase.BaseClass;
import com.Fieldy.TestBase.Constants;
import com.Fieldy.TestBase.ObjectInstance;
import com.Fieldy.TestUtility.DriverUtils;
import com.Fieldy.TestUtility.ListenersUtils;

@Listeners(ListenersUtils.class)
public class FieldyRun extends BaseClass {

	DriverUtils helper;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		getDriver(Constants.chromeBrowser, Constants.incognito);
		System.out.println("Info : --> : WebBrowser has been launched successfully");

		DriverUtils.maximize();
		System.out.println("Info : --> : The window has been maximized successfully");

		DriverUtils.implicitWait(2);
		System.out.println("Info : --> : ImplictWait for all the WebElements Triggered successfully");

		DriverUtils.get(Constants.pageURL);
		System.out.println("Info : --> : URL has been Passed successfully");

		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("document.body.style.zoom='80%'");
	}

	@Test(priority = -2, groups = "pagedetails")
	public void printTitle() {
		String title = DriverUtils.getTitle();
		System.out.println("Info : --> : The title of the page : " + title);
		System.out.println("Info : --> : Identified the title of the page successfully");
	}

	@Test(priority = -1, groups = "pagedetails")
	public void printCurrentURL() {
		String currentURL = DriverUtils.getCurrentURL();
		System.out.println("Info : --> : The Current URL of the page : " + currentURL);
		System.out.println("Info : --> : Identified the URL of the page successfully");
	}

	@Test(priority = 0, groups = "login")
	public void validateLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			ObjectInstance.getLoginPageInstance().verifyLogin(Constants.technicianUserName,
					Constants.technicianPassword);
			System.out.println("Info : --> : UserName and Password Entered successfully");

			WebElement welcomePageMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[2]/div[1]/section/div[4]/div/div[1]/div/ol/li/div")));
			Assert.assertTrue(welcomePageMessage.isDisplayed());
			System.out.println("Info : --> : Login SuccessFully.....");
		}

		catch (TimeoutException e) {
			System.out.println("Info : --> : Login Failed....");
			System.out.println("Info : --> : Please Check Entered Username and Password Details.....");
			Assert.fail("Entered Details InCorrect");
		}

		catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("Unable to locate element....");
		}

	}

	@Test(priority = 1, groups = "clock", enabled = false)
	public void attendanceClockIn() throws InterruptedException {
		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("document.body.style.zoom='90%'");
		ObjectInstance.getDasdBoardPageInstance().getAttendanceModule();
		WebElement attendenceClockinOption = ObjectInstance.getDasdBoardPageInstance().getClockinOption();
		Assert.assertTrue(attendenceClockinOption.isDisplayed());
		String attendenceClockinOptionText = attendenceClockinOption.getText();
		System.out.println(attendenceClockinOptionText + " Button Displayed");
		Assert.assertSame(attendenceClockinOptionText, "Clock In");
		attendenceClockinOption.click();
		WebElement attendenceClockinMessage = ObjectInstance.getDasdBoardPageInstance().getClockinMessage();
		String attendenceClockInText = attendenceClockinMessage.getText();
		System.out.println(attendenceClockInText);
		Assert.assertSame(attendenceClockInText, "Clocked in successfully");
		Thread.sleep(5000);
	}

	@Test(priority = 2, groups = "clock", enabled = false)
	public void attendanceClockOut() {
		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("document.body.style.zoom='90%'");
		WebElement attendenceClockOutOption = ObjectInstance.getDasdBoardPageInstance().getClockOutOption();
		Assert.assertTrue(attendenceClockOutOption.isDisplayed());
		String attendenceClockOutOptionText = attendenceClockOutOption.getText();
		System.out.println(attendenceClockOutOptionText + " Button Displayed");
		Assert.assertSame(attendenceClockOutOptionText, "Clock Out");
		attendenceClockOutOption.click();
		WebElement attendenceClockOutMessage = ObjectInstance.getDasdBoardPageInstance().getClockOutMessage();
		String attendenceClockOutText = attendenceClockOutMessage.getText();
		System.out.println(attendenceClockOutText);
		Assert.assertSame(attendenceClockOutText, "Clocked out successfully");

	}

	@Test(priority = 4, dependsOnMethods = "validateLogin", groups = "editamc", enabled = false)
	public void editAMCForm() throws InterruptedException {
		ObjectInstance.getAMCFormPageInstance().editAMCForm(1, "6000");
	}

	@Test(priority = 3, dependsOnMethods = "validateLogin", groups = "createamc", enabled = false)
	public void createAMCForm() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ObjectInstance.getAMCFormPageInstance().createAMCForm("New amc", "Prem", "02-21-2025", "02-21-2025", "5000");
		try {
			WebElement welcomePageMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='tables']")));
			Assert.assertTrue(welcomePageMessage.isDisplayed());
			System.out.println("Info : --> : AMC Form Created SuccessFully.....");

		} catch (TimeoutException e) {
			System.out.println("Info : --> : AMC Form Creation Failed.....");
			System.out.println("Info : --> : Please Check entered mandatory Fields.....");
			Assert.fail("Entered Details InCorrect.....");
		}

		catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("Unable to locate element....");
		}
	}
	
	@Test(priority = 6, dependsOnMethods = "validateLogin", groups = "editasset")
	public void editAssetForm() throws InterruptedException {
		ObjectInstance.getAMCFormPageInstance().editAssetForm(1, "New asset edit");
	}
	
		@Test(priority=5, dependsOnMethods = "validateLogin", groups = "createasset", enabled = false)
		public void createAssetForm() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			ObjectInstance.getAMCFormPageInstance().createAssetForm("New asset", "Prem");
			
			try {
				WebElement welcomePageMessage = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='tables']")));
				Assert.assertTrue(welcomePageMessage.isDisplayed());
				System.out.println("Info : --> : Asset Form Created SuccessFully.....");

			} catch (TimeoutException e) {
				System.out.println("Info : --> : Asset Form Creation Failed.....");
				System.out.println("Info : --> : Please Check entered mandatory Fields.....");
				Assert.fail("Entered Details InCorrect.....");
			}

			catch (NoSuchElementException e) {
				e.printStackTrace();
				Assert.fail("Unable to locate element....");
	}
		}
	

	}
