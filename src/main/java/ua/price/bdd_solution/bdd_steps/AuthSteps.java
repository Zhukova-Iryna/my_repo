package ua.price.bdd_solution.bdd_steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import ua.price.bdd_solution.bdd_pages.pages.MainPageAuth;
import ua.price.site.data.bean.user.User;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthSteps extends ScenarioSteps {
    MainPageAuth mainPageAuth;
    User user;

    public AuthSteps(Pages pages) {
        super(pages);
        user = new User();
    }

    @Step
    public void openMainPage() {
        mainPageAuth.open();
    }

    @Step
    public void openLoginForm() {
        mainPageAuth.openAuthenticationForm();
    }

    @Step
    public void loginToAccount() {
        mainPageAuth.login(user);
    }

    @Step
    public void switchToRegistrationTab() {
        mainPageAuth.switchToRegistrationTab();
    }

    @Step
    public void registrationOnSite() {
        mainPageAuth.registration(user);
    }

    @Step
    public void loginWithInvalidPassword() {
        mainPageAuth.login(user.password("test2020"));
    }

    @Step
    public void inscriptionShouldChanged() {
        assertThat(mainPageAuth.getTextFromUserAccountLink()).doesNotContain("Вход");
    }

    @Step
    public void shouldAppearErrorMessage() {
        assertThat(mainPageAuth.isErrorMessageDisplayed()).isTrue();
    }

    @Step
    public void shouldSeeErrorLoginMessage() {
        assertThat(mainPageAuth.isErrorMessageDisplayed()).isTrue();
    }
}