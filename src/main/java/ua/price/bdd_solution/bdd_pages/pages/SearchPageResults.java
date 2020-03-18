package ua.price.bdd_solution.bdd_pages.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.price.bdd_solution.bdd_pages.base_page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class SearchPageResults extends BasePage {
    private By selectedProducer;

    @FindBy(xpath = ".//div[contains(@class, 'product-block type')]")
    private List<WebElementFacade> searchResultsList;

    @FindBy(xpath = ".//a[contains(@class,'btn-orange')]")
    private WebElementFacade itemPageButton;

    @FindBy(xpath = ".//div[@id='paginator']")
    private WebElementFacade pagination;

    @FindBy(xpath = ".//li[contains(@class,'selected')]/span")
    private WebElementFacade selectedPage;

    @FindBy(xpath = ".//li[@class='next']")
    private WebElementFacade nextPage;

    @FindBy(xpath = ".//input[@id='price_min_']")
    private WebElementFacade minPriceInput;

    @FindBy(xpath = ".//input[@id='price_max_']")
    private WebElementFacade maxPriceInput;

    @FindBy(xpath = ".//a[contains(@class,'btn-filters-submit')]")
    private WebElementFacade submitFiltrationButton;

    @FindBy(xpath = "(.//span[contains(@class,'add-to-wishlist-link')])")
    private WebElementFacade addFirstSearchResultToFavoriteList;

    @FindBy(xpath = "(.//div[contains(@class,'existed-lists')])//label")
    private List<WebElementFacade> wishListCheckboxes;

    @FindBy(xpath = ".//div[@class='link-container']/span[@class= 'price']")
    private List<WebElementFacade> pricesFromSearchResults;

    public SearchPageResults(WebDriver driver) {
        super(driver);
    }

    public boolean isPaginationHasNextPage() {
        pagination.setWindowFocus();
        int currentPage = Integer.parseInt(selectedPage.getText());
        nextPage.click();
        waitPageLoad();
        pagination.setWindowFocus();
        return Integer.parseInt(selectedPage.getText()) != currentPage;
    }

    public int getNumberOfItemsAccordingToSearchRequest(String request) {
        int counter = 0;
        for (WebElement we : searchResultsList) {
            if (we.getText().contains(request)) {
                counter++;
            }
        }
        return counter;
    }

    public void addItemsFromPage(List<WebElementFacade> listForAdding) {
        listForAdding.addAll(searchResultsList);
    }

    public int getIndicatedAmountOfItemsForSelectedProducer() {
        return Integer.parseInt(getDriver().findElement(selectedProducer).findElement(By.xpath("./following-sibling::span")).getText());
    }

    public void getProducerElement(String producer) {
        selectedProducer = By.xpath(String.format(".//a[@data-producer-alias='%s']", producer.toLowerCase()));
    }

    public void selectProducer() {
        clickOn(getDriver().findElement(selectedProducer));
        waitPageLoad();
    }

    public void inputMinPriceAndMaxPrice(String min, String max) {
        minPriceInput.type(min);
        maxPriceInput.type(max);
        jsClickWebElement(submitFiltrationButton);
        waitPageLoad();
    }

    public List<Integer> getIntegerPricesFromSearchResults() {
        List<Integer> prices = new ArrayList<>();
        pricesFromSearchResults.forEach(element -> prices.add(Integer.parseInt(element.getText().replaceAll("\\D", ""))));
        return prices;
    }

    public void addFourthItemToFavoritesList() {
        waitPageLoad();
        clickOn(addFirstSearchResultToFavoriteList);
    }

    public void selectDefaultFavoritesListForAddingNewItem() {
        clickOn(wishListCheckboxes.get(0));
    }

    public void openSelectedItemPage() {
        itemPageButton.click();
    }
}
