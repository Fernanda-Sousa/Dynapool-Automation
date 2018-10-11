/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 11-oct-2018

Last update date: 11-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class NonComplianceList_Page extends Home_Page {

	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By newBtn = By.name("btnNew");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.linkText("id");
	By userFlt = By.linkText("user");
	By descriptionFlt = By.linkText("description");
	By idTaskFlt = By.linkText("tsk#");
	By idOpportunityFlt = By.linkText("opp#");
	By createdFlt = By.linkText("created");
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

	public void clickUserFilter() {
		Selenium_Engine.click(userFlt);
	}

	public void clickDescriptionFilter() {
		Selenium_Engine.click(descriptionFlt);
	}

	public void clickIdTaskFilter() {
		Selenium_Engine.click(idTaskFlt);
	}

	public void clickIdOpportunityFilter() {
		Selenium_Engine.click(idOpportunityFlt);
	}

	public void clickCreatedFilter() {
		Selenium_Engine.click(createdFlt);
	}

	public void clickFirstItemLink() {
		Selenium_Engine.click(firstItemLnk);
	}

	public void doubleClickIdFilter() {
		Selenium_Engine.doubleClick(idFlt);
	}

	public void doubleClickUserFilter() {
		Selenium_Engine.doubleClick(userFlt);
	}

	public void doubleClickDescriptionFilter() {
		Selenium_Engine.doubleClick(descriptionFlt);
	}

	public void doubleClickIdTaskFilter() {
		Selenium_Engine.doubleClick(idTaskFlt);
	}

	public void doubleClickIdOpportunityFilter() {
		Selenium_Engine.doubleClick(idOpportunityFlt);
	}

	public void doubleClickCreatedFilter() {
		Selenium_Engine.doubleClick(createdFlt);
	}
}
