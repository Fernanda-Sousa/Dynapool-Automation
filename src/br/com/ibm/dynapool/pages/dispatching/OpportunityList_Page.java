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

import br.com.ibm.dynapool.pages.Home_Page;

public class OpportunityList_Page extends Home_Page{

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
	By firstItemLnk = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]");

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

	public void clickPriorityFilter() {
		selEngine.click(priorityFlt);
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

	public void clickRequesterFilter() {
		selEngine.click(requesterFlt);
	}

	public void clickSummaryFilter() {
		selEngine.click(summaryFlt);
	}

	public void clickComplexityFilter() {
		selEngine.click(complexityFlt);
	}

	public void clickStageFilter() {
		selEngine.click(stageFlt);
	}

	public void clickStatusFilter() {
		selEngine.click(statusFlt);
	}

	public void clickApprovedFilter() {
		selEngine.click(approvedFlt);
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

	public void doubleClickPriorityFilter() {
		selEngine.doubleClick(priorityFlt);
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

	public void doubleClickRequesterFilter() {
		selEngine.doubleClick(requesterFlt);
	}

	public void doubleClickSummaryFilter() {
		selEngine.doubleClick(summaryFlt);
	}

	public void doubleClickComplexityFilter() {
		selEngine.doubleClick(complexityFlt);
	}

	public void doubleClickStageFilter() {
		selEngine.doubleClick(stageFlt);
	}

	public void doubleClickStatusFilter() {
		selEngine.doubleClick(statusFlt);
	}

	public void doubleClickApprovedFilter() {
		selEngine.doubleClick(approvedFlt);
	}
}
