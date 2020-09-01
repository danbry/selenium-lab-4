package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page object for the main page for Twitter.
 */
public class MainPage {
    private final WebDriver driver;

    public static final String path = "/home";

    private final By profileButton = By.cssSelector("#react-root a[aria-label=Profile]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnMainPage() {
        String  currentUrl = driver.getCurrentUrl();
        return currentUrl.endsWith(path);
    }

    public void clickProfileButton() {
        driver.findElement(profileButton).click();;
    }
}
