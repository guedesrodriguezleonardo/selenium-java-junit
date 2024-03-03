package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage {

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "inputFirstName")
    WebElement nameInput;

    @FindBy(name = "inputLastName")
    WebElement lastNameInput;

    @FindBy(name = "inputEmail")
    WebElement emailInput;

    @FindBy(name = "inputCountry")
    WebElement countryInput;

    @FindBy(xpath = "//button[contains(text(),'Confirmar cambios')]")
    WebElement confirmChangesBtn;

    public void enterName(String name) {
        typeElement(nameInput, name);
    }

    public void enterLastName(String lastName) {
        typeElement(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
        typeElement(emailInput, email);
    }

    public void enterCountry(String country) {
        typeElement(countryInput, country);
    }

    public void clickConfirmChanges() {
        clickElement(confirmChangesBtn);
    }

}