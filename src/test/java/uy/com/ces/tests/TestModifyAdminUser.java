package uy.com.ces.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import uy.com.ces.core.pages.HomePage;
import uy.com.ces.core.pages.LoginPage;
import uy.com.ces.core.pages.UserProfilePage;
import uy.com.ces.core.pages.ViewUsersPage;

@DisplayName("Modify Admin User")
class TestModifyAdminUser extends TestBase {

    String email = prop.getProperty("email");
    String initialPassword = prop.getProperty("initialPassword");
    String modifiedName = prop.getProperty("modifiedName");
    String modifiedLastName = prop.getProperty("modifiedLastName");
    String modifiedEmail = prop.getProperty("modifiedEmail");
    String modifiedCountry = prop.getProperty("modifiedCountry");
    String successModifyMsg = prop.getProperty("successModifyMsg");

    @Test
    @Tag("regression")
    @Tag("adminData")
    @Description("Test case to modify an admin user's profile and verify the changes.")
    void testModifyAdminUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();

        homePage = loginPage.login(email, initialPassword);
        
        homePage.clickOk();
        UserProfilePage userProfilePage =    homePage.clickUserProfile();

        userProfilePage.enterName(modifiedName);
        userProfilePage.enterLastName(modifiedLastName);
        userProfilePage.enterEmail(modifiedEmail);
        userProfilePage.enterCountry(modifiedCountry);
        userProfilePage.clickConfirmChanges();

        assertEquals(userProfilePage.getElementText(userProfilePage.successfulMsg), successModifyMsg);

        userProfilePage.clickOk();
        userProfilePage.backPage();

        ViewUsersPage viewUsersPage = homePage.clickViewUsers();

        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.firstNameColumn, modifiedName));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.lastNameColumn, modifiedLastName));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.emailColumn, modifiedEmail));
        assertTrue(viewUsersPage.isUserDataInTable(viewUsersPage.countryColumn, modifiedCountry));
    }

}