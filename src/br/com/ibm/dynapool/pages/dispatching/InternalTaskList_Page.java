/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 10-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class InternalTaskList_Page {

	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.linkText("id");
	By summaryFlt = By.linkText("summary");
	By squadFlt = By.linkText("squad");
	By ownerFlt = By.linkText("owner");
	By contryFlt = By.linkText("contry");
	By accountFlt = By.linkText("account");
	By areaFlt = By.linkText("area");
	By approvedFlt = By.linkText("approved");
	By dueDateFlt = By.linkText("due date");
	By stageFlt = By.linkText("stage");
	By typeFlt = By.linkText("type");
	By priorityFlt = By.linkText("priority");
	By lastStatusFlt = By.linkText("last status");
	By statusFlt = By.linkText("status");
	By exportExcelBtn = By.linkText("export excel");
	By firstItemLnk = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]");

	public void clickMagnifierFilter() {
		Selenium_Engine.click(magnifierFlt);
	}

	public void clickPreviousButton() {
		Selenium_Engine.click(previousBtn);
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

	public void clickSummaryFilter() {
		Selenium_Engine.click(summaryFlt);
	}

	public void clickSquadFilter() {
		Selenium_Engine.click(squadFlt);
	}

	public void clickOwnerFilter() {
		Selenium_Engine.click(ownerFlt);
	}

	public void clickContryFilter() {
		Selenium_Engine.click(contryFlt);
	}

	public void clickAccountFilter() {
		Selenium_Engine.click(accountFlt);
	}

	public void clickAreaFilter() {
		Selenium_Engine.click(areaFlt);
	}

	public void clickApprovedFilter() {
		Selenium_Engine.click(approvedFlt);
	}

	public void clickDueDateFilter() {
		Selenium_Engine.click(dueDateFlt);
	}

	public void clickPriorityFilter() {
		Selenium_Engine.click(priorityFlt);
	}

	public void clickLastStatusFilter() {
		Selenium_Engine.click(lastStatusFlt);
	}

	public void clickStatusFilter() {
		Selenium_Engine.click(statusFlt);
	}

	public void clickExportExcelButton() {
		Selenium_Engine.click(exportExcelBtn);
	}

	public void clickFirstItemLink() {
		Selenium_Engine.click(firstItemLnk);
	}

	public void doubleClickIdFilter() {
		Selenium_Engine.doubleClick(idFlt);
	}

	public void doubleClickSummaryFilter() {
		Selenium_Engine.doubleClick(summaryFlt);
	}

	public void doubleClickSquadFilter() {
		Selenium_Engine.doubleClick(squadFlt);
	}

	public void doubleClickOwnerFilter() {
		Selenium_Engine.doubleClick(ownerFlt);
	}

	public void doubleClickContryFilter() {
		Selenium_Engine.doubleClick(contryFlt);
	}

	public void doubleClickAccountFilter() {
		Selenium_Engine.doubleClick(accountFlt);
	}

	public void doubleClickAreaFilter() {
		Selenium_Engine.doubleClick(areaFlt);
	}

	public void doubleClickApprovedFilter() {
		Selenium_Engine.doubleClick(approvedFlt);
	}

	public void doubleClickDueDateFilter() {
		Selenium_Engine.doubleClick(dueDateFlt);
	}

	public void doubleClickPriorityFilter() {
		Selenium_Engine.doubleClick(priorityFlt);
	}

	public void doubleClickLastStatusFilter() {
		Selenium_Engine.doubleClick(lastStatusFlt);
	}

	public void doubleClickStatusFilter() {
		Selenium_Engine.doubleClick(statusFlt);
	}
}
