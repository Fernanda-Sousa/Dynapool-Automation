/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 14-nov-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class AccountList_Page extends Home_Page{
		
	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By newBtn = By.name("btnNew");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/th[1]/a");
	By nameFlt = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/th[2]/a");
	By countryFlt = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/th[3]/a");
	By statusFlt = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/th[4]/a");
	By firstItemLnk = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]");

	Selenium_Engine selEngine = new Selenium_Engine();
	
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

	public void clickCountryFilter() {
		selEngine.click(countryFlt);
	}

	public void clickStatusFilter() {
		selEngine.click(statusFlt);
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

	public void doubleClickCountryFilter() {
		selEngine.doubleClick(countryFlt);
	}

	public void doubleClickStatusFilter() {
		selEngine.doubleClick(statusFlt);
	}
}
