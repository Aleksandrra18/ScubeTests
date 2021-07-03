package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class PositiveLoginTest extends BaseTest{


    @Test(description = "User log in with valid credentials")
    public void loginWithValidCredentialsTest(){
        HomePage homePage = new HomePage();
        homePage.skipWelcomeMenu()
                .goToProfile()
                .clickOnLogInButton()
                .enterLoginAndPassword("olatest@wp.pl", "Test1234")
                .clickGreenLoginButton()
                .verifyingIfAvailabilityButtonIsDisplayed();
    }


    @Test(description = "User log in with Google account")
    public void loginWithGoogleAccount(){
        HomePage homePage = new HomePage();
        homePage.skipWelcomeMenu()
                .goToProfile()
                .clickOnLogInButton()
                .loginWithGoogleAccount()
                .verifyingIfAvailabilityButtonIsDisplayed();
    }
}
