package ua.price.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import ua.price.properties.PropertyReader;
import ua.price.site.base.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SearchPageTest extends BaseTest {
    private String searchRequest = PropertyReader.getProperty("search_request");;

    @Test
    protected void testSearchPageOpens() {
        searchSteps.openSearchPage(pagesUrl);
        assertTrue(searchSteps.getPageTitle().contains("Поиск"), "Search page doesn't open");
    }

    @Test
    protected void testRelevantSearchResultsTest() {
        searchSteps.openSearchPage(pagesUrl);
        assertTrue(searchSteps.getNumbersOfElementsAccordingToSearchRequest(searchRequest) > 0, "Search results are invalid");
    }

    @Test
    protected void testSortingPriceInAscendingOrder() {
        searchSteps.openSearchPage(pagesUrl);
        searchSteps.selectItemForSortingTest();
        searchSteps.selectAllPriceOffers();
        searchSteps.selectSortingPriceInAscendingOrder();
        List<Integer> defaultAscendingOrderSortingPrices = searchSteps.getIntegerPriceValueFromPriceOffers();
        List<Integer> defaultAscendingOrderSortingPricesAfterAdditionalSorting = searchSteps.getIntegerPriceValueFromPriceOffers();
        defaultAscendingOrderSortingPricesAfterAdditionalSorting.sort(Integer::compareTo);
        assertThat(defaultAscendingOrderSortingPrices).containsSequence(defaultAscendingOrderSortingPricesAfterAdditionalSorting);
    }

    @Test
    public void checkIndicatedAmountOfItemsByProducerFiltration() {
        List<WebElement> allItemsAccordingToProducerFilter = new ArrayList<>();
        searchSteps.openSearchPage(pagesUrl);
        searchSteps.selectProducerSamsung();
        do {
            searchSteps.addItemsFromPage(allItemsAccordingToProducerFilter);
        } while (searchSteps.isPaginationHasNextPage());
        assertTrue(searchSteps.getIndicatedAmountOfItemsForProducerSamsung() == allItemsAccordingToProducerFilter.size());
    }

    @Test
    public void checkAllItemsPriceAccordingToFilterRangeFrom200To400() {
        List<Integer> itemsPriceInRangeFrom200To400 = new ArrayList<>();
        searchSteps.openSearchPage(pagesUrl);
        searchSteps.input200InMinPriceAnd400InMaxPrice();
        do {
            searchSteps.addItemsPriceFromPage(itemsPriceInRangeFrom200To400);
        } while (searchSteps.isPaginationHasNextPage());
        itemsPriceInRangeFrom200To400.forEach(i -> assertThat(i).isBetween(200, 400));
    }
}
