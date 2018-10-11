/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 11-oct-2018

Last update date: 11-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.administration;

import org.openqa.selenium.By;

import br.com.ibm.dynapool.pages.Home_Page;



public class RoleList_Page extends Home_Page{

	By magnifierFlt = By.className("bigCardTitle");
	By previousBtn = By.name("btnPrevious page");
	By newBtn = By.name("btnNew");
	By closeBtn = By.name("btnClose");
	By nextBtn = By.name("btnNext page");
	By idFlt = By.linkText("id");
	By titleFlt = By.linkText("title");
	By descriptionFlt = By.linkText("description");
	By firstItemLnk = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/table/tbody/tr[2]");

	public void clickMagnifierFilter() {
		selEngine.click(magnifierFlt);
	}

	public void clickPreviousButton() {
		selEngine.click(previousBtn);
	}

	public void clickNewButton() {
		selEngine.click(newBtn);
	}

	public void clickCloseButton() {
		selEngine.click(closeBtn);
	}

	public void clickNextButton() {
		selEngine.click(nextBtn);
	}

	public void clickIdFilter() {
		selEngine.click(idFlt);
	}

	public void clickTitleFilter() {
		selEngine.click(titleFlt);
	}

	public void clickDescriptionFilter() {
		selEngine.click(descriptionFlt);
	}

	public void clickFirstItemLink() {
		selEngine.click(firstItemLnk);
	}

	public void doubleClickIdFilter() {
		selEngine.doubleClick(idFlt);
	}

	public void doubleClickTitleFilter() {
		selEngine.doubleClick(titleFlt);
	}

	public void doubleClickDescriptionFilter() {
		selEngine.doubleClick(descriptionFlt);
	}
}
