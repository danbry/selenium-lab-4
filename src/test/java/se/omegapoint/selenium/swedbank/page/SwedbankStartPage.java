package se.omegapoint.selenium.swedbank.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page object representing the login page for Swedbank demo.
 */
public class SwedbankStartPage {

    private final String pageUrl = "/app/ib/start-page";
    private final WebDriver driver;

    // Elements on page
    private final By welcomeHero = By.cssSelector("acorn-hero h1");

    private final By initialLoginButton = By.cssSelector("acorn-button[data-test-id=initial-login-button");

    private final By firstProfile = By.cssSelector("acorn-item[slot=item-0]");

    private final String welcomeHeroTextSwedish = "Välkommen!";

    public SwedbankStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(SwedbankLoginPage.baseUrl + pageUrl);
    }

    public boolean isOnPage() {
        try {
            WebElement element = driver.findElement(welcomeHero);
            return welcomeHeroTextSwedish.equals(element.getText());
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}

