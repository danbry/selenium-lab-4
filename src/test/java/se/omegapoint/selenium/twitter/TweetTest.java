package se.omegapoint.selenium.twitter;

import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;
import se.omegapoint.selenium.infra.Config;
import se.omegapoint.selenium.twitter.page.LoginPage;
import se.omegapoint.selenium.twitter.page.MainPage;
import se.omegapoint.selenium.twitter.page.ProfilePage;
import se.omegapoint.selenium.twitter.page.TweetModal;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class TweetTest extends BaseTest {

  /**
   * Tests to create tweets
   */
  @Test
  public void correctTweet() throws Exception {

      if (!Config.getBooleanValue(Config.Value.TWITTER_TEST_ACCOUNT)) {
          fail("Since this is an updating test it will only run with a test Twitter account");
      }

      //Go to login page
      LoginPage loginPage = new LoginPage(driver);
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
      assertTrue(profilePage.isOnPage(), "Not on profile page");

      //Get number of tweets before new tweet
      int numberOfTweetsBeforeNewTweet = profilePage.getCurrentNumberOfTweets();

      //Open the tweet modal
      TweetModal tweetModal = new TweetModal(driver);
      tweetModal.openModal();
      assertTrue(tweetModal.isOnTweetModal(), "Expect to have tweet modal");

      //Enter tweet text and click button
      tweetModal.enterTweet("Tweet created by Selenium test on " + new Date());
      tweetModal.clickTweetButton();

      //Go back to profile page to get number of tweets
      mainPage.clickProfileButton();

      //Get number of tweets after new tweet
      int numberOfTweetsAfterNewTweet = profilePage.getCurrentNumberOfTweets();

      //Check that the number of tweets increased
      assertTrue(numberOfTweetsBeforeNewTweet + 1 == numberOfTweetsAfterNewTweet,
              "The number of tweets should have been increased");
  }

  /**
   * Test that it's not possible to create a tweet with too many characters
   */
  @Test
  public void tweetWithTooManyCharacters() {

      //Go to login page
      LoginPage loginPage = new LoginPage(driver);
      loginPage.goToPage();

      //Perform login
      loginPage.doLoginWithConfiguredUsernameAndPassword();

      //Verify that we are on the main page
      MainPage mainPage = new MainPage(driver);
      assertTrue(mainPage.isOnMainPage(), "Not on main page");

      //Check that the tweet modal is open
      TweetModal tweetModal = new TweetModal(driver);
      tweetModal.openModal();
      assertTrue(tweetModal.isOnTweetModal(), "Expect to have tweet modal");

      //Enter tweet text with too many characters and click button
      tweetModal.enterTweet(Strings.repeat("a", 300));
      assertFalse(tweetModal.isTweetButtonEnabled(), "The tweet button should not be enabled");
  }
}
