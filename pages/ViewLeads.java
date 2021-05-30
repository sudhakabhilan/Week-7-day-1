package pages;

import org.openqa.selenium.By;

import hooks.TestNGHooks;



public class ViewLeads extends TestNGHooks{

	public ViewLeads viewLeadstitle() {
		
		verifyPartialTitle("View lead");
		
	
		return this;
	}
}
