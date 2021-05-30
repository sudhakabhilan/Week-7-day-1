package pages;

import org.openqa.selenium.By;

import hooks.TestNGHooks;



public class LeadsTab extends TestNGHooks{
	
	public LeadsTab checkLeadsTab()
	{
		
		click(locateElement("link","Create Lead"));
		return this;
		
	}

}
