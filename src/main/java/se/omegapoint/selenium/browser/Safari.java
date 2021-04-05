package se.omegapoint.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.lang.reflect.InvocationTargetException;

/**
 * The Safari browser - not working yet with insecure certs..
 */
public class Safari implements BrowserDriver {
    public WebDriver getDriverInstance() {
        DriverManagerType safari = DriverManagerType.SAFARI;
        WebDriverManager.getInstance(safari).setup();

        //The Safari driver does not allow "Accept Insecure Certs"
        /*
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        return new SafariDriver(options);
         */

        return new SafariDriver();
    }
}
