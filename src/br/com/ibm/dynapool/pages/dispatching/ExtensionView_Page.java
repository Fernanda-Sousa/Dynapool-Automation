/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 15-oct-2018

Last update date: 15-oct-2018
Last updated by: Fernanda pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.pages.dispatching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExtensionView_Page {

	WebDriver driver;

	By editLnk = By.name("tabEdit");

	By taskIdTxt = By.name("txtIdtask");
	By targetCountryDpx = By.name("selDefcountry");
	By targetAccountDpx = By.name("selIdaccount");
	By priorityDpx = By.name("selDefpriority");
	By ownerDpx = By.name("selIdowner");
	By summaryTxt = By.name("txtSummary");
	By descriptionTxa = By.name("txaDescription");
	By dueDateDtf = By.name("txtDatedue");

	By idTxt = By.name("txtId");
	By createdDtf = By.name("txtDatecreation");
	By reasonTxa = By.name("txaReason");
	By suggestedDateDtf = By.name("txtDatesuggested");

	By reviewedDateDtf = By.name("txtDatereview");
	By statusDpx = By.name("selDefstatus");
	By justificationTxa = By.name("txaReasonreject");

	By approveBtn = By.name("btnApprove");
	By rejectBtn = By.name("btnReject");
	By closeBtn = By.name("btnClose");
	By deleteBtn = By.name("btnDelete");

}
