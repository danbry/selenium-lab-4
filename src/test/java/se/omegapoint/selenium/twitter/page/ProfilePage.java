package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.omegapoint.selenium.twitter.infra.Config;

import java.util.List;

/**
 * Page object for the profile page for Twitter.
 */
public class ProfilePage {

    private final WebDriver driver;
    private final By numberOfTweets = By.cssSelector("#react-root h2[role=heading] + div");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage(String userName) {
        driver.get(LoginPage.baseUrl + "/" + userName);
    }

    public void goToPageForConfiguredUsername() { goToPage(Config.getStringValue(Config.Value.USERNAME)); }

    public int getCurrentNumberOfTweets() {
        List<WebElement> elements = driver.findElements(numberOfTweets);

        String tweets = elements.get(1).getText();  //269 Tweets
        String[] splitTweetsString = tweets.split(" ");
        return Integer.parseInt(splitTweetsString[0]);
    }
}
