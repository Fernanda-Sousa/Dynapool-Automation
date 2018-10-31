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

public class OpportunityView_Page extends Home_Page {

	WebDriver driver;

	By editLnk = By.name("tabEdit");

	By idTxt = By.name("txtId");

	By requesterDpx = By.name("selIdrequester");

	By squadDpx = By.name("selDefsquad");
	By ownerDpx = By.name("selIdowner");

	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By priorityDpx = By.name("selDefpriority");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
//TODO	By SME_ClientContactTxt = By.name("txtAccountsme");

	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
	By expectedSavingsTxt = By.name("txtSavings");
	By costsAvoidedTxt = By.name("txtCostavoid");
	By complexityDpx = By.name("selDefcomplexity");

	By statusDpx = By.name("selDefstatus");
	By currentStageDpx = By.name("selDefstage");

	By createdDtf = By.name("txtDatecreation");
	By approvedDft = By.name("txtDateapproval");

	By justificationTxa = By.name("txaJustification");

	By closeBtn = By.name("btnClose");
	By invalidateBtn = By.name("btnInvalidate");
	By deleteBtn = By.name("btnDelete");

	By firstChildLnk = By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[2]");
	By secondChildLnk = By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[3]");
	By thirdChildLnk = By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[4]");
	By fourthChildLnk = By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[5]");
	By fifthChildLnk = By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[6]");

	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void clickEditTab() {
		selEngine.click(editLnk);
	}

	public int getIntegerId() {
		return selEngine.getIntegerContent(idTxt);
	}
	
	public String getId() {
		return selEngine.getAttribute(idTxt, "value");
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

	public boolean comparePriority(String strPriority) {
		return selEngine.compareText(priorityDpx, strPriority);
	}

	public boolean compareSummary(String strSummary) {
		return selEngine.compareText(summaryTxt, strSummary);
	}

	public boolean compareDescription(String strDescription) {
		return selEngine.compareText(descriptionTxa, strDescription);
	}

//TODO public boolean compareSME_ClientContact(String strSME_ClientContact) {
//		return selEngine.compareText(SME_ClientContactTxt, strSME_ClientContact);
//	}
	
	public boolean compareAutomataCategory(String strAutomataCategory) {
		return selEngine.compareText(automataCategoryDpx, strAutomataCategory);
	}

	public boolean compareAlert_ServerCount(String strAlert_ServerCount) {
		return selEngine.compareText(alert_ServerCountTxt, strAlert_ServerCount);
	}

	public boolean compareExpectedSavings(String strExpectedSavings) {
		return selEngine.compareText(expectedSavingsTxt, strExpectedSavings);
	}

	public boolean compareCostsAvoided(String strCostsAvoided) {
		return selEngine.compareText(costsAvoidedTxt, strCostsAvoided);
	}

	public boolean compareComplexity(String strComplexity) {
		return selEngine.compareText(complexityDpx, strComplexity);
	}

	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}

	public boolean compareCurrentStage(String strCurrentStage) {
		return selEngine.compareText(currentStageDpx, strCurrentStage);
	}

	public boolean compareCreatedDate(String strCreatedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(createdDtf, strCreatedDate);
	}

	public boolean compareApprovedDate(String strApprovedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(approvedDft, strApprovedDate);
	}

	public boolean compareJustification(String strJustification) {
		return selEngine.compareText(justificationTxa, strJustification);
	}

	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}

	public void clickInvalidateButton() {
		selEngine.click(invalidateBtn);
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
	
	public void clickFourthChildLnk() {
		selEngine.click(fourthChildLnk);
	}

	public void clickFifthChildLink() {
		selEngine.click(fifthChildLnk);
	}
}
