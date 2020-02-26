package ua.price.steps;

import org.openqa.selenium.WebDriver;

public class AuthenticationSteps extends BaseSteps{
    private WebDriver driver;

    public AuthenticationSteps(WebDriver driver) {
        super(driver);
    }

    public void openAuthenticationForm() {
        waitUntilPageLoaded();
        clickWebElement(mainPage.loginLink());
    }

    public void openRegistrationTabInAuthenticationForm() {
        clickWebElement(mainPage.registrationTab());
    }

    public void login(String email, String password) {
        enterTextInTextField(mainPage.emailField(), email);
        enterTextInTextField(mainPage.passwordField(), password);
        clickWebElement(mainPage.submitLoginButton());
    }

    public void registration(String regEmail, String regPassword) {
        enterTextInTextField(mainPage.regEmailField(), regEmail);
        enterTextInTextField(mainPage.regPasswordField(), regPassword);
        clickWebElement(mainPage.submitRegistration());
    }

    public String getAccountLinkName() {
        return getTextFromElement(mainPage.userAccount());
    }

    public boolean isErrorMessageDisplayed() {
        return mainPage.errorLabel().isDisplayed();
    }

    public boolean isSuccessfulRegistrationMessageAppears() {
        return mainPage.confirmRegistrationMessage().isDisplayed();
    }

    public void logout() {
        clickWebElement(mainPage.userAccount());
        waitUntilPageLoaded();
        clickWebElement(mainPage.loginUsersSignOut());
    }
}
