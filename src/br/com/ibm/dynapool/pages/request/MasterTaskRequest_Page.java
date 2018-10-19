/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 10-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.request;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class MasterTaskRequest_Page extends Home_Page{

	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By classDpx = By.name("selDeftype");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By automatasAvailableCrl = By.name("crlAutomataAvailable");
	By addAutomataCrl = By.cssSelector("input.crossListButton:nth-child(1)");
	By removeAutomataCrl = By.cssSelector("input.crossListButton:nth-child(3)");
	By automatasSelectedCrl = By.name("crlAutomataSelected");
	By taskSourceDpx = By.name("selDeftasksource");
	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
	By defectCategoryDpx = By.name("selDefdefectcategory");
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

Selenium_Engine selEngine;
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void setCountry(String strCountry) {
		selEngine.selectDropDown(targetCountryDpx, strCountry);
	}

	public void setAccount(String strAccount) {
		selEngine.selectDropDown(targetAccountDpx, strAccount);
	}

	public void setEnvironment(String strEnvironment) {
		selEngine.selectDropDown(environmentDpx, strEnvironment);
	}

	public void setClass(String strClass) {
		selEngine.selectDropDown(classDpx, strClass);
	}

	public void setPriority(String strPriority) {
		selEngine.selectDropDown(priorityDpx, strPriority);
	}

	public void setComplexity(String strComplexity) {
		selEngine.selectDropDown(complexityDpx, strComplexity);
	}

	public void setSummary(String strSummary) {
		selEngine.setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		selEngine.setTextbox(descriptionTxa, strDescription);
	}

	public void addAutomata(String strAutomata) {
		selEngine.click(automatasAvailableCrl);
		selEngine.click(By.partialLinkText(strAutomata));
		selEngine.click(addAutomataCrl);
	}
	
	public void removeAutomata(String strAutomata) {
		selEngine.click(automatasSelectedCrl);
		selEngine.click(By.partialLinkText(strAutomata));
		selEngine.click(removeAutomataCrl);
	}
	
	public void setTaskSource(String strTaskSource) {
		selEngine.selectDropDown(taskSourceDpx, strTaskSource);
	}

	public void setAutomataCategory(String strAutomataCategory) {
		selEngine.selectDropDown(automataCategoryDpx, strAutomataCategory);
	}

	public void setAlert_ServerCount(String strAlert_ServerCount) {
		selEngine.setTextbox(alert_ServerCountTxt, strAlert_ServerCount);
	}

	public void setDefectCategory(String strDefectCategory) {
		selEngine.selectDropDown(defectCategoryDpx, strDefectCategory);
	}

	public void clickSaveButton() {
		selEngine.click(saveBtn);
	}

	public void clickClearButton() {
		selEngine.click(clearBtn);
	}

	public void clickCancelButton() {
		selEngine.click(cancelBtn);
	}
}
