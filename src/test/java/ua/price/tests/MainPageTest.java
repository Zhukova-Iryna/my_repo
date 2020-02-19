package ua.price.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.price.base.BaseTest;
import ua.price.pages.MainPage;
import ua.price.pages.SearchPage;
import ua.price.properties.PropertyReader;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;
    private String baseUrl;
    private String email;
    private String password;
    private String regEmail;
    private String regPassword;
    private String empty = "";
    private String searchRequest;

    @BeforeClass
    protected void setUp() {
        baseUrl = PropertyReader.getProperty("base_url");
        email = PropertyReader.getProperty("login_email");
        password = PropertyReader.getProperty("login_password");
        regEmail = PropertyReader.getProperty("reg_email");
        regPassword = PropertyReader.getProperty("reg_password");
        searchRequest = PropertyReader.getProperty("search_request");
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
    }

    @Test
    protected void checkPositiveLoginScenario() {
        mainPage.fillLoginForm(email, password);
        Assert.assertNotEquals(mainPage.getAccountName(), "Вход", "Text doesn't change in authentication block");
    }

    @Test
    protected void checkNegativeLoginScenario() {
        mainPage.fillLoginForm(email, regPassword);
        Assert.assertTrue(mainPage.checkErrorLoginMessageAppears(), "Error message doesn't appears");
    }

    @Test
    protected void checkPositiveRegistrationScenario() {
        mainPage.fillRegistrationForm(regEmail, regPassword);
        Assert.assertTrue(mainPage.checkConfirmRegistrationMessageAppears(), "Successful registration message doesn't appear");
    }

    @Test
    protected void checkNegativeRegistrationScenario() {
        mainPage.fillRegistrationForm(email, regPassword);
        Assert.assertTrue(mainPage.checkErrorLoginMessageAppears(), "Error message doesn't appears");
    }

    @Test
    protected void searchStartsTest() {
        SearchPage searchPage = mainPage.runSearch(searchRequest);
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='page-breadcrumbs']")));
        Assert.assertTrue(driver.getTitle().contains("Поиск"), "Search page doesn't open");
    }
}
