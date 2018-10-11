/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 11-oct-2018

Last update date: 11-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MasterTaskView_Page {
	
	WebDriver driver;
	
	By editLnk = By.name("tabEdit");
	
	By idTxt = By.name("txtId");
	
	By requesterDpx = By.name("selIdrequester");
	
	By squadDpx = By.name("selDefsquad");
	By ownerDpx = By.name("selIdowner");
	
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By environmentDpx = By.name("selDefenvironment");
	By classDpx = By.name("selDeftype");
	By priorityDpx = By.name("selDefpriority");
	By complexityDpx = By.name("selDefcomplexity");
	By automataDpx = By.name("selAutomata");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	
	By taskSourceDpx = By.name("selDeftasksource");
	By automataCategoryDpx = By.name("selDefautomatacategory");
	By alert_ServerCountTxt = By.name("txtAutomatacount");
	By defectCategoryDpx = By.name("selDefdefectcategory");
	
	By approvedRdb = By.name("rdoYnapproved");
	By currentStageDpx = By.name("selDefstage");
	
	By statusDpx = By.name("selDefstatus");
	By createdDtf = By.name("txtDatecreation");
	By approvedDft = By.name("txtDateapproval");
	By plannedStartDateDtf = By.name("txtDatePlanning");
	By startedDtf = By.name("txtDatestarted");
	
	By justificationTxa = By.name("txaJustification");
	
	By closeBtn = By.name("btnClose");
	By deleteBtn = By.name("btnDelete");

	By firstChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[2]");
	By secondLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[3]");
	By thirdLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[4]");
	By fourthChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[5]");
	By fifthChildLnk = By.name("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[6]");
	
}
