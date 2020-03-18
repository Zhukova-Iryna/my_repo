package ua.price.bdd_solution.bdd_pages.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import ua.price.bdd_solution.bdd_pages.base_page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ItemPage extends BasePage {
    @FindBy(xpath = "(.//a[contains(@class,'ga_mdl_tab_price')])[2]")
    private WebElementFacade priceOffersTab;

    @FindBy(xpath = ".//div[@class='sort-buttons']")
    private WebElementFacade sortingList;

    @FindBy(xpath = ".//a[@data-wa-event-label='From_cheap_to_expensive']")
    private WebElementFacade ascendingPriceSorting;

    @FindBy(xpath = ".//div[contains(@id,'pricelineAnchor')]")
    private List<WebElementFacade> priceOffers;

    @FindBy(xpath = ".//div[contains(@id,'pricelineAnchor')]//span[@class='price']")
    private List<WebElementFacade> pricesFromPriceOffers;

    @FindBy(xpath = ".//div[contains(@class, 'b24-widget-button-popup-show')]")
    private WebElementFacade chat;

    @FindBy(xpath = ".//span[@class='b24-widget-button-popup-btn-hide']")
    private WebElementFacade closeChat;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void selectAllPriceOffersTab() {
        priceOffersTab.click();
    }

    public void openSortingList() {
        waitPageLoad();
        sortingList.click();
    }

    public void selectAscendingSorting() {
        ascendingPriceSorting.click();
    }

    public List<Integer> getIntegerPriceValueFromPriceOffers() {
        List<Integer> prices = new ArrayList<>();
        pricesFromPriceOffers.forEach(element -> prices.add(Integer.parseInt(element.getText().replaceAll("\\D", ""))));
        return prices;
    }

    public void closeChatIfVisible() {
        if (chat.isVisible()) {
            closeChat.click();
            clickOn(sortingList);
        }
    }
}
