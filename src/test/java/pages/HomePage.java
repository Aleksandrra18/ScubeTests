package pages;

import assrtions.AssertWebElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.Calendar;

public class HomePage extends BasePage {

    public HomePage(){
    }

    @FindBy(xpath = "//android.view.View[@content-desc = 'Sprawdź dostępność']")
    private MobileElement checkAvailabilityButton;

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement profileButton;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement reservationButton;

    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement searchButton;

    @AndroidFindBy(xpath = "//*[@content-desc='POMIŃ']")
    private MobileElement skipButton;

    @Step("Skipping welcome menu")
    public HomePage skipWelcomeMenu(){
        WaitForElement.waitUntilElementIsClickable(skipButton);
        log().info("Clicking on skip button");
        skipButton.click();
        return this;
    }

    @Step("Clicking Profile button")
    public Profile goToProfile(){
        WaitForElement.waitUntilElementIsClickable(profileButton);
        log().info("Clicking on profile button " + profileButton.getText());
        profileButton.click();
        return new Profile();
    }

    @Step("Clicking check availability button")
    public CitiesList clickOnCheckAvailabilityButton(){
        WaitForElement.waitUntilElementIsVisible(checkAvailabilityButton);
        checkAvailabilityButton.click();
        return new CitiesList();
    }

    @Step("Checking if user is logged")
    public HomePage verifyingIfAvailabilityButtonIsDisplayed(){
        WaitForElement.waitUntilElementIsVisible(checkAvailabilityButton);
        log().info("Checking if user is logged");
        AssertWebElement.assertThat(checkAvailabilityButton).elementIsNotDisplayed();
        return this;
    }
}
