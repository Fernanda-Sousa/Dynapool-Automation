/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 19-oct-2018

Last update date: 31-oct-2018
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
import br.com.ibm.dynapool.pages.dispatching.TaskEdit_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskView_Page;
import br.com.ibm.dynapool.pages.frames.StageApprovalsList_Page;
import br.com.ibm.dynapool.pages.request.OpportunityRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class TestFFO extends Test_Constructor {

	String id;

	Home_Page home = new Home_Page();
	OpportunityRequest_Page request = new OpportunityRequest_Page();
	OpportunityList_Page list = new OpportunityList_Page();
	OpportunityView_Page view = new OpportunityView_Page();
	OpportunityEdit_Page edit = new OpportunityEdit_Page();
	OpportunityFilter_Page filter = new OpportunityFilter_Page();
	TaskView_Page viewTask = new TaskView_Page();
	TaskEdit_Page editTask = new TaskEdit_Page();
	StageApprovalsList_Page stageFrm = new StageApprovalsList_Page();

	@BeforeTest
	private void openPage() {
		selEngine.sysOut("openPage");
		try {
			selEngine.openURL(prop.readPropertiesFile("testwebsite"));
			selEngine.waitForPageLoad();
			FileCSV = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_fullFlowOpportunity"));
		} catch (IOException e) {
			System.out.println("Error on openPage()" + e.getCause());
		}
	}

	@Test(priority = 0)
	public void executeLogin() throws IOException {
		selEngine.sysOut("executeLogin");
		logger = extent.startTest("Execute login");

		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));

		selEngine.login("dev");

		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Test Case Passed. Home Page loaded");
	}

