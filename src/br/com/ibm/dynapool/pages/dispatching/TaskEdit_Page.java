/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 17-oct-2018

Last update date: 18-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class TaskEdit_Page extends Home_Page {

	By viewLnk = By.name("tabView");

	By idTxt = By.name("txtId");
	By opportunityId = By.name("txtIdopportunity");
	By masterTaskId = By.name("txtIdmaster");
	By requesterDpx = By.name("selIdrequester");

	By squadDpx = By.name("selDefsquad");
	By ownerDpx = By.name("selIdowner");

	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By classDpx = By.name("selDeftype");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By previewedEffortTxt = By.name("txtEffort");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By linkSOPTxa = By.name("txaSopurl");
	By SOPApprovedNoRdb = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(18) > td:nth-child(2) > input:nth-child(1)");
	By SOPApprovedYesRdb = By.cssSelector("input.enabled:nth-child(2)");

	By currentStatusDpx = By.name("selDefstatus");
	By previousStatusDpx = By.name("selLaststatus");
	By currentEffortTxt = By.name("txtReffort");
	By dueDateDtf = By.name("txtDatedue");
	By percentageCompletedTxt = By.name("txtPercompleted");

	By createdDtf = By.name("txtDatecreation");
	By approvedDft = By.name("txtDateapproval");
	By startedDtf = By.name("txtDatestarted");

	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

Selenium_Engine selEngine;
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	
	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}

	public boolean compareMasterTaskId(String strMasterTaskId) {
		return selEngine.compareText(masterTaskId, strMasterTaskId);
	}

	public boolean compareOpportunityId(String strOpportunityId) {
		return selEngine.compareText(opportunityId, strOpportunityId);
	}

	public boolean compareRequester(String strRequester) {
		return selEngine.compareText(requesterDpx, strRequester);
	}

	public boolean compareSquad(String strSquad) {
		return selEngine.compareText(squadDpx, strSquad);
	}

	public boolean compareOwner(String strOwner) {
		return selEngine.compareText(ownerDpx, strOwner);
	}

	public boolean compareCountry(String strCountry) {
		return selEngine.compareText(targetCountryDpx, strCountry);
	}

	public boolean compareAccount(String strAccount) {
		return selEngine.compareText(targetAccountDpx, strAccount);
	}

	public boolean compareEnvironment(String strEnvironment) {
		return selEngine.compareText(environmentDpx, strEnvironment);
	}

	public boolean compareClass(String strClass) {
		return selEngine.compareText(classDpx, strClass);
	}

	public boolean comparePriority(String strPriority) {
		return selEngine.compareText(priorityDpx, strPriority);
	}

	public boolean compareComplexity(String strComplexity) {
		return selEngine.compareText(complexityDpx, strComplexity);
	}

	public boolean comparePreviewedEffort(String strPreviewedEffort) {
		return selEngine.compareText(previewedEffortTxt, strPreviewedEffort);
	}

	public boolean compareSummary(String strSummary) {
		return selEngine.compareText(summaryTxt, strSummary);
	}

	public boolean compareDescription(String strDescription) {
		return selEngine.compareText(descriptionTxa, strDescription);
	}

	public boolean compareCurrentStatus(String strCurrentStatus) {
		return selEngine.compareText(currentStatusDpx, strCurrentStatus);
	}

	public boolean comparePreviousStatus(String strPreviousStatus) {
		return selEngine.compareText(previousStatusDpx, strPreviousStatus);
	}

	public boolean compareCurrentEffort(String strCurrentEffort) {
		return selEngine.compareText(currentEffortTxt, strCurrentEffort);
	}

	public boolean compareDueDate(String strDueDate) {
		return selEngine.compareText(dueDateDtf, strDueDate);
	}

	public boolean comparePercentualCompleted(String strPercentualCompleted) {
		return selEngine.compareText(percentageCompletedTxt, strPercentualCompleted);
	}

	public boolean compareCreatedDate(String strCreatedDate) {
		return selEngine.compareText(createdDtf, strCreatedDate);
	}

	public boolean compareApprovedDate(String strApprovedDate) {
		return selEngine.compareText(approvedDft, strApprovedDate);
	}

//	public boolean compareDateCreation(String strDateCreation) {
//		return selEngine.compareText(creationDateDtf, strDateCreation);
//	}

	public boolean compareStartedDate(String strStartedDate) {
		return selEngine.compareText(startedDtf, strStartedDate);
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

	public void setEnvironment(String strEnvironment) {
		selEngine.selectDropDown(environmentDpx, strEnvironment);
	}

	public void setPriority(String strPriority) {
		selEngine.selectDropDown(priorityDpx, strPriority);
	}

	public void setComplexity(String strComplexity) {
		selEngine.selectDropDown(complexityDpx, strComplexity);
	}

	public void setPreviewedEffort(String strPreviewedEffort) {
		selEngine.setTextbox(previewedEffortTxt, strPreviewedEffort);
	}

	public void setSummary(String strSummary) {
		selEngine.setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		selEngine.setTextbox(descriptionTxa, strDescription);
	}

	public void setDueDate(String strDueDate) {
		selEngine.setTextbox(dueDateDtf, strDueDate);
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
