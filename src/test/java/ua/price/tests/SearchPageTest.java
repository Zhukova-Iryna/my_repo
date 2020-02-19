package ua.price.tests;

        import org.testng.Assert;
        import org.testng.annotations.*;
        import ua.price.base.BaseTest;
        import ua.price.pages.SearchPage;
        import ua.price.properties.PropertyReader;


public class SearchPageTest extends BaseTest {
    private SearchPage searchPage;
    private String searchUrl;
    private String searchRequest;

    @BeforeClass
    protected void setUp() {
        searchUrl = PropertyReader.getProperty("search_url");
        searchRequest = PropertyReader.getProperty("search_request");
        driver.get(searchUrl);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void relevantSearchResultsTest() {
        Assert.assertTrue(searchPage.getNumbersOfElementsAccordingToValue(searchRequest) > 0, "Search results are invalid");
    }
}
