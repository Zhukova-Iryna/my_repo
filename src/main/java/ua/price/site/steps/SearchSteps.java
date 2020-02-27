package ua.price.site.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.price.site.base_steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps extends BaseSteps {
    public SearchSteps(WebDriver driver) {
        super(driver);
    }

    public void searchPageLoaded() {
        waitUntilPageLoaded();
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
        waitUntilPageLoaded();
    }

    public void selectAllPriceOffers() {
        clickWebElement(itemPage.priceOffersTab());
        waitUntilPageLoaded();
    }

    public void selectSortingPriceInAscendingOrder() {
        clickWebElement(itemPage.sortingList());
        waitUntilPageLoaded();
        clickWebElement(itemPage.ascendingPriceSorting());
        waitUntilPageLoaded();
    }

    public List<Integer> getIntegerPriceValueFromPriceOffers() {
        List<Integer> prices = new ArrayList<>();
        itemPage.pricesFromPriceOffers().forEach(element -> prices.add(Integer.parseInt(getTextFromElement(element).replaceAll("\\D", ""))));
        return prices;
    }
}
