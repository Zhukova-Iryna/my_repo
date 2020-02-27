package ua.price.tests;

import org.testng.annotations.*;
import ua.price.site.base.BaseTest;

import static org.testng.Assert.*;

public class MainPageTest extends BaseTest {

    @Test
    protected void checkPositiveLoginScenario() {
        authSteps.openMainPage(pagesUrl);
        authSteps.openAuthenticationForm();
        authSteps.login(user);
        assertNotEquals(authSteps.getAccountLinkName(), "Вход", "Text doesn't change in authentication block");
    }

    @Test
    protected void checkNegativeLoginScenario() {
        authSteps.openMainPage(pagesUrl);
        authSteps.openAuthenticationForm();
        user.email("User1@gmail.com");
        authSteps.login(user);
        assertTrue(authSteps.isErrorMessageDisplayed(), "Error message doesn't appears");
    }

    @Test
    protected void checkPositiveRegistrationScenario() {
        authSteps.openMainPage(pagesUrl);
        authSteps.openAuthenticationForm();
        authSteps.openRegistrationTabInAuthenticationForm();
        authSteps.registration(user);
        assertTrue(authSteps.isSuccessfulRegistrationMessageAppears(), "Successful registration message doesn't appear");
    }

    @Test
    protected void checkNegativeRegistrationScenario() {
        authSteps.openMainPage(pagesUrl);
        authSteps.openAuthenticationForm();
        authSteps.openRegistrationTabInAuthenticationForm();
        user.regEmail("User1_gmail.com");
        authSteps.registration(user);
        assertTrue(authSteps.isErrorMessageDisplayed(), "Error message doesn't appears");
    }

    @Test
    protected void checkUsersLogout() {
        authSteps.openMainPage(pagesUrl);
        authSteps.openAuthenticationForm();
        authSteps.login(user);
        authSteps.logout();
        assertEquals(authSteps.getAccountLinkName(), "Вход", "User doesn't logout");
    }
}
