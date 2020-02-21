package ua.price.tests;

import org.testng.annotations.*;
import ua.price.base.BaseTest;
import ua.price.pages.SearchPage;

import static org.testng.Assert.*;

public class SearchPageTest extends BaseTest {
    private SearchPage searchPage;


    @BeforeClass
    protected void setUp() {
        driver.get(searchUrl);
        searchPage = new SearchPage(driver);
    }

    @Test
    protected void relevantSearchResultsTest() {
        System.out.println(searchPage.getElement());
        assertTrue(searchPage.getNumbersOfElementsAccordingToValue(searchRequest) > 0, "Search results are invalid");
    }
}
