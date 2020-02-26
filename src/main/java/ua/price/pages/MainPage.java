package ua.price.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.price.base.BasePage;

@Accessors(fluent = true)
@Getter
public class MainPage extends BasePage {

    @FindBy(xpath = ".//div[@id='auth-user-block']")
    private WebElement loginLink;

    @FindBy(xpath = "(.//a[contains(@class,'header-user-link')])[1]")
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

    @FindBy(xpath = ".//form[@id='logout_form_yw4']")
    private WebElement loginUsersSignOut;

    @FindBy(xpath = ".//a[@class='i-profile']")
    private WebElement goToProfileLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
