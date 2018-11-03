/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 15-oct-2018

Last update date: 30-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

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
import br.com.ibm.dynapool.pages.Home_Page;
import br.com.ibm.dynapool.pages.dispatching.ExtensionFilter_Page;
import br.com.ibm.dynapool.pages.dispatching.ExtensionList_Page;
import br.com.ibm.dynapool.pages.dispatching.ExtensionView_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskView_Page;
import br.com.ibm.dynapool.pages.dispatching.exception.ExtensionRequest_Page;
import br.com.ibm.dynapool.pages.dispatching.exception.OnHold_Page;

public class Test_Constructor {
	protected ExtentReports extent;
	protected ExtentTest logger;
	protected Properties_Engine prop = new Properties_Engine();
	protected Selenium_Engine selEngine = new Selenium_Engine();

	OnHold_Page onHold = new OnHold_Page();
	TaskView_Page taskView = new TaskView_Page();
	ExtensionView_Page extView = new ExtensionView_Page();
	ExtensionRequest_Page extReq = new ExtensionRequest_Page();
	Home_Page home = new Home_Page();
	ExtensionList_Page extList = new ExtensionList_Page();
	ExtensionFilter_Page extFilter = new ExtensionFilter_Page();
		
	protected List<Csv_Constructor> FileCSVOpp = new LinkedList<>();
	protected List<Csv_Constructor> FileCSVMas = new LinkedList<>();
	protected List<Csv_Constructor> FileCSVHol = new LinkedList<>();
	protected List<Csv_Constructor> FileCSVExt = new LinkedList<>();
		
	String taskId;

	@BeforeTest
	public void startReport() {
		selEngine.createDriver();
		Csv_Engine csvEng = new Csv_Engine();
		FileCSVOpp = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_fullFlowOpportunity"));
		FileCSVMas = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_fullFlowOpportunity"));
		FileCSVHol = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_onHold"));
		FileCSVExt = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_extension"));
		
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
	public void getResult(ITestResult result){
	
		String screenshotPath = null;
		try {
			screenshotPath = getScreenshot(result.getName());
		} catch (Exception e1) {
			System.out.println(e1);
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			try {
				logger.log(LogStatus.INFO, logger.addScreenCapture(screenshotPath));
			} catch (Exception e) {

				selEngine.sysOut("Error on get screenshot: " + e);
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			logger.log(LogStatus.INFO, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.INFO, logger.addScreenCapture(screenshotPath));
		}
	}

	@AfterTest
	public void endReport() {
		extent.flush();
//		extent.close();

		selEngine.shutdownDriver();
	}

	public String getScreenshot(String screenshotName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) selEngine.driver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			System.out.println(e);
		}
		return destination;
	}

	// On Hold
	public void onHold() {

		logger = extent.startTest("On hold");

		for (Csv_Constructor csv : FileCSVHol) {
			// Put on hold
			taskView.clickOnHoldButton();

			onHold.setAditionalEmail(csv.getHoldAditionalEmail());
			onHold.setCategory(csv.getHoldCategory());
			onHold.setJustification(csv.getHoldJustification());
			onHold.setAction(csv.getHoldAction());
			onHold.clickExternalDependencyYes();

			onHold.clickSaveButton();

			selEngine.alertClick();

			// Resume
			taskView.clickResumeOnHoldButton();

			onHold.clickResumeButton();

			selEngine.alertClick();
			selEngine.waitForPageLoad();
			
			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The On hold process was executed correctly");
		}

		
		logger.log(LogStatus.PASS, "The On hold Test was done correctly");
	}

	// Extension
	public void extension(){
		logger = extent.startTest("Extension");

		for (Csv_Constructor csv : FileCSVExt) {
			// Request Extension
			taskId = taskView.getId();
			taskView.clickExtensionButton();
						
			extReq.setReason(csv.getExtensionReason());
			extReq.setSuggestedDate(csv.getExtensionSuggestedDate());
			selEngine.click(By.className("label"));			
			
			extReq.clickSaveButton();
			
			// Approve the extension
			selEngine.changeUser("disp");
			
			home.clickDispatchExtension();
			extList.clickMagnifierFilter();
			extFilter.setTaskId(taskId);
			extFilter.clickApply();
			
			extList.clickFirstItemLink();
			
			extView.setJustification(csv.getExtensionJustification());
			
			extView.clickApproveButton();
			
			selEngine.alertClick();
			
			selEngine.waitForPageLoad();
			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Extension process was done correctly");
		}
		
		logger.log(LogStatus.PASS, "The Extension Test was done correctly");
	}	
}