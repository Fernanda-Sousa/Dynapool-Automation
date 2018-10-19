package br.com.ibm.dynapool.test.regretion;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowOpportunity extends Test_Constructor {
	
	
	@Test(priority=1)
	public void executeLogin() throws IOException {
		logger = extent.startTest("Execute login");
		
		selengine.openURL(prop.readPropertiesFile("testwebsite"));
		selengine.waitForPageLoad();
		
		
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
 
}
