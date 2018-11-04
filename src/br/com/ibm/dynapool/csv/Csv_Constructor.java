/*
Created by: Fernanda Pereira (ferps@br.ibm.com)
Date: 23-oct-2018

Last update date: 24-oct-2018
Last updated by: Fernanda Pereira (ferps@br.ibm.com)

Version: 1.0.0.0
Description: 
*/

package br.com.ibm.dynapool.csv;

import com.opencsv.bean.CsvBindByName;

public class Csv_Constructor {

	@CsvBindByName(column = "Target Country")
	private String targetCountry;
	@CsvBindByName(column = "Target Account")
	private String targetAccount;
	@CsvBindByName(column = "Environment")
	private String environment;
	@CsvBindByName(column = "Priority")
	private String priority;
	@CsvBindByName(column = "Summary")
	private String summary;
	@CsvBindByName(column = "Description")
	private String description;
	@CsvBindByName(column = "SME/Client Contact")
	private String SME_ClientContact;
	@CsvBindByName(column = "Automata Category")
	private String automataCategory;
	@CsvBindByName(column = "Alert/Server Count")
	private String alert_ServerCount;
	@CsvBindByName(column = "Expected Savings")
	private String expectedSavings;
	@CsvBindByName(column = "Costs Avoided")
	private String costsAvoided;
	@CsvBindByName(column = "SOP Link")
	private String SOPLink;
	@CsvBindByName(column = "Current Effort")
	private String currentEffort;
	@CsvBindByName(column = "Percentage Completed")
	private String percentageCompleted;

	@CsvBindByName(column = "Squad")
	private String squad;
	@CsvBindByName(column = "Owner")
	private String owner;
	@CsvBindByName(column = "Complexity")
	private String complexity;
	@CsvBindByName(column = "Form App. Notes")
	private String formAppNotes;
	@CsvBindByName(column = "Business App. Notes")
	private String businessAppNotes;
	@CsvBindByName(column = "Technical App. Notes")
	private String technicalAppNotes;
	@CsvBindByName(column = "Class")
	private String classField;
	@CsvBindByName(column = "Discussion")
	private String discussion;
	
	@CsvBindByName(column = "Hold Aditional E-mail")
	private String holdAditionalEmail;
	@CsvBindByName(column = "Hold Category")
	private String holdCategory;
	@CsvBindByName(column = "Hold Justification")
	private String holdJustification;
	@CsvBindByName(column = "Hold Action")
	private String holdAction;
	
	@CsvBindByName(column = "Extension Reason")
	private String extensionReason;
	@CsvBindByName(column = "Extension Suggested Date")
	private String extensionSuggestedDate;
	
	@CsvBindByName(column = "Extension Justification")
	private String extensionJustification;
	
	@CsvBindByName(column = "Defect Category")
	private String defectCategory;
	@CsvBindByName(column = "Task Source")
	private String taskSource;
	
	@CsvBindByName(column = "Activity")
	private String activity;
	
	public String getTargetCountry() {
		return targetCountry;
	}
	public void setTargetCountry(String targetCountry) {
		this.targetCountry = targetCountry;
	}
	
	public String getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(String targetAccount) {
		this.targetAccount = targetAccount;
	}

	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSME_ClientContact() {
		return SME_ClientContact;
	}
	public void setSME_ClientContact(String SME_ClientContact) {
		this.SME_ClientContact = SME_ClientContact;
	}

	public String getAutomataCategory() {
		return automataCategory;
	}
	public void setAutomataCategory(String automataCategory) {
		this.automataCategory = automataCategory;
	}

	public String getAlert_ServerCount() {
		return alert_ServerCount;
	}
	public void setAlert_ServerCount(String alert_ServerCount) {
		this.alert_ServerCount = alert_ServerCount;
	}

	public String getExpectedSavings() {
		return expectedSavings;
	}
	public void setExpectedSavings(String expectedSavings) {
		this.expectedSavings = expectedSavings;
	}

	public String getCostsAvoided() {
		return costsAvoided;
	}
	public void setCostsAvoided(String costsAvoided) {
		this.costsAvoided = costsAvoided;
	}
		
	public String getSOPLink() {
		return SOPLink;
	}
	public void setSOPLink(String sOPLink) {
		SOPLink = sOPLink;
	}
	
	public String getCurrentEffort() {
		return currentEffort;
	}
	public void setCurrentEffort(String currentEffort) {
		this.currentEffort = currentEffort;
	}
	
	public String getPercentageCompleted() {
		return percentageCompleted;
	}
	public void setPercentageCompleted(String percentageCompleted) {
		this.percentageCompleted = percentageCompleted;
	}
	
	public String getSquad() {
		return squad;
	}
	public void setSquad(String squad) {
		this.squad = squad;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getComplexity() {
		return complexity;
	}
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
	
	public String getFormAppNotes() {
		return formAppNotes;
	}
	public void setFormAppNotes(String formAppNotes) {
		this.formAppNotes = formAppNotes;
	}
	
	public String getBusinessAppNotes() {
		return businessAppNotes;
	}
	public void setBusinessAppNotes(String businessAppNotes) {
		this.businessAppNotes = businessAppNotes;
	}
	
	public String getTechnicalAppNotes() {
		return technicalAppNotes;
	}
	public void setTechnicalAppNotes(String technicalAppNotes) {
		this.technicalAppNotes = technicalAppNotes;
	}
	
	public String getClassField() {
		return classField;
	}
	public void setClassField(String classField) {
		this.classField = classField;
	}
	
	public String getDiscussion() {
		return discussion;
	}
	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}
	
	public String getHoldAditionalEmail() {
		return holdAditionalEmail;
	}
	public void setHoldAditionalEmail(String holdAditionalEmail) {
		this.holdAditionalEmail = holdAditionalEmail;
	}
	
	public String getHoldCategory() {
		return holdCategory;
	}
	public void setHoldCategory(String holdCategory) {
		this.holdCategory = holdCategory;
	}
	
	public String getHoldJustification() {
		return holdJustification;
	}
	public void setHoldJustification(String holdJustification) {
		this.holdJustification = holdJustification;
	}
	
	public String getHoldAction() {
		return holdAction;
	}
	public void setHoldAction(String holdAction) {
		this.holdAction = holdAction;
	}
	
	public String getExtensionReason() {
		return extensionReason;
	}
	public void setExtensionReason(String extensionReason) {
		this.extensionReason = extensionReason;
	}
	
	public String getExtensionSuggestedDate() {
		return extensionSuggestedDate;
	}
	public void setExtensionSuggestedDate(String extensionSuggestedDate) {
		this.extensionSuggestedDate = extensionSuggestedDate;
	}
	
	public String getExtensionJustification() {
		return extensionJustification;
	}
	public void setExtensionJustification(String extensionJustification) {
		this.extensionJustification = extensionJustification;
	}
	
	public String getDefectCategory() {
		return defectCategory;
	}
	public void setDefectCategory(String defectCategory) {
		this.defectCategory = defectCategory;
	}
	
	public String getTaskSource() {
		return taskSource;
	}
	public void setTaskSource(String taskSource) {
		this.taskSource = taskSource;
	}
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
}
