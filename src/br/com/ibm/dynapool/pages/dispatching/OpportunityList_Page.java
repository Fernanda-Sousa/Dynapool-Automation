package br.com.ibm.dynapool.pages.dispatching;

import static br.com.ibm.dynapool.engine.Selenium_Engine.click;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class OpportunityList_Page {

	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.linkText("id");
	By priorityFlt = By.linkText("priority");
	By contryFlt = By.linkText("contry");
	By accountFlt = By.linkText("account");
	By areaFlt = By.linkText("area");
	By requesterFlt = By.linkText("requester");
	By summaryFlt = By.linkText("summary");
	By complexityFlt = By.linkText("complexity");
	By stageFlt = By.linkText("stage");
	By statusFlt = By.linkText("status");
	By approvedFlt = By.linkText("approved");
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

	public void clickPriorityFilter() {
		click(priorityFlt);
	}

	public void clickContryFilter() {
		click(contryFlt);
	}

	public void clickAccountFilter() {
		click(accountFlt);
	}

	public void clickAreaFilter() {
		click(areaFlt);
	}

	public void clickRequesterFilter() {
		click(requesterFlt);
	}

	public void clickSummaryFilter() {
		click(summaryFlt);
	}

	public void clickComplexityFilter() {
		click(complexityFlt);
	}

	public void clickStageFilter() {
		click(stageFlt);
	}

	public void clickStatusFilter() {
		click(statusFlt);
	}

	public void clickApprovedFilter() {
		click(approvedFlt);
	}

	public void clickExportExcelButton() {
		click(exportExcelBtn);
	}

	public void doubleClickIdFilter() {
		Selenium_Engine.doubleClick(idFlt);
	}

	public void doubleClickPriorityFilter() {
		Selenium_Engine.doubleClick(priorityFlt);
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

	public void doubleClickRequesterFilter() {
		Selenium_Engine.doubleClick(requesterFlt);
	}

	public void doubleClickSummaryFilter() {
		Selenium_Engine.doubleClick(summaryFlt);
	}

	public void doubleClickComplexityFilter() {
		Selenium_Engine.doubleClick(complexityFlt);
	}

	public void doubleClickStageFilter() {
		Selenium_Engine.doubleClick(stageFlt);
	}

	public void doubleClickStatusFilter() {
		Selenium_Engine.doubleClick(statusFlt);
	}

	public void doubleClickApprovedFilter() {
		Selenium_Engine.doubleClick(approvedFlt);
	}
}
