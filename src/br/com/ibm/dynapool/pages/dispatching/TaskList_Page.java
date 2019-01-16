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
import br.com.ibm.dynapool.pages.Home_Page;


public class TaskList_Page extends Home_Page{

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

	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}

	public void clickNextButton() {
		selEngine.click(nextBtn);
	}

	public void clickIdFilter() {
		selEngine.click(idFlt);
	}

	public void clickSummaryFilter() {
		selEngine.click(summaryFlt);
	}

	public void clickSquadFilter() {
		selEngine.click(squadFlt);
	}

	public void clickOwnerFilter() {
		selEngine.click(ownerFlt);
	}

	public void clickContryFilter() {
		selEngine.click(contryFlt);
	}

	public void clickAccountFilter() {
		selEngine.click(accountFlt);
	}

	public void clickAreaFilter() {
		selEngine.click(areaFlt);
	}

	public void clickApprovedFilter() {
		selEngine.click(approvedFlt);
	}

	public void clickDueDateFilter() {
		selEngine.click(dueDateFlt);
	}

	public void clickPriorityFilter() {
		selEngine.click(priorityFlt);
	}

	public void clickLastStatusFilter() {
		selEngine.click(lastStatusFlt);
	}

	public void clickStatusFilter() {
		selEngine.click(statusFlt);
	}

	public void clickExportExcelButton() {
		selEngine.click(exportExcelBtn);
	}

	public void clickFirstItemLink() {
		selEngine.click(firstItemLnk);
	}

	public void doubleClickIdFilter() {
		selEngine.doubleClick(idFlt);
	}

	public void doubleClickSummaryFilter() {
		selEngine.doubleClick(summaryFlt);
	}

	public void doubleClickSquadFilter() {
		selEngine.doubleClick(squadFlt);
	}

	public void doubleClickOwnerFilter() {
		selEngine.doubleClick(ownerFlt);
	}

	public void doubleClickContryFilter() {
		selEngine.doubleClick(contryFlt);
	}

	public void doubleClickAccountFilter() {
		selEngine.doubleClick(accountFlt);
	}

	public void doubleClickAreaFilter() {
		selEngine.doubleClick(areaFlt);
	}

	public void doubleClickApprovedFilter() {
		selEngine.doubleClick(approvedFlt);
	}

	public void doubleClickDueDateFilter() {
		selEngine.doubleClick(dueDateFlt);
	}

	public void doubleClickPriorityFilter() {
		selEngine.doubleClick(priorityFlt);
	}

	public void doubleClickLastStatusFilter() {
		selEngine.doubleClick(lastStatusFlt);
	}

	public void doubleClickStatusFilter() {
		selEngine.doubleClick(statusFlt);
	}
}
