package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "inputEmail")
    WebElement emailInput;

    @FindBy(name = "inputPassword")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Iniciar Sesión')]")
    WebElement loginBtn;

    public void enterEmail(String email) {
        typeElement(emailInput, email);
    }

    public void enterPassword(String password) {
        typeElement(passwordInput, password);
    }

    public void clickLogin() {
        clickElement(loginBtn);
    }

    public HomePage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        return new HomePage(driver);
    }


}