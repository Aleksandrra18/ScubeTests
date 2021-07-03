package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class BookCubeTest extends BaseTest{

    @Test(description = "Selecting booking date and hour test")
    public void bookCube(){
        HomePage homePage = new HomePage();
        homePage.skipWelcomeMenu()
                .clickOnCheckAvailabilityButton()
                .clickOnCity()
                .pickBookingDate()
                .pickBookingHours();
    }
}
