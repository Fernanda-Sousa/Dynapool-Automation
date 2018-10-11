/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 10-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.test;

import java.io.File;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReports{
	ExtentReports extent;
	ExtentTest logger;
	
	
	@BeforeTest
	public void startReport(){
	
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		extent
                .addSystemInfo("Host Name", "XXXXXXXXXXXX") // Talvez pegar do properties
                .addSystemInfo("Environment", "XXXXXXXXX")
                .addSystemInfo("User Name", "XXXXXXXX");
               
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
		
	@Test
	public void passTest(){
		logger = extent.startTest("passTest");
		AssertJUnit.assertTrue(true);
		//To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void failTest(){
		logger = extent.startTest("failTest");
		AssertJUnit.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}
	
	@Test
	public void skipTest(){
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result){ // Necessario adicionar Screenshot
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		extent.endTest(logger);
	}
	@AfterTest
	public void endReport(){
                extent.flush();
                extent.close();
    }
}