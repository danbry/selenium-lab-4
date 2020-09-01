package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import se.omegapoint.selenium.twitter.infra.Config;

import java.util.Base64;

/**
 * Page object representing the login page for Twitter.
 */
public class LoginPage {
    static final String baseUrl = "https://www.twitter.com";
    private final WebDriver driver;

    // Elements on page
    private final By signinEmailInput = By.name("session[username_or_email]");
    private final By signinPasswordInput = By.name("session[password]");
    private final By loginButton = By.cssSelector("#react-root div[role=button]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(baseUrl + "/login");
    }

    public void doLogin(String userEmail, String password, Boolean base64DecodePassword) {
        //Fill in user name
        driver.findElement(signinEmailInput).sendKeys(userEmail);

        //Fill in password
        if (base64DecodePassword) {
            password = new String(Base64.getDecoder().decode(password));
        }
        driver.findElement(signinPasswordInput).sendKeys(password);

        //Click on login button
        driver.findElements(loginButton).get(1).click();
    }

    public void doLoginWithConfiguredUsernameAndPassword() {
        doLogin(Config.getStringValue(Config.Value.USERNAME),
                Config.getStringValue(Config.Value.PASSWORD),
                Config.getBooleanValue(Config.Value.BASE64_DECODE_PASSWORD));
    }


}
