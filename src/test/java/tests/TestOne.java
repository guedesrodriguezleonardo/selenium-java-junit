package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	}
}
