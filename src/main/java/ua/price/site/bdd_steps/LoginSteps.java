package ua.price.site.bdd_steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import ua.price.site.base_steps.BaseSteps;
import ua.price.site.data.PagesUrl;
import ua.price.site.data.bean.user.User;
import ua.price.site.steps.AuthenticationSteps;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class LoginSteps{
    private AuthenticationSteps authSteps;
    private User user;
    private PagesUrl pagesUrl;

    public LoginSteps(WebDriver driver) {
        authSteps = new AuthenticationSteps(driver);
        user = new User();
        pagesUrl = new PagesUrl();
    }
   // @org.testng.annotations.Test
    @Given("I am on 'Main' Page")
    public void goToMainPage() {
        authSteps.openMainPage(pagesUrl);
    }
    @When("I open login form")
    public void openLoginForm() {
        authSteps.openAuthenticationForm();
    }
    @When("I enter email $email and enter password $password and click on 'Login' button")
    @Alias("I input email $email and input password $password and click on 'Login' button")
    public void loginToAccount() {
        authSteps.login(user);
    }
    @Then("I should see that the inscription in 'User account link' changed to my login")
    public void shouldChangedInscriptionOnLoginLink() {
        assertNotEquals(authSteps.getAccountLinkName(), "Вход", "Text doesn't change in authentication block");
    }
    @Then("I should see error message")
    public void shouldSeeErrorMessage() {
        assertTrue(authSteps.isErrorMessageDisplayed(), "Error message doesn't appears");
    }

}
