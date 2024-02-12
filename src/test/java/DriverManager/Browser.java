package DriverManager;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testmonkeys.maui.core.browser.popups.BrowserPopUps;
import org.testmonkeys.maui.core.elements.location.LocatesElements;
import org.testmonkeys.maui.core.elements.location.Locator;

public class Browser implements LocatesElements {
    Logger logger = LoggerFactory.getLogger(org.testmonkeys.maui.core.browser.Browser.class);
    private WebDriver driver;
    private FluentWait<WebDriver> dynamicWaiter;
    private int pageTimeout = 10;
    private int elementTimeout = 10;
    private TimeUnit unit;
    private int step;
    private BrowserPopUps browserPopUps;

    public Browser(WebDriver driver) {
        this.unit = TimeUnit.SECONDS;
        this.step = 1;
        this.driver = driver;
        this.dynamicWaiter = this.initWaitter(this.elementTimeout, this.step, this.unit);
    }

    public Browser(WebDriver driver, TimeUnit unit, int elementTimeout, int pageTimeout) {
        this.unit = TimeUnit.SECONDS;
        this.step = 1;
        this.driver = driver;
        this.elementTimeout = elementTimeout;
        this.unit = unit;
        this.pageTimeout = pageTimeout;
//        this.driver.manage().timeouts().pageLoadTimeout((long) pageTimeout, unit);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(pageTimeout));
        this.dynamicWaiter = this.initWaitter(elementTimeout, this.step, unit);
    }

    public byte[] takeScreenshot() {
        return (byte[]) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    public FluentWait<WebDriver> getDynamicWaiter() {
        return this.dynamicWaiter;
    }

    public WebElement findElement(Locator locator) {
        return (WebElement) this.dynamicWaiter.until((webDriver) -> {
            return webDriver.findElement(locator.getSeleniumLocator());
        });
    }

    public List<WebElement> findElements(Locator locator) {
        return (List) this.dynamicWaiter.until((webDriver) -> {
            return webDriver.findElements(locator.getSeleniumLocator());
        });
    }

    private FluentWait<WebDriver> initWaitter(int timeout, int step, TimeUnit unit) {
        return (new FluentWait(this.driver)).withTimeout(Duration.ofSeconds(101)).pollingEvery(Duration.ofSeconds(100)).ignoring(NoSuchElementException.class);
    }

    public BrowserPopUps getPopUps() {
        return this.browserPopUps;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void goTo(String url) {
        this.logger.info("Accessing URL:" + url);
        this.driver.navigate().to(url);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void quit() {
        this.driver.quit();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void goBack() {
        this.driver.navigate().back();
    }

    public void waitForPageToLoad() {
        this.initWaitter(this.pageTimeout, this.step, this.unit).until((d) -> {
            return ((JavascriptExecutor) d).executeScript("return document.readyState", new Object[0]).equals("complete");
        });
    }

    public String getPageHtml() {
        return this.driver.getPageSource();
    }
}
