package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Selections, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> windowshandle = driver.getWindowHandles();
			List<String> allwindows = new ArrayList<>(windowshandle);
			String window = allwindows.get(index);
			driver.switchTo().window(window);
			System.out.println("The Window is switched perfectly");
		} catch (Exception e) {
			System.err.println("The Window is not Switching");
		}
		
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("The frame is switched to"+ ele);
		} catch (NoSuchFrameException e) {
			System.err.println("No such Frame was found in the page");
		}

	}

	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("The Alert has been accepted");
		} catch (NoAlertPresentException  e) {
			System.err.println("Alert was not present to accept");
		}
	
	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("The Alert has been dismissed");
		} catch (NoAlertPresentException  e) {
			System.err.println("Alert was not present to dismiss");
		}

	}

	@Override
	public String getAlertText() {
		try {
		String text = driver.switchTo().alert().getText();
			System.out.println(text);
		} catch (NoAlertPresentException  e) {
			System.err.println("Alert was not present to get text");
		}
		return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		 
		try {
			new Select(ele).selectByVisibleText(value);
			System.out.println(value + "is selected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(value +"is not selected");
		}

	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			System.out.println(value + "is selected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(value +"is not selected");
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			System.out.println(index + "is selected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(index +"is not selected");
		}
	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+data);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+data);
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		try {
			String text = ele.getText();
			System.out.println(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("text was not read");
		}
		return null;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		
	try {
		String verifyexacttext = ele.getText();
		if(verifyexacttext.equals(expectedText));
		System.out.println("The text match was successful");
	} catch (Exception e) {
		
		System.err.println("The match was not successfull");
	
	}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String verifypartialtext = ele.getText();
			if(verifypartialtext.contains(expectedText));
			System.out.println("The text contains" + expectedText);
		} catch (Exception e) {
		
			System.err.println("The text does not contain" +  expectedText);
		}
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String verifyexactattribute = ele.getAttribute(attribute);
			if(attribute.equalsIgnoreCase(value));
			System.out.println("The attribute matches :" + value);
		} catch (Exception e) {
			
			System.err.println("The attribute does not match:" +  value);
		}
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String verifypartialattribute = ele.getAttribute(attribute);
			if(attribute.contains(value));
			System.out.println("The attribute contains" + value);
		} catch (Exception e) {
			
			System.err.println("The attribute does not contain" +  value);

	}

	}

	@Override
	public void verifySelected(WebElement ele) {
		
		try {
			boolean verifyselected = ele.isSelected();
			if(verifyselected == true) {
				System.out.println("The element is selected");
			}
		} catch (Exception e) {
			System.out.println("The element is not selected");
		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			boolean verifyselected = ele.isDisplayed();
			if(verifyselected == true) {
				System.out.println("The element is displayed");
			}
		} catch (Exception e) {
			System.out.println("The element is not displayed");
		}

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		
		try {
			if(driver.getTitle().equalsIgnoreCase(expectedTitle))
					{
				System.out.println("The Title matches exactly" + expectedTitle);
			}
		} catch (Exception e) {
			System.err.println("The Title does not match exactly with " + expectedTitle);
		}
		
		return false;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			if(driver.getTitle().contains(expectedTitle))
					{
				System.out.println("The Title matches exactly" + expectedTitle);
			}
		} catch (Exception e) {
			System.err.println("The Title does not match exactly with " + expectedTitle);
		}
		
		return false;
	}

	@Override
	public void closeActiveBrowser() {
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();
	}





}
