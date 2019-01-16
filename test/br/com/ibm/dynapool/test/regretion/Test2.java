/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 19-oct-2018

Last update date: 13-nov-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.test.regretion;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.csv.Csv_Constructor;
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

public class Test2 extends Test_Constructor {

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

	@Test(priority = 0)
	public void executeLogin() {
		selEngine.sysOut("openPage\n");
		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();

		selEngine.sysOut("executeLogin");
		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));

		selEngine.login("dev");

		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Home Page loaded");
	}

	@Test(priority = 1)
	public void requestOpportunity() {
		selEngine.sysOut("requestOpportunity\n");
		logger = extent.startTest("Request Opportunity");

		for (Csv_Constructor csv : FileCSVOpp) {
			
			System.out.println("Test"+ csv.getCountry());
			home.clickRequestOpportunity();
			selEngine.waitForPageLoad();

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

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Opportunity Request was done correctly");
		}

		logger.log(LogStatus.PASS, "The Opportunity Request test was executed correctly");
	}

	@Test(priority = 2)
	public void approveRequest() {
		selEngine.sysOut("approveRequest\n");
		logger = extent.startTest("Approve Request Opportunity");

		selEngine.changeUser("admin");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/opportunityList.jsp");
			selEngine.waitForPageLoad();

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
			selEngine.waitForPageLoad();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved. ID: " + id));
			logger.log(LogStatus.INFO, "The Request Approval was done correctly");
		}

		logger.log(LogStatus.PASS, "The Request Approval test was done correctly");
	}

	@Test(priority = 3)
	public void SOPStart() {
		selEngine.sysOut("startSOP\n");
		logger = extent.startTest("Start SOP Definition");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/opportunityList.jsp");
		selEngine.waitForPageLoad();

		list.clickMagnifierButton();
		selEngine.waitForPageLoad();
		filter.setId(id);
		filter.clickApplyButton();
		selEngine.waitForPageLoad();

		list.clickFirstItemLink();
		view.clickFirstChildLink();

		viewTask.setDiscussion(FileCSVOpp.get(0).getDiscussion());
		viewTask.clickStartButton();

		selEngine.alertClick();
		selEngine.waitForPageLoad();

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The SOP Start test was executed correctly");
	}

	@Test(priority = 4)
	public void createSOP() {
		selEngine.sysOut("createSOP\n");
		logger = extent.startTest("Create a SOP");

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.waitForPageLoad();
			viewTask.setLinkSOP(csv.getSOPLink());
//			selEngine.clearField(viewTask.getCurrentEffort());
			viewTask.setCurrentEffort(csv.getCurrentEffort());
			viewTask.setPercentageCompleted(csv.getPercentageCompleted());
			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickUpdateButton();
			selEngine.waitForPageLoad();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The SOP was created correctly");
		}

		logger.log(LogStatus.PASS, "The Create SOP Test executed correctly");
	}

	@Test(priority = 5)
	public void OnHoldProcess() {
		selEngine.sysOut("OnHoldProcess\n");

		onHold();
	}

	@Test(priority = 6)
	public void ExtensionProcess() {
		selEngine.sysOut("ExtensionProcess\n");

		extension();
	}

	@Test(priority = 7)
	public void ApproveSOP() {
		selEngine.sysOut("ApproveSOP\n");
		logger = extent.startTest("Approve SOP");

		selEngine.changeUser("qatest");
		selEngine.waitForPageLoad();

		home.clickStageApprovalsFrame();
		stageFrm.doubleClickIdFilter();
		stageFrm.clickFirstItemFilter();

		viewTask.clickEditTab();

		editTask.clickSOPApprovedYes();

		editTask.clickSaveButton();

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The SOP link was approved correctly");
	}

	@Test(priority = 8)
	public void ResolveSOP() {
		selEngine.sysOut("ResolveSOP\n");
		logger = extent.startTest("Resolve SOP");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/opportunityList.jsp");

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

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The SOP was resolved correctly");
		}

		logger.log(LogStatus.PASS, "The SOP Resolve test was executed correctly");
	}

