package br.com.ibm.dynapool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import br.com.ibm.dynapool.engine.Selenium_Engine;


public class Login_page {

	WebDriver driver;
	By userName = By.name("txtUsername");
	By userPassword = By.name("txtPassword");
	By GDPRcheckbox = By.name("chkAgreement");
	By loginBtn = By.name("btnSubmit");

	Selenium_Engine engine = new Selenium_Engine();

	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}

	public void setUserPassword(String strUserPassword) {
		engine.setTextbox(userPassword, strUserPassword);
	}

	public void setGDPRcheckbox(boolean enabled) {
		engine.selectCheckBox(GDPRcheckbox);
	}
	
	public void clickLoginButton() {
		engine.click(loginBtn);
	}

}
