package br.com.ibm.dynapool.test.regretion;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.test.Test_Constructor;

public class SampleTest extends Test_Constructor{
		
	@Test(priority=1)
	public void passTest(){
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		selengine.openURL("https:\\www.facebook.com.br");
		selengine.waitForPageLoad();
		
	}
	
	@Test(priority=2)
	public void failTest(){
		logger = extent.startTest("failTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}
	
	@Test(priority=3)
	public void skipTest(){
		logger = extent.startTest("skipTest");
		logger.log(LogStatus.SKIP, "PQ EU QUERO");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	
}