package pages;

import androidkeys.AndroidKeysAction;
import driverManager.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterFormPage extends BasePage {

    @FindBy(xpath = "//*[@text = 'Imię*']")
    MobileElement userName;

    @AndroidFindBy(xpath = "//*[@text = 'Nazwisko*']")
    MobileElement userSurname;

    @AndroidFindBy(xpath = "//*[@text = 'Data urodzenia']")
    MobileElement birthdate;

    @AndroidFindBy(xpath = "//*[@text = 'Adres e-mail*']")
    MobileElement email;

    @AndroidFindBy(xpath = "//*[@text = 'Hasło*']")
    MobileElement password;

    @AndroidFindBy(xpath = "//*[@text = 'Powtórz hasło*']")
    MobileElement repeatedPassword;

    @Step("Entering user data in register form")
    public RegisterFormPage enterUserName(){
        Actions actions = new Actions(DriverManager.getWebDriver());
        userName.click();
        actions.sendKeys("user1").perform();
        userSurname.click();
        actions.sendKeys("user1").perform();
        AndroidKeysAction.pressOKKey();
        email.click();
        actions.sendKeys("user@mail.com").perform();
        return this;
    }


}
