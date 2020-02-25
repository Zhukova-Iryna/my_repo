package ua.price.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.price.utils.WaitUtils;

public abstract class BasePage {
    public WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void enterTextInTextField(WebElement textField, String inputText) {
        clickWebElement(textField);
        textField.clear();
        textField.sendKeys(inputText);
    }

    public String getTextFromElement(WebElement webElement) {
        return webElement.getText();
    }

    public void clickWebElement(WebElement webElement) {
        waitUtils.elementToBeClickable(webElement).click();
    }
}