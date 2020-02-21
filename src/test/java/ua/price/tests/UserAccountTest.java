package ua.price.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.price.base.BaseTest;
import ua.price.pages.UserAccountPage;

import static ua.price.properties.PropertyReader.getProperty;

public class UserAccountTest extends BaseTest {
    private UserAccountPage accountPage;
    private String accountUrl;
    private String userEmail;
    private String userPassword;

    @BeforeClass
    protected void setUp() {
        accountUrl = getProperty("account_url");
        userEmail = getProperty("login_email");
        userPassword = getProperty("login_password");
        driver.get(accountUrl);
        accountPage = new UserAccountPage(driver);
        accountPage.loginToAccount(userEmail, userPassword);
    }

    @Test
    protected void checkHobbyChosenSave() {
        Assert.assertTrue(accountPage.isHobbyChecked(), "Wrong setting for hobby");
    }
}
