package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uy.com.ces.core.PropertiesConfiguration;

public class AuthorizationPage extends BasePage {

    String hashPassword = PropertiesConfiguration.getProperty("hashPassword");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl);
    }

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    public HomePage submitHashPassword() {
        typeElement(passwordField, hashPassword);
        clickElement(submitBtn);
        return new HomePage(driver);
    }

}