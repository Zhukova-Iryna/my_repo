package ua.price.site.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.price.site.data.PagesUrl;
import ua.price.site.data.bean.user.User;
import ua.price.site.steps.AuthenticationSteps;
import ua.price.site.steps.SearchSteps;
import ua.price.site.steps.UserAccountSteps;

import static ua.price.utils.DriverUtils.initDrivers;

public abstract class BaseTest {
    protected WebDriver driver;
    protected AuthenticationSteps authSteps;
    protected SearchSteps searchSteps;
    protected UserAccountSteps userAccountSteps;
    protected PagesUrl pagesUrl;
    protected User user;

    @Parameters("browser")
    @BeforeClass
    protected void setUp(@Optional("chrome") String browser) {
        this.driver = initDrivers(browser);
        authSteps = new AuthenticationSteps(driver);
        searchSteps = new SearchSteps(driver);
        userAccountSteps = new UserAccountSteps(driver);
        pagesUrl = new PagesUrl();
        user = new User();
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }
}
