package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MySharedClass {
	
	WebDriver driver;
	
	@Before
	public WebDriver startBrowser() {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/preethasoundararajan/Desktop/Tools/Selenium/driver/chromedriver");
		if (driver==null)
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
		driver=null;
	}

}
