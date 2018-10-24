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

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class OpportunityRequest_Page extends Home_Page{
	
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

	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void setCountry(String strCountry) {
		selEngine.selectDropDown(targetCountryDpx, strCountry);
	}

	public void setAccount(String strAccount) {
		selEngine.selectDropDown(targetAccountDpx, strAccount);
	}

	public void setEnvironment(String strEnvironment) {
		selEngine.selectDropDown(environmentDpx, strEnvironment);
	}

	public void setClass(String strClass) {
		selEngine.selectDropDown(classDpx, strClass);
	}

	public void setPriority(String strPriority) {
		selEngine.selectDropDown(priorityDpx, strPriority);
	}

	public void setSummary(String strSummary) {
		selEngine.setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		selEngine.setTextbox(descriptionTxa, strDescription);
	}

	public void setSME_ClientContact(String strSME_ClientContact) {
		selEngine.setTextbox(SME_ClientContactTxt, strSME_ClientContact);
	}

	public void setAutomataCategory(String strAutomataCategory) {
		selEngine.selectDropDown(automataCategoryDpx, strAutomataCategory);
	}

	public void setAlert_ServerCount(String strAlert_ServerCount) {
		selEngine.setTextbox(alert_ServerCountTxt, strAlert_ServerCount);
	}

	public void setExpectedSavings(String strExpectedSavings) {
		selEngine.setTextbox(expectedSavingsTxt, strExpectedSavings);
	}

	public void setcostsAvoidedTxt(String strcostsAvoidedTxt) {
		selEngine.setTextbox(costsAvoidedTxt, strcostsAvoidedTxt);
	}

	public void clickSaveButton() {
		selEngine.click(saveBtn);
	}

	public void clickClearButton() {
		selEngine.click(clearBtn);
	}

	public void clickCancelButton() {
		selEngine.click(cancelBtn);
	}
}
