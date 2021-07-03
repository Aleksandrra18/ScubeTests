package configuration;

import java.util.Properties;

public class ConfigurationProperties {

    private static Properties properties;

    public static void setProperties(Properties properties) {
        if (properties != null) {
            ConfigurationProperties.properties = properties;
        }
    }

    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Please set properties using setProperties() before calling getProperties()");
        } else {
            return properties;
        }
    }
}
