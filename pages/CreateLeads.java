package pages;

import org.openqa.selenium.By;

import hooks.TestNGHooks;



public class CreateLeads extends TestNGHooks {

	public CreateLeads entercomname(String comname) {
		
		type(locateElement("id","createLeadForm_companyName"), comname);
		
		return this;
	}
	public CreateLeads enterfirstname(String fname) {
		type(locateElement("id","createLeadForm_firstName"), fname);
		
		return this;
	}
	public CreateLeads enterlastname(String lname) {
		type(locateElement("id","createLeadForm_lastName"), lname);
		
		return this;
	}
	
	public ViewLeads clickCreate() {
		
		click(locateElement("name","submitButton"));
		
		return new ViewLeads();
	}
	
	
}
