package br.com.ibm.dynapool.pages.request;

import static br.com.ibm.dynapool.engine.Selenium_Engine.click;
import static br.com.ibm.dynapool.engine.Selenium_Engine.selectDropDown;
import static br.com.ibm.dynapool.engine.Selenium_Engine.setTextbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		selectDropDown(targetCountryDpx, strCountry);
	}

	public void setAccount(String strAccount) {
		selectDropDown(targetAccountDpx, strAccount);
	}

	public void setEnvironment(String strEnvironment) {
		selectDropDown(environmentDpx, strEnvironment);
	}

	public void setClass(String strClass) {
		selectDropDown(classDpx, strClass);
	}

	public void setPriority(String strPriority) {
		selectDropDown(priorityDpx, strPriority);
	}

	public void setSummary(String strSummary) {
		setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		setTextbox(descriptionTxa, strDescription);
	}

	public void setSME_ClientContact(String strSME_ClientContact) {
		setTextbox(SME_ClientContactTxt, strSME_ClientContact);
	}

	public void setAutomataCategory(String strAutomataCategory) {
		selectDropDown(automataCategoryDpx, strAutomataCategory);
	}

	public void setAlert_ServerCount(String strAlert_ServerCount) {
		setTextbox(alert_ServerCountTxt, strAlert_ServerCount);
	}

	public void setExpectedSavings(String strExpectedSavings) {
		setTextbox(expectedSavingsTxt, strExpectedSavings);
	}

	public void setcostsAvoidedTxt(String strcostsAvoidedTxt) {
		setTextbox(costsAvoidedTxt, strcostsAvoidedTxt);
	}

	public void clickSaveButton() {
		click(saveBtn);
	}

	public void clickClearButton() {
		click(clearBtn);
	}

	public void clickCancelButton() {
		click(cancelBtn);
	}
}
