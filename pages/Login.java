package pages;

import org.openqa.selenium.By;

import hooks.TestNGHooks;



public class Login extends TestNGHooks {
	
	public Login enterUsername(String useid) {
		type(locateElement("id", "username"), useid);
		
		return this;
		
	}

	public Login enterPassword(String pwd) {
		type(locateElement("id", "password"), pwd);
	
		return this;
		
	}
	
	public Login clickLogin() {
		click(locateElement("class","decorativeSubmit" ));
		return this;
		
	}
	

}