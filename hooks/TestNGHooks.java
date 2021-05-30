package hooks;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ReadExcelForDataProvider;
import wrappers.BaseDriver;

public class TestNGHooks extends BaseDriver{
	
	@BeforeSuite
	public void setUpSuites() {
		
	}
	@BeforeTest
	public void setUpTests() {
		
	}
	@BeforeClass
	public void setUpClass() {
		
	}
	@BeforeMethod
	public void Launch() {
		startApp("chrome", "http://leaftaps.com/opentaps");
	}
	@AfterMethod
	public void close() {
		closeActiveBrowser();
	}
	@AfterClass
	public void afterClass() {
		
	}
	@AfterTest
	public void afterTest() {
		
	}
	@AfterSuite
	public void reports() {
		
	}
	
	@DataProvider(name = "FetchExcelData")
	public Object[][] readExcelData() {
		
		try {
			return ReadExcelForDataProvider.readExcelData("");
		} catch (InvalidFormatException e) {
			System.err.println("The excel is in invalid format. Looks corrupted");
			e.printStackTrace();
		} catch (IOException e) {
			
			System.err.println("The file does not exist");
			
		}
		
	return null;
			
	
	}
				
	@Before
	public void test() {}
	
	@After
	public void test1() {}
}
