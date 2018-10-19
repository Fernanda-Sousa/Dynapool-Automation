/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 11-oct-2018

Last update date: 11-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class UserList_Page extends Home_Page{

	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By newBtn = By.name("btnNew");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.linkText("id");
	By nameFlt = By.linkText("name");
	By emailFlt = By.linkText("email");
	By statusFlt = By.linkText("status");
	By roleFlt = By.linkText("role");
	By firstItemLnk = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]");

Selenium_Engine selEngine;
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	
	public void clickMagnifierFilter() {
		selEngine.click(magnifierFlt);
	}

	public void clickPreviousButton() {
		selEngine.click(previousBtn);
	}

	public void clickNewButton() {
		selEngine.click(newBtn);
	}

	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}

	public void clickNextButton() {
		selEngine.click(nextBtn);
	}

	public void clickIdFilter() {
		selEngine.click(idFlt);
	}

	public void clickNameFilter() {
		selEngine.click(nameFlt);
	}

	public void clickEmailFilter() {
		selEngine.click(emailFlt);
	}

	public void clickStatusFilter() {
		selEngine.click(statusFlt);
	}

	public void clickRoleFilter() {
		selEngine.click(roleFlt);
	}

	public void clickFirstItemLink() {
		selEngine.click(firstItemLnk);
	}

	public void doubleClickIdFilter() {
		selEngine.doubleClick(idFlt);
	}

	public void doubleClickNameFilter() {
		selEngine.doubleClick(nameFlt);
	}

	public void doubleClickEmailFilter() {
		selEngine.doubleClick(emailFlt);
	}

	public void doubleClickStatusFilter() {
		selEngine.doubleClick(statusFlt);
	}

	public void doubleClickRoleFilter() {
		selEngine.doubleClick(emailFlt);
	}
}
