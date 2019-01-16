/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 26-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class Login_Page extends Home_Page {

	By userName = By.name("txtUsername");
	By userPassword = By.name("txtPassword");
	By GDPRcheckbox = By.name("chkAgreement");
	By loginBtn = By.name("btnSubmit");

	Selenium_Engine selEngine = new Selenium_Engine();

	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}

	public void setUserName(String strUserName) {
		selEngine.setTextbox(userName, strUserName);
	}

	public void setUserPassword(String strUserPassword) {
		selEngine.setTextbox(userPassword, strUserPassword);
	}

	public void setGDPRcheckbox(boolean enabled) {
		selEngine.selectCheckBox(GDPRcheckbox);
	}

	public void clickLoginButton() {
		selEngine.click(loginBtn);
	}

}
