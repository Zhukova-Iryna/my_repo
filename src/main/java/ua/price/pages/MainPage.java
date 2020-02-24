package ua.price.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.price.base.BasePage;
import ua.price.utils.WaitUtils;

public class MainPage extends BasePage {

    @FindBy(xpath = ".//div[@id='auth-user-block']")
    private WebElement loginLink;

    @FindBy(xpath = ".//a[@id='header-user-link']")
    private WebElement userAccount;

    @FindBy(xpath = ".//input[@id='SearchForm_searchPhrase']")
    private WebElement searchFieldInput;

    @FindBy(xpath = ".//input[@id = 'LoginForm_username']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@id = 'login_user_password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[contains(@class,'pt_20')]")
    private WebElement submitLoginButton;

    @FindBy(xpath = ".//a[@id = 'go-tab-recovery']")
    private WebElement recoveryPasswordLink;

    @FindBy(xpath = ".//div[@id = 'go-tab-userregister']")
    private WebElement registrationTab;

    @FindBy(xpath = ".//div[@class='error-text'][contains(text(),'.')]")
    private WebElement errorLabel;

    @FindBy(xpath = ".//input[@id = 'RegisterUserFirmForm_user_email']")
    private WebElement regEmailField;

    @FindBy(xpath = ".//input[@id = 'user_user_password']")
    private WebElement regPasswordField;

    @FindBy(xpath = "//div[contains(@class,'mt_10')]")
    private WebElement submitRegistration;

    @FindBy(xpath = ".//div[@class = 'reg-success-text']")
    private WebElement confirmRegistrationMessage;

    @FindBy(xpath = ".//div[@id='google_ads_iframe_/6560281/Price_Promo_text_1_0__container__']")
    private WebElement popularCategoryAd;

    @FindBy(xpath = ".//div[@id='auth-user-links']")
    private WebElement loginUsersSignOut;

    @FindBy(xpath = ".//a[@class='i-profile']")
    private WebElement goToProfileLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginForm(String email, String password) {
        openLoginForm();
        enterTextInTextField(emailField, email);
        enterTextInTextField(passwordField, password);
        clickWebElement(submitLoginButton);
    }

    public void fillRegistrationForm(String email, String password) {
        openLoginForm();
        clickWebElement(registrationTab);
        enterTextInTextField(regEmailField, email);
        enterTextInTextField(regPasswordField, password);
        clickWebElement(submitRegistration);
    }

    public String getAccountName() {
        return userAccount.getText();
    }

    public boolean checkErrorLoginMessageAppears() {
        System.out.println(errorLabel.getText());
        return errorLabel.isDisplayed();
    }

    public boolean checkConfirmRegistrationMessageAppears() {
        return confirmRegistrationMessage.isDisplayed();
    }

    public SearchPage runSearch(String searchRequest) {
        searchFieldInput.sendKeys(searchRequest + Keys.ENTER);
        waitUtils.waitUntilPageLoaded();
        return new SearchPage(driver);
    }

    public String getAttributeForLoginUserLogoutForm() {
        new WaitUtils(driver).waitUntilPageLoaded();
        clickWebElement(userAccount);
        return waitUtils.waitForElement(loginUsersSignOut).getAttribute("style");
    }

    public void openLoginForm() {
        waitUtils.waitUntilPageLoaded();
        clickWebElement(loginLink);
    }
}
