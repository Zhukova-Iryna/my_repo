package ua.price.site.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.price.site.base_steps.BaseSteps;
import ua.price.site.data.PagesUrl;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps extends BaseSteps {
    public SearchSteps(WebDriver driver) {
        super(driver);
    }

    public void openSearchPage(PagesUrl pagesUrl) {
        driver.get(pagesUrl.searchUrl());
        waitUtils.waitUntilPageLoaded();
    }

    public int getNumbersOfElementsAccordingToSearchRequest(String value) {
        int counter = 0;
        for (WebElement we : searchPage.searchResultList()) {
            if (we.getText().contains(value)) {
                counter++;
            }
        }
        return counter;
    }

    public void selectItemForSortingTest() {
        clickWebElement(searchPage.itemPageButton());
        waitUtils.waitUntilPageLoaded();
    }

    public void selectAllPriceOffers() {
        clickWebElement(itemPage.priceOffersTab());
        waitUtils.waitUntilPageLoaded();
    }

    public void selectSortingPriceInAscendingOrder() {
        clickWebElement(itemPage.sortingList());
        waitUtils.waitUntilPageLoaded();
        clickWebElement(itemPage.ascendingPriceSorting());
        waitUtils.waitUntilPageLoaded();
    }

    public List<Integer> getIntegerPriceValueFromPriceOffers() {
        List<Integer> prices = new ArrayList<>();
        itemPage.pricesFromPriceOffers().forEach(element -> prices.add(Integer.parseInt(getTextFromElement(element).replaceAll("\\D", ""))));
        return prices;
    }

    public void selectProducerSamsung() {
        jsClickWebElement(searchPage.selectProducerSamsung());
        waitUtils.waitUntilPageLoaded();
    }

    public void addItemsFromPage(List<WebElement> listForAdding) {
        listForAdding.addAll(searchPage.searchResultList());
    }

    public void addItemsPriceFromPage(List<Integer> listForAdding) {
        listForAdding.addAll(getIntegerPricesFromSearchResults());
    }

    public boolean isPaginationHasNextPage() {
        actions.moveToElement(searchPage.pagination());
        int currentPage = Integer.parseInt(getTextFromElement(searchPage.selectedPage()));
        jsClickWebElement(searchPage.nextPage());
        waitUtils.waitUntilPageLoaded();
        return Integer.parseInt(getTextFromElement(searchPage.selectedPage())) != currentPage;
    }

    public int getIndicatedAmountOfItemsForProducerSamsung() {
        return Integer.parseInt(getTextFromElement(searchPage.amountOfItemsForSelectedProducerSamsung()));
    }

    public void input200InMinPriceAnd400InMaxPrice() {
        enterTextInTextField(searchPage.minPriceInput(), "200");
        enterTextInTextField(searchPage.maxPriceInput(), "400");
        jsClickWebElement(searchPage.submitFilterButton());
        waitUtils.waitUntilPageLoaded();
    }

    public List<Integer> getIntegerPricesFromSearchResults() {
        List<Integer> prices = new ArrayList<>();
        searchPage.pricesFromSearchResults().forEach(element -> prices.add(Integer.parseInt(getTextFromElement(element).replaceAll("\\D", ""))));
        return prices;
    }

    public void addItemToComparing() {
        jsClickWebElement(searchPage.addToCompareCheckBoxes().get(0));
    }

    public int getAmountOfItemsForComparing() {
        return Integer.parseInt(searchPage.headerCompareLink().getAttribute("value"));
    }
}
