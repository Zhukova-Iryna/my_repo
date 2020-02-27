package ua.price.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class WaitUtils {
    private WebDriver driver;
    private static final int TIMEOUT = 5;
    private static final int FLUENT_TIMEOUT = 30;
    private static final int POLLING_WAIT = 5;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAlertPresent() {
        try {
            new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAttributeContains(WebElement webElement, String attribute, String attributeValue) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.attributeContains(webElement, attribute, attributeValue));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAttributeToBe(WebElement webElement, String attribute, String attributeValue) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.attributeToBe(webElement, attribute, attributeValue));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAttributeNotEmpty(WebElement webElement, String attribute) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.attributeToBeNotEmpty(webElement, attribute));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementSelection(WebElement webElement, boolean selected) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementSelectionStateToBe(webElement, selected));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickWhenReady(WebElement webElement) {
        try {
            new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(webElement)).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    public boolean isElementSelected(WebElement webElement) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeSelected(webElement));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebDriver frameToBeAvailableAndSwitchToIt(WebElement frameLocator) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public boolean isElementInvisible(WebElement webElement) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOf(webElement));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean areAllElementsInvisible(List<WebElement> elementList) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.invisibilityOfAllElements(elementList));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Object jsReturnsValue(String javaScript) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.jsReturnsValue(javaScript));
    }

    public boolean isTextPresentInElement(WebElement webElement, String text) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.textToBePresentInElement(webElement, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isTitleContains(String title) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isTitle(String title) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isUrlContains(String url) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains(url));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isUrlToBe(String url) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlToBe(url));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement elementToBeVisible(WebElement webElement) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(webElement));
    }

    public boolean isElementDisplayed(WebElement webElement) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(webElement)) != null;
    }

    public List<WebElement> allElementsAreVisible(List<WebElement> elementList) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public static ExpectedCondition<Boolean> isJavascriptTrue() {
        return driver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState === 'complete'");
    }

    public void waitUntilPageLoaded() {
        new WebDriverWait(driver, TIMEOUT).until(isJavascriptTrue());
        waitASecond();
    }

    public WebElement waitForElement(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(FLUENT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(POLLING_WAIT))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver -> webElement);
    }

    private static void waitASecond() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
