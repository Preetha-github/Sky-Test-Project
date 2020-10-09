package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopPageNavigation {
	WebDriver driver;

	public ShopPageNavigation(MySharedClass mysharedclass) {
		driver = mysharedclass.startBrowser();
	}

	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		// Naviagte to url
		driver.navigate().to("https://www.sky.com/");
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Switch to cookie frame
		driver.switchTo().frame("sp_message_iframe_207015");

	}

	@Given("^I accept cookies$")
	public void i_accept_cookies() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 7);
		WebElement AgreeButton = driver.findElement(By.cssSelector(
				"body > div > div.message.type-modal > div.message-component.message-row.unstack > button:nth-child(2)"));
		// Wait for element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(AgreeButton));
		AgreeButton.click();
		// Switching to homepage
		driver.switchTo().defaultContent();

	}

	@When("^I navigate to ‘Products & Packages’$")
	public void i_navigate_to_Products_Packages() throws Throwable {
		// Locating and clicking Products & Packages
		driver.findElement(By.xpath("//a[contains(text(),'Products & Packages')]")).click();
	}

	@Then("^the user should be on the ‘https://www\\.sky\\.com/shop/’ page$")
	public void the_user_should_be_on_the_https_www_sky_com_shop_page() throws Throwable {

		// Checking user is on Skyshop page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("https://www.sky.com/shop/")) {
			System.out.println("User is on Sky shop page");
		} else {
			System.out.println("User is not on Sky shop page");
		}

	}

	@Then("^I should see tiles with text in it$")
	public void i_should_see_tiles_with_text_in_it() throws Throwable {
		// Locating tiles
		List<WebElement> TileElements = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div"));

		for (WebElement webElement : TileElements) {
			// Get the text of each tile
			System.out.println(webElement.getText());

		}
	}

	@When("^I click on ‘Our latest Offers’ section$")
	public void i_click_on_Our_latest_Offers_section() throws Throwable {
		// Navigating to Our latest offers
		driver.findElement(By.xpath("(//*[@id=\"root\"]/div/div[2]/div/div)[1]")).click();
	}

	@Then("^I see a list of offers with a price to it$")
	public void i_see_a_list_of_offers_with_a_price_to_it() throws Throwable {

		WebElement offer1 = driver.findElement(By.xpath("//*[@id=\"TPutv\"]"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		// Scroll down to the element

		executor.executeScript("arguments[0].scrollIntoView();", offer1);

		List<WebElement> offers = driver.findElements(By.xpath("//div[@class='c-offer-selection']"));
		List<WebElement> tvBroadbandoffers = new ArrayList<WebElement>();

		for (WebElement webElement : offers) {

			if (webElement.isDisplayed()) {
				tvBroadbandoffers.add(webElement);
			}

		}

		int TotalOffersCount = offers.size();

		System.out.println("Total offers available : " + TotalOffersCount);

		int tvBroadbandoffersCount = tvBroadbandoffers.size();
		System.out.println("Total TV & Broadband offers available : " + tvBroadbandoffersCount);
		Thread.sleep(3000);
		System.out.println("********************" );
		System.out.println("TV & Broadband deal : " );
		System.out.println("********************" );
		for (WebElement webElement : tvBroadbandoffers) {

			WebElement head = webElement.findElement(By.cssSelector("h3 strong"));

			System.out.println(head.getAttribute("innerHTML"));

			WebElement offerprice = webElement.findElement(By.cssSelector("div>span>span>span"));
			System.out.println("Price :  " + offerprice.getAttribute("innerHTML"));

		}

	}

}
