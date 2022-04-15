package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.omegapoint.selenium.infra.Config;

import java.time.Duration;

/**
 * Page object for the main page for Twitter.
 */
public class MainPage {
    private final WebDriver driver;

    public static final String path = "/home";

    private final By profileButton = By.cssSelector("a[href='/" + Config.getStringValue(Config.Value.USERNAME) + "']");

    private final By buttons = By.cssSelector("div[role=button]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        //Accept cookie settings.
        //TODO: The accept cookie settings button should be identified better.
        driver.findElements(buttons).get(0).click();
    }

    public boolean isOnMainPage() {
        String  currentUrl = driver.getCurrentUrl();
        return currentUrl.endsWith(path);
    }

    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }
}
