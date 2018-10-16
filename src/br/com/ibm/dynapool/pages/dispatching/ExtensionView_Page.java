/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 15-oct-2018

Last update date: 16-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ibm.dynapool.pages.Home_Page;

public class ExtensionView_Page extends Home_Page {

	WebDriver driver;

	By editLnk = By.name("tabEdit");

	By taskIdTxt = By.name("txtIdtask");
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By priorityDpx = By.name("selDefpriority");
	By ownerDpx = By.name("selIdowner");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By dueDateDtf = By.name("txtDatedue");

	By idTxt = By.name("txtId");
	By createdDtf = By.name("txtDatecreation");
	By reasonTxa = By.name("txaReason");
	By suggestedDateDtf = By.name("txtDatesuggested");

	By reviewedDateDtf = By.name("txtDatereview");
	By statusDpx = By.name("selDefstatus");
	By justificationTxa = By.name("txaReasonreject");

	By approveBtn = By.name("btnApprove");
	By rejectBtn = By.name("btnReject");
	By closeBtn = By.name("btnClose");
	By deleteBtn = By.name("btnDelete");

	public void clickEditTab() {
		selEngine.click(editLnk);
	}

	public int getIntegerTaskId(By idTxt) {
		return Integer.parseInt(driver.findElement(idTxt).getText());
	}

	public int getIntegerId(By opportunityId) {
		return Integer.parseInt(driver.findElement(opportunityId).getText());
	}

	public boolean compareTaskId(String strTaskId) {
		return selEngine.compareText(idTxt, strTaskId);
	}

	public boolean compareCountry(String strCountry) {
		return selEngine.compareText(targetCountryDpx, strCountry);
	}

	public boolean compareAccount(String strAccount) {
		return selEngine.compareText(targetAccountDpx, strAccount);
	}

	public boolean comparePriority(String strPriority) {
		return selEngine.compareText(priorityDpx, strPriority);
	}

	public boolean compareOwner(String strOwner) {
		return selEngine.compareText(ownerDpx, strOwner);
	}

	public boolean compareSummary(String strSummary) {
		return selEngine.compareText(summaryTxt, strSummary);
	}

	public boolean compareDescription(String strDescription) {
		return selEngine.compareText(descriptionTxa, strDescription);
	}

	public boolean compareDueDate(String strDueDate) {
		return selEngine.compareText(dueDateDtf, strDueDate);
	}

	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}

	public boolean compareCreatedDate(String strCreatedDate) {// MM/dd/yyyy hh:mm:ss
		return selEngine.compareText(createdDtf, strCreatedDate);
	}

	public boolean compareReason(String strReason) {
		return selEngine.compareText(reasonTxa, strReason);
	}

	public boolean compareSuggestedDate(String strSuggestedDate) {// MM/dd/yyyy
		return selEngine.compareText(suggestedDateDtf, strSuggestedDate);
	}

	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}

	public boolean compareJustification(String strJustification) {
		return selEngine.compareText(justificationTxa, strJustification);
	}

	public void clickApproveButton() {
		selEngine.click(approveBtn);
	}

	public void clickRejectButton() {
		selEngine.click(rejectBtn);
	}

	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}

	public void clickDeleteButton() {
		selEngine.click(deleteBtn);
	}

}
