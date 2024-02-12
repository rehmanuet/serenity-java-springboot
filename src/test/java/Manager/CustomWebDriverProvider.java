package Manager;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;


import java.net.MalformedURLException;

public class CustomWebDriverProvider implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
//
            return DriverFactory.init("CHROME", "locale");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true; // Set it to true if you want Serenity to take screenshots
    }
}
