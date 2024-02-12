package DriverManager;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CustomWebDriverProvider implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
            return initBrowser().getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Browser initBrowser() throws MalformedURLException {
        WebDriver driver = DriverFactory.init("FIREFOX", "locale");
        return new Browser(driver, TimeUnit.SECONDS, 5, 30);
    }

    @Override
    public boolean takesScreenshots() {
        return true; // Set it to true if you want Serenity to take screenshots
    }
}
