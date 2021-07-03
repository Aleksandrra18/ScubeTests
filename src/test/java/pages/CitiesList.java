package pages;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class CitiesList extends BasePage{

    @FindBy(xpath = "//*[@content-desc='Wrocław']")
    private MobileElement city;

    @Step("Clicking on Wrocław city")
    public CubeCalendar clickOnCity(){
        WaitForElement.waitUntilElementIsClickable(city);
        city.click();
        return new CubeCalendar();
    }
}
