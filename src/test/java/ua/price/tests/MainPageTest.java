package ua.price.tests;

import org.testng.annotations.*;
import ua.price.base.BaseTest;
import ua.price.data.bean.user.User;
import ua.price.steps.AuthenticationSteps;

import static org.testng.Assert.*;

public class MainPageTest extends BaseTest {
    private AuthenticationSteps authSteps;
    private User user;

    @BeforeClass
    protected void setUp() {
        driver.get(pagesUrl.baseUrl());
        authSteps = new AuthenticationSteps(driver);
        user = new User();
    }

    @Test
    protected void checkPositiveLoginScenario() {
        authSteps.openAuthenticationForm();
        authSteps.login(user.email(), user.password());
        authSteps.waitUntilPageLoaded();
        assertNotEquals(authSteps.getAccountLinkName(), "Вход", "Text doesn't change in authentication block");
    }

    @Test
    protected void checkNegativeLoginScenario() {
        authSteps.openAuthenticationForm();
        authSteps.login(user.email(), user.regPassword());
        authSteps.waitUntilPageLoaded();
        assertTrue(authSteps.isErrorMessageDisplayed(), "Error message doesn't appears");
    }

    @Test
    protected void checkPositiveRegistrationScenario() {
        authSteps.openAuthenticationForm();
        authSteps.openRegistrationTabInAuthenticationForm();
        authSteps.registration(user.regEmail(), user.regPassword());
        authSteps.waitUntilPageLoaded();
        assertTrue(authSteps.isSuccessfulRegistrationMessageAppears(), "Successful registration message doesn't appear");
    }

    @Test
    protected void checkNegativeRegistrationScenario() {
        authSteps.openAuthenticationForm();
        authSteps.openRegistrationTabInAuthenticationForm();
        authSteps.registration(user.email(), user.regPassword());
        authSteps.waitUntilPageLoaded();
        assertTrue(authSteps.isErrorMessageDisplayed(), "Error message doesn't appears");
    }

    @Test
    protected void checkUsersLogout() {
        authSteps.waitUntilPageLoaded();
        authSteps.openAuthenticationForm();
        authSteps.login(user.email(), user.password());
        authSteps.waitUntilPageLoaded();
        authSteps.logout();
        assertEquals(authSteps.getAccountLinkName(), "Вход", "User doesn't logout");
    }
}
