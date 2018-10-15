/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 11-oct-2018

Last update date: 15-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ibm.dynapool.pages.Home_Page;

public class MasterTaskView_Page extends Home_Page {

	WebDriver driver;

	By editLnk = By.name("tabEdit");

	By idTxt = By.name("txtId");

	By requesterDpx = By.name("selIdrequester");

	By squadDpx = By.name("selDefsquad");
	By ownerDpx = By.name("selIdowner");

	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By classDpx = By.name("selDeftype");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By automataDpx = By.name("selAutomata");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");

	By taskSourceDpx = By.name("selDeftasksource");
	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
	By defectCategoryDpx = By.name("selDefdefectcategory");

	By approvedRdb = By.name("rdoYnapproved");
	By currentStageDpx = By.name("selDefstage");

	By statusDpx = By.name("selDefstatus");
	By createdDtf = By.name("txtDatecreation");
	By approvedDft = By.name("txtDateapproval");
	By plannedStartDateDtf = By.name("txtDatePlanning");
	By startedDtf = By.name("txtDatestarted");

	By justificationTxa = By.name("txaJustification");

	By closeBtn = By.name("btnClose");
	By deleteBtn = By.name("btnDelete");

	By firstChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[2]");
	By secondChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[3]");
	By thirdChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[4]");
	By fourthChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[5]");
	By fifthChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[6]");

	public void clickEditTab() {
		selEngine.click(editLnk);
	}

	public int getIntegerId(By by) {
		return Integer.parseInt(driver.findElement(by).getText());
	}

	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
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

	public boolean compareAutomata(String strAutomata) {
		return selEngine.compareText(automataDpx, strAutomata);
	}

	public boolean compareSummary(String strSummary) {
		return selEngine.compareText(summaryTxt, strSummary);
	}

	public boolean compareDescription(String strDescription) {
		return selEngine.compareText(descriptionTxa, strDescription);
	}

	public boolean compareTaskSource(String strTaskSource) {
		return selEngine.compareText(taskSourceDpx, strTaskSource);
	}

	public boolean compareAutomataCategory(String strAutomataCategory) {
		return selEngine.compareText(automataCategoryDpx, strAutomataCategory);
	}

	public boolean compareAlert_ServerCount(String strAlert_ServerCount) {
		return selEngine.compareText(alert_ServerCountTxt, strAlert_ServerCount);
	}

	public boolean compareDefectCategory(String strDefectCategory) {
		return selEngine.compareText(defectCategoryDpx, strDefectCategory);
	}

//	TODO
//	public boolean compareApproved(String strAttribute, String strValue) {
//		return selEngine.compareAttribute(approvedDft, strAttribute, strValue);
//	}

	public boolean compareCurrentStage(String strCurrentStage) {
		return selEngine.compareText(currentStageDpx, strCurrentStage);
	}

	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}

	public boolean compareCreatedDate(String strCreatedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(createdDtf, strCreatedDate);
	}

	public boolean compareApprovedDate(String strApprovedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(approvedDft, strApprovedDate);
	}

	public boolean comparePlannedStartDate(String strPlannedStartDate) {// MM/dd/yyyy
		return selEngine.compareText(plannedStartDateDtf, strPlannedStartDate);
	}

	public boolean compareStartedDate(String strStartedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(startedDtf, strStartedDate);
	}

	public boolean compareJustification(String strJustification) {
		return selEngine.compareText(justificationTxa, strJustification);
	}

	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}

	public void clickDeleteButton() {
		selEngine.click(deleteBtn);
	}

	public void clickFirstChildLink() {
		selEngine.click(firstChildLnk);
	}

	public void clickSecondChildLink() {
		selEngine.click(secondChildLnk);
	}

	public void clickThirdChildLink() {
		selEngine.click(thirdChildLnk);
	}

	public void clickFifthChildLink() {
		selEngine.click(fifthChildLnk);
	}

}
