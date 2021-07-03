package driverManager;

import configuration.MobileProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import server.AppiumServer;

public class AppiumDriverFactory {

    private static final String UNKNOWN_PLATFORM_TYPE = "Unknown platform type. Please check your configuration";

    public AndroidDriver<MobileElement> getAndroidDriver(){
        if (MobileProperties.getPlatformName().equals("Android")) {
            return new AndroidDriver<>(AppiumServer.getServiceUrl(), SetCapabilities.setDesiredCapabilities());
        } else {
            throw new IllegalStateException(UNKNOWN_PLATFORM_TYPE);
        }
    }
}
