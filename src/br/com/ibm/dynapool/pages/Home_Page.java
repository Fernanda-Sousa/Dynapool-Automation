/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 10-oct-2018

Last update date: 25-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;

public class Home_Page {
	// Menus
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
	
	// Frames
	By daynaNewsFrameLnk = By.cssSelector("div.smallCard:nth-child(1)");
	By yourCurrentTasksFrameLnk = By.cssSelector("div.smallCard:nth-child(2)");
	By noAssigneesFrameLnk = By.cssSelector("div.smallCard:nth-child(3)");
	By openTasksFrameLnk = By.cssSelector("div.smallCard:nth-child(4)");
	By closedTasksFrameLnk = By.cssSelector("div.smallCard:nth-child(5)");//
	By draftsForApprovalFrameLnk = By.cssSelector("div.smallCard:nth-child(6)");
	By onHoldFrameLnk = By.cssSelector("div.smallCard:nth-child(7)");
	By overdueFrameLnk = By.cssSelector("div.smallCard:nth-child(8)");
	By stageApprovalsFrameLnk = By.xpath("/html/body/div[1]/div[4]/div[8]");
	By pendingExtensionsFrameLnk = By.cssSelector("div.smallCard:nth-child(10)");
	By yourRequestsFrameLnk = By.cssSelector("div.smallCard:nth-child(5)");//

	// Header
	By logoLnk = By.linkText("navigateTo('https://dynapool.ipctrmx02.com/dynatest/home.jsp')");
	By searchBarTxt = By.name("txtHomeSearch");
	By magnifierBtn = By.linkText("javascript:submitHome();");
	By changeThemeBtn = By.linkText("javascript:showDiv('themeSelector', false)");
	By lightThemeBtn = By.linkText("javascript:changeTheme('standard')");
	By darkThemeBtn = By.linkText("javascript:changeTheme('darks')");
	By exitBtn = By.cssSelector("#header > div.hdrRightPanel > div:nth-child(2)");
	By profileBtn = By.className("hdrUser");
	
	
	Selenium_Engine selEngine = new Selenium_Engine();

	public void clickRequestInternal() {
		selEngine.click(requestMnu);
		selEngine.click(requestInternalMnu);
	}

	public void clickRequestMaster() {
		selEngine.click(requestMnu);
		selEngine.click(requestMasterMnu);
	}

	public void clickRequestOpportunity() {
		selEngine.click(requestMnu);
		selEngine.click(requestOpportunityMnu);
	}

	public void clickAdministrationAccount() {
		selEngine.click(adminMnu);
		selEngine.click(adminAccountMnu);
	}

	public void clickAdministrationNonCompliance() {
		selEngine.click(adminMnu);
		selEngine.click(adminNoncomplianceMnu);
	}

	public void clickAdministrationAutomata() {
		selEngine.click(adminMnu);
		selEngine.click(adminAutomataMnu);
	}

	public void clickAdministrationHoldCategory() {
		selEngine.click(adminMnu);
		selEngine.click(adminHoldCategoryMnu);
	}

	public void clickAdministrationRole() {
		selEngine.click(adminMnu);
		selEngine.click(adminRoleMnu);
	}

	public void clickAdministrationUser() {
		selEngine.click(adminMnu);
		selEngine.click(adminUserMnu);
	}

	public void clickDispatchExtension() {
		selEngine.click(dispatchMnu);
		selEngine.click(dispatchExtensionMnu);
	}

	public void clickDispatchTask() {
		selEngine.click(dispatchMnu);
		selEngine.click(dispatchTaskMnu);
	}

	public void clickDispatchMaster() {
		selEngine.click(dispatchMnu);
		selEngine.click(dispatchMasterMnu);
	}

	public void clickDispatchOpportunity() {
		selEngine.click(dispatchMnu);
		selEngine.click(dispatchOpportunityMnu);
	}

	public void clickDispatchSquad() {
		selEngine.click(dispatchMnu);
		selEngine.click(dispatchSquadMnu);
	}

	public void clickPortalNews() {
		selEngine.click(portalMnu);
		selEngine.click(portalNewsMnu);
	}

	public void clickPortalSuggestion() {
		selEngine.click(portalMnu);
		selEngine.click(portalSuggestionMnu);
	}

	public void clickReport() {
		selEngine.click(reportMnu);
	}

	public void clickResearchBacklog() {
		selEngine.click(researchMnu);
		selEngine.click(researchBacklogMnu);
	}

	public void clickLinksKanban() {
		selEngine.click(linksMnu);
		selEngine.click(linksKanbanMnu);
	}

	public void clickLinksGAMP() {
		selEngine.click(linksMnu);
		selEngine.click(linksGAMPMnu);
	}
	
	public void clickDaynaNewsFrame() {
		selEngine.click(daynaNewsFrameLnk);
	}
	
	public void clickYourCurrentTasksFrame() {
		selEngine.click(yourCurrentTasksFrameLnk);
	}
	
	public void clickNoAssigneesFrame() {
		selEngine.click(noAssigneesFrameLnk);
	}
	
	public void clickOpenTasksFrame() {
		selEngine.click(openTasksFrameLnk);
	}
	
	public void clickClosedTasksFrame() {
		selEngine.click(closedTasksFrameLnk);
	}
	
	public void clickDraftsForApprovalFrame() {
		selEngine.click(draftsForApprovalFrameLnk);
	}
	
	public void clickOnHoldFrame() {
		selEngine.click(onHoldFrameLnk);
	}
	
	public void clickOverdueFrame() {
		selEngine.click(overdueFrameLnk);
	}
	
	public void clickStageApprovalsFrame() {
		selEngine.waitForPageLoad();
		selEngine.click(stageApprovalsFrameLnk);
	}
	
	public void clickPendingExtensionsFrame() {
		selEngine.click(pendingExtensionsFrameLnk);
	}
	
	public void clickYourRequestsFrame() {
		selEngine.click(yourRequestsFrameLnk);
	}
	
	public void clickLogo() {
		selEngine.click(logoLnk);
	}
	
	public void setSearchBar(String strSearchBar) {
		selEngine.setTextbox(searchBarTxt, strSearchBar);
	}
	
	public void clickMagnifierButton() {
		selEngine.click(magnifierBtn);
	}
	
	public void clickLightThemeButton() {
		selEngine.click(changeThemeBtn);
		selEngine.click(lightThemeBtn);
	}
	
	public void clickDarkThemeButton() {
		selEngine.click(changeThemeBtn);
		selEngine.click(darkThemeBtn);
	}
	
	public void clickExitButton() {
		selEngine.click(exitBtn);
	}
	
	public void clickProfileButton() {
		selEngine.click(profileBtn);
	}
}

