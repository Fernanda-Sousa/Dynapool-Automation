/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 10-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.request;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class OpportunityRequest_Page {
	WebDriver driver;
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By classDpx = By.name("selDeftype");
	By priorityDpx = By.name("selDefpriority");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By SME_ClientContactTxt = By.name("txtAccountsme");
	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
	By expectedSavingsTxt = By.name("txtSavings");
	By costsAvoidedTxt = By.name("txtCostavoid");
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

	public void setCountry(String strCountry) {
		Selenium_Engine.selectDropDown(targetCountryDpx, strCountry);
	}

	public void setAccount(String strAccount) {
		Selenium_Engine.selectDropDown(targetAccountDpx, strAccount);
	}

	public void setEnvironment(String strEnvironment) {
		Selenium_Engine.selectDropDown(environmentDpx, strEnvironment);
	}

	public void setClass(String strClass) {
		Selenium_Engine.selectDropDown(classDpx, strClass);
	}

	public void setPriority(String strPriority) {
		Selenium_Engine.selectDropDown(priorityDpx, strPriority);
	}

	public void setSummary(String strSummary) {
		Selenium_Engine.setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		Selenium_Engine.setTextbox(descriptionTxa, strDescription);
	}

	public void setSME_ClientContact(String strSME_ClientContact) {
		Selenium_Engine.setTextbox(SME_ClientContactTxt, strSME_ClientContact);
	}

	public void setAutomataCategory(String strAutomataCategory) {
		Selenium_Engine.selectDropDown(automataCategoryDpx, strAutomataCategory);
	}

	public void setAlert_ServerCount(String strAlert_ServerCount) {
		Selenium_Engine.setTextbox(alert_ServerCountTxt, strAlert_ServerCount);
	}

	public void setExpectedSavings(String strExpectedSavings) {
		Selenium_Engine.setTextbox(expectedSavingsTxt, strExpectedSavings);
	}

	public void setcostsAvoidedTxt(String strcostsAvoidedTxt) {
		Selenium_Engine.setTextbox(costsAvoidedTxt, strcostsAvoidedTxt);
	}

	public void clickSaveButton() {
		Selenium_Engine.click(saveBtn);
	}

	public void clickClearButton() {
		Selenium_Engine.click(clearBtn);
	}

	public void clickCancelButton() {
		Selenium_Engine.click(cancelBtn);
	}
}
