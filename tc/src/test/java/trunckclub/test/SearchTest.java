package trunckclub.test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import bsh.classpath.BshClassPath.GeneratedClassSource;
import trunckclub.pages.AmazonHomePage;

public class SearchTest {

	WebDriver driver;

	AmazonHomePage amazonSearchPage;

	@BeforeTest

	public void setup() {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

	@Test(priority = 0)

	public void test_Home_Page_Appear_Correct() {

		// Create Login Page object
		amazonSearchPage = new AmazonHomePage(driver);
		amazonSearchPage.setSearchName("lap");

		Iterator<WebElement> itr = amazonSearchPage.getsuggestions().iterator();

		while (itr.hasNext()) {

			WebElement we = itr.next();
			Assert.assertTrue(we.getAttribute("data-keyword").contains("lap"));
			System.out.println(we.getAttribute("data-keyword"));

		}
	}
}
