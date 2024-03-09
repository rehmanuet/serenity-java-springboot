package com.lab.tas.stepdefinitions;

import com.lab.tas.configuration.SpringConfiguration;
import com.lab.tas.configuration.TestContextConfiguration;
import com.lab.tas.context.ScenarioContext;
import com.lab.tas.stepdefinitions.actions.LoginPage;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SerenityRunner.class)
@SpringBootTest(classes = TestContextConfiguration.class)

public class LoginSteps extends UIInteractionSteps {
    @Steps
    SpringConfiguration configuration;

    @Autowired
    ScenarioContext context;

    @Rule
    public SpringIntegrationMethodRule springIntegrationMethodRule =
            new SpringIntegrationMethodRule();

    @Steps
    LoginPage loginPage;

    @Given("{string} is logged into the dashboard")
    public void isLoggedIntoTheDashboard(String user) {
        openUrl("https://www.saucedemo.com/");
        loginPage.login(this.context.getUser(user));
    }
}