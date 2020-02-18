import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Enter text to text field
    public static void enterTextInTextField(WebElement textField, String inputText) {
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    // Get text from web element
    public String getTextFromElement(WebElement webElement) {
        return webElement.getText();
    }


    // Click on web element
    public static void clickWebElement(WebElement webElement){
        webElement.click();
    }

}