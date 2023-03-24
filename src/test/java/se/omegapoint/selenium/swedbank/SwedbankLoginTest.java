package se.omegapoint.selenium.swedbank;

import org.junit.jupiter.api.Test;
import se.omegapoint.selenium.swedbank.page.SwedbankLoginPage;
import se.omegapoint.selenium.swedbank.page.SwedbankStartPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Simple login tests to test the login page.
 */

public class SwedbankLoginTest extends SwedbankBaseTest {

    /**
    * Performs a correct login
    */
    @Test
    public void correctLogin() {

        try {
            //Go to login page
            SwedbankLoginPage loginPage = new SwedbankLoginPage(driver);
            loginPage.goToPage();
            loginPage.acceptAllCookies();

            //Do login
            assertTrue(loginPage.isLoginButtonDisplayed());
            loginPage.login();

            //Select the private profile
            loginPage.selectPrivateProfile();

            //After login the user should end up on the start page
            SwedbankStartPage startPage = new SwedbankStartPage(driver);
            assertTrue(startPage.isOnPage());
        } catch (Exception e) {
            takeFullScreenShot("swedbank_correct_login_error.png");
            fail("Login test failed [" + e.toString() + "]");
        }
    }
}
