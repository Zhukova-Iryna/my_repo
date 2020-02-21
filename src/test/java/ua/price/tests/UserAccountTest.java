package ua.price.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.price.base.BaseTest;
import ua.price.pages.UserAccountPage;

public class UserAccountTest extends BaseTest {
    private UserAccountPage accountPage;

    @BeforeClass
    protected void setUp() {
        driver.get(accountUrl);
        accountPage = new UserAccountPage(driver);
        accountPage.loginToAccount(email, password);
    }

    @Test
    protected void checkHobbyChosenSave() {
        Assert.assertTrue(accountPage.isHobbyChecked(), "Wrong setting for hobby");
    }
}
