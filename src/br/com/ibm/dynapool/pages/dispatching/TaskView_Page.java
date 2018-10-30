/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 15-oct-2018

Last update date: 30-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class TaskView_Page extends Home_Page {

	WebDriver driver;

	By editLnk = By.name("tabEdit");

	By idTxt = By.name("txtId");
	By opportunityId = By.name("txtIdopportunity");
	By openOpprtunity = By.name("btnIdopportunity");
	By masterTaskId = By.name("txtIdmaster");
	By openMasterTask = By.name("btnIdmaster");

	By requesterDpx = By.name("selIdrequester");

	By squadDpx = By.name("selDefsquad");
	By ownerDpx = By.name("selIdowner");

	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By stageDpx = By.name("selDefstage");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By previewedEffortTxt = By.name("txtEffort");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By approvedRdb = By.name("rdoYnapproved");
//TODO	By SOPApprovedRdb = By.name("rdoYnapproved"); 
	By linkToSOPTxa = By.name("txaSopurl");

	By currentStatusDpx = By.name("selDefstatus");
	By sinceDtf = By.name("selDefstatus");
	By previousStatusDpx = By.name("selLaststatus");
	By currentEffortTxt = By.name("txtReffort");
	By dueDateDtf = By.name("txtDatedue");
	By percentageCompletedTxt = By.name("txtPercompleted");

	By createdDtf = By.name("txtDatecreation");
	By approvedDft = By.name("txtDateapproval");
	By discussionTxa = By.name("txaReason");

	By updateBtn = By.name("btnSave");
	By skipBtn = By.name("btnSkip");
	By startBtn = By.name("btnStart");
	By extensionBtn = By.name("btnExtension");
	By resolveBtn = By.name("btnResolve");
	By closeBtn = By.name("btnClose");
	By onHoldBtn = By.name("btnHold");
	By resumeOnHoldBtn = By.name("btnHold");

	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void setLinkSOP(String strLinkSOP) {
		selEngine.setTextbox(linkToSOPTxa, strLinkSOP);
	}
	
	public void setDiscussion(String strDiscussion) {
		selEngine.setTextbox(discussionTxa, strDiscussion);
	}
	
	public void setCurrentEffort(String strCurrentEffort) {
		selEngine.setTextbox(currentEffortTxt, strCurrentEffort);
	}
	
	public void setPercentageCompleted(String strPercentageCompleted) {
		selEngine.setTextbox(percentageCompletedTxt, strPercentageCompleted);
	}
	
	public void clickEditTab() {
		selEngine.click(editLnk);
	}

	public void clickOpenOpportunity() {
		selEngine.click(openOpprtunity);
	}

	public void clickOpenMasterTask() {
		selEngine.click(openMasterTask);
	}

	public int getIntegerId(By idTxt) {
		return Integer.parseInt(driver.findElement(idTxt).getText());
	}

	public int getIntegerIdOpportunity(By opportunityId) {
		return Integer.parseInt(driver.findElement(opportunityId).getText());
	}

	public int getIntegerIdMaster(By masterTaskId) {
		return Integer.parseInt(driver.findElement(masterTaskId).getText());
	}
	
	public String getId() {
		return selEngine.getAttribute(idTxt, "value");
	}

	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}

	public boolean compareOpportunityId(String strOpportunityId) {
		return selEngine.compareText(opportunityId, strOpportunityId);
	}
	
	public boolean compareMasterId(String strMasterId) {
		return selEngine.compareText(masterTaskId, strMasterId);
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

	public boolean compareStage(String strStage) {
		return selEngine.compareText(stageDpx, strStage);
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

//	TODO
//	public boolean compareApproved(String strAttribute, String strValue) {
//		return selEngine.compareAttribute(approvedDft, strAttribute, strValue);
//	}
//	
//	public boolean compareSOPApproved(By approvedRdb, String attribute, String text) {
//		return selEngine.compareAttribute(approvedRdb, strTaskSource);
//	}

	public boolean compareCurrentStatus(String strCurrentStatus) {
		return selEngine.compareText(currentStatusDpx, strCurrentStatus);
	}

	public boolean compareSinceDate(String strSinceDate) {
		return selEngine.compareText(sinceDtf, strSinceDate);
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
	
	public boolean comparePercentagemCompleted(String strPercentageCompleted) {
		return selEngine.compareText(percentageCompletedTxt, strPercentageCompleted);
	}
	
	public boolean compareCreatedDate(String strCreatedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(createdDtf, strCreatedDate);
	}

	public boolean compareApprovedDate(String strApprovedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(approvedDft, strApprovedDate);
	}

	public boolean compareDiscussion(String strDiscussion) {
		return selEngine.compareText(discussionTxa, strDiscussion);
	}
	
	public void clickUpdateButton() {
		selEngine.click(updateBtn);
	}
	
	public void clickSkipButton() {
		selEngine.click(skipBtn);
	}
	
	public void clickStartButton() {
		selEngine.click(startBtn);
	}

	public void clickExtensionButton() {
		selEngine.click(extensionBtn);
	}
	
	public void clickResolveButton() {
		selEngine.click(resolveBtn);
	}
	
	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}
	
	public void clickOnHoldButton() {
		selEngine.click(onHoldBtn);
	}
	
	public void clickResumeOnHoldButton() {
		selEngine.click(resumeOnHoldBtn);
	}
}
