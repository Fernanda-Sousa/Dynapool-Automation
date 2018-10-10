package br.com.ibm.dynapool.pages.dispatching;

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

	public void clickContryFilter() {
		Selenium_Engine.click(contryFlt);
	}

	public void clickAccountFilter() {
		Selenium_Engine.click(accountFlt);
	}

	public void clickTypeFilter() {
		Selenium_Engine.click(typeFlt);
	}

	public void clickRequesterFilter() {
		Selenium_Engine.click(requesterFlt);
	}

	public void clickAutomataFilter() {
		Selenium_Engine.click(automataFlt);
	}

	public void clickSummaryFilter() {
		Selenium_Engine.click(summaryFlt);
	}

	public void clickComplexityFilter() {
		Selenium_Engine.click(complexityFlt);
	}

	public void clickPriorityFilter() {
		Selenium_Engine.click(priorityFlt);
	}

	public void clickStageFilter() {
		Selenium_Engine.click(stageFlt);
	}

	public void clickStatusFilter() {
		Selenium_Engine.click(statusFlt);
	}

	public void clickCreatedFilter() {
		Selenium_Engine.click(createdFlt);
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
