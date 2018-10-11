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
import org.openqa.selenium.WebDriver;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class TaskRequest_Page extends Home_Page{

	WebDriver driver;
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By classDpx = By.name("selDeftype");
	By activityDpx = By.name("selDefactivity");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

	public void setCountry(String strCountry) {
		Selenium_Engine.selectDropDown(targetCountryDpx, strCountry);
	}

	public void setAccount(String strAccount) {
		Selenium_Engine.selectDropDown(targetAccountDpx, strAccount);
	}

	public void setEnvironment(String strEnvironment) {
		Selenium_Engine.selectDropDown(environmentDpx, strEnvironment);
	}

	public void setClass(String strClass) {
		Selenium_Engine.selectDropDown(classDpx, strClass);
	}

	public void setActivityDpx(String strActivityDpx) {
		Selenium_Engine.selectDropDown(activityDpx, strActivityDpx);
	}

	public void setPriority(String strPriority) {
		Selenium_Engine.selectDropDown(priorityDpx, strPriority);
	}

	public void setComplexity(String strComplexity) {
		Selenium_Engine.selectDropDown(complexityDpx, strComplexity);
	}

	public void setSummary(String strSummary) {
		Selenium_Engine.setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		Selenium_Engine.setTextbox(descriptionTxa, strDescription);
	}

	public void clickSaveButton() {
		Selenium_Engine.click(saveBtn);
	}

	public void clickClearButton() {
		Selenium_Engine.click(clearBtn);
	}

	public void clickCancelButton() {
		Selenium_Engine.click(cancelBtn);
	}
}
