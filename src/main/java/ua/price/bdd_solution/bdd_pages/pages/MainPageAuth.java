package ua.price.bdd_solution.bdd_pages.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import ua.price.bdd_solution.bdd_pages.base_page.BasePage;
import ua.price.site.data.bean.user.User;

@DefaultUrl("https://price.ua/")
public class MainPageAuth extends BasePage {
    @FindBy(xpath = "(.//a[contains(@class,'header-user-link')])[1]")
    private WebElementFacade userAccountLink;

    @FindBy(xpath = ".//div[@id='auth-user-block']")
    private WebElementFacade loginLink;

    @FindBy(xpath = ".//input[@id = 'LoginForm_username']")
    private WebElementFacade emailField;

    @FindBy(xpath = ".//input[@id = 'login_user_password']")
    private WebElementFacade passwordField;

    @FindBy(xpath = ".//div[contains(@class,'pt_20')]")
    private WebElementFacade submitLoginButton;

    @FindBy(xpath = ".//div[@id = 'go-tab-userregister']")
    private WebElementFacade registrationTab;

    @FindBy(xpath = ".//input[@id = 'RegisterUserFirmForm_user_email']")
    private WebElementFacade regEmailField;

    @FindBy(xpath = ".//input[@id = 'user_user_password']")
    private WebElementFacade regPasswordField;

    @FindBy(xpath = "//div[contains(@class,'mt_10')]")
    private WebElementFacade submitRegistrationButton;

    @FindBy(xpath = ".//div[@class='error-text'][contains(text(),'.')]")
    private WebElementFacade errorLabel;

    @FindBy(xpath = ".//a[@class='wishlist-panel-link']")
    private WebElementFacade wishListLink;

    public MainPageAuth(WebDriver driver) {
        super(driver);
    }

    public void openAuthenticationForm() {
        loginLink.click();
    }

    public void login(User user) {
        typeInto(emailField, user.email());
        typeInto(passwordField, user.password());
        submitLoginButton.click();
    }

    public void switchToRegistrationTab() {
        registrationTab.click();
    }

    public void registration(User user) {
        typeInto(regEmailField, user.regEmail());
        typeInto(regPasswordField, user.regPassword());
        submitRegistrationButton.click();
    }

    public String getTextFromUserAccountLink() {
        waitPageLoad();
        return userAccountLink.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorLabel.isDisplayed();
    }

    public void clickFavoritesLink() {
        clickOn(wishListLink);
    }

    public void runSearch(String request) {
        searchRequestInput.typeAndEnter(request);
    }
}
