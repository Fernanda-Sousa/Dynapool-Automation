package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class ExtensionRequestsList_Page {

	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.linkText("id");
	By taskFlt = By.linkText("task");
	By reasonFlt = By.linkText("reason");
	By createdFlt = By.linkText("created");
	By statusFlt = By.linkText("status");
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

	public void clickTaskFilter() {
		Selenium_Engine.click(taskFlt);
	}

	public void clickReasonFilter() {
		Selenium_Engine.click(reasonFlt);
	}

	public void clickCreatedFilter() {
		Selenium_Engine.click(createdFlt);
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

	public void doubleClickTaskFilter() {
		Selenium_Engine.doubleClick(taskFlt);
	}

	public void doubleClickReasonFilter() {
		Selenium_Engine.doubleClick(reasonFlt);
	}

	public void doubleClickCreatedFilter() {
		Selenium_Engine.doubleClick(createdFlt);
	}

	public void doubleClickStatusFilter() {
		Selenium_Engine.doubleClick(statusFlt);
	}

}
