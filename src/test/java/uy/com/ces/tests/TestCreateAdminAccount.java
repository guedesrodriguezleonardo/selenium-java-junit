package uy.com.ces.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import uy.com.ces.core.pages.HomePage;
import uy.com.ces.core.pages.LoginPage;
import uy.com.ces.core.pages.SignUpPage;
import uy.com.ces.core.pages.ViewUsersPage;

@DisplayName("Create Admin Account")
class TestCreateAdminAccount extends TestBase {

    String createName = prop.getProperty("createName");
    String createLastName = prop.getProperty("createLastName");
    String createEmail = prop.getProperty("createEmail");
    String createPassword= prop.getProperty("createPassword");
    String createCountry = prop.getProperty("createCountry");
    String successSignUpMsg = prop.getProperty("successSignUpMsg");

    @Test
    @Tag("regression")
    @Tag("adminData")
    @Description("Test case to create an admin account and verify user details.")
    void testCreateAdminAccount() {        
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUp();

        signUpPage.enterName(createName);
        signUpPage.enterLastName(createLastName);
        signUpPage.enterEmail(createEmail);
        signUpPage.enterPassword(createPassword, createPassword);
        signUpPage.enterCountry(createCountry);
        homePage = signUpPage.clickSignUp();

        assertEquals(signUpPage.getElementText(signUpPage.successfulMsg), successSignUpMsg);
        
        homePage.clickOk();
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(createEmail, createPassword);

        homePage.clickOk();
        ViewUsersPage viewUsersPage = homePage.clickViewUsers();

        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.firstNameColumn, createName));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.lastNameColumn, createLastName));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.emailColumn, createEmail));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.countryColumn, createCountry));
    }

}