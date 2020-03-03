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
public class SearchPage extends BasePage {

    @FindBy(xpath = ".//div[@id='page-breadcrumbs']")
    private WebElement pageBreadcrumbs;

    @FindBy(xpath = ".//div[@id = 'fluid-grid']")
    private WebElement searchResultBlock;

    @FindBy(xpath = ".//div[contains(@class, 'product-block type')]")
    private List<WebElement> searchResultList;

    @FindBy(xpath = ".//div[@class='link-container']/span[@class= 'price']")
    private List<WebElement> pricesFromSearchResults;

    @FindBy(xpath = ".//a[contains(@class,'btn-orange')]")
    private WebElement itemPageButton;

    @FindBy(xpath = "(.//span[contains(@class,'add-to-wishlist-link')])[4]")
    private WebElement addForthSearchResultToFavoriteList;

    @FindBy(xpath = "(.//div[contains(@class,'existed-lists')])[4]//label")
    private List<WebElement> wishListCheckboxes;

    @FindBy(xpath = ".//div[@id='paginator']")
    private WebElement pagination;

    @FindBy(xpath = ".//li[@class='previous']")
    private WebElement previousPage;

    @FindBy(xpath = ".//li[@class='next']")
    private WebElement nextPage;

    @FindBy(xpath = ".//li[contains(@class,'selected')]/span")
    private WebElement selectedPage;

    @FindBy(xpath = ".//a[@data-producer-alias='samsung']")
    private WebElement selectProducerSamsung;

    @FindBy(xpath = ".//a[@data-producer-alias='samsung']/following-sibling::span")
    private WebElement amountOfItemsForSelectedProducerSamsung;

    @FindBy(xpath = ".//input[@id='price_max_']")
    private WebElement maxPriceInput;

    @FindBy(xpath = ".//input[@id='price_min_']")
    private WebElement minPriceInput;

    @FindBy(xpath = ".//a[contains(@class,'btn-filters-submit')]")
    private WebElement submitFilterButton;

    @FindBy(xpath = ".//label[contains(@for,'compare')]")
    private WebElement headerCompareLink;

    @FindBy(xpath = ".//a[contains(@class,'compare-exist')]")
    private WebElement compareButton;

    @FindBy(xpath = ".//label[contains(@for,'compare')]")
    private List<WebElement> addToCompareCheckBoxes;


    public SearchPage(WebDriver driver) {
        super(driver);
    }
}