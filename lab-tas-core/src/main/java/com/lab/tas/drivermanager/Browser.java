package com.lab.tas.drivermanager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {
    Logger logger = LoggerFactory.getLogger(Browser.class);
    private WebDriver driver;
    private FluentWait<WebDriver> dynamicWaiter;
    private int pageTimeout = 10;
    private int elementTimeout = 10;
    private TimeUnit unit;
    private int step;

    public Browser(WebDriver driver) {
        this.unit = TimeUnit.SECONDS;
        this.step = 1;
        this.driver = driver;
        this.dynamicWaiter = this.initWaitter(this.elementTimeout, this.step);
    }

    public Browser(WebDriver driver, int elementTimeout, int pageTimeout) {
        this.unit = TimeUnit.SECONDS;
        this.step = 1;
        this.driver = driver;
        this.elementTimeout = elementTimeout;
        this.pageTimeout = pageTimeout;
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeout));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(pageTimeout));
        this.dynamicWaiter = this.initWaitter(elementTimeout, this.step);
    }

    public byte[] takeScreenshot() {
        return (byte[]) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    public FluentWait<WebDriver> getDynamicWaiter() {
        return this.dynamicWaiter;
    }

    private FluentWait<WebDriver> initWaitter(int timeout, int step) {
        return (new FluentWait(this.driver)).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(step)).ignoring(NoSuchElementException.class);
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
        this.initWaitter(this.pageTimeout, this.step).until((d) -> {
            return ((JavascriptExecutor) d).executeScript("return document.readyState", new Object[0]).equals("complete");
        });
    }

    public String getPageHtml() {
        return this.driver.getPageSource();
    }
}
