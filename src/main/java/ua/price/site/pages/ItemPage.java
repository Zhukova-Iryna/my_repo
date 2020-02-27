package ua.price.site.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.price.site.base.BasePage;

import java.util.List;

@Accessors(fluent = true)
@Getter
public class ItemPage extends BasePage {

    @FindBy(xpath = "(.//a[contains(@class,'ga_mdl_tab_price')])[2]")
    private WebElement priceOffersTab;

    @FindBy(xpath = ".//div[@class='sort-buttons']")
    private WebElement sortingList;

    @FindBy(xpath = ".//a[@data-wa-event-label='From_cheap_to_expensive']")
    private WebElement ascendingPriceSorting;

    @FindBy(xpath = ".//div[contains(@id,'pricelineAnchor')]")
    private List<WebElement> priceOffers;

    @FindBy(xpath = ".//div[contains(@id,'pricelineAnchor')]//span[@class='price']")
    private List<WebElement> pricesFromPriceOffers;

    public ItemPage(WebDriver driver) {
        super(driver);
    }
}
