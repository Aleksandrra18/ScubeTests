package driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverManager {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getWebDriver(){
        if (driver == null) {
            driver = new AppiumDriverFactory().getAndroidDriver();
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.quit();
        driver = null;
    }
}
