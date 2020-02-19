package ua.price.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void enterTextInTextField(WebElement textField, String inputText) {
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    public String getTextFromElement(WebElement webElement) {
        return webElement.getText();
    }

    public static void clickWebElement(WebElement webElement) {
        webElement.click();
    }
}