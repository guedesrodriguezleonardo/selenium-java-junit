package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    private static String url = "https://www.bing.com/";

    // Constructor

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    //Locators
    
	@FindBy(id = "bLogo")
    private WebElement logo;
    
    //Functions

    public void navigateToHome() {
        navigateTo(url);
    }

    public void checkHomePage() {
        isElementDisplayed(logo);
    }

}
