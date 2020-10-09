package stepDefinition;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditorialAndGenericSearch {

	WebDriver driver;

	public EditorialAndGenericSearch(MySharedClass mysharedclass) {
		driver = mysharedclass.startBrowser();
	}

	@When("^I search ‘sky’ in the search bar$")
	public void i_search_sky_in_the_search_bar() throws Throwable {

		// Dismiss and clicking the notification
		WebElement DismissNotification = driver.findElement(By.xpath("//button[@aria-label='Dismiss notification']"));
		DismissNotification.click();

		// Locating the search icon and clicking
		WebElement searchicon = driver
				.findElement(By.xpath("//button[@class='c-link-faux mast-c-user-actions__btn mast-c-search-icon']"));
		searchicon.click();

		// Enter the search word - "sky" and hitting Enter key
		driver.findElement(By.xpath("//*[@data-test-id='input-box']")).sendKeys("sky" + Keys.ENTER);

		driver.get("https://www.sky.com/new-search?q=sky");
	}

	@Then("^I should see an editorial section\\.$")
	public void i_should_see_an_editorial_section() throws Throwable {

		boolean editorialSection = driver
				.findElement(By.xpath("//div[@class='c-editorial-layer c-tile in-view no-anim']")).isDisplayed();
		
		//Check Editorial section is displayed
		if (editorialSection) {
			System.out.println("Editorial section is displayed");

		} else {
			System.out.println("Editorial section is NOT displayed");
		}

		/*
		 * // Verify Editorial Layer Title
		 * 
		 * String EditorialLayerTitle =
		 * driver.findElement(By.xpath("//a[@class='c-editorial-layer__title']")).
		 * getText(); System.out.println("Editorial Layer Title is : " +
		 * EditorialLayerTitle);
		 * 
		 * // Verify Editorial Layer Text
		 * 
		 * String EditorialLayerText =
		 * driver.findElement(By.xpath("//p[@class='c-editorial-layer__text']")).getText
		 * (); System.out.println("Editorial Layer Text is : " + EditorialLayerText);
		 * 
		 * // Verify Image is displayed/ visible
		 * 
		 * WebElement Image =
		 * driver.findElement(By.xpath("//img[@class='c-editorial-layer__image']"));
		 * 
		 * if (Image.getAttribute("naturalWidth").equals("0")) {
		 * System.out.println("Editorial Image is broken "); } else {
		 * System.out.println("Editorial Image is visible "); }
		 * 
		 * // Verify Editorial Layer links
		 * 
		 * List<WebElement> lists = driver .findElements(By.
		 * xpath("//ul[@class='c-editorial-layer__links o-list-bare']/li"));
		 * System.out.println("Editorial Layer Links : "); for (WebElement webElement :
		 * lists) {
		 * 
		 * System.out.println(webElement.getText());
		 * 
		 * }
		 */
	}

}
