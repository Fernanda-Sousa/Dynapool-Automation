/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 22-oct-2018

Last update date: 22-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class ExtensionEdit_Page {

	By viewLnk = By.name("tabView");

	By idTxt = By.name("txtId");
	By taskIdTxt = By.name("txtIdtask");
	By createdDtf = By.name("txtDatecreation");
	By reasonTxa = By.name("txaReason");
	By suggestedDateDtf = By.name("txtDatesuggested");

	By statusDpx = By.name("selDefstatus");

	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

	Selenium_Engine selEngine;

	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}

	public void clickViewTab() {
		selEngine.click(viewLnk);
	}

	public int getId() {
		return selEngine.getIntegerContent(idTxt);
	}

	public int getTaskId() {
		return selEngine.getIntegerContent(taskIdTxt);
	}

	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}

	public boolean compareTaskId(String strTaskId) {
		return selEngine.compareText(taskIdTxt, strTaskId);
	}

	public boolean compareCreated(String strCreated) {// mm/dd/yyyy hh:mm:ss
		return selEngine.compareText(createdDtf, strCreated);
	}

	public boolean compareReason(String strReason) {
		return selEngine.compareText(reasonTxa, strReason);
	}

	public boolean compareSuggestedDate(String strSuggestedDate) {
		return selEngine.compareText(suggestedDateDtf, strSuggestedDate);
	}

	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}

	public void setReason(String strReason) {
		selEngine.setTextbox(reasonTxa, strReason);
	}

	public void setSuggestedDate(String strSuggestedDate) {
		selEngine.click(suggestedDateDtf);
		selEngine.setTextbox(suggestedDateDtf, strSuggestedDate);
		selEngine.click(By.tagName("h2"));
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
