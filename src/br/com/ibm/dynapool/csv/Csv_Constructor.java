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
    @CsvBindByName(column = "Class")
    private String classField;
    @CsvBindByName(column = "Complexity")
    private String complexity;
    
    
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
	public String getClassField() {
		return classField;
	}
	public void setClassField(String classField) {
		this.classField = classField;
	}
	public String getComplexity() {
		return complexity;
	}
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
    
    
    
    
	
}
