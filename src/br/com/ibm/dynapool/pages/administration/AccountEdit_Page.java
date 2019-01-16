/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 14-nov-2018

Last update date: 14-nov-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class AccountEdit_Page extends Home_Page{

	By viewLnk = By.name("tabView");
	
	By idTxt = By.name("txtId");
	By nameTxt = By.name("txtName");
	By countryDpx = By.name("selDefcountry");
	By statusDpx = By.name("selStatus");
	
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void clickViewTab() {
		selEngine.click(viewLnk);
	}
	
	public String getId() {
		return selEngine.getAttribute(idTxt, "value");
	}
	
	public void setName(String strName) {
		selEngine.setTextbox(nameTxt, strName);
	}

	public void setCountry(String strCountry) {
		selEngine.selectDropDown(countryDpx, strCountry);
	}
	
	public void setStatus(String strStatus) {
		selEngine.selectDropDown(statusDpx, strStatus);
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

