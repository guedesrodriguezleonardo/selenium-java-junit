package uy.com.ces.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Properties;

public class DriverConfiguration {

    protected static Properties prop = PropertiesConfiguration.loadProperties();

    private DriverConfiguration() {
    }

    public static WebDriver configureDriver() {
        // Load properties from config.properties
        
        String browser = prop.getProperty("browser");

        if ("Google Chrome".equals(browser)) {

            // Web driver configuration for Google Chrome
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--lang=es_ES.UTF-8");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;

        } else if ("Mozilla Firefox".equals(browser)) {

            // Web driver configuration for Mozilla Firefox
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;

        } else {
            throw new IllegalArgumentException("Invalid browser specified in config.properties: " + browser);
        }
    }
}