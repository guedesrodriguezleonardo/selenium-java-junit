package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {
	
	public static WebDriver driver;

	@BeforeAll
	public static void setUpDriver() {
		String browserName = System.getenv().getOrDefault("BROWSER", "chrome");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = getChromeDriver();
		} else {
			throw new UnsupportedOperationException("This TestBase only supports Chrome");
		}
	}

	@BeforeEach
	public abstract void setUpPage();

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}

	private static ChromeDriver getChromeDriver() {
		String path = System.getProperty("user.dir");
		System.out.println(path); 
        String chromeDriverPath = path + "/src/test/resources/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		return new ChromeDriver();
	}
    
}
