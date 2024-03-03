package uy.com.ces.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import uy.com.ces.core.pages.CreateTesterPage;
import uy.com.ces.core.pages.HomePage;
import uy.com.ces.core.pages.LoginPage;
import uy.com.ces.core.pages.ViewUsersPage;

@DisplayName("Create Tester Account")
class TestCreateTesterAccount extends TestBase {

    String email = prop.getProperty("email");
    String password = prop.getProperty("initialPassword");
    String createTesterName = prop.getProperty("createTesterName");
    String createTesterLastName = prop.getProperty("createTesterLastName");
    String createTesterEmail = prop.getProperty("createTesterEmail");
    String createTesterPassword= prop.getProperty("createTesterPassword");
    String createTesterCountry = prop.getProperty("createTesterCountry");
    String createTesterRole = prop.getProperty("createTesterRole");
    String successTesterCreationMsg = prop.getProperty("successSignUpMsg");
    String successLoginMsg = prop.getProperty("successLoginMsg");

    @Test
    @Tag("regression")
    @Tag("testerData")
    @Description("Test case to create a tester account and verify user details.")
    void testCreateTesterAccount() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();

        homePage = loginPage.login(email, password);

        homePage.clickOk();
        CreateTesterPage createTesterPage = homePage.clickCreateUser();

        createTesterPage.enterName(createTesterName);
        createTesterPage.enterLastName(createTesterLastName);
        createTesterPage.enterEmail(createTesterEmail);
        createTesterPage.enterPassword(createTesterPassword);
        createTesterPage.selectCountry(createTesterCountry);
        createTesterPage.selectTesterRole(createTesterRole);
        homePage = createTesterPage.clickCreateAccount();

        assertEquals(createTesterPage.getElementText(createTesterPage.successfulMsg), successTesterCreationMsg);

        homePage.clickOk();
        ViewUsersPage viewUsersPage = homePage.clickViewUsers();

        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.firstNameColumn, createTesterName));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.lastNameColumn, createTesterLastName));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.emailColumn, createTesterEmail));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.countryColumn, createTesterCountry));
    }

}