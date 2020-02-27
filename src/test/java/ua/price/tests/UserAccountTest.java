package ua.price.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.price.site.base.BaseTest;

public class UserAccountTest extends BaseTest {
    @BeforeClass
    protected void setUp() {
        driver.get(pagesUrl.accountUrl());
    }

    @Test
    protected void checkHobbyChosenSave() {
        userAccountSteps.loginToAccount(user);
        userAccountSteps.setCheckingHobby(driver);
        Assert.assertTrue(userAccountSteps.isSuccessSaveMessageAppears(), "Wrong setting for hobby");
    }
}
