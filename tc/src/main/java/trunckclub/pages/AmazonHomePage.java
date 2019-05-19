package trunckclub.pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {

	WebDriver driver;
	By searchBar = By.id("twotabsearchtextbox");
	By listSuggestions = By.xpath("//*[@id='suggestions']/div");

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;

	}

	// enter text in search bar
	public void setSearchName(String strSrchName) {

		driver.findElement(searchBar).sendKeys(strSrchName);
	}

	public List<WebElement> getsuggestions() {
		return driver.findElements(listSuggestions);
	}
}
