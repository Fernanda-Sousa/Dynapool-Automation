/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 03-dec-2018

Last update date: 26-dec-2018
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
import br.com.ibm.dynapool.pages.administration.UserAccess_Page;
import br.com.ibm.dynapool.pages.administration.UserEdit_Page;
import br.com.ibm.dynapool.pages.administration.UserList_Page;
import br.com.ibm.dynapool.pages.administration.UserNew_Page;
import br.com.ibm.dynapool.pages.administration.UserView_Page;
import br.com.ibm.dynapool.pages.request.MasterTaskRequest_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class FullFlowUser extends Test_Constructor {
	Home_Page home = new Home_Page();
	UserList_Page list = new UserList_Page();
	UserNew_Page newU = new UserNew_Page();
	UserView_Page view = new UserView_Page();
	UserEdit_Page edit = new UserEdit_Page();
	UserAccess_Page access = new UserAccess_Page();

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
	public void newUser() {
		selEngine.sysOut("newUser\n");
		logger = extent.startTest("New User");

		home.clickAdministrationUser();

		list.clickNewButton();

		for (Csv_Constructor csv : FileCSVUsr) {
			newU.setName(csv.getName());
			newU.setEmail(csv.getEmail());

			newU.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The User creation was done correctly");
		}

		logger.log(LogStatus.PASS, "The User creation test was executed correctly");
	}

	@Test(priority = 2)
	public void editUser() {
		selEngine.sysOut("editUser\n");
		logger = extent.startTest("Edit User");

		selEngine.waitForPageLoad();
		list.doubleClickIdFilter();

		for (Csv_Constructor csv : FileCSVUsr) {
			list.clickFirstItemLink();
			view.clickEditTab();
			selEngine.waitForPageLoad();

			edit.setName(csv.getName() + " - Update");
			edit.setEmail(csv.getEmail());
			edit.setStatus(csv.getStatus());

			edit.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
			logger.log(LogStatus.INFO, "The User edition was done correctly");
		}

		logger.log(LogStatus.PASS, "The User edition test was executed correctly");
	}

	@Test(priority = 3)
	public void accessUser() {
		selEngine.sysOut("accessUser\n");
		logger = extent.startTest("Access User");

		for (Csv_Constructor csv : FileCSVUsr) {
			selEngine.waitForPageLoad();
			list.doubleClickIdFilter();
			list.clickFirstItemLink();
			view.clickAccessTab();
			selEngine.waitForPageLoad();

			access.setAccessLevel(csv.getAccessLevel());

			access.clickSaveButton();

			Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Access information successfully saved."));
			logger.log(LogStatus.INFO, "The User change access was done correctly");
		}

		logger.log(LogStatus.PASS, "The User change access test was executed correctly");
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test(priority = 4)
	public void verifyUser() {
		selEngine.sysOut("verifyUser\n");
		logger = extent.startTest("Verify User");

		try {
			MasterTaskRequest_Page request = new MasterTaskRequest_Page();

			home.clickRequestMaster();
			request.setCountry(FileCSVAut.get(0).getTargetCountry());
			selEngine.waitForPageLoad();
			request.setAccount(FileCSVAut.get(0).getTargetAccount());
			request.setEnvironment(FileCSVAut.get(0).getEnvironment());
			request.setClass(FileCSVAut.get(0).getClassField());

			Select Crosslist = new Select(request.getAutomataAvailable());

			List<WebElement> crossList = Crosslist.getOptions();
			Assert.assertEquals(crossList.get(0).getText(), FileCSVAut.get(0).getName() + " - Update");

			logger.log(LogStatus.PASS, "The new automata was shown on crossList on master task");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "The new automata was not shown on crossList on master task");
		}
	}
}
