package uy.com.ces.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import uy.com.ces.core.DriverConfiguration;
import uy.com.ces.core.PropertiesConfiguration;
import uy.com.ces.core.pages.AuthorizationPage;
import uy.com.ces.core.pages.HomePage;
import uy.com.ces.core.pages.SystemManagementPage;

public abstract class TestBase {
	
    protected static WebDriver driver;

    protected static Properties prop = PropertiesConfiguration.loadProperties();

    public void takeScreenShot(String name) {
        Allure.attachment(name, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    public static void allureReportEnvInfo() throws IOException {

        // Get the values from the properties
        String seleniumVersion = prop.getProperty("seleniumJavaVersion");
        String browser = prop.getProperty("browser");
        String browserVersion = prop.getProperty("browserVersion");

        // Define the content for environment.properties
        String environmentContent = "Selenium.Java.Version=" + seleniumVersion + "\n"
                + "Browser=" + browser + "\n"
                + "Browser.Version=" + browserVersion;

        // Define the path for the environment.properties file
        String filePath = "allure-results/environment.properties";

        // Create the parent directory if it does not exist
        File parentDir = new File(filePath).getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        // Write the content to the environment.properties file
        FileWriter writer = new FileWriter(filePath);
        writer.write(environmentContent);
        writer.close();
    }

    @BeforeEach
    public void setUp() {
        driver = DriverConfiguration.configureDriver();   

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        HomePage homePage = authorizationPage.submitHashPassword();

        SystemManagementPage systemManagementPage = homePage.clickSystemManagement();
        systemManagementPage.uploadData();
        systemManagementPage.backPage();
    }

    @AfterEach()
    public void tearDown() throws IOException {
        allureReportEnvInfo();
        takeScreenShot("screenshot");

        HomePage homePage = new HomePage(driver);
        homePage.logout();

        if (driver != null) {
            driver.quit();
        }
    }

}
