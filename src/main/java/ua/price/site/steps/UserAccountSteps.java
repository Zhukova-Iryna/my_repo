package ua.price.site.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ua.price.site.base_steps.BaseSteps;
import ua.price.site.data.bean.user.User;

public class UserAccountSteps extends BaseSteps {
    public UserAccountSteps(WebDriver driver) {
        super(driver);
    }

    public void loginToAccount(User user) {
        waitUntilPageLoaded();
        enterTextInTextField(userAccountPage.loginEmailInput(), user.email());
        enterTextInTextField(userAccountPage.loginPasswordInput(), user.password());
        clickWebElement(userAccountPage.loginSubmit());
    }

    public void setCheckingHobby(WebDriver driver) {
        waitUntilPageLoaded();
        Actions actions = new Actions(driver);
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
        waitUntilPageLoaded();
        return waitUtils.isElementSelected(userAccountPage.checkBoxTourismHobby());
    }

    public boolean isSuccessSaveMessageAppears() {
        waitUntilPageLoaded();
        return waitUtils.isElementDisplayed(userAccountPage.successMessage());
    }
}
