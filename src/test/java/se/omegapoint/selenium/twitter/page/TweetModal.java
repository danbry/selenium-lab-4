package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page object representing the tweet modal.
 */
public class TweetModal {
    private final WebDriver driver;

    private final By tweetButton = By.cssSelector("div[data-testid=tweetButton]");
    private final By tweetButtonDisabled = By.cssSelector("div[data-testid=tweetButton][aria-disabled=true]");
    private final By tweetTextBox = By.cssSelector("div[aria-label=\"Tweet text\"]");


    public TweetModal(WebDriver driver) {
        this.driver = driver;
    }

    public void openModal() {
        driver.get(LoginPage.baseUrl + "/compose/tweet");
    }

    public boolean isOnTweetModal() {
        try {
            WebElement element = driver.findElement(tweetTextBox);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterTweet(String text) {
        WebElement element = driver.findElement(tweetTextBox);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isTweetButtonEnabled() {
        WebElement element = driver.findElement(tweetButtonDisabled);
        return element == null;
    }

    public void clickTweetButton() {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.elementToBeClickable(tweetButton));
        element.click();
    }
}
