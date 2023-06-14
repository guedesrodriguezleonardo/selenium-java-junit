package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import pages.HomePage;

public class TestOne extends TestBase {

	@BeforeEach
	public void setUpPage() {
	}
	
	@Test
	public void testTC01() {
		HomePage homePage = new HomePage(driver);
		homePage.navigateToHome();
		homePage.checkHomePage();

 		assertTrue(homePage.isLogoDisplayed(), "Logo should be displayed on the home page.");
	}
}
