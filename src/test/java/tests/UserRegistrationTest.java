package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class UserRegistrationTest extends BaseTest {

    @Test(description = "User register with success")
    public void userRegisterWithSuccess() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.skipWelcomeMenu()
                .goToProfile()
                .clickOnLogInButton()
                .clickRegisterHereButton()
                .enterUserName();
    }
}
