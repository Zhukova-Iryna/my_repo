package ua.price.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.price.base.BasePage;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = ".//div[@id = 'fluid-grid']")
    WebElement searchResultBlock;

    @FindBy(xpath = ".//div[contains(@class, 'product-block type')]")
    List<WebElement> searchResultList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public int getNumbersOfElementsAccordingToValue(String value) {
        int counter = 0;
        for (WebElement we : searchResultList) {
            if (we.getText().contains("Samsung A50")) {
                counter++;
            }
        }
        return counter;
    }
}