package ua.price.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static ua.price.properties.PropertyReader.*;

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
                System.setProperty("webdriver.chrome.driver", getProperty("chrome_driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getProperty("firefox_driver"));
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", getProperty("ie_driver"));
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown browser: %s", browser));
        }
    }

    @AfterMethod
    protected void tearDown() throws Exception {
        driver.quit();
    }
}
