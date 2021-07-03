package driverManager;

import configuration.MobileProperties;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;

public class SetCapabilities {

    public static DesiredCapabilities setDesiredCapabilities() {
        File app = new File("src/main/java/app/app-release-test.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileProperties.getDeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileProperties.getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileProperties.getPlatformName());
        capabilities.setCapability(MobileCapabilityType.UDID, MobileProperties.getUDID());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, MobileProperties.getAppPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, MobileProperties.getAppActivity());
        capabilities.setCapability("unicodeKeyboard", false);
        capabilities.setCapability("resetKeyboard", false);
        capabilities.setCapability("noReset", false);
        return capabilities;
    }
}
