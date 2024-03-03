package uy.com.ces.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    String loginUrl = prop.getProperty("loginUrl");
    String signUpUrl = prop.getProperty("signUpUrl");
    String forgotPasswordUrl = prop.getProperty("forgotPasswordUrl");
    String systemManagementUrl= prop.getProperty("systemManagementUrl");
    String createUserUrl = prop.getProperty("createUserUrl");
    String viewUsersUrl = prop.getProperty("viewUsersUrl");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(partialLinkText = "Iniciar ses")
    WebElement loginBtn;

    @FindBy(linkText = "Registrarse")
    WebElement signUpBtn;

    @FindBy(partialLinkText = "Reiniciar")
    WebElement resetPasswordBtn;

    @FindBy(partialLinkText = "sistema")
    WebElement systemManagementBtn;

    @FindBy(linkText = "Crear usuario")
    WebElement createUserBtn;

    @FindBy(linkText = "Ver usuarios")
    WebElement viewUsersBtn;

    @FindBy(className = "dropdown")
    public
    WebElement userDropdown;

    @FindBy(linkText = "Cerrar sesión")
    public
    WebElement logOutBtn;

    @FindBy(linkText = "Perfil")
    WebElement userProfileBtn;

    public LoginPage clickLogin() {
        clickElement(loginBtn);
        waitForUrlToMatch(loginUrl);
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp() {
        clickElement(signUpBtn);
        waitForUrlToMatch(signUpUrl);
        return new SignUpPage(driver);
    }

    public ForgotPasswordPage clickResetPassword() {
        clickElement(resetPasswordBtn);
        waitForUrlToMatch(forgotPasswordUrl);
        return new ForgotPasswordPage(driver);
    }

    public SystemManagementPage clickSystemManagement() {
        clickElement(systemManagementBtn);
        waitForUrlToMatch(systemManagementUrl);
        return new SystemManagementPage(driver);
    }

    public CreateTesterPage clickCreateUser() {
        clickElement(createUserBtn);
        waitForUrlToMatch(createUserUrl);
        return new CreateTesterPage(driver);
    }

    public ViewUsersPage clickViewUsers() {
        clickElement(viewUsersBtn);
        waitForUrlToMatch(viewUsersUrl);
        return new ViewUsersPage(driver);
    }
    public UserProfilePage clickUserProfile() {
        clickElement(userDropdown);
        clickElement(userProfileBtn);
        return new UserProfilePage(driver);

    }

    public void logout() {
        clickElement(userDropdown);
        clickElement(logOutBtn);
        clickConfirm();
        clickOk();
    }



}