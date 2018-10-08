package br.com.ibm.dynapool.pages.request;

import static br.com.ibm.dynapool.engine.Selenium_Engine.click;
import static br.com.ibm.dynapool.engine.Selenium_Engine.selectDropDown;
import static br.com.ibm.dynapool.engine.Selenium_Engine.setTextbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskRequest_Page {
	
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
		selectDropDown(targetCountryDpx, strCountry);
	}

	public void setAccount(String strAccount) {
		selectDropDown(targetAccountDpx, strAccount);
	}

	public void setEnvironment(String strEnvironment) {
		selectDropDown(environmentDpx, strEnvironment);
	}

	public void setClass(String strClass) {
		selectDropDown(classDpx, strClass);
	}
	
	public void setActivityDpx(String strActivityDpx) {
		selectDropDown(activityDpx, strActivityDpx);
	}

	public void setPriority(String strPriority) {
		selectDropDown(priorityDpx, strPriority);
	}

	public void setComplexity(String strComplexity) {
		selectDropDown(complexityDpx, strComplexity);
	}

	public void setSummary(String strSummary) {
		setTextbox(summaryTxt, strSummary);
	}

	public void setDescription(String strDescription) {
		setTextbox(descriptionTxa, strDescription);
	}

	public void clickSaveButton() {
		click(saveBtn);
	}

	public void clickClearButton() {
		click(clearBtn);
	}

	public void clickCancelButton() {
		click(cancelBtn);
	}
}
