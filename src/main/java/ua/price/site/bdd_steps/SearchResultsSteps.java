package ua.price.site.bdd_steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.price.site.data.PagesUrl;
import ua.price.site.steps.AuthenticationSteps;
import ua.price.site.steps.SearchSteps;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsSteps {
    private WebDriver driver;
    private AuthenticationSteps authSteps;
    private SearchSteps searchSteps;
    private PagesUrl pagesUrl;

    @BeforeScenario
    public void scenarioSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        authSteps = new AuthenticationSteps(driver);
        searchSteps = new SearchSteps(driver);
        pagesUrl = new PagesUrl();
    }

    @Given("I am on the start page")
    public void openMainPage() {
        authSteps.openMainPage(pagesUrl);
    }

    @Given("I am on the search results page")
    public void openSearchResultsPage() {
        searchSteps.openSearchPage(pagesUrl);
    }

    @When("I select item and click button and open item's page")
    public void selectItemForSortingPrices() {
        searchSteps.selectItemForSortingTest();
    }

    @When("I select tab with all price offers")
    public void selectTabWithPriceOffers() {
        searchSteps.selectAllPriceOffers();
    }

    @When("I select sorting price in ascending order")
    public void selectSortingPriceInAscendingOrder() {
        searchSteps.selectSortingPriceInAscendingOrder();
    }

    @When("I select producer 'Samsung' checkbox")
    public void selectProducerSamsung() {
        searchSteps.selectProducerSamsung();
    }

    @When("I enter <request> in search field and click enter")
    public void enterRequestAndRunSearch(@Named("request") String request) {
        searchSteps.runSearch(request);
    }

    @Then("I should see at list one relevant search result according to my <request>")
    public void shouldSeeAtListOneSearchResult(@Named("request") String request) {
        assertTrue(searchSteps.getNumbersOfElementsAccordingToSearchRequest(request) > 0);
    }

    @Then("I should see that the prices shown in ascending order")
    public void priceShouldSortedInAscendingOrder() {
        List<Integer> defaultAscendingOrderSortingPrices = searchSteps.getIntegerPriceValueFromPriceOffers();
        List<Integer> defaultAscendingOrderSortingPricesAfterAdditionalSorting = searchSteps.getIntegerPriceValueFromPriceOffers();
        defaultAscendingOrderSortingPricesAfterAdditionalSorting.sort(Integer::compareTo);
        assertThat(defaultAscendingOrderSortingPrices).containsSequence(defaultAscendingOrderSortingPricesAfterAdditionalSorting);
    }

    @Then("I count filtered items and their quantity should correspond to the described")
    public void countFilteredItems() {
        List<WebElement> allItemsAccordingToProducerFilter = new ArrayList<>();
        searchSteps.openSearchPage(pagesUrl);
        searchSteps.selectProducerSamsung();
        do {
            searchSteps.addItemsFromPage(allItemsAccordingToProducerFilter);
        } while (searchSteps.isPaginationHasNextPage());
        assertTrue(searchSteps.getIndicatedAmountOfItemsForProducerSamsung() == allItemsAccordingToProducerFilter.size());
    }
}


