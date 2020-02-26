package ua.price.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.price.pages.ItemPage;
import ua.price.pages.MainPage;
import ua.price.pages.SearchPage;
import ua.price.pages.UserAccountPage;
import ua.price.utils.WaitUtils;

public abstract class BaseSteps {
    private WebDriver driver;
    protected WaitUtils waitUtils;
    protected MainPage mainPage;
    protected UserAccountPage userAccountPage;
    protected SearchPage searchPage;
    protected ItemPage itemPage;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        mainPage = new MainPage(driver);
        userAccountPage = new UserAccountPage(driver);
        searchPage = new SearchPage(driver);
        itemPage = new ItemPage(driver);
    }

    public void waitUntilPageLoaded() {
        waitUtils.waitUntilPageLoaded();
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

    public String getPageTitle() {
        return this.driver.getTitle();
    }
}
