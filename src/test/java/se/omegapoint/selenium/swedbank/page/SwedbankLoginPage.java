package se.omegapoint.selenium.swedbank.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page object representing the login page for Swedbank demo.
 */
public class SwedbankLoginPage {
    public static final String baseUrl = "https://demo.swedbank.se";

    private static final String pageUrl = "/app/ib/logga-in";

    private final WebDriver driver;

    // Elements on page
    private final By consentButton = By.cssSelector("acorn-button[data-test-id=acorn-button-accept-all-cookies]");

    private final By initialLoginButton = By.cssSelector("acorn-button[data-test-id=initial-login-button]");

    private final By privateProfileSelector = By.cssSelector("acorn-item[tabIndex=\"0\"]");

    public SwedbankLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(baseUrl + pageUrl);
    }

   public void acceptAllCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        driver.findElement(consentButton).click();
   }

   public boolean isLoginButtonDisplayed() {
       try {
           return driver.findElement(initialLoginButton).isDisplayed();
       } catch (NoSuchElementException e) {
           return false;
       }
   }
   public void login() {
        driver.findElement(initialLoginButton).click();
   }

   public void selectPrivateProfile() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.elementToBeClickable(privateProfileSelector));
       driver.findElement(privateProfileSelector).click();
   }
}

