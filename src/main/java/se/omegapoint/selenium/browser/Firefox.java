package se.omegapoint.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The Firefox browser
 */
public class Firefox implements BrowserDriver {
    public WebDriver getDriverInstance() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
