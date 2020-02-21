package ua.price.tests;

import org.testng.annotations.*;
import ua.price.base.BaseTest;
import ua.price.pages.SearchPage;

import static org.testng.Assert.*;
import static ua.price.properties.PropertyReader.*;

public class SearchPageTest extends BaseTest {
    private SearchPage searchPage;
    private String searchUrl;
    private String searchRequest;

    @BeforeClass
    protected void setUp() {
        searchUrl = getProperty("search_url");
        searchRequest = getProperty("search_request");
        driver.get(searchUrl);
        searchPage = new SearchPage(driver);
    }

    @Test
    protected void relevantSearchResultsTest() {
        System.out.println(searchPage.getElement());
        assertTrue(searchPage.getNumbersOfElementsAccordingToValue(searchRequest) > 0, "Search results are invalid");
    }
}
