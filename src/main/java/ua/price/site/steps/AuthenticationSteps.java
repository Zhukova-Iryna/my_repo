package ua.price.site.steps;

import org.openqa.selenium.WebDriver;
import ua.price.site.base_steps.BaseSteps;
import ua.price.site.data.bean.user.User;

public class AuthenticationSteps extends BaseSteps {
    public AuthenticationSteps(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        waitUntilPageLoaded();
    }

    public void openAuthenticationForm() {
        waitUntilPageLoaded();
        clickWebElement(mainPage.loginLink());
    }

    public void openRegistrationTabInAuthenticationForm() {
        clickWebElement(mainPage.registrationTab());
    }

    public void login(User user) {
        enterTextInTextField(mainPage.emailField(), user.email());
        enterTextInTextField(mainPage.passwordField(), user.password());
        clickWebElement(mainPage.submitLoginButton());
    }


    public void registration(User user) {
        enterTextInTextField(mainPage.regEmailField(), user.regEmail());
        enterTextInTextField(mainPage.regPasswordField(), user.regPassword());
        clickWebElement(mainPage.submitRegistration());
    }

    public String getAccountLinkName() {
        return getTextFromElement(mainPage.userAccount());
    }

    public boolean isErrorMessageDisplayed() {
        return waitUtils.isElementDisplayed(mainPage.errorLabel());
    }

    public boolean isSuccessfulRegistrationMessageAppears() {
        return waitUtils.isElementDisplayed(mainPage.confirmRegistrationMessage());
    }

    public void logout() {
        waitUntilPageLoaded();
        clickWebElement(mainPage.userAccount());
        waitUntilPageLoaded();
        jsClickWebElement(mainPage.loginUsersSignOut());
    }
}
