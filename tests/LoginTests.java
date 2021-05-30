package tests;

import org.testng.annotations.Test;

import hooks.TestNGHooks;
import pages.Login;

public class LoginTests extends TestNGHooks{
	
	@Test
	public void LoginTest() {
		
		new Login().enterUsername("DemoSalesManager").enterPassword("crmsfa").clickLogin();
		
	}
	

}
