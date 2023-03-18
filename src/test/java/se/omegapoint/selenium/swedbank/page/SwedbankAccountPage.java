package se.omegapoint.selenium.swedbank.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object representing the account page for Swedbank demo.
 */
public class SwedbankAccountPage {

    private final WebDriver driver;

    private final By headerText = By.cssSelector("h1[slot=heading]");

    public SwedbankAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnPage() {
        return "Sparkapitalkonto".equals(driver.findElement(headerText).getText());
    }
}
