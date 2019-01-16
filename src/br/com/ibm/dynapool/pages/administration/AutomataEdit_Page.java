/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 26-nov-2018

Last update date: 26-nov-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.engine.Selenium_Engine;
import br.com.ibm.dynapool.pages.Home_Page;

public class AutomataEdit_Page extends Home_Page{

	By viewLnk = By.name("tabView");

	By idTxt = By.name("txtId");
	By nameTxt = By.name("txtName");
	By environmentDpx = By.name("selDefenvironment");

	By selectEligibleAccountCrl = By.partialLinkText("1");
	By addEligibleAccountsBtn = By.xpath("//*[@id=\"divCrossEligibleAccount\"]/div[2]/input[1]");
	By removeEligibleAccountsBtn = By.xpath("//*[@id=\"divCrossEligibleAccount\"]/div[2]/input[2]");
	
	By selectDeployedAccountCrl = By.partialLinkText("11");
	By addDeployedAccountsBtn = By.xpath("//*[@id=\"divCrossDeployedAccount\"]/div[2]/input[1]");
	By removeDeployedAccountsBtn = By.xpath("//*[@id=\"divCrossDeployedAccount\"]/div[2]/input[2]");
	
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");

	Selenium_Engine selEngine = new Selenium_Engine();

	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}

	public boolean compareId(String strId) {
		return selEngine.compareText(idTxt, strId);
	}

	public void setName(String strName) {
		selEngine.setTextbox(nameTxt, strName);
	}
	
	public void setEnvironmrnt(String strEnvironmrnt) {
		selEngine.selectDropDown(environmentDpx, strEnvironmrnt);
	}
	
	public String getId() {
		return selEngine.getAttribute(idTxt, "value");
	}
	
	public void clickSelectEligibleAccount() {
		selEngine.click(selectEligibleAccountCrl);
	}
	
	public void clickAddEligibleAccounts() {
		selEngine.click(addEligibleAccountsBtn);
	}
	
	public void clickRemoveEligibleAccounts() {
		selEngine.click(removeEligibleAccountsBtn);
	}
	
	public void clickSelectDeployedAccount() {
		selEngine.click(selectDeployedAccountCrl);
	}
	
	public void clickAddDeployedAccounts() {
		selEngine.click(addDeployedAccountsBtn);
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

