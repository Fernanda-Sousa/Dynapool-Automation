/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 25-oct-2018

Last update date: 25-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class TaskFilter_Page {
	
	By textSearchTxt = By.name("txtDescription");
	By idTxt = By.name("txtId");
	By ownerDpx = By.name("selIdowner");
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By areaDpx = By.name("selDefenvironment");
	By typeDpx = By.name("selDeftype");
	By stageDpx = By.name("selDefstage");
	By statusDpx = By.name("selDefstatus");
	By priorityDpx = By.name("selDefpriority");
	By dueDateDtf = By.name("txtDatedue");

	By requesterInternalDpx = By.name("selIdrequester");
	By requesterExtNameTxt = By.name("txtRequestername");
	By requesterExtEmailTxt = By.name("txtRequestermail");
	By approvalDateFromDtf = By.id("dateFromPeriod");
	By approvalDateToDtf = By.id("dateToPeriod");

	By applyBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnClear");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void setTextSearch(String strTextSearch) {
		selEngine.setTextbox(textSearchTxt, strTextSearch);
	}
	
	public void setId(String strId) {
		selEngine.setTextbox(idTxt, strId);
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
	
	public void setType(String strType) {
		selEngine.selectDropDown(typeDpx, strType);
	}
	
	public void setStage(String strStage) {
		selEngine.selectDropDown(stageDpx, strStage);
	}
	
	public void setStatus(String strStatus) {
		selEngine.selectDropDown(statusDpx, strStatus);
	}
	
	public void setPriority(String strPriority) {
		selEngine.selectDropDown(priorityDpx, strPriority);
	}
	
	public void setDueDate(String strDueDate) {
		selEngine.click(dueDateDtf);
		selEngine.setTextbox(dueDateDtf, strDueDate);
		selEngine.click(By.tagName("label"));
	}
	
	public void setRequesterInternal(String strRequesterInternal) {
		selEngine.selectDropDown(requesterInternalDpx, strRequesterInternal);
	}
	
	public void setRequesterExtName(String strRequesterExtName) {
		selEngine.setTextbox(requesterExtNameTxt, strRequesterExtName);
	}
	
	public void setRequesterExtEmail(String strRequesterExtEmail) {
		selEngine.setTextbox(requesterExtEmailTxt, strRequesterExtEmail);
	}
	
	public void setApprovalDateFrom(String strApprovalDateFrom) {
		selEngine.click(approvalDateFromDtf);
		selEngine.setTextbox(approvalDateFromDtf, strApprovalDateFrom);
		selEngine.click(By.tagName("label"));
	}
	
	public void setApprovalDateTo(String strApprovalDateTo) {
		selEngine.click(approvalDateToDtf);
		selEngine.setTextbox(approvalDateToDtf, strApprovalDateTo);
		selEngine.click(By.tagName("label"));
	}
	
	public void clickApplyButton() {
		selEngine.click(applyBtn);
	}
	
	public void clickClearButton() {
		selEngine.click(clearBtn);
	}
}
