import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = ".//div[@class='products fluid-grid clearer-block']")
    WebElement searchResultBlock;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchElements() {
        return driver.findElements(By.xpath(".//div[contains(@class, 'product-block type')]"));
    }
}