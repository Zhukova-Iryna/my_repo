package ua.price.site.bdd_steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.price.site.data.PagesUrl;
import ua.price.site.data.bean.user.User;
import ua.price.site.steps.AuthenticationSteps;
import ua.price.site.steps.SearchSteps;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class AuthSteps {
    private WebDriver driver;
    private AuthenticationSteps authSteps;
    private SearchSteps searchSteps;
    private User user;
    private PagesUrl pagesUrl;

    @BeforeScenario
    public void scenarioSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        authSteps = new AuthenticationSteps(driver);
        searchSteps = new SearchSteps(driver);
        user = new User();
        pagesUrl = new PagesUrl();
    }

    @Given("I am on the main page")
    public void openMainPage() {
        authSteps.openMainPage(pagesUrl);
    }

    @When("I open login form")
    public void openLoginForm() {
        authSteps.openAuthenticationForm();
    }

    @When("I enter email and password and click submit button")
    public void loginToAccount() {
        authSteps.login(user);
    }

    @When("I switch to registration tab")
    public void switchToRegistrationTab() {
        authSteps.openRegistrationTabInAuthenticationForm();
    }

    @When("I enter new email and password and click submit button")
    public void registrationOnSite() {
        authSteps.registration(user);
    }

    @When("I enter email and invalid password and click submit button")
    public void loginWithInvalidPassword() {
        authSteps.login(user.password("test2020"));
    }

    @Then("I should see that the inscription on the link to user account is to be changed to my username")
    public void inscriptionShouldChanged() {
        assertNotEquals(authSteps.getAccountLinkName(), "Вход", "Text doesn't change in authentication block");
    }

    @Then("I should see error registration message")
    public void shouldAppearSuccessfulMessage() {
        assertTrue(authSteps.isErrorMessageDisplayed());
    }

    @Then("I should see error login message")
    public void shouldSeeErrorLoginMessage() {
        assertTrue(authSteps.isErrorMessageDisplayed());
    }

    @AfterScenario
    public void afterScenario() {
        driver.quit();
    }
}

