package uy.com.ces.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import uy.com.ces.core.pages.ForgotPasswordPage;
import uy.com.ces.core.pages.HomePage;
import uy.com.ces.core.pages.LoginPage;

@DisplayName("Forgot Password")
class TestForgotPassword extends TestBase {

    String email = prop.getProperty("email");
    String newPassword = prop.getProperty("newPassword");
    String successResetPasswordMsg = prop.getProperty("successResetPasswordMsg");
    String username = prop.getProperty("username");
    String successLoginMsg = prop.getProperty("successLoginMsg");

    @Test
    @Tag("regression")
    @Tag("adminData")
    @Description("Test case to reset a forgotten password and verify login with the new password.")
    void testForgotPassword() {
        HomePage homePage = new HomePage(driver);
        ForgotPasswordPage forgotPasswordPage = homePage.clickResetPassword();

        forgotPasswordPage.enterEmail(email);
        forgotPasswordPage.enterPassword(newPassword, newPassword);
        homePage = forgotPasswordPage.clickResetPassword();

        assertEquals(forgotPasswordPage.getElementText(forgotPasswordPage.successfulMsg), successResetPasswordMsg);
        
        homePage.clickOk();
        LoginPage loginPage = homePage.clickLogin();

        homePage = loginPage.login(email, newPassword);

        assertEquals(loginPage.getElementText(loginPage.successfulMsg), successLoginMsg);
        assertTrue(homePage.getElementText(homePage.userDropdown).contains(username));

        homePage.clickOk();
    }

}