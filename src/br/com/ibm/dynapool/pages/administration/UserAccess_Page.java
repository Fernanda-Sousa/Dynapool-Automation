/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 03-dec-2018

Last update date: 03-dec-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class UserAccess_Page extends Home_Page {
	
	By idTxt = By.name("txtId");
	By nameTxt = By.name("txtName");
	By emailLnk = By.partialLinkText("mailto");
	
	By nicknameTxt = By.name("txtNickame");
	By accessLevelDpx = By.name("selRole");
	
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
	
	public String getName() {
		return selEngine.getAttribute(nameTxt, "value");
	}
	
	public String getEmail() {
		return selEngine.getAttribute(emailLnk, "value");
	}
	
	public void setNickname(String strNickname) {
		selEngine.setTextbox(nicknameTxt, strNickname);
	}
	
	public void setAccessLevel(String strAccessLevel) {
		selEngine.selectDropDown(accessLevelDpx, strAccessLevel);
	}
	
	public void clickSaveButton() {
		selEngine.click(saveBtn);
	}
	
	public void clickClearButton() {
		selEngine.click(clearBtn);
	}
	
	public void clickCancelButton() {
		selEngine.click(closeBtn);
	}
}
