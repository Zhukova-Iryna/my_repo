package ua.price.site.steps;

import org.openqa.selenium.WebDriver;
import ua.price.site.base_steps.BaseSteps;
import ua.price.site.data.PagesUrl;
import ua.price.site.data.bean.user.User;

public class AuthenticationSteps extends BaseSteps {
    public AuthenticationSteps(WebDriver driver) {
        super(driver);
    }

    public void openMainPage(PagesUrl pagesUrl) {
        driver.get(pagesUrl.baseUrl());
        waitUtils.waitUntilPageLoaded();
    }

    public void openAuthenticationForm() {
        waitUtils.waitUntilPageLoaded();
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

    public void inputEmail(User user) {
        enterTextInTextField(mainPage.emailField(), user.email());
    }

    public void registration(User user) {
        enterTextInTextField(mainPage.regEmailField(), user.regEmail());
        enterTextInTextField(mainPage.regPasswordField(), user.regPassword());
        clickWebElement(mainPage.submitRegistration());
    }

    public String getAccountLinkName() {
        waitUtils.waitUntilPageLoaded();
        return getTextFromElement(mainPage.userAccount());
    }

    public boolean isErrorMessageDisplayed() {
        waitUtils.waitUntilPageLoaded();
        return waitUtils.isElementDisplayed(mainPage.errorLabel());
    }

    public boolean isSuccessfulRegistrationMessageAppears() {
        waitUtils.waitUntilPageLoaded();
        return waitUtils.isElementDisplayed(mainPage.confirmRegistrationMessage());
    }

    public void logout() {
        waitUtils.waitUntilPageLoaded();
        clickWebElement(mainPage.userAccount());
        waitUtils.waitUntilPageLoaded();
        jsClickWebElement(mainPage.loginUsersSignOut());
    }
}
