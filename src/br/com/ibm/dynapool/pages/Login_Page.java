package br.com.ibm.dynapool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class Login_Page {

	WebDriver driver;
	By userName = By.name("txtUsername");
	By userPassword = By.name("txtPassword");
	By GDPRcheckbox = By.name("chkAgreement");
	By loginBtn = By.name("btnSubmit");

	public void setUserName(String strUserName) {
		Selenium_Engine.setTextbox(userName, strUserName);
	}

	public void setUserPassword(String strUserPassword) {
		Selenium_Engine.setTextbox(userPassword, strUserPassword);
	}

	public void setGDPRcheckbox(boolean enabled) {
		Selenium_Engine.selectCheckBox(GDPRcheckbox);
	}

	public void clickLoginButton() {
		Selenium_Engine.click(loginBtn);
	}

}
