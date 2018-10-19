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
	public void executeLogin() throws IOException {

		login.setSelEngine(selEngine);
		
		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));
		
		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();
		
		login.setUserName(prop.readPropertiesFile("devuser"));
		login.setUserPassword(prop.readPropertiesFile("devpass"));
		login.setGDPRcheckbox(true);
		login.clickLoginButton();
		
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is:" + this.getClass().getName());
	}
 
}
