package com.lab.tas.stepdefinitions.actions;

import com.lab.tas.models.User;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;


public class LoginPage extends UIInteractionSteps {

    private final By userNameField = By.cssSelector("[data-test='username']");
    private final By passwordField = By.cssSelector("[data-test='password']");
    private final By loginButton = By.cssSelector("[data-test='login-button']");

    public void login(User user) {
        find(userNameField).type(user.username());
        find(passwordField).type(user.password());
        find(loginButton).click();
    }

}
