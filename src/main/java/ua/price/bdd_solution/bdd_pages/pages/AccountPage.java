package ua.price.bdd_solution.bdd_pages.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;
import ua.price.bdd_solution.bdd_pages.base_page.BasePage;

import java.util.List;

@DefaultUrl("https://price.ua/user/login")
public class AccountPage extends BasePage {
    @FindBy(xpath = ".//input[@id='LoginForm_username']")
    private WebElementFacade loginEmailInput;

    @FindBy(xpath = ".//input[@id='LoginForm_password']")
    private WebElementFacade loginPasswordInput;

    @FindBy(xpath = ".//a[contains(@class,'ga_user_login_page_enter_click')]")
    private WebElementFacade loginSubmit;

    @FindBy(xpath = ".//label[@for='UserHobbies0']")
    private WebElementFacade checkBoxTourismHobby;

    @FindBy(xpath = ".//input[@id='UserHobbies1']")
    private WebElementFacade checkBoxMusicHobby;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElementFacade saveButton;

    @FindBy(xpath = ".//a[@class='i-logout']")
    private WebElementFacade logoutLink;

    @FindBy(xpath = ".//a[@id='header-user-link']/span")
    private WebElementFacade accountIcon;

    @FindBy(xpath = ".//div[contains(@class,'alert-success')]")
    private WebElementFacade successMessage;

    @FindBy(xpath = "(.//ul[@id='yw1']/li)[4]")
    private WebElementFacade userWishListLink;

    @FindBy(xpath = ".//div[contains(@class,'wishlist-list-item')]")
    private List<WebElementFacade> wishListItems;

    @FindBy(xpath = ".//a[contains(@class,'create_wishlist_cabinet')]")
    private WebElementFacade createNewWishListButton;

    @FindBy(xpath = ".//input[@id='wishlist-name']")
    private WebElementFacade newWishListNameInput;

    @FindBy(xpath = ".//button[contains(@class,'btn-create-list')]")
    private WebElementFacade saveNewWishListButton;

    @FindBy(xpath = ".//a[contains(@class,'wishlist-chips-item')]")
    private List<WebElementFacade> wishLists;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void loginToAccount(String email, String password) {
        typeInto(loginEmailInput, email);
        typeInto(loginPasswordInput, password);
        clickOn(loginSubmit);
    }

    public void scrollToHobby() {
        checkBoxTourismHobby.setWindowFocus();
    }

    public void checkTourismHobby() {
        jsClickWebElement(checkBoxTourismHobby);
    }

    public void clickSaveChangesButton() {
        jsClickWebElement(saveButton);
    }

    public boolean isSuccessChangesSaveMessage() {
        return successMessage.isCurrentlyVisible();
    }

    public void clickFavoritesLink() {
        clickOn(userWishListLink);
    }

    public void clickCreateNewFavoritesList() {
        clickOn(createNewWishListButton);
    }

    public int getAmountOfDefaultFavoritesListItems() {
        return wishListItems.size();
    }

    public void enterNewWishListName(String name) {
        typeInto(newWishListNameInput, name);
    }

    public void clickSaveNewFavoritesListButton() {
        clickOn(saveNewWishListButton);
    }

    public String getLastFavoritesListName() {
        return wishLists.get(wishLists.size() - 1).getText();
    }

    public void enterRequestAndRunSearch(String request) {
        searchRequestInput.typeAndEnter(request);
    }
}
