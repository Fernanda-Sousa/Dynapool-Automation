/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 30-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.frames;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class StageApprovalsList_Page extends Home_Page{
	
	By idFlt = By.linkText("id");
	By ownerFlt = By.linkText("owner");
	By summaryFlt = By.linkText("summary");
	By duedateFlt = By.linkText("duedate");
	By compFlt = By.linkText("comp");
	By statusFtl = By.linkText("status");
	By firstItemLnk = By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div/table/tbody/tr[2]");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void clickIdFilter() {
		selEngine.click(idFlt);
	}
	
	public void clickOwnerFilter() {
		selEngine.click(ownerFlt);
	}
	
	public void clickSummaryFilter() {
		selEngine.click(summaryFlt);
	}
	
	public void clickDueDateFilter() {
		selEngine.click(duedateFlt);
	}
	
	public void clickCompFilter() {
		selEngine.click(compFlt);
	}
	
	public void clickStatusFilter() {
		selEngine.click(statusFtl);
	}
	
	public void clickFirstItemFilter() {
		selEngine.click(firstItemLnk);
	}
	
	public void doubleClickIdFilter() {
		selEngine.doubleClick(idFlt);
	}
	
	public void doubleClickOwnerFilter() {
		selEngine.doubleClick(ownerFlt);
	}
	
	public void doubleClickSummaryFilter() {
		selEngine.doubleClick(summaryFlt);
	}
	
	public void doubleClickDueDateFilter() {
		selEngine.doubleClick(duedateFlt);
	}
	
	public void doubleClickCompFilter() {
		selEngine.doubleClick(compFlt);
	}
	
	public void doubleClickStatusFilter() {
		selEngine.doubleClick(statusFtl);
	}
	
	public void doubleClickFirstItemFilter() {
		selEngine.doubleClick(firstItemLnk);
	}
}
