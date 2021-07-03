package configuration;

public class MobileProperties {

    public static String getPlatformName(){
        return ConfigurationProperties.getProperties().getProperty("platform.name");
    }

    public static String getDeviceName(){
        return ConfigurationProperties.getProperties().getProperty("device.name");
    }
    public static String getPlatformVersion(){
        return ConfigurationProperties.getProperties().getProperty("platform.version");
    }

    public static String getUDID(){
        return ConfigurationProperties.getProperties().getProperty("udid");
    }

    public static String getAppPackage(){
        return ConfigurationProperties.getProperties().getProperty("app.package");
    }

    public static String getAppActivity(){
        return ConfigurationProperties.getProperties().getProperty("app.activity");
    }
}
