package ua.price.bdd_solution.bdd_steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import ua.price.bdd_solution.bdd_pages.pages.MainPageAuth;
import ua.price.bdd_solution.bdd_pages.pages.ItemPage;
import ua.price.bdd_solution.bdd_pages.pages.SearchPageResults;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsSteps extends ScenarioSteps {
    ItemPage itemPage;
    MainPageAuth mainPageAuth;
    SearchPageResults searchPageResults;

    public SearchResultsSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void openSearchResultsPage(String request) {
        mainPageAuth.open();
        mainPageAuth.runSearch(request);
    }

    @Step
    public void isNumberOfItemsAccordingToSearchRequestAtListEqualsToRequired(String request, int required) {
        assertThat(searchPageResults.getNumberOfItemsAccordingToSearchRequest(request)).isGreaterThanOrEqualTo(required);
    }

    @Step
    public void selectItemForSortingPrices() {
        searchPageResults.openSelectedItemPage();
    }

    @Step
    public void selectTabWithPriceOffers() {
        itemPage.selectAllPriceOffersTab();
    }

    @Step
    public void selectSortingPriceInAscendingOrder() {
        itemPage.openSortingList();
        itemPage.closeChatIfVisible();
        itemPage.selectAscendingSorting();
    }

    @Step
    public void selectProducer(String producer) {
        searchPageResults.getProducerElement(producer);
        searchPageResults.selectProducer();
    }

    @Step
    public void inputMinPriceAndMaxPrice(String min_value, String max_value) {
        searchPageResults.inputMinPriceAndMaxPrice(min_value, max_value);
    }

    @Step
    public void priceShouldSortedInAscendingOrder() {
        List<Integer> defaultAscendingOrderSortingPrices = itemPage.getIntegerPriceValueFromPriceOffers();
        List<Integer> defaultAscendingOrderSortingPricesAfterAdditionalSorting = itemPage.getIntegerPriceValueFromPriceOffers();
        defaultAscendingOrderSortingPricesAfterAdditionalSorting.sort(Integer::compareTo);
        assertThat(defaultAscendingOrderSortingPrices).containsSequence(defaultAscendingOrderSortingPricesAfterAdditionalSorting);
    }

    @Step
    public void countFilteredItems() {
        List<WebElementFacade> allItemsAccordingToProducerFilter = new ArrayList<>();
        do {
            searchPageResults.addItemsFromPage(allItemsAccordingToProducerFilter);
        } while (searchPageResults.isPaginationHasNextPage());
        assertThat(searchPageResults.getIndicatedAmountOfItemsForSelectedProducer()).isEqualTo(allItemsAccordingToProducerFilter.size());
    }

    @Step
    public void addItemsPriceFromPage(List<Integer> listForAdding) {
        listForAdding.addAll(searchPageResults.getIntegerPricesFromSearchResults());
    }

    @Step
    public void checkPriceRangeFilterResults(int min_value, int max_value) {
        List<Integer> allPricesInPriceRange = new ArrayList<>();
        do {
            addItemsPriceFromPage(allPricesInPriceRange);
        } while (searchPageResults.isPaginationHasNextPage());
        allPricesInPriceRange.forEach(price -> assertThat(price).isBetween(min_value, max_value));
    }
}