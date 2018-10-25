/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 17-oct-2018

Last update date: 25-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class OpportunityEdit_Page extends Home_Page {

	By viewLnk = By.name("tabView");

	By idTxt = By.name("txtId");

	By requesterDpx = By.name("selIdrequester");

	By squadDpx = By.name("selDefsquad");
	By ownerDpx = By.name("selIdowner");

	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By areaDpx = By.name("selDefenvironment");
	By priorityDpx = By.name("selDefpriority");

	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By SMEContactTxt = By.name("txtAccountsme");

	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
	By expectedSavingsTxt = By.name("txtSavings");
	By costsAvoidedTxt = By.name("txtCostavoid");
	By complexityDpx = By.name("selDefcomplexity");
	By taskSourceDpx = By.name("selDeftasksource");

	By creationDateDtf = By.name("txtDatecreation");//
	By plannedStartDateDtf = By.name("txtDatePlanning");
	By formApprovedNoRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(24) > td:nth-child(2) > input:nth-child(1)");
	By formApprovedYesRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(24) > td:nth-child(2) > input:nth-child(2)");
	By formAppNotesTxa = By.name("txaFormnotes");
	By businessApprovedNoRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(26) > td:nth-child(2) > input:nth-child(1)");
	By businessApprovedYesRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(26) > td:nth-child(2) > input:nth-child(2)");
	By businessAppNotesTxa = By.name("txaBusnotes");
	By technicalApprovedNoRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(28) > td:nth-child(2) > input:nth-child(1)");
	By technicalApprovedYesRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(28) > td:nth-child(2) > input:nth-child(2)");
	By technicalAppNotesTxa = By.name("txaTecnotes");
	By statusDpx = By.name("selDefstatus");
	By currentStageDpx = By.name("selDefstage");
	By approvedDft = By.name("txtDateapproval");

	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

	Selenium_Engine selEngine = new Selenium_Engine();

	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}

	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}

	public boolean compareRequester(String strRequester) {
		return selEngine.compareText(requesterDpx, strRequester);
	}

	public void setSquad(String strSquad) {
		selEngine.selectDropDown(squadDpx, strSquad);
	}

	public void setOwner(String strOwner) {
		selEngine.selectDropDown(ownerDpx, strOwner);
	}

	public void setCountry(String strCountry) {
		selEngine.selectDropDown(targetCountryDpx, strCountry);
	}

	public void setAccount(String strAccount) {
		selEngine.selectDropDown(targetAccountDpx, strAccount);
	}

	public void setArea(String strArea) {
		selEngine.selectDropDown(areaDpx, strArea);
	}

	public void setPriority(String strPriority) {
		selEngine.selectDropDown(priorityDpx, strPriority);
	}

	public void setSMEContact(String strSMEContact) {
		selEngine.setTextbox(SMEContactTxt, strSMEContact);
	}

	public boolean compareAutomataCategory(String strAutomataCategory) {
		return selEngine.compareText(automataCategoryDpx, strAutomataCategory);
	}

	public void setSummary(String strSummary) {
		selEngine.setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		selEngine.setTextbox(descriptionTxa, strDescription);
	}

	public void setTaskSource(String strTaskSource) {
		selEngine.selectDropDown(taskSourceDpx, strTaskSource);
	}

	public void setAutomataCategory(String strAutomataCategory) {
		selEngine.selectDropDown(automataCategoryDpx, strAutomataCategory);
	}

	public void setAlert_ServerCount(String strAlert_ServerCount) {
		selEngine.setTextbox(alert_ServerCountTxt, strAlert_ServerCount);
	}

	public boolean compareExpectedSavings(String strExpectedSavings) {
		return selEngine.compareText(expectedSavingsTxt, strExpectedSavings);
	}

	public boolean compareCostsAvoided(String strCostsAvoided) {
		return selEngine.compareText(costsAvoidedTxt, strCostsAvoided);
	}

	public void setComplexity(String strComplexity) {
		selEngine.selectDropDown(complexityDpx, strComplexity);
	}

	public boolean compareDateCreation(String strDateCreation) {
		return selEngine.compareText(creationDateDtf, strDateCreation);
	}

	public void setPlannedStartDate(String strPlannedStartDate) {
		selEngine.setTextbox(plannedStartDateDtf, strPlannedStartDate);
	}

	public void clickFormApprovedNo() {
		selEngine.click(formApprovedNoRdb);
	}

	public void clickFormApprovedYes() {
		selEngine.click(formApprovedYesRdb);
	}

	public void setFormAppNotes(String strFormAppNotes) {
		selEngine.setTextbox(formAppNotesTxa, strFormAppNotes);
	}

	public void clickBusinessApprovedNo() {
		selEngine.click(businessApprovedNoRdb);
	}

	public void clickBusinessApprovedYes() {
		selEngine.click(businessApprovedYesRdb);
	}

	public void setBusinessAppNotes(String strBusinessAppNotes) {
		selEngine.setTextbox(businessAppNotesTxa, strBusinessAppNotes);
	}

	public void clickTechnicalApprovedNo() {
		selEngine.click(technicalApprovedNoRdb);
	}

	public void clickTechnicalApprovedYes() {
		selEngine.click(technicalApprovedYesRdb);
	}

	public void setTechnicalAppNotes(String strTechnicalAppNotes) {
		selEngine.setTextbox(technicalAppNotesTxa, strTechnicalAppNotes);
	}

	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}

	public boolean compareCurrentStage(String strCurrentStage) {
		return selEngine.compareText(currentStageDpx, strCurrentStage);
	}

	public boolean compareApprovedDate(String strApprovedDate) {
		return selEngine.compareText(approvedDft, strApprovedDate);
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
