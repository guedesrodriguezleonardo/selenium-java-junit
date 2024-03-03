package uy.com.ces.core.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uy.com.ces.core.PropertiesConfiguration;

public class BasePage {

    WebDriver driver;

    protected static Properties prop = PropertiesConfiguration.loadProperties();

    int timeout = Integer.parseInt(PropertiesConfiguration.getProperty("timeout"));
    String baseUrl = PropertiesConfiguration.getProperty("baseUrl");

    @FindBy(id = "swal2-html-container")
    public WebElement successfulMsg;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public WebElement okBtn;

    @FindBy(xpath = "//button[contains(text(),'Sí')]")
    WebElement confirmBtn;

    @FindBy(xpath = "//button[contains(text(),'Cancelar')]")
    WebElement cancelBtn;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void backPage() {
        driver.navigate().back();
    }

    public void waitForElementDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitForElementToDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void clickElement(WebElement element) {
        waitForElementDisplayed(element);
        element.click();
    }

    public void clearElement(WebElement element) {
        waitForElementDisplayed(element);
        element.clear();
    }

    public void typeElement(WebElement element, String text) {
        waitForElementDisplayed(element);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            waitForElementDisplayed(element);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getElementText(WebElement element) {
        waitForElementDisplayed(element);
        return element.getText();
    }

    public String getElementAttribute(WebElement element, String attribute) {
        waitForElementDisplayed(element);
        return element.getAttribute(attribute);
    }

    public String getElementTagName(WebElement element) {
        waitForElementDisplayed(element);
        return element.getTagName();
    }

    public void waitForUrlToMatch(String relativeUrl) {
        String fullUrl = baseUrl + relativeUrl;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.urlToBe(fullUrl));
    }

    public static boolean isValueInColumn(List<WebElement> column, String targetValue) {
        for (WebElement element : column) {
            String text = element.getText();
            if (text.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    public void clickOk() {
        clickElement(okBtn);
        waitForElementToDisappear(okBtn);
    }

    public void clickConfirm() {
        clickElement(confirmBtn);
    }

    public void clickCancel() {
        clickElement(cancelBtn);
    }

}
