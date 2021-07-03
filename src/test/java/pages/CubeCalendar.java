package pages;

import androidkeys.AndroidKeysAction;
import driverManager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CubeCalendar extends BasePage {

    @FindBy(xpath = "//android.view.View[@content-desc='Zameldowanie']")
    private WebElement zameldowanie;

    @FindBy(xpath = "//android.view.View[@index='0']")
    private WebElement checkDate;

    @FindBy(xpath = "//android.view.View[@index='7']")
    private List<WebElement> buttonsIndex7;

    @FindBy(xpath = "//android.view.View[@index='8']")
    private List<WebElement> buttonsIndex8;

    @FindBy(className = "android.widget.Button")
    private MobileElement readyButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Sprawdź dostępność']")
    private WebElement checkAvailability;

    @Step("Picking random booking date in calendar")
    public CubeCalendar pickBookingDate() {
        String monthToScroll = getMonthToScroll();
        AndroidKeysAction.scrollToText(monthToScroll);
        WaitForElement.waitUntilElementIsClickable(zameldowanie);
        zameldowanie.click();
        int[] hours = pickRandomBookingDays();
        String checkInDate = String.valueOf(hours[0] - 1);
        String checkOutDate = String.valueOf(hours[1] - 1);
        checkDate.findElement(By.xpath("//*[@index='" + checkInDate + "']")).click();
        checkDate.findElement(By.xpath("//*[@index='" + checkOutDate + "']")).click();
        return this;
    }

    @Step("Picking random booking hour in calendar page")
    public CubeCalendar pickBookingHours(){
        WaitForElement.waitUntilElementIsClickable(buttonsIndex7.get(1));
        buttonsIndex7.get(1).click();
        AndroidKeysAction.scrollForward();
        readyButton.click();
        buttonsIndex8.get(1).click();
        AndroidKeysAction.scrollBackward();
        readyButton.click();
        checkAvailability.click();
        return this;
    }

    private String getMonthToScroll() {
        Locale polishLocale = new Locale("pl", "PL");
        LocalDate date = LocalDate.now();
        return date.plusMonths(1).getMonth().getDisplayName(TextStyle.FULL_STANDALONE, polishLocale) + " " + date.getYear();
    }

    private int[] pickRandomBookingDays() {
        Random random = new Random();
        int firstDay = random.nextInt(20);
        int secondDay = firstDay + 2;
        int[] hours = new int[]{firstDay, secondDay};
        return hours;
    }
}
