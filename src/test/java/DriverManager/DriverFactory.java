package DriverManager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {


    static public WebDriver init(Device device, String locale) throws MalformedURLException {

        switch (device.driver()) {
            case CHROME: {
                //TODO Extract driver version
                WebDriverManager.chromedriver().driverVersion("121").setup();
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                // prefs.put("intl.accept_languages", String.format("%s-%s", locale.language(), locale.country()));
                options.setExperimentalOption("prefs", prefs);
                return new ChromeDriver(options);
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile profile = new FirefoxProfile();
//                profile.setPreference("intl.accept_languages", String.format("%s-%s", locale.language(), locale.country()));
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                return new FirefoxDriver(options);
            }
            case EDGE: {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            case SAFARI: {
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            default:
                throw new RuntimeException(String.format("Failed to initialize WebDriver for config[%s]", device));
        }
    }
}
