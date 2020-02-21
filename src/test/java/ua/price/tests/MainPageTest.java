package ua.price.tests;

import org.testng.annotations.*;
import ua.price.base.BaseTest;
import ua.price.pages.MainPage;
import ua.price.pages.SearchPage;

import static org.testng.Assert.*;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;

    @BeforeClass
    protected void setUp() {
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
    }

    @Test
    protected void checkPositiveLoginScenario() {
        mainPage.fillLoginForm(email, password);
        assertNotEquals(mainPage.getAccountName(), "Вход", "Text doesn't change in authentication block");
    }

    @Test
    protected void checkNegativeLoginScenario() {
        mainPage.fillLoginForm(email, regPassword);
        assertTrue(mainPage.checkErrorLoginMessageAppears(), "Error message doesn't appears");
    }

    @Test
    protected void checkPositiveRegistrationScenario() {
        mainPage.fillRegistrationForm(regEmail, regPassword);
        assertTrue(mainPage.checkConfirmRegistrationMessageAppears(), "Successful registration message doesn't appear");
    }

    @Test
    protected void checkNegativeRegistrationScenario() {
        mainPage.fillRegistrationForm(email, regPassword);
        assertTrue(mainPage.checkErrorLoginMessageAppears(), "Error message doesn't appears");
    }

    @Test
    protected void checkSearchPageOpens() {
        SearchPage searchPage = mainPage.runSearch(searchRequest);
        assertTrue(searchPage.driver.getTitle().contains("Поиск"), "Search page doesn't open");
    }

    @Test
    protected void checkUsersLogout() {
        mainPage.fillLoginForm(email, password);
        assertNotEquals(mainPage.getAttributeForLoginUserLogoutForm(), "display: none;", "Users logout form doesn't open");
    }
}
