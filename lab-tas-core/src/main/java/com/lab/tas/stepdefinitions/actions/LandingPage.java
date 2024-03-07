package com.lab.tas.stepdefinitions.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LandingPage extends UIInteractionSteps {
    private final By loginButton = By.cssSelector("[id='show-login']");
    private final By forgotPassLink = By.cssSelector("[class*='LoginForm_login-form__forgPass'] [href]");
    private final By emailField = By.cssSelector("[class='spark-input'][autocomplete='username']");
    private final By termsAndConditionLabel = By.cssSelector("label[for='reg-legal']");
    private final By termsAndConditionCheckBox = By.cssSelector("input[type='checkbox'][id='reg-legal']");


    public void gotoForgotPage() {
        find(loginButton).click();
        find(this.forgotPassLink).click();
    }

    public void enterEmail(String email) {
        find(emailField).type(email);
    }


    public void clickOnTAndCLabel() {
        find(termsAndConditionLabel).click();
    }

    public boolean checkTAndCChecked() {
        return find(termsAndConditionCheckBox).isSelected();
    }

}
