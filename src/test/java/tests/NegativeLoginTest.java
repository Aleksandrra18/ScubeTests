package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class NegativeLoginTest extends BaseTest{

    @Test
    public void loginWithInvalidCredentials() {
        HomePage homePage = new HomePage();
        homePage.skipWelcomeMenu()
                .goToProfile()
                .clickOnLogInButton()
                .enterLoginAndPassword("olatest@wp.pl", " 11111111")
                .clickGreenLoginButton();
        LogInPage logInPage = new LogInPage();
        logInPage.getMsgAfterFailedLogin();
    }
}