// Implementation
	@Test(priority = 9)
	public void startImplementation() {
		selEngine.sysOut("startImplementation\n");
		logger = extent.startTest("Start Implementation");

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.waitForPageLoad();
			viewTask.clickOpenOpportunity();
			view.clickSecondChildLink();

			viewTask.setDiscussion(csv.getDiscussion());
			viewTask.clickStartButton();
			selEngine.alertClick();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Implementation was started correctly");
		}

		logger.log(LogStatus.PASS, "The Implementation Test was executed correctly");
	}

	@Test(priority = 10)
	public void resolveImplementation() {
		selEngine.sysOut("resolveImplementation\n");
		logger = extent.startTest("Resolve Implementation");

		for (Csv_Constructor csv : FileCSVOpp) {
			viewTask.clickOpenOpportunity();
			view.clickSecondChildLink();

			viewTask.setCurrentEffort(csv.getCurrentEffort());
			viewTask.setPercentageCompleted(csv.getPercentageCompleted());
			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickResolveButton();
			selEngine.alertClick();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Implementation was resolved correctly");
		}

		logger.log(LogStatus.PASS, "The Implementation Resolve test was executed correctly");
	}

// QA Review
	@Test(priority = 11)
	public void startQAReview() {
		selEngine.sysOut("startQAReview\n");
		logger = extent.startTest("Start QAReview");

		selEngine.changeUser("qatest");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/opportunityList.jsp");
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

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The QA Review was started correctly");
		}

		logger.log(LogStatus.PASS, "The QA Review start test was executed correctly");
	}

	@Test(priority = 12)
	public void resolveQAReview() {
		selEngine.sysOut("resolveQAReview\n");
		logger = extent.startTest("Resolve QAReview");

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.waitForPageLoad();
			viewTask.setCurrentEffort(csv.getCurrentEffort());
			viewTask.setPercentageCompleted(csv.getPercentageCompleted());
			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickResolveButton();
			selEngine.alertClick();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The QA Review was resolveed correctly");
		}

		logger.log(LogStatus.PASS, "The QA Review resolve test was executed correctly");
	}

// QA Tests	
	@Test(priority = 13)
	public void skipQATests() {
		selEngine.sysOut("skipQATests\n");
		logger = extent.startTest("Skip QA Tests");

		for (Csv_Constructor csv : FileCSVOpp) {
			viewTask.clickOpenOpportunity();
			view.clickFourthChildLnk();

			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickSkipButton();
			selEngine.alertClick();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The QA Tests was skipped correctly");
		}

		logger.log(LogStatus.PASS, "The QA Tests skip test was executed correctly");
	}

