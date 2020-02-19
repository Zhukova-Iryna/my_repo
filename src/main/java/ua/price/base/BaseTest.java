package ua.price.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import ua.price.properties.PropertyReader;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    protected void setUp(@Optional("chrome") String browser) throws Exception {
        initDrivers(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void initDrivers(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PropertyReader.getProperty("chrome_driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", PropertyReader.getProperty("firefox_driver"));
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", PropertyReader.getProperty("ie_driver"));
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown browser", browser));
        }
    }

    @AfterMethod
    protected void tearDown() throws Exception {
        driver.quit();
    }
}
