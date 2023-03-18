package se.omegapoint.selenium.swedbank;

import org.junit.jupiter.api.Test;
import se.omegapoint.selenium.swedbank.page.SwedbankAccountPage;
import se.omegapoint.selenium.swedbank.page.SwedbankLoginPage;
import se.omegapoint.selenium.swedbank.page.SwedbankStartPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwedbankAccountTest extends SwedbankBaseTest {

    @Test
    public void accountInfo() {
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

            //Go to account page
            startPage.goToAccountPage();

            SwedbankAccountPage accountPage = new SwedbankAccountPage(driver);
            assertTrue(accountPage.isOnPage());


        } catch (Exception e) {
            takeFullScreenShot("swedbank_account_info_error.png");
        }
    }
}
