package se.omegapoint.selenium.twitter.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.omegapoint.selenium.twitter.infra.Config;

/**
 * The Firefox browser
 */
public class Firefox implements BrowserDriver {
    public WebDriver getDriverInstance() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
