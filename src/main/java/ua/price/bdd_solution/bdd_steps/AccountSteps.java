package ua.price.bdd_solution.bdd_steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import ua.price.bdd_solution.bdd_pages.pages.AccountPage;
import ua.price.bdd_solution.bdd_pages.pages.MainPageAuth;
import ua.price.bdd_solution.bdd_pages.pages.SearchPageResults;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountSteps extends ScenarioSteps {
    AccountPage accountPage;
    MainPageAuth mainPageAuth;
    SearchPageResults searchPageResults;
    int previousAmount;

    public AccountSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void loginToAccount(String email, String password) {
        accountPage.open();
        accountPage.loginToAccount(email, password);
    }

    @Step
    public void scrollAndCheckTourismHobby() {
        accountPage.scrollToHobby();
        accountPage.checkTourismHobby();
    }

    @Step
    public void clickSaveChangesButton() {
        accountPage.clickSaveChangesButton();
    }

    @Step
    public void successSavingChangesMessageAppear() {
        assertThat(accountPage.isSuccessChangesSaveMessage()).isTrue();
    }

    @Step
    public void clickFavoritesAccountLink() {
        accountPage.clickFavoritesLink();
    }

    @Step
    public void clickCreateNewFavoritesList() {
        accountPage.clickCreateNewFavoritesList();
    }

    @Step
    public void getAmountOfDefaultFavoritesListItems() {
        previousAmount = accountPage.getAmountOfDefaultFavoritesListItems();
    }

    @Step
    public void enterRequestAndRunSearch(String request) {
        accountPage.enterRequestAndRunSearch(request);
    }

    @Step
    public void enterNewFavoritesListNameAndSave(String name) {
        accountPage.enterNewWishListName(name);
        accountPage.clickSaveNewFavoritesListButton();
    }

    @Step
    public void compareNameOfLastAddedFavoritesList(String name) {
        assertThat(accountPage.getLastFavoritesListName()).isEqualTo(name);
    }

    @Step
    public void clickFavoritesLink() {
        mainPageAuth.clickFavoritesLink();
    }

    @Step
    public void comparePreviousAmountOfItemsInDefaultFavoritesAndCurrent() {
        assertThat(accountPage.getAmountOfDefaultFavoritesListItems()).isEqualTo(++previousAmount);
    }

    @Step
    public void addForthItemToDefaultFavoritesList() {
        searchPageResults.addFourthItemToFavoritesList();
        searchPageResults.selectDefaultFavoritesListForAddingNewItem();
    }
}
