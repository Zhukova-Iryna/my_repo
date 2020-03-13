package ua.price.site.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.price.site.base_steps.BaseSteps;
import ua.price.site.data.bean.user.User;

public class UserAccountSteps extends BaseSteps {
    public UserAccountSteps(WebDriver driver) {
        super(driver);
    }

    public void loginToAccount(User user) {
        waitUtils.waitUntilPageLoaded();
        enterTextInTextField(userAccountPage.loginEmailInput(), user.email());
        enterTextInTextField(userAccountPage.loginPasswordInput(), user.password());
        clickWebElement(userAccountPage.loginSubmit());
    }

    public void setCheckingHobby(WebDriver driver) {
        waitUtils.waitUntilPageLoaded();
        actions.moveToElement(userAccountPage.saveButton());
        if (waitUtils.isElementSelected(userAccountPage.checkBoxTourismHobby())) {
            jsClickWebElement(userAccountPage.checkBoxTourismHobby());
            jsClickWebElement(userAccountPage.checkBoxMusicHobby());
        } else if (waitUtils.isElementSelected(userAccountPage.checkBoxMusicHobby())) {
            jsClickWebElement(userAccountPage.checkBoxMusicHobby());
            jsClickWebElement(userAccountPage.checkBoxTourismHobby());
        } else jsClickWebElement(userAccountPage.checkBoxTourismHobby());
        clickWebElement(userAccountPage.saveButton());
    }

    public boolean isHobbyChecked() {
        waitUtils.waitUntilPageLoaded();
        return waitUtils.isElementSelected(userAccountPage.checkBoxTourismHobby());
    }

    public boolean isSuccessSaveMessageAppears() {
        waitUtils.waitUntilPageLoaded();
        return waitUtils.isElementDisplayed(userAccountPage.successMessage());
    }

    public void openWishListsFromMainPage() {
        clickWebElement(mainPage.wishListLink());
    }

    public void openWishListAccountDirectory() {
        clickWebElement(userAccountPage.userWishListLink());
        waitUtils.waitUntilPageLoaded();
    }

    public void createNewWishList(String newWishListName) {
        clickWebElement(userAccountPage.createNewWishListButton());
        enterTextInTextField(userAccountPage.newWishListNameInput(), newWishListName);
        clickWebElement(userAccountPage.saveNewWishListButton());
    }

    public String getNewWishListName() {
        waitUtils.waitUntilPageLoaded();
        return getTextFromElement(userAccountPage.wishLists().get(userAccountPage.wishLists().size() - 1));
    }

    public int getAmountOfAddingItemsInWishList() {
        return userAccountPage.wishListItems().size();
    }

    public void selectWishList() {
        clickWebElement(userAccountPage.wishLists().get(0));
    }

    public void selectWishList(String wishListName) {
        waitUtils.waitUntilPageLoaded();
        for (WebElement e:userAccountPage.wishLists()) {
            if(userAccountPage.wishLists().size() > 1 && getTextFromElement(e).equals(wishListName)) {
                System.out.println(getTextFromElement(e));
                jsClickWebElement(e);
            } else selectWishList();
        }
    }

    public void addItemToFavorite() {
        clickWebElement(searchPage.addForthSearchResultToFavoriteList());
        clickWebElement(searchPage.wishListCheckboxes().get(0));
    }

    public void addItemToFavorite(String wishListName) {
        waitUtils.waitUntilPageLoaded();
        clickWebElement(searchPage.addForthSearchResultToFavoriteList());
        for (WebElement e:searchPage.wishListCheckboxes()) {
            if(getTextFromElement(e).equals(wishListName)) {
                System.out.println(getTextFromElement(e));
                jsClickWebElement(e);
            } else clickWebElement(searchPage.wishListCheckboxes().get(0));
        }
    }
}
