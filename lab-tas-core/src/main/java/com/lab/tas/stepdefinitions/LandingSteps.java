package com.lab.tas.stepdefinitions;

import com.lab.tas.stepdefinitions.actions.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.hamcrest.Matchers;

import static com.lab.tas.assertions.AssertionWrapper.assertThat;

public class LandingSteps extends UIInteractionSteps {

    @Steps
    LandingPage landingPage;

    @Given("{string} opens EliteSingle\\(US)")
    public void sergeyOpensEliteSingleUS(String actor) {
        openUrl("https://www.elitesingles.com/");
    }

    @When("he wants to reset his password")
    public void heWantsToResetHisPassword() {
        landingPage.gotoForgotPage();
    }

    @Then("he enters email {string}")
    public void heEntersEmail(String email) {
        landingPage.enterEmail(email);
    }

    @When("he clicks on the terms & conditions label")
    public void heClicksOnTheTermsConditionsLabelText() {
        assertThat("T&C checkbox is not selected", landingPage.checkTAndCChecked(), Matchers.is(false));
        landingPage.clickOnTAndCLabel();
    }

    @Then("the terms & conditions checkbox should be checked")
    public void theTermsConditionsCheckboxShouldBeChecked() {
        assertThat("T&C checkbox is selected", landingPage.checkTAndCChecked(), Matchers.is(true));
    }

}