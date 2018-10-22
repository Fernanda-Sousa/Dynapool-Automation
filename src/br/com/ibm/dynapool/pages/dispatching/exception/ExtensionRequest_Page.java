/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 22-oct-2018

Last update date: 22-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching.exception;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class ExtensionRequest_Page extends Home_Page {

	By taskIdTxt = By.name("txtIdtask");
	By reasonTxa = By.name("txaReason");
	By suggestedDateDtf = By.name("txtDatesuggested");

	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

	Selenium_Engine selEngine;

	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}

	public int getTaskIdTxt() {
		return selEngine.getIntegerContent(taskIdTxt);
	}

	public boolean compareTaskId(String strTaskId) {
		return selEngine.compareText(taskIdTxt, strTaskId);

	}

	public void setReason(String strReason) {
		selEngine.setTextbox(reasonTxa, strReason);
	}

	public void setSuggestedDate(String strSuggestedDate) {
		selEngine.click(suggestedDateDtf);
		selEngine.setTextbox(suggestedDateDtf, strSuggestedDate);
		selEngine.click(By.tagName("h2"));
	}

	public void clickSaveButton() {
		selEngine.click(saveBtn);
	}

	public void clickClear() {
		selEngine.click(clearBtn);
	}

	public void clickCancel() {
		selEngine.click(cancelBtn);
	}

}
