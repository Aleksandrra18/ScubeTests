package androidkeys;

import driverManager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class AndroidKeysAction {

    private static AndroidDriver getAndroidWebDriver() {
        return (AndroidDriver) DriverManager.getWebDriver();
    }

    public static void pressBackKey() {
        getAndroidWebDriver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void pressOKKey() {
        getAndroidWebDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public static void scrollToText(String text) {
        AndroidDriver<MobileElement> driver = getAndroidWebDriver();
        MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true).instance(1)).scrollIntoView("
                + "new UiSelector().description(\"" + text + "\"));");
    }

    public static void scrollForward() {
        AndroidDriver<MobileElement> driver = getAndroidWebDriver();
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(3)"));
    }

    public static void scrollBackward() {
        AndroidDriver<MobileElement> driver = getAndroidWebDriver();
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(4)"));
    }
}
