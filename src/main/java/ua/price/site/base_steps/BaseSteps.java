package ua.price.site.base_steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ua.price.site.pages.ItemPage;
import ua.price.site.pages.MainPage;
import ua.price.site.pages.SearchPage;
import ua.price.site.pages.UserAccountPage;
import ua.price.utils.WaitUtils;

public abstract class BaseSteps {
    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected MainPage mainPage;
    protected UserAccountPage userAccountPage;
    protected SearchPage searchPage;
    protected ItemPage itemPage;
    protected Actions actions;


    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        mainPage = new MainPage(driver);
        userAccountPage = new UserAccountPage(driver);
        searchPage = new SearchPage(driver);
        itemPage = new ItemPage(driver);
        actions = new Actions(driver);
    }

    public void enterTextInTextField(WebElement textField, String inputText) {
        clickWebElement(textField);
        textField.clear();
        textField.sendKeys(inputText);
    }

    public String getTextFromElement(WebElement webElement) {
        return waitUtils.waitForElement(webElement).getText();
    }

    public void clickWebElement(WebElement webElement) {
        waitUtils.clickWhenReady(webElement);
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public void jsClickWebElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }
}