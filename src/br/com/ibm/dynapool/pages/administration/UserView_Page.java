/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 03-dec-2018

Last update date: 26-dec-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class UserView_Page extends Home_Page {

	By editTab = By.xpath("/html/body/div[1]/div[2]/div[1]/input[2]");
	By accessTab = By.xpath("/html/body/div[1]/div[2]/div[1]/input[3]");
	
	By idTxt = By.name("txtId");
	By nameTxt = By.name("txtName");
	By emailLnk = By.partialLinkText("mailto");
	By statusDpx = By.name("selDefstatus");
	
	By numberVisitsTxt = By.name("txtCounter");
	By lastVisitDtf = By.name("txtLastvisit");
	
	By closeBtn = By.name("btnClose");
	By deleteBtn = By.name("btnDelete");
	
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
	
	public String getStatus() {
		return selEngine.getAttribute(statusDpx, "value");
	}
	
	public String getNumberVisits() {
		return selEngine.getAttribute(numberVisitsTxt, "value");
	}
	
	public String getLastVisit() {
		return selEngine.getAttribute(lastVisitDtf, "value");
	}
	
	public void clickEditTab() {
		selEngine.click(editTab);
	}
	
	public void clickAccessTab() {
		selEngine.click(accessTab);
	}
	
	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}
	
	public void clickDeleteButton() {
		selEngine.click(deleteBtn);
	}
}