// Request
	@Test(priority = 1)
	public void requestOpportunity() throws IOException {
		selEngine.sysOut("requestOpportunity");
		logger = extent.startTest("Request Opportunity");

		for (Csv_Constructor csv : FileCSV) {
			selEngine.waitForPageLoad();
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
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Opportunity Request was done correctly");
	}

	@Test(priority = 2)
	public void approveRequest() throws IOException {
		selEngine.sysOut("approveRequest");
		logger = extent.startTest("Approve Request Opportunity");

		selEngine.changeUser("admin");

		for (Csv_Constructor csv : FileCSV) {
			selEngine.waitForPageLoad();
			home.clickDispatchOpportunity();
			selEngine.waitForPageLoad();
			
			list.doubleClickIdFilter();
			list.clickFirstItemLink();
			selEngine.waitForPageLoad();
			
			id = view.getId();
			view.clickEditTab();

			selEngine.waitForPageLoad();
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
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved. ID: " + id));
		logger.log(LogStatus.PASS, "The Request Approval was done correctly");
	}

// SOP Definition
	@Test(priority = 3)
	public void startSOPDefinition() {
		selEngine.sysOut("startSOPDefinition");
		logger = extent.startTest("Start SOP Defination");

		selEngine.waitForPageLoad();
		try {
			selEngine.changeUser("dev");
		} catch (IOException e) {
			System.out.println("Error on selEngine.changeUser(\"dev\");" + e.getCause());
			e.printStackTrace();
		}

		for (Csv_Constructor csv : FileCSV) {
			selEngine.waitForPageLoad();
			home.clickDispatchOpportunity();

			selEngine.waitForPageLoad();
			list.clickMagnifierFilter();
			selEngine.waitForPageLoad();
			filter.setId(id);
			filter.clickApplyButton();
			selEngine.waitForPageLoad();

			list.clickFirstItemLink();

			selEngine.waitForPageLoad();
			view.clickFirstChildLink();
			selEngine.waitForPageLoad();
			viewTask.setDiscussion(csv.getDiscussion());
			viewTask.clickStartButton();
			
			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Task was start correctly");
	}

	@Test(priority = 4)
	public void createSOP() throws IOException {
		selEngine.sysOut("createSOP");
		logger = extent.startTest("Create a SOP");

		try {
			for (Csv_Constructor csv : FileCSV) {
				selEngine.waitForPageLoad();
				viewTask.setLinkSOP(csv.getSOPLink());
				viewTask.setCurrentEffort(csv.getCurrentEffort());
				viewTask.setPercentageCompleted(csv.getPercentageCompleted());
				viewTask.setDiscussion(csv.getDiscussion());

				viewTask.clickUpdateButton();
				selEngine.waitForPageLoad();
			}

		} catch (Exception e) {
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "The Task wasn't start correctly: " + e);
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Task was start correctly");
	}

	@Test(priority = 5)
	public void OnHoldProcess() throws IOException {
		selEngine.sysOut("OnHoldProcess");

		onHold();
	}

	@Test(priority = 6)
	public void ExtensionProcess() throws IOException {
		selEngine.sysOut("ExtensionProcess");

		extension();
	}

	@Test(priority = 7)
	public void ApproveSOP() throws IOException {
		selEngine.sysOut("ApproveSOP");
		logger = extent.startTest("Approve SOP");

		selEngine.waitForPageLoad();
		selEngine.changeUser("qatest");

		for (Csv_Constructor csv : FileCSV) {
			selEngine.waitForPageLoad();
			home.clickStageApprovalsFrame();
			stageFrm.doubleClickIdFilter();
			stageFrm.clickFirstItemFilter();

			viewTask.clickEditTab();

			editTask.clickSOPApprovedYes();

			editTask.clickSaveButton();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The SOP link was approved correctly");
	}

	@Test(priority = 8)
	public void ResolveSOP() throws IOException {
		selEngine.sysOut("ResolveSOP");
		logger = extent.startTest("Resolve SOP");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();
		
		for (Csv_Constructor csv : FileCSV) {
			home.clickDispatchOpportunity();

			selEngine.waitForPageLoad();
			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();

			list.clickFirstItemLink();

			selEngine.waitForPageLoad();
			view.clickFirstChildLink();

			viewTask.setDiscussion(csv.getDiscussion());
			viewTask.clickResolveButton();

			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The SOP was resolved correctly");
	}

// Implementation
	@Test(priority = 9)
	public void startImplementation() throws IOException {
		selEngine.sysOut("startImplementation");
		logger = extent.startTest("Start Implementation");

		for (Csv_Constructor csv : FileCSV) {
			selEngine.waitForPageLoad();
			viewTask.clickOpenOpportunity();
			view.clickSecondChildLink();

			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickStartButton();

			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Implementation was started correctly");
	}

	@Test(priority = 10)
	public void resolveImplementation() throws IOException {
		selEngine.sysOut("resolveImplementation");
		logger = extent.startTest("Resolve Implementation");

		for (Csv_Constructor csv : FileCSV) {
			selEngine.waitForPageLoad();
			viewTask.clickOpenOpportunity();
			view.clickSecondChildLink();

			viewTask.setCurrentEffort(csv.getCurrentEffort());
			viewTask.setPercentageCompleted(csv.getPercentageCompleted());
			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickResolveButton();
			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Implementation was resolved correctly");
	}

// QA Review
	@Test(priority = 11)
	public void startQAReview() throws IOException {
		selEngine.sysOut("startQAReview");
		logger = extent.startTest("Start QAReview");

		selEngine.changeUser("qatest");
		selEngine.waitForPageLoad();
		
		for (Csv_Constructor csv : FileCSV) {
			home.clickDispatchOpportunity();
			selEngine.waitForPageLoad();

			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();
			selEngine.waitForPageLoad();

			list.clickFirstItemLink();
			selEngine.waitForPageLoad();

			view.clickThirdChildLink();

			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickStartButton();
			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The QA Review was started correctly");
	}

	@Test(priority = 12)
	public void resolveQAReview() throws IOException {
		selEngine.sysOut("resolveQAReview");
		logger = extent.startTest("Resolve QAReview");

		for (Csv_Constructor csv : FileCSV) {
			selEngine.waitForPageLoad();
			viewTask.setCurrentEffort(csv.getCurrentEffort());
			viewTask.setPercentageCompleted(csv.getPercentageCompleted());
			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickResolveButton();
			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The QA Review was resolveed correctly");
	}

// QA Tests	
	@Test(priority = 13)
	public void skipQATests() throws IOException {
		selEngine.sysOut("skipQATests");
		logger = extent.startTest("Skip QA Tests");

		for (Csv_Constructor csv : FileCSV) {
			viewTask.clickOpenOpportunity();
			view.clickFourthChildLnk();

			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickSkipButton();
			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}
		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The QA Tests was skipped correctly");

	}

// Deployment
	@Test(priority = 14)
	public void startDeployment() throws IOException {
		selEngine.sysOut("startDeployment");
		logger = extent.startTest("Start Deployment");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();
		
		for (Csv_Constructor csv : FileCSV) {
			home.clickDispatchOpportunity();
			selEngine.waitForPageLoad();

			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();
			selEngine.waitForPageLoad();

			list.clickFirstItemLink();
			selEngine.waitForPageLoad();

			view.clickFifthChildLink();
			selEngine.waitForPageLoad();

			viewTask.setDiscussion(csv.getDiscussion());
			viewTask.clickStartButton();

			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Deployment was started correctly");
	}

	@Test(priority = 15)
	public void approveDeployment() throws IOException {
		selEngine.sysOut("approveDeploymen");
		logger = extent.startTest("Approve Deployment");

		selEngine.changeUser("qatest");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSV) {
			home.clickDispatchOpportunity();
			selEngine.waitForPageLoad();

			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();
			selEngine.waitForPageLoad();

			list.clickFirstItemLink();
			selEngine.waitForPageLoad();

			view.clickFifthChildLink();
			selEngine.waitForPageLoad();

			viewTask.clickEditTab();
			selEngine.waitForPageLoad();
			editTask.clickDeploymentApprovedYes();
			editTask.clickSaveButton();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Deployment was started correctly");
	}

	@Test(priority = 16)
	public void resolveDeployment() throws IOException {
		selEngine.sysOut("resolveDeployment");
		logger = extent.startTest("Resolve Deployment");

		selEngine.waitForPageLoad();
		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();
		
		for (Csv_Constructor csv : FileCSV) {
			home.clickDispatchOpportunity();
			selEngine.waitForPageLoad();

			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();
			selEngine.waitForPageLoad();

			list.clickFirstItemLink();
			selEngine.waitForPageLoad();

			view.clickFifthChildLink();
			selEngine.waitForPageLoad();

			viewTask.setCurrentEffort(csv.getCurrentEffort());
			viewTask.setPercentageCompleted(csv.getPercentageCompleted());
			viewTask.setDiscussion(csv.getDiscussion());
			viewTask.clickResolveButton();

			selEngine.alertClick();
			selEngine.waitForPageLoad();
		}

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Deployment was resolved correctly");
	}
}
