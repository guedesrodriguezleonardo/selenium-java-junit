package uy.com.ces.core.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewUsersPage extends BasePage {

    public ViewUsersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[1]")
    public List<WebElement> firstNameColumn;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> lastNameColumn;

    @FindBy(xpath = "//td[3]")
    public List<WebElement> emailColumn;

    @FindBy(xpath = "//td[4]")
    public List<WebElement> countryColumn;

    @FindBy(xpath = "//td[5]")
    public List<WebElement> roleColumn;

    public boolean isUserDataInTable(List<WebElement> column, String targetValue) {
        return isValueInColumn(column, targetValue);
    }

    public WebElement userDeleteBtn(String email) {
        return driver.findElement(By.id(email));
    }

    public void clickUserDelete(String email) {
        clickElement(userDeleteBtn(email));
    }

}