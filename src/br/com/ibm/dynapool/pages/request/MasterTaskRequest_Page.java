package br.com.ibm.dynapool.pages.request;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MasterTaskRequest_Page {

	WebDriver driver;
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By classDpx = By.name("selDeftype");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By automatasCrl = By.name("crlAutomataAvailable");
	By addAutomataCrl = By.cssSelector("input.crossListButton:nth-child(1)");//verify the better way
	By removeAutomataCrl = By.cssSelector("input.crossListButton:nth-child(3)");//verify the better way
	By taskSourceDpx = By.name("selDeftasksource");
	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
	By defectCategoryDpx = By.name("selDefdefectcategory");
	By sameBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");
	
	
}
