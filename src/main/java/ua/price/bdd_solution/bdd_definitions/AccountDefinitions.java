package ua.price.bdd_solution.bdd_definitions;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ua.price.bdd_solution.bdd_steps.AccountSteps;

public class AccountDefinitions {
    @Steps
    AccountSteps accountSteps;

    @Given("I login to my account with email $email and password $password")
    public void loginToAccount(@Named("email") String email, @Named("password") String password) {
        accountSteps.loginToAccount(email, password);
    }

    @When("I scroll to hobby settings and select tourism")
    public void scrollAndCheckHobby() {
        accountSteps.scrollAndCheckTourismHobby();
    }

    @When("I click save changes button")
    public void clickSaveChangesButton() {
        accountSteps.clickSaveChangesButton();
    }

    @When("I click favorites link")
    public void clickFavoritesAccountLink() {
        accountSteps.clickFavoritesAccountLink();
    }

    @When("I click create new list button")
    public void clickCreateNewFavoritesListButton() {
        accountSteps.clickCreateNewFavoritesList();
    }

    @When("I enter name $name for new favorite list and click save button")
    public void enterNewFavoritesListNameAndSave(@Named("name") String name) {
        accountSteps.enterNewFavoritesListNameAndSave(name);
    }

    @When("I count and remember amount of added items")
    public void countAndRememberAmountOfAddedItems() {
        accountSteps.getAmountOfDefaultFavoritesListItems();
    }

    @When("I enter request $request in search field and run search")
    public void enterRequestAndRunSearch(@Named("request") String request) {
        accountSteps.enterRequestAndRunSearch(request);
    }

    @When("I add fourth item from search results to default favorite list")
    public void addFourthItemToDefaultFavoritesList() {
        accountSteps.addForthItemToDefaultFavoritesList();
    }

    @When("I click favorites link on the main page")
    public void clickFavoritesLink() {
        accountSteps.clickFavoritesLink();
    }

    @Then("I should see success saving message")
    public void shouldAppearSuccessfulSavingMessage() {
        accountSteps.successSavingChangesMessageAppear();
    }

    @Then("I should see new $list_name added to favorites list")
    public void newFavoritesListNameShouldBe(@Named("list_name") String list_name) {
        accountSteps.compareNameOfLastAddedFavoritesList(list_name);
    }

    @Then("I should see amount of items increased by 1")
    public void amountOfItemsShouldIncrease() {
        accountSteps.comparePreviousAmountOfItemsInDefaultFavoritesAndCurrent();
    }
}
