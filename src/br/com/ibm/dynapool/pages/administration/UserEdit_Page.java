/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 29-nov-2018

Last update date: 03-dec-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class UserEdit_Page  extends Home_Page{
	
	By idTxt = By.name("txtId");
	By nameTxt = By.name("txtName");
	By emailTxt = By.name("txtEmail");
	By statusDpx = By.name("selDefstatus");
	
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By closeBtn = By.name("btnClose");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public String getId() {
		return selEngine.getAttribute(idTxt, "value");
	}
	
	public void setName(String strName) {
		selEngine.setTextbox(nameTxt, strName);
	}
	
	public void setEmail(String strEmail) {
		selEngine.setTextbox(emailTxt, strEmail);
	}
	
	public void setStatus(String strStatus) {
		selEngine.selectDropDown(statusDpx, strStatus);
	}
	
	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}
	
	public boolean compareName(String strName) {
		return selEngine.compareText(nameTxt, strName);
	}
	
	public boolean compareEmail(String strEmail) {
		return selEngine.compareText(emailTxt, strEmail);
	}
	
	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}
	
	public void clickSaveButton() {
		selEngine.click(saveBtn);
	}
	
	public void clickClearButton() {
		selEngine.click(clearBtn);
	}
	
	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}
}
