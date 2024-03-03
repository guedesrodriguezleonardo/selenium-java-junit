package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "inputEmail")
    WebElement emailInput;

    @FindBy(name = "inputPassword")
    WebElement passwordInput;

    @FindBy(name = "inputRepeatPassword")
    WebElement repeatPasswordInput;

    @FindBy(id = "btnReset")
    WebElement resetPasswordBtn;

    public void enterEmail(String email) {
        typeElement(emailInput, email);
    }

    public void enterPassword(String password, String repeatedPassword) {
        typeElement(passwordInput, password);
        typeElement(repeatPasswordInput, repeatedPassword);
    }

    public HomePage clickResetPassword() {
        clickElement(resetPasswordBtn);
        return new HomePage(driver);
    }

}