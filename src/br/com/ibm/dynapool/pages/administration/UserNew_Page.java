/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 29-nov-2018

Last update date: 30-nov-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class UserNew_Page extends Home_Page{

	By nameTxt = By.name("txtName");
	By emailTxt = By.name("txtEmail");
	
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By closeBtn = By.name("btnClose");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void setName(String strName) {
		selEngine.setTextbox(nameTxt, strName);
	}
	
	public void setEmail(String strEmail) {
		selEngine.selectDropDown(emailTxt, strEmail);
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
