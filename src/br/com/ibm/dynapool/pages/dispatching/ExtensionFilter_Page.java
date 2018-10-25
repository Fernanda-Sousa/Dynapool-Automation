/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 25-oct-2018

Last update date: 25-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class ExtensionFilter_Page {

	By idTxt = By.name("txtId");
	By taskIdTxt = By.name("txtIdtask");
	By reasonTxt = By.name("txtReason");
	By periodFromDtf = By.id("dateFromPeriod");
	By periodToDtf = By.id("dateToPeriod");
	By statusDpx = By.name("selDefstatus");
	
	By applyBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnClear");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setId(String strId) {
		selEngine.setTextbox(idTxt, strId);
	}
	
	public void setTaskId(String strTaskId) {
		selEngine.setTextbox(taskIdTxt, strTaskId);
	}
	
	public void setReason(String strReason) {
		selEngine.setTextbox(reasonTxt, strReason);
	}
	
	public void setPeriodFrom(String strPeriodFrom) {
		selEngine.click(periodFromDtf);
		selEngine.setTextbox(periodFromDtf, strPeriodFrom);
		selEngine.click(By.tagName("label"));
	}
	
	public void setPeriodTo(String strPeriodTo) {
		selEngine.click(periodToDtf);
		selEngine.setTextbox(periodToDtf, strPeriodTo);
		selEngine.click(By.tagName("label"));
	}
	
	public void setStatus(String strStatus) {
		selEngine.selectDropDown(statusDpx, strStatus);
	}
	
	public void clickApply() {
		selEngine.click(applyBtn);
	}
	
	public void clickClear() {
		selEngine.click(clearBtn);
	}
}
