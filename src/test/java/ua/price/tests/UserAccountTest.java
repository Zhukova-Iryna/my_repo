package ua.price.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.price.base.BaseTest;
import ua.price.data.bean.user.User;
import ua.price.steps.UserAccountSteps;

public class UserAccountTest extends BaseTest {
    private UserAccountSteps userAccountSteps;
    private User user;

    @BeforeClass
    protected void setUp() {
        driver.get(pagesUrl.accountUrl());
        userAccountSteps = new UserAccountSteps(driver);
        user = new User();
    }

    @Test
    protected void checkHobbyChosenSave() {
        userAccountSteps.loginToAccount(user.email(), user.password());
        Assert.assertTrue(userAccountSteps.isHobbyChecked(), "Wrong setting for hobby");
    }
}
