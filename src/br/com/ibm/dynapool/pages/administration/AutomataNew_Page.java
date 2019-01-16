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

public class AutomataNew_Page {
	By nameTxt = By.name("txtName");
	By environmentDpx = By.name("selDefenvironment");
	
	By selectEligibleAccountCrl = By.xpath("//*[@id=\"divCrossEligibleAccount\"]/div[1]/select/option[10]"); //hard coded - verify other way
	By addEligibleAccountsBtn = By.xpath("//*[@id=\"divCrossEligibleAccount\"]/div[2]/input[1]");
	By removeEligibleAccountsBtn = By.xpath("//*[@id=\"divCrossEligibleAccount\"]/div[2]/input[2]");
	
	By selectDeployedAccountCrl = By.xpath("//*[@id=\"divCrossDeployedAccount\"]/div[1]/select/option[17]");//hard coded - verify other way
	By addDeployedAccountsBtn = By.xpath("//*[@id=\"divCrossDeployedAccount\"]/div[2]/input[1]");
	By removeDeployedAccountsBtn = By.xpath("//*[@id=\"divCrossDeployedAccount\"]/div[2]/input[2]");
	
	By saveBtn = By.name("btnSubmit");
	By clearBtn = By.name("btnReset");
	By cancelBtn = By.name("btnCancel");
	
	Selenium_Engine selEngine = new Selenium_Engine();
	
	public void setSelEngine(Selenium_Engine selEngine) {
		this.selEngine = selEngine;
	}
	
	public void setName(String strName) {
		selEngine.setTextbox(nameTxt, strName);
	}
	
	public void setEnvironment(String strEnvironmrnt) {
		selEngine.selectDropDown(environmentDpx, strEnvironmrnt);
	}
	
	public String getName() {
		return selEngine.getAttribute(nameTxt, "value");
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
