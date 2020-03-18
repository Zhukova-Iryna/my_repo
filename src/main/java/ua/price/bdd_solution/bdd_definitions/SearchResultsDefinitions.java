package ua.price.bdd_solution.bdd_definitions;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

import ua.price.bdd_solution.bdd_steps.SearchResultsSteps;

public class SearchResultsDefinitions {
    @Steps
    SearchResultsSteps searchResultsSteps;

    @Given("I am on the main page and run search by request $request")
    public void openSearchResultsPage(@Named("request") String request) {
        searchResultsSteps.openSearchResultsPage(request);
    }

    @When("I select item and click button and open item's page")
    public void selectItemForSortingPrices() {
        searchResultsSteps.selectItemForSortingPrices();
    }

    @When("I select tab with all price offers")
    public void selectTabWithPriceOffers() {
        searchResultsSteps.selectTabWithPriceOffers();
    }

    @When("I select sorting price in ascending order")
    public void selectSortingPriceInAscendingOrder() {
        searchResultsSteps.selectSortingPriceInAscendingOrder();
    }

    @When("I select producer $producer checkbox")
    public void selectProducer(@Named("producer") String producer) {
        searchResultsSteps.selectProducer(producer);
    }

    @When("I enter $min_value and $max_value in price range inputs and submit filtration")
    public void enterMinAndMaxPriceRange(@Named("min_value") String min_value, @Named("max_value") String max_value) {
        searchResultsSteps.inputMinPriceAndMaxPrice(min_value, max_value);
    }

    @Then("I should see at list $required relevant result according to request $request")
    public void shouldSeeAtListRequiredRelevantResult(@Named("required") int required, @Named("request") String request) {
        searchResultsSteps.isNumberOfItemsAccordingToSearchRequestAtListEqualsToRequired(request, required);
    }

    @Then("I should see that the prices shown in ascending order")
    public void priceShouldSortedInAscendingOrder() {
        searchResultsSteps.priceShouldSortedInAscendingOrder();
    }

    @Then("I count filtered items and their quantity should correspond to the described")
    public void countFilteredItems() {
        searchResultsSteps.countFilteredItems();
    }

    @Then("I should only see the items in price range from $min_value to $max_value")
    public void shouldOnlySeeItemsInDefinedPriceRange(@Named("min_value") int min_value, @Named("max_value") int max_value) {
        searchResultsSteps.checkPriceRangeFilterResults(min_value, max_value);
    }
}
