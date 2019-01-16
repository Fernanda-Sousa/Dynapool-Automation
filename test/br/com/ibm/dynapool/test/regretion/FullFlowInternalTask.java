/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 02-nov-2018

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
import br.com.ibm.dynapool.pages.dispatching.TaskEdit_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskFilter_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskList_Page;
import br.com.ibm.dynapool.pages.dispatching.TaskView_Page;
import br.com.ibm.dynapool.pages.request.TaskRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowInternalTask extends Test_Constructor {

	String id;
	
	Home_Page home = new Home_Page();
	TaskRequest_Page request = new TaskRequest_Page();
	TaskList_Page list = new TaskList_Page();
	TaskFilter_Page filter = new TaskFilter_Page();
	TaskView_Page view = new TaskView_Page();
	TaskEdit_Page edit = new TaskEdit_Page();

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
	public void requestInternalTask() {
		selEngine.sysOut("requestInternalTask\n");
		logger = extent.startTest("Request Internal Task");

		for (Csv_Constructor csv : FileCSVInt) {
			home.clickRequestInternal();
			selEngine.waitForPageLoad();

			request.setCountry(csv.getTargetCountry());
			request.setAccount(csv.getTargetAccount());
			request.setEnvironment(csv.getEnvironment());
			request.setClass(csv.getClassField());
			request.setActivityDpx(csv.getActivity());
			request.setPriority(csv.getPriority());
			request.setComplexity(csv.getComplexity());
			request.setSummary(csv.getSummary());
			request.setDescription(csv.getDescription());

			request.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Internal Task Request was done correctly");
		}

		logger.log(LogStatus.PASS, "The Internal Task Request test was executed correctly");
	}
	
	@Test(priority = 2)
	public void assignRequest() {
		selEngine.sysOut("assignRequest\n");
		logger = extent.startTest("Assign Internal Task Request");

		selEngine.changeUser("disp");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVInt) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/taskList.jsp");
			selEngine.waitForPageLoad();

			list.doubleClickIdFilter();
			selEngine.waitForPageLoad();
			list.clickFirstItemLink();
			selEngine.waitForPageLoad();

			id = view.getId();
			view.clickEditTab();

			edit.setSquad(csv.getSquad());
			edit.setOwner(csv.getOwner());

			edit.clickSaveButton();
			selEngine.waitForPageLoad();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved. ID: " + id));
			logger.log(LogStatus.INFO, "The Request was assigned correctly");
		}

		logger.log(LogStatus.PASS, "The Request Assign test was done correctly");
	}
	
	@Test(priority = 3)
	public void startInternalTask() {
		selEngine.sysOut("startInternalTask\n");
		logger = extent.startTest("Start Internal Task");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/taskList.jsp");
		selEngine.waitForPageLoad();

		list.clickMagnifierFilter();
		selEngine.waitForPageLoad();
		filter.setId(id);
		filter.clickApplyButton();
		selEngine.waitForPageLoad();

		list.clickFirstItemLink();
		selEngine.waitForPageLoad();
		
		view.setDiscussion(FileCSVInt.get(0).getDiscussion());
		view.clickStartButton();

		selEngine.alertClick();

		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The Start test was executed correctly");
	}
	
	@Test(priority = 4)
	public void onHoldProcess() {
		selEngine.sysOut("OnHoldProcess\n");

		onHold();
	}

	@Test(priority = 5)
	public void extensionProcess() {
		selEngine.sysOut("ExtensionProcess\n");

		extension();
	}
	
	@Test(priority = 6)
	public void resolveInternalTask() {
		selEngine.sysOut("ResolveInternalTask\n");
		logger = extent.startTest("Resolve Internal Task");

		selEngine.changeUser("dev");
		selEngine.waitForPageLoad();

		for (Csv_Constructor csv : FileCSVInt) {
			selEngine.driver().get("https://dynapool.ipctrmx02.com/dynatest/dispatch/taskList.jsp");

			selEngine.waitForPageLoad();
			list.clickMagnifierFilter();
			filter.setId(id);
			filter.clickApplyButton();
			selEngine.waitForPageLoad();

			list.clickFirstItemLink();
			selEngine.waitForPageLoad();
			
			view.setCurrentEffort(csv.getCurrentEffort());
			view.setPercentageCompleted(csv.getPercentageCompleted());
			view.setDiscussion(csv.getDiscussion());
			view.clickResolveButton();

			selEngine.alertClick();
			selEngine.waitForPageLoad();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Internal Task was resolved correctly");
		}

		logger.log(LogStatus.PASS, "The Internal Task resolve Test was executed correctly");
	}
	
	@Test(priority = 7)
	public void verifyFill() {
		selEngine.sysOut("verifyFill\n");
		logger = extent.startTest("Verify Fill");
		
		try {
			view.compareRequester("Developer Test");
			view.compareSquad(FileCSVInt.get(0).getSquad());
			view.compareOwner(FileCSVInt.get(0).getOwner());
			view.compareCountry(FileCSVInt.get(0).getTargetCountry());
			view.compareAccount(FileCSVInt.get(0).getTargetAccount());
			view.compareEnvironment(FileCSVInt.get(0).getEnvironment());
			view.comparePriority(FileCSVInt.get(0).getPriority());
			view.compareComplexity(FileCSVInt.get(0).getComplexity());
			view.compareSummary(FileCSVInt.get(0).getSummary());
			view.compareDescription(FileCSVInt.get(0).getDescription());
			view.compareCurrentStatus("Closed");
			view.comparePreviousStatus("In Progress");
			
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "All fields were filled correctly");
		
		}catch (Exception x){
			selEngine.sysOut(x);
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Some field(s) was(were) filled correctly");
		}		
	}
}
