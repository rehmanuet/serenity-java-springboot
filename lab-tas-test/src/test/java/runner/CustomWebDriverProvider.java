package runner;

import com.lab.tas.drivermanager.Browser;
import com.lab.tas.drivermanager.DriverFactory;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.webdriver.DriverSource;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


public class CustomWebDriverProvider implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
            return initBrowser().getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Browser initBrowser() throws MalformedURLException {
        //TODO Extract env variable
        EnvironmentSpecificConfiguration value = EnvironmentSpecificConfiguration.from(SystemEnvironmentVariables.createEnvironmentVariables());
        WebDriver driver = DriverFactory.init(value.getProperty("browser"), "locale");
        return new Browser(driver, Integer.parseInt(value.getProperty("element.timeout")), Integer.parseInt(value.getProperty("page.timeout")));
    }

    @Override
    public boolean takesScreenshots() {
        return true; // Set it to true if you want Serenity to take screenshots
    }
}
