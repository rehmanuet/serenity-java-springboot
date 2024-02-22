package DriverManager;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.webdriver.DriverSource;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import starter.stepdefinitions.ScenarioContext;

import java.net.MalformedURLException;

import static DriverManager.Driver.*;

public class CustomWebDriverProvider implements DriverSource {
    @Autowired
    ScenarioContext context;
    @Override
    public WebDriver newDriver() {
        try {
            return initBrowser().getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Browser initBrowser() throws MalformedURLException {
        WebDriver driver = DriverFactory.init(new Device().driver(CHROME), "locale");
        return new Browser(driver, 5, 30);
    }

    @Override
    public boolean takesScreenshots() {
        return true; // Set it to true if you want Serenity to take screenshots
    }
}
