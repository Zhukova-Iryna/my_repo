package ua.price.steps;

import org.openqa.selenium.WebDriver;

public class UserAccountSteps extends BaseSteps {
    public UserAccountSteps(WebDriver driver) {
        super(driver);
    }

    public void loginToAccount(String email, String password) {
        waitUntilPageLoaded();
        enterTextInTextField(userAccountPage.loginEmailInput(), email);
        enterTextInTextField(userAccountPage.loginPasswordInput(), password);
        clickWebElement(userAccountPage.loginSubmit());
    }

    public boolean isHobbyChecked() {
        waitUntilPageLoaded();
        return userAccountPage.checkBoxTourismHobby().isSelected();
    }

    public boolean isSuccessMessageAppears() {
        waitUntilPageLoaded();
        return userAccountPage.successMessage().isDisplayed();
    }
}
