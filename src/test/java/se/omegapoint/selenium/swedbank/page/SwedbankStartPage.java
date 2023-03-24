package se.omegapoint.selenium.swedbank.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
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

    private final String welcomeHeroTextSwedish = new String("Välkommen!".getBytes(StandardCharsets.UTF_8));

    public SwedbankStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(SwedbankLoginPage.baseUrl + pageUrl);
    }

    public void goToAccountPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> accounts = driver.findElements(accountsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(accounts.get(2)));
        //Make sure the link is clickable if the screen is too small to see the link
        Actions actions = new Actions(driver);
        actions.moveToElement(accounts.get(2)).click().build().perform();
    }

    public boolean isOnPage() {
        try {
            WebElement element = driver.findElement(welcomeHeroSelector);
            String welcomeText = element.getText();
            String utf8WelcomeTextString = new String(welcomeText.getBytes(StandardCharsets.UTF_8));
            return welcomeHeroTextSwedish.equals(utf8WelcomeTextString);
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}

