package tests;

import org.testng.annotations.Test;

import hooks.TestNGHooks;
import pages.CreateLeads;
import pages.Home;
import pages.LeadsTab;
import pages.Login;
import pages.MyHome;
import pages.ViewLeads;

public class CreateLead extends TestNGHooks {

	@Test (dataProvider = "FetchExcelData")
	public void createLogin(String username, String password) {
	new Login().enterUsername(username).enterPassword(password).clickLogin();
	new Home().verifyhometitle().clickCRMSFA();
	new MyHome().Myhomepage().clickLeadsTab();
	new LeadsTab().checkLeadsTab();
	new CreateLeads().entercomname("CA").enterfirstname("Sudhakaran").enterlastname("V").clickCreate();
	new ViewLeads().viewLeadstitle();
	
	}
}
