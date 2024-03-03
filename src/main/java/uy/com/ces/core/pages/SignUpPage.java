package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "inputFirstName")
    WebElement nameInput;

    @FindBy(name = "inputLastName")
    WebElement lastNameInput;

    @FindBy(name = "inputEmail")
    WebElement emailInput;

    @FindBy(name = "inputPassword")
    WebElement passwordInput;

    @FindBy(name = "inputRepeatPassword")
    WebElement repeatPasswordInput;

    @FindBy(name = "inputCountry")
    WebElement countryInput;

    @FindBy(id = "btnRegister")
    WebElement signUpBtn;

    public void enterName(String name) {
        typeElement(nameInput, name);
    }

    public void enterLastName(String lastName) {
        typeElement(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
        typeElement(emailInput, email);
    }

    public void enterPassword(String password, String repeatedPassword) {
        typeElement(passwordInput, password);
        typeElement(repeatPasswordInput, repeatedPassword);
    }

    public void enterCountry(String country) {
        typeElement(countryInput, country);
    }

    public HomePage clickSignUp() {
        clickElement(signUpBtn);
        return new HomePage(driver);
    }

}