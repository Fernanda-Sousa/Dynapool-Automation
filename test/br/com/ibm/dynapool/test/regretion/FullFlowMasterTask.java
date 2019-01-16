/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 01-nov-2018

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
import br.com.ibm.dynapool.pages.dispatching.MasterTaskEdit_Page;
import br.com.ibm.dynapool.pages.dispatching.MasterTaskFilter_Page;
import br.com.ibm.dynapool.pages.dispatching.MasterTaskList_Page;
import br.com.ibm.dynapool.pages.dispatching.MasterTaskView_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskEdit_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskView_Page;
import br.com.ibm.dynapool.pages.frames.StageApprovalsList_Page;
import br.com.ibm.dynapool.pages.request.MasterTaskRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowMasterTask extends Test_Constructor {

	String id;

	Home_Page home = new Home_Page();
	MasterTaskRequest_Page request = new MasterTaskRequest_Page();
	MasterTaskList_Page list = new MasterTaskList_Page();
	MasterTaskView_Page view = new MasterTaskView_Page();
	MasterTaskEdit_Page edit = new MasterTaskEdit_Page();
	MasterTaskFilter_Page filter = new MasterTaskFilter_Page();
	TaskView_Page viewTask = new TaskView_Page();
	TaskEdit_Page editTask = new TaskEdit_Page();
	StageApprovalsList_Page stageFrm = new StageApprovalsList_Page();

	@Test(priority = 0)
	public void executeLogin() {
		selEngine.sysOut("openPage\n");
		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();

		selEngine.sysOut("executeLogin\n");
		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));

		selEngine.login("dev");

		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Home Page loaded");
	}

	@Test(priority = 1)
	public void requestMasterTask() {
		selEngine.sysOut("requestMasterTask\n");
		logger = extent.startTest("Request Master Task");

		for (Csv_Constructor csv : FileCSVMas) {
			home.clickRequestMaster();
			selEngine.waitForPageLoad();

			request.setCountry(csv.getTargetCountry());
			request.setAccount(csv.getTargetAccount());
			request.setEnvironment(csv.getEnvironment());
			request.setClass(csv.getClassField());
			request.setPriority(csv.getPriority());
			request.setComplexity(csv.getComplexity());
			request.setSummary(csv.getSummary());
			request.setDescription(csv.getDescription());
			request.setTaskSource(csv.getTaskSource());
			request.setAutomataCategory(csv.getAutomataCategory());
			request.setAlert_ServerCount(csv.getAlert_ServerCount());
//			request.setDefectCategory(csv.getDefectCategory());

			request.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Master Task Request was done correctly");
		}

		logger.log(LogStatus.PASS, "The Master Task Request test was executed correctly");
	}

	@Test(priority = 2)
	public void approveRequest() {
		selEngine.sysOut("approveRequest\n");
		logger = extent.startTest("Approve Master Task Request");

		selEngine.changeUser("admin");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVMas) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/mastertaskList.jsp");
			selEngine.waitForPageLoad();

			list.doubleClickIdFilter();
			selEngine.waitForPageLoad();
			list.clickFirstItemLink();
			selEngine.waitForPageLoad();

			id = view.getId();
			view.clickEditTab();

			edit.setSquad(csv.getSquad());
			edit.setOwner(csv.getOwner());
			selEngine.sleepSeconds(3);
			edit.clickApproveYes();

			edit.clickSaveButton();
			selEngine.waitForPageLoad();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved. ID: " + id));
			logger.log(LogStatus.INFO, "The Request Approval was done correctly");
		}

		logger.log(LogStatus.PASS, "The Request Approval test was done correctly");
	}

