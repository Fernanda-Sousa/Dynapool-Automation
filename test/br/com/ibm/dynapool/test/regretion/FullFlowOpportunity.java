package br.com.ibm.dynapool.test.regretion;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.pages.Login_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowOpportunity extends Test_Constructor {
	
	Login_Page login = new Login_Page();
		
	@Test(priority=1)
	public void executeLogin() throws IOException{
		
		login.setSelEngine(selEngine);
		
		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));
		
		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();
		
		login.setUserName(prop.readPropertiesFile("adminuser"));
		login.setUserPassword(prop.readPropertiesFile("adminpass"));
		login.setGDPRcheckbox(true);
		login.clickLoginButton();
		selEngine.waitForPageLoad();
		
		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Test Case Passed. Home Page loaded");
	}
 
}
