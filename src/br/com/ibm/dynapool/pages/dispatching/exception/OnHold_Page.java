/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 22-oct-2018

Last update date: 29-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/
package br.com.ibm.dynapool.pages.dispatching.exception;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class OnHold_Page extends Home_Page {

	By taskIdTxt = By.name("txtIdtask");
	By aditionalEmailTxt = By.name("txtEmail");
	By categoryDpx = By.name("selDefcategory");
	By justificationTxa = By.name("txaJustification");
	By actionTxa = By.name("txaAction");
	By externalDependencyNo = By
			.cssSelector(".frmLayout > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(2) > input:nth-child(1)");
	By externalDependencyYes = By.cssSelector("input.enabled:nth-child(2)");

	By saveBtn = By.name("btnStart");
	By cancelBtn = By.name("btnCancel");
	By updateBtn = By.name("btnSave");
	By resumeBtn = By.name("btnStart");

	Selenium_Engine selEngine = new Selenium_Engine();

	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}

	public int getTaskIdTxt() {
		return selEngine.getIntegerContent(taskIdTxt);
	}

	public boolean compareTaskId(String strTaskId) {
		return selEngine.compareText(taskIdTxt, strTaskId);
	}

	public void setAditionalEmail(String strAditionalEmail) {
		selEngine.setTextbox(aditionalEmailTxt, strAditionalEmail);
	}

	public void setCategory(String strCategory) {
		selEngine.selectDropDown(categoryDpx, strCategory);
	}

	public void setJustification(String strJustification) {
		selEngine.setTextbox(justificationTxa, strJustification);
	}

	public void setAction(String strAction) {
		selEngine.setTextbox(actionTxa, strAction);
	}

	public void clickExternalDependencyNo() {
		selEngine.click(externalDependencyNo);
	}

	public void clickExternalDependencyYes() {
		selEngine.click(externalDependencyYes);
	}

	public boolean compareAditionalEmail(String strAditionalEmail) {
		return selEngine.compareText(aditionalEmailTxt, strAditionalEmail);
	}

	public boolean compareCategory(String strCategory) {
		return selEngine.compareText(categoryDpx, strCategory);
	}

	public boolean compareJustification(String strJustification) {
		return selEngine.compareText(justificationTxa, strJustification);
	}

	public boolean compareAction(String strAction) {
		return selEngine.compareText(actionTxa, strAction);
	}

	public void clickSaveButton() {
		selEngine.click(saveBtn);
	}

	public void clickCancelButton() {
		selEngine.click(cancelBtn);
	}

	public void clickUpdateButton() {
		selEngine.click(updateBtn);
	}

	public void clickResumeButton() {
		selEngine.click(resumeBtn);
	}

}
