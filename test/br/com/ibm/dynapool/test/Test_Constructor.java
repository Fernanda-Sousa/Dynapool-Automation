package br.com.ibm.dynapool.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.csv.Csv_Constructor;
import br.com.ibm.dynapool.engine.Csv_Engine;
import br.com.ibm.dynapool.engine.Properties_Engine;
import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.dispatching.TaskView_Page;
import br.com.ibm.dynapool.pages.dispatching.exception.OnHold_Page;

public class Test_Constructor {
	protected ExtentReports extent;
	protected ExtentTest logger;
	protected Properties_Engine prop = new Properties_Engine();
	protected Selenium_Engine selEngine = new Selenium_Engine();
	
	OnHold_Page onHold = new OnHold_Page();
	TaskView_Page taskView = new TaskView_Page();

	@BeforeTest
	public void startReport() throws IOException {

		selEngine.createDriver();
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);

		extent.addSystemInfo("Host Name", prop.readPropertiesFile("host"))
				.addSystemInfo("Environment", prop.readPropertiesFile("environment"))
				.addSystemInfo("User Name", prop.readPropertiesFile("tester"));
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

//	@AfterMethod
//	public void getResult(ITestResult result) {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
//			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
//		}
//		extent.endTest(logger);
//	}
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		String screenshotPath = getScreenshot(result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			try {
				logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			} catch (Exception e) {

				selEngine.sysOut("Error on get screenshot: " + e);
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			logger.log(LogStatus.SKIP, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		}
	}

	@AfterTest
	public void endReport() {
		extent.flush();
//		extent.close();

		selEngine.shutdownDriver();
	}

	public String getScreenshot(String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) selEngine.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	// On Hold
	public void executeOnHold() throws IOException {
		putOnHold();
	}
	
	public void putOnHold() throws IOException {
		
		logger = extent.startTest("On hold");

		// Read CSV
		logger.log(LogStatus.INFO, "Reading from Spreadsheet: " + prop.readPropertiesFile("csv_onHold"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Hold = new LinkedList<>();
//		logger.log(LogStatus.INFO, "Test found: " + Req.size() + " rows into file test");// is not working

		Hold = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_onHold"));

		// Hold
		for (Csv_Constructor csv : Hold) {

			taskView.clickOnHoldButton();

			onHold.setAditionalEmail(csv.getHoldAditionalEmail());
			onHold.setCategory(csv.getHoldCategory());
			onHold.setJustification(csv.getHoldJustification());
			onHold.setAction(csv.getHoldAction());
			onHold.clickExternalDependencyYes();

			onHold.clickSaveButton();

			selEngine.alertClick();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The task was put on hold correctly");
	}
}