package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SystemManagementPage extends BasePage {

    public SystemManagementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'CARGAR')]")
    WebElement uploadData;

    @FindBy(xpath = "//button[contains(text(),'BORRAR')]")
    WebElement cleanData;

    public void uploadData() {
        clickElement(uploadData);
        clickConfirm();
        clickOk();
    }

}