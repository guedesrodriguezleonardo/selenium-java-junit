package uy.com.ces.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import uy.com.ces.core.pages.HomePage;
import uy.com.ces.core.pages.LoginPage;
import uy.com.ces.core.pages.ViewUsersPage;

@DisplayName("Delete Tester Account")
class TestDeleteTesterAccount extends TestBase {

    String email = prop.getProperty("email");
    String password = prop.getProperty("initialPassword");
    String deleteTesterEmail = prop.getProperty("deleteTesterEmail");
    String successTesterDeleteMsg = prop.getProperty("successTesterDeleteMsg");

    @Test
    @Tag("regression")
    @Tag("testerData")
    @Description("Test case to delete a tester account and verify user deletion.")
    void testDeleteTesterAccount() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(email, password);
        
        homePage.clickOk();
        ViewUsersPage viewUsersPage = homePage.clickViewUsers();

        viewUsersPage.clickUserDelete(deleteTesterEmail);
        viewUsersPage.clickConfirm();

        assertEquals(viewUsersPage.getElementText(viewUsersPage.successfulMsg), successTesterDeleteMsg);

        viewUsersPage.clickOk();

        assertFalse(viewUsersPage.isUserDataInTable(viewUsersPage.emailColumn, deleteTesterEmail));
    }

}