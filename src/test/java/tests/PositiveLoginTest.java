package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class PositiveLoginTest extends BaseTest{

    @Test
    public void loginWithValidCredentialsTest(){
        HomePage homePage = new HomePage();
        homePage.skipWelcomeMenu()
                .goToProfile()
                .clickOnLogInButton()
                .enterLoginAndPassword("olatest@wp.pl", "Test1234")
                .clickGreenLoginButton()
                .verifyingIfAvailabilityButtonIsDisplayed();
    }

    @Test
    public void loginWithGoogleAccount(){
        HomePage homePage = new HomePage();
        homePage.skipWelcomeMenu()
                .goToProfile()
                .clickOnLogInButton()
                .loginWithGoogleAccount()
                .verifyingIfAvailabilityButtonIsDisplayed();
    }
}
