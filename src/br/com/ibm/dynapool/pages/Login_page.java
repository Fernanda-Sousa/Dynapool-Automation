package br.com.ibm.dynapool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import br.com.ibm.dynapool.engine.*;

public class Login_page{

	WebDriver driver;
	By userName = By.name("");
	By userPassword = By.name("");
	By titleText = By.className("");
	By loginBtn = By.name("");

	public Login_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}
	
	public void setUserPassword(String strUserPassword) {
		driver.findElement(userPassword).sendKeys(strUserPassword);
	}

}
