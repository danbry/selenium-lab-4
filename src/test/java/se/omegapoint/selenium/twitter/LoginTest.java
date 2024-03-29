package se.omegapoint.selenium.twitter;

import org.junit.jupiter.api.Test;
import se.omegapoint.selenium.twitter.page.LoginPage;
import se.omegapoint.selenium.twitter.page.MainPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Simple login tests to test the login page.
 */

public class LoginTest extends BaseTest {

    /**
    * Performs a correct login
    */
    @Test
    public void correctLogin() {

        try {
            //Go to login page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.goToPage();

            //Perform login
            loginPage.doLoginWithConfiguredUsernameAndPassword();

            //Verify that we are on the main page
            MainPage mainPage = new MainPage(driver);
            assertTrue(mainPage.isOnMainPage(), "Not on main page " + driver.getCurrentUrl());
        } catch (Exception e) {
            takeFullScreenShot("correct_login_error.png");
            throw e;
        }
    }


    /**
     * Performs an incorrect login
     */
    @Test
    public void incorrectLogin() {

        //Go to login page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToPage();

        //Perform incorrect login
        loginPage.doLogin("InvalidUsername", "bogus", false);

        //Checks that the login was incorrect -> not on main page
        MainPage mainPage = new MainPage(driver);
        assertFalse(mainPage.isOnMainPage(), "Should not be logged in");
    }
}
