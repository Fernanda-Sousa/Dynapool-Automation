package br.com.ibm.dynapool.pages.dispatching;

import static br.com.ibm.dynapool.engine.Selenium_Engine.click;

import org.openqa.selenium.By;

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

	public void clickSummaryFilter() {
		click(summaryFlt);
	}

	public void clickSquadFilter() {
		click(squadFlt);
	}

	public void clickOwnerFilter() {
		click(ownerFlt);
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

	public void clickApprovedFilter() {
		click(approvedFlt);
	}

	public void clickDueDateFilter() {
		click(dueDateFlt);
	}

	public void clickPriorityFilter() {
		click(priorityFlt);
	}

	public void clickLastStatusFilter() {
		click(lastStatusFlt);
	}

	public void clickStatusFilter() {
		click(statusFlt);
	}

	public void clickExportExcelButton() {
		click(exportExcelBtn);
	}
}
