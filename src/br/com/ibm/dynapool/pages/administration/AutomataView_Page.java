/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 26-nov-2018

Last update date: 26-nov-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class AutomataView_Page {
	By editLnk = By.name("tabEdit");

	By idTxt = By.name("txtId");
	By nameTxt = By.name("txtName");
	By environmentDpx = By.name("selDefenvironment");

	By closeBtn = By.name("btnClose");
	By deleteBtn = By.name("btnDelete");

	Selenium_Engine selEngine = new Selenium_Engine();

	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}

	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}

	public boolean compareName(String strName) {
		return selEngine.compareText(nameTxt, strName);
	}

	public boolean compareEnvironment(String strEnvironment) {
		return selEngine.compareText(environmentDpx, strEnvironment);
	}

	public String getId() {
		return selEngine.getAttribute(idTxt, "value");
	}

	public void clickEditTab() {
		selEngine.click(editLnk);
	}

	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}

	public void clickDeleteButton() {
		selEngine.click(deleteBtn);
	}
}
