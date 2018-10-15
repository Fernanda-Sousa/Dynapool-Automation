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


public class ExtensionList_Page extends Home_Page {

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

	public void clickTaskFilter() {
		selEngine.click(taskFlt);
	}

	public void clickReasonFilter() {
		selEngine.click(reasonFlt);
	}

	public void clickCreatedFilter() {
		selEngine.click(createdFlt);
	}

	public void clickStatusFilter() {
		selEngine.click(statusFlt);
	}

	public void clickFirstItemLink() {
		selEngine.click(firstItemLnk);
	}

	public void doubleClickIdFilter() {
		selEngine.doubleClick(idFlt);
	}

	public void doubleClickTaskFilter() {
		selEngine.doubleClick(taskFlt);
	}

	public void doubleClickReasonFilter() {
		selEngine.doubleClick(reasonFlt);
	}

	public void doubleClickCreatedFilter() {
		selEngine.doubleClick(createdFlt);
	}

	public void doubleClickStatusFilter() {
		selEngine.doubleClick(statusFlt);
	}

}