// Deployment
	@Test(priority = 14)
	public void startDeployment() {
		selEngine.sysOut("startDeployment\n");
		logger = extent.startTest("Start Deployment");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/opportunityList.jsp");
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

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Deployment was started correctly");
		}

		logger.log(LogStatus.PASS, "The Deployment start test was executed correctly");
	}

	@Test(priority = 15)
	public void approveDeployment() throws InterruptedException {
		selEngine.sysOut("approveDeploymen\n");
		logger = extent.startTest("Approve Deployment");

		selEngine.changeUser("qatest");
		selEngine.waitForPageLoad();

		selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/opportunityList.jsp");
		selEngine.waitForPageLoad();

		list.clickMagnifierFilter();
		filter.setId(id);
		filter.clickApplyButton();
		selEngine.waitForPageLoad();

		list.clickFirstItemLink();
		selEngine.waitForPageLoad();

		view.clickFifthChildLink();
		selEngine.waitForPageLoad();

		Thread.sleep(3000);
		viewTask.clickEditTab();
		selEngine.waitForPageLoad();

		editTask.clickDeploymentApprovedYes();
		selEngine.waitForPageLoad();
		editTask.clickSaveButton();

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Deployment was started correctly");
	}

	@Test(priority = 16)
	public void resolveDeployment() {
		selEngine.sysOut("resolveDeployment\n");
		logger = extent.startTest("Resolve Deployment");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVOpp) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/opportunityList.jsp");
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

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Deployment was resolved correctly");
		}

		logger.log(LogStatus.PASS, "The Deployment resolve test was executed correctly");
	}

	// Verifications
	@Test(priority = 17)
	public void verifyDate() {
		selEngine.sysOut("verifyDate\n");
		logger = extent.startTest("Verify Date");

		String closedDateLastChild = viewTask.getClosedDate();

		viewTask.clickOpenOpportunity();
		selEngine.waitForPageLoad();

		String approvedDateOpportunity = view.getApprovedDate();
		String closedDateOpportunity = view.getClosedDate();

		view.clickFirstChildLink();
		selEngine.waitForPageLoad();

		String createdDateFirstChild = viewTask.getCreatedDate();

		selEngine.sysOut("closed child: " + closedDateLastChild + "; closed master: " + closedDateOpportunity
				+ "; created child: " + createdDateFirstChild + "; created master: " + approvedDateOpportunity);

		Assert.assertEquals(approvedDateOpportunity, createdDateFirstChild);
		Assert.assertEquals(closedDateOpportunity, closedDateLastChild);

		logger.log(LogStatus.PASS, "The dates are the same");
	}

	@Test(priority = 18)
	public void verifyFill() {
		selEngine.sysOut("verifyFill\n");
		logger = extent.startTest("Verify Fill");
		
		viewTask.clickOpenOpportunity();
		try {
			view.compareId(id);
			view.compareRequester("Developer Test");
			view.compareSquad(FileCSVOpp.get(0).getSquad());
			view.compareOwner(FileCSVOpp.get(0).getOwner());
			view.compareCountry(FileCSVOpp.get(0).getTargetCountry());
			view.compareAccount(FileCSVOpp.get(0).getTargetAccount());
			view.compareEnvironment(FileCSVOpp.get(0).getEnvironment());
			view.comparePriority(FileCSVOpp.get(0).getPriority());
			view.compareSummary(FileCSVOpp.get(0).getSummary());
			view.compareDescription(FileCSVOpp.get(0).getDescription());
			view.compareAutomataCategory(FileCSVOpp.get(0).getAutomataCategory());
			view.compareAlert_ServerCount(FileCSVOpp.get(0).getAlert_ServerCount());
			view.compareExpectedSavings(FileCSVOpp.get(0).getExpectedSavings());
			view.compareCostsAvoided(FileCSVOpp.get(0).getCostsAvoided());
			view.compareComplexity(FileCSVOpp.get(0).getComplexity());
			view.compareStatus("Closed");
			view.compareCurrentStage("Deployment");
			
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");
		
		}catch (Exception x){
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Some field(s) was(were) filled correctly");
		}		
	}

	@Test(priority = 19)
	public void verifyFillSOPDefinition() {
		selEngine.sysOut("verifyFillSOPDefinition\n");
		logger = extent.startTest("Verify Fill SOP Definition");

		view.clickFirstChildLink();
		try {
			viewTask.compareOpportunityId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVOpp.get(0).getSquad());
			viewTask.compareOwner(FileCSVOpp.get(0).getOwner());
			viewTask.compareCountry(FileCSVOpp.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVOpp.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVOpp.get(0).getEnvironment());
			viewTask.compareStage("SOP Definition");
			viewTask.comparePriority(FileCSVOpp.get(0).getPriority());
			viewTask.compareComplexity(FileCSVOpp.get(0).getComplexity());
			viewTask.compareSummary(FileCSVOpp.get(0).getSummary());
			viewTask.compareDescription(FileCSVOpp.get(0).getDescription());
			viewTask.compareLinkToSOP(FileCSVOpp.get(0).getSOPLink());
			viewTask.compareCurrentStatus("Closed");
			viewTask.comparePreviousStatus("In Progress");

			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");

		} catch (Exception x) {
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Some field(s) was(were) filled correctly");
		}
	}
	
	@Test(priority = 20)
	public void verifyFillImplementation() {
		selEngine.sysOut("verifyFillImplementation\n");
		logger = extent.startTest("Verify Fill Implementation");

		viewTask.clickOpenOpportunity();
		
		view.clickSecondChildLink();
		try {
			viewTask.compareOpportunityId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVOpp.get(0).getSquad());
			viewTask.compareOwner(FileCSVOpp.get(0).getOwner());
			viewTask.compareCountry(FileCSVOpp.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVOpp.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVOpp.get(0).getEnvironment());
			viewTask.compareStage("Implemantation");
			viewTask.comparePriority(FileCSVOpp.get(0).getPriority());
			viewTask.compareComplexity(FileCSVOpp.get(0).getComplexity());
			viewTask.compareSummary(FileCSVOpp.get(0).getSummary());
			viewTask.compareDescription(FileCSVOpp.get(0).getDescription());
			viewTask.compareCurrentStatus("Closed");
			viewTask.comparePreviousStatus("In Progress");

			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");

		} catch (Exception x) {
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Some field(s) was(were) filled correctly");
		}
	}
	
	@Test(priority = 21)
	public void verifyFillQAReview() {
		selEngine.sysOut("verifyFillQAReview\n");
		logger = extent.startTest("Verify Fill QA Review");

		viewTask.clickOpenOpportunity();
		
		view.clickThirdChildLink();
		try {
			viewTask.compareOpportunityId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVOpp.get(0).getSquad());
			viewTask.compareCountry(FileCSVOpp.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVOpp.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVOpp.get(0).getEnvironment());
			viewTask.compareStage("QA Review");
			viewTask.comparePriority(FileCSVOpp.get(0).getPriority());
			viewTask.compareComplexity(FileCSVOpp.get(0).getComplexity());
			viewTask.compareSummary(FileCSVOpp.get(0).getSummary());
			viewTask.compareDescription(FileCSVOpp.get(0).getDescription());
			viewTask.compareCurrentStatus("Closed");
			viewTask.comparePreviousStatus("In Progress");

			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");

		} catch (Exception x) {
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Some field(s) was(were) filled correctly");
		}
	}
	
	@Test(priority = 22)
	public void verifyFillQATests() {
		selEngine.sysOut("verifyFillQATests\n");
		logger = extent.startTest("Verify Fill QA Tests");

		viewTask.clickOpenOpportunity();
		
		view.clickFourthChildLnk();
		try {
			viewTask.compareOpportunityId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVOpp.get(0).getSquad());
			viewTask.compareCountry(FileCSVOpp.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVOpp.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVOpp.get(0).getEnvironment());
			viewTask.compareStage("QA Tests");
			viewTask.comparePriority(FileCSVOpp.get(0).getPriority());
			viewTask.compareComplexity(FileCSVOpp.get(0).getComplexity());
			viewTask.compareSummary(FileCSVOpp.get(0).getSummary());
			viewTask.compareDescription(FileCSVOpp.get(0).getDescription());
			viewTask.compareCurrentStatus("Closed");
			viewTask.comparePreviousStatus("New");

			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");

		} catch (Exception x) {
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Some field(s) was(were) filled correctly");
		}
	}
	
	@Test(priority = 23)
	public void verifyFillDeployment() {
		selEngine.sysOut("verifyFillDeployment\n");
		logger = extent.startTest("Verify Fill Deployment");

		viewTask.clickOpenOpportunity();
		
		view.clickFifthChildLink();
		try {
			viewTask.compareOpportunityId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVOpp.get(0).getSquad());
			viewTask.compareOwner(FileCSVOpp.get(0).getOwner());
			viewTask.compareCountry(FileCSVOpp.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVOpp.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVOpp.get(0).getEnvironment());
			viewTask.compareStage("Deployment");
			viewTask.comparePriority(FileCSVOpp.get(0).getPriority());
			viewTask.compareComplexity(FileCSVOpp.get(0).getComplexity());
			viewTask.compareSummary(FileCSVOpp.get(0).getSummary());
			viewTask.compareDescription(FileCSVOpp.get(0).getDescription());
			viewTask.compareCurrentStatus("Closed");
			viewTask.comparePreviousStatus("In Progress");

			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");

		} catch (Exception x) {
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Some field(s) was(were) filled correctly");
		}
	}
}
