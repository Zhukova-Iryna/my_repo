package ua.price.bdd_solution.bdd_pages.base_page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ua.price.utils.WaitUtils;

public abstract class BasePage extends PageObject {
    @FindBy(xpath = ".//input[@id='SearchForm_searchPhrase']")
    protected WebElementFacade searchRequestInput;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void waitPageLoad() {
        WaitUtils waitUtils = new WaitUtils(getDriver());
        waitUtils.waitUntilPageLoaded();
    }

    public void jsClickWebElement(WebElementFacade element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
