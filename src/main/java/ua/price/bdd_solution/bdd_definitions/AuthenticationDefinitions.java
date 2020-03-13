package ua.price.bdd_solution.bdd_definitions;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ua.price.bdd_solution.bdd_steps.AuthSteps;

public class AuthenticationDefinitions {
    @Steps
    AuthSteps authSteps;

    @Given("I am on the main page")
    public void openMainPage() {
        authSteps.openMainPage();
    }

    @When("I open login form")
    public void openLoginForm() {
        authSteps.openLoginForm();
    }

    @When("I enter email and password and click submit button")
    public void loginToAccount() {
        authSteps.loginToAccount();
    }

    @When("I switch to registration tab")
    public void switchToRegistrationTab() {
        authSteps.switchToRegistrationTab();
    }

    @When("I enter new email and password and click submit button")
    public void registrationOnSite() {
        authSteps.registrationOnSite();
    }

    @When("I enter email and invalid password and click submit button")
    public void loginWithInvalidPassword() {
        authSteps.loginWithInvalidPassword();
    }

    @Then("I should see that the inscription on the link to user account is to be changed to my username")
    public void inscriptionShouldChanged() {
        authSteps.inscriptionShouldChanged();
    }

    @Then("I should see error registration message")
    public void shouldAppearErrorMessage() {
        authSteps.shouldAppearErrorMessage();
    }

    @Then("I should see error login message")
    public void shouldSeeErrorLoginMessage() {
        authSteps.shouldSeeErrorLoginMessage();
    }
}
