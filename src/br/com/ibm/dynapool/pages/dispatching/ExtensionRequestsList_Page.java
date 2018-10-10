package br.com.ibm.dynapool.pages.dispatching;

import static br.com.ibm.dynapool.engine.Selenium_Engine.click;

import javax.print.attribute.standard.MediaSize.Engineering;

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

	public void clickTaskFilter() {
		click(taskFlt);
	}

	public void clickReasonFilter() {
		click(reasonFlt);
	}

	public void clickCreatedFilter() {
		click(createdFlt);
	}

	public void clickStatusFilter() {
		click(statusFlt);
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
