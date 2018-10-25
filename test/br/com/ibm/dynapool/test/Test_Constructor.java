package br.com.ibm.dynapool.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.engine.Properties_Engine;
import br.com.ibm.dynapool.engine.Selenium_Engine;

public class Test_Constructor {
	protected ExtentReports extent;
	protected ExtentTest logger;
	protected Properties_Engine prop = new Properties_Engine();
	protected Selenium_Engine selEngine = new Selenium_Engine();
	
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
		}else if(result.getStatus() == ITestResult.SUCCESS) {
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

}