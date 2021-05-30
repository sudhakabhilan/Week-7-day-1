package pages;

import org.openqa.selenium.By;

import hooks.TestNGHooks;



public class MyHome extends TestNGHooks{

	public MyHome Myhomepage() {
		
		verifyPartialTitle("In My Homepage now");
		
		return this;
			
	}
	public LeadsTab clickLeadsTab() {
		
		click(locateElement("link","Leads"));
		
		return new LeadsTab();
	}
}
