package com.liita.tas.DriverManager;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {


    static public WebDriver init(String device, String locale) {

        switch (device.toLowerCase()) {
            case "chrome": {
                //TODO Extract driver version
                WebDriverManager.chromedriver().driverVersion("122").setup();
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                options.setExperimentalOption("prefs", prefs);
                return new ChromeDriver(options);
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile profile = new FirefoxProfile();
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                return new FirefoxDriver(options);
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            case "safari": {
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            default:
                throw new RuntimeException(String.format("Failed to initialize WebDriver for config[%s]", device));
        }
    }
}
