import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = ".//div[@id = 'auth-user-links']")
    private WebElement loginLink;

    @FindBy(id = "header-user-link")
    private WebElement userAccount;

    @FindBy(id = "SearchForm_searchPhrase")
    private WebElement searchField;

    @FindBy(id = "LoginForm_username")
    private WebElement emailField;

    @FindBy(id = "login_user_password")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[contains(@class,'pt_20')]")
    private WebElement submitLogin;

    @FindBy(id = "go-tab-recovery")
    private WebElement recoveryPasswordLink;

    @FindBy(id = "go-tab-userregister")
    private WebElement registrationTab;

    @FindBy(id = "login_user_password")
    private WebElement passField;

    @FindBy(xpath = ".//div[contains(@class,'pt_20')]")
    private WebElement submitButton;

    @FindBy(xpath = ".//div[@class='error-text'][contains(text(),'.')]")
    private WebElement errorLabel;

    @FindBy(id = "RegisterUserFirmForm_user_email")
    private WebElement regEmailField;

    @FindBy(id = "user_user_password")
    private WebElement regPasswordField;

    @FindBy(xpath = "//div[contains(@class,'mt_10')]")
    private WebElement submitRegistration;

    @FindBy(id = "SearchForm_searchPhrase")
    private WebElement searchInput;

    /*@FindBy(xpath = "//div[@class='form-wrap clearer-block']//span[@class^='soc-btn-facebook ga_user_login_page_social_click'][contains(text(),'facebook')]")
    WebElement authByFacebook;

    @FindBy(xpath = "//div[@class='form-wrap clearer-block']//span[@class='soc-btn-twitter ga_user_login_page_social_click'][contains(text(),'twitter')]")
    WebElement authByTwitter;

    @FindBy(xpath = "//div[@class='form-wrap clearer-block']//span[@class='soc-btn-google ga_user_login_page_social_click'][contains(text(),'google')]")
    WebElement authByGoogle;

    @FindBy(xpath = "//div[@class='form-content type-login']//a[@class='link-window-open ga_footer_agreement']")
    WebElement usersAgreementLink;

    @FindBy(xpath = "//div[@class='form-content type-login']//label")
    WebElement usersAgreementAcceptedCheckbox;

    @FindBy(xpath = "//div[@class='right-block-inputs']//div[1]//div[1]")
    WebElement blankEmailFieldMessage;

    @FindBy(xpath = "//div[@id='tab-login']//div[@class='right-block-inputs']//div[2]//div[1]")
    WebElement blankPasswordFieldMessage;

    @FindBy(xpath = "//div[@class='right-block-inputs']//div[2]//div[1]")
    WebElement blankRegEmailFieldMessage;

    @FindBy(xpath = "//div[@class='right-block-inputs']//div[3]//div[1]")
    WebElement blankRegPasswordFieldMessage;

    @FindBy(xpath = "//button[contains(@class,'ga_register_user_popup_close']")
    WebElement closeFormButton;*/

    public MainPage(WebDriver driver){
        super(driver);
    }

    // Fill login form and submit
    public void fillLoginForm(String email, String password) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginLink);
        //clickWebElement(loginLink);
        enterTextInTextField(emailField, email);
        enterTextInTextField(passwordField, password);
        clickWebElement(submitButton);
    }

    // Tab to registration and fill registration form and submit
    public void fillRegistrationForm(String email, String password) {
        clickWebElement(loginLink);
        clickWebElement(registrationTab);
        enterTextInTextField(regEmailField, email);
        enterTextInTextField(regPasswordField, password);
        clickWebElement(submitRegistration);
    }

    // Get title from login button
    public String getAccountName() {
        return userAccount.getText();
    }

    // Check is error message appears
    public boolean checkErrorLoginMessageAppears() {
        System.out.println(errorLabel.getText());
        return errorLabel.isDisplayed();
    }

    // Fill search field and open search result page
    public void runSearch(String searchRequest) {
        searchInput.sendKeys(searchRequest + Keys.ENTER);
    }

}
