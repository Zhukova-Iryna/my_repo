package ua.price.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.lang.Thread.sleep;

public class WaitUtils {
    WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAlertPresent(int timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAttributeContains(WebElement webElement, int timeout, String attribute, String attributeValue) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.attributeContains(webElement, attribute, attributeValue));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAttributeToBe(WebElement webElement, int timeout, String attribute, String attributeValue) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.attributeToBe(webElement, attribute, attributeValue));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAttributeNotEmpty(WebElement webElement, int timeout, String attribute) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.attributeToBeNotEmpty(webElement, attribute));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementSelection(WebElement webElement, int timeout, boolean selected) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementSelectionStateToBe(webElement, selected));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement elementToBeClickable(WebElement webElement, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public boolean isElementSelected(WebElement webElement, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeSelected(webElement));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebDriver frameToBeAvailableAndSwitchToIt(WebElement frameLocator, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public boolean isElementInvisible(WebElement webElement, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(webElement));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean areAllElementsInvisible(List<WebElement> elementList, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfAllElements(elementList));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isJavaScriptThrowsNoExceptions(String javaScript, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Object jsReturnsValue(String javaScript, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.jsReturnsValue(javaScript));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public boolean isTextPresentInElement(WebElement webElement, int timeout, String text) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBePresentInElement(webElement, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isTitleContains(int timeout, String title) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isTitle(int timeout, String title) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isUrlContains(int timeout, String url) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(url));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isUrlMatches(int timeout, String regex) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlMatches(regex));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isUrlToBe(int timeout, String url) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(url));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement elementToBetVisible(WebElement webElement, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public List<WebElement> allElementsAreVisible(List<WebElement> elementList, int timeout) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(elementList));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public List<WebElement> nestedElementsLocatedByAreVisible(WebElement webElement, int timeout, By locator) {
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(webElement, locator));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public static ExpectedCondition<Boolean> isJavascriptTrue() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState === 'complete'");
            }
        };
    }

    public void waitUntilPageLoaded(int timeout) {
        new WebDriverWait(driver, timeout).until(isJavascriptTrue());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitElement(WebElement webElement, int timeout, int pollingFreq) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingFreq))
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
    }
}
