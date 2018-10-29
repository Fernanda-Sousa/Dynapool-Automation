/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 19-oct-2018

Last update date: 29-oct-2018
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.csv.Csv_Constructor;
import br.com.ibm.dynapool.engine.Csv_Engine;
import br.com.ibm.dynapool.pages.Home_Page;
import br.com.ibm.dynapool.pages.dispatching.OpportunityEdit_Page;
import br.com.ibm.dynapool.pages.dispatching.OpportunityFilter_Page;
import br.com.ibm.dynapool.pages.dispatching.OpportunityList_Page;
import br.com.ibm.dynapool.pages.dispatching.OpportunityView_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskView_Page;
import br.com.ibm.dynapool.pages.request.OpportunityRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowOpportunity extends Test_Constructor {

	String id;

	Home_Page home = new Home_Page();
	OpportunityRequest_Page request = new OpportunityRequest_Page();
	OpportunityList_Page list = new OpportunityList_Page();
	OpportunityView_Page view = new OpportunityView_Page();
	OpportunityEdit_Page edit = new OpportunityEdit_Page();
	OpportunityFilter_Page filter = new OpportunityFilter_Page();
	TaskView_Page viewTask = new TaskView_Page();

	@BeforeTest
	private void openPage() throws IOException {
		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();
	}

	@Test(priority = 0)
	public void executeLogin() throws IOException {
		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));

		selEngine.login("dev");

		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Test Case Passed. Home Page loaded");
	}

	@Test(priority = 1)
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

		selEngine.changeUser("admin");

		logger = extent.startTest("Approve Request Opportunity");

		// Read CSV
		logger.log(LogStatus.INFO,
				"Reading from Spreadsheet: " + prop.readPropertiesFile("csv_approveRequestOpportunity"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Appr = new LinkedList<>();
//		logger.log(LogStatus.INFO, "Test found: " + Req.size() + " rows into file test");// is not working

		Appr = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_approveRequestOpportunity"));

		// Approve
		for (Csv_Constructor csv : Appr) {
			home.clickDispatchOpportunity();

			list.doubleClickIdFilter();
			list.clickFirstItemLink();

			id = view.getId();
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

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved. ID: " + id));
		logger.log(LogStatus.PASS, "The Request Approval was done correctly");
	}

	@Test(priority = 3)
	public void startSOPDefinition() throws IOException {

		selEngine.changeUser("dev");

		logger = extent.startTest("Start SOP Defination");

		// Read CSV
		logger.log(LogStatus.INFO,
				"Reading from Spreadsheet: " + prop.readPropertiesFile("csv_opportunitySOPDefinition"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Start = new LinkedList<>();
//		logger.log(LogStatus.INFO, "Test found: " + Req.size() + " rows into file test");// is not working

		Start = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_opportunitySOPDefinition"));

		// Approve
		for (Csv_Constructor csv : Start) {
			home.clickDispatchOpportunity();

			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();

			list.clickFirstItemLink();
			
			selEngine.waitForPageLoad();
			view.clickFirstChildLink();
			viewTask.setDiscussion(csv.getDiscussion());
			viewTask.clickStartButton();
			
			selEngine.alertClick();		
		}
		
		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Task was start correctly");
	}
	////////////////////////////////////////////////////////////////////////////////////////////Incompleto
	@Test(priority = 4)
	public void createSOP() throws IOException {
		
		logger = extent.startTest("Create a SOP");

		// Read CSV
		logger.log(LogStatus.INFO,
				"Reading from Spreadsheet: " + prop.readPropertiesFile("csv_opportunitySOPDefinition"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Link = new LinkedList<>();
//		logger.log(LogStatus.INFO, "Test found: " + Req.size() + " rows into file test");// is not working

		Link = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_opportunitySOPDefinition"));

		// Approve
		for (Csv_Constructor csv : Link) {
			view.setLinkSOP(csv.getSOPLink());
			view.setCurrentEffort(csv.getCurrentEffort());
			view.setPercentageCompleted(csv.getPercentageCompleted());
		}
		
		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Task was start correctly");
	}
	
	@Test(priority = 5)
	public void OnHoldProcess() throws IOException {
		onHold();
	}
	
	@Test(priority = 6)
	public void ExtensionProcess() throws IOException {
		extension();
	}
	
	
}
