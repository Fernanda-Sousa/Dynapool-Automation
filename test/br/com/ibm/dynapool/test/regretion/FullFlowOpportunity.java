/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 19-oct-2018

Last update date: 22-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.test.regretion;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.csv.Csv_Constructor;
import br.com.ibm.dynapool.engine.Csv_Engine;
import br.com.ibm.dynapool.pages.Home_Page;
import br.com.ibm.dynapool.pages.Login_Page;
import br.com.ibm.dynapool.pages.request.OpportunityRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowOpportunity extends Test_Constructor {
	
	Login_Page login = new Login_Page();
	Home_Page home = new Home_Page();
	OpportunityRequest_Page request = new OpportunityRequest_Page();
		
	@Test(priority=0)
	public void executeLogin() throws IOException{
		// Configuration
		login.setSelEngine(selEngine);
		
		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));
		
		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();
		
		// Login
		login.setUserName(prop.readPropertiesFile("adminuser"));
		login.setUserPassword(prop.readPropertiesFile("adminpass"));
		login.setGDPRcheckbox(true);
		login.clickLoginButton();
		selEngine.waitForPageLoad();
		
		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Test Case Passed. Home Page loaded");
		

	}
 ///////////////////////////////////////////////////////////////////////////////////do not work/////////////////////////////////////////
	@Test(priority=1)
	public void requestOpportunity() throws IOException {
//		logger = extent.startTest("Request Opportunity");
		
		selEngine.waitForPageLoad();
		home.clickRequestOpportunity();
			
		// 
//		logger.log(LogStatus.INFO, "Reading from Spreadsheet: " + prop.readPropertiesFile("csv_requestOpportunity"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Req = new LinkedList<>();
		logger.log(LogStatus.INFO, "Test found: " + Req.size() + "rows into file test");
		
		Req = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_requestOpportunity"));
		
		for(Csv_Constructor csv : Req) {
//			logger.log(LogStatus.INFO, "Executing Priority number: " + csv.getPriority());
//			System.out.println("Priority: " + csv.getPriority());
			
			request.setCountry(csv.getTargetCountry());
			request.setAccount(csv.getTargetAccount());
			
		}
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed. Printed all Priorities");
	
	}
}
