/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 16-oct-2018

Last update date: 16-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class MasterTaskEdit_Page extends Home_Page {

	By viewLnk = By.name("tabView");

	By idTxt = By.name("txtId");

	By requesterDpx = By.name("selIdrequester");

	By squadDpx = By.name("selDefsquad");
	By ownerDpx = By.name("selIdowner");

	By classDpx = By.name("selDeftype");
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By areaDpx = By.name("selDefenvironment");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By automataDpx = By.name("selAutomata");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");

	By taskSourceDpx = By.name("selDeftasksource");
	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
//	By defectCategoryDpx = By.name("selDefdefectcategory");

	By approvedNoRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(22) > td:nth-child(2) > input:nth-child(1)");
	By approvedYesRdb = By.xpath("//*[@id=\"panel\"]/form/table/tbody/tr[22]/td[2]/input[2]");
	By currentStageDpx = By.name("selDefstage");

	By statusDpx = By.name("selDefstatus");
	By createdDtf = By.name("txtDatecreation");//
	By approvedDft = By.name("txtDateapproval");
	By creationDateDtf = By.name("txtDatecreation");//
	By plannedStartDateDtf = By.name("txtDatePlanning");
	By startedDtf = By.name("txtDatestarted");

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

	public boolean compareClass(String strClass) {
		return selEngine.compareText(classDpx, strClass);
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

	public void setComplexity(String strComplexity) {
		selEngine.selectDropDown(complexityDpx, strComplexity);
	}

	public boolean compareAutomata(String strAutomata) {
		return selEngine.compareText(automataDpx, strAutomata);
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

	public void clickApproveNo() {
		selEngine.click(approvedNoRdb);
	}

	public void clickApproveYes() {
		selEngine.click(approvedYesRdb);
	}
	
	public boolean compareCurrentStage(String strCurrentStage) {
		return selEngine.compareText(currentStageDpx, strCurrentStage);
	}

	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}
	
	public boolean compareCreatedDate(String strCreatedDate) {
		return selEngine.compareText(createdDtf, strCreatedDate);
	}
	
	public boolean compareApprovedDate(String strApprovedDate) {
		return selEngine.compareText(approvedDft, strApprovedDate);
	}

	public boolean compareDateCreation(String strDateCreation) {
		return selEngine.compareText(creationDateDtf, strDateCreation);
	}
	
	public void setPlannedStartDate(String strPlannedStartDate) {
		selEngine.setTextbox(plannedStartDateDtf, strPlannedStartDate);
	}
	
	public boolean compareStartedDate(String strStartedDate) {
		return selEngine.compareText(startedDtf, strStartedDate);
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
