package br.com.ibm.dynapool.test.unit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.test.Test_Constructor;

public class SampleTest extends Test_Constructor{
	
	Selenium_Engine selengine = new Selenium_Engine();
	
	@Test
	public void passTest(){
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		try {
			selengine.createDriver();
			selengine.openURL("https:\\www.google.com.br");
			selengine.waitForPageLoad();
			selengine.driver().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void failTest(){
		logger = extent.startTest("failTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}
	
	@Test
	public void skipTest(){
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	
}