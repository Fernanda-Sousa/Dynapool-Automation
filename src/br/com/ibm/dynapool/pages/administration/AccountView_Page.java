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

public class AccountView_Page extends Home_Page{

	By editLnk = By.name("tabEdit");
	
	By idTxt = By.name("txtId");
	By nameTxt = By.name("txtName");
	By countryDpx = By.name("selDefcountry");
	By statusDpx = By.name("selStatus");
	
	By closeBtn = By.name("btnClose");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void clickEditTab() {
		selEngine.click(editLnk);
	}
	
	public String getId() {
		return selEngine.getAttribute(idTxt, "value");
	}
	
	public boolean compareName(String strName) {
		return selEngine.compareText(nameTxt, strName);
	}
	
	public boolean compareCountry(String strCountry) {
		return selEngine.compareText(countryDpx, strCountry);
	}
	
	public boolean compareStatus(String strStatus) {
		return selEngine.compareText(statusDpx, strStatus);
	}
	
	public void clickClose() {
		selEngine.click(closeBtn);
	}
}
