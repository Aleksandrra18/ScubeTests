package pages;

import androidkeys.AndroidKeysAction;
import assrtions.AssertWebElement;
import driverManager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.List;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//*[@content-desc='Zaloguj przez Google']")
    private MobileElement loginWithGoogle;

    @AndroidFindBy(id = "com.google.android.gms:id/container")
    private MobileElement googleAccount;

    @FindBy(xpath = "//*[@content-desc='Zaloguj przez Facebook']")
    private MobileElement loginWithFB;

    @FindBy(xpath = "//android.widget.EditText[@text='Adres e-mail']")
    private MobileElement emailInput;

    @FindBy(xpath = "//android.widget.EditText[@text='Hasło']")
    private MobileElement passwordInput;

    @FindBy(xpath = "//*[@content-desc='Coś poszło nie tak :/']")
    MobileElement sthWentWrongMsg;

    @FindBy(xpath = "//android.widget.Button")
    private List<MobileElement> clickButtons;

    @FindBy(xpath = "//*[@content-desc = 'Register here' or @content-desc ='Zarejestruj się']")
    private MobileElement registerHereButton;

    public LogInPage enterLoginAndPassword(String login, String password){
        WaitForElement.waitUntilElementIsVisible(emailInput);
        Actions actions = new Actions(DriverManager.getWebDriver());
        emailInput.click();
        actions.sendKeys(emailInput, login).perform();
        passwordInput.click();
        actions.sendKeys(passwordInput, password).perform();
        AndroidKeysAction.pressOKKey();
        return this;
    }

    public HomePage loginWithGoogleAccount(){
        WaitForElement.waitUntilElementIsVisible(loginWithGoogle);
        loginWithGoogle.click();
        WaitForElement.waitUntilElementIsClickable(googleAccount);
        googleAccount.click();
        return new HomePage();
    }

    public HomePage clickGreenLoginButton(){
        MobileElement loginButton = clickButtons.get(2);
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();
        return new HomePage();
    }

    public LogInPage getMsgAfterFailedLogin(){
        WaitForElement.waitUntilElementIsVisible(clickButtons.get(0));
        AssertWebElement.assertThat(clickButtons.get(0)).elementIsNotDisplayed();
        return this;
    }

    public RegisterFormPage clickRegisterHereButton(){
        WaitForElement.waitUntilElementIsClickable(registerHereButton);
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.doubleClick(clickButtons.get(1)).perform();
        registerHereButton.click();
        return new RegisterFormPage();
    }


}
