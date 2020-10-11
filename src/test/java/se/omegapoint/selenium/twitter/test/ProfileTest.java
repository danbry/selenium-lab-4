package se.omegapoint.selenium.twitter.test;

import org.junit.jupiter.api.Test;
import se.omegapoint.selenium.twitter.page.LoginPage;
import se.omegapoint.selenium.twitter.page.MainPage;
import se.omegapoint.selenium.twitter.page.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the profile page
 */
public class ProfileTest extends BaseTest {

    @Test
    public void goToProfilePage() {
        LoginPage loginPage = new LoginPage(driver);

        //Go to login page
        loginPage.goToPage();

        //Perform login
        loginPage.doLoginWithConfiguredUsernameAndPassword();

        //Verify that we are on the main page
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isOnMainPage(), "Not on main page");

        //Go to profile page
        mainPage.clickProfileButton();

        //Verify that we are on the profile page
        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue(profilePage.isOnPage());

        //Verify that the number of tweets are more than zero
        int numberOfTweetsOnProfilePage = profilePage.getCurrentNumberOfTweets();
        assertTrue(numberOfTweetsOnProfilePage > 0);


    }
}
