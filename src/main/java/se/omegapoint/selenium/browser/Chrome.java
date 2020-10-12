package se.omegapoint.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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