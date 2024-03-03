package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateTesterPage extends BasePage {

    public CreateTesterPage(WebDriver driver) {
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
    WebElement createAccountBtn;

    @FindBy(id = "testerJunior")
    WebElement testerJunior;

    @FindBy(id = "testerSenior")
    WebElement testerSenior;

    @FindBy(id = "testerLead")
    WebElement testerLead;

    public void enterName(String name) {
        typeElement(nameInput, name);
    }

    public void enterLastName(String lastName) {
        typeElement(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
        typeElement(emailInput, email);
    }

    public void enterPassword(String password) {
        typeElement(passwordInput, password);
    }

    public void selectCountry(String country) {
        Select select = new Select(countryInput);
        select.selectByVisibleText(country);
    }

    public void selectTesterRole(String role) {
        String normalizedRole = role.replaceAll(" ", "").toLowerCase();

        WebElement testerRole = 
            "testerjunior".equals(normalizedRole) ? testerJunior :
            "testersenior".equals(normalizedRole) ? testerSenior :
            "testerlead".equals(normalizedRole) ? testerLead :
            null;

        if (testerRole == null) {
            throw new IllegalArgumentException("Invalid tester role: " + role);
        }

        testerRole.click();
    }

    public HomePage clickCreateAccount() {
        clickElement(createAccountBtn);
        return new HomePage(driver);
    }

}