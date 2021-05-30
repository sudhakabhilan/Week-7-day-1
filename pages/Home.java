package pages;

import org.openqa.selenium.By;

import hooks.TestNGHooks;



public class Home extends TestNGHooks{
	
public Home verifyhometitle()
{
	verifyPartialTitle("Welcome");
	
	return this;
	
	}

public Login verifylogout(){
	
	click(locateElement("class","decorativeSubmit"));
	
	
	return new Login();
}
public MyHome clickCRMSFA() {
	click(locateElement("link","CRM/SFA"));
	
	return new MyHome();
}
}
