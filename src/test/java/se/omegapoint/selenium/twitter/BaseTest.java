package se.omegapoint.selenium.twitter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import se.omegapoint.selenium.browser.BrowserDriver;
import se.omegapoint.selenium.browser.BrowserSelector;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * The base test setting up and tearing down the specified WebDriver.
 */
public abstract class BaseTest {

    protected WebDriver driver;

    protected BrowserDriver getBrowser() {
        return BrowserSelector.getConfiguredBrowser();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
        isAlertPresentThenAccept();
    }

    protected boolean isAlertPresentThenAccept() {
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeEach
    public void setUp() {
        driver = getBrowser().getDriverInstance();
        driver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS));
        driver.manage().window().fullscreen();
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
