package ua.price.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.price.properties.PropertyReader;

public class DriverUtils {
    public static WebDriver initDrivers(String browser) {
        WebDriver driver;
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PropertyReader.getProperty("chrome_driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", PropertyReader.getProperty("firefox_driver"));
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown browser: %s", browser));
        }
        driver.manage().window().maximize();
        return driver;
    }
}
