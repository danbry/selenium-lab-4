package se.omegapoint.selenium.twitter.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import se.omegapoint.selenium.twitter.infra.Config;

import java.sql.Driver;

/**
 * The Chrome browser
 */
public class Chrome implements BrowserDriver {
    public WebDriver getDriverInstance()
    {
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver();
    }
}