// SOP Definition
	@Test(priority = 3)
	public void startSOPDefinition() {
		selEngine.sysOut("startSOPDefinition\n");
		logger = extent.startTest("Start SOP Defination");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/mastertaskList.jsp");
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

		viewTask.setDiscussion(FileCSVMas.get(0).getDiscussion());
		viewTask.clickStartButton();

		selEngine.alertClick();

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The SOP Start test was executed correctly");
	}

	@Test(priority = 4)
	public void createSOP() {
		selEngine.sysOut("createSOP\n");
		logger = extent.startTest("Create a SOP");

		for (Csv_Constructor csv : FileCSVMas) {
			viewTask.setLinkSOP(csv.getSOPLink());
			viewTask.setCurrentEffort(csv.getCurrentEffort());
			viewTask.setPercentageCompleted(csv.getPercentageCompleted());
			viewTask.setDiscussion(csv.getDiscussion());

			viewTask.clickUpdateButton();
			selEngine.waitForPageLoad();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Task was start correctly");
		}

		logger.log(LogStatus.PASS, "The Create SOP Test executed correctly");
	}

	@Test(priority = 5)
	public void onHoldProcess() {
		selEngine.sysOut("OnHoldProcess\n");

		onHold();
	}

	@Test(priority = 6)
	public void extensionProcess() {
		selEngine.sysOut("ExtensionProcess\n");

		extension();
	}

	@Test(priority = 7)
	public void approveSOP() {
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
		selEngine.waitForPageLoad();

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The SOP link was approved correctly");
	}

	@Test(priority = 8)
	public void resolveSOP() {
		selEngine.sysOut("ResolveSOP\n");
		logger = extent.startTest("Resolve SOP");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVMas) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/mastertaskList.jsp");

			selEngine.waitForPageLoad();
			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();
			selEngine.waitForPageLoad();

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

		logger.log(LogStatus.PASS, "The SOP resolve Test was executed correctly");
	}

