/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 27-nov-2018

Last update date: 28-nov-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.test.regretion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.csv.Csv_Constructor;
import br.com.ibm.dynapool.pages.Home_Page;
import br.com.ibm.dynapool.pages.administration.AutomataEdit_Page;
import br.com.ibm.dynapool.pages.administration.AutomataList_Page;
import br.com.ibm.dynapool.pages.administration.AutomataNew_Page;
import br.com.ibm.dynapool.pages.administration.AutomataView_Page;
import br.com.ibm.dynapool.pages.request.MasterTaskRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowAutomata extends Test_Constructor {
	Home_Page home = new Home_Page();
	AutomataList_Page list = new AutomataList_Page();
	AutomataNew_Page newA = new AutomataNew_Page();
	AutomataView_Page view = new AutomataView_Page();
	AutomataEdit_Page edit = new AutomataEdit_Page();

	@Test(priority = 0)
	public void executeLogin() {
		selEngine.sysOut("openPage\n");
		selEngine.openURL(prop.readPropertiesFile("testwebsite"));
		selEngine.waitForPageLoad();

		selEngine.sysOut("executeLogin\n");
		logger = extent.startTest("Execute login");
		logger.log(LogStatus.INFO, "Using URL: " + prop.readPropertiesFile("testwebsite"));

		selEngine.login("admin");

		Assert.assertTrue(selEngine.verifyTextOnFieldPartial("IBM Latin America - Dynamic Automation Team"));
		logger.log(LogStatus.PASS, "Home Page loaded");
	}

	@Test(priority = 1)
	public void newAutomata() {
		selEngine.sysOut("newAutomata\n");
		logger = extent.startTest("New Automata");

		home.clickAdministrationAutomata();

		list.clickNewButton();

		for (Csv_Constructor csv : FileCSVAut) {
			newA.setName(csv.getName());
			newA.setEnvironment(csv.getEnvironment());
			selEngine.click(By.className("label"));
			newA.clickSelectEligibleAccount();
			newA.clickAddEligibleAccounts();
			newA.clickSelectDeployedAccount();
			newA.clickAddDeployedAccounts();

			newA.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Automata creation was done correctly");
		}

		logger.log(LogStatus.PASS, "The Automata creation test was executed correctly");
	}

	@Test(priority = 2)
	public void editAutomata() {
		selEngine.sysOut("editAutomata\n");
		logger = extent.startTest("Edit Automata");

		selEngine.waitForPageLoad();
		list.doubleClickIdFilter();
		list.clickFirstItemLink();
		view.clickEditTab();
		selEngine.waitForPageLoad();
		
		for (Csv_Constructor csv : FileCSVAut) {
			newA.setName(csv.getName() + " - Update");

			newA.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Automata edition was done correctly");
		}

		logger.log(LogStatus.PASS, "The Automata edition test was executed correctly");
	}

	@Test(priority = 3)
	public void verifyAutomata() {
		selEngine.sysOut("verifyAutomata\n");
		logger = extent.startTest("Verify Automata");

		try {
			MasterTaskRequest_Page request = new MasterTaskRequest_Page();

			home.clickRequestMaster();
			request.setCountry(FileCSVAut.get(0).getTargetCountry());
			selEngine.waitForPageLoad();
			request.setAccount(FileCSVAut.get(0).getTargetAccount());
			request.setEnvironment(FileCSVAut.get(0).getEnvironment());
			request.setClass(FileCSVAut.get(0).getClassField());
			
			Select Crosslist  = new Select(request.getAutomataAvailable());
			
			List<WebElement> crossList = Crosslist.getOptions();
			Assert.assertEquals(crossList.get(0).getText(), FileCSVAut.get(0).getName() + " - Update");

			logger.log(LogStatus.PASS, "The new automata was shown on crossList on master task");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "The new automata was not shown on crossList on master task");
		}
	}
}
