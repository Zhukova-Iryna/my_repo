package ua.price.tests;

import org.testng.annotations.*;
import ua.price.properties.PropertyReader;
import ua.price.site.base.BaseTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SearchPageTest extends BaseTest {
    private String searchRequest;

    @BeforeClass
    protected void setUp() {
        driver.get(pagesUrl.searchUrl());
        searchRequest = PropertyReader.getProperty("search_request");
    }

    @Test
    protected void testSearchPageOpens() {
        assertTrue(searchSteps.getPageTitle().contains("Поиск"), "Search page doesn't open");
    }

    @Test
    protected void testRelevantSearchResultsTest() {
        searchSteps.searchPageLoaded();
        System.out.println(searchRequest);
        assertTrue(searchSteps.getNumbersOfElementsAccordingToSearchRequest(searchRequest) > 0, "Search results are invalid");
    }

    @Test
    protected void testSortingPriceInAscendingOrder() {
        searchSteps.selectItemForSortingTest();
        searchSteps.selectAllPriceOffers();
        searchSteps.selectSortingPriceInAscendingOrder();
        List<Integer> defaultAscendingOrderSortingPrices = searchSteps.getIntegerPriceValueFromPriceOffers();
        List<Integer> defaultAscendingOrderSortingPricesAfterAdditionalSorting = searchSteps.getIntegerPriceValueFromPriceOffers();
        defaultAscendingOrderSortingPricesAfterAdditionalSorting.sort(Integer::compareTo);
        assertThat(defaultAscendingOrderSortingPrices).containsSequence(defaultAscendingOrderSortingPricesAfterAdditionalSorting);
    }
}
