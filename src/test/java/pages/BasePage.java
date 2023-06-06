package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void clearElement(WebElement element) {
        waitUntilVisible(element);
        element.clear();
    }

    public void typeElement(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        waitUntilVisible(element);
        element.click();
    }

    public void waitForPageToLoad(String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public boolean isElementDisplayed(WebElement element) {
        waitUntilVisible(element);
        return element.isDisplayed();
    }

    public String getElementText(WebElement element) {
        waitUntilVisible(element);
        return element.getText();
    }

    public String getElementAttribute(WebElement element, String attribute) {
        waitUntilVisible(element);
        return element.getAttribute(attribute);
    }

}