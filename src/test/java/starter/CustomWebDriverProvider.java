package starter;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomWebDriverProvider implements DriverSource {

    @Override
    public WebDriver newDriver() {
        // Setup ChromeDriver using WebDriverManager (you can use other drivers similarly)
        WebDriverManager.chromedriver().driverVersion("121.0").setup();

        System.out.println("YOYO");

        // Configure ChromeOptions if needed

        // Create a new instance of ChromeDriver with the desired options
        return new ChromeDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return true; // Set it to true if you want Serenity to take screenshots
    }
}
