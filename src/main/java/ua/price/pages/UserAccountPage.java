package ua.price.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.price.base.BasePage;

public class UserAccountPage extends BasePage {

    @FindBy(xpath = ".//input[@id='LoginForm_username']")
    private WebElement loginEmailInput;

    @FindBy(xpath = ".//input[@id='LoginForm_password']")
    private WebElement loginPasswordInput;

    @FindBy(xpath = ".//a[contains(@class,'ga_user_login_page_enter_click')]")
    private WebElement loginSubmit;

    @FindBy(xpath = ".//input[@id='UserHobbies0']")
    private WebElement checkBoxTourismHobby;

    @FindBy(xpath = ".//input[@id='UserHobbies1']")
    private WebElement checkBoxMusicHobby;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = ".//a[@class='i-logout']")
    private WebElement logoutLink;

    @FindBy(xpath = ".//a[@id='header-user-link']/span")
    private WebElement accountIcon;

    @FindBy(xpath = ".//div[contains(@class,'alert-success')]")
    WebElement successMessage;

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHobbyChecked() {
        return checkBoxTourismHobby.isSelected();
    }

    public void loginToAccount(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginSubmit.click();
    }

    public void logOut() {
        clickWebElement(accountIcon);
        clickWebElement(logoutLink);
    }

    public boolean isSuccessMessageAppears() {
        return successMessage.isDisplayed();
    }
}
