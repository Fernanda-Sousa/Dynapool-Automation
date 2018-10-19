/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 19-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class Home_Page {

	By requestMnu = By.id("mnuRequest"); // Main Menu
	By requestInternalMnu = By.id("mnuRequestInternal");
	By requestMasterMnu = By.id("mnuRequestMaster");
	By requestOpportunityMnu = By.id("mnuRequestOpportunity");

	By adminMnu = By.id("mnuAdmin"); // Main Menu
	By adminAccountMnu = By.id("mnuAdminAccount");
	By adminNoncomplianceMnu = By.id("mnuAdminNoncompliance");
	By adminAutomataMnu = By.id("mnuAdminAutomata");
	By adminHoldCategoryMnu = By.id("mnuAdminHoldCategory");
	By adminRoleMnu = By.id("mnuAdminRole");
	By adminUserMnu = By.id("mnuAdminUser");

	By dispatchMnu = By.id("mnuDispatch");// Main Menu
	By dispatchExtensionMnu = By.id("mnuDispatchExtension");
	By dispatchTaskMnu = By.id("mnuDispatchTask");
	By dispatchMasterMnu = By.id("mnuDispatchMaster");
	By dispatchOpportunityMnu = By.id("mnuDispatchOpportunity");
	By dispatchSquadMnu = By.id("mnuDispatchSquad");

	By portalMnu = By.id("mnuPortal");// Main Menu
	By portalNewsMnu = By.id("mnuPortalNews");
	By portalSuggestionMnu = By.id("mnuPortalSuggestion");

	By reportMnu = By.id("mnuReport"); // Main Menu

	By researchMnu = By.id("mnuResearch"); // Main Menu
	By researchBacklogMnu = By.id("mnuResearchBacklog");

	By linksMnu = By.id("mnuLinks"); // Main Menu
	By linksKanbanMnu = By.id("mnuLinksKanban");
	By linksGAMPMnu = By.id("mnuLinksGAMP");

	Selenium_Engine selEngine;

	public void clickRequestInternal() {
		selEngine.click(requestMnu);
		selEngine.click(requestInternalMnu);
	}
	
}
