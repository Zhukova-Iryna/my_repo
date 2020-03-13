package ua.price.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.price.properties.PropertyReader;
import ua.price.site.base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class UserAccountTest extends BaseTest {
    private String newWishListName;

    @BeforeClass
    public void setUp() {
        driver.get(pagesUrl.accountUrl());
        newWishListName = PropertyReader.getProperty("new_wish_list_name");
    }

    @Test
    public void checkHobbyChosenSave() {
        userAccountSteps.loginToAccount(user);
        userAccountSteps.setCheckingHobby(driver);
        Assert.assertTrue(userAccountSteps.isSuccessSaveMessageAppears(), "Wrong setting for hobby");
    }

    @Test
    public void checkNewWishListCreated() {
        userAccountSteps.loginToAccount(user);
        userAccountSteps.openWishListAccountDirectory();
        userAccountSteps.createNewWishList(newWishListName);
        assertThat(userAccountSteps.getNewWishListName().equals(newWishListName));
    }

    @Test
    public void checkItemAddedToWishList() {
        userAccountSteps.loginToAccount(user);
        userAccountSteps.openWishListAccountDirectory();
        userAccountSteps.selectWishList();
        int previousAmount = userAccountSteps.getAmountOfAddingItemsInWishList();
        searchSteps.openSearchPage(pagesUrl);
        userAccountSteps.addItemToFavorite();
        userAccountSteps.openWishListsFromMainPage();
        userAccountSteps.selectWishList();
        Assert.assertTrue(userAccountSteps.getAmountOfAddingItemsInWishList() == ++previousAmount);
    }
}