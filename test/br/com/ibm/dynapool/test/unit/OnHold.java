/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 29-oct-2018

Last update date: 29-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.test.unit;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import br.com.ibm.dynapool.csv.Csv_Constructor;
import br.com.ibm.dynapool.engine.Csv_Engine;
import br.com.ibm.dynapool.pages.dispatching.TaskView_Page;
import br.com.ibm.dynapool.pages.dispatching.exception.OnHold_Page;
import br.com.ibm.dynapool.test.Test_Constructor;

public class OnHold extends Test_Constructor {

	OnHold_Page onHold = new OnHold_Page();
	TaskView_Page taskView = new TaskView_Page();

	@Test(priority = 0)
	public void putOnHold() throws IOException {
		
		logger = extent.startTest("On hold");

		// Read CSV
		logger.log(LogStatus.INFO, "Reading from Spreadsheet: " + prop.readPropertiesFile("csv_onHold"));
		Csv_Engine csvEng = new Csv_Engine();
		List<Csv_Constructor> Hold = new LinkedList<>();
//		logger.log(LogStatus.INFO, "Test found: " + Req.size() + " rows into file test");// is not working

		Hold = csvEng.readSpreadsheetCSV(prop.readPropertiesFile("csv_onHold"));

		// Hold
		for (Csv_Constructor csv : Hold) {

			taskView.clickOnHoldButton();

			onHold.setAditionalEmail(csv.getHoldAditionalEmail());
			onHold.setCategory(csv.getHoldCategory());
			onHold.setJustification(csv.getHoldJustification());
			onHold.setAction(csv.getHoldAction());
			onHold.clickExternalDependencyYes();
			
			onHold.clickSaveButton();
			
			selEngine.alertClick();
		}
		
		Assert.assertTrue(selEngine.compareTextPartial(By.id("message"), "Item successfully saved."));
		logger.log(LogStatus.PASS, "The task was put on hold correctly");
	}
	
	
}
