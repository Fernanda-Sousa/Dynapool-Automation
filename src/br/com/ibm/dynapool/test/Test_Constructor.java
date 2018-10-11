package br.com.ibm.dynapool.test;

import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.engine.Properties_Engine;

public class Test_Constructor {
	protected ExtentReports extent;
	protected ExtentTest logger;
	static Properties_Engine prop = new Properties_Engine();

	@BeforeTest
	public void startReport() throws IOException {

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);

		extent.addSystemInfo("Host Name", prop.readPropertiesFile("host"))
				.addSystemInfo("Environment", prop.readPropertiesFile("environment"))
				.addSystemInfo("User Name", prop.readPropertiesFile("tester"));
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {

		extent.flush();
		extent.close();
	}
}