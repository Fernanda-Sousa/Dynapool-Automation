package br.com.ibm.dynapool.pages.dispatching;

import static br.com.ibm.dynapool.engine.Selenium_Engine.click;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class MasterTaskList_Page {

	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.linkText("id");
	By contryFlt = By.linkText("contry");
	By accountFlt = By.linkText("account");
	By typeFlt = By.linkText("type");
	By requesterFlt = By.linkText("requester");
	By automataFlt = By.linkText("automata");
	By summaryFlt = By.linkText("summary");
	By complexityFlt = By.linkText("complexity");
	By priorityFlt = By.linkText("priority");
	By stageFlt = By.linkText("stage");
	By statusFlt = By.linkText("status");
	By createdFlt = By.linkText("created");
	By exportExcelBtn = By.linkText("export excel");

	public void clickMagnifierFilter() {
		click(magnifierFlt);
	}

	public void clickPreviousButton() {
		click(previousBtn);
	}

	public void clickCloseButton() {
		click(closeBtn);
	}

	public void clickNextButton() {
		click(nextBtn);
	}

	public void clickIdFilter() {
		click(idFlt);
	}

	public void clickContryFilter() {
		click(contryFlt);
	}

	public void clickAccountFilter() {
		click(accountFlt);
	}

	public void clickTypeFilter() {
		click(typeFlt);
	}

	public void clickRequesterFilter() {
		click(requesterFlt);
	}

	public void clickAutomataFilter() {
		click(automataFlt);
	}

	public void clickSummaryFilter() {
		click(summaryFlt);
	}

	public void clickComplexityFilter() {
		click(complexityFlt);
	}

	public void clickPriorityFilter() {
		click(priorityFlt);
	}

	public void clickStageFilter() {
		click(stageFlt);
	}

	public void clickStatusFilter() {
		click(statusFlt);
	}

	public void clickCreatedFilter() {
		click(createdFlt);
	}

	public void clickExportExcelButton() {
		click(exportExcelBtn);
	}
	
	public void doubleClickIdFilter() {
		Selenium_Engine.doubleClick(idFlt);
	}

	public void doubleClickContryFilter() {
		Selenium_Engine.doubleClick(contryFlt);
	}

	public void doubleClickAccountFilter() {
		Selenium_Engine.doubleClick(accountFlt);
	}

	public void doubleClickTypeFilter() {
		Selenium_Engine.doubleClick(typeFlt);
	}

	public void doubleClickRequesterFilter() {
		Selenium_Engine.doubleClick(requesterFlt);
	}

	public void doubleClickAutomataFilter() {
		Selenium_Engine.doubleClick(automataFlt);
	}

	public void doubleClickSummaryFilter() {
		Selenium_Engine.doubleClick(summaryFlt);
	}

	public void doubleClickComplexityFilter() {
		Selenium_Engine.doubleClick(complexityFlt);
	}

	public void doubleClickPriorityFilter() {
		Selenium_Engine.doubleClick(priorityFlt);
	}

	public void doubleClickStageFilter() {
		Selenium_Engine.doubleClick(stageFlt);
	}

	public void doubleClickStatusFilter() {
		Selenium_Engine.doubleClick(statusFlt);
	}

	public void doubleClickCreatedFilter() {
		Selenium_Engine.doubleClick(createdFlt);
	}
}
