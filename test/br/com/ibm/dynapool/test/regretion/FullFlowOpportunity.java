/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 19-oct-2018

Last update date: 24-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.test.regretion;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.csv.Csv_Constructor;
import br.com.ibm.dynapool.engine.Csv_Engine;
import br.com.ibm.dynapool.pages.Home_Page;
import br.com.ibm.dynapool.pages.Login_Page;
import br.com.ibm.dynapool.pages.dispatching.OpportunityEdit_Page;
import br.com.ibm.dynapool.pages.dispatching.OpportunityList_Page;
import br.com.ibm.dynapool.pages.dispatching.OpportunityView_Page;
import br.com.ibm.dynapool.pages.request.OpportunityRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowOpportunity extends Test_Constructor {

	int id;
	
	Login_Page login = new Login_Page();
	Home_Page home = new Home_Page();
	OpportunityRequest_Page request = new OpportunityRequest_Page();
	OpportunityList_Page list = new OpportunityList_Page();
	OpportunityView_Page view = new OpportunityView_Page();
	OpportunityEdit_Page edit = new OpportunityEdit_Page();

	///////////////////////////////////////////////////////////////////////////////////////// TODO
	///////////////////////////////////////////////////////////////////////////////////////// verify
	///////////////////////////////////////////////////////////////////////////////////////// how
	///////////////////////////////////////////////////////////////////////////////////////// to
	///////////////////////////////////////////////////////////////////////////////////////// use
	///////////////////////////////////////////////////////////////////////////////////////// login
	///////////////////////////////////////////////////////////////////////////////////////// (on
	///////////////////////////////////////////////////////////////////////////////////////// test
	///////////////////////////////////////////////////////////////////////////////////////// page
	///////////////////////////////////////////////////////////////////////////////////////// or
	///////////////////////////////////////////////////////////////////////////////////////// engine)
	@Test(priority = 0)
	public void executeLogin() throws IOException {
		// Configuration
		login.setSelEngine(selEngine);

		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));

		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();

		// Login
		login.setUserName(prop.readPropertiesFile("adminuser"));
		login.setUserPassword(prop.readPropertiesFile("adminuser"));
		login.setGDPRcheckbox(true);
		login.clickLoginButton();
		selEngine.waitForPageLoad();

		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Test Case Passed. Home Page loaded");
	}

	@Test(priority = 1) // dev
	public void requestOpportunity() throws IOException {
		logger = extent.startTest("Request Opportunity");

		// Read CSV
		logger.log(LogStatus.INFO, "Reading from Spreadsheet: " + prop.readPropertiesFile("csv_requestOpportunity"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Req = new LinkedList<>();
//		logger.log(LogStatus.INFO, "Test found: " + Req.size() + " rows into file test");// is not working

		Req = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_requestOpportunity"));

		// Request
		for (Csv_Constructor csv : Req) {
			home.clickRequestOpportunity();

			request.setCountry(csv.getTargetCountry());
			request.setAccount(csv.getTargetAccount());
			request.setEnvironment(csv.getEnvironment());
			request.setPriority(csv.getPriority());
			request.setSummary(csv.getSummary());
			request.setDescription(csv.getDescription());
			request.setSME_ClientContact(csv.getSME_ClientContact());
			request.setAutomataCategory(csv.getAutomataCategory());
			request.setAlert_ServerCount(csv.getAlert_ServerCount());
			request.setExpectedSavings(csv.getExpectedSavings());
			request.setcostsAvoidedTxt(csv.getCostsAvoided());
			request.clickSaveButton();

		}
		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Opportunity Request was done correctly");
	}

	@Test(priority = 2) // adm
	public void approveRequest() throws IOException {
		logger = extent.startTest("Approve Request Opportunity");

		// Read CSV
		logger.log(LogStatus.INFO, "Reading from Spreadsheet: " + prop.readPropertiesFile("approveRequestOpportunity"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Appr = new LinkedList<>();
//		logger.log(LogStatus.INFO, "Test found: " + Req.size() + " rows into file test");// is not working

		Appr = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("approveRequestOpportunity"));

		// Approve
		for (Csv_Constructor csv : Appr) {
			home.clickDispatchOpportunity();

			list.doubleClickIdFilter();
			list.clickFirstItemLink();

			id = view.getIntegerId();
			view.clickEditTab();

			edit.setSquad(csv.getSquad());
			edit.setOwner(csv.getOwner());
			edit.setComplexity(csv.getComplexity());
			edit.clickFormApprovedYes();
			edit.setFormAppNotes(csv.getFormAppNotes());
			edit.clickBusinessApprovedYes();
			edit.setBusinessAppNotes(csv.getBusinessAppNotes());
			edit.clickTechnicalApprovedYes();
			edit.setTechnicalAppNotes(csv.getTechnicalAppNotes());
			edit.clickSaveButton();
		}
		/////////////////////////////////////////////////////////////////////////////////////////not working
		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved. ID: " + String.valueOf(id));
		logger.log(LogStatus.PASS, "The Request Approval was done correctly");

	}
}
