package pages;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class Profile extends BasePage{

    public Profile(){
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc='Zaloguj się']")
    private MobileElement loginButton;

    @Step("Clicking on login in button on profile page")
    public LogInPage clickOnLogInButton(){
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        return new LogInPage();
    }
}
