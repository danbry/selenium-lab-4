package se.omegapoint.selenium.swedbank.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page object representing the start page for Swedbank demo.
 */
public class SwedbankStartPage {

    private final String pageUrl = "/app/ib/start-page";
    private final WebDriver driver;

    // Elements on page
    private final By welcomeHeroSelector = By.cssSelector("acorn-hero h1");

    private final By accountsSelector = By.cssSelector("fdp-widget-my-accounts acorn-item");

    private final String welcomeHeroTextSwedish = "Välkommen!";

    public SwedbankStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(SwedbankLoginPage.baseUrl + pageUrl);
    }

    public void goToAccountPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> accounts = driver.findElements(accountsSelector);
        wait.until(ExpectedConditions.visibilityOfAllElements(accounts));
        accounts.get(2).click();
    }

    public boolean isOnPage() {
        try {
            WebElement element = driver.findElement(welcomeHeroSelector);
            return welcomeHeroTextSwedish.equals(element.getText());
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}

