/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 10-oct-2018
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
	By idFlt = By.linkText("id");
	By nameFlt = By.linkText("name");
	By countryFlt = By.linkText("country");
	By statusFlt = By.linkText("status");
	By firstItemLnk = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]");

	public void clickMagnifierFilter() {
		Selenium_Engine.click(magnifierFlt);
	}

	public void clickPreviousButton() {
		Selenium_Engine.click(previousBtn);
	}

	public void clickNewButton() {
		Selenium_Engine.click(newBtn);
	}

	public void clickCloseButton() {
		Selenium_Engine.click(closeBtn);
	}

	public void clickNextButton() {
		Selenium_Engine.click(nextBtn);
	}

	public void clickIdFilter() {
		Selenium_Engine.click(idFlt);
	}

	public void clickNameFilter() {
		Selenium_Engine.click(nameFlt);
	}

	public void clickCountryFilter() {
		Selenium_Engine.click(countryFlt);
	}

	public void clickStatusFilter() {
		Selenium_Engine.click(statusFlt);
	}

	public void clickFirstItemLink() {
		Selenium_Engine.click(firstItemLnk);
	}

	public void doubleClickIdFilter() {
		Selenium_Engine.doubleClick(idFlt);
	}

	public void doubleClickNameFilter() {
		Selenium_Engine.doubleClick(nameFlt);
	}

	public void doubleClickCountryFilter() {
		Selenium_Engine.doubleClick(countryFlt);
	}

	public void doubleClickStatusFilter() {
		Selenium_Engine.doubleClick(statusFlt);
	}
}