// Implementation
	@Test(priority = 9)
	public void startImplementation() {
		selEngine.sysOut("startImplementation\n");
		logger = extent.startTest("Start Implementation");

		for (Csv_Constructor csv : FileCSVMas) {
			selEngine.waitForPageLoad();
			viewTask.clickOpenMasterTask();
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

		for (Csv_Constructor csv : FileCSVMas) {
			viewTask.clickOpenMasterTask();
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

		for (Csv_Constructor csv : FileCSVMas) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/mastertaskList.jsp");
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

		for (Csv_Constructor csv : FileCSVMas) {
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

		for (Csv_Constructor csv : FileCSVMas) {
			viewTask.clickOpenMasterTask();
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

		for (Csv_Constructor csv : FileCSVMas) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/mastertaskList.jsp");
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
	public void approveDeployment() {
		selEngine.sysOut("approveDeploymen\n");
		logger = extent.startTest("Approve Deployment");

		selEngine.changeUser("qatest");
		selEngine.waitForPageLoad();

		selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/mastertaskList.jsp");
		selEngine.waitForPageLoad();

		list.clickMagnifierFilter();
		filter.setId(id);
		filter.clickApplyButton();
		selEngine.waitForPageLoad();

		list.clickFirstItemLink();
		selEngine.waitForPageLoad();
		view.clickFifthChildLink();
		selEngine.waitForPageLoad();

		selEngine.sleepSeconds(3);
		viewTask.clickEditTab();
		selEngine.waitForPageLoad();
		selEngine.sleepSeconds(3);
		editTask.clickDeploymentApprovedYes();
		editTask.clickSaveButton();
		selEngine.waitForPageLoad();

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Deployment was started correctly");
	}

	@Test(priority = 16)
	public void resolveDeployment() {
		selEngine.sysOut("resolveDeployment\n");
		logger = extent.startTest("Resolve Deployment");

		selEngine.waitForPageLoad();
		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVMas) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/mastertaskList.jsp");
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

		viewTask.clickOpenMasterTask();
		selEngine.waitForPageLoad();

		String approvedDateMaster = view.getApprovedDate();
		String closedDateMaster = view.getClosedDate();

		view.clickFirstChildLink();
		selEngine.waitForPageLoad();

		String createdDateFirstChild = viewTask.getCreatedDate();

		selEngine.sysOut("closed child: " + closedDateLastChild + "; closed master: " + closedDateMaster
				+ "; created child: " + createdDateFirstChild + "; created master: " + approvedDateMaster);

		Assert.assertEquals(approvedDateMaster, createdDateFirstChild);
		Assert.assertEquals(closedDateMaster, closedDateLastChild);

		logger.log(LogStatus.PASS, "The dates are the same");
	}

	@Test(priority = 18)
	public void verifyFill() {
		selEngine.sysOut("verifyFill\n");
		logger = extent.startTest("Verify Fill");

		viewTask.clickOpenMasterTask();
		try {
			view.compareId(id);
			view.compareRequester("Developer Test");
			view.compareSquad(FileCSVMas.get(0).getSquad());
			view.compareOwner(FileCSVMas.get(0).getOwner());
			view.compareCountry(FileCSVMas.get(0).getTargetCountry());
			view.compareAccount(FileCSVMas.get(0).getTargetAccount());
			view.compareEnvironment(FileCSVMas.get(0).getEnvironment());
			view.compareClass(FileCSVMas.get(0).getClassField());
			view.comparePriority(FileCSVMas.get(0).getPriority());
			view.compareComplexity(FileCSVMas.get(0).getComplexity());
			view.compareSummary(FileCSVMas.get(0).getSummary());
			view.compareDescription(FileCSVMas.get(0).getDescription());
			view.compareTaskSource(FileCSVMas.get(0).getTaskSource());
			view.compareAutomataCategory(FileCSVMas.get(0).getAutomataCategory());
			view.compareAlert_ServerCount(FileCSVMas.get(0).getAlert_ServerCount());
			view.compareStatus("Closed");
			view.compareCurrentStage("Deployment");

			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");

		} catch (Exception x) {
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
			viewTask.compareMasterId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVMas.get(0).getSquad());
			viewTask.compareOwner(FileCSVMas.get(0).getOwner());
			viewTask.compareCountry(FileCSVMas.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVMas.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVMas.get(0).getEnvironment());
			viewTask.compareStage("SOP Definition");
			viewTask.comparePriority(FileCSVMas.get(0).getPriority());
			viewTask.compareComplexity(FileCSVMas.get(0).getComplexity());
			viewTask.compareSummary(FileCSVMas.get(0).getSummary());
			viewTask.compareDescription(FileCSVMas.get(0).getDescription());
			viewTask.compareLinkToSOP(FileCSVMas.get(0).getSOPLink());
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

		viewTask.clickOpenMasterTask();
		
		view.clickSecondChildLink();
		try {
			viewTask.compareMasterId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVMas.get(0).getSquad());
			viewTask.compareOwner(FileCSVMas.get(0).getOwner());
			viewTask.compareCountry(FileCSVMas.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVMas.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVMas.get(0).getEnvironment());
			viewTask.compareStage("Implemantation");
			viewTask.comparePriority(FileCSVMas.get(0).getPriority());
			viewTask.compareComplexity(FileCSVMas.get(0).getComplexity());
			viewTask.compareSummary(FileCSVMas.get(0).getSummary());
			viewTask.compareDescription(FileCSVMas.get(0).getDescription());
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

		viewTask.clickOpenMasterTask();
		
		view.clickThirdChildLink();
		try {
			viewTask.compareMasterId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVMas.get(0).getSquad());
			viewTask.compareCountry(FileCSVMas.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVMas.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVMas.get(0).getEnvironment());
			viewTask.compareStage("QA Review");
			viewTask.comparePriority(FileCSVMas.get(0).getPriority());
			viewTask.compareComplexity(FileCSVMas.get(0).getComplexity());
			viewTask.compareSummary(FileCSVMas.get(0).getSummary());
			viewTask.compareDescription(FileCSVMas.get(0).getDescription());
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

		viewTask.clickOpenMasterTask();
		
		view.clickFourthChildLnk();
		try {
			viewTask.compareMasterId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVMas.get(0).getSquad());
			viewTask.compareCountry(FileCSVMas.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVMas.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVMas.get(0).getEnvironment());
			viewTask.compareStage("QA Tests");
			viewTask.comparePriority(FileCSVMas.get(0).getPriority());
			viewTask.compareComplexity(FileCSVMas.get(0).getComplexity());
			viewTask.compareSummary(FileCSVMas.get(0).getSummary());
			viewTask.compareDescription(FileCSVMas.get(0).getDescription());
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

		viewTask.clickOpenMasterTask();
		
		view.clickFifthChildLink();
		try {
			viewTask.compareMasterId(id);
			viewTask.compareRequester("Developer Test");
			viewTask.compareSquad(FileCSVMas.get(0).getSquad());
			viewTask.compareOwner(FileCSVMas.get(0).getOwner());
			viewTask.compareCountry(FileCSVMas.get(0).getTargetCountry());
			viewTask.compareAccount(FileCSVMas.get(0).getTargetAccount());
			viewTask.compareEnvironment(FileCSVMas.get(0).getEnvironment());
			viewTask.compareStage("Deployment");
			viewTask.comparePriority(FileCSVMas.get(0).getPriority());
			viewTask.compareComplexity(FileCSVMas.get(0).getComplexity());
			viewTask.compareSummary(FileCSVMas.get(0).getSummary());
			viewTask.compareDescription(FileCSVMas.get(0).getDescription());
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
