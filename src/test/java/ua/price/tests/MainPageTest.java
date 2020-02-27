package ua.price.tests;

import org.testng.annotations.*;
import ua.price.site.base.BaseTest;

import static org.testng.Assert.*;

public class MainPageTest extends BaseTest {
    @BeforeClass
    protected void setUp() {
        driver.get(pagesUrl.baseUrl());
    }

    @Test
    protected void checkPositiveLoginScenario() {
        authSteps.openMainPage();
        authSteps.openAuthenticationForm();
        authSteps.login(user);
        authSteps.waitUntilPageLoaded();
        assertNotEquals(authSteps.getAccountLinkName(), "Вход", "Text doesn't change in authentication block");
    }

    @Test
    protected void checkNegativeLoginScenario() {
        authSteps.openMainPage();
        authSteps.openAuthenticationForm();
        authSteps.login(user);
        authSteps.waitUntilPageLoaded();
        assertTrue(authSteps.isErrorMessageDisplayed(), "Error message doesn't appears");
    }

    @Test
    protected void checkPositiveRegistrationScenario() {
        authSteps.openMainPage();
        authSteps.openAuthenticationForm();
        authSteps.openRegistrationTabInAuthenticationForm();
        authSteps.registration(user);
        authSteps.waitUntilPageLoaded();
        assertTrue(authSteps.isSuccessfulRegistrationMessageAppears(), "Successful registration message doesn't appear");
    }

    @Test
    protected void checkNegativeRegistrationScenario() {
        authSteps.openMainPage();
        authSteps.openAuthenticationForm();
        authSteps.openRegistrationTabInAuthenticationForm();
        authSteps.registration(user);
        authSteps.waitUntilPageLoaded();
        assertTrue(authSteps.isErrorMessageDisplayed(), "Error message doesn't appears");
    }

    @Test
    protected void checkUsersLogout() {
        authSteps.openMainPage();
        authSteps.openAuthenticationForm();
        authSteps.login(user);
        authSteps.logout();
        assertEquals(authSteps.getAccountLinkName(), "Вход", "User doesn't logout");
    }
}
