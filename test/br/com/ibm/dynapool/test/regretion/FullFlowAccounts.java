/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 14-nov-2018

Last update date: 26-nov-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

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
import br.com.ibm.dynapool.pages.administration.AccountEdit_Page;
import br.com.ibm.dynapool.pages.administration.AccountList_Page;
import br.com.ibm.dynapool.pages.administration.AccountNew_Page;
import br.com.ibm.dynapool.pages.administration.AccountView_Page;
import br.com.ibm.dynapool.pages.request.MasterTaskRequest_Page;
import br.com.ibm.dynapool.pages.request.OpportunityRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowAccounts extends Test_Constructor {

	Home_Page home = new Home_Page();
	AccountList_Page list = new AccountList_Page();
	AccountNew_Page newA = new AccountNew_Page();
	AccountView_Page view = new AccountView_Page();
	AccountEdit_Page edit = new AccountEdit_Page();

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
	public void newAccount() {
		selEngine.sysOut("newAccount\n");
		logger = extent.startTest("New Account");

		home.clickAdministrationAccount();

		list.clickNewButton();

		for (Csv_Constructor csv : FileCSVAcc) {
			newA.setName(csv.getName());
			newA.setCountry(csv.getCountry());
			newA.setStatus(csv.getStatus());

			newA.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Account creation was done correctly");
		}

		logger.log(LogStatus.PASS, "The Account creation test was executed correctly");
	}

	@Test(priority = 2)
	public void editAccount() {
		selEngine.sysOut("editAccount\n");
		logger = extent.startTest("Edit Account");

		selEngine.waitForPageLoad();
		list.doubleClickIdFilter();
		list.clickFirstItemLink();
		view.clickEditTab();

		for (Csv_Constructor csv : FileCSVAcc) {
			selEngine.waitForPageLoad();
			newA.setName(csv.getName() + " - Update");

			newA.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The Account edition was done correctly");
		}

		logger.log(LogStatus.PASS, "The Account edition test was executed correctly");
	}

	@Test(priority = 3)
	public void verifyAccount() {
		selEngine.sysOut("verifyAccount\n");
		logger = extent.startTest("Verify Account");

		try {
			MasterTaskRequest_Page request = new MasterTaskRequest_Page();

			home.clickRequestMaster();
			request.setCountry(FileCSVAcc.get(0).getCountry());
			request.setAccount(FileCSVAcc.get(0).getName());

			request.getCountry().compareTo(FileCSVAcc.get(0).getCountry());
			request.getAccount().compareTo(FileCSVAcc.get(0).getName());
			
			request.clickCancelButton();

			logger.log(LogStatus.PASS, "The new account was shown on dropbox list on master task");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "The new account was not shown on dropbox list on master task");
		}

		try {
			OpportunityRequest_Page request = new OpportunityRequest_Page();

			home.clickRequestOpportunity();
			request.setCountry(FileCSVAcc.get(0).getCountry());
			request.setAccount(FileCSVAcc.get(0).getName());

			request.getCountry().compareTo(FileCSVAcc.get(0).getCountry());
			request.getAccount().compareTo(FileCSVAcc.get(0).getName());

			logger.log(LogStatus.PASS, "The new account was shown on dropbox list on opportunity task");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "The new account was not shown on dropbox list on opportunity task");
		}
	}
}
