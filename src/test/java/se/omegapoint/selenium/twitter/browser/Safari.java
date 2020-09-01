package se.omegapoint.selenium.twitter.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.lang.reflect.InvocationTargetException;

/**
 * The Safari browser - not working yet
 */
public class Safari implements BrowserDriver {
    public WebDriver getDriverInstance() {

        DriverManagerType safari = DriverManagerType.SAFARI;
        WebDriverManager.getInstance(safari).setup();

        Class<?> safariClass = null;
        try {
            safariClass = Class.forName(safari.browserClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return (WebDriver) safariClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

       //return new SafariDriver();
    }
}
