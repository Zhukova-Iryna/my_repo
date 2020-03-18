package ua.price.site.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.price.site.base.BasePage;

import java.util.List;

@Accessors(fluent = true)
@Getter
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
    private WebElement successMessage;

    @FindBy(xpath = "(.//ul[@id='yw1']/li)[4]")
    private WebElement userWishListLink;

    @FindBy(xpath = ".//div[contains(@class,'wishlist-list-item')]")
    private List<WebElement> wishListItems;

    @FindBy(xpath = ".//a[contains(@class,'create_wishlist_cabinet')]")
    private WebElement createNewWishListButton;

    @FindBy(xpath = ".//input[@id='wishlist-name']")
    private WebElement newWishListNameInput;

    @FindBy(xpath = ".//button[contains(@class,'btn-create-list')]")
    private WebElement saveNewWishListButton;

    @FindBy(xpath = ".//a[contains(@class,'wishlist-chips-item')]")
    private List<WebElement> wishLists;

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }
}
