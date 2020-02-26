package ua.price.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.price.base.BasePage;

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

    @FindBy(xpath = ".//a[contains(@class,'btn-orange')]")
    private WebElement itemPageButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